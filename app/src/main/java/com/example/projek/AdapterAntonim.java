package com.example.projek;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterAntonim extends BaseAdapter {


    private Context context;
    private ArrayList<AntonimModel> arrayList;

    public AdapterAntonim(Context context, ArrayList<AntonimModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    // Rest of the adapter code...

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int posisiton) {
        return arrayList.get(posisiton);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        view = layoutInflater.inflate(R.layout.listview_item_antonim, null);

        TextView kata = view.findViewById(R.id.kata);
        AntonimModel antonim = arrayList.get(position);
        kata.setText(antonim.getKata());

        return view;
    }
}
