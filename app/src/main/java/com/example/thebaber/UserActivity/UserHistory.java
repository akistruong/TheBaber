package com.example.thebaber.UserActivity;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.thebaber.Adapter.HistoryAdapter;
import com.example.thebaber.Models.BaberTask;
import com.example.thebaber.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class UserHistory extends AppCompatActivity {
    FirebaseUser user;
    FirebaseAuth mAuth;
    FirebaseFirestore mStore;
    HistoryAdapter adapter;
    RecyclerView  recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_history);
        mAuth = FirebaseAuth.getInstance();
        mStore = FirebaseFirestore.getInstance();
        user = mAuth.getCurrentUser();
        recyclerView = findViewById(R.id.rcv_history);
        getHistoryTask();


    }
    private void getHistoryTask()
    {
        List<BaberTask> list = new ArrayList<>();
        if(user!=null) {
            mStore.collection("Task").whereEqualTo("customerId", user.getUid()).whereEqualTo("done",true).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                      List<BaberTask> test=  task.getResult().toObjects(BaberTask.class);
                        adapter = new HistoryAdapter(test,UserHistory.this);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(UserHistory.this,RecyclerView.VERTICAL,false);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(adapter);
                    } else {
                        Log.d(TAG, "Error getting documents: ", task.getException());
                    }
                }
            });
        }
    }

}