/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.app;

import java.util.ArrayList;

/**
 *
 * @author khristianmorel
 */
public class DocReader
{

    private ArrayList<String> tokens = new ArrayList<String>();

    /*
    Takes in one line of the file and then parses it and loads it into the DocData object. Then returns the docData object for the Mapper to use later.
     */
    
    ArrayList<String> getFields()
    {
        return tokens;
    }
    
    public DocData processLine(String line)
    {
        tokens = new ArrayList <String>(); // re-initialize tokens to be empty, otherwise it keeps filling and we won't get the right data
        String[] tokes = line.split("\t"); // split our line into a string array
        for (int i = 0; i < tokes.length; i++)
        {
            tokens.add(tokes[i]); // we know the dr will ALWAYS have an NPI so we can get away with adding an element to the array first
            if(tokes[i].endsWith(" ")) // know next index has no data
            {
                i++; // skip to next index
                tokens.add("No Data"); // put no data so it isn't a null in there
            }
        }
        
        DocData data = new DocData(); //create the bean! 
        return data.set_NPI(tokens.get(0)).set_nppes_provider_last_org_name(tokens.get(1)).set_nppes_provider_first_name(tokens.get(2)).set_nppes_provider_mi(tokens.get(3))
                .set_nppes_credentials(tokens.get(4)).set_nppes_provider_gender(tokens.get(5)).set_nppes_entity_code(tokens.get(6)).set_nppes_provider_street1(tokens.get(7))
                .set_nppes_provider_street2(tokens.get(8)).set_nppes_provider_city(tokens.get(9)).set_nppes_provider_zip(tokens.get(10)).set_nppes_provider_state(tokens.get(11))
                .set_nppes_provider_country(tokens.get(12)).set_provider_type(tokens.get(13)).set_medicare_participation_indicator(tokens.get(14)).set_place_of_service(tokens.get(15))
                .set_hcpcs_code(tokens.get(16)).set_hcpcs_description(tokens.get(17)).set_line_srvc_cnt(tokens.get(18)).set_bene_unique_cnt(tokens.get(19)).set_bene_day_srvc_cnt(tokens.get(20))
                .set_average_Medicare_allowed_amt(tokens.get(21)).set_stdev_Medicare_allowed_amt(tokens.get(22)).set_average_submitted_chrg_amt(tokens.get(23)).set_stdev_submitted_chrg_amt(tokens.get(24))
                .set_average_Medicare_payment_amt(tokens.get(25)).set_stdev_Medicare_payment_amt(tokens.get(26)); //use bean power to fill the whole object and return it in all of
                // its wonderful glory.
    }
}
