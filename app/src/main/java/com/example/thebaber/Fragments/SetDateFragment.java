package com.example.thebaber.Fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;

import com.example.thebaber.Models.DateConvert;
import com.example.thebaber.Models.User;
import com.example.thebaber.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SetDateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetDateFragment extends Fragment {
    ArrayList<DateConvert> items =new ArrayList<DateConvert>();
    AutoCompleteTextView completeTextView;
    ArrayAdapter adapter;

    public SetDateFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Date tempDate = new Date();
       int currentDay =tempDate.getDay();
        int dateCount = 0;
       for(int i= currentDay ;i<=7;i++)
       {
           Date date = new Date();
           date.setDate(date.getDate()+dateCount);
           items.add(new DateConvert(date));
            dateCount++;
       }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_set_date, container, false);
        completeTextView = view.findViewById(R.id.autoComplete_txt);
        adapter = new ArrayAdapter<DateConvert>(getActivity(),R.layout.list_date_item,items);
        completeTextView.setAdapter(adapter);
        completeTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
            DateConvert convert =     items.get(i);
            Date test = convert.getDate();
                Log.d("item",item);

            }
        });
        return view;
    }
}