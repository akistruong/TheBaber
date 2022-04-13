package com.example.thebaber.StaffActivityPackage;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.thebaber.Models.BaberTask;
import com.example.thebaber.Models.ServiceBaber;
import com.example.thebaber.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DetailTask extends AppCompatActivity {
    boolean[] selectedLanguage;
    ArrayList<Integer> ServicePositions = new ArrayList<>();
    ArrayList<ServiceBaber> TaskList = new ArrayList<>();
    List <ServiceBaber> listSelected = new ArrayList<>();
    String[] ServiceArray ;
    TextView textViewSelect ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_task);
        BaberTask task =(BaberTask)getIntent().getSerializableExtra("Task");
        initService();
        handleSelectService();
    }
    void initService()
    {

        TaskList.add(new ServiceBaber("","Cắt tóc 7 bước","", 500f));
        TaskList.add(new ServiceBaber("","Uốc tóc","", 120f));
        ServiceArray = new String[TaskList.size()];
        selectedLanguage = new boolean[ServiceArray.length];
        for(int i =0;i<TaskList.size();i++)
        {
            ServiceArray[i] = TaskList.get(i).getTitle();
        }
    }
    void handleSelectService()
    {
        textViewSelect = findViewById(R.id.tx_select_service);
        textViewSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DetailTask.this);
                builder.setTitle("Chọn dịch vụ");
                // set dialog non cancelable
                builder.setCancelable(false);
                builder.setMultiChoiceItems(ServiceArray, selectedLanguage, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                        if(b)
                        {
                            ServicePositions.add(i);
                            Collections.sort(ServicePositions);
                        }
                        else
                        {
                            ServicePositions.remove(Integer.valueOf(i));

                        }
                    }

                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StringBuilder stringBuilder = new StringBuilder();
                        List<ServiceBaber> selectedTemp = new ArrayList<>();
                        for(int j=0 ;j<ServicePositions.size();j++)
                        {
                            selectedTemp.add(TaskList.get(ServicePositions.get(j)));
                            ServiceBaber service =   TaskList.get(ServicePositions.get(j));
                            stringBuilder.append(service.getTitle());
                            if (j != ServicePositions.size() - 1) {
                                stringBuilder.append(", ");
                            }
                        }
                        textViewSelect.setText(stringBuilder.toString());
                        Log.d(TAG, "onClick: "+ServicePositions.toString());
                        listSelected = selectedTemp;
                        String a = "sdasd";
                    }
                });
                builder.show();
            }

        });
    }

}