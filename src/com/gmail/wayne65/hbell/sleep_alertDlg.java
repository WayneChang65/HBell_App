package com.gmail.wayne65.hbell;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Vibrator;



/**
 * alert_dlg���O
 * Health Bell���D�n�e��
 *
 * @author Wayne Chang
 * @author wayne65@gmail.com
 * @version 1.0.0
 */
public class sleep_alertDlg extends Activity {
//	private String mLogTag;			// Debug�ɨϥΪ�Log Tag�A������O�W��
	private Vibrator mVibrator;
	
	// private �禡�R�W�A�ϥΩ��u�}�Y�åB�Ĥ@�r���p�g
	/**
	 * ���귽�ɹ�����ID�A�åB�s��������귽�ɦ�}
	 */
	private void _findViews() {
//		mLogTag = alert_dlg.class.getSimpleName();
		
	}	

	/**
	 * ��l����ܤ��󪺸��
	 */
	private void _initialData() {

	}	

	/**
	 * �q�\�Ҧ�����P���쪺�ƥ�
	 */
	private void _setListeners() {
	}	
	
	
	
	private void _showAlertDialog(Context arg0, String strTitle, String strMessage, String strPosBtn, String strNegBtn){
		new AlertDialog.Builder(arg0).setTitle(strTitle).setMessage(strMessage)
				.setPositiveButton(strPosBtn, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialoginterface, int i) {
						
						if (pref.LoadSleepBellCheckedValue(sleep_alertDlg.this) == true){
							publicFun.ringBell(sleep_alertDlg.this, false); 	// �����
						}
						if (mVibrator != null) mVibrator.cancel();			// �����
						
						sleep_alertDlg.this.finish();
					}
				}).setNegativeButton(strNegBtn, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialoginterface, int i) {
						if (pref.LoadSleepBellCheckedValue(sleep_alertDlg.this) == true){
							publicFun.ringBell(sleep_alertDlg.this, false); 	// �����
						}
						if (mVibrator != null) mVibrator.cancel();			// ��������
						
						sleep_alertDlg.this.finish();
					}
				}).show();

	}
	
	private void _alertProcess(){
		if (pref.LoadSleepBellCheckedValue(sleep_alertDlg.this) == true){
			publicFun.ringBell(sleep_alertDlg.this, true); // ���񭵼�
		}
		if (pref.LoadSleepVibrationCheckedValue(sleep_alertDlg.this) == true){
			_vibration();
		}
		_showAlertDialog(sleep_alertDlg.this, "��ı����", "�Ӻ�ı�F�I", "�T�{", "���L");
	}
	
	private void _vibration(){
		mVibrator = (Vibrator)getApplication().getSystemService(Service.VIBRATOR_SERVICE);
		mVibrator.vibrate(new long[]{100, 10, 100, 1000}, -1);
		publicFun.showToast(sleep_alertDlg.this, "���ʤ�");
	}
	// Inner classes
	// ���F�M�ת��D�n���O����C�}�Y���~�A���������O�q�q�HC��prefix

	
	
	
	// Public���禡��b�̫᭱�A�禡�W�٨ϥΤp�g�r���}�Y�R�W
	/**  
	 * ��ثe��Activity�ҰʮɡA�o�Ө禡�N�|�Q�I�s
	 * 
	 * @param savedInstanceState �e�@��activity���ᵲ���A
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
			//publicFun.showAlertDialog(alert_dlg.this, "�_�ɴ���", "�j���I�Ӱ_�ɤF�a�I", "�T�{", "���L");
//		}
//	}
    
    
   /**  
	 * ��Menu�Q�إ߮ɡA�o�Ө禡�N�|�Q�I�s
	 * 
	 * @param menu �ثe��menu�ǤJ
	 */    
  
    
    
	/**  
	 * ��Menu Item�Q����ɡA�o�Ө禡�N�|�Q�I�s
	 * 
	 * @param item �ثe�Q�����MenuItem
	 */   
 
}