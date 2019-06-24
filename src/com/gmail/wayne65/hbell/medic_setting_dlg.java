package com.gmail.wayne65.hbell;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;




/**
 * alert_dlg���O
 * Health Bell���D�n�e��
 *
 * @author Wayne Chang
 * @author wayne65@gmail.com
 * @version 1.0.0
 */
public class medic_setting_dlg extends Activity {
//	private String mLogTag;			// Debug�ɨϥΪ�Log Tag�A������O�W��
//	private Vibrator mVibrator;
//	private Context mContext;
	private EditText mDescription1, mDescription2, mDescription3;
	private Button mOk, mCancel;
	// private �禡�R�W�A�ϥΩ��u�}�Y�åB�Ĥ@�r���p�g
	/**
	 * ���귽�ɹ�����ID�A�åB�s��������귽�ɦ�}
	 */
	private void _findViews() {
//		mLogTag = alert_dlg.class.getSimpleName();
		mDescription1 = (EditText)findViewById(R.id.etx_medic_comment1);
		mDescription2 = (EditText)findViewById(R.id.etx_medic_comment2);
		mDescription3 = (EditText)findViewById(R.id.etx_medic_comment3);
		
		mOk = (Button) findViewById(R.id.btn_medic_ok);
		mCancel = (Button) findViewById(R.id.btn_medic_cancel);
	}	

	/**
	 * ��l����ܤ��󪺸��
	 */
	private void _initialData() {
		mDescription1.setText(pref.LoadMedicTime1DescriptionValue(medic_setting_dlg.this));
		mDescription2.setText(pref.LoadMedicTime2DescriptionValue(medic_setting_dlg.this));
		mDescription3.setText(pref.LoadMedicTime3DescriptionValue(medic_setting_dlg.this));
	}	

	/**
	 * �q�\�Ҧ�����P���쪺�ƥ�
	 */
	private void _setListeners() {
		mOk.setOnClickListener(
				new View.OnClickListener() {
					public void onClick(View v) {
						pref.SaveMedicTime1DescriptionValue(medic_setting_dlg.this, mDescription1.getText().toString());
						pref.SaveMedicTime2DescriptionValue(medic_setting_dlg.this, mDescription2.getText().toString());
						pref.SaveMedicTime3DescriptionValue(medic_setting_dlg.this, mDescription3.getText().toString());
	
						medic_setting_dlg.this.finish();
					}
				}
		);
		
		mCancel.setOnClickListener(
				new View.OnClickListener() {			
					public void onClick(View v) {
						medic_setting_dlg.this.finish();
					}
				}
		);
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

        setContentView(R.layout.medic_setting_dlg);
        
		_findViews();

		_initialData();

		_setListeners();     	
		

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