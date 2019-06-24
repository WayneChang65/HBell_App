package com.gmail.wayne65.hbell;

import java.util.Calendar;


import android.app.Activity;
import android.content.Intent;
//import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.LightingColorFilter;


/**
 * main���O
 * Health Bell���D�n�e��
 *
 * @author Wayne Chang
 * @author wayne65@gmail.com
 * @version 1.0.0
 */
public class main extends Activity {
	private String mLogTag;			// Debug�ɨϥΪ�Log Tag�A������O�W��
//	private int mCount = 0;
	private ImageButton mGetup;
	private ImageButton mSleep;
	private ImageButton mMeal;
	private ImageButton mDrink;
	private ImageButton mMedic;
	private ImageButton mSport;
	
	private TextView mGirlSpeak;
	private ImageView mGirlStatus;
//	private ImageView mGirlSpeakWnd;
	
	private AbsoluteLayout mMainBackground;
	
	private int mCurrentAlert = 0;
	Handler mHandler = new Handler();
	Runnable mTask;
	
//	private Timer mTimerChangGirlMood = new Timer();

	
	// private �禡�R�W�A�ϥΩ��u�}�Y�åB�Ĥ@�r���p�g
	/**
	 * ���귽�ɹ�����ID�A�åB�s��������귽�ɦ�}
	 */
	private void _findViews() {
		mLogTag = main.class.getSimpleName();
		
		mGetup = (ImageButton) findViewById(R.id.ibt_main_getup);
		mSleep = (ImageButton) findViewById(R.id.ibt_main_sleep);
		mMeal = (ImageButton) findViewById(R.id.ibt_main_meal);
		mDrink = (ImageButton) findViewById(R.id.ibt_main_drink);
		mMedic = (ImageButton) findViewById(R.id.ibt_main_medic);
		mSport = (ImageButton) findViewById(R.id.ibt_main_sport);
		
		mGirlSpeak = (TextView) findViewById(R.id.txv_girl_comment);
		mGirlStatus = (ImageView) findViewById(R.id.imv_main_girl);
//		mGirlSpeakWnd = (ImageView) findViewById(R.id.imv_main_girl_comment);
		
		mMainBackground = (AbsoluteLayout) findViewById(R.id.al_main_bg);
	}	

	/**
	 * ��l����ܤ��󪺸��
	 */
	private void _initialData() {
		//mGetup.setAlpha(50);
		//mGetup.setBackgroundColor(0xff444444);
		//mGetup.setBackgroundResource(R.drawable.bg_drink);
		
		if (pref.LoadMainSwitchGetupValue(main.this) == true){
			mGetup.clearColorFilter();
			mGetup.setAlpha(255);
			mGetup.setEnabled(true);
		}else{
    		LightingColorFilter lcf = new LightingColorFilter(/*0xFF00FFFF*/0xFF333333, /*0x000000FF*/ 0);
    		mGetup.setColorFilter(lcf);
    		mGetup.setAlpha(90);
    		mGetup.setEnabled(false);
		}
		
		if (pref.LoadMainSwitchSleepValue(main.this) == true){
			mSleep.clearColorFilter();
			mSleep.setAlpha(255);
			mSleep.setEnabled(true);
		}else{
    		LightingColorFilter lcf = new LightingColorFilter(/*0xFF00FFFF*/0xFF333333, /*0x000000FF*/ 0);
    		mSleep.setColorFilter(lcf);
    		mSleep.setAlpha(90);
    		mSleep.setEnabled(false);
		}
		
		if (pref.LoadMainSwitchMealValue(main.this) == true){
			mMeal.clearColorFilter();
			mMeal.setAlpha(255);
			mMeal.setEnabled(true);
		}else{
    		LightingColorFilter lcf = new LightingColorFilter(/*0xFF00FFFF*/0xFF333333, /*0x000000FF*/ 0);
    		mMeal.setColorFilter(lcf);
    		mMeal.setAlpha(90);
    		mMeal.setEnabled(false);
		}		

		if (pref.LoadMainSwitchDrinkValue(main.this) == true){
			mDrink.clearColorFilter();
			mDrink.setAlpha(255);
			mDrink.setEnabled(true);
		}else{
    		LightingColorFilter lcf = new LightingColorFilter(/*0xFF00FFFF*/0xFF333333, /*0x000000FF*/ 0);
    		mDrink.setColorFilter(lcf);
    		mDrink.setAlpha(90);
    		mDrink.setEnabled(false);
		}
		
		if (pref.LoadMainSwitchMedicValue(main.this) == true){
			mMedic.clearColorFilter();
			mMedic.setAlpha(255);
			mMedic.setEnabled(true);
		}else{
    		LightingColorFilter lcf = new LightingColorFilter(/*0xFF00FFFF*/0xFF333333, /*0x000000FF*/ 0);
    		mMedic.setColorFilter(lcf);
    		mMedic.setAlpha(90);
    		mMedic.setEnabled(false);
		}
		
		if (pref.LoadMainSwitchSportValue(main.this) == true){
			mSport.clearColorFilter();
			mSport.setAlpha(255);
			mSport.setEnabled(true);
		}else{
    		LightingColorFilter lcf = new LightingColorFilter(/*0xFF00FFFF*/0xFF333333, /*0x000000FF*/ 0);
    		mSport.setColorFilter(lcf);
    		mSport.setAlpha(90);
    		mSport.setEnabled(false);
		}
	}	

