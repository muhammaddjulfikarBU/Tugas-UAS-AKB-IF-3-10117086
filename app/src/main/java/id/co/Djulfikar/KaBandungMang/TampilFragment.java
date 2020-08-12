package id.co.Djulfikar.KaBandungMang;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * * Created by 12 Agustus 2020 - 10117086 - RD Muhammad Djulfikar BU - IF3
 */

@SuppressLint("ValidFragment")
public class TampilFragment extends Fragment {

    int layout;

    public TampilFragment(int layout){
        this.layout = layout;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(layout, container, false);
    }
}
