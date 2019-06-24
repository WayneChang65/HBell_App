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
 * getup���O
 * Health Bell���D�n�e��
 *
 * @author Wayne Chang
 * @author wayne65@gmail.com
 * @version 1.0.0
 */
public class getup extends Activity {
	private String mLogTag;			// Debug�ɨϥΪ�Log Tag�A������O�W��
	private LinearLayout mTime;
	private TextView mTimeDisplay;
	private int mHour;
	private int mMinute;
	private CheckBox mBellSwitch;
	private CheckBox mVibrationSwitch;
	private CheckBox mTextSwitch;
	
	// private �禡�R�W�A�ϥΩ��u�}�Y�åB�Ĥ@�r���p�g
	/**
	 * ���귽�ɹ�����ID�A�åB�s��������귽�ɦ�}
	 */
	private void _findViews() {
		mLogTag = getup.class.getSimpleName();
		mTime = (LinearLayout) findViewById(R.id.ll_getup_time);
		mTimeDisplay = (TextView) findViewById(R.id.txv_getup_time_display);
		mBellSwitch = (CheckBox) findViewById(R.id.cbx_getup_alerttype_bell);
		mVibrationSwitch = (CheckBox) findViewById(R.id.cbx_getup_alerttype_vibration);
		mTextSwitch = (CheckBox) findViewById(R.id.cbx_getup_alerttype_text);
	}	

	/**
	 * ��l����ܤ��󪺸��
	 */
	private void _initialData() {
		_loadPref_Time();
		_showTimeDisplay();
		
		mTextSwitch.setChecked(true);
		mTextSwitch.setEnabled(false);
	}	

	/**
	 * �q�\�Ҧ�����P���쪺�ƥ�
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
		mHour = pref.LoadGetupTimeHourValue(this);
		mMinute = pref.LoadGetupTimeMinuteValue(this);
		
		mBellSwitch.setChecked(pref.LoadGetupBellCheckedValue(this));
		mVibrationSwitch.setChecked(pref.LoadGetupVibrationCheckedValue(this));
	}
	
	private void _savePref_Time(int iHour, int iMinute) {
		pref.SaveGetupTimeHourValue(this, iHour);
		pref.SaveGetupTimeMinuteValue(this, iMinute);
	}
	
	private void _showTimeDisplay(){
		String strTime, strAMPM;
		if (mHour >= 0 && mHour <= 11){
			strAMPM = "�W��";
		}else{
			strAMPM = "�U��";
			mHour -= 12;
		}
		if (mHour == 0) mHour = 12;
		strTime = strAMPM + "  " + mHour + ":" + mMinute;
		mTimeDisplay.setText(strTime);
	}
	
	
	// Inner classes
	// ���F�M�ת��D�n���O����C�}�Y���~�A���������O�q�q�HC��prefix
	private class CListener_mTime implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mTime::onClick");
			
			_loadPref_Time();
			CListener_timePicker listener_timePicker = new CListener_timePicker();
			new TimePickerDialog(getup.this, listener_timePicker, mHour, mMinute, false).show();
		}
	}	

	
	private class CListener_timePicker implements TimePickerDialog.OnTimeSetListener{
		public void onTimeSet(TimePicker view, int hourOfDay, int minute){
			_savePref_Time(hourOfDay, minute);
			mHour = hourOfDay;
			mMinute = minute;
			_showTimeDisplay();

			Intent receiverIntent = new Intent(getup.this, getup_alarmReceiver.class);
			PendingIntent sender = PendingIntent.getBroadcast(getup.this, 1, receiverIntent, 0);
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
			pref.SaveGetupBellCheckedValue(getup.this, mBellSwitch.isChecked());
		}
	}	
	
	private class CListener_mVibrationSwitch implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mVibrationSwitch::onClick");
			pref.SaveGetupVibrationCheckedValue(getup.this, mVibrationSwitch.isChecked());
		}
	}	
	// Public���禡��b�̫᭱�A�禡�W�٨ϥΤp�g�r���}�Y�R�W
	/**  
	 * ��ثe��Activity�ҰʮɡA�o�Ө禡�N�|�Q�I�s
	 * 
	 * @param savedInstanceState �e�@��activity���ᵲ���A
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getup);
        
		_findViews();

		_initialData();

		_setListeners();
		
		globalVariable.getup_context = this;
		
    }

    /**  
	 * ��Menu�Q�إ߮ɡA�o�Ө禡�N�|�Q�I�s
	 * 
	 * @param menu �ثe��menu�ǤJ
	 */    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.getup_menu, menu);
    	return true;
    }
    
	/**  
	 * ��Menu Item�Q����ɡA�o�Ө禡�N�|�Q�I�s
	 * 
	 * @param item �ثe�Q�����MenuItem
	 */   
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch(item.getItemId()){
    	case R.id.mit_getup_info:
			Intent intent = new Intent();
			intent.setClass(getup.this, getup_info.class);
			
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