package com.myrep.rals.tehcnicianapps.model;

import java.util.List;

/**
 * Created by Pinjaman on 1/31/2018.
 */

public class WorkOrders {
    private String status;
    private String message;
    private List<WoData> data;


    public WorkOrders(String status, String message, List<WoData> data) {
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

    public List<WoData> getData() {
        return data;
    }

    public void setData(List<WoData> data) {
        this.data = data;
    }
}
