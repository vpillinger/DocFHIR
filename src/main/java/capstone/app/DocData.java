/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.app;

/**
 *
 * @author Derek
 */
public class DocData 
{
    private String NPI = null;
    private String nppes_provider_last_org_name = null;
    private String nppes_provider_first_name = null;
    private String nppes_provider_mi = null;
    private String nppes_credentials = null;      
    private String nppes_provider_gender = null;
    private String nppes_entity_code = null;     
    private String nppes_provider_street1 = null;       
    private String nppes_provider_street2 = null;
    private String nppes_provider_city = null;       
    private String nppes_provider_zip = null;
    private String nppes_provider_state = null;
    private String nppes_provider_country = null;
    private String provider_type = null;
    private String medicare_participation_indicator = null;
    private String place_of_service = null;
    private String hcpcs_code = null;
    private String hcpcs_description = null;
    private String line_srvc_cnt = null;
    private String bene_unique_cnt = null;
    private String bene_day_srvc_cnt = null;
    private String average_Medicare_allowed_amt = null;
    private String stdev_Medicare_allowed_amt = null;
    private String average_submitted_chrg_amt = null;
    private String stdev_submitted_chrg_amt = null;
    private String average_Medicare_payment_amt = null;
    private String stdev_Medicare_payment_amt = null;
    
    public DocData set_NPI(String NPI)
    {
        this.NPI = NPI;
        return this;
    }
    
    public DocData set_nppes_provider_last_org_name(String data)
    {
        this.nppes_provider_last_org_name = data;
        return this;
    }
    
    public DocData set_nppes_provider_first_name(String data)
    {
        this.nppes_provider_first_name = data;
        return this;
    }
    
    public DocData set_nppes_provider_mi(String data)
    {
        this.nppes_provider_mi = data;
        return this;
    }
    
    public DocData set_nppes_credentials(String data)
    {
        this.nppes_credentials = data;
        return this;
    }
    
    public DocData set_nppes_provider_gender(String data)
    {
        this.nppes_provider_gender = data;
        return this;
    }
    
    public DocData set_nppes_entity_code(String data)
    {
        this.nppes_entity_code = data;
        return this;
    }
    
    public DocData set_nppes_provider_street1(String data)
    {
        this.nppes_provider_street1 = data;
        return this;
    }
    
    public DocData set_nppes_provider_street2(String data)
    {
        this.nppes_provider_street2 = data;
        return this;
    }
    
    public DocData set_nppes_provider_city(String data)
    {
        this.nppes_provider_city = data;
        return this;
    }
    
    public DocData set_nppes_provider_zip(String data)
    {
        this.nppes_provider_zip = data;
        return this;
    }
    
    public DocData set_nppes_provider_state(String data)
    {
        this.nppes_provider_state = data;
        return this;
    }
    
    public DocData set_nppes_provider_country(String data)
    {
        this.nppes_provider_country = data;
        return this;
    }
    
    public DocData set_provider_type(String data)
    {
        this.provider_type = data;
        return this;
    }
    
    public DocData set_medicare_participation_indicator(String data)
    {
        this.medicare_participation_indicator = data;
        return this;
    }
    
    public DocData set_place_of_service(String data)
    {
        this.place_of_service = data;
        return this;
    }
    
    public DocData set_hcpcs_code(String data)
    {
        this.hcpcs_code = data;
        return this;
    }
    
    public DocData set_hcpcs_description(String data)
    {
        this.hcpcs_description = data;
        return this;
    }
    
    public DocData set_line_srvc_cnt(String data)
    {
        this.line_srvc_cnt = data;
        return this;
    }
    
    public DocData set_bene_unique_cnt(String data)
    {
        this.bene_unique_cnt = data;
        return this;
    }
    
    public DocData set_bene_day_srvc_cnt(String data)
    {
        this.bene_day_srvc_cnt = data;
        return this;
    }
    
    public DocData set_average_Medicare_allowed_amt(String data)
    {
        this.average_Medicare_allowed_amt = data;
        return this;
    }
    
    public DocData set_stdev_Medicare_allowed_amt(String data)
    {
        this.stdev_Medicare_allowed_amt = data;
        return this;
    }
    
    public DocData set_average_submitted_chrg_amt(String data)
    {
        this.average_submitted_chrg_amt = data;
        return this;
    }
    
    public DocData set_stdev_submitted_chrg_amt(String data)
    {
        this.stdev_submitted_chrg_amt = data;
        return this;
    }
    
    public DocData set_average_Medicare_payment_amt(String data)
    {
        this.average_Medicare_payment_amt = data;
        return this;
    }
    
    public DocData set_stdev_Medicare_payment_amt(String data)
    {
        this.stdev_Medicare_payment_amt = data;
        return this;
    }
    
    
    
    
    public String get_NPI()
    {
        return NPI;
    }
    
    public String get_nppes_provider_last_org_name()
    {
        return nppes_provider_last_org_name;
    }
    
    public String get_nppes_provider_first_name()
    {
        return nppes_provider_first_name;
    }
    
    public String get_nppes_provider_mi()
    {
        return nppes_provider_mi;     
    }
    
    public String get_nppes_credentials()
    {
        return nppes_credentials;
    }
    
    public String get_nppes_provider_gende()
    {
        return nppes_provider_gender;
    }
    
    public String get_nppes_entity_code()
    {
        return nppes_entity_code;
    }
    
    public String get_nppes_provider_street1()
    {
        return nppes_provider_street1;
    }
    
    public String get_nppes_provider_street2()
    {
        return nppes_provider_street2;
    }
    
    public String get_nppes_provider_city()
    {
        return nppes_provider_city;
    }
    
    public String get_nppes_provider_zip()
    {
        return nppes_provider_zip;
    }
    
    public String get_nppes_provider_state()
    {
        return nppes_provider_state;
    }
    
    public String get_nppes_provider_country()
    {
        return nppes_provider_country;
    }
    
    public String get_provider_type()
    {
        return provider_type;
    }
    
    public String get_medicare_participation_indicator()
    {
        return medicare_participation_indicator;
    }
    
    public String get_place_of_service()
    {
        return place_of_service;
    }
    
    public String get_hcpcs_code()
    {
        return hcpcs_code;
    }
    
    public String get_hcpcs_description()
    {
        return hcpcs_description;
    }
    
    public String get_line_srvc_cnt()
    {
        return line_srvc_cnt;
    }
    
    public String get_bene_unique_cnt()
    {
        return bene_unique_cnt;
    }
    
    public String get_bene_day_srvc_cnt()
    {
        return bene_day_srvc_cnt;
    }
    
    public String set_average_Medicare_allowed_amt()
    {
        return average_Medicare_allowed_amt;
    }
    
    public String get_stdev_Medicare_allowed_amt()
    {
        return stdev_Medicare_allowed_amt;        
    }
    
    public String get_average_submitted_chrg_amt()
    {
        return average_submitted_chrg_amt;
    }
    
    public String get_stdev_submitted_chrg_amt(String data)
    {
        return stdev_submitted_chrg_amt;
    }
    
    public String get_average_Medicare_payment_amt()
    {
        return average_Medicare_payment_amt;
    }
    
    public String get_stdev_Medicare_payment_amt()
    {
        return stdev_Medicare_payment_amt;
    }
    
}
