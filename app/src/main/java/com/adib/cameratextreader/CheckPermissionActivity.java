package com.adib.cameratextreader;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CheckPermissionActivity extends AppCompatActivity {

    public static final int CAMERA_PERMISSSION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcer);

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSSION);
        } else {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case CAMERA_PERMISSSION:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "PERMISSION GRANTED", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } else{
                    Toast.makeText(this, "PERMISSION NOT GRANTED", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }
}
