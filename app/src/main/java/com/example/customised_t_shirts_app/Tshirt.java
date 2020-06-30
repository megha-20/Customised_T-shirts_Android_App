package com.example.customised_t_shirts_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.Manifest;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.customised_t_shirts_app.Adapter.CartAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Tshirt extends AppCompatActivity {

    //Button

    private Button button;
    private ImageButton pd_add_to_cart_button;
    private ElegantNumberButton numberButton;

    private TextView tvtitle, tvdescription, tvCategory;
    private ImageView img;
    Bitmap bitmap;
    BitmapDrawable drawable;


    Button mSaveBtn,mShareBtn;
    CardView btncart;

    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tshirt);

        //cart



        //Button click
       /*button=(Button) findViewById(R.id.button_one);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openshirtactivity();
            }
        });*/



        mSaveBtn = findViewById(R.id.saveBtn);
        mShareBtn = findViewById(R.id.shareBtn);

      //  mfab = findViewById(R.id.fab);

        pd_add_to_cart_button=(ImageButton) findViewById(R.id.pd_add_to_cart_button);
        numberButton=(ElegantNumberButton)findViewById(R.id.number_btn);


        tvtitle = (TextView) findViewById(R.id.txttitle);
        tvdescription = (TextView) findViewById(R.id.txtDesc);
        tvCategory = (TextView) findViewById(R.id.txtcat);
        img = (ImageView) findViewById(R.id.shirtthumbnail);

        //Retrive data

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail");

        //setting values

        tvtitle.setText(Title);
        tvdescription.setText(Description);
        img.setImageResource(image);

       /* mfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Tshirt.this,Cart.class));
            }
        });*/

        pd_add_to_cart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addingToCartList();
            }
        });





       mShareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent=new Intent(Intent.ACTION_SEND);
                Drawable myDrawable=img.getDrawable();
                Bitmap bitmap=((BitmapDrawable)myDrawable).getBitmap();
                sharingIntent.setType("img/png");
                String shareBody="customised t-shirt design by cloud clothing app";
                String shareSubject="T-shirt";
                sharingIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT,shareSubject);

                startActivity(Intent.createChooser(sharingIntent,"Share Using"));
            }
        });

    /* mShareBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Drawable myDrawable=img.getDrawable();
              Bitmap bitmap=((BitmapDrawable)myDrawable).getBitmap();

              try {
                  File file=new File(Tshirt.this.getExternalCacheDir(),"T-shirt.png");
                  FileOutputStream fout=new FileOutputStream(file);
                  bitmap.compress(Bitmap.CompressFormat.PNG,80,fout);
                  fout.flush();
                  fout.close();
                  file.setReadable(true,false);
                  Intent intent=new Intent(Intent.ACTION_SEND);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  intent.putExtra(Intent.EXTRA_STREAM,Uri.fromFile(file));
                  intent.setType("image/png");
                  startActivity(Intent.createChooser(intent,"Share Image Via"));

              } catch (FileNotFoundException e) {
                  e.printStackTrace();
                  Toast.makeText(Tshirt.this, "File not found", Toast.LENGTH_SHORT).show();
              } catch (IOException e) {
                  e.printStackTrace();
              }catch (Exception e){
                  e.printStackTrace();
              }
          }
      });*/



     /* mShareBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              shareImage();
          }
      });*/

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawable = (BitmapDrawable) img.getDrawable();
                //CardView cardView=(CardView) btn_emoji.get;
                bitmap = drawable.getBitmap();

                FileOutputStream outputStream = null;

                File sdCard = Environment.getExternalStorageDirectory();
                File directory = new File(sdCard.getAbsolutePath() + "/Customised_T-shirt_app");
                directory.mkdir();

                String fileName = String.format("%d.png", System.currentTimeMillis());
                File outFile = new File(directory, fileName);

                Toast.makeText(Tshirt.this, "Image Saved Successfully", Toast.LENGTH_SHORT).show();


                try {
                    outputStream = new FileOutputStream(outFile);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                    outputStream.flush();
                    outputStream.close();

                    Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                    intent.setData(Uri.fromFile(outFile));
                    sendBroadcast(intent);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

    }

    private void addingToCartList() {

        String saveCurrentTime, saveCurrentDate;
        Calendar calForDate = Calendar.getInstance();
        SimpleDateFormat currentDate=new SimpleDateFormat("MM dd,yyyy");
        saveCurrentDate=currentDate.format(calForDate.getTime());

        SimpleDateFormat currentTime=new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime=currentDate.format(calForDate.getTime());

        final HashMap<String,Object> cartMap=new HashMap<>();
        cartMap.put("pname",tvtitle.getText().toString());
        cartMap.put("pcategory",tvCategory.getText().toString());
        cartMap.put("date",saveCurrentDate);
        cartMap.put("time",saveCurrentTime);
        cartMap.put("quantity",numberButton.getNumber());

    }








   /* private void shareImage() {

        try {

           File file=new File(getExternalCacheDir(),"sample.png");
           FileOutputStream fout=new FileOutputStream(file);
           bitmap.compress(Bitmap.CompressFormat.PNG,100,fout);
           fout.flush();
           fout.close();
           file.setReadable(true,false);
           Intent intent=new Intent(Intent.ACTION_SEND);
           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

           intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
           intent.setType("image/png");
           startActivity(Intent.createChooser(intent,"Share via"));

        }

        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }*/



    public void openshirtactivity(){
        Intent intent=new Intent(this,shirtactivity.class);
        startActivity(intent);
    }

}
