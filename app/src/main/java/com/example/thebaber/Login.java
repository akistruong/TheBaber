package com.example.thebaber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {
    FirebaseAuth mAuth;

    Button btnSignIn;
    TextInputEditText mEmail,mPassword;
    CircularProgressIndicator mPgsLogin;
    TextView mGoToRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        btnSignIn = findViewById(R.id.btnLogin);
        mEmail  = (TextInputEditText)findViewById(R.id.txtEmailLogin);
        mPassword =(TextInputEditText)findViewById(R.id.txtPasswordLogin);
        mPgsLogin = (CircularProgressIndicator)findViewById(R.id.pgsLogin);
        mGoToRegister = findViewById(R.id.goToRegister);
        mGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();

                if(!email.isEmpty()&&!password.isEmpty())
                {
                    mPgsLogin.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                mPgsLogin.setVisibility(View.GONE);
                                startActivity(new Intent(Login.this,MainActivity.class));
                            }
                            else
                            {
                                mPgsLogin.setVisibility(View.GONE);
                                Toast.makeText(Login.this, "Đăng nhập thất bại, vui lòng kiểm tra lại"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(Login.this, "Đăng nhập thất bại, vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}