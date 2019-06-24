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
 * sport類別
 * Health Bell的主要畫面
 *
 * @author Wayne Chang
 * @author wayne65@gmail.com
 * @version 1.0.0
 */
public class sport extends Activity {
	private String mLogTag;			// Debug時使用的Log Tag，顯示類別名稱
	private LinearLayout mTime_1, mTime_2, mTime_3;
	private TextView mTimeDisplay_1, mTimeDisplay_2, mTimeDisplay_3;
	private int mHour_1, mHour_2, mHour_3;
	private int mMinute_1, mMinute_2, mMinute_3;
	private CheckBox mBellSwitch;
	private CheckBox mVibrationSwitch;
	private CheckBox mTextSwitch;
	private TextView mDescription_1, mDescription_2, mDescription_3;
	
	// private 函式命名，使用底線開頭並且第一字母小寫
	/**
	 * 找到資源檔對應的ID，並且連結到相關資源檔位址
	 */
	private void _findViews() {
		mLogTag = sport.class.getSimpleName();
		mTime_1 = (LinearLayout) findViewById(R.id.ll_sport_time_time1);
		mTime_2 = (LinearLayout) findViewById(R.id.ll_sport_time_time2);
		mTime_3 = (LinearLayout) findViewById(R.id.ll_sport_time_time3);

		mTimeDisplay_1 = (TextView) findViewById(R.id.txv_sport_time1_time_display);
		mTimeDisplay_2 = (TextView) findViewById(R.id.txv_sport_time2_time_display);
		mTimeDisplay_3 = (TextView) findViewById(R.id.txv_sport_time3_time_display);
		
		mDescription_1 = (TextView) findViewById(R.id.txv_sport_time1_time_description);
		mDescription_2 = (TextView) findViewById(R.id.txv_sport_time2_time_description);
		mDescription_3 = (TextView) findViewById(R.id.txv_sport_time3_time_description);
		
		mBellSwitch = (CheckBox) findViewById(R.id.cbx_sport_alerttype_bell);
		mVibrationSwitch = (CheckBox) findViewById(R.id.cbx_sport_alerttype_vibration);
		mTextSwitch = (CheckBox) findViewById(R.id.cbx_sport_alerttype_text);
	}	

	/**
	 * 初始化顯示元件的資料
	 */
	private void _initialData() {
		_loadPref_Time();
		_showTimeDisplay_time1();
		_showTimeDisplay_time2();
		_showTimeDisplay_time3();
		
		mTextSwitch.setChecked(true);
		mTextSwitch.setEnabled(false);
	}	

	/**
	 * 訂閱所有元件感興趣的事件
	 */
	private void _setListeners() {
		CListener_mTime_time1 listener_mTime_time1 = new CListener_mTime_time1();
		CListener_mTime_time2 listener_mTime_time2 = new CListener_mTime_time2();
		CListener_mTime_time3 listener_mTime_time3 = new CListener_mTime_time3();
		CListener_mBellSwitch listener_mBellSwitch = new CListener_mBellSwitch();
		CListener_mVibrationSwitch listener_mVibrationSwitch = new CListener_mVibrationSwitch();
		
		
		mTime_1.setOnClickListener(listener_mTime_time1);
		mTime_2.setOnClickListener(listener_mTime_time2);
		mTime_3.setOnClickListener(listener_mTime_time3);
		
		mBellSwitch.setOnClickListener(listener_mBellSwitch);
		mVibrationSwitch.setOnClickListener(listener_mVibrationSwitch);
	}	

	private void _loadPref_Time() {
		mHour_1 = pref.LoadSportTime1TimeHourValue(this);
		mMinute_1 = pref.LoadSportTime1TimeMinuteValue(this);
		mHour_2 = pref.LoadSportTime2TimeHourValue(this);
		mMinute_2 = pref.LoadSportTime2TimeMinuteValue(this);
		mHour_3 = pref.LoadSportTime3TimeHourValue(this);
		mMinute_3 = pref.LoadSportTime3TimeMinuteValue(this);
		
		mBellSwitch.setChecked(pref.LoadSportBellCheckedValue(this));
		mVibrationSwitch.setChecked(pref.LoadSportVibrationCheckedValue(this));
	}
	
