package com.gmail.wayne65.hbell;

import android.content.Context;
import android.content.SharedPreferences;

public class pref {
    private static final String PREF_FILE_NAME   = "pref";
    
    private static final String KEY_MAIN_SWITCH_GETUP_VAL = "main_switch_getup_val";
    private static final String KEY_MAIN_SWITCH_SLEEP_VAL = "main_switch_sleep_val";
    private static final String KEY_MAIN_SWITCH_MEAL_VAL = "main_switch_meal_val";
    private static final String KEY_MAIN_SWITCH_DRINK_VAL = "main_switch_drink_val";
    private static final String KEY_MAIN_SWITCH_MEDIC_VAL = "main_switch_medic_val";
    private static final String KEY_MAIN_SWITCH_SPORT_VAL = "main_switch_sport_val";
    
    private static final String KEY_GETUP_TIME_HOUR_VAL = "getup_time_hour_val";
    private static final String KEY_GETUP_TIME_MINUTE_VAL = "getup_time_minute_val";
    private static final String KEY_GETUP_BELL_CHECKED_VAL = "getup_bell_checked_val";
    private static final String KEY_GETUP_VIBRATION_CHECKED_VAL = "getup_vibration_check_val";
    
    private static final String KEY_SLEEP_TIME_HOUR_VAL = "sleep_time_hour_val";
    private static final String KEY_SLEEP_TIME_MINUTE_VAL = "sleep_time_minute_val";
    private static final String KEY_SLEEP_BELL_CHECKED_VAL = "sleep_bell_checked_val";
    private static final String KEY_SLEEP_VIBRATION_CHECKED_VAL = "sleep_vibration_check_val";
    
    private static final String KEY_MEAL_BREAKFAST_TIME_HOUR_VAL = "meal_breakfast_time_hour_val";
    private static final String KEY_MEAL_BREAKFAST_TIME_MINUTE_VAL = "meal_breakfast_time_minute_val";
    private static final String KEY_MEAL_LUNCH_TIME_HOUR_VAL = "meal_lunch_time_hour_val";
    private static final String KEY_MEAL_LUNCH_TIME_MINUTE_VAL = "meal_lunch_time_minute_val";
    private static final String KEY_MEAL_DINNER_TIME_HOUR_VAL = "meal_dinner_time_hour_val";
    private static final String KEY_MEAL_DINNER_TIME_MINUTE_VAL = "meal_dinner_time_minute_val";
    private static final String KEY_MEAL_BELL_CHECKED_VAL = "meal_bell_checked_val";
    private static final String KEY_MEAL_VIBRATION_CHECKED_VAL = "meal_vibration_check_val";
    
    private static final String KEY_DRINK_TIME_HOUR_VAL = "drink_time_hour_val";
    private static final String KEY_DRINK_TIME_MINUTE_VAL = "drink_time_minute_val";
    private static final String KEY_DRINK_BELL_CHECKED_VAL = "drink_bell_checked_val";
    private static final String KEY_DRINK_VIBRATION_CHECKED_VAL = "drink_vibration_check_val";
    private static final String KEY_DRINK_TIME_PERIOD_HOUR_VAL = "drink_time_period_hour_val";
    private static final String KEY_DRINK_TIME_PERIOD_MINUTE_VAL = "drink_time_period_minute_val";
    
    
    
