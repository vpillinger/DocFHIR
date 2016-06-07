package capstone.app;

import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.*;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class FileConversionTest extends XMLTestCase{
	
	@Before
    public void Setup()
    {
		//ignore whitespace in XML
    	XMLUnit.setIgnoreWhitespace(true);
    }
	
	/**
     * Convert all files given in the testing folder. Then compare those files to the expected if one exists.
     */
    @Test
    public void testFileConversion()
    {
    	
    	// loop through all files in test inputs
    	File test_dir = new File("src\\test\\test inputs\\");
    	
    	for (File test_file : test_dir.listFiles()){
    		System.out.println(test_file.getAbsolutePath());
    		boolean file_converted = convertTestFile(test_file);
    		//if we converted the file, and 
    		if(file_converted ){
    			try {
    				// if a correct results file exists to compare
    				if(new File("\\test\\test expected outputs\\" + test_file.getName()).exists()) {
						assertXMLEqual("\\test\\test outputs\\" + test_file.getName(),
								"\\test\\test expected outputs\\" + test_file.getName());
    				}
    				System.out.println("Success");
    			} catch (SAXException e) {
					e.printStackTrace();
					fail("Some failure on vserification");
				} catch (IOException e) {
					e.printStackTrace();
					fail("I/O failure on verification");
				}
    		}else{
    			fail("File not successfully converted");
    		}
    	}
    	
    }

	private boolean convertTestFile(File test_file){
    	String out_path = "\\test\\test outputs\\" + test_file.getName();
    	
    	return DocFhir.convertDocGraphData(test_file.getAbsolutePath(), out_path);
    		
    }
    
}
