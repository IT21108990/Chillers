package com.example.bookroom;
import android.os.Parcel;
import android.os.Parcelable;
public class BookingRVMModal implements Parcelable{

    private String bName;
    private String bNumber;
    

    public String getBName() {
        return bName;
    }

    public String getBNumber() {
        return bNumber;
    }

       private String bqAud;


    public void setBqName(String bName) {
        this.bName = bName;
    }

    public void setBNumber(String bNumber) {
        this.bNumber = bNumber;
    }

   
    public BookingRVMModal(String bName, String bNumber){
        this.bName=bName;
        this.bDate=bDate;

    }

    protected BookingRVMModal(Parcel in) {
        bName = in.readString();
        bDate = in.readString();
    }

    public static final Creator<bookroom> CREATOR = new Creator<bookroom>() {
        @Override
        public BookingRVMModal createFromParcel(Parcel in) {
            return new bookroom(in);
        }

        @Override
        public bookroom[] newArray(int size) {
            return new bookroom[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bName);
        parcel.writeString(bDate);
       
}