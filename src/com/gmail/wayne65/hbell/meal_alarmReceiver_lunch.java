package com.gmail.wayne65.hbell;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class meal_alarmReceiver_lunch extends BroadcastReceiver {
	private boolean isExit = true;

	@Override
	public void onReceive(Context arg0, Intent arg1) {

		if (isExit) {
			Intent intent = new Intent();
			intent.setClass(arg0, meal_alertDlg_lunch.class);
			
			// �]�w���@�ӥ��s��task�Ӱ��� (�S�o�˰��|��� -_- )
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			arg0.startActivity(intent);
		}
	}
}
