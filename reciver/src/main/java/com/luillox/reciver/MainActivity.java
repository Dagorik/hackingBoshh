package com.luillox.reciver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.android.BezirkMiddleware;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.luillox.key.SimulateKeyEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BezirkMiddleware.initialize(this);
        Bezirk bezirk = BezirkMiddleware.registerZirk("Remote Control Receiver Zirk");
        final EventSet eventSet = new EventSet(SimulateKeyEvent.class);

        eventSet.setEventReceiver(new EventSet.EventReceiver() {


            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                Log.e("MyLog", "Entre al receiveEvent");
                Toast.makeText(MainActivity.this, "Entre al receiveEvent", Toast.LENGTH_SHORT).show();
                //Check if the event is of interest
                if (event instanceof SimulateKeyEvent) {
                    final SimulateKeyEvent simulateKeyEvent = (SimulateKeyEvent) event;
                    System.out.println("Received key event - code: " + simulateKeyEvent.getKeyIntegerCode());
                    Toast.makeText(MainActivity.this, "Entre al receiveEvent" + simulateKeyEvent.getKeyIntegerCode(), Toast.LENGTH_SHORT).show();


                }
            }
        });

        bezirk.subscribe(eventSet);
        System.out.println("Listening for SimulateKeyEvents...");
    }
}
