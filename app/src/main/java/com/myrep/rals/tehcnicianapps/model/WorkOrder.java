package com.myrep.rals.tehcnicianapps.model;

/**
 * Created by CICILAN on 09/02/2018.
 */

public class WorkOrder {
    private String woid;
    private String myrep_woid;
    private String wo_date;
    private String installation_date;
    private String job_status;

    public WorkOrder(String woid, String myrep_woid, String wo_date, String installation_date, String job_status) {
        this.woid = woid;
        this.myrep_woid = myrep_woid;
        this.wo_date = wo_date;
        this.installation_date = installation_date;
        this.job_status = job_status;
    }

    public String getWoid() {
        return woid;
    }

    public void setWoid(String woid) {
        this.woid = woid;
    }

    public String getMyrep_woid() {
        return myrep_woid;
    }

    public void setMyrep_woid(String myrep_woid) {
        this.myrep_woid = myrep_woid;
    }

    public String getWo_date() {
        return wo_date;
    }

    public void setWo_date(String wo_date) {
        this.wo_date = wo_date;
    }

    public String getInstallation_date() {
        return installation_date;
    }

    public void setInstallation_date(String installation_date) {
        this.installation_date = installation_date;
    }

    public String getJob_status() {
        return job_status;
    }

    public void setJob_status(String job_status) {
        this.job_status = job_status;
    }
}