	/**
	 * �q�\�Ҧ�����P���쪺�ƥ�
	 */
	private void _setListeners() {
		CListener_mGetup listener_mGetup = new CListener_mGetup();
		CListener_mSleep listener_mSleep = new CListener_mSleep();
		CListener_mMeal listener_mMeal = new CListener_mMeal();
		CListener_mDrink listener_mDrink = new CListener_mDrink();
		CListener_mMedic listener_mMedic = new CListener_mMedic();
		CListener_mSport listener_mSport = new CListener_mSport();
		
		mGetup.setOnClickListener(listener_mGetup);
		mSleep.setOnClickListener(listener_mSleep);
		mMeal.setOnClickListener(listener_mMeal);
		mDrink.setOnClickListener(listener_mDrink);
		mMedic.setOnClickListener(listener_mMedic);
		mSport.setOnClickListener(listener_mSport);
	}	
	
	
	private int _getNextAlert(){
///		String strMsg = "";
		long lTimeDifferenceInMillis[] = new long[13];
		long timeSetInMillis[] = new long[13];
		long minDifference = 0;
		int theNextAlert = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());

		try {
			timeSetInMillis[0] = (calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE)) * 60 * 1000;
			timeSetInMillis[1] = (pref.LoadGetupTimeHourValue(main.this) * 60 + pref
					.LoadGetupTimeMinuteValue(main.this)) * 60 * 1000;
			timeSetInMillis[2] = (pref.LoadSleepTimeHourValue(main.this) * 60 + pref
					.LoadSleepTimeMinuteValue(main.this)) * 60 * 1000;
			timeSetInMillis[3] = (pref
					.LoadMealBreakfastTimeHourValue(main.this) * 60 + pref
					.LoadMealBreakfastTimeMinuteValue(main.this)) * 60 * 1000;
			timeSetInMillis[4] = (pref
					.LoadMealLunchTimeHourValue(main.this) * 60 + pref
					.LoadMealLunchTimeMinuteValue(main.this)) * 60 * 1000;
			timeSetInMillis[5] = (pref
					.LoadMealDinnerTimeHourValue(main.this) * 60 + pref
					.LoadMealDinnerTimeMinuteValue(main.this)) * 60 * 1000;
			timeSetInMillis[6] = (pref.LoadDrinkTimeHourValue(main.this) * 60 + pref
					.LoadDrinkTimeMinuteValue(main.this)) * 60 * 1000;
			timeSetInMillis[7] = (pref
					.LoadMedicTime1TimeHourValue(main.this) * 60 + pref
					.LoadMedicTime1TimeMinuteValue(main.this)) * 60 * 1000;
			timeSetInMillis[8] = (pref
					.LoadMedicTime2TimeHourValue(main.this) * 60 + pref
					.LoadMedicTime2TimeMinuteValue(main.this)) * 60 * 1000;
			timeSetInMillis[9] = (pref
					.LoadMedicTime3TimeHourValue(main.this) * 60 + pref
					.LoadMedicTime3TimeMinuteValue(main.this)) * 60 * 1000;
			timeSetInMillis[10] = (pref
					.LoadSportTime1TimeHourValue(main.this) * 60 + pref
					.LoadSportTime1TimeMinuteValue(main.this)) * 60 * 1000;
			timeSetInMillis[11] = (pref
					.LoadSportTime2TimeHourValue(main.this) * 60 + pref
					.LoadSportTime2TimeMinuteValue(main.this)) * 60 * 1000;
			timeSetInMillis[12] = (pref
					.LoadSportTime3TimeHourValue(main.this) * 60 + pref
					.LoadSportTime3TimeMinuteValue(main.this)) * 60 * 1000;

