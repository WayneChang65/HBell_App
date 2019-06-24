package com.gmail.wayne65.hbell;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class meal_alarmReceiver_dinner extends BroadcastReceiver {
	private boolean isExit = true;

	@Override
	public void onReceive(Context arg0, Intent arg1) {

		if (isExit) {
			Intent intent = new Intent();
			intent.setClass(arg0, meal_alertDlg_dinner.class);
			
			// 設定讓一個全新的task來執行 (沒這樣做會當機 -_- )
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			arg0.startActivity(intent);
		}
	}
}
