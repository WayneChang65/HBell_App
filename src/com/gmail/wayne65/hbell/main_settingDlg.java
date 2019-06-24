package com.gmail.wayne65.hbell;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;




/**
 * alert_dlg類別
 * Health Bell的主要畫面
 *
 * @author Wayne Chang
 * @author wayne65@gmail.com
 * @version 1.0.0
 */
public class main_settingDlg extends Activity {
//	private String mLogTag;			// Debug時使用的Log Tag，顯示類別名稱
//	private Vibrator mVibrator;
	private CheckBox mGetup, mSleep, mMeal, mDrink, mMedic, mSport;
	private Button mOk, mCancel;
	// private 函式命名，使用底線開頭並且第一字母小寫
	/**
	 * 找到資源檔對應的ID，並且連結到相關資源檔位址
	 */
	private void _findViews() {
//		mLogTag = alert_dlg.class.getSimpleName();
		mGetup = (CheckBox) findViewById(R.id.cbx_main_setting_getup);
		mSleep = (CheckBox) findViewById(R.id.cbx_main_setting_sleep);
		mMeal = (CheckBox) findViewById(R.id.cbx_main_setting_meal);
		mDrink = (CheckBox) findViewById(R.id.cbx_main_setting_drink);
		mMedic = (CheckBox) findViewById(R.id.cbx_main_setting_medic);
		mSport = (CheckBox) findViewById(R.id.cbx_main_setting_sport);
		
		mOk = (Button) findViewById(R.id.btn_main_setting_ok);
		mCancel = (Button) findViewById(R.id.btn_main_setting_cancel);
	}	

	/**
	 * 初始化顯示元件的資料
	 */
	private void _initialData() {
		mGetup.setChecked(pref.LoadMainSwitchGetupValue(main_settingDlg.this));
		mSleep.setChecked(pref.LoadMainSwitchSleepValue(main_settingDlg.this));
		mMeal.setChecked(pref.LoadMainSwitchMealValue(main_settingDlg.this));
		mDrink.setChecked(pref.LoadMainSwitchDrinkValue(main_settingDlg.this));
		mMedic.setChecked(pref.LoadMainSwitchMedicValue(main_settingDlg.this));
		mSport.setChecked(pref.LoadMainSwitchSportValue(main_settingDlg.this));
	}	

	/**
	 * 訂閱所有元件感興趣的事件
	 */
	private void _setListeners() {
		mOk.setOnClickListener(
				new View.OnClickListener() {
					public void onClick(View v) {
						pref.SaveMainSwitchGetupValue(main_settingDlg.this, mGetup.isChecked());
						pref.SaveMainSwitchSleepValue(main_settingDlg.this, mSleep.isChecked());
						pref.SaveMainSwitchMealValue(main_settingDlg.this, mMeal.isChecked());
						pref.SaveMainSwitchDrinkValue(main_settingDlg.this, mDrink.isChecked());
						pref.SaveMainSwitchMedicValue(main_settingDlg.this, mMedic.isChecked());
						pref.SaveMainSwitchSportValue(main_settingDlg.this, mSport.isChecked());
						main_settingDlg.this.finish();
					}
				}
		);
		
		mCancel.setOnClickListener(
				new View.OnClickListener() {			
					public void onClick(View v) {
						main_settingDlg.this.finish();
					}
				}
		);
	}	
	
	
	
	// Inner classes
	// 除了專案的主要類別不用C開頭之外，內部的類別通通以C為prefix

	
	
	
	// Public的函式放在最後面，函式名稱使用小寫字母開頭命名
	/**  
	 * 當目前的Activity啟動時，這個函式就會被呼叫
	 * 
	 * @param savedInstanceState 前一次activity的凍結狀態
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
     	
    	super.onCreate(savedInstanceState);

        setContentView(R.layout.main_setting);
        
		_findViews();

		_initialData();

		_setListeners();     	
		

    }


//	@Override
//	public void onWindowFocusChanged(boolean hasFocus) {
//		super.onWindowFocusChanged(hasFocus);
//		if(hasFocus == true){
			//publicFun.showToast(alert_dlg.this, "onWindowFocusChanged!");
			//publicFun.showAlertDialog(alert_dlg.this, "起床提醒", "大哥！該起床了吧！", "確認", "略過");
//		}
//	}
    
    
   /**  
	 * 當Menu被建立時，這個函式就會被呼叫
	 * 
	 * @param menu 目前的menu傳入
	 */    
  
    
    
	/**  
	 * 當Menu Item被選取時，這個函式就會被呼叫
	 * 
	 * @param item 目前被選取的MenuItem
	 */   
 
}