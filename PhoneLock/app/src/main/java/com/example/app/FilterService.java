package com.example.app;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.Toast;

public class FilterService extends Service implements OnTouchListener, OnClickListener {

    private WindowManager wm;
    private View convertView;
    Button closeButton;
    @Override public IBinder onBind(Intent intent) {
        // Not used
        return null;
    }

    @Override public void onCreate() {
        super.onCreate();
        final LayoutInflater infalInflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Inflating the splash screen and setting up the static view
        wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        convertView = infalInflater.inflate(R.layout.splash,null);
        convertView.setBackgroundColor(Color.TRANSPARENT);//Transparent background
        setupCloseButton();
        addViewToWindow();
    }

    /**
     * This method sets up the button that will be in the top right corner
     * which shuts off lock mode.
     */
    public void setupCloseButton(){
        closeButton = (Button)convertView.findViewById(R.id.closeButton);
        closeButton.setBackgroundColor(Color.TRANSPARENT);
        closeButton.setOnClickListener(this);
    }

    /**
     * This method sets up the parameters for the window and then adds our service view
     * to the window manager.
     */
    public void addViewToWindow(){
        //WindowManager.LayoutParams params = new WindowManager.LayoutParams(10000, 7000, LayoutParams.TYPE_SYSTEM_OVERLAY,  WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL, PixelFormat.TRANSLUCENT);//Clickable One
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(10000, 10000, WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL, PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.LEFT | Gravity.TOP;
        params.x = 0;
        params.y = 0;
        params.width=LayoutParams.MATCH_PARENT;
        params.height=LayoutParams.MATCH_PARENT;
        wm.addView(convertView, params);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Phone Unlocked", Toast.LENGTH_SHORT).show();
        this.stopSelf();
        wm.removeView(convertView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
