package com.theviciousgames.s20screentweaker.backend;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Vibrator;

import java.util.ArrayList;
import java.util.List;

import eu.chainfire.libsuperuser.Shell;

public class Tools {
    public static class SU {
        public static String executeCommandSH(String command) {
            List<String> stdout = new ArrayList<>();
            List<String> stderr = new ArrayList<>();
            try {
                Shell.Pool.SH.run(command, stdout, stderr, true);
            } catch (Shell.ShellDiedException e) {
                e.printStackTrace();
            }
            if (stdout == null)
                return null;
            StringBuilder stringBuilder = new StringBuilder();
            for (String line : stdout) {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();
        }

        public static String executeCommandSU(String command) {
            List<String> stdout = new ArrayList<>();
            List<String> stderr = new ArrayList<>();
            try {
                Shell.Pool.SU.run(command, stdout, stderr, true);
            } catch (Shell.ShellDiedException e) {
                e.printStackTrace();
            }
            if (stdout == null)
                return null;
            StringBuilder stringBuilder = new StringBuilder();
            for (String line : stdout) {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();
        }
    }

    public static class Utils {
        public static Display.Resolution CreateResolutionObj() {
            Display.Resolution ResolutionManager = new Display.Resolution();
            return ResolutionManager;
        }

        public static Display.RefreshRate CreateRefreshRateObj() {
            Display.RefreshRate RefreshRateManager = new Display.RefreshRate();
            return RefreshRateManager;
        }

        public static void changeScreenResolutionTo(String resVal) {
            CreateResolutionObj().changeScreenResolution(resVal);
        }

        public static void changeScreenRefreshRateTo(String rateVal) {
            CreateRefreshRateObj().changeScreenHz(rateVal);
        }

        public static void changeResAndRateTo(String resVal, String rateVal) {
            changeScreenResolutionTo(resVal);
            changeScreenRefreshRateTo(rateVal);
        }

        public static String getRefreshRate(Activity activity)
        {
            return Display.RefreshRate.getCurrentRefreshRate(activity);
        }

        public static void vibration(Context context)
        {
            Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
            v.vibrate(50);
        }
    }
}
