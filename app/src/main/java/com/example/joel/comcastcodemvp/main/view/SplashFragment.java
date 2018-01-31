package com.example.joel.comcastcodemvp.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.joel.comcastcodemvp.R;


public class SplashFragment extends Fragment {

    private ImageView imageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        imageView = view.findViewById(R.id.splashImage);
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
        animation.setDuration(4000);
        imageView.startAnimation(animation);
        return view;
    }
}