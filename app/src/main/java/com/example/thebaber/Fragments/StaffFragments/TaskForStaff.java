package com.example.thebaber.Fragments.StaffFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thebaber.Adapter.ListTaskAdapter;
import com.example.thebaber.Adapter.StaffFragmentAdapter;
import com.example.thebaber.Models.BaberTask;
import com.example.thebaber.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskForStaff extends Fragment {
    ListTaskAdapter listTaskAdapter;
    RecyclerView recyclerView;
    List<BaberTask> mList;
    FirebaseFirestore mStore;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStore = FirebaseFirestore.getInstance();
        initTask();


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_task_for_staff,container,false);
        recyclerView = view.findViewById(R.id.rcv_list_task);
        return view;
    }
    void initTask()
    {

        mStore.collection("Task").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful())
                {
                    mList = task.getResult().toObjects(BaberTask.class);
                    listTaskAdapter = new ListTaskAdapter(mList,getActivity());
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(listTaskAdapter);
                }
            }
        });
    }

}
