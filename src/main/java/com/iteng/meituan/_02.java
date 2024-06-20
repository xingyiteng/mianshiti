package com.iteng.meituan;

import java.util.Scanner;

/**
 * 小美走公路
 * https://kamacoder.com/problemcontest.php?cid=1047&pid=1
 */
public class _02 {
    public static void main(String[] args) {
        _02 c = new _02();
        c.main();
    }

    public void main(){
        final long MOD = (long) (1e9 + 7);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] roads = new int[n];
        for(int i = 0; i < n; i++){
            roads[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        long forward = 0, backward = 0;

        for(int i = x - 1; i != y - 1; i = (i + 1) % n){
            forward += roads[i];
        }
        for(int i = x - 1; i != y - 1; i = (i - 1 + n) % n){
            // roads 记录的是正走的距离 反走的距离应该看前一个road[i-1]
            backward += roads[(i - 1 + n) % n];
        }

        System.out.println(Math.min(forward, backward));
    }
}
