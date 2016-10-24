package com.aryaan.ankitha.implicitintentexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view){
        Intent intent,chooser;
        if (view.getId() == R.id.launchMap){
            intent = new Intent(Intent.ACTION_VIEW);
            Intent.createChooser(intent,"Launch Map");
            chooser = intent.setData(Uri.parse("geo:12.9716,77.5946"));
            startActivity(chooser);
        }
        if (view.getId() == R.id.launchMarket){
            intent = new Intent(Intent.ACTION_VIEW);
            Intent.createChooser(intent,"Launch Google Play");
            chooser = intent.setData(Uri.parse("market://details?id=in.startv.hotstar&hl=en"));
            startActivity(chooser);
        }
        if (view.getId()== R.id.sendEmail){
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {"pratibhamk2@gmail.com","shrinivasjadhav92@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL,to);
            intent.putExtra(Intent.EXTRA_SUBJECT,"Email from my App");
            intent.putExtra(Intent.EXTRA_TEXT,"I am sending this message from my new app");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent,"Send Email");
            startActivity(chooser);
        }
    }
}
