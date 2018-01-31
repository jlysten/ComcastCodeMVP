package com.example.joel.comcastcodemvp.main.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joel.comcastcodemvp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{
    private final Context context;
    private final List<String> relatedTopicsItems;
    private final List<String> urls;
    private String title, description;
    //private String ;
    private ClickOnItemListener listener;

    public interface ClickOnItemListener {
        void onClickOnItemListener(String title, String description, String image);
    }

    boolean isSwitchView = true;
    //LIST_ITEM and GRID_ITEM are variables to check ad set the change in the layouts
    private static final int LIST_ITEM = 0;
    private static final int GRID_ITEM = 1;

    public MyRecyclerViewAdapter(Context context, List<String> list, List<String> urls) {
        this.context = context;
        this.relatedTopicsItems = list;
        listener = (ClickOnItemListener) context;
        this.urls = urls;
    }

    @Override
    public int getItemViewType (int position) {
        if (isSwitchView){
            return LIST_ITEM;
        }else{
            return GRID_ITEM;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
    private final TextView text;
    private final ImageView imageView;

    MyViewHolder(View view) {
        super(view);
        text = view.findViewById(R.id.titles);
        imageView = view.findViewById(R.id.imageView);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] Title =relatedTopicsItems.get(getAdapterPosition()).split("-");
                title = Title[0];
                description = Title[1];
                listener.onClickOnItemListener(title,description,urls.get(getAdapterPosition()));
            }
        });
    }
}

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == LIST_ITEM){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent, false);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_grid,parent, false);
        }
        return new MyViewHolder(view);
    }

    public boolean toggleItemViewType () {
        isSwitchView = !isSwitchView;
        return isSwitchView;
    }
    @Override
    public void onBindViewHolder( MyViewHolder holder, final int position) {
        String[] Title = relatedTopicsItems.get(position).split("-");
        title = Title[0];
        description = Title[1];
        holder.text.setText(title);
        if (urls.get(position).isEmpty() || urls.get(position) == null) {
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
        } else {
            Picasso.with(context)
                    .load(urls.get(position))
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return relatedTopicsItems.size();
    }
}