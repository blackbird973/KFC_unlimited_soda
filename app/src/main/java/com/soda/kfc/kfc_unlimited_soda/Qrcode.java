package com.soda.kfc.kfc_unlimited_soda;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.net.Uri;
import java.net.URL;
import com.soda.kfc.kfc_unlimited_soda.MainActivity;

import com.squareup.picasso.Picasso;

import java.util.Random;



class Qrcode extends Activity {

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //DECLARE IMAGEVIEW QR CODE
        ImageView ImageQRcode = (ImageView) findViewById(R.id.imageViewQrCode);

        setContentView(R.layout.qr_code_affichage);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .6));


        //CREATION URL QR CODE
        String basename;
        basename = "https://chart.googleapis.com/chart?chs=250x250&cht=qr&chl=WBCB;SERVICE;1;";



        //ADD NOMBRE ALEATOIRE
        Random rand = new Random();
        int n = rand.nextInt(100);

        //RECUPERE LA STRING DE L'INTENT DU MAIN ACTIVITY
        String SBvalue = getIntent().getStringExtra("SB_value");

        //URL FINAL COMPLET
        String url_final = basename + String.valueOf(n) + ";" + SBvalue ;

        Log.v(TAG, url_final);

        loadImageFromUrl(url_final);


    }


    private void loadImageFromUrl(String url_final) {

        ImageView ImageQRcode = (ImageView) findViewById(R.id.imageViewQrCode);

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
