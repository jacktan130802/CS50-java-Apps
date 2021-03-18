    package com.sp.test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.RequestOptions;

import java.io.FileDescriptor;
import java.io.IOException;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation;

public class MainActivity4 extends AppCompatActivity {
private ImageView imgview;
private Bitmap image;  /*Use to load images.*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        imgview=findViewById(R.id.imgView);

    }
//Creating your own method to reduce too many of the same code  that is being used when you create the effects.
    public void apply(Transformation<Bitmap> filter){
        Glide.with(this).load(image)
                .apply(RequestOptions.bitmapTransform(filter)) //creating an object, confirm do not need new.
                .into(imgview);

        /*RequestOptions.bitmapTransform() + cntrl p to see the arguments that u want*/
    }

    public void choosePhoto (View v){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT); //Specify something in te intent.
        intent.setType("image/*");
        startActivityForResult(intent, 1);
        /*Request code : To identify where request came from.*/
    }
    public void applySepia(View v){
        Glide.with(this).load(image)
                .apply(RequestOptions.bitmapTransform(new SepiaFilterTransformation()))
                .into(imgview);
    }
    public void applyToon(View v){
        Glide.with(this).load(image)
                .apply(RequestOptions.bitmapTransform(new ToonFilterTransformation()))
                .into(imgview);
    }
    public void applySketch(View v){
        apply(new SketchFilterTransformation()); // new : new is used to create an unnamed object through the constructor.
    }
    public void applyBlur(View v){
        apply(new BlurTransformation()); // new : new is used to create an unnamed object through the constructor.
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_OK && data != null){
            try {
                Uri uri = data.getData();
                ParcelFileDescriptor parcelFileDescriptor = getContentResolver().openFileDescriptor(uri,"r");
                //r is only to read i.
                FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
                image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
                parcelFileDescriptor.close();
                imgview.setImageBitmap(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}