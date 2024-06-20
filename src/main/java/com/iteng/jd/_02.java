package com.iteng.jd;

import java.util.Scanner;

/**
 * 小红买药
 * https://kamacoder.com/problemcontest.php?cid=1048&pid=1
 */
public class _02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        char[] o = s.toCharArray();
        int count1 = 0;
        for (char c : o) {
            if(c == '1'){
                count1++;
            }
        }
        int m = scanner.nextInt();
        scanner.nextLine();
        char[][][] arr = new char[m][2][n];
        for (int i = 0; i < m; i++) {
            String t0 = scanner.nextLine();
            arr[i][0] = t0.toCharArray();
            String t1 = scanner.nextLine();
            arr[i][1] = t1.toCharArray();
        }
        int q = scanner.nextInt();
        int[] ans = new int[q];
        for(int i = 0; i < q; i++){
            int t = scanner.nextInt() - 1;
            char[][] temp =  arr[t];
            char[] t1 = temp[0];
            char[] t2 = temp[1];
            // 遍历第一维
            for (int j = 0; j < t1.length; j++) {
                if(t1[j] == '1' && o[j] == '1'){
                    count1--;
                    o[j] = '0';
                }
            }
            // 遍历第二维
            for (int j = 0; j < t2.length; j++) {
                if(t2[j] == '1' && o[j] != '1'){
                    count1++;
                    o[j] = '1';
                }
            }
            ans[i] = count1;
        }
        for (int an : ans) {
            System.out.println(an);
        }
        scanner.close();
    }
}
