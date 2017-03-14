package com.cs3680.justin.js_project5_networkdata;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by justi on 3/11/2017.
 */

public class Planet {
    private String mType;
    private String mName;
    private int mMoonCount;
    private double mDistanceFromSun;
    private double mDiameterKm;

    List<Satellite> satellites = new ArrayList<>();

    public String getType() {
        return mType;
    }

    public void setType(String mType) {
        this.mType = mType;
    }


    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getMoonCount() {
        return mMoonCount;
    }

    public void setMoonCount(int mMoonCount) {
        this.mMoonCount = mMoonCount;
    }

    public double getDistanceFromSun() {
        return mDistanceFromSun;
    }

    public void setDistanceFromSun(double mDistanceFromSun) {
        this.mDistanceFromSun = mDistanceFromSun;
    }

    public double getDiameterKm() {
        return mDiameterKm;
    }

    public void setDiameterKm(double mDiameterKm) {
        this.mDiameterKm = mDiameterKm;
    }


}
