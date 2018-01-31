package com.example.joel.comcastcodemvp.main.data;

import android.util.Log;

import com.example.joel.comcastcodemvp.main.network.ApiInterface;
import com.example.joel.comcastcodemvp.main.network.RetrofitClient;
import com.example.joel.comcastcodemvp.model.RelatedTopicsItem;
import com.example.joel.comcastcodemvp.model.Response;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


/**
 * Created by Joel on 1/25/2018.
 */
public class ImplementorImpl implements Implementor {

    private final ApiInterface apiClient = RetrofitClient.getRetrofit().create(ApiInterface.class);

    private final List<String> list = new ArrayList<>();
    private final List<String> urls = new ArrayList<>();

    @Override
    public void callAPI(final onResponse listener) {
        Call<Response> call = apiClient.getData("simpsons+characters", "json");
        call.enqueue(new Callback<Response>() {

            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                List<RelatedTopicsItem> res = response.body().getRelatedTopics();
                Log.e("RESPONSE","ONSE"+res);

                for (RelatedTopicsItem item : res) {
                    list.add(item.getText());
                    urls.add(item.getIcon().getURL());
                }
                listener.onSuccess(list,urls);
            }

            @Override
            public void onFailure(Call<com.example.joel.comcastcodemvp.model.Response> call, Throwable t) {
                Log.d("TAG", "onFailure: " + "all");
                Log.d("HI", "onFailure: " + call.request().url());
                listener.onFailure("Failed");
            }
        });
    }
/*
    @Override
    public void switchView(final onResponse listener) {
        listFragment = ((ListFragment)fragmentManager.findFragmentByTag("list"));
        boolean isSwitched = listFragment.getAdapter().toggleItemViewType();
        listFragment.recyclerView.setLayoutManager(isSwitched ? new LinearLayoutManager(context) : new GridLayoutManager(context, 2));
        listFragment.getAdapter().notifyDataSetChanged();
        listener.onSwitched();
    }*/


}