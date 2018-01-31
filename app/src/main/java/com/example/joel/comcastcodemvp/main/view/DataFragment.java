package com.example.joel.comcastcodemvp.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joel.comcastcodemvp.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Joel on 1/31/2018.
 */

public class DataFragment extends Fragment {

    private TextView title;
    private TextView description;
    private ImageView imageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        title = view.findViewById(R.id.detailstitles);
        description = view.findViewById(R.id.detailsdescription);
        imageView = view.findViewById(R.id.detailsimageView);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        if (args == null) {
            title.setText("NULL");
            description.setText("NULL");
        } else {
            ((MainActivity) getActivity()).toolBarTitle(args.get("title").toString());
            title.setText(args.get("title").toString());
            description.setText(args.get("description").toString());
            String s = (String) args.get("image");
            if (s != null && !s.isEmpty()) {
                Picasso.with(getContext())
                        .load(s)
                        .into(imageView);
            }
        }
    }
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_favorite);
        item.setVisible(false);
    }
}
