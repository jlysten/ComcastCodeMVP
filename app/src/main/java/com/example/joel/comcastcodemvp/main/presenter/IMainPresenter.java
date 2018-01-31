package com.example.joel.comcastcodemvp.main.presenter;

import android.content.Context;

import com.example.joel.comcastcodemvp.main.view.MainActivity;

import java.util.List;

/**
 * Created by Joel on 1/25/2018.
 */

public interface IMainPresenter {
    void doNetworkCall();
    void loadSplash();

    void loadListFragment(List<String> list, List<String> urls);

    void switchLayout();

    void loadDetailFragment(String title, String description, String image);

}
