package com.myrep.rals.tehcnicianapps.model;

/**
 * Created by Pinjaman on 1/22/2018.
 */

public class PersonalInfo {
    private String user_id;
    private String first_name;
    private String last_name;
    private String company;

    private String installer_id;
    private String photo;
    private String mobile;
    private String phone;
    private String vendor_title;

    public PersonalInfo(String user_id, String first_name, String last_name, String company,  String installer_id, String photo, String mobile, String phone, String vendor_title) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.company = company;

        this.installer_id = installer_id;
        this.photo = photo;
        this.mobile = mobile;
        this.phone = phone;
        this.vendor_title = vendor_title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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



    public String getInstaller_id() {
        return installer_id;
    }

    public void setInstaller_id(String installer_id) {
        this.installer_id = installer_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVendor_title() {
        return vendor_title;
    }

    public void setVendor_title(String vendor_title) {
        this.vendor_title = vendor_title;
    }
}
