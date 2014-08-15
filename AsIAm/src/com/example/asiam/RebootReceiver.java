package com.example.asiam;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class RebootReceiver extends BroadcastReceiver {
	public RebootReceiver() {
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		
		if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            // TODO: Set the alarm here.
			Timer timer = new Timer();
			timer.startTimer(context);
        }

	}
}
