package com.myrep.rals.tehcnicianapps.model;

/**
 * Created by Rals-PC on 10/26/2016.
 */
public class recyleview {

    public int imageResourceId;
    public String userName;
    public String userMobile;
    public String userstatus;

    public recyleview()
    {}

    public recyleview(int imageResourceId, String userName, String userMobile, String userstatus) {
        this.imageResourceId = imageResourceId;
        this.userName = userName;
        this.userMobile = userMobile;
        this.userstatus = userstatus;
    }
}
