package com.example.datasaveddemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private  final String TAG = "MainActivity";

    private EditText name ;
    private EditText pwd ;
    private EditText show ;
    private Button login ;
    private Button showData ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.et_name);
        pwd = (EditText) findViewById(R.id.et_pwd);
        show = (EditText) findViewById(R.id.edit_show);
        login = (Button) findViewById(R.id.btn_login);
        showData = (Button) findViewById(R.id.btn_show);
        onClick(login);
        onClick(showData);
    }


    public void onClick(final Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (button.getId()){
                    case R.id.btn_login:
                        save();
                        break;
                    case R.id.btn_show:
                        showData();
                        break;
                    default:
                        break;
                }





            }
        });



    }



    public void showData(){
        FileInputStream in = null ;
        BufferedReader reader = null ;
        StringBuilder content = new StringBuilder();

        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null  ){
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader!=null)
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        Log.d(TAG,content.toString());


        show.setText(content.toString());

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    private void save() {
        FileOutputStream out = null ;
        BufferedWriter writer = null ;
        try {

            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));

            writer.write("Name : " + name.getText().toString());
            writer.write("Pwd : " + pwd.getText().toString());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (writer != null){
                    Log.d(TAG,"save OK");
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


}
