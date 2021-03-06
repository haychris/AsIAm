package com.example.asiam;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

public class Timer extends BroadcastReceiver{
    
    public void onReceive(Context context, Intent intent) {
    	Log.e("Timer", "Toast");
        //do notification and stuff
        Toast.makeText(context, "Testing" , Toast.LENGTH_LONG).show();
        PicNotification.notify(context, "Take a pic!", 4);
    }

    private void enableBootReceiver(Context context){
    	ComponentName receiver = new ComponentName(context, RebootReceiver.class);
    	PackageManager pm = context.getPackageManager();

    	pm.setComponentEnabledSetting(receiver,
    	        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
    	        PackageManager.DONT_KILL_APP);
    }
    private void disableBootReceiver(Context context) {
    	ComponentName receiver = new ComponentName(context, RebootReceiver.class);
    	PackageManager pm = context.getPackageManager();

    	pm.setComponentEnabledSetting(receiver,
    	        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
    	        PackageManager.DONT_KILL_APP);
    }
    public void startTimer(Context context) {
        //cancels existing alarms
        cancelTimer(context);
        
        //creating alarm with intent
        AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);;
        Intent intent = new Intent(context, Timer.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        //setting timer length based on setting
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int timerPreference = Integer.parseInt(preferences.getString("picture_frequency", "-1")) * 1000;
        if (timerPreference > 0){ 
        	enableBootReceiver(context);
            alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,
            		SystemClock.elapsedRealtime() + timerPreference,
                    timerPreference, alarmIntent);
        	//alarmMgr.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), timerPreference, alarmIntent);
        }
        else {
        	disableBootReceiver(context);
        }
    	Log.e("Timer", Integer.toString(timerPreference));

    }
    public void startTimer(Context context, int time) {
        //cancels existing alarms
        cancelTimer(context);
        
        //creating alarm with intent
        AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);;
        Intent intent = new Intent(context, Timer.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        
        if (time > 0){ 
        	enableBootReceiver(context);
            alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,
            		SystemClock.elapsedRealtime() + time,
                    time, alarmIntent);
        	//alarmMgr.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), timerPreference, alarmIntent);
        }
        else {
        	disableBootReceiver(context);
        }
    	Log.e("Timer", Integer.toString(time));

    }
    
    public void cancelTimer(Context context) {
        //creating alarm with intent
        AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);;
        Intent intent = new Intent(context, Timer.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
                
        //cancels alarms with same intent filter
        alarmMgr.cancel(alarmIntent);
    }
}
