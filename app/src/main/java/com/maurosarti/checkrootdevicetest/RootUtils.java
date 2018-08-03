package com.maurosarti.checkrootdevicetest;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RootUtils {

    public static boolean isDeviceRooted() {
        return checkRootMethod1() || checkRootMethod2() || checkRootMethod3() || checkRootMethod4();
    }

    public static boolean checkRootMethod1() {
        String buildTags = android.os.Build.TAGS;
        return buildTags != null && buildTags.contains("test-keys");
    }

    public static boolean checkRootMethod2() {
        String[] paths = { "/data/local/bin/su",
                "/data/local/su",
                "/data/local/xbin/su",
                "/sbin/su",
                "/su/bin/su",
                "/system/app/Superuser.apk",
                "/system/bin/failsafe/su",
                "/system/bin/su",
                "/system/xbin/su",
                "/system/sd/xbin/su"
        };
        for (String path : paths) {
            if (new File(path).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkRootMethod3() {
        Process process = null;
        try {
            List<String> commands = new ArrayList<>();
            commands.add("/system/xbin/which su");
            commands.add("/system/bin/which su");
            commands.add("which su");
            commands.add("su");

            for (String command : commands){
                try {
                    process = Runtime.getRuntime().exec(command);
                    BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    if (in.readLine() != null) {
                        return true;
                    }
                } catch (Throwable t){

                } finally {
                    if (process != null) {
                        process.destroy();
                    }
                }
            }
            return false;
        } catch (Throwable t) {
            return false;
        }
    }

    public static boolean checkRootMethod4() {
        // get from build info
        String buildTags = android.os.Build.TAGS;
        if (buildTags != null && buildTags.contains("test-keys")) {
            return true;
        }
        return false;
    }
}
