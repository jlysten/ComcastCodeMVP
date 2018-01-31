package com.example.joel.comcastcodemvp.main.presenter;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import com.example.joel.comcastcodemvp.R;
import com.example.joel.comcastcodemvp.main.data.Implementor;
import com.example.joel.comcastcodemvp.main.data.ImplementorImpl;
import com.example.joel.comcastcodemvp.main.view.DataFragment;
import com.example.joel.comcastcodemvp.main.view.ListFragment;
import com.example.joel.comcastcodemvp.main.view.MainActivity;
import com.example.joel.comcastcodemvp.main.view.SplashFragment;
import com.example.joel.comcastcodemvp.main.view.ViewInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel on 1/25/2018.
 */

public class MainPresenter implements IMainPresenter,Implementor.onResponse {
    private ViewInterface viewInterface;
    private Implementor implementor;
    private Context c;
    private FragmentManager fragmentManager;
    private ListFragment listFragment = new ListFragment();
    private DataFragment dataFragment = new DataFragment();
    private SplashFragment splashFragment;
    List<String> title = new ArrayList<>();
    List<String> urls = new ArrayList<>();
    Toolbar topToolbar;
    String detailsTitle,detailsDescription,detailsUrl;

    public MainPresenter(ViewInterface viewInterface, ImplementorImpl implementor, Toolbar mTopToolbar, Context context) {
        this.viewInterface = viewInterface;
        this.implementor = implementor;
        this.c = context;
        this.topToolbar = mTopToolbar;
    }

    @Override
    public void onSuccess(List<String> list, List<String> urls) {
        viewInterface.navigatetoListFragment(list, urls);
    }

    @Override
    public void onFailure(String message) {
        viewInterface.showError("Network Call Failed");
    }

    @Override
    public void doNetworkCall() {
        implementor.callAPI(this);
    }

    @Override
    public void loadSplash() {
        splashFragment = new SplashFragment();
        ((MainActivity) c).setSupportActionBar(topToolbar);
        ((MainActivity) c).getSupportActionBar().hide();
        new Handler().post(new Runnable() {
            public void run() {
                if (!((MainActivity) c).isFinishing() && !((MainActivity) c).isDestroyed()) {
                    fragmentManager = ((MainActivity) c).getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainer, splashFragment)
                            .commit();
                }
            }
        });
    }

    @Override
    public void loadListFragment(List<String> list, List<String> url) {
        title = list;
        urls = url;
        Bundle args = new Bundle();
        args.putStringArrayList("urls", (ArrayList<String>) urls);
        args.putStringArrayList("title", (ArrayList<String>) title);
        listFragment.setArguments(args);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ((MainActivity) c).setSupportActionBar(topToolbar);
                ((MainActivity) c).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                ((MainActivity) c).getSupportActionBar().setDisplayShowHomeEnabled(true);
                ((MainActivity) c).getSupportActionBar().show();
                if (!((MainActivity) c).isFinishing() && !((MainActivity) c).isDestroyed()) {
                    fragmentManager = ((MainActivity) c).getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainer, listFragment, "list")
                            .commit();
                }
            }
        }, 4000);
    }

    @Override
    public void switchLayout() {
        listFragment = ((ListFragment) fragmentManager.findFragmentByTag("list"));
        boolean isSwitched = listFragment.getAdapter().toggleItemViewType();
        listFragment.recyclerView.setLayoutManager(isSwitched ? new LinearLayoutManager(c) : new GridLayoutManager(c, 2));
        listFragment.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void loadDetailFragment(String title, String description, String image) {
        detailsTitle = title;
        detailsDescription = description;
        detailsUrl = image;
        Bundle bundle = new Bundle();
        bundle.putString("title", detailsTitle);
        bundle.putString("description", detailsDescription);
        bundle.putString("image", detailsUrl);
        dataFragment.setArguments(bundle);
        if (!((MainActivity) c).isFinishing() && !((MainActivity) c).isDestroyed()) {
            fragmentManager = ((MainActivity) c).getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, dataFragment, "datafragment")
                    .addToBackStack("")
                    .commit();
        }
    }
}


