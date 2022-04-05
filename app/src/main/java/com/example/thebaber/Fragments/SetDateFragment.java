package com.example.thebaber.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.thebaber.Adapter.TimePickerAdapter;
import com.example.thebaber.Models.BaberTask;
import com.example.thebaber.Models.DateConvert;
import com.example.thebaber.Models.User;
import com.example.thebaber.R;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SetDateFragment extends Fragment {
    ArrayList<DateConvert> items =new ArrayList<DateConvert>();
    AutoCompleteTextView completeTextView;
    ArrayAdapter adapter;
    TimePickerAdapter timePickerAdapter;
    RecyclerView rcvTimes;
    ItemClickListener itemClickListener;
    String DateChoose ="";
    String TimeChoose="";
    Date DateFormat;
    Button btnSetDate;
    FirebaseFirestore mStore;
    FirebaseAuth mAuth;
    public SetDateFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Date tempDate = new Date();
        mStore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
       int currentDay =tempDate.getDay();
       int dateCount = 0;

       for(int i= currentDay ;i<=7;i++)
       {
           Date date = new Date();
           date.setDate(date.getDate()+dateCount);
           items.add(new DateConvert(date));
            dateCount++;
       }
       itemClickListener = new ItemClickListener() {
           @Override
           public void onClick(String s) {
               rcvTimes.post(new Runnable() {
                   @Override
                   public void run() {
                       timePickerAdapter.notifyDataSetChanged();
                   }
               });
               TimeChoose = s;
               Log.d("choose", DateChoose);
               Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
           }
       };
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_set_date, container, false);
        completeTextView = view.findViewById(R.id.autoComplete_txt);
        adapter = new ArrayAdapter<DateConvert>(getActivity(),R.layout.list_date_item,items);
        btnSetDate = view.findViewById(R.id.btnSetDate);
//        viewPager = view.findViewById(R.id.ViewPager_TimePicker);
        completeTextView.setAdapter(adapter);
        completeTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
            DateConvert convert =     items.get(i);
            DateChoose = item;
            DateFormat = convert.getDate();
            Date test = convert.getDate();

            }
        });

        handleSetDate();


        rcvTimes = view.findViewById(R.id.Rcv_TimePicker);
        timePickerAdapter = new TimePickerAdapter(getActivity(),itemClickListener);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getActivity(), FlexDirection.ROW, FlexWrap.WRAP);
        flexboxLayoutManager.setJustifyContent(JustifyContent.CENTER);
        rcvTimes.setLayoutManager(flexboxLayoutManager);
        timePickerAdapter.setData(getListTimes());
        rcvTimes.setAdapter(timePickerAdapter);
        return view;
    }

    private void handleSetDate() {
        btnSetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] Split =  TimeChoose.split("H");
                String HourString = Split[0].toString();
                int Hours =Integer.parseInt(Split[0].toString());
                DateFormat.setHours(Hours);
                DateFormat.setMinutes(0);
                DateFormat.setSeconds(0);
                Toast.makeText(getActivity(), "YourTimes"+DateFormat.toString(), Toast.LENGTH_SHORT).show();
                FirebaseUser user = mAuth.getCurrentUser();
                DocumentReference docRef = mStore.collection("users").document(user.getUid());
                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful())
                        {
                            DocumentSnapshot document = task.getResult();
                            if(document.exists())
                            {
                                User user1 = document.toObject(User.class);
                                BaberTask newBaberTask = new BaberTask(user1.getUserName(),DateFormat, user1.getPhone(), false,0);
                                mStore.collection("Task").add(newBaberTask).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DocumentReference> task) {
                                        if(task.isSuccessful())
                                        {
                                            Toast.makeText(getActivity(), "Them thanh cong", Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            Toast.makeText(getActivity(), "Them that bai", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
//                            else
//                            {
//
//                            }
                        }
                    }
                });


            }
        });
    }

    private List<String> getListTimes() {
     List<String>   Times = new ArrayList<String>();
       for(int i=8;i<=20;i++)
       {
           Times.add(i+"H00");
       }
        return Times;
    }
}