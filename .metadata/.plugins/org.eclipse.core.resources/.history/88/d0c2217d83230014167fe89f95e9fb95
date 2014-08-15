package com.example.asiam;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class Timer extends BroadcastReceiver{
    
    public void onReceive(Context context, Intent intent) {
        //do notification and stuff
         Toast.makeText(context, "Testing" , Toast.LENGTH_LONG).show();
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
        int timerPreference = preferences.getInt("picture_frequency", -1);
        timerPreference = 10000;
        if (timerPreference > 0){       
            alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,
                    timerPreference,
                    timerPreference, alarmIntent);
        }
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
