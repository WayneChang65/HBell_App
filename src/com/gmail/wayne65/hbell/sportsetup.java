package com.gmail.wayne65.hbell;

import android.app.Activity;
import android.os.Bundle;



/**
 * sportsetup���O
 * Health Bell���D�n�e��
 *
 * @author Wayne Chang
 * @author wayne65@gmail.com
 * @version 1.0.0
 */
public class sportsetup extends Activity {
//	private String mLogTag;			// Debug�ɨϥΪ�Log Tag�A������O�W��
	
	
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

        setContentView(R.layout.sportsetup);
        
		_findViews();

		_initialData();

		_setListeners();     	
		
    }
    
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