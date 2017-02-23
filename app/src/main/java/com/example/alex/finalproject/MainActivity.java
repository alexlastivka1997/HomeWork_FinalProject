package com.example.alex.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtCall;
    TextView txtMap;
    TextView txtEmail;

    ImageView imgCall;
    ImageView imgMap;
    ImageView imgEmail;

    String geoUriString = "geo:49.442012,32.065156?z=18";
    String phoneNum = "tel:0472320465";
    String to = "WWE_WWF@ukr.net";
    String subject = "TEST";
    String text = "TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMap = (TextView)findViewById(R.id.txt_map);
        txtCall = (TextView)findViewById(R.id.txt_phone);
        txtEmail = (TextView)findViewById(R.id.txt_mail);

        imgMap = (ImageView)findViewById(R.id.img_map);
        imgCall = (ImageView)findViewById(R.id.img_phone);
        imgEmail = (ImageView)findViewById(R.id.img_email);


        txtMap.setOnClickListener(this);
        txtCall.setOnClickListener(this);
        txtEmail.setOnClickListener(this);

        imgMap.setOnClickListener(this);
        imgEmail.setOnClickListener(this);
        imgCall.setOnClickListener(this);

    }

    public void onClick(View v){

        switch(v.getId()){

            case (R.id.txt_phone):
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNum));
                startActivity(phoneIntent);
                break;

            case (R.id.img_phone):
                Intent phoneIntent1 = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNum));
                startActivity(phoneIntent1);
                break;

            case (R.id.txt_map):
                Uri geoUri = Uri.parse(geoUriString);
                Intent geoIntent = new Intent(Intent.ACTION_VIEW,geoUri);
                startActivity(geoIntent);
                break;

            case (R.id.img_map):
                Uri geoUri1 = Uri.parse(geoUriString);
                Intent geoIntent1 = new Intent(Intent.ACTION_VIEW,geoUri1);
                startActivity(geoIntent1);
                break;

            case (R.id.txt_mail):
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT,text);

                emailIntent.setType("massage/rfc882");

                startActivity(emailIntent.createChooser(emailIntent,"Выберите способ отправки Email"));
                break;

            case (R.id.img_email):
                Intent emailIntent1 = new Intent(Intent.ACTION_SEND);
                emailIntent1.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                emailIntent1.putExtra(Intent.EXTRA_SUBJECT,subject);
                emailIntent1.putExtra(Intent.EXTRA_TEXT,text);

                emailIntent1.setType("massage/rfc882");

                startActivity(emailIntent1.createChooser(emailIntent1,"Выберите способ отправки Email"));
                break;

        }

    }
}
