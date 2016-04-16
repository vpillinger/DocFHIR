/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.app;

import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import java.util.ArrayList;

/**
 *
 * @author Derek
 */
public class FhirMapper 
{
    public boolean exists(String NPI)
    {
        return false; // check NPI against current resource NPI
    }
    
    public void createPractitioner(DocData data)
    {
        // Create new practitioner object and use all elements of array
        
    }
    
    public void addAttributes(DocData data)
    {
        // add all non-common elements of array to Practitioner object
    }
    
    public Practitioner getResource()
    {
        return null; //return the Practitioner Resrouce
    }
}
