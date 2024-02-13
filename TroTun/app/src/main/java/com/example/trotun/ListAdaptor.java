package com.example.trotun;

import android.annotation.SuppressLint;
import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class ListAdaptor extends BaseAdapter {
    Context context;
    ArrayList<Integer> arrayList;
    LayoutInflater layoutInflater;
    public ListAdaptor(Context context, ArrayList<Integer> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
        layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        @SuppressLint("ViewHolder") View view1 = layoutInflater.inflate(R.layout.item_file  ,viewGroup,false);
        ImageView imageView =view1.findViewById(R.id.img);
        imageView.setImageResource(arrayList.get(i));
        return view1;
    }
}
