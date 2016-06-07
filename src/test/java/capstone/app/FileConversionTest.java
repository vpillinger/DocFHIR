package capstone.app;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;

public class RunTestCases {
	
	/**
     * Convert all files given in the testing folder. Then compare those files to the expected if one exists.
     */
    @Test
    public void runTestFiles()
    {
    	// loop through all files in test inputs
    	File test_dir = new File("\\test\\test inputs");
    	for (File test_file : test_dir.listFiles()){
    		
    		boolean file_converted = convertTestFile(test_file);
    		
    		if(file_converted){
    			assertTrue(checkFileResult(test_file));
    		}else{
    			fail("File not successfully converted");
    		}
    	}
    	
    }

	private boolean convertTestFile(File test_file){
    	String in_path = test_file.getAbsolutePath();
    	String out_path = in_path + "-output.xml";
    	
    	return DocFhir.convertDocGraphData(in_path, out_path);
    		
    }
    	
        
    private boolean checkFileResult(File test_file) {
		// TODO Auto-generated method stub
		return true;
	}	
    
}
