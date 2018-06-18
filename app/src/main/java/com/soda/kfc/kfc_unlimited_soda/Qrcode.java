package com.soda.kfc.kfc_unlimited_soda;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Random;



class Qrcode extends Activity {

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.qrcode_display_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .6));


        //Creation of the final URL for the request
        String basename;
        basename = "https://chart.googleapis.com/chart?chs=250x250&cht=qr&chl=WBCB;SERVICE;1;";



        //Add a random int between 0 - 100
        Random rand = new Random();
        int n = rand.nextInt(100);

        //Get the value of the string passed by the Intent from the MainActivity.java
        String SBvalue = getIntent().getStringExtra("SB_value");

        //Comple Final URL
        String finalUrl = basename + String.valueOf(n) + ";" + SBvalue ;

        Log.v(TAG, finalUrl);

        loadImageFromUrl(finalUrl);


    }


    private void loadImageFromUrl(String url_final) {

        ImageView ImageQRcode = (ImageView) findViewById(R.id.imageViewqrCode);

        Picasso.with(this).load(url_final).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(ImageQRcode, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
