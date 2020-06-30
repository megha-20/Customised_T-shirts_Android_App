package com.example.customised_t_shirts_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Icon;
import android.media.audiofx.DynamicsProcessing;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.customised_t_shirts_app.Interface.AddTextFragmentListener;
import com.example.customised_t_shirts_app.Interface.BrushFragmentListener;
import com.example.customised_t_shirts_app.Interface.EmojiFragmentListener;
import com.example.customised_t_shirts_app.Utils.BitmapUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ja.burhanrashid52.photoeditor.PhotoEditor;
import ja.burhanrashid52.photoeditor.PhotoEditorView;
import petrov.kristiyan.colorpicker.ColorPicker;



public class shirtactivity extends AppCompatActivity implements BrushFragmentListener, EmojiFragmentListener, AddTextFragmentListener {

    private ImageView imageView;
   // private static final int PERMISSION_PICK_IMAGE=1000;
    //private static final int PERMISSION_INSERT_IMAGE=1001;

    Bitmap originalBitmap;//,filteredBitmap,finalBitmap;



    ImageView img;
    ImageView mImageView;
    ImageView imgView;
    ImageButton mChooseBtn;
    ImageButton btn_save;

    RelativeLayout relativeLayout;


    BitmapDrawable drawable;
    Bitmap bitmap;

    PhotoEditor photoEditor;
    PhotoEditorView photoEditorView;
    CardView btn_brush,btn_emoji,btn_add_text;

