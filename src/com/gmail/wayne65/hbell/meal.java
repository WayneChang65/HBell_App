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
 * meal類別
 * Health Bell的主要畫面
 *
 * @author Wayne Chang
 * @author wayne65@gmail.com
 * @version 1.0.0
 */
public class meal extends Activity {
	private String mLogTag;			// Debug時使用的Log Tag，顯示類別名稱
	private LinearLayout mTime_breakfast, mTime_lunch, mTime_dinner;
	private TextView mTimeDisplay_breakfast, mTimeDisplay_lunch, mTimeDisplay_dinner;
	private int mHour_breakfast, mHour_lunch, mHour_dinner;
	private int mMinute_breakfast, mMinute_lunch, mMinute_dinner;
	private CheckBox mBellSwitch;
	private CheckBox mVibrationSwitch;
	private CheckBox mTextSwitch;
	
	// private 函式命名，使用底線開頭並且第一字母小寫
	/**
	 * 找到資源檔對應的ID，並且連結到相關資源檔位址
	 */
	private void _findViews() {
		mLogTag = meal.class.getSimpleName();
		mTime_breakfast = (LinearLayout) findViewById(R.id.ll_meal_time_breakfast);
		mTime_lunch = (LinearLayout) findViewById(R.id.ll_meal_time_lunch);
		mTime_dinner = (LinearLayout) findViewById(R.id.ll_meal_time_dinner);

		mTimeDisplay_breakfast = (TextView) findViewById(R.id.txv_meal_breakfast_time_display);
		mTimeDisplay_lunch = (TextView) findViewById(R.id.txv_meal_lunch_time_display);
		mTimeDisplay_dinner = (TextView) findViewById(R.id.txv_meal_dinner_time_display);
		
		mBellSwitch = (CheckBox) findViewById(R.id.cbx_meal_alerttype_bell);
		mVibrationSwitch = (CheckBox) findViewById(R.id.cbx_meal_alerttype_vibration);
		mTextSwitch = (CheckBox) findViewById(R.id.cbx_meal_alerttype_text);
	}	

	/**
	 * 初始化顯示元件的資料
	 */
	private void _initialData() {
		_loadPref_Time();
		_showTimeDisplay_breakfast();
		_showTimeDisplay_lunch();
		_showTimeDisplay_dinner();
		
		mTextSwitch.setChecked(true);
		mTextSwitch.setEnabled(false);
	}	

	/**
	 * 訂閱所有元件感興趣的事件
	 */
	private void _setListeners() {
		CListener_mTime_breakfast listener_mTime_breakfast = new CListener_mTime_breakfast();
		CListener_mTime_lunch listener_mTime_lunch = new CListener_mTime_lunch();
		CListener_mTime_dinner listener_mTime_dinner = new CListener_mTime_dinner();
		CListener_mBellSwitch listener_mBellSwitch = new CListener_mBellSwitch();
		CListener_mVibrationSwitch listener_mVibrationSwitch = new CListener_mVibrationSwitch();
		
		
		mTime_breakfast.setOnClickListener(listener_mTime_breakfast);
		mTime_lunch.setOnClickListener(listener_mTime_lunch);
		mTime_dinner.setOnClickListener(listener_mTime_dinner);
		
		mBellSwitch.setOnClickListener(listener_mBellSwitch);
		mVibrationSwitch.setOnClickListener(listener_mVibrationSwitch);
	}	

	private void _loadPref_Time() {
		mHour_breakfast = pref.LoadMealBreakfastTimeHourValue(this);
		mMinute_breakfast = pref.LoadMealBreakfastTimeMinuteValue(this);
		mHour_lunch = pref.LoadMealLunchTimeHourValue(this);
		mMinute_lunch = pref.LoadMealLunchTimeMinuteValue(this);
		mHour_dinner = pref.LoadMealDinnerTimeHourValue(this);
		mMinute_dinner = pref.LoadMealDinnerTimeMinuteValue(this);
		
		mBellSwitch.setChecked(pref.LoadMealBellCheckedValue(this));
		mVibrationSwitch.setChecked(pref.LoadMealVibrationCheckedValue(this));
	}
	
	private void _savePref_BreakfastTime(int iHour, int iMinute) {
		pref.SaveMealBreakfastTimeHourValue(this, iHour);
		pref.SaveMealBreakfastTimeMinuteValue(this, iMinute);
	}
	
	private void _savePref_LunchTime(int iHour, int iMinute) {
		pref.SaveMealLunchTimeHourValue(this, iHour);
		pref.SaveMealLunchTimeMinuteValue(this, iMinute);
	}
	
	private void _savePref_DinnerTime(int iHour, int iMinute) {
		pref.SaveMealDinnerTimeHourValue(this, iHour);
		pref.SaveMealDinnerTimeMinuteValue(this, iMinute);
	}
	
