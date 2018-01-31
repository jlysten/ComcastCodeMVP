package com.example.joel.comcastcodemvp.main.view;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.joel.comcastcodemvp.R;
import com.example.joel.comcastcodemvp.main.adapters.MyRecyclerViewAdapter;
import com.example.joel.comcastcodemvp.main.data.ImplementorImpl;
import com.example.joel.comcastcodemvp.main.presenter.IMainPresenter;
import com.example.joel.comcastcodemvp.main.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewInterface, MyRecyclerViewAdapter.ClickOnItemListener {

    private IMainPresenter IMainPresenter;
    private Toolbar mTopToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTopToolbar = findViewById(R.id.my_toolbar);
        IMainPresenter = new MainPresenter(this, new ImplementorImpl(),mTopToolbar, this);
        IMainPresenter.doNetworkCall();
        IMainPresenter.loadSplash();
    }

    @Override
    public void navigatetoListFragment(List<String> list, List<String> urls) {
        IMainPresenter.loadListFragment(list, urls);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case (android.R.id.home):
                finish();
                break;
            case (R.id.action_favorite):
                supportInvalidateOptionsMenu();
                //switchLayout();
                IMainPresenter.switchLayout();
                Toast.makeText(MainActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
       super.onSaveInstanceState(outState);
        IMainPresenter = new MainPresenter(this, new ImplementorImpl(),mTopToolbar, this);

        IMainPresenter.doNetworkCall();
        IMainPresenter.loadSplash();
    }

    @Override
    public void onClickOnItemListener(String title, String description, String image) {
        IMainPresenter.loadDetailFragment(title, description, image);
    }

    void toolBarTitle(String title){
    setSupportActionBar(mTopToolbar);
    getSupportActionBar().setTitle(title);
}}
