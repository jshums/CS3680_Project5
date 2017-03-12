package com.cs3680.justin.js_project5_networkdata;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by justi on 3/11/2017.
 */

public class Planet {
    private static List<Satellite> mSatellites;
    private String mType;
    private String mName;
    private int mMoonCount;
    private double mDistanceFromSun;
    private int mDiameterKm;

    public static List<Satellite> getSatellites() {
        return mSatellites;
    }

    public static void setSatellites(List<Satellite> mSatellites) {
        Planet.mSatellites = mSatellites;
    }


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

    public int getDiameterKm() {
        return mDiameterKm;
    }

    public void setDiameterKm(int mDiameterKm) {
        this.mDiameterKm = mDiameterKm;
    }
}