    private static final String KEY_MEDIC_TIME1_TIME_HOUR_VAL = "medic_time1_time_hour_val";
    private static final String KEY_MEDIC_TIME1_TIME_MINUTE_VAL = "medic_time1_time_minute_val";
    private static final String KEY_MEDIC_TIME1_DESCRIPTION_VAL = "medic_time1_description_val";
    private static final String KEY_MEDIC_TIME2_TIME_HOUR_VAL = "medic_time2_time_hour_val";
    private static final String KEY_MEDIC_TIME2_TIME_MINUTE_VAL = "medic_time2_time_minute_val";
    private static final String KEY_MEDIC_TIME2_DESCRIPTION_VAL = "medic_time2_description_val";
    private static final String KEY_MEDIC_TIME3_TIME_HOUR_VAL = "medic_time3_time_hour_val";
    private static final String KEY_MEDIC_TIME3_TIME_MINUTE_VAL = "medic_time3_time_minute_val";
    private static final String KEY_MEDIC_TIME3_DESCRIPTION_VAL = "medic_time3_description_val";
    private static final String KEY_MEDIC_BELL_CHECKED_VAL = "medic_bell_checked_val";
    private static final String KEY_MEDIC_VIBRATION_CHECKED_VAL = "medic_vibration_check_val";
    
    
    private static final String KEY_SPORT_TIME1_TIME_HOUR_VAL = "sport_time1_time_hour_val";
    private static final String KEY_SPORT_TIME1_TIME_MINUTE_VAL = "sport_time1_time_minute_val";
    private static final String KEY_SPORT_TIME1_DESCRIPTION_VAL = "sport_time1_description_val";
    private static final String KEY_SPORT_TIME2_TIME_HOUR_VAL = "sport_time2_time_hour_val";
    private static final String KEY_SPORT_TIME2_TIME_MINUTE_VAL = "sport_time2_time_minute_val";
    private static final String KEY_SPORT_TIME2_DESCRIPTION_VAL = "sport_time2_description_val";
    private static final String KEY_SPORT_TIME3_TIME_HOUR_VAL = "sport_time3_time_hour_val";
    private static final String KEY_SPORT_TIME3_TIME_MINUTE_VAL = "sport_time3_time_minute_val";
    private static final String KEY_SPORT_TIME3_DESCRIPTION_VAL = "sport_time3_description_val";
    private static final String KEY_SPORT_BELL_CHECKED_VAL = "sport_bell_checked_val";
    private static final String KEY_SPORT_VIBRATION_CHECKED_VAL = "sport_vibration_check_val";

    
    // Public Method
    
