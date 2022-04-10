package com.example.thebaber.UserActivity;

import static com.example.thebaber.Helpers.CloudHelper.initCloud;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;
//import com.cloudinary.android.MediaManager;
//import com.cloudinary.android.callback.ErrorInfo;
//import com.cloudinary.android.callback.UploadCallback;
import com.cloudinary.android.MediaManager;
import com.cloudinary.android.callback.ErrorInfo;
import com.cloudinary.android.callback.UploadCallback;
import com.example.thebaber.Fragments.HomeUserFragment;
import com.example.thebaber.Helpers.CloudHelper;
import com.example.thebaber.Models.UrlObj;
import com.example.thebaber.Models.User;
import com.example.thebaber.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;


import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class UpdateUser extends AppCompatActivity {
    TextInputEditText mEmail,mPhone,mName;
    CircleImageView imgAvt;
    Button btnUpdate;
    FirebaseFirestore mStore;
    FirebaseAuth mAuth;
    FirebaseUser user;
    Uri uriImg;
    Bitmap bitmapUri;
    CloudHelper helper;
    ActivityResultLauncher<Intent> intentActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
                if(result.getResultCode()==RESULT_OK)
                {
                    Intent intent = result.getData();
                    if(intent==null)
                    {
                        return;
                    }
                    uriImg = intent.getData();
                    Bitmap bitmap = null;
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uriImg);
                        imgAvt.setImageBitmap(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        }
    });
    public static final int MY_REQUEST_CODE =10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        mEmail = (TextInputEditText)findViewById(R.id.txt_email_update);
        mPhone = (TextInputEditText)findViewById(R.id.txt_phone_update);
        mName=(TextInputEditText)findViewById(R.id.txt_name_update);
        imgAvt = (CircleImageView)findViewById(R.id.iv_avt_update);
        btnUpdate = (Button)findViewById(R.id.btn_user_update);
        mAuth =FirebaseAuth.getInstance();
        mStore = FirebaseFirestore.getInstance();
         user= mAuth.getCurrentUser();

        setUserInfo();
        initListener();
        handleClickUpdate();
    }

    private void handleClickUpdate() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaManager.get().upload(uriImg).callback(new UploadCallback() {
                    @Override
                    public void onStart(String requestId) {

                    }

                    @Override
                    public void onProgress(String requestId, long bytes, long totalBytes) {

                    }

                    @Override
                    public void onSuccess(String requestId, Map resultData) {
                        Log.d("FileCloud", "onSuccess: "+resultData.get("url"));
                        Map userUpdate = new HashMap();
                        UrlObj url = new UrlObj(resultData.get("url").toString(),resultData.get("public_id").toString());
                        userUpdate.put("userName",mName.getText());
                        userUpdate.put("avtUrl",url);
                        mStore.collection("users").document(user.getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                               if(task.isSuccessful()&&task.getResult().exists())
                               {
                                   User mUser = task.getResult().toObject(User.class);
                                   UrlObj urlObj = new UrlObj(resultData.get("url").toString(),resultData.get("public_id").toString());
                                   mUser.setUserName(mName.getText().toString());
                                   mUser.setAvtUrl(urlObj);
                                   mStore.collection("users").document(user.getUid()).set(mUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                       @Override
                                       public void onComplete(@NonNull Task<Void> task) {
                                           if(task.isSuccessful())
                                           {
                                               Log.d("UpdateSuccess", "DocumentSnapshot successfully updated!");
                                           }
                                       }
                                   });
                               }
                            }
                        });

                    }

                    @Override
                    public void onError(String requestId, ErrorInfo error)
                    {
                        Log.d("FileError", "onError: "+error.getDescription());
                    }

                    @Override
                    public void onReschedule(String requestId, ErrorInfo error) {
                        Log.d("FileError", "onReschedule: "+error.getDescription());
                    }
                }).dispatch();
            }
        });
    }

    private void initListener() {
        imgAvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickRequestPermission();
            }
        });
    }

    private void handleClickRequestPermission() {
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M)
        {
            openGallery();
            return;
        }
        if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
        {
            openGallery();
        }else
        {
            String[] permisstion = {Manifest.permission.READ_EXTERNAL_STORAGE};
            requestPermissions(permisstion,MY_REQUEST_CODE);
        }
    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intentActivityResultLauncher.launch(Intent.createChooser(intent,"Select picture"));
    }

    private void setUserInfo() {
        user = mAuth.getCurrentUser();
        if(user==null)
        {
            return;
        }
        mStore.collection("users").document(user.getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if(task.isSuccessful())
                    {
                        if(task.getResult().exists())
                        {
                            Uri uri = user.getPhotoUrl();
                            User mUser  = task.getResult().toObject(User.class);
                            mEmail.setText(mUser.getEmail());
                            mPhone.setText(mUser.getPhone());
                            mName.setText(mUser.getUserName());
                            Glide.with(UpdateUser.this).load(mUser.getAvtUrl().getUrl()).into(imgAvt);
                        }
                    }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==MY_REQUEST_CODE)
        {
            if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                openGallery();
            }
        }
    }
}