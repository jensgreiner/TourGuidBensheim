package com.greiner_co.tourguidebensheim;

/**
 * Created by Jens Greiner on 16.06.17.
 */

public class Copyright {

    private final String mCopyrightTitle;
    private final String mCopyrightDetails;

    public Copyright(String title, String detail) {
        mCopyrightTitle = title;
        mCopyrightDetails = detail;
    }

    public String getmCopyrightTitle() {
        return mCopyrightTitle;
    }

    public String getmCopyrightDetails() {
        return mCopyrightDetails;
    }

    @Override
    public String toString() {
        return "Copyright{" +
                "mCopyrightTitle='" + mCopyrightTitle + '\'' +
                ", mCopyrightDetails='" + mCopyrightDetails + '\'' +
                '}';
    }
}
