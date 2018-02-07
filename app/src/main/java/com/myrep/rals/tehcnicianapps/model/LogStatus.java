package com.myrep.rals.tehcnicianapps.model;

/**
 * Created by Pinjaman on 1/22/2018.
 */

public class LogStatus {
    private String status;
    private String message;
    private String Authorization;

    public LogStatus(String status, String message, String Authorization) {
        this.status = status;
        this.message = message;
        this.Authorization = Authorization;
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

    public String getAuthorization() {
        return Authorization;
    }

    public void setAuthorization(String authorization) {
        Authorization = authorization;
    }
}
