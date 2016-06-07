/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.app;

import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Observation;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.model.dstu2.resource.Practitioner.PractitionerRole;
import ca.uhn.fhir.model.dstu2.resource.Practitioner.Qualification;
import ca.uhn.fhir.model.dstu2.valueset.AdministrativeGenderEnum;
import ca.uhn.fhir.model.dstu2.valueset.PractitionerRoleEnum;
import ca.uhn.fhir.model.primitive.StringDt;
import java.util.ArrayList;


public class FhirMapper 
{
    Practitioner practitioner;
    ArrayList<Observation> observations;
    ArrayList<ResourceReferenceDt> performers; //this will be for the observation performer ie it will have one element with the practitioner in it
    
    public boolean exists(String NPI)
    {
        if(NPI.equals(practitioner.getId()))
        {
            return true;
        }
        return false; // check NPI against current resource NPI
    }
    
    public void createPractitioner(DocData data)
    {
        ArrayList<AddressDt> addresses = new ArrayList<AddressDt>(); //addresses requires an array argument
        ArrayList<PractitionerRole> roles = new ArrayList<PractitionerRole>(); // practitioner role resouce requires an array of roles
        ArrayList<ResourceReferenceDt> descriptions = new ArrayList<ResourceReferenceDt>(); // practitioner healthcareServiceProvided also requires an array aof healthCareServices provided
        Qualification credential;
        
        
        practitioner = new Practitioner(); //create new practitioner
        practitioner.setId(data.get_NPI());
        practitioner.setName(new HumanNameDt().addGiven(data.get_nppes_provider_first_name() + " " + data.get_nppes_provider_mi()).addFamily(data.get_nppes_provider_last_org_name()));
        addresses.add(new AddressDt());
        addresses.get(0).addLine(data.get_nppes_provider_street1()).addLine(data.get_nppes_provider_street2()).setCity(data.get_nppes_provider_city()).setState(data.get_nppes_provider_state()).setPostalCode(data.get_nppes_provider_zip());
        roles.add(new PractitionerRole().setRole(PractitionerRoleEnum.DOCTOR)); //add a role to the roles array, DOCTOR is only enum that makes sense
        descriptions.add(new ResourceReferenceDt().setDisplay(data.get_hcpcs_description()).setReference(data.get_hcpcs_code())); // add the description as the display and set its id to the code value
        roles.get(0).setHealthcareService(descriptions); // load the healthcare services into the role
        practitioner.setPractitionerRole(roles);
        if(data.get_medicare_participation_indicator().equals("Y")) // they participate in medicare so we can set their field for active
        {
            practitioner.setActive(true);
        }
        else
        {
            practitioner.setActive(false); //otherwise they are inactive because we are ONLY dealing with medicare data here
        }
        
        credential = new Practitioner.Qualification().addIdentifier(new IdentifierDt("system", data.get_nppes_credentials())); // get rid of system, when we decide on namespace
        practitioner.addQualification(credential); // load credential as a qualification int practitioner
        
        if(data.get_nppes_provider_gende().equals("M")) // gender of male
        {
            practitioner.setGender(AdministrativeGenderEnum.MALE);
        }
        else if(data.get_nppes_provider_gende().equals("F")) // gender of Female
        {
            practitioner.setGender(AdministrativeGenderEnum.FEMALE);
        }
        else    // Anything other than M or F
        {
            practitioner.setGender(AdministrativeGenderEnum.UNKNOWN);
        }
        
        performers = new ArrayList<ResourceReferenceDt>(); // make the array list a new one to empty it for the new practitioner
        performers.add(new ResourceReferenceDt(practitioner)); // put the practitioner in as a performer
        
        observations = new ArrayList<Observation>(); // clear the observations array for the new practitioner
        
        Observation observation = new Observation();
        observation.setPerformer(performers);
        observation.setCode(new CodeableConceptDt("system", "average_Medicare_allowed_amt")); //according to HAPI documentation, this is where the name goes
        observation.setValue(new StringDt(data.get_average_Medicare_payment_amt()));
        
        observations.add(observation); // put it in our array so we dont have to use 1000 variable names floating everywhere
        
        observation = new Observation();
        observation.setPerformer(performers);
        observation.setCode(new CodeableConceptDt("system", "stdev_Medicare_allowed_amt"));
        observation.setValue(new StringDt(data.get_stdev_Medicare_allowed_amt()));
        
        observations.add(observation); //add to the observations array
        
        observation = new Observation();
        observation.setPerformer(performers);
        observation.setCode(new CodeableConceptDt("system","average_Medicare_payment_amt"));
        observation.setValue(new StringDt(data.get_average_Medicare_payment_amt()));
        
        observations.add(observation);
        
        observation = new Observation();
        observation.setPerformer(performers);
        observation.setCode(new CodeableConceptDt("syste", "stdev_Medicare_payment_amt"));
        observation.setValue(new StringDt(data.get_stdev_Medicare_payment_amt()));
        
        observations.add(observation);
        
        observation = new Observation();
        observation.setPerformer(performers);
        observation.setCode(new CodeableConceptDt("system", "average_submitted)chrg_amt"));
        observation.setValue(new StringDt(data.get_average_submitted_chrg_amt()));
        
        observations.add(observation);
        
        observation = new Observation();
        observation.setPerformer(performers);
        observation.setCode(new CodeableConceptDt("system", "stdev_submitted_chrg_amt"));
        observation.setValue(new StringDt(data.get_stdev_submitted_chrg_amt()));
        
        observations.add(observation);
        
        observation = new Observation();
        observation.setPerformer(performers);
        observation.setCode(new CodeableConceptDt("system", "bene_day_srvc_cnt"));
        observation.setValue(new StringDt(data.get_bene_day_srvc_cnt()));
        
        observations.add(observation);
        
        observation = new Observation();
        observation.setPerformer(performers);
        observation.setCode(new CodeableConceptDt("system", "bene_unique_cnt"));
        observation.setValue(new StringDt(data.get_bene_unique_cnt()));
        
        observations.add(observation);
              
        
    }
    