    // main page
    public static final boolean LoadMainSwitchGetupValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_MAIN_SWITCH_GETUP_VAL, true);   	
    }

    public static final void SaveMainSwitchGetupValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_MAIN_SWITCH_GETUP_VAL, bValue);
        ed.commit();
    }        
    
    public static final boolean LoadMainSwitchSleepValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_MAIN_SWITCH_SLEEP_VAL, true);   	
    }

    public static final void SaveMainSwitchSleepValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_MAIN_SWITCH_SLEEP_VAL, bValue);
        ed.commit();
    }           
    
    public static final boolean LoadMainSwitchMealValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_MAIN_SWITCH_MEAL_VAL, true);   	
    }

    public static final void SaveMainSwitchMealValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_MAIN_SWITCH_MEAL_VAL, bValue);
        ed.commit();
    }        
    
    public static final boolean LoadMainSwitchDrinkValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_MAIN_SWITCH_DRINK_VAL, true);   	
    }

    public static final void SaveMainSwitchDrinkValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_MAIN_SWITCH_DRINK_VAL, bValue);
        ed.commit();
    }        

    public static final boolean LoadMainSwitchMedicValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_MAIN_SWITCH_MEDIC_VAL, true);   	
    }

    public static final void SaveMainSwitchMedicValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_MAIN_SWITCH_MEDIC_VAL, bValue);
        ed.commit();
    }   
    
    public static final boolean LoadMainSwitchSportValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_MAIN_SWITCH_SPORT_VAL, true);   	
    }

    public static final void SaveMainSwitchSportValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_MAIN_SWITCH_SPORT_VAL, bValue);
        ed.commit();
    }        
    
    // getup page
    public static final int LoadGetupTimeHourValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_GETUP_TIME_HOUR_VAL, 8);
    }
    
    public static final void SaveGetupTimeHourValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_GETUP_TIME_HOUR_VAL, iValue);
        ed.commit();
    }
    
    public static final int LoadGetupTimeMinuteValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_GETUP_TIME_MINUTE_VAL, 15);
    }
    
    public static final void SaveGetupTimeMinuteValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_GETUP_TIME_MINUTE_VAL, iValue);
        ed.commit();
    }    

    public static final boolean LoadGetupBellCheckedValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_GETUP_BELL_CHECKED_VAL, false);   	
    }

    public static final void SaveGetupBellCheckedValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_GETUP_BELL_CHECKED_VAL, bValue);
        ed.commit();
    }    
 
    public static final boolean LoadGetupVibrationCheckedValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_GETUP_VIBRATION_CHECKED_VAL, false);   	
    }

    public static final void SaveGetupVibrationCheckedValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_GETUP_VIBRATION_CHECKED_VAL, bValue);
        ed.commit();
    }    
    
    // meal page
    public static final int LoadMealBreakfastTimeHourValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_MEAL_BREAKFAST_TIME_HOUR_VAL, 9);
    }
    
    public static final void SaveMealBreakfastTimeHourValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_MEAL_BREAKFAST_TIME_HOUR_VAL, iValue);
        ed.commit();
    }
    
    public static final int LoadMealLunchTimeHourValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_MEAL_LUNCH_TIME_HOUR_VAL, 11);
    }
    
    public static final void SaveMealLunchTimeHourValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_MEAL_LUNCH_TIME_HOUR_VAL, iValue);
        ed.commit();
    }

    public static final int LoadMealDinnerTimeHourValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_MEAL_DINNER_TIME_HOUR_VAL, 18);
    }
    
    public static final void SaveMealDinnerTimeHourValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_MEAL_DINNER_TIME_HOUR_VAL, iValue);
        ed.commit();
    }
    
    public static final int LoadMealBreakfastTimeMinuteValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_MEAL_BREAKFAST_TIME_MINUTE_VAL, 0);
    }
    
    public static final void SaveMealBreakfastTimeMinuteValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_MEAL_BREAKFAST_TIME_MINUTE_VAL, iValue);
        ed.commit();
    }    

    public static final int LoadMealLunchTimeMinuteValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_MEAL_LUNCH_TIME_MINUTE_VAL, 40);
    }
    
    public static final void SaveMealLunchTimeMinuteValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_MEAL_LUNCH_TIME_MINUTE_VAL, iValue);
        ed.commit();
    }    
 
    public static final int LoadMealDinnerTimeMinuteValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_MEAL_DINNER_TIME_MINUTE_VAL, 10);
    }
    
    public static final void SaveMealDinnerTimeMinuteValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_MEAL_DINNER_TIME_MINUTE_VAL, iValue);
        ed.commit();
    }    
    
    public static final boolean LoadMealBellCheckedValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_MEAL_BELL_CHECKED_VAL, false);   	
    }

    public static final void SaveMealBellCheckedValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_MEAL_BELL_CHECKED_VAL, bValue);
        ed.commit();
    }    
 
    public static final boolean LoadMealVibrationCheckedValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_MEAL_VIBRATION_CHECKED_VAL, false);   	
    }

    public static final void SaveMealVibrationCheckedValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_MEAL_VIBRATION_CHECKED_VAL, bValue);
        ed.commit();
    }        
    
    // sleep page
    public static final int LoadSleepTimeHourValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_SLEEP_TIME_HOUR_VAL, 11);
    }
    
    public static final void SaveSleepTimeHourValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_SLEEP_TIME_HOUR_VAL, iValue);
        ed.commit();
    }
    
    public static final int LoadSleepTimeMinuteValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_SLEEP_TIME_MINUTE_VAL, 10);
    }
    
    public static final void SaveSleepTimeMinuteValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_SLEEP_TIME_MINUTE_VAL, iValue);
        ed.commit();
    }    

    public static final boolean LoadSleepBellCheckedValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_SLEEP_BELL_CHECKED_VAL, false);   	
    }

    public static final void SaveSleepBellCheckedValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_SLEEP_BELL_CHECKED_VAL, bValue);
        ed.commit();
    }    
 
    public static final boolean LoadSleepVibrationCheckedValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_SLEEP_VIBRATION_CHECKED_VAL, false);   	
    }

    public static final void SaveSleepVibrationCheckedValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_SLEEP_VIBRATION_CHECKED_VAL, bValue);
        ed.commit();
    }            
 
    // drink page
    public static final int LoadDrinkTimeHourValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_DRINK_TIME_HOUR_VAL, 0);
    }
    
    public static final void SaveDrinkTimeHourValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_DRINK_TIME_HOUR_VAL, iValue);
        ed.commit();
    }
    
    public static final int LoadDrinkTimeMinuteValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_DRINK_TIME_MINUTE_VAL, 0);
    }
    
    public static final void SaveDrinkTimeMinuteValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_DRINK_TIME_MINUTE_VAL, iValue);
        ed.commit();
    }    

    public static final boolean LoadDrinkBellCheckedValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_DRINK_BELL_CHECKED_VAL, false);   	
    }

    public static final void SaveDrinkBellCheckedValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_DRINK_BELL_CHECKED_VAL, bValue);
        ed.commit();
    }    
 
    public static final boolean LoadDrinkVibrationCheckedValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_DRINK_VIBRATION_CHECKED_VAL, false);   	
    }

    public static final void SaveDrinkVibrationCheckedValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_DRINK_VIBRATION_CHECKED_VAL, bValue);
        ed.commit();
    }    
 
    public static final int LoadDrinkTimePeriodHourValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_DRINK_TIME_PERIOD_HOUR_VAL, 2);
    }
    
    public static final void SaveDrinkTimePeriodHourValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_DRINK_TIME_PERIOD_HOUR_VAL, iValue);
        ed.commit();
    }
    
    public static final int LoadDrinkTimePeriodMinuteValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_DRINK_TIME_PERIOD_MINUTE_VAL, 0);
    }
    
    public static final void SaveDrinkTimePeriodMinuteValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_DRINK_TIME_PERIOD_MINUTE_VAL, iValue);
        ed.commit();
    }    
    // medic page
    public static final int LoadMedicTime1TimeHourValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_MEDIC_TIME1_TIME_HOUR_VAL, 9);
    }
    
    public static final void SaveMedicTime1TimeHourValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_MEDIC_TIME1_TIME_HOUR_VAL, iValue);
        ed.commit();
    }
    
    public static final int LoadMedicTime2TimeHourValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_MEDIC_TIME2_TIME_HOUR_VAL, 13);
    }
    
    public static final void SaveMedicTime2TimeHourValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_MEDIC_TIME2_TIME_HOUR_VAL, iValue);
        ed.commit();
    }

    public static final int LoadMedicTime3TimeHourValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_MEDIC_TIME3_TIME_HOUR_VAL, 18);
    }
    
    public static final void SaveMedicTime3TimeHourValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_MEDIC_TIME3_TIME_HOUR_VAL, iValue);
        ed.commit();
    }
    
    public static final int LoadMedicTime1TimeMinuteValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_MEDIC_TIME1_TIME_MINUTE_VAL, 30);
    }
    
    public static final void SaveMedicTime1TimeMinuteValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_MEDIC_TIME1_TIME_MINUTE_VAL, iValue);
        ed.commit();
    }    

    public static final int LoadMedicTime2TimeMinuteValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_MEDIC_TIME2_TIME_MINUTE_VAL, 0);
    }
    
    public static final void SaveMedicTime2TimeMinuteValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_MEDIC_TIME2_TIME_MINUTE_VAL, iValue);
        ed.commit();
    }    
 
    public static final int LoadMedicTime3TimeMinuteValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_MEDIC_TIME3_TIME_MINUTE_VAL, 20);
    }
    
    public static final void SaveMedicTime3TimeMinuteValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_MEDIC_TIME3_TIME_MINUTE_VAL, iValue);
        ed.commit();
    }    
  
    public static final String LoadMedicTime1DescriptionValue(Context context){
    	SharedPreferences pref = _GetPref(context);
    	return pref.getString(KEY_MEDIC_TIME1_DESCRIPTION_VAL, "Allopurinol");
    }
    
    public static final void SaveMedicTime1DescriptionValue(Context context, String strValue){
    	SharedPreferences.Editor ed = _GetPrefEditor(context);
    	ed.putString(KEY_MEDIC_TIME1_DESCRIPTION_VAL, strValue);
    	ed.commit();
    }

    public static final String LoadMedicTime2DescriptionValue(Context context){
    	SharedPreferences pref = _GetPref(context);
    	return pref.getString(KEY_MEDIC_TIME2_DESCRIPTION_VAL, "SIRIN          ");
    }
    
    public static final void SaveMedicTime2DescriptionValue(Context context, String strValue){
    	SharedPreferences.Editor ed = _GetPrefEditor(context);
    	ed.putString(KEY_MEDIC_TIME2_DESCRIPTION_VAL, strValue);
    	ed.commit();
    }
    
    public static final String LoadMedicTime3DescriptionValue(Context context){
    	SharedPreferences pref = _GetPref(context);
    	return pref.getString(KEY_MEDIC_TIME3_DESCRIPTION_VAL, "Vitamin C   ");
    }
    
    public static final void SaveMedicTime3DescriptionValue(Context context, String strValue){
    	SharedPreferences.Editor ed = _GetPrefEditor(context);
    	ed.putString(KEY_MEDIC_TIME3_DESCRIPTION_VAL, strValue);
    	ed.commit();
    }    
    public static final boolean LoadMedicBellCheckedValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_MEDIC_BELL_CHECKED_VAL, false);   	
    }

    public static final void SaveMedicBellCheckedValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_MEDIC_BELL_CHECKED_VAL, bValue);
        ed.commit();
    }    
 
    public static final boolean LoadMedicVibrationCheckedValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_MEDIC_VIBRATION_CHECKED_VAL, false);   	
    }

    public static final void SaveMedicVibrationCheckedValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_MEDIC_VIBRATION_CHECKED_VAL, bValue);
        ed.commit();
    }        
 
    // sport page
    public static final int LoadSportTime1TimeHourValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_SPORT_TIME1_TIME_HOUR_VAL, 8);
    }
    
    public static final void SaveSportTime1TimeHourValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_SPORT_TIME1_TIME_HOUR_VAL, iValue);
        ed.commit();
    }
    
    public static final int LoadSportTime2TimeHourValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_SPORT_TIME2_TIME_HOUR_VAL, 16);
    }
    
    public static final void SaveSportTime2TimeHourValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_SPORT_TIME2_TIME_HOUR_VAL, iValue);
        ed.commit();
    }

    public static final int LoadSportTime3TimeHourValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_SPORT_TIME3_TIME_HOUR_VAL, 20);
    }
    
    public static final void SaveSportTime3TimeHourValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_SPORT_TIME3_TIME_HOUR_VAL, iValue);
        ed.commit();
    }
    
    public static final int LoadSportTime1TimeMinuteValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_SPORT_TIME1_TIME_MINUTE_VAL, 30);
    }
    
    public static final void SaveSportTime1TimeMinuteValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_SPORT_TIME1_TIME_MINUTE_VAL, iValue);
        ed.commit();
    }    

    public static final int LoadSportTime2TimeMinuteValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_SPORT_TIME2_TIME_MINUTE_VAL, 30);
    }
    
    public static final void SaveSportTime2TimeMinuteValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_SPORT_TIME2_TIME_MINUTE_VAL, iValue);
        ed.commit();
    }    
 
    public static final int LoadSportTime3TimeMinuteValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getInt(KEY_SPORT_TIME3_TIME_MINUTE_VAL, 0);
    }
    
    public static final void SaveSportTime3TimeMinuteValue(Context context, int iValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putInt(KEY_SPORT_TIME3_TIME_MINUTE_VAL, iValue);
        ed.commit();
    }    

    public static final String LoadSportTime1DescriptionValue(Context context){
    	SharedPreferences pref = _GetPref(context);
    	return pref.getString(KEY_SPORT_TIME1_DESCRIPTION_VAL, "Jogging      ");
    }
    
    public static final void SaveSportTime1DescriptionValue(Context context, String strValue){
    	SharedPreferences.Editor ed = _GetPrefEditor(context);
    	ed.putString(KEY_SPORT_TIME1_DESCRIPTION_VAL, strValue);
    	ed.commit();
    }

    public static final String LoadSportTime2DescriptionValue(Context context){
    	SharedPreferences pref = _GetPref(context);
    	return pref.getString(KEY_SPORT_TIME2_DESCRIPTION_VAL, "Basketball");
    }
    
    public static final void SaveSportTime2DescriptionValue(Context context, String strValue){
    	SharedPreferences.Editor ed = _GetPrefEditor(context);
    	ed.putString(KEY_SPORT_TIME2_DESCRIPTION_VAL, strValue);
    	ed.commit();
    }
    
    public static final String LoadSportTime3DescriptionValue(Context context){
    	SharedPreferences pref = _GetPref(context);
    	return pref.getString(KEY_SPORT_TIME3_DESCRIPTION_VAL, "Swimming");
    }
    
    public static final void SaveSportTime3DescriptionValue(Context context, String strValue){
    	SharedPreferences.Editor ed = _GetPrefEditor(context);
    	ed.putString(KEY_SPORT_TIME3_DESCRIPTION_VAL, strValue);
    	ed.commit();
    }
    
    public static final boolean LoadSportBellCheckedValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_SPORT_BELL_CHECKED_VAL, false);   	
    }

    public static final void SaveSportBellCheckedValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_SPORT_BELL_CHECKED_VAL, bValue);
        ed.commit();
    }    
 
    public static final boolean LoadSportVibrationCheckedValue(Context context)
    {
        SharedPreferences pref = _GetPref(context);
        return pref.getBoolean(KEY_SPORT_VIBRATION_CHECKED_VAL, false);   	
    }

    public static final void SaveSportVibrationCheckedValue(Context context, boolean bValue)
    {
        SharedPreferences.Editor ed = _GetPrefEditor(context);
        ed.putBoolean(KEY_SPORT_VIBRATION_CHECKED_VAL, bValue);
        ed.commit();
    }            
    // Private Method
    private static SharedPreferences _GetPref(Context context)
    {
        return context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }
    
    private static SharedPreferences.Editor _GetPrefEditor(Context context)
    {
        return _GetPref(context).edit();
    }
}

