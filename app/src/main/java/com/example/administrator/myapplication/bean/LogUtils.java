package com.example.administrator.myapplication.bean;

import android.util.Log;

import com.example.administrator.myapplication.BuildConfig;
import com.example.administrator.myapplication.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * 基本使用方法：
 * 比如：LogUtils.e(消息)，或LogUtils.e(是否加边框，消息)；
 * 可以自定义log总开关，log标签，log写入文件开关
 *
 * 日志工具类
 */
public final class LogUtils {

    private LogUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static final int V = 0x01;
    public static final int D = 0x02;
    public static final int I = 0x04;
    public static final int W = 0x08;
    public static final int E = 0x10;
    public static final int A = 0x20;
    private static final int FILE = 0xF1;
    private static final int JSON = 0xF2;
    private static final int XML  = 0xF4;

    private static String dir;                          // log存储目录
    private static boolean sLogSwitch       = BuildConfig.DEBUG; // log总开关
    private static String sGlobalTag        = null;      // log标签
    private static boolean sLog2FileSwitch  = false;    // log写入文件开关
    private static boolean sLogBorderSwitch = false;    // log边框开关

    private static final String TOP_BORDER     = "╔═══════════════════════════════════════════════════════════════════════════════════════════════════";
    private static final String LEFT_BORDER    = "║ ";
    private static final String SPLIT_LINE     = "║═══════════════════════════════════════════════════════════════════════════════════════════════════";
    private static final String BOTTOM_BORDER  = "╚═══════════════════════════════════════════════════════════════════════════════════════════════════";
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private static final int    MAX_LEN   = 4000;
    private static final String NULL_TIPS = "Log with null object.";
    private static final String NULL      = "null";
    private static final String ARGS      = "args";

    public static void v(Object... contents) {
        log(V, sGlobalTag, contents);
    }

    public static void v(Boolean logBorderSwitch, Object... contents) {
        sLogBorderSwitch = logBorderSwitch;
        log(V, sGlobalTag, contents);
    }

    public static void d(Object... contents) {
        log(D, sGlobalTag, contents);
    }

    public static void d(Boolean logBorderSwitch, Object... contents) {
        sLogBorderSwitch = logBorderSwitch;
        log(D, sGlobalTag, contents);
    }

    public static void i(Object... contents) {
        log(I, sGlobalTag, contents);
    }

    public static void i(Boolean logBorderSwitch, Object... contents) {
        sLogBorderSwitch = logBorderSwitch;
        log(I, sGlobalTag, contents);
    }

    public static void w(Object... contents) {
        log(W, sGlobalTag, contents);
    }

    public static void w(Boolean logBorderSwitch, Object... contents) {
        sLogBorderSwitch = logBorderSwitch;
        log(W, sGlobalTag, contents);
    }

    public static void e(Object... contents) {
        log(E, sGlobalTag, contents);
    }

    public static void e(Boolean logBorderSwitch, Object... contents) {
        sLogBorderSwitch = logBorderSwitch;
        log(E, sGlobalTag, contents);
    }

    public static void a(Object... contents) {
        log(A, sGlobalTag, contents);
    }

    public static void a(Boolean logBorderSwitch, Object... contents) {
        sLogBorderSwitch = logBorderSwitch;
        log(A, sGlobalTag, contents);
    }

    public static void file(Object contents) {
        log(FILE, sGlobalTag, contents);
    }

    public static void json(String contents) {
        sLogBorderSwitch = true;
        log(JSON, sGlobalTag, contents);
    }

    public static void xml(String contents) {
        sLogBorderSwitch = true;
        log(XML, sGlobalTag, contents);
    }

    private static void log(int type, String tag, Object... contents) {
        if (!sLogSwitch) return;
        final String[] processContents = processContents(type, tag, contents);
        tag = processContents[0];
        String msg = processContents[1];
        switch (type) {
            case V:
            case D:
            case I:
            case W:
            case E:
            case A:
                printLog(type, tag, msg);
                if (sLog2FileSwitch) {
                    if (dir == null) {
                        dir = MyApplication.getInstance().getExternalCacheDir() + File.separator + "log" + File.separator;
                    }
                    print2File(tag, msg);
                }
                break;
            case FILE:
                print2File(tag, msg);
                break;
            case JSON:
                printLog(D, tag, msg);
                break;
            case XML:
                printLog(D, tag, msg);
                break;
        }

    }

