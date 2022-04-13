package com.example.thebaber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thebaber.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    Button btnRegister;
    private TextInputEditText mEmail,mUserName,mPhone,mPassword,mRePassword;
    private FirebaseAuth mAuth;
    TextView mGoToLogin;
    FirebaseFirestore mStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        mStore = FirebaseFirestore.getInstance();
        setContentView(R.layout.activity_register);
        mEmail = (TextInputEditText)findViewById(R.id.txtEmail);
        mUserName = (TextInputEditText)findViewById(R.id.txtUserName);
        mPassword = (TextInputEditText)findViewById(R.id.txtPassword);
        mRePassword = (TextInputEditText)findViewById(R.id.txtRePassword);
        mPhone = (TextInputEditText)findViewById(R.id.txtPhone);
        mGoToLogin = findViewById(R.id.goToLogin);
        btnRegister = findViewById(R.id.btnOk);
        mGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this,Login.class));
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = mEmail.getText().toString();
                String username = mUserName.getText().toString();
                String password = mPassword.getText().toString();
                String phone = mPhone.getText().toString();
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override

                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    FirebaseUser currentUser = mAuth.getCurrentUser();
                                    DocumentReference df = mStore.collection("users").document(currentUser.getUid());
                                    User user = new User(email,username,phone,false,false,true,new Date(),null);
                                    df.set(user);
                                    Toast.makeText(Register.this, "Register Success.",
                                            Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Register.this,SplashScreen.class));
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("mess", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Register.this, "Authentication failed."+task.getException().getMessage(),
                                            Toast.LENGTH_SHORT).show();
                                };
                            };
                        });

            }
        });
    }
}