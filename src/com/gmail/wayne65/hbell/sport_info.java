package com.gmail.wayne65.hbell;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



/**
 * sportsetup類別
 * Health Bell的主要畫面
 *
 * @author Wayne Chang
 * @author wayne65@gmail.com
 * @version 1.0.0
 */
public class sport_info extends Activity {
//	private String mLogTag;			// Debug時使用的Log Tag，顯示類別名稱
	private Button mOk;
	
	
	// private 函式命名，使用底線開頭並且第一字母小寫
	/**
	 * 找到資源檔對應的ID，並且連結到相關資源檔位址
	 */
	private void _findViews() {
//		mLogTag = alert_dlg.class.getSimpleName();
		mOk = (Button) findViewById(R.id.btn_sport_info_ok);
		
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
		mOk.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				sport_info.this.finish();
			}
		});
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

        setContentView(R.layout.sport_info);
        
		_findViews();

		_initialData();

		_setListeners();     	
		
    }
    
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