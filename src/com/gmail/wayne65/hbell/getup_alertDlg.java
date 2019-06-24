package com.gmail.wayne65.hbell;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Vibrator;



/**
 * alert_dlg類別
 * Health Bell的主要畫面
 *
 * @author Wayne Chang
 * @author wayne65@gmail.com
 * @version 1.0.0
 */
public class getup_alertDlg extends Activity {
//	private String mLogTag;			// Debug時使用的Log Tag，顯示類別名稱
	private Vibrator mVibrator;
	
	// private 函式命名，使用底線開頭並且第一字母小寫
	/**
	 * 找到資源檔對應的ID，並且連結到相關資源檔位址
	 */
	private void _findViews() {
//		mLogTag = alert_dlg.class.getSimpleName();
		
	}	

	/**
	 * 初始化顯示元件的資料
	 */
	private void _initialData() {

	}	

	/**
	 * 訂閱所有元件感興趣的事件
	 */
	private void _setListeners() {
	}	
	
	
	
	private void _showAlertDialog(Context arg0, String strTitle, String strMessage, String strPosBtn, String strNegBtn){
		new AlertDialog.Builder(arg0).setTitle(strTitle).setMessage(strMessage)
				.setPositiveButton(strPosBtn, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialoginterface, int i) {
						if (pref.LoadGetupBellCheckedValue(getup_alertDlg.this) == true){
							publicFun.ringBell(getup_alertDlg.this, false); 	// 停止音樂
						}
						if (mVibrator != null) mVibrator.cancel();			// 停止振動
						
						getup_alertDlg.this.finish();
					}
				}).setNegativeButton(strNegBtn, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialoginterface, int i) {
						if (pref.LoadGetupBellCheckedValue(getup_alertDlg.this) == true){
							publicFun.ringBell(getup_alertDlg.this, false); 	// 停止音樂
						}
						if (mVibrator != null) mVibrator.cancel();			// 停正振動
						
						getup_alertDlg.this.finish();
					}
				}).show();

	}
	
	private void _alertProcess(){
		if (pref.LoadGetupBellCheckedValue(getup_alertDlg.this) == true){
			publicFun.ringBell(getup_alertDlg.this, true); // 撥放音樂
		}
		if (pref.LoadGetupVibrationCheckedValue(getup_alertDlg.this) == true){
			_vibration();
		}
		_showAlertDialog(getup_alertDlg.this, "起床提醒", "該起床了！", "確認", "略過");
	}
	
	private void _vibration(){
		mVibrator = (Vibrator)getApplication().getSystemService(Service.VIBRATOR_SERVICE);
		mVibrator.vibrate(new long[]{100, 10, 100, 1000}, -1);
		publicFun.showToast(getup_alertDlg.this, "振動中");
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

        setContentView(R.layout.alert_dlg);
        
		_findViews();

		_initialData();

		_setListeners();     	
		
		_alertProcess();
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