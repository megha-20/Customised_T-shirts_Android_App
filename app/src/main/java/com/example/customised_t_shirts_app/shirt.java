package com.example.customised_t_shirts_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class shirt extends AppCompatActivity {

    private TextView tvtitle,tvdescription,tvCategory;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirt);

        tvtitle=(TextView)findViewById(R.id.txttitle);
        tvdescription=(TextView)findViewById(R.id.txtDesc);
        tvCategory=(TextView)findViewById(R.id.txtcat);
        img=(ImageView)findViewById(R.id.shirtthumbnail);

        //retrieve data

        Intent intent=getIntent();
        String Title=intent.getExtras().getString("Title");
        String Description=intent.getExtras().getString("Description");
        int image=intent.getExtras().getInt("Thumbnail");

        tvtitle.setText(Title);
        tvdescription.setText(Description);
        img.setImageResource(image);

    }
}