	private void _savePref_Time1Time(int iHour, int iMinute) {
		pref.SaveSportTime1TimeHourValue(this, iHour);
		pref.SaveSportTime1TimeMinuteValue(this, iMinute);
	}
	
	private void _savePref_Time2Time(int iHour, int iMinute) {
		pref.SaveSportTime2TimeHourValue(this, iHour);
		pref.SaveSportTime2TimeMinuteValue(this, iMinute);
	}
	
	private void _savePref_Time3Time(int iHour, int iMinute) {
		pref.SaveSportTime3TimeHourValue(this, iHour);
		pref.SaveSportTime3TimeMinuteValue(this, iMinute);
	}
	
	private void _showTimeDisplay_time1(){
		String strTime, strAMPM;
		if (mHour_1 >= 0 && mHour_1 <= 11){
			strAMPM = "上午";
		}else{
			strAMPM = "下午";
			mHour_1 -= 12;
		}
		if (mHour_1 == 0) mHour_1 = 12;
		strTime = strAMPM + "  " + mHour_1 + ":" + mMinute_1;
		mTimeDisplay_1.setText(strTime);
		mDescription_1.setText(pref.LoadSportTime1DescriptionValue(sport.this));
	}
	
	private void _showTimeDisplay_time2(){
		String strTime, strAMPM;
		if (mHour_2 >= 0 && mHour_2 <= 11){
			strAMPM = "上午";
		}else{
			strAMPM = "下午";
			mHour_2 -= 12;
		}
		if (mHour_2 == 0) mHour_2 = 12;
		strTime = strAMPM + "  " + mHour_2 + ":" + mMinute_2;
		mTimeDisplay_2.setText(strTime);
		mDescription_2.setText(pref.LoadSportTime2DescriptionValue(sport.this));
	}
	
	private void _showTimeDisplay_time3(){
		String strTime, strAMPM;
		if (mHour_3 >= 0 && mHour_3 <= 11){
			strAMPM = "上午";
		}else{
			strAMPM = "下午";
			mHour_3 -= 12;
		}
		if (mHour_3 == 0) mHour_3 = 12;
		strTime = strAMPM + "  " + mHour_3 + ":" + mMinute_3;
		mTimeDisplay_3.setText(strTime);
		mDescription_3.setText(pref.LoadSportTime3DescriptionValue(sport.this));
	}
	
	// Inner classes
	// 除了專案的主要類別不用C開頭之外，內部的類別通通以C為prefix
	private class CListener_mTime_time1 implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mTime_time1::onClick");
			
