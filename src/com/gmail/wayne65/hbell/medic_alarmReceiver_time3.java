package com.gmail.wayne65.hbell;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class medic_alarmReceiver_time3 extends BroadcastReceiver {
	private boolean isExit = true;

	@Override
	public void onReceive(Context arg0, Intent arg1) {

		if (isExit) {
			Intent intent = new Intent();
			intent.setClass(arg0, medic_alertDlg_time3.class);
			
			// �]�w���@�ӥ��s��task�Ӱ��� (�S�o�˰��|��� -_- )
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			arg0.startActivity(intent);
		}
	}
}