	private void _showTimeDisplay_breakfast(){
		String strTime, strAMPM;
		if (mHour_breakfast >= 0 && mHour_breakfast <= 11){
			strAMPM = "上午";
		}else{
			strAMPM = "下午";
			mHour_breakfast -= 12;
		}
		if (mHour_breakfast == 0) mHour_breakfast = 12;
		strTime = strAMPM + "  " + mHour_breakfast + ":" + mMinute_breakfast;
		mTimeDisplay_breakfast.setText(strTime);
	}
	
	private void _showTimeDisplay_lunch(){
		String strTime, strAMPM;
		if (mHour_lunch >= 0 && mHour_lunch <= 11){
			strAMPM = "上午";
		}else{
			strAMPM = "下午";
			mHour_lunch -= 12;
		}
		if (mHour_lunch == 0) mHour_lunch = 12;
		strTime = strAMPM + "  " + mHour_lunch + ":" + mMinute_lunch;
		mTimeDisplay_lunch.setText(strTime);
	}
	
	private void _showTimeDisplay_dinner(){
		String strTime, strAMPM;
		if (mHour_dinner >= 0 && mHour_dinner <= 11){
			strAMPM = "上午";
		}else{
			strAMPM = "下午";
			mHour_dinner -= 12;
		}
		if (mHour_dinner == 0) mHour_dinner = 12;
		strTime = strAMPM + "  " + mHour_dinner + ":" + mMinute_dinner;
		mTimeDisplay_dinner.setText(strTime);
	}
	
	// Inner classes
	// 除了專案的主要類別不用C開頭之外，內部的類別通通以C為prefix
	private class CListener_mTime_breakfast implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mTime_breakfast::onClick");
			
			_loadPref_Time();
			CListener_timePicker_breakfast listener_timePicker = new CListener_timePicker_breakfast();
			new TimePickerDialog(meal.this, listener_timePicker, mHour_breakfast, mMinute_breakfast, false).show();
		}
	}	

	private class CListener_mTime_lunch implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mTime_lunch::onClick");
			
			_loadPref_Time();
			CListener_timePicker_lunch listener_timePicker = new CListener_timePicker_lunch();
			new TimePickerDialog(meal.this, listener_timePicker, mHour_lunch, mMinute_lunch, false).show();
		}
	}	

	private class CListener_mTime_dinner implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mTime_dinner::onClick");
			
			_loadPref_Time();
			CListener_timePicker_dinner listener_timePicker = new CListener_timePicker_dinner();
			new TimePickerDialog(meal.this, listener_timePicker, mHour_dinner, mMinute_dinner, false).show();
		}
	}	
	
	
	private class CListener_timePicker_breakfast implements TimePickerDialog.OnTimeSetListener{
		public void onTimeSet(TimePicker view, int hourOfDay, int minute){
			_savePref_BreakfastTime(hourOfDay, minute);
			mHour_breakfast = hourOfDay;
			mMinute_breakfast = minute;
			_showTimeDisplay_breakfast();

			Intent receiverIntent = new Intent(meal.this, meal_alarmReceiver_breakfast.class);
			PendingIntent sender = PendingIntent.getBroadcast(meal.this, 1, receiverIntent, 0);
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

	private class CListener_timePicker_lunch implements TimePickerDialog.OnTimeSetListener{
		public void onTimeSet(TimePicker view, int hourOfDay, int minute){
			_savePref_LunchTime(hourOfDay, minute);
			mHour_lunch = hourOfDay;
			mMinute_lunch = minute;
			_showTimeDisplay_lunch();

			Intent receiverIntent = new Intent(meal.this, meal_alarmReceiver_lunch.class);
			PendingIntent sender = PendingIntent.getBroadcast(meal.this, 1, receiverIntent, 0);
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

	private class CListener_timePicker_dinner implements TimePickerDialog.OnTimeSetListener{
		public void onTimeSet(TimePicker view, int hourOfDay, int minute){
			_savePref_DinnerTime(hourOfDay, minute);
			mHour_dinner = hourOfDay;
			mMinute_dinner = minute;
			_showTimeDisplay_dinner();

			Intent receiverIntent = new Intent(meal.this, meal_alarmReceiver_dinner.class);
			PendingIntent sender = PendingIntent.getBroadcast(meal.this, 1, receiverIntent, 0);
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
			pref.SaveMealBellCheckedValue(meal.this, mBellSwitch.isChecked());
		}
	}	
	
	private class CListener_mVibrationSwitch implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mVibrationSwitch::onClick");
			pref.SaveMealVibrationCheckedValue(meal.this, mVibrationSwitch.isChecked());
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
        setContentView(R.layout.meal);
        
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
    	inflater.inflate(R.menu.meal_menu, menu);
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
    	case R.id.mit_meal_info:
			Intent intent = new Intent();
			intent.setClass(meal.this, meal_info.class);
			
			startActivity(intent);	
    		break;
 //   	case R.id.mit_main_about:
  //  		unregisterReceiver(drink_alarmReceiver.this.);
 //   		break;
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