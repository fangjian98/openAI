package CodeSegment;

public class LogUtils {

    private static final String TAG = "ProjectName";
    private static final boolean isEnable = true;

    public static void main(String[] args) {
        System.out.println("Hello LogUtils!");
    }

    //DEBUG
    public static void d(String msg) {
        if (isEnable) {
            Log.d(TAG, getCallerInfo() + msg);
        }
    }

    //INFO
    public static void i(String msg) {
        if (isEnable) {
            Log.i(TAG, getCallerInfo() + msg);
        }
    }

    //WARN
    public static void w(String msg) {
        if (isEnable) {
            Log.w(TAG, getCallerInfo() + msg);
        }
    }

    //ERROR
    public static void e(String msg) {
        if (isEnable) {
            Log.e(TAG, getCallerInfo() + msg);
        }
    }

    //获取调用信息
    private static String getCallerInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement caller = stackTrace[4];
        return caller.getClassName() + " " + caller.getMethodName() + " " + caller.getLineNumber() + " ";
    }

    //Java Log
    private static class Log {
        public static void d(String tag, String msg) {
            System.out.println("DEBUG: " + tag + " " + msg);
        }

        public static void i(String tag, String msg) {
            System.out.println("INFO: " + tag + " " + msg);
        }

        public static void w(String tag, String msg) {
            System.out.println("WARN: " + tag + " " + msg);
        }

        public static void e(String tag, String msg) {
            System.out.println("ERROR: " + tag + " " + msg);
        }
    }

}
