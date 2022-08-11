package com.maxxspace.leetcode;


import java.util.Scanner;

/**
 *
 * <a href="https://blog.csdn.net/qq_34465338/article/details/125249545">...</a>
 *
 * 标题：字符串分割 | 时间限制：1秒 | 内存限制：262144K | 语言限制：不限
 * 给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，给定正整数K，要求除第一个子串外，其余的子串每K个字符组成新的子串，并用‘-’分隔。
 * 对于新组成的每一个子串，如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母；反之，如果它含有的大写字母比
 * 小写字母多，则将这个子串的所有小写字母转换为大写字母；大小写字母的数量相等时，不做转换。
 * <p>
 * 输入描述:
 * 输入为两行，第一行为参数K，第二行为字符串S。
 * 输出描述:
 * 输出转换后的字符串。
 * <p>
 * 示例1
 * 输入
 * 3
 * 12abc-abCABc-4aB@
 * 输出
 * 12abc-abc-ABC-4aB-@
 * 说明
 * 子串为12abc、abCABc、4aB@，第一个子串保留，后面的子串每3个字符一组为abC、ABc、4aB、@，abC中小写字母较多，
 * 转换为abc，ABc中大写字母较多，转换为ABC，4aB中大小写字母都为1个，不做转换，@中没有字母，连起来即12abc-abc-ABC-4aB-@
 * <p>
 * 示例2
 * 输入
 * 12
 * 12abc-abCABc-4aB@
 * 输出
 * 12abc-abCABc4aB@
 * 说明
 * 子串为12abc、abCABc、4aB@，第一个子串保留，后面的子串每12个字符一组为abCABc4aB@，这个子串中大小写字母都为4个，不做转换，连起来即12abc-abCABc4aB@
 * <p>
 * 解题思路：
 * 将除了第一个子串外的其他所有子串拼接成一个长字符串
 * 对拼接后的长字符串进行K长度的分割
 * 对分割出来的字符串进行格式化（题意中的大小写变化）
 * 使用”-”将格式化的各子串进行拼接
 */


public class StringSplit{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] s = sc.nextLine().split("-");

        String string = "";
        String res = "";

        for(int i=1;i<s.length;i++){
            string+=s[i];   //将除了第一个子串之外的所有子串拼接成长字符串
        }

        int step; //字符串分割的终点位置
        for(int i=0;i<=string.length();i+=n){
            if(i+n>string.length()){
                step = string.length();
            }else {
                step = i+n;
            }
            res+="-"+geshihua(string.substring(i,step));    //将字符串进行分割并格式化
        }

        System.out.println(s[0]+res);
    }

    public static String geshihua(String s){
        int low = 0;  //小写字母数量
        int up = 0; //大写字母数量
        String res = "";
        for(int i=0;i<s.length();i++){  //计算大小写字母数量
            if(Character.isLowerCase(s.charAt(i))){
                low++;
            }else if(Character.isUpperCase(s.charAt(i))){
                up++;
            }
        }
        if(low>up){ //小写字母数量大于大写字母数量
            for(int i=0;i<s.length();i++){
                if(Character.isUpperCase(s.charAt(i))){
                    res+=Character.toLowerCase(s.charAt(i)); //将所有大写字母转换成小写字母
                    continue;
                }
                res+=s.charAt(i);
            }
        } else if(low<up){  //大写字母数量大于小写字母数量
            for(int i=0;i<s.length();i++){
                if(Character.isLowerCase(s.charAt(i))){
                    res+=Character.toUpperCase(s.charAt(i));    //将所有小写字母转换成大写字母
                    continue;
                }
                res+=s.charAt(i);
            }
        }else {
            res = s;
        }
        return res;
    }

}