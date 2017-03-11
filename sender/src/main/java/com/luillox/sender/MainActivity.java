package com.luillox.sender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.android.BezirkMiddleware;
import com.luillox.key.SimulateKeyEvent;

public class MainActivity extends AppCompatActivity {

    private Bezirk bezirk;
    private static final int LEFT_ARROW = 37;
    private static final int RIGHT_ARROW = 39;
    private static final int UP_ARROW = 38;
    private static final int DOWN_ARROW = 40;
    private static final int SPACE_BAR = 32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BezirkMiddleware.initialize(this);
        bezirk = BezirkMiddleware.registerZirk("Remote Control Android Zirk");

    }


    public void playPauseBtnPressed(View v) {

        bezirk.sendEvent(new SimulateKeyEvent(SPACE_BAR));
        System.out.println("Sent simulateKeyEvent for space bar");
    }

    public void backBtnPressed(View v) {
        bezirk.sendEvent(new SimulateKeyEvent(LEFT_ARROW));
        System.out.println("Sent simulateKeyEvent for left arrow");
    }

    public void forwardBtnPressed(View v) {
        bezirk.sendEvent(new SimulateKeyEvent(RIGHT_ARROW));
        System.out.println("Sent simulateKeyEvent for right arrow");
    }

    public void volumeDownBtnPressed(View v) {
        bezirk.sendEvent(new SimulateKeyEvent(DOWN_ARROW));
        System.out.println("Sent simulateKeyEvent for up arrow");
    }

    public void volumeUpBtnPressed(View v) {
        bezirk.sendEvent(new SimulateKeyEvent(UP_ARROW));
        System.out.println("Sent simulateKeyEvent for down arrow");
    }
}
