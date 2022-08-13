package CodeSegment;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsUtils {
    public static void main(String[] args) {
        System.out.println("Hello Strings Utils!");
    }

    //判断字符串是否为空
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
    
    //判断字符串是否不为空且不为空格
    public static boolean isBlanket(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }

    //判断字符串是否为空或者全部为空格
    public static boolean isBlank(String str) {
        int length = str.length();
        if (length == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    //截取字符串 using String start and String end
    public static String substring(String str, String start, String end) {
        int startIndex = str.indexOf(start);
        int endIndex = str.indexOf(end);
        return str.substring(startIndex + start.length(), endIndex);
    }

    //截取字符串 using String start
    public static String subStartString(String str, String start) {
        int startIndex = str.indexOf(start);
        return str.substring(startIndex + start.length());
    }

    //截取字符串 using String end
    public static String subEndString(String str, String end) {
        int endIndex = str.indexOf(end);
        return str.substring(0, endIndex);
    }

    //截取字符串 using String start and int count
    public static String subStartString(String str, String start, int count) {
        int startIndex = str.indexOf(start);
        return str.substring(startIndex + start.length(), startIndex + start.length() + count);
    }

    //截取前 int count 字符串
    public static String subStartString(String str, int count) {
        return str.substring(0, count);
    }

    //截取后 int count 字符串
    public static String subEndString(String str, int count) {
        return str.substring(str.length() - count);
    }

    //插入字符串 
    public static String insertString(String str, String insert, int index) {
        return str.substring(0, index) + insert + str.substring(index);
    }

    //是否包含字符串
    public static boolean contains(String str, String subStr) {
        return str.indexOf(subStr) != -1;
    }

    //是否包含字符串不区分大小写
    public static boolean containsIgnoreCase(String str, String subStr) {
        return str.toLowerCase().indexOf(subStr.toLowerCase()) != -1;
    }

    //是否以字符串开头
    public static boolean startWith(String str, String start) {
        return str.startsWith(start);
    }

    //是否以字符串结尾
    public static boolean endWith(String str, String end) {
        return str.endsWith(end);
    }

    //替换字符串
    public static String replace(String str, String oldStr, String newStr) {
        return str.replace(oldStr, newStr);
    }

    //替换所有字符串
    public static String replaceAll(String str, String oldStr, String newStr) {
        return str.replaceAll(oldStr, newStr);
    }

    //去除字符串中的所有的空格/换行/制表符
    public static String trim(String str) {
        return str.replaceAll("\\s*", "");
    }

    //使用正则表达式去除字符串中的所有的空格/换行/制表符
    public static String replaceBlank(String content) {
        String dest = "";
        if (content != null) {
            Pattern p = Pattern.compile("\t|\r|\n");
            Matcher m = p.matcher(content);
            dest = m.replaceAll("");
        }
        return dest;
    }

    //格式化数字：千分位分隔符
    public static String formatNumber(String number) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(Double.parseDouble(number));
    }

    //使用正则表达式格式化数字：千分位分隔符
    public static String formatMoreNumber(String num) {
        StringBuffer tmp = new StringBuffer().append(num).reverse();
        String retNum = Pattern.compile("(\\d{3})(?=\\d)").matcher(tmp.toString()).replaceAll("$1,");
        return new StringBuffer().append(retNum).reverse().toString();
    }

    //比较字符串
    public static boolean equals(String str1, String str2) {
        return str1.equals(str2);
    }

    //比较字符串，忽略大小写
    public static boolean equalsIgnoreCase(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);
    }

    //字符串大写
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    //字符串小写
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    //字符串长度
    public static int length(String str) {
        return str.length();
    }
}
