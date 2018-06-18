package com.soda.kfc.kfc_unlimited_soda;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //DEBUT AJOUT
    SeekBar sb;
    TextView valuetxt;
    ImageView image_gobelet;
    //FIN AJOUT
    Button btn_valider;

    int progressChanged = 10; //PERMET D'AVOIR UN MIN A 10
    private static final String TAG = "MyActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DEBUT AJOUT






        btn_valider=(Button) findViewById(R.id.view_boutonvalider);
        sb=(SeekBar) findViewById(R.id.simpleSeekBar);
        image_gobelet=(ImageView) findViewById(R.id.gallery);
        sb.setProgress(20); //VALEUR INITIALE DE LA SEEKBAR
        sb.setMax(40); //Met le max de la seekbar

        sb.incrementProgressBy(10);

        valuetxt=(TextView) findViewById(R.id.varboisson);
        valuetxt.setText("Tu as choisis de remplir " + sb.getProgress() + " centilitres");

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {



            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = 10+ progress;
                progressChanged = progressChanged / 10;
                progressChanged = progressChanged * 10;
                valuetxt.setText("Tu as choisis de remplir " + progressChanged + " centilitres");

                //ANIMATION DU REMPLISSAGE DU GOBELET SUIVANT LES VALEURS DE LA SEEKBAR
                if (progressChanged <= 10){
                        image_gobelet.setImageDrawable(getResources().getDrawable(R.drawable.gob1));
                } else if (progressChanged >= 10 && progressChanged <= 20 ) {
                        image_gobelet.setImageDrawable(getResources().getDrawable(R.drawable.gob2));
                } else if (progressChanged >= 20 && progressChanged <= 30 ) {
                        image_gobelet.setImageDrawable(getResources().getDrawable(R.drawable.gob3));
                } else if (progressChanged >= 30 && progressChanged <= 40 ) {
                        image_gobelet.setImageDrawable(getResources().getDrawable(R.drawable.gob4));
                } else if (progressChanged == 50 ) {
                        image_gobelet.setImageDrawable(getResources().getDrawable(R.drawable.gob5));
                }



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //FIN AJOUT

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DEBUT ABOUT POPUP
                startActivity(new Intent(MainActivity.this,Pop.class));


                //FIN ABOUT
            }
        });


        btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //PASSE LA VALEUR DE LA SEEKBAR EN INTENT DANS LA CLASS Qrcode.java ET LANCE Qrcode.java
                Intent intent = new Intent(getBaseContext(), Qrcode.class);
                intent.putExtra("SB_value", String.valueOf(progressChanged));
                startActivity(intent);





            }
        });




    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return item.getItemId() == R.id.action_settings || super.onOptionsItemSelected(item);
    }

}





