package com.example.asiam;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

public class SnoozeService extends Service {
	public SnoozeService() {
	}

	public int onStartCommand(Intent intent, int flags, int startId) {
		Bundle extras = intent.getExtras();
        if (extras != null) {
        	String id = extras.getString("id");
        	NotificationManager nm = (NotificationManager) this
    				.getSystemService(Context.NOTIFICATION_SERVICE);
        	nm.cancel(id, 0);
        }
		
		//TODO: actual handling of snoozing
		stopSelf();
		return START_NOT_STICKY;
	}
	@Override
	public IBinder onBind(Intent intent) {
		return null;
		// TODO: Return the communication channel to the service.
		//throw new UnsupportedOperationException("Not yet implemented");
	}
}
