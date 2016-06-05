package capstone.app;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Composition;
import ca.uhn.fhir.model.dstu2.resource.Composition.Section;
import ca.uhn.fhir.model.dstu2.valueset.NameUseEnum;
import ca.uhn.fhir.parser.IParser;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello HAPI!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
    	
    	DocFhir.convertDocGraphData("\\docgraph\\Medicare-Physician-and-Other-Supplier-PUF-CY2012-head.txt");

    }
    /**
     * This method is copied example code, replace this with main for debugging import issues
     */
    private static void example(){
    	// Alternately, create a context for DSTU2
 		FhirContext ctx = FhirContext.forDstu2();

 		// The following is an example Patient resource
 		String msgString = "<Patient xmlns=\"http://hl7.org/fhir\">"
 			+ "<text><status value=\"generated\" /><div xmlns=\"http://www.w3.org/1999/xhtml\">John Cardinal</div></text>"
 			+ "<identifier><system value=\"http://orionhealth.com/mrn\" /><value value=\"PRP1660\" /></identifier>"
 			+ "<name><use value=\"official\" /><family value=\"Cardinal\" /><given value=\"John\" /></name>"
 			+ "<gender><coding><system value=\"http://hl7.org/fhir/v3/AdministrativeGender\" /><code value=\"M\" /></coding></gender>"
 			+ "<address><use value=\"home\" /><line value=\"2222 Home Street\" /></address><active value=\"true\" />"
 			+ "</Patient>";

 		// The hapi context object is used to create a new XML parser
 		// instance. The parser can then be used to parse (or unmarshall) the
 		// string message into a Patient object
 		IParser parser = ctx.newXmlParser();
 		Patient patient = parser.parseResource(Patient.class, msgString);

 		// The patient object has accessor methods to retrieve all of the
 		// data which has been parsed into the instance.
 		String patientId = patient.getIdentifier().get(0).getValue();
 		String familyName = patient.getName().get(0).getFamily().get(0).getValue();
 		String gender = patient.getGender();

 		System.out.println(patientId); // PRP1660
 		System.out.println(familyName); // Cardinal
 		System.out.println(gender); // M
 		

 		/**
 		 * FHIR model types in HAPI are simple POJOs. To create a new
 		 * one, invoke the default constructor and then
 		 * start populating values.
 		 */
 		Patient patient2 = new Patient();
 		 
 		// Add an MRN (a patient identifier)
 		IdentifierDt id = patient2.addIdentifier();
 		id.setSystem("http://example.com/fictitious-mrns");
 		id.setValue("MRN001");
 		 
 		// Add a name
 		HumanNameDt name = patient2.addName();
 		name.setUse(NameUseEnum.OFFICIAL);
 		name.addFamily("Tester");
 		name.addGiven("John");
 		name.addGiven("Q");
                 
                 
                 Composition comp= new Composition();
                 
                 Section sect= new Section();
 		 
 		// We can now use a parser to encode this resource into a string.
 		String encoded = ctx.newXmlParser().encodeResourceToString(patient2);
 		System.out.println(encoded);
    }
}
