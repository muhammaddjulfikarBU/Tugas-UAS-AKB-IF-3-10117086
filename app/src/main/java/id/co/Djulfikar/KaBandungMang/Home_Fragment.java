package id.co.Djulfikar.KaBandungMang;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * * Created by 12 Agustus 2020 - 10117086 - RD Muhammad Djulfikar BU - IF3
 */


@SuppressLint("ValidFragment")
public class Home_Fragment extends Fragment {

    Context context;
    ViewPager viewPager;
    int i = 0;
    boolean running = true;

    public Home_Fragment(Context c) {
        context = c;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(context));

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            viewPager.setCurrentItem(i);
                        }
                    });
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                    if (i > 5) {
                        i = 0;
                    }
                }
            }
        }).start();
    }

    @Override
    public void onPause() {
        super.onPause();
        running = false;
    }
}
