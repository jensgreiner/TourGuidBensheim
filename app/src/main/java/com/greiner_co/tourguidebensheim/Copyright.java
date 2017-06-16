package com.greiner_co.tourguidebensheim;

/**
 * Created by Jens Greiner on 16.06.17.
 */

public class Copyright {

    private final String mCopyrightTitle;
    private final int mImageResourceId;

    public Copyright(String title, int imageResourceId) {
        mCopyrightTitle = title;
        mImageResourceId = imageResourceId;
    }

    public String getmCopyrightTitle() {
        return mCopyrightTitle;
    }

    public int getmCopyrightImage() {
        return mImageResourceId;
    }

    @Override
    public String toString() {
        return "Copyright{" +
                "mCopyrightTitle='" + mCopyrightTitle + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }
}
