/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.app;


import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.model.dstu2.resource.Practitioner.PractitionerRole;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Derek
 */
public class HAPI_Playground 
{
    public static void main(String[] args)
    {
        Practitioner dr = new Practitioner();
        dr.setId("1234556789");
        dr.setName(new HumanNameDt().addGiven("John").addFamily("Doe"));
        ArrayList<AddressDt> addresses = new ArrayList();
        addresses.add(new AddressDt());
        addresses.get(0).addLine("1408 Hitchcock Lane").setCity("Bethlehem").setState("PA").setPostalCode("12345"); //addresses can only be set in form of list
        dr.setAddress(addresses);
        dr.addTelecom(new ContactPointDt().setValue("555-555-5555")); //Value i for phone number or email address, you can also adjust rank of importnace
        // I can't seem to figure out the import for the ENUM on administrative Gender...
        
        
        System.out.println(dr);
        System.out.println(dr.getName());
        System.out.println(dr.getAddress().get(0).getLine().get(0)); // line returns a list, which can be either the streent and house number or intersection directions etc.
        System.out.println(dr.getAddress().get(0).getCity()); // have to specify field you want from address 
        System.out.println(dr.getTelecom().get(0).getValue()); // Also have to specify element of the list and specific element you need
    }
    
}
