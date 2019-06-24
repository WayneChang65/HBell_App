package com.gmail.wayne65.hbell;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class drink_alarmReceiver extends BroadcastReceiver {

	// 不知道為什麼只要設定好時間，不管怎樣，就會馬上進到這之中的程序，
	// 只好先過濾掉第一次事件，等第二次事件再進入
	
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Log.d(drink_alarmReceiver.class.getSimpleName(), "is2ndTimeGetIn = false");
		if (globalVariable.is2ndTimeGetIn == true) {
			Log.d(drink_alarmReceiver.class.getSimpleName(), "is2ndTimeGetIn = true");
			Intent intent = new Intent();
			intent.setClass(arg0, drink_alertDlg.class);
			
			// 設定讓一個全新的task來執行 (沒這樣做會當機 -_- )
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			arg0.startActivity(intent);
		}
		globalVariable.is2ndTimeGetIn = true;
	}
}
