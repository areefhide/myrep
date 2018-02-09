package com.myrep.rals.tehcnicianapps.model;

/**
 * Created by CICILAN on 09/02/2018.
 */

public class Customer {
    private String customer_id;
    private String myrep_cid;
    private String first_name;
    private String last_name;
    private String address;
    private String cust_phone;
    private String cust_mobile;
    private String cust_email;

    public Customer(String customer_id, String myrep_cid, String first_name, String last_name, String address, String cust_phone, String cust_mobile, String cust_email) {
        this.customer_id = customer_id;
        this.myrep_cid = myrep_cid;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.cust_phone = cust_phone;
        this.cust_mobile = cust_mobile;
        this.cust_email = cust_email;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getMyrep_cid() {
        return myrep_cid;
    }

    public void setMyrep_cid(String myrep_cid) {
        this.myrep_cid = myrep_cid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getCust_mobile() {
        return cust_mobile;
    }

    public void setCust_mobile(String cust_mobile) {
        this.cust_mobile = cust_mobile;
    }

    public String getCust_email() {
        return cust_email;
    }

    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }
}