			_loadPref_Time();
			CListener_timePicker_time1 listener_timePicker = new CListener_timePicker_time1();
			new TimePickerDialog(sport.this, listener_timePicker, mHour_1, mMinute_1, false).show();
		}
	}	

	private class CListener_mTime_time2 implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mTime_time2::onClick");
			
			_loadPref_Time();
			CListener_timePicker_time2 listener_timePicker = new CListener_timePicker_time2();
			new TimePickerDialog(sport.this, listener_timePicker, mHour_2, mMinute_2, false).show();
		}
	}	

	private class CListener_mTime_time3 implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mTime_time3::onClick");
			
			_loadPref_Time();
			CListener_timePicker_time3 listener_timePicker = new CListener_timePicker_time3();
			new TimePickerDialog(sport.this, listener_timePicker, mHour_3, mMinute_3, false).show();
		}
	}	
	
	
	private class CListener_timePicker_time1 implements TimePickerDialog.OnTimeSetListener{
		public void onTimeSet(TimePicker view, int hourOfDay, int minute){
			_savePref_Time1Time(hourOfDay, minute);
			mHour_1 = hourOfDay;
			mMinute_1 = minute;
			_showTimeDisplay_time1();

			Intent receiverIntent = new Intent(sport.this, sport_alarmReceiver_time1.class);
			PendingIntent sender = PendingIntent.getBroadcast(sport.this, 1, receiverIntent, 0);
			AlarmManager am;
			am = (AlarmManager) getSystemService(ALARM_SERVICE);
			am.cancel(sender);
			int times = 24 * 60 * 60 * 1000;
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
			calendar.set(Calendar.MINUTE, minute);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);

			long triggerTime = calendar.getTimeInMillis();

			am.setRepeating(AlarmManager.RTC_WAKEUP, triggerTime, times, sender);
		}
	}

	private class CListener_timePicker_time2 implements TimePickerDialog.OnTimeSetListener{
		public void onTimeSet(TimePicker view, int hourOfDay, int minute){
			_savePref_Time2Time(hourOfDay, minute);
			mHour_2 = hourOfDay;
			mMinute_2 = minute;
			_showTimeDisplay_time2();

			Intent receiverIntent = new Intent(sport.this, sport_alarmReceiver_time2.class);
			PendingIntent sender = PendingIntent.getBroadcast(sport.this, 1, receiverIntent, 0);
			AlarmManager am;
			am = (AlarmManager) getSystemService(ALARM_SERVICE);
			am.cancel(sender);
			int times = 24 * 60 * 60 * 1000;
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
			calendar.set(Calendar.MINUTE, minute);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);

			long triggerTime = calendar.getTimeInMillis();

			am.setRepeating(AlarmManager.RTC_WAKEUP, triggerTime, times, sender);
		}
	}

	private class CListener_timePicker_time3 implements TimePickerDialog.OnTimeSetListener{
		public void onTimeSet(TimePicker view, int hourOfDay, int minute){
			_savePref_Time3Time(hourOfDay, minute);
			mHour_3 = hourOfDay;
			mMinute_3 = minute;
			_showTimeDisplay_time3();

			Intent receiverIntent = new Intent(sport.this, sport_alarmReceiver_time3.class);
			PendingIntent sender = PendingIntent.getBroadcast(sport.this, 1, receiverIntent, 0);
			AlarmManager am;
			am = (AlarmManager) getSystemService(ALARM_SERVICE);
			am.cancel(sender);
			int times = 24 * 60 * 60 * 1000;
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
			calendar.set(Calendar.MINUTE, minute);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);

			long triggerTime = calendar.getTimeInMillis();

			am.setRepeating(AlarmManager.RTC_WAKEUP, triggerTime, times, sender);
		}
	}

	
	private class CListener_mBellSwitch implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mBellSwitch::onClick");
			pref.SaveSportBellCheckedValue(sport.this, mBellSwitch.isChecked());
		}
	}	
	
	private class CListener_mVibrationSwitch implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mVibrationSwitch::onClick");
			pref.SaveSportVibrationCheckedValue(sport.this, mVibrationSwitch.isChecked());
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
        setContentView(R.layout.sport);
        
		_findViews();

		_initialData();

		_setListeners();
			
    }

    
	@Override
	protected void onResume() {
		_initialData();
		super.onResume();
	}

	/**  
	 * 當Menu被建立時，這個函式就會被呼叫
	 * 
	 * @param menu 目前的menu傳入
	 */    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.sport_menu, menu);
    	return true;
    }
    
	/**  
	 * 當Menu Item被選取時，這個函式就會被呼叫
	 * 
	 * @param item 目前被選取的MenuItem
	 */   
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
		Intent intent = new Intent();

    	switch(item.getItemId()){
    	case R.id.mit_sport_setting:
    		intent.setClass(sport.this, sport_setting_dlg.class);
			
			startActivity(intent);
//	  		sport_setting_dlg dlg = new sport_setting_dlg(sport.this);
//	  		dlg.setTitle("運動提醒說明設定");
//	  		dlg.show();
    		break;
    	case R.id.mit_sport_info:
    		intent.setClass(sport.this, sport_info.class);
			
			startActivity(intent);

//  		unregisterReceiver(drink_alarmReceiver.this.);
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