			for (int i = 1; i <= 12; i++) {
				lTimeDifferenceInMillis[i] = timeSetInMillis[i]	- timeSetInMillis[0];
				if (lTimeDifferenceInMillis[i] < 0)
					lTimeDifferenceInMillis[i] = 0;
			}

			for (int i = 1; i <= 12; i++) {
				if (lTimeDifferenceInMillis[i] == 0) {
					continue;
				}
				
				if (minDifference == 0){
					minDifference = lTimeDifferenceInMillis[i];
					theNextAlert = i;
				}
				
				if ((lTimeDifferenceInMillis[i] > 0) && (lTimeDifferenceInMillis[i] < minDifference)) {
					minDifference = lTimeDifferenceInMillis[i];
					theNextAlert = i;
				}
			}
		} catch (Exception obj) {
//			publicFun.showToast(main.this, obj.getMessage());
			obj.printStackTrace();
		}
		
//		strMsg = String.format("%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d", 
//				getupTime.iHour, sleepTime.iHour, mealTime1.iHour, mealTime2.iHour, mealTime3.iHour,
//				drinkTime.iHour, medicTime1.iHour, medicTime2.iHour, medicTime3.iHour,
//				sportTime1.iHour, sportTime2.iHour, sportTime3.iHour);
		
//		publicFun.showToast(main.this, strMsg);
		
		return theNextAlert;
	}
	
	private String _showTimeDisplay(int iHour, int iMinute){
		String strTime, strAMPM;
		if (iHour >= 0 && iHour <= 11){
			strAMPM = "�W��";
		}else{
			strAMPM = "�U��";
			iHour -= 12;
		}
		if (iHour == 0) iHour = 12;
		strTime = strAMPM + "  " + iHour + ":" + iMinute;
		return strTime;
	}
	
	private void _taskHandler(){
   		mTask = new Runnable() {
			public void run() {
				int theNextAlert = _getNextAlert();

				if (mCurrentAlert != theNextAlert) {

					switch (theNextAlert) {
					case globalVariable.CURRENT_TIME:
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_begin);
						mGirlSpeak.setText("�w��ϥΰ��d�p�a�C" + "\n" + "�A�n�I�ڬO�p�a�I");
						mMainBackground.setBackgroundResource(R.drawable.bg_main);
						break;
					case globalVariable.GETUP_TIME:
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_getup);
						mGirlSpeak.setText("�O�ѤF\n" + 
								_showTimeDisplay(pref.LoadGetupTimeHourValue(main.this), 
										pref.LoadGetupTimeMinuteValue(main.this)) + "\n�n�Ǯɰ_�ɳ�I\n" + "���_�����঳�ΦY�I");
						mMainBackground.setBackgroundResource(R.drawable.bg_main_getup);
						break;
					case globalVariable.SLEEP_TIME:
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_sleep);
						mGirlSpeak.setText("�O�ѤF\n" + 
								_showTimeDisplay(pref.LoadSleepTimeHourValue(main.this), 
										pref.LoadSleepTimeMinuteValue(main.this)) + "\n�n�ǮɤW�ɺ�ı��I\n" + "���Φ��_����n��I");
						mMainBackground.setBackgroundResource(R.drawable.bg_main_getup);
						break;
					case globalVariable.MEAL_TIME1:
						mGirlSpeak.setText("�O�ѤF\n" + 
								_showTimeDisplay(pref.LoadMealBreakfastTimeHourValue(main.this), 
										pref.LoadMealBreakfastTimeMinuteValue(main.this)) + "\n�n�ǮɦY���\��I\n" + "���\�Y�n�A�믫�@�w�n�I");
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_meal);
						mMainBackground.setBackgroundResource(R.drawable.bg_main_meal);
						break;
					case globalVariable.MEAL_TIME2:
						mGirlSpeak.setText("�O�ѤF\n" + 
								_showTimeDisplay(pref.LoadMealLunchTimeHourValue(main.this), 
										pref.LoadMealLunchTimeMinuteValue(main.this)) + "\n�n�ǮɦY���\��I\n" + "���\²��Y�A�Ĳv���I");
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_meal);
						mMainBackground.setBackgroundResource(R.drawable.bg_main_meal);
						break;
					case globalVariable.MEAL_TIME3:
						mGirlSpeak.setText("�O�ѤF\n" + 
								_showTimeDisplay(pref.LoadMealDinnerTimeHourValue(main.this), 
										pref.LoadMealDinnerTimeMinuteValue(main.this)) + "\n�n�ǮɦY���\��I\n" + "���\���P�Y�A�S�дo�I");
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_meal);
						mMainBackground.setBackgroundResource(R.drawable.bg_main_meal);
						break;
					case globalVariable.DRINK_TIME:
						mGirlSpeak.setText("�O�ѤF\n" + 
								_showTimeDisplay(pref.LoadDrinkTimeHourValue(main.this), 
										pref.LoadDrinkTimeMinuteValue(main.this)) + "\n�n�Ǯɳܤ���I\n" + "���H���G�k�H�O�������I");
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_drink);
						mMainBackground.setBackgroundResource(R.drawable.bg_main_drink);
						break;
					case globalVariable.MEDIC_TIME1:
						mGirlSpeak.setText("�аO�o\n" + 
								_showTimeDisplay(pref.LoadMedicTime1TimeHourValue(main.this), 
										pref.LoadMedicTime1TimeMinuteValue(main.this)) + "�n�ǮɪA��\n" + 
										pref.LoadMedicTime1DescriptionValue(main.this) + "�Ī�\n" + "���ɦY�ġA����d�_�I");
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_medic);
						mMainBackground.setBackgroundResource(R.drawable.bg_main_meal);
						break;
					case globalVariable.MEDIC_TIME2:
						mGirlSpeak.setText("�аO�o\n" + 
								_showTimeDisplay(pref.LoadMedicTime2TimeHourValue(main.this), 
										pref.LoadMedicTime2TimeMinuteValue(main.this)) + "�n�ǮɪA��\n" + 
										pref.LoadMedicTime2DescriptionValue(main.this) + "�Ī�\n" + "���ɦY�ġA����d�_�I");
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_medic);
						mMainBackground.setBackgroundResource(R.drawable.bg_main_meal);
						break;
					case globalVariable.MEDIC_TIME3:
						mGirlSpeak.setText("�аO�o\n" + 
								_showTimeDisplay(pref.LoadMedicTime3TimeHourValue(main.this), 
										pref.LoadMedicTime3TimeMinuteValue(main.this)) + "�n�ǮɪA��\n" + 
										pref.LoadMedicTime3DescriptionValue(main.this) + "�Ī�\n" + "���ɦY�ġA����d�_�I");			
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_medic);
						mMainBackground.setBackgroundResource(R.drawable.bg_main_meal);
						break;
					case globalVariable.SPORT_TIME1:
						mGirlSpeak.setText("�аO�o\n" + 
								_showTimeDisplay(pref.LoadSportTime1TimeHourValue(main.this), 
										pref.LoadSportTime1TimeMinuteValue(main.this)) + "�n�Ǯɶi��\n" + 
										pref.LoadSportTime1DescriptionValue(main.this) + "�B�ʳ�I\n" + "�n���N�n�ʡI");				
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_sport);
						mMainBackground.setBackgroundResource(R.drawable.bg_sport);
						break;
					case globalVariable.SPORT_TIME2:
						mGirlSpeak.setText("�аO�o\n" + 
								_showTimeDisplay(pref.LoadSportTime2TimeHourValue(main.this), 
										pref.LoadSportTime2TimeMinuteValue(main.this)) + "�n�Ǯɶi��\n" + 
										pref.LoadSportTime2DescriptionValue(main.this) + "�B�ʳ�I\n" + "�n���N�n�ʡI");				
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_sport);
						mMainBackground.setBackgroundResource(R.drawable.bg_sport);
						break;
					case globalVariable.SPORT_TIME3:
						mGirlSpeak.setText("�аO�o\n" + 
								_showTimeDisplay(pref.LoadSportTime3TimeHourValue(main.this), 
										pref.LoadSportTime3TimeMinuteValue(main.this)) + "�n�Ǯɶi��\n" + 
										pref.LoadSportTime3DescriptionValue(main.this) + "�B�ʳ�I\n" + "�n���N�n�ʡI");				
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_sport);
						mMainBackground.setBackgroundResource(R.drawable.bg_sport);
						break;
					}
				}

		  		//publicFun.showToast(main.this, String.format("%d -- %d  ", _getNextAlert(), mCount++));  
		  		mHandler.postDelayed(mTask, 500);
			}
		};
		mHandler.postDelayed(mTask, 5000);
	}
	
	
	// Inner classes
	// ���F�M�ת��D�n���O����C�}�Y���~�A���������O�q�q�HC��prefix
