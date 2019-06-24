package com.gmail.wayne65.hbell;

import java.util.Calendar;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class publicFun {
	private static MediaPlayer mMediaPlayer = null;
	private static Context mContext = null;
	
	public static void showNotification(Context arg0, String msg){
		Notification notification = new Notification(R.drawable.icon, "HBell", System.currentTimeMillis());
		PendingIntent contentIntent = PendingIntent.getActivity(arg0, 0, new Intent(arg0, main.class), 0);
		notification.setLatestEventInfo(arg0, "", msg, contentIntent);
		NotificationManager mNM = (NotificationManager)arg0.getSystemService(Context.NOTIFICATION_SERVICE);
		
		mNM.cancel(0);
		mNM.notify(0, notification);
	}

	public static void showToast(Context arg0, String msg) {
		Toast.makeText(arg0, msg, Toast.LENGTH_LONG).show();
	}

	public static int getCurrentTime(Context context){
		long lTime;
		int iHour, iMinutes;
		final Calendar c;
//		String strMsg;
		lTime = System.currentTimeMillis();
		c = Calendar.getInstance();
		c.setTimeInMillis(lTime);
		iHour = c.get(Calendar.HOUR);
		iMinutes = c.get(Calendar.MINUTE);
//		strMsg = String.format("%d", iHour * 100) + String.format("%d", iMinutes * 1);
//		strMsg = String.format("%d", iHour) + "時" + String.format("%d", iMinutes) + "分";
//		publicFun.showToast(main.this, strMsg);
		return Integer.parseInt(String.format("%d", iHour)) * 100
				+ Integer.parseInt(String.format("%d", iMinutes)) * 1;
	}
	
	public static void ringBell(Context context, boolean doPlay) {

		if (doPlay == true) {
			mContext = context;
			mMediaPlayer = new MediaPlayer();
			mMediaPlayer = MediaPlayer.create(mContext, R.raw.ring);

			try {
				if (mMediaPlayer != null) {
					mMediaPlayer.stop();
				}
				mMediaPlayer.prepare();
				mMediaPlayer.start();
			} catch (Exception e) {
				publicFun.showToast(mContext, e.toString());
				e.printStackTrace();
			}

			mMediaPlayer
					.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
						public void onCompletion(MediaPlayer arg0) {
							try {
								arg0.release();
								// showToast(mContext, "撥放完成");
							} catch (Exception e) {
								publicFun.showToast(mContext, e.toString());
								e.printStackTrace();
							}
						}
					});

			mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
				public boolean onError(MediaPlayer arg0, int arg1, int arg2) {
					try {
						arg0.release();
					} catch (Exception e) {
						publicFun.showToast(mContext, e.toString());
						e.printStackTrace();
					}
					return false;
				}
			});
		}else{
			if(mMediaPlayer != null){
				mMediaPlayer.stop();
				mMediaPlayer.release();
			}
		}
	}
}

