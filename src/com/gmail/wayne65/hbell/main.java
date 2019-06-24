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
 * main類別
 * Health Bell的主要畫面
 *
 * @author Wayne Chang
 * @author wayne65@gmail.com
 * @version 1.0.0
 */
public class main extends Activity {
	private String mLogTag;			// Debug時使用的Log Tag，顯示類別名稱
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

	
	// private 函式命名，使用底線開頭並且第一字母小寫
	/**
	 * 找到資源檔對應的ID，並且連結到相關資源檔位址
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
	 * 初始化顯示元件的資料
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
	 * 訂閱所有元件感興趣的事件
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
			strAMPM = "上午";
		}else{
			strAMPM = "下午";
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
						mGirlSpeak.setText("歡迎使用健康小鈴。" + "\n" + "你好！我是小鈴！");
						mMainBackground.setBackgroundResource(R.drawable.bg_main);
						break;
					case globalVariable.GETUP_TIME:
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_getup);
						mGirlSpeak.setText("別忘了\n" + 
								_showTimeDisplay(pref.LoadGetupTimeHourValue(main.this), 
										pref.LoadGetupTimeMinuteValue(main.this)) + "\n要準時起床喔！\n" + "早起的鳥兒有蟲吃！");
						mMainBackground.setBackgroundResource(R.drawable.bg_main_getup);
						break;
					case globalVariable.SLEEP_TIME:
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_sleep);
						mGirlSpeak.setText("別忘了\n" + 
								_showTimeDisplay(pref.LoadSleepTimeHourValue(main.this), 
										pref.LoadSleepTimeMinuteValue(main.this)) + "\n要準時上床睡覺喔！\n" + "早睡早起身體好唷！");
						mMainBackground.setBackgroundResource(R.drawable.bg_main_getup);
						break;
					case globalVariable.MEAL_TIME1:
						mGirlSpeak.setText("別忘了\n" + 
								_showTimeDisplay(pref.LoadMealBreakfastTimeHourValue(main.this), 
										pref.LoadMealBreakfastTimeMinuteValue(main.this)) + "\n要準時吃早餐喔！\n" + "早餐吃好，精神一定好！");
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_meal);
						mMainBackground.setBackgroundResource(R.drawable.bg_main_meal);
						break;
					case globalVariable.MEAL_TIME2:
						mGirlSpeak.setText("別忘了\n" + 
								_showTimeDisplay(pref.LoadMealLunchTimeHourValue(main.this), 
										pref.LoadMealLunchTimeMinuteValue(main.this)) + "\n要準時吃午餐喔！\n" + "午餐簡單吃，效率高！");
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_meal);
						mMainBackground.setBackgroundResource(R.drawable.bg_main_meal);
						break;
					case globalVariable.MEAL_TIME3:
						mGirlSpeak.setText("別忘了\n" + 
								_showTimeDisplay(pref.LoadMealDinnerTimeHourValue(main.this), 
										pref.LoadMealDinnerTimeMinuteValue(main.this)) + "\n要準時吃晚餐喔！\n" + "晚餐輕鬆吃，沒煩惱！");
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_meal);
						mMainBackground.setBackgroundResource(R.drawable.bg_main_meal);
						break;
					case globalVariable.DRINK_TIME:
						mGirlSpeak.setText("別忘了\n" + 
								_showTimeDisplay(pref.LoadDrinkTimeHourValue(main.this), 
										pref.LoadDrinkTimeMinuteValue(main.this)) + "\n要準時喝水喔！\n" + "有人說：女人是水做的！");
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_drink);
						mMainBackground.setBackgroundResource(R.drawable.bg_main_drink);
						break;
					case globalVariable.MEDIC_TIME1:
						mGirlSpeak.setText("請記得\n" + 
								_showTimeDisplay(pref.LoadMedicTime1TimeHourValue(main.this), 
										pref.LoadMedicTime1TimeMinuteValue(main.this)) + "要準時服用\n" + 
										pref.LoadMedicTime1DescriptionValue(main.this) + "藥物\n" + "按時吃藥，早日康復！");
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_medic);
						mMainBackground.setBackgroundResource(R.drawable.bg_main_meal);
						break;
					case globalVariable.MEDIC_TIME2:
						mGirlSpeak.setText("請記得\n" + 
								_showTimeDisplay(pref.LoadMedicTime2TimeHourValue(main.this), 
										pref.LoadMedicTime2TimeMinuteValue(main.this)) + "要準時服用\n" + 
										pref.LoadMedicTime2DescriptionValue(main.this) + "藥物\n" + "按時吃藥，早日康復！");
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_medic);
						mMainBackground.setBackgroundResource(R.drawable.bg_main_meal);
						break;
					case globalVariable.MEDIC_TIME3:
						mGirlSpeak.setText("請記得\n" + 
								_showTimeDisplay(pref.LoadMedicTime3TimeHourValue(main.this), 
										pref.LoadMedicTime3TimeMinuteValue(main.this)) + "要準時服用\n" + 
										pref.LoadMedicTime3DescriptionValue(main.this) + "藥物\n" + "按時吃藥，早日康復！");			
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_medic);
						mMainBackground.setBackgroundResource(R.drawable.bg_main_meal);
						break;
					case globalVariable.SPORT_TIME1:
						mGirlSpeak.setText("請記得\n" + 
								_showTimeDisplay(pref.LoadSportTime1TimeHourValue(main.this), 
										pref.LoadSportTime1TimeMinuteValue(main.this)) + "要準時進行\n" + 
										pref.LoadSportTime1DescriptionValue(main.this) + "運動喔！\n" + "要活就要動！");				
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_sport);
						mMainBackground.setBackgroundResource(R.drawable.bg_sport);
						break;
					case globalVariable.SPORT_TIME2:
						mGirlSpeak.setText("請記得\n" + 
								_showTimeDisplay(pref.LoadSportTime2TimeHourValue(main.this), 
										pref.LoadSportTime2TimeMinuteValue(main.this)) + "要準時進行\n" + 
										pref.LoadSportTime2DescriptionValue(main.this) + "運動喔！\n" + "要活就要動！");				
						mGirlStatus.setBackgroundResource(R.drawable.main_girl_sport);
						mMainBackground.setBackgroundResource(R.drawable.bg_sport);
						break;
					case globalVariable.SPORT_TIME3:
						mGirlSpeak.setText("請記得\n" + 
								_showTimeDisplay(pref.LoadSportTime3TimeHourValue(main.this), 
										pref.LoadSportTime3TimeMinuteValue(main.this)) + "要準時進行\n" + 
										pref.LoadSportTime3DescriptionValue(main.this) + "運動喔！\n" + "要活就要動！");				
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
	// 除了專案的主要類別不用C開頭之外，內部的類別通通以C為prefix
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
	
			//publicFun.showAlertDialog(main.this, "起床提醒", "大哥！該起床了吧！", "確認", "略過");
			
//			globalVariable.mVirbator = (Vibrator)getApplication().getSystemService(Service.VIBRATOR_SERVICE);
//			globalVariable.mVirbator.vibrate(new long[]{100, 10, 100, 1000}, -1);
//			publicFun.showToast(main.this, "振動中");
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
    	String msg = "健康小鈴";
    	
    	super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        
		_findViews();

		_initialData();

		_setListeners();   
		
		publicFun.showNotification(main.this, msg);
		
		mGirlSpeak.setText("歡迎使用健康小鈴。" + "\n" + "你好！我是小鈴！");
		
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
	 * 當Menu被建立時，這個函式就會被呼叫
	 * 
	 * @param menu 目前的menu傳入
	 */    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.main_menu, menu);
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
//    	case R.id.mit_about:
//			Uri uri = Uri.parse(getString(R.string.SID_about_site));
//			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//			startActivity(intent);
//    		break;
//    	case R.id.mit_exit:
//    		finish();
//    		break;
    	case R.id.mit_main_setting:
    		// 取得目前的時間 
    		// 格式為四位數的整數。e.g. 156代表1:56, 34代表0:34, 2133代表21:33,...(24小時制)
    		//publicFun.showToast(main.this, String.format("%d", publicFun.getCurrentTime(main.this)));
    		
    		// 動畫撥放
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