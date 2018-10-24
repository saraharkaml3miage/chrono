package com.example.sarah.chronomtre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.os.SystemClock;



public class MainActivity extends AppCompatActivity {

    private Button Start;
    private Button Stop;
    private Button Reset;
    private Chronometer Chrono;
    private long dureePause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Chrono= (Chronometer)findViewById(R.id.chronometre_id);
        Start= (Button)findViewById(R.id.start_id);
        Stop= (Button)findViewById(R.id.stop_id);
        Reset= (Button)findViewById(R.id.reset_id);
    }







    public void startClick(View view) {



        if (dureePause==0) {
            Chrono.setBase(SystemClock.elapsedRealtime());

        }

        else if(dureePause != 0) {

            Chrono.setBase(SystemClock.elapsedRealtime()+ Chrono.getBase()- dureePause);
        }

        Chrono.start();
    }


    public void stopClick(View view){

        Chrono.stop();
        dureePause= SystemClock.elapsedRealtime();

    }


    public void resetClick(View view){

        Chrono.stop();
        dureePause = 0;
        Chrono.setText("0");
        Chrono.setBase(SystemClock.elapsedRealtime());
        Chrono.start();




    }
}

