package capstone.app;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    DocReader FW;

    @Before
    public void Setup()
    {
        FW = new DocReader();
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testApp()
    {
        assertTrue(true);
    }

    /**
     * Tests FHIRWriter when reading in data from medicare data to make sure it
     * gets 27 fields of data.
     *
     * @throws IOException
     */
    @Test
    public void testFHIRwriter27Items() throws IOException
    {

        FW.readIn("src/test/test files/TestFieldData.txt");

        assertEquals(27, FW.getFields().size());
    }

    /**
     * Test FHIRWriter when reading in data from ha1c data to make sure it gets
     * 16 fields of data. 
     * Uncomment test once parser has been updated to read in this data.
     *
     * @throws IOException
     */
//    @Test
//    public void testFHIRwriter16Items() throws IOException
//    {
//
//        FW.readIn("src/test/test files/TestFieldData.txt");
//
//        assertEquals(16,FW.getFields().size());
//    }
    /**
     * Test FHIRWriter when reading in data from medicare data to make
     * sure the data is read in the proper order.
     *
     * @throws IOException
     */
    @Test
    public void testFHIRWriterMedCorrectOrder() throws IOException
    {
        ArrayList<String> testData = new ArrayList<String>();
        testData.add("1234567890");
        testData.add("JOE");
        testData.add("BAGODONUTS");
        testData.add("");
        testData.add("M.D.");
        testData.add("M");
        testData.add("I");
        testData.add("123 CANDY DR");
        testData.add("");
        testData.add("NARNIA");
        testData.add("123456789");
        testData.add("PA");
        testData.add("US");
        testData.add("Funny Bone Specialist");
        testData.add("Y");
        testData.add("F");
        testData.add("123456");
        testData.add("COMEDIAN");
        testData.add("123");
        testData.add("123");
        testData.add("123");
        testData.add("123.45");
        testData.add("0");
        testData.add("123");
        testData.add("0");
        testData.add("123.45678901");
        testData.add("1.2345678901");

        FW.readIn("src/test/test files/TestFieldData.txt");

        for (int i = 0; i < FW.getFields().size(); i++)
        {
            assertEquals(testData.get(i), FW.getFields().get(i));
        }

    }
}
