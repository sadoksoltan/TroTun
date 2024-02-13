package com.example.trotun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class tun extends AppCompatActivity {
    ListView listView;
    ArrayList<Integer> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tun);
        listView.findViewById(R.id.listview);

       arrayList.add(R.drawable.d1);
        arrayList.add(R.drawable.d2);
        arrayList.add(R.drawable.d3);
        arrayList.add(R.drawable.d4);
        arrayList.add(R.drawable.d5);
        arrayList.add(R.drawable.d7);
        arrayList.add(R.drawable.d8);
        arrayList.add(R.drawable.d9);
        arrayList.add(R.drawable.d10);
        arrayList.add(R.drawable.d11);
        arrayList.add(R.drawable.d17);
        arrayList.add(R.drawable.d13);
        arrayList.add(R.drawable.d14);
        arrayList.add(R.drawable.d15);
        ListAdaptor listAdaptor =new ListAdaptor(this,arrayList);
        listView.setAdapter(listAdaptor);

    }
}