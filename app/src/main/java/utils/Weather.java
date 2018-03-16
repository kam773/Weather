package utils;

/**
 * Created by Kamil on 2018-03-16.
 */

public class Weather {

    private String mMinTemp;
    private String mMaxTemp;
    private String mHumidity;
    private String mWind;
    private String mDate;
    private String mDescription;
    private String mConditions;


    public Weather(String mMinTemp, String mMaxTemp, String mHumidity, String mWind, String mDate, String mDescription, String mConditions) {
        this.mMinTemp = mMinTemp;
        this.mMaxTemp = mMaxTemp;
        this.mHumidity = mHumidity;
        this.mWind = mWind;
        this.mDate = mDate;
        this.mDescription = mDescription;
        this.mConditions = mConditions;
    }

    public String getmMinTemp() {
        return mMinTemp;
    }

    public String getmMaxTemp() {
        return mMaxTemp;
    }

    public String getmHumidity() {
        return mHumidity;
    }

    public String getmWind() {
        return mWind;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmConditions() {
        return mConditions;
    }
}
