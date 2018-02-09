package com.myrep.rals.tehcnicianapps.model;

/**
 * Created by CICILAN on 09/02/2018.
 */

public class WoData {
    private WorkOrder workorder;
    private Customer customer;

    public WoData(WorkOrder workorder, Customer customer) {
        this.workorder = workorder;
        this.customer = customer;
    }

    public WorkOrder getWorkorder() {
        return workorder;
    }

    public void setWorkorder(WorkOrder workorder) {
        this.workorder = workorder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
