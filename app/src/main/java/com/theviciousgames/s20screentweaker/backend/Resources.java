package com.theviciousgames.s20screentweaker.backend;

import java.util.concurrent.TimeUnit;

public class Resources
{
    public static String SCREEN_HZ_CHANGE_TO_48_MIN = "settings put system min_refresh_rate 48.0 ";
    public static String SCREEN_HZ_CHANGE_TO_48_PEAK = "settings put system peak_refresh_rate 48.0 ";
    public static String SCREEN_HZ_CHANGE_TO_60_MIN = "settings put system min_refresh_rate 60.0 ";
    public static String SCREEN_HZ_CHANGE_TO_60_PEAK = "settings put system peak_refresh_rate 60.0 ";
    public static String SCREEN_HZ_CHANGE_TO_96_MIN = "settings put system min_refresh_rate 96.0 ";
    public static String SCREEN_HZ_CHANGE_TO_96_PEAK = "settings put system peak_refresh_rate 96.0 ";
    public static String SCREEN_HZ_CHANGE_TO_120_MIN = "settings put system min_refresh_rate 120.0 ";
    public static String SCREEN_HZ_CHANGE_TO_120_PEAK = "settings put system peak_refresh_rate 120.0 ";

    public static String SCREEN_RESOLUTION_CHANGE_TO_HD="wm size 720x1600 & wm density 300 ";
    public static String SCREEN_RESOLUTION_CHANGE_TO_FHD="wm size 1080x2400 & wm density 450 ";
    public static String SCREEN_RESOLUTION_CHANGE_TO_WQHD="wm size 1440x3200 & wm density 600 ";

    public static String SCREEN_DEFAULT_MODES_DELETE="settings delete secure refresh_rate_mode ";
    public static String SCREEN_DEFAULT_MODES_SET_TO_0="settings put secure refresh_rate_mode 0 ";
    public static String SCREEN_DEFAULT_MODES_SET_TO_1="settings put secure refresh_rate_mode 1 ";
    public static String SCREEN_DEFAULT_MODES_SET_TO_2="settings put secure refresh_rate_mode 2 ";

    public static String SCREEN_HZ_VALUE_48="48";
    public static String SCREEN_HZ_VALUE_60="60";
    public static String SCREEN_HZ_VALUE_96="96";
    public static String SCREEN_HZ_VALUE_120="120";

    public static String SCREEN_RESOLUTION_VALUE_HD="HD";
    public static String SCREEN_RESOLUTION_VALUE_FHD="FHD";
    public static String SCREEN_RESOLUTION_VALUE_WQHD="WQHD";

    public static int NUMBER_OF_CORES=Runtime.getRuntime().availableProcessors();
    public static TimeUnit KEEP_ALIVE_TIME_UNIT=TimeUnit.SECONDS;
    public static int KEEP_ALIVE_TIME=1;
    public static int sTAG=1;


}
