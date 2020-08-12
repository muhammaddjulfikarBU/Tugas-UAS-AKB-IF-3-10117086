package id.co.Djulfikar.KaBandungMang;

/**
 * * Created by 12 Agustus 2020 - 10117086 - RD Muhammad Djulfikar BU - IF3
 */

public enum ModelObject {


    WISATA(R.string.wisata, R.layout.slider_wisata),
            ;

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}