    public void addAttributes(DocData data)
    {
    	observations = new ArrayList<Observation>();
        Observation observation = new Observation();
        observation.setPerformer(performers);
        observation.setCode(new CodeableConceptDt("system", "average_Medicare_allowed_amt")); //according to HAPI documentation, this is where the name goes
        observation.setValue(new StringDt(data.get_average_Medicare_allowed_amt()));
        
        observations.add(observation); // put it in our array so we dont have to use 1000 variable names floating everywhere
        
        observation = new Observation();
        observation.setPerformer(performers);
        observation.setCode(new CodeableConceptDt("system", "stdev_Medicare_allowed_amt"));
        observation.setValue(new StringDt(data.get_stdev_Medicare_allowed_amt()));
        
        observations.add(observation); //add to the observations array
        
        observation = new Observation();
        observation.setPerformer(performers);
        observation.setCode(new CodeableConceptDt("system","average_Medicare_payment_amt"));
        observation.setValue(new StringDt(data.get_average_Medicare_payment_amt()));
        
        observations.add(observation);
        
        observation = new Observation();
        observation.setPerformer(performers);
        observation.setCode(new CodeableConceptDt("syste", "stdev_Medicare_payment_amt"));
        observation.setValue(new StringDt(data.get_stdev_Medicare_payment_amt()));
        
        observations.add(observation);
        
        observation = new Observation();
        observation.setPerformer(performers);
        observation.setCode(new CodeableConceptDt("system", "average_submitted)chrg_amt"));
        observation.setValue(new StringDt(data.get_average_submitted_chrg_amt()));
        
        observations.add(observation);
        
        observation = new Observation();
        observation.setPerformer(performers);
        observation.setCode(new CodeableConceptDt("system", "stdev_submitted_chrg_amt"));
        observation.setValue(new StringDt(data.get_stdev_submitted_chrg_amt()));
        
        observations.add(observation);
        
        observation = new Observation();
        observation.setPerformer(performers);
        observation.setCode(new CodeableConceptDt("system", "bene_day_srvc_cnt"));
        observation.setValue(new StringDt(data.get_bene_day_srvc_cnt()));
        
        observations.add(observation);
        
        observation = new Observation();
        observation.setPerformer(performers);
        observation.setCode(new CodeableConceptDt("system", "bene_unique_cnt"));
        observation.setValue(new StringDt(data.get_bene_unique_cnt()));
        
        observations.add(observation);
    }
    
    public Practitioner getResource()
    {
        return practitioner; //return the Practitioner Resrouce
    }
}
