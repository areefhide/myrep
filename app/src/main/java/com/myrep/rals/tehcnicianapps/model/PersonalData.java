package com.myrep.rals.tehcnicianapps.model;

/**
 * Created by CICILAN on 07/02/2018.
 */

public class PersonalData {
    private String status;
    private String message;
    private PersonalInfo data;

    public PersonalData(String status, String message, PersonalInfo data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PersonalInfo getData() {
        return data;
    }

    public void setData(PersonalInfo data) {
        this.data = data;
    }
}
