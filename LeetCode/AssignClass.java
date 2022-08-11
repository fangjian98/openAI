package com.maxxspace.leetcode;

import java.util.Scanner;

/**
 *
 * <a href="https://blog.csdn.net/qq_34465338/article/details/125248732">...</a>
 *
 * 标题：分班 | 时间限制：1秒 | 内存限制：262144K | 语言限制：不限
 * 幼儿园两个班的小朋友在排队时混在了一起，每位小朋友都知道自己是否与前面一位小朋友是否同班，请你帮忙把同班的小朋友找出来。
 * 小朋友的编号为整数，与前一位小朋友同班用Y表示，不同班用N表示。
 * <p>
 * 输入描述:
 * 输入为空格分开的小朋友编号和是否同班标志。
 * 比如：6/N 2/Y 3/N 4/Y，表示共4位小朋友，2和6同班，3和2不同班，4和3同班。
 * 其中，小朋友总数不超过999，每个小朋友编号大于0，小于等于999。
 * 不考虑输入格式错误问题。
 * <p>
 * 输出描述:
 * 输出为两行，每一行记录一个班小朋友的编号，编号用空格分开。且：
 * 1、编号需要按照大小升序排列，分班记录中第一个编号小的排在第一行。
 * 2、若只有一个班的小朋友，第二行为空行。
 * 3、若输入不符合要求，则直接输出字符串ERROR。
 * <p>
 * 示例1
 * 输入
 * 1/N 2/Y 3/N 4/Y
 * 输出
 * 1 2
 * 3 4
 * 说明
 * 2的同班标记为Y，因此和1同班。
 * 3的同班标记为N，因此和1、2不同班。
 * 4的同班标记为Y，因此和3同班。
 * 所以1、2同班，3、4同班，输出为
 * 1 2
 * 3 4
 * <p>
 * 解题思路：
 * 需要一个boolean值来转换班级
 * True：一班
 * N：表示在二班
 * Y：表示在一班
 * False：二班
 * N：表示在一班
 * Y：表示在二班
 */

public class AssignClass{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");

        String list1 = "";  //一班
        String list2 = "";  //二班

        list1 += strings[0].split("/")[0] + " ";    //第一位直接安排一班
        boolean b = true;   //用来转换班级 true为一班 false为二班

        for(int i=1;i<strings.length;i++){
            String[] x = strings[i].split("/");
            if(b){  //此时是一班
                if(x[1].equals("N")){
                    list2 += x[0] + " " ;   //非一班
                    b = false;
                }else {
                    list1 += x[0] + " ";
                }
            } else {    //此时是二班
                if(x[1].equals("N")){
                    list1 += x[0] + " ";   //非二班
                    b = true;
                }else {
                    list2 += x[0] + " ";
                }
            }
        }
        System.out.println(list1.substring(0, list1.length()-1));
        System.out.println(list2.substring(0, list2.length()-1));
    }
}