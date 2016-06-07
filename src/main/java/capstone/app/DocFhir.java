package capstone.app;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class DocFhir {
	
	public static boolean convertDocGraphData(String in_filepath){
		
		return convertDocGraphData(in_filepath, in_filepath + "-FHIR.xml");
		
	}

	public static boolean convertDocGraphData(String in_filepath, String out_filepath){
		DocReader reader = new DocReader();
        FhirMapper mapper = new FhirMapper();
        FhirPrinter printer = new FhirPrinter();
        DocData data = null;
        boolean passedFirstIteration = false;
        
        try
        {
            FileInputStream inputStream = new FileInputStream(in_filepath); //put filename here
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            
            String line;
            while ((line = bufferedReader.readLine()) != null) // going to go through each line of the file
            {
                data = reader.processLine(line); // put a line into a DocData Element
                if(passedFirstIteration == true && mapper.exists(data.get_NPI()) == false) //if we passed the first line and the NPI's don't match meaning we found a new doctor or first one
                {
                    printer.outputResource(mapper.getResource(), out_filepath); // before overriding, output the current resource to a file if there is one to print
                    
                    mapper.createPractitioner(data); // mapper will use all fields for the practitioner
                }
                else // the NPI's match so we keep adding observations to the practitioner resource
                {
                    mapper.addAttributes(data); //having mapper add just the necessary fields to the practitioner
                }
                
                passedFirstIteration = true; // we now know there will always exist a resource from now until the end.
            }
            bufferedReader.close();
            return true;
            
        } catch (FileNotFoundException e)
        {
            System.out.println("File Not Found! File Not Found Exception");
            return false;
        }
        catch (IOException e)
        {
            System.out.println("File Not Found! IO Exception");
            return false;
        }
	}
}
