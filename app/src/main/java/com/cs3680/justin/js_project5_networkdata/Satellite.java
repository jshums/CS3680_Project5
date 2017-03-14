package com.cs3680.justin.js_project5_networkdata;

/**
 * Created by justi on 3/11/2017.
 */

public class Satellite {
    private String mName;
    private double mDiameterKm;

    public Satellite () {

    }


    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public double getDiameterKm() {
        return mDiameterKm;
    }

    public void setDiameterKm(double mDiameterKm) {
        this.mDiameterKm = mDiameterKm;
    }
}
