package com.example.hallbooking;
import android.os.Parcel;
import android.os.Parcelable;
public class BookingRVMModal implements Parcelable{

    private String bqName;
    private String bqNumber;
    private String bqDate;
    private String bqTime;
    private String bqGuest;
    private String bqBev;

    public String getBqName() {
        return bqName;
    }

    public String getBqNumber() {
        return bqNumber;
    }

    public String getBqDate() {
        return bqDate;
    }

    public String getBqTime() {
        return bqTime;
    }

    public String getBqGuest() {
        return bqGuest;
    }

    public String getBqBev() {
        return bqBev;
    }

    public String getBqAud() {
        return bqAud;
    }

    private String bqAud;


    public void setBqName(String bqName) {
        this.bqName = bqName;
    }

    public void setBqNumber(String bqNumber) {
        this.bqNumber = bqNumber;
    }

    public void setBqDate(String bqDate) {
        this.bqDate = bqDate;
    }

    public void setBqTime(String bqTime) {
        this.bqTime = bqTime;
    }

    public void setBqGuest(String bqGuest) {
        this.bqGuest = bqGuest;
    }

    public void setBqBev(String bqBev) {
        this.bqBev = bqBev;
    }

    public void setBqAud(String bqAud) {
        this.bqAud = bqAud;
    }

    public BookingRVMModal(String bqName, String bqNumber, String bqDate, String bqTime, String bqGuest, String bqBev, String bqAud){
        this.bqName=bqName;
        this.bqDate=bqDate;
        this.bqGuest=bqGuest;
        this.bqNumber=bqNumber;
        this.bqTime=bqTime;
        this.bqBev=bqBev;
        this.bqAud=bqAud;

    }

    protected BookingRVMModal(Parcel in) {
        bqName = in.readString();
        bqDate = in.readString();
        bqGuest = in.readString();
        bqNumber = in.readString();
        bqTime= in.readString();
        bqBev= in.readString();
        bqAud= in.readString();
    }

    public static final Creator<BookingRVMModal> CREATOR = new Creator<BookingRVMModal>() {
        @Override
        public BookingRVMModal createFromParcel(Parcel in) {
            return new BookingRVMModal(in);
        }

        @Override
        public BookingRVMModal[] newArray(int size) {
            return new BookingRVMModal[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bqName);
        parcel.writeString(bqDate);
        parcel.writeString(bqGuest);
        parcel.writeString(bqNumber);
        parcel.writeString(bqTime);
        parcel.writeString(bqAud);
        parcel.writeString(bqBev);
    }
}
