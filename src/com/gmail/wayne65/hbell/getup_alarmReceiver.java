package com.gmail.wayne65.hbell;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
//import android.media.MediaPlayer;


public class getup_alarmReceiver extends BroadcastReceiver {
	private boolean isExit = true;
//	private MediaPlayer mMediaPlayer = null;
//	private Context mContext = null;

	
	@Override
	public void onReceive(Context arg0, Intent arg1) {

		if (isExit) {
//			String msg = "該起床囉！";
//			mContext = arg0;
//			publicFun.showToast(mContext, msg);

// 這種呼叫AlertDialog的方式在Activity裏面都以正常運行，但是在這個alarmReceiver裏面就是會有錯誤，真怪啊~			
//			publicFun.showAlertDialog(mContext, "起床提醒", "大哥！該起床了吧！", "確認", "略過");
			
//			if (pref.LoadGetupBellCheckedValue(mContext) == true) _ringBell();
//			if (pref.LoadGetupVibrationCheckedValue(mContext) == true) _vibration();
//			publicFun.showNotification(arg0, msg);
			
			
			Intent intent = new Intent();
			intent.setClass(arg0, getup_alertDlg.class);
			
			// 設定讓一個全新的task來執行 (沒這樣做會當機 -_- )
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			arg0.startActivity(intent);
		}
	}
}
