package com.example.android.quakereport;

import android.provider.ContactsContract;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Earthquake {

    private double mMagnitud;
    private String mLocation;
    private long mTimestamp;
    private String mDate;
    private  String mOffset;
    private  String mPrimaryLocation;
    private String mTime;

    public Earthquake(double mMagnitud, String mLocation, long mTimestamp) {
        this.mMagnitud = mMagnitud;
        this.mLocation = mLocation;
        this.mTimestamp = mTimestamp;

        this.splitLocation(this.mLocation);
    }

    public double getmMagnitud() {
        return mMagnitud;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmDate() {

        Date date = new Date(this.getmTimestamp());
        SimpleDateFormat format = new SimpleDateFormat("LLL dd, yyyy");
        this.setmDate(format.format(date));

        return mDate;
    }

    public long getmTimestamp() {
        return mTimestamp;
    }

    public void setmMagnitud(double mMagnitud) {
        this.mMagnitud = mMagnitud;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public void setmTimestamp(long mTimestamp) {
        this.mTimestamp = mTimestamp;
    }

    public void setmOffset(String mOffset) {
        this.mOffset = mOffset;
    }

    public void setmPrimaryLocation(String mPrimaryLocation) {
        this.mPrimaryLocation = mPrimaryLocation;
    }

    public String getmOffset() {
        return mOffset;
    }

    public String getmPrimaryLocation() {
        return mPrimaryLocation;
    }

    public String getmTime() {
        SimpleDateFormat format = new SimpleDateFormat("h:mm a");
        Date date = new Date(this.getmTimestamp());

        this.setmTime(format.format(date));

        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public void splitLocation(String mLocation){

        int index = mLocation.indexOf("of");

        if (index < 0){

            this.setmOffset("Near the");
            this.setmPrimaryLocation(this.mLocation);

            return;
        }

        String tempOffset = mLocation.substring(0,index + 2);
        String tempPrimary = mLocation.substring(index + 3);

        this.setmOffset(tempOffset);
        this.setmPrimaryLocation(tempPrimary);

    }

}



