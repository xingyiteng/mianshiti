package com.iteng.huawei;


import java.util.*;

//超时
public class _02 {
    private static StringBuilder sb = new StringBuilder();
    private static int i = 0;
    private static int len = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            if ("end".equals(s)) {
                break;
            }
            String[] t = s.split(" ");
            String arg0 = t[0];
            String arg1 = null;
            if (t.length != 1){
                arg1 = t[1];
            }
            helper(arg0, arg1);
        }
        System.out.println(sb.toString());
    }

    private static void helper(String arg0, String arg1) {
        if ("insert".equals(arg0)) {
            sb.insert(i, arg1);
            i+=arg1.length();
            len+=arg1.length();
            return;
        }

        if ("move".equals(arg0)) {
            int c = Integer.parseInt(arg1);
            if(c < 0){
                if(-c > i){
                    return;
                }
            }else {
                if(c > len - i){
                    return;
                }
            }
            i+=c;
        }

        if ("delete".equals(arg0)) {
            int c = Integer.parseInt(arg1);
            if(c <= 0 || c > len){
                return;
            }
            if(c > i){
                return;
            }
            sb.delete(i - c, i);
            i -= c;
            len -= c;
        }

        if ("copy".equals(arg0)) {
            String substring = sb.substring(0, i);
            sb.insert(i, substring);
            len += substring.length();
            i+=substring.length();
        }
    }
}
