package com.example.project1;

import android.os.Parcel;
import android.os.Parcelable;

public class rvModel implements Parcelable {
    private String rName, rNumber, rDate, rTime, RGuestCount, RRoom;

    public rvModel () {

    }

    public rvModel(String rName, String rNumber, String rDate, String rTime, String RGuestCount, String RRoom) {
        this.rName = rName;
        this.rNumber = rNumber;
        this.rDate = rDate;
        this.rTime = rTime;
        this.RGuestCount = RGuestCount;
        this.RRoom = RRoom;
    }

    protected rvModel(Parcel in) {
        rName = in.readString();
        rNumber = in.readString();
        rDate = in.readString();
        rTime = in.readString();
        RGuestCount = in.readString();
        RRoom = in.readString();
    }

    public static final Creator<rvModel> CREATOR = new Creator<rvModel>() {
        @Override
        public rvModel createFromParcel(Parcel in) {
            return new rvModel(in);
        }

        @Override
        public rvModel[] newArray(int size) {
            return new rvModel[size];
        }
    };

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrNumber() {
        return rNumber;
    }

    public void setrNumber(String rNumber) {
        this.rNumber = rNumber;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public String getrTime() {
        return rTime;
    }

    public void setrTime(String rTime) {
        this.rTime = rTime;
    }

    public String getRGuestCount() {
        return RGuestCount;
    }

    public void setRGuestCount(String RGuestCount) {
        this.RGuestCount = RGuestCount;
    }

    public String getRRoom() {
        return RRoom;
    }

    public void setRRoom(String RRoom) {
        this.RRoom = RRoom;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(rName);
        parcel.writeString(rNumber);
        parcel.writeString(rDate);
        parcel.writeString(rTime);
        parcel.writeString(RGuestCount);
        parcel.writeString(RRoom);
    }
}