    private static final int IMAGE_PICK_CODE=1000;
    private static final int PERMISSION_CODE=1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirtactivity);

        //view
        photoEditorView = (PhotoEditorView) findViewById(R.id.image_preview);
        photoEditor = new PhotoEditor.Builder(this, photoEditorView)
                .setPinchTextScalable(true)
                .setDefaultEmojiTypeface(Typeface.createFromAsset(getAssets(), "emojione-android.ttf"))
                .build();

        imageView = (ImageView) findViewById(R.id.shirtthumbnail1);
        Intent intent1 = getIntent();
        int image = intent1.getExtras().getInt("Thumbnail");
        imageView.setImageResource(image);

        //brush

        btn_save=(ImageButton)findViewById(R.id.btn_save);
        btn_brush = (CardView) findViewById(R.id.btn_brush);
        btn_emoji = (CardView) findViewById(R.id.btn_emoji);
        btn_add_text = (CardView) findViewById(R.id.btn_add_text);
        relativeLayout=findViewById(R.id.savebtn1);
       // btn_add_image = (CardView) findViewById(R.id.btn_add_image);


        btn_brush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //enable brush mode
                //imgView.setBrushDrawingMode(true);
                photoEditor.setBrushDrawingMode(true);
                BrushFragment brushFragment = BrushFragment.getInstance();
                brushFragment.setListener(shirtactivity.this);
                brushFragment.show(getSupportFragmentManager(), brushFragment.getTag());
            }
        });


        btn_emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmojiFragment emojiFragment = EmojiFragment.getInstance();
                emojiFragment.setListener(shirtactivity.this);
                emojiFragment.show(getSupportFragmentManager(), emojiFragment.getTag());
            }
        });


        btn_add_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddTextFragment addTextFragment = AddTextFragment.getInstance();
                addTextFragment.setListener(shirtactivity.this);
                addTextFragment.show(getSupportFragmentManager(), addTextFragment.getTag());
            }
        });

      /* btn_add_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addImageToPicture();
            }
        });*/



     btn_save.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Bitmap bitmap=Bitmap.createBitmap(relativeLayout.getWidth(),relativeLayout.getHeight(), Bitmap.Config.ARGB_8888);
              Canvas canvas=new Canvas(bitmap);
              relativeLayout.draw(canvas);
              //drawable=(BitmapDrawable)imageView.getDrawable();
              //CardView cardView=(CardView) btn_emoji.get;
              //bitmap=drawable.getBitmap();

              FileOutputStream outputStream=null;

              File sdCard= Environment.getExternalStorageDirectory();
              File directory=new File(sdCard.getAbsolutePath()+"/yourFolderName");
              directory.mkdir();

              String fileName=String.format("%d.png",System.currentTimeMillis());
              File outFile=new File(directory,fileName);

              Toast.makeText(shirtactivity.this, "Image Saved Successfully", Toast.LENGTH_SHORT).show();



              try {
                  outputStream=new FileOutputStream(outFile);
                  bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
                  outputStream.flush();
                  outputStream.close();

                  Intent intent=new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                  intent.setData(Uri.fromFile(outFile));
                  sendBroadcast(intent);




              } catch (FileNotFoundException e) {
                  e.printStackTrace();
              } catch (IOException e) {
                  e.printStackTrace();
              }


          }
      });



     //colorpicker

        img = (ImageView) findViewById(R.id.shirtthumbnail1);

        ImageButton changecolor = (ImageButton) findViewById(R.id.imageButton1);

        changecolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencolorpicker();
            }
        });


        //VIEWS GALLERY

        // mImageView=findViewById(R.id.shirtthumbnail2);
         mChooseBtn=findViewById(R.id.imageButton3);
         Bitmap bitmap;


        //handle button click

        mChooseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check runtime permission

                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                       //permission not granted, request it.

                       String[] permissions={Manifest.permission.READ_EXTERNAL_STORAGE};

                       //show popup for runtime permission

                        requestPermissions(permissions,PERMISSION_CODE);
                    }
                else{
                       //permission already granted
                        pickImageFromGallery();
                    }
                }

             else{
                   //system os is less then marshallow
                    pickImageFromGallery();
                }
            }
        });
    }




   private void pickImageFromGallery(){
       //intent to pick image
       Intent intent=new Intent(Intent.ACTION_PICK);
       Intent data = null;

       intent.setType("image/*");
       startActivityForResult(intent,IMAGE_PICK_CODE);




    }

    //handle result of runtime permission



   @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {


        switch (requestCode){
            case PERMISSION_CODE:{
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    pickImageFromGallery();
                }

                else{
                    //permission was denied

                    Toast.makeText(this,"Permission denied...!",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

        //handle result of picked image


   @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==RESULT_OK&&requestCode==IMAGE_PICK_CODE){
            //set image to imageview
           // mImageView.setImageURI(data.getData());
            Bitmap bitmap=BitmapUtils.getBitmapFromGallery(this,data.getData(),200,200);
            photoEditor.addImage(bitmap);
        }
    }



   /* private void addImageToPicture() {
        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if(report.areAllPermissionsGranted())
                        {
                            Intent intent=new Intent(Intent.ACTION_PICK);
                            intent.setType("image/*");
                            startActivityForResult(intent,PERMISSION_INSERT_IMAGE);
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        Toast.makeText(shirtactivity.this,"Permission Denied",Toast.LENGTH_SHORT).show();
                    }
                }).check();
    }*/


   /* @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(resultCode==RESULT_OK){
            if(resultCode==PERMISSION_PICK_IMAGE){
                Bitmap bitmap=BitmapUtils.getBitmapFromGallery(this,data.getData(),800,800);

                //clear bitmap memory
                originalBitmap.recycle();
                finalBitmap.recycle();
                filteredBitmap.recycle();

                originalBitmap=bitmap.copy(Bitmap.Config.ARGB_8888,true);
                finalBitmap=originalBitmap.copy(Bitmap.Config.ARGB_8888,true);
                filteredBitmap=originalBitmap.copy(Bitmap.Config.ARGB_8888,true);
                photoEditorView.getSource().setImageBitmap(originalBitmap);
                bitmap.recycle();

               // filterListFragment.displayThumbnail(originalBitmap);

            }

            else  if(resultCode==PERMISSION_INSERT_IMAGE){
                Bitmap bitmap=BitmapUtils.getBitmapFromGallery(this,data.getData(),200,200);
                photoEditor.addImage(bitmap);

            }
        }
    }*/

  
    public void opencolorpicker(){
        final ColorPicker colorPicker=new ColorPicker(this);
        final ArrayList<String> colors=new ArrayList<>();
        colors.add("#258174");
        colors.add("#3c8d2f");
        colors.add("#20724f");
        colors.add("#6a3ab2");
        colors.add("#323299");
        colors.add("#800080");
        colors.add("#b79716");
        colors.add("#966d37");
        colors.add("#b77231");
        colors.add("#808000");
        colors.add("#f44336");
        colors.add("#03A9F4");
        colors.add("#ffffff");
        colors.add("#FFEB3B");
        colors.add("#FF5722");
        colors.add("#9E9E9E");
        colors.add("#D500F9");
        colors.add("#1A237E");
        colors.add("#D500F9");
        colors.add("#795548");
        colors.add("#7986CB");

        colorPicker.setColors(colors)
                .setColumns(5)
                .setRoundColorButton(true)
                .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position, int color) {
                        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                            img.setColorFilter(color);
                        }



                    @Override
                    public void onCancel() {

                    }
                }).show();
    }

    @Override
    public void onBrushSizeChangedListener(float size){
        photoEditor.setBrushSize(size);

    }

    @Override
    public void onBrushOpacityChangedListener(int opacity){
        photoEditor.setOpacity(opacity);
    }

    @Override
    public void onBrushColorChangedListener(int color){
        photoEditor.setBrushColor(color);
    }

    @Override
    public void onBrushStateChangedListener(boolean isEraser){
        if(isEraser)
            photoEditor.brushEraser();
        else
            photoEditor.setBrushDrawingMode(true);
    }


    @Override
    public void onEmojiSelected(String emoji) {
        photoEditor.addEmoji(emoji);
    }

    @Override
    public void onAddTextButtonClick(String text, int color) {
        photoEditor.addText(text,color);
    }

   
}

