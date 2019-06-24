package com.gmail.wayne65.hbell;

import java.util.Calendar;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.AlarmManager;



/**
 * drink類別
 * Health Bell的主要畫面
 *
 * @author Wayne Chang
 * @author wayne65@gmail.com
 * @version 1.0.0
 */
public class drink extends Activity {
	private String mLogTag;			// Debug時使用的Log Tag，顯示類別名稱
	private LinearLayout mTime;
	private TextView mTimeDisplay;
	private int mHour;
	private int mMinute;
	private CheckBox mBellSwitch;
	private CheckBox mVibrationSwitch;
	private CheckBox mTextSwitch;
	private TimePickerDialog mTpd;
	
	// private 函式命名，使用底線開頭並且第一字母小寫
	/**
	 * 找到資源檔對應的ID，並且連結到相關資源檔位址
	 */
	private void _findViews() {
		mLogTag = drink.class.getSimpleName();
		mTime = (LinearLayout) findViewById(R.id.ll_drink_time);
		mTimeDisplay = (TextView) findViewById(R.id.txv_drink_time_display);
		mBellSwitch = (CheckBox) findViewById(R.id.cbx_drink_alerttype_bell);
		mVibrationSwitch = (CheckBox) findViewById(R.id.cbx_drink_alerttype_vibration);
		mTextSwitch = (CheckBox) findViewById(R.id.cbx_drink_alerttype_text);
	}	

	/**
	 * 初始化顯示元件的資料
	 */
	private void _initialData() {
		_loadPref_Time();
		_showTimeDisplay();
		
		mTextSwitch.setChecked(true);
		mTextSwitch.setEnabled(false);
	}	

	/**
	 * 訂閱所有元件感興趣的事件
	 */
	private void _setListeners() {
		CListener_mTime listener_mTime = new CListener_mTime();
		CListener_mBellSwitch listener_mBellSwitch = new CListener_mBellSwitch();
		CListener_mVibrationSwitch listener_mVibrationSwitch = new CListener_mVibrationSwitch();
		
		
		mTime.setOnClickListener(listener_mTime);
		
		mBellSwitch.setOnClickListener(listener_mBellSwitch);
		mVibrationSwitch.setOnClickListener(listener_mVibrationSwitch);
	}	

	private void _loadPref_Time() {
		mHour = pref.LoadDrinkTimePeriodHourValue(this);
		mMinute = pref.LoadDrinkTimePeriodMinuteValue(this);
		
		mBellSwitch.setChecked(pref.LoadDrinkBellCheckedValue(this));
		mVibrationSwitch.setChecked(pref.LoadDrinkVibrationCheckedValue(this));
	}
	
	private void _savePref_Time(int iHour, int iMinute) {
		pref.SaveDrinkTimePeriodHourValue(this, iHour);
		pref.SaveDrinkTimePeriodMinuteValue(this, iMinute);
	}
	
	private void _showTimeDisplay(){
		String strTime;
		strTime = mHour + "小時 " + mMinute + "分";
		mTimeDisplay.setText(strTime);
	}
	
	
	// Inner classes
	// 除了專案的主要類別不用C開頭之外，內部的類別通通以C為prefix
	private class CListener_mTime implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mTime::onClick");

			_loadPref_Time();
			CListener_timePicker listener_timePicker = new CListener_timePicker();
			mTpd = new TimePickerDialog(drink.this, listener_timePicker, mHour, mMinute, true);
			mTpd.setTitle("間隔時間設定");
			mTpd.show();
		}
		

	}	

	
	private class CListener_timePicker implements TimePickerDialog.OnTimeSetListener{
		public void onTimeSet(TimePicker view, int hourOfDay, int minute){
			_savePref_Time(hourOfDay, minute);
			mHour = hourOfDay;
			mMinute = minute;
			_showTimeDisplay();
			
			globalVariable.is2ndTimeGetIn = false; // 為了讓喝水事件不要一設定完，時間還沒到就先偷跑一次
			
			Intent receiverIntent = new Intent(drink.this, drink_alarmReceiver.class);
			PendingIntent sender = PendingIntent.getBroadcast(drink.this, 1, receiverIntent, 0);
			
			
			AlarmManager am;
			am = (AlarmManager) getSystemService(ALARM_SERVICE);
			am.cancel(sender);
			
			long lCurrentTimeMillis = System.currentTimeMillis();
			int times = (hourOfDay * 60 + minute) * 60 * 1000;
			Calendar calendar = Calendar.getInstance();
			
			///// 為了算出幾點幾分 Hour:Min 要存在pref中，讓主頁計算最近的事件
			long lTimeMillis = lCurrentTimeMillis + times;
			calendar.setTimeInMillis(lTimeMillis);
//			publicFun.showToast(drink.this, String.format("%d : %d", 
//					calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE)));
			pref.SaveDrinkTimeHourValue(drink.this, calendar.get(Calendar.HOUR_OF_DAY));
			pref.SaveDrinkTimeMinuteValue(drink.this, calendar.get(Calendar.MINUTE));
			/////
			
			calendar.setTimeInMillis(lCurrentTimeMillis);
			long triggerTime = calendar.getTimeInMillis();
		
			am.setRepeating(AlarmManager.RTC_WAKEUP, triggerTime, times, sender);
//			publicFun.showToast(drink.this, String.format("%d, %d, times:%d", hourOfDay, minute, times));
			
			

		}
		
//		public void onTimeChanged(TimePicker view, int hour, int minute){
//			if (mTpd != null) mTpd.setTitle("間隔時間設定");
//		}
	}
	
	private class CListener_mBellSwitch implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mBellSwitch::onClick");
			pref.SaveDrinkBellCheckedValue(drink.this, mBellSwitch.isChecked());
		}
	}	
	
	private class CListener_mVibrationSwitch implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mVibrationSwitch::onClick");
			pref.SaveDrinkVibrationCheckedValue(drink.this, mVibrationSwitch.isChecked());
		}
	}	
	// Public的函式放在最後面，函式名稱使用小寫字母開頭命名
	/**  
	 * 當目前的Activity啟動時，這個函式就會被呼叫
	 * 
	 * @param savedInstanceState 前一次activity的凍結狀態
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drink);
        
		_findViews();

		_initialData();

		_setListeners();
			
    }

    /**  
	 * 當Menu被建立時，這個函式就會被呼叫
	 * 
	 * @param menu 目前的menu傳入
	 */    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.drink_menu, menu);
    	return true;
    }
    
	/**  
	 * 當Menu Item被選取時，這個函式就會被呼叫
	 * 
	 * @param item 目前被選取的MenuItem
	 */   
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch(item.getItemId()){
    	case R.id.mit_drink_info:
			Intent intent = new Intent();
			intent.setClass(drink.this, drink_info.class);
			
			startActivity(intent);	
    		break;
//    	case R.id.mit_about:
//			Uri uri = Uri.parse(getString(R.string.SID_about_site));
//			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//			startActivity(intent);
//    		break;
//    	case R.id.mit_exit:
//    		finish();
//    		break;
    	}
    	return super.onOptionsItemSelected(item);
    }

}