    private static String[] processContents(int type, String tag, Object... contents) {
        StackTraceElement targetElement = Thread.currentThread().getStackTrace()[5];
        String className = targetElement.getClassName();
        String[] classNameInfo = className.split("\\.");
        if (classNameInfo.length > 0) {
            className = classNameInfo[classNameInfo.length - 1];
        }
        if (className.contains("$")) {
            className = className.split("\\$")[0];
        }
        tag = sGlobalTag == null ? className : sGlobalTag;

        String head = "";
        if (sLogBorderSwitch) {
            head = " "+ LINE_SEPARATOR
                    + TOP_BORDER + LINE_SEPARATOR
                    + LEFT_BORDER + new Formatter().format("Thread: %s, %s(%s.java:%d)" + LINE_SEPARATOR,
                            Thread.currentThread().getName(),
                            targetElement.getMethodName(),
                            className,
                            targetElement.getLineNumber()).toString()
                    + SPLIT_LINE + LINE_SEPARATOR;
        }

        String msg = NULL_TIPS;
        if (contents != null) {
            if (contents.length == 1) {
                Object object = contents[0];
                msg = object == null ? NULL : object.toString();
                if (type == JSON) {
                    msg = formatJson(msg);
                } else if (type == XML) {
                    msg = formatXml(msg);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0, len = contents.length; i < len; ++i) {
                    Object content = contents[i];
                    sb.append(ARGS)
                            .append("[")
                            .append(i)
                            .append("]")
                            .append(" = ")
                            .append(content == null ? NULL : content.toString())
                            .append(LINE_SEPARATOR);
                }
                msg = sb.toString();
            }
        }
        if (sLogBorderSwitch) {
            StringBuilder sb = new StringBuilder();
            String[] lines = msg.split(LINE_SEPARATOR);
            for (String line : lines) {
                sb.append(LEFT_BORDER).append(line).append(LINE_SEPARATOR);
            }
            msg = sb.toString();
        }
        return new String[]{tag, head + msg};
    }

    private static String formatJson(String json) {
        try {
            if (json.startsWith("{")) {
                json = new JSONObject(json).toString(4);
            } else if (json.startsWith("[")) {
                json = new JSONArray(json).toString(4);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    private static String formatXml(String xml) {
        try {
            Source xmlInput = new StreamSource(new StringReader(xml));
            StreamResult xmlOutput = new StreamResult(new StringWriter());
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(xmlInput, xmlOutput);
            xml = xmlOutput.getWriter().toString().replaceFirst(">", ">" + LINE_SEPARATOR);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }

    private static void printLog(int type, String tag, String msg) {
        int len = msg.length();
        int countOfSub = len / MAX_LEN;
        if (countOfSub > 0) {
            int index = 0;
            String sub;
            for (int i = 0; i < countOfSub; i++) {
                sub = msg.substring(index, index + MAX_LEN);
                printSubLog(type, tag, sub);
                index += MAX_LEN;
            }
            printSubLog(type, tag, msg.substring(index, len));
        } else {
            printSubLog(type, tag, msg);
        }
        if (sLogBorderSwitch) printSubLog(type, tag, BOTTOM_BORDER);
        sLogBorderSwitch = false;
    }

    private static void printSubLog(final int type, final String tag, String msg) {
        switch (type) {
            case V:
                Log.v(tag, msg);
                break;
            case D:
                Log.d(tag, msg);
                break;
            case I:
                Log.i(tag, msg);
                break;
            case W:
                Log.w(tag, msg);
                break;
            case E:
                Log.e(tag, msg);
                break;
            case A:
                Log.wtf(tag, msg);
                break;
        }
    }

    private synchronized static void print2File(final String tag, final String msg) {
        Date now = new Date();
        String date = new SimpleDateFormat("MM-dd", Locale.getDefault()).format(now);
        final String fullPath = dir + date + ".txt";
        if (!createOrExistsFile(fullPath)) {
            Log.e(tag, "log to " + fullPath + " failed!");
            return;
        }
        String time = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault()).format(now);
        StringBuilder sb = new StringBuilder();
        if (sLogBorderSwitch) sb.append(TOP_BORDER).append(LINE_SEPARATOR);
        sb.append(time)
                .append(tag)
                .append(": ")
                .append(msg)
                .append(LINE_SEPARATOR);
        if (sLogBorderSwitch) sb.append(BOTTOM_BORDER).append(LINE_SEPARATOR);
        final String dateLogContent = sb.toString();
        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedWriter bw = null;
                try {
                    bw = new BufferedWriter(new FileWriter(fullPath, true));
                    bw.write(dateLogContent);
                    Log.d(tag, "log to " + fullPath + " success!");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e(tag, "log to " + fullPath + " failed!");
                } finally {
                    try {
                        if (bw != null) {
                            bw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private static boolean createOrExistsFile(String filePath) {
        return createOrExistsFile(isSpace(filePath) ? null : new File(filePath));
    }

    private static boolean createOrExistsFile(File file) {
        if (file == null) return false;
        if (file.exists()) return file.isFile();
        if (!createOrExistsDir(file.getParentFile())) return false;
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean createOrExistsDir(File file) {
        return file != null && (file.exists() ? file.isDirectory() : file.mkdirs());
    }

    private static boolean isSpace(String s) {
        if (s == null) return true;
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}