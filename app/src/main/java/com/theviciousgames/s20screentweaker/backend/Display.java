package com.theviciousgames.s20screentweaker.backend;

import android.app.Activity;
import android.util.DisplayMetrics;

public class Display
{
    public static class RefreshRate
    {
        public void changeScreenHz(String RateVal)
        {
            switch (RateVal)
            {
                case "48":
                    Tools.SU.executeCommandSU(Resources.SCREEN_HZ_CHANGE_TO_48_MIN + "& " + Resources.SCREEN_HZ_CHANGE_TO_48_PEAK);
                    break;
                case "60":
                    Tools.SU.executeCommandSU( Resources.SCREEN_DEFAULT_MODES_SET_TO_0 + "& " + Resources.SCREEN_HZ_CHANGE_TO_60_MIN + "& " + Resources.SCREEN_HZ_CHANGE_TO_60_PEAK);
                    break;
                case "96":
                    Tools.SU.executeCommandSU(Resources.SCREEN_HZ_CHANGE_TO_96_MIN + "& " + Resources.SCREEN_HZ_CHANGE_TO_96_PEAK);
                    break;
                case "120":
                    Tools.SU.executeCommandSU(Resources.SCREEN_DEFAULT_MODES_SET_TO_2 + " & " +Resources.SCREEN_HZ_CHANGE_TO_120_MIN + "& " + Resources.SCREEN_HZ_CHANGE_TO_120_PEAK);
                    break;
            }
        }
        public static String getCurrentRefreshRate(Activity activity) {
            String refreshRate = activity.getWindowManager().getDefaultDisplay().getRefreshRate() + "";

            return refreshRate;
        }
    }
        public static class Resolution
        {
            public void changeScreenResolution(String ResVal)
            {
                switch(ResVal)
                {
                    case "HD":
                        Tools.SU.executeCommandSU(Resources.SCREEN_RESOLUTION_CHANGE_TO_HD);
                        break;
                    case "FHD":
                        Tools.SU.executeCommandSU(Resources.SCREEN_RESOLUTION_CHANGE_TO_FHD);
                        break;
                    case "WQHD":
                        Tools.SU.executeCommandSU(Resources.SCREEN_RESOLUTION_CHANGE_TO_WQHD);
                        break;
                }
            }
            public static int getCurrentVerticalPixels(Activity activity) {

                DisplayMetrics displayMetrics = new DisplayMetrics();
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int height = displayMetrics.heightPixels;


                return height;
            }
        }
    }

