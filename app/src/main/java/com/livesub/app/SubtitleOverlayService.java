package com.livesub.app;
import android.app.*;import android.content.*;import android.graphics.*;import android.os.*;import android.view.*;import android.widget.*;
public class SubtitleOverlayService extends Service{
 WindowManager wm;TextView tv;WindowManager.LayoutParams lp;
 public void onCreate(){super.onCreate();wm=(WindowManager)getSystemService(WINDOW_SERVICE);tv=new TextView(this);tv.setTextColor(Color.WHITE);tv.setTextSize(18);tv.setTypeface(null,1);tv.setGravity(Gravity.CENTER);tv.setPadding(24,14,24,14);tv.setBackgroundColor(0xe6101830);tv.setText("LiveSub");int type=Build.VERSION.SDK_INT>=26?WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY:WindowManager.LayoutParams.TYPE_PHONE;lp=new WindowManager.LayoutParams(-1,-2,type,WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,PixelFormat.TRANSLUCENT);lp.gravity=Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL;lp.y=80;try{wm.addView(tv,lp);}catch(Exception e){}}
 public int onStartCommand(Intent i,int f,int id){if(i!=null&&i.hasExtra("subtitle")&&tv!=null)tv.setText(i.getStringExtra("subtitle"));return START_NOT_STICKY;}
 public void onDestroy(){if(tv!=null)try{wm.removeView(tv);}catch(Exception e){}super.onDestroy();}
 public IBinder onBind(Intent i){return null;}
}