package com.example.thebaber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.thebaber.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class SplashScreen extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseFirestore mStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mStore = FirebaseFirestore.getInstance();
        Handler handler = new Handler();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(user==null)
                {
                    startActivity(new Intent(SplashScreen.this,Login.class));
                    finish();
                }
               else
                {
                    DocumentReference df  = mStore.collection("users").document(user.getUid());

                    df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if(task.isSuccessful())
                                {
                                    DocumentSnapshot document = task.getResult();
                                    if(document.exists())
                                    {
                                        User user1 = document.toObject(User.class);
                                        if(user1.getAdmin())
                                        {
                                            startActivity(new Intent(SplashScreen.this,AdminScreen.class));
                                            finish();
                                        }
                                        else {
                                            startActivity(new Intent(SplashScreen.this,MainActivity.class));
                                            finish();
                                        }
                                    }
                                    else
                                    {
                                        Log.d("NoUser", "No data: ");
                                    }
                                }
                        }
                    });

                }
            }
        },2000);
    }
}