//	public class CTimeSet{
//		public int iHour;
//		public int iMinute;
//		public long iTimeInMillis;
//	}
	
	private class CListener_mGetup implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mGetup::onClick");
			Intent intent = new Intent();
			intent.setClass(main.this, getup.class);
			
			startActivity(intent);
			
//			main.this.finish();
		}
	}

	private class CListener_mSleep implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mSleep::onClick");
			Intent intent = new Intent();
			intent.setClass(main.this, sleep.class);
			
			startActivity(intent);
		}
	}

	private class CListener_mMeal implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mMeal::onClick");
			Intent intent = new Intent();
			intent.setClass(main.this, meal.class);
			
			startActivity(intent);
		}
	}

	private class CListener_mDrink implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mDrink::onClick");
			Intent intent = new Intent();
			intent.setClass(main.this, drink.class);
			
			startActivity(intent);	
		}
	}

	private class CListener_mMedic implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mMedic::onClick");
			Intent intent = new Intent();
			intent.setClass(main.this, medic.class);
			
			startActivity(intent);
		}
	}

	private class CListener_mSport implements View.OnClickListener{
		public void onClick(View v) {
			Log.d(mLogTag, "CListener_mSport::onClick");
			Intent intent = new Intent();
			intent.setClass(main.this, sport.class);
			
			startActivity(intent);
	
			//publicFun.showAlertDialog(main.this, "�_�ɴ���", "�j���I�Ӱ_�ɤF�a�I", "�T�{", "���L");
			
//			globalVariable.mVirbator = (Vibrator)getApplication().getSystemService(Service.VIBRATOR_SERVICE);
//			globalVariable.mVirbator.vibrate(new long[]{100, 10, 100, 1000}, -1);
//			publicFun.showToast(main.this, "���ʤ�");
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
    	String msg = "���d�p�a";
    	
    	super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        
		_findViews();

		_initialData();

		_setListeners();   
		
		publicFun.showNotification(main.this, msg);
		
		mGirlSpeak.setText("�w��ϥΰ��d�p�a�C" + "\n" + "�A�n�I�ڬO�p�a�I");
		
    }
    
    

	@Override
	protected void onResume() {
		_initialData();	
		_taskHandler();
		super.onResume();

	}


	@Override
	protected void onPause() {
		mHandler.removeCallbacks(mTask);
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		mHandler.removeCallbacks(mTask);
		super.onDestroy();
	}

/**  
	 * ��Menu�Q�إ߮ɡA�o�Ө禡�N�|�Q�I�s
	 * 
	 * @param menu �ثe��menu�ǤJ
	 */    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.main_menu, menu);
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
//    	case R.id.mit_about:
//			Uri uri = Uri.parse(getString(R.string.SID_about_site));
//			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//			startActivity(intent);
//    		break;
//    	case R.id.mit_exit:
//    		finish();
//    		break;
    	case R.id.mit_main_setting:
    		// ���o�ثe���ɶ� 
    		// �榡���|��ƪ���ơCe.g. 156�N��1:56, 34�N��0:34, 2133�N��21:33,...(24�p�ɨ�)
    		//publicFun.showToast(main.this, String.format("%d", publicFun.getCurrentTime(main.this)));
    		
    		// �ʵe����
    		//ImageView img = (ImageView) findViewById(R.id.imv_main_girl);
    		//img.setBackgroundResource(R.drawable.animated);
    		//AnimationDrawable ad = (AnimationDrawable)img.getBackground();
    		//ad.start();

    		Intent intent = new Intent();
    		intent.setClass(main.this, main_settingDlg.class);
			
			startActivity(intent);
    		break;
    	case R.id.mit_main_about:
 //   		publicFun.showToast(main.this, String.format("%d", _getNextAlert()));

 
    		
    		
//    		medic_setting_dlg dlg = new medic_setting_dlg(this);
//    		dlg.show();

//    		LightingColorFilter lcf = new LightingColorFilter(/*0xFF00FFFF*/0xFF333333, /*0x000000FF*/ 0);
 //   		mSport.setColorFilter(lcf);
  //  		mSport.setAlpha(90);
   // 		mSport.setEnabled(false);
    		break;
    	}
    	return super.onOptionsItemSelected(item);
    }

}