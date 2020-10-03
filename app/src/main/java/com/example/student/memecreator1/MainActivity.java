package com.example.student.memecreator1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.media.MediaPlayer;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity implements TopSectionFragment.TopSectionListener {
MediaPlayer mysound;
    @Override
    public void createMeme(String top, String bottom) {

        bottomPictureFragment bottomfragment=(bottomPictureFragment)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        bottomfragment.setMemeText(top,bottom);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mysound=MediaPlayer.create(MainActivity.this,R.raw.therock);
        mysound.start();

    }

    public void play(View view)
    {
        Toast.makeText(this,"let's Meme",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mysound.release();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.twitter);
        builder.setCancelable(false);
        builder.setMessage("do u ant to exit");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(this,"let's Meme",Toast.LENGTH_LONG).show();
                finish();
            }
        });
        builder.setNegativeButton("No",null);
        builder.show();
    }
}
