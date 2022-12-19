package io.github.thegbguy.notificationfromservicetest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // toasting the retrived data from notification
        String firstData = getIntent().getStringExtra("first_data");
        String secondData = getIntent().getStringExtra("second_data");

        ((TextView) findViewById(R.id.tv_first_data)).setText("First data : " + firstData);
        ((TextView) findViewById(R.id.tv_second_data)).setText("Second data : " + secondData);

//        Toast.makeText(this, "First data : " + firstData + " and Second data : " + secondData, Toast.LENGTH_SHORT).show();

        // launch service after 3 secs
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, TestService.class);
            startService(intent);
            Toast.makeText(MainActivity.this, "Check and click notification", Toast.LENGTH_SHORT).show();
        }, 5000);
    }
}