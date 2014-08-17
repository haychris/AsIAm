package com.example.asiam;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;

public class Snooze extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();
        if (extras != null) {
        	String id = extras.getString("id");
        	NotificationManager nm = (NotificationManager) this
    				.getSystemService(Context.NOTIFICATION_SERVICE);
        	nm.cancel(id, 0);
        }
	}
	
}
