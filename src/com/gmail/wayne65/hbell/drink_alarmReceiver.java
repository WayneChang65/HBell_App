package com.gmail.wayne65.hbell;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class drink_alarmReceiver extends BroadcastReceiver {

	// �����D������u�n�]�w�n�ɶ��A���ޫ�ˡA�N�|���W�i��o�������{�ǡA
	// �u�n���L�o���Ĥ@���ƥ�A���ĤG���ƥ�A�i�J
	
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Log.d(drink_alarmReceiver.class.getSimpleName(), "is2ndTimeGetIn = false");
		if (globalVariable.is2ndTimeGetIn == true) {
			Log.d(drink_alarmReceiver.class.getSimpleName(), "is2ndTimeGetIn = true");
			Intent intent = new Intent();
			intent.setClass(arg0, drink_alertDlg.class);
			
			// �]�w���@�ӥ��s��task�Ӱ��� (�S�o�˰��|��� -_- )
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			arg0.startActivity(intent);
		}
		globalVariable.is2ndTimeGetIn = true;
	}
}
