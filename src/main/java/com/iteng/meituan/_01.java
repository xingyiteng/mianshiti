package com.iteng.meituan;

import java.util.Scanner;

/**
 * 小美的排列询问
 * https://kamacoder.com/problemcontest.php?cid=1047&pid=0
 */
public class _01 {
    public static void main(String[] args) {
        _01 c = new _01();
        c.main();
    }

    public void main(){
        final long MOD = (long) (1e9 + 7);
        Scanner sc = new Scanner(System.in);
        String ans = "No";
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int i = 1;
        while(n-- > 0){
            arr[sc.nextInt()] = i++;
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(arr[x] + 1 == arr[y] || arr[x] - 1 == arr[y]){
            ans = "Yes";
        }
        System.out.println(ans);
    }
}
