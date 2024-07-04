package com.iteng.tx;

import java.util.Scanner;

public class _01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取数组大小
        int n = scanner.nextInt();
        int[] array = new int[n];

        // 读取数组元素
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int count = 0;

        // 遍历所有的两两组合
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // 检查乘积是否为完美数
                if (isPerfectNumber((long) array[i] * (long) array[j])) {
                    count++;
                }
            }
        }

        // 输出结果
        System.out.println(count);

        scanner.close();
    }

    // 判断一个数是否为完美数
    public static boolean isPerfectNumber(long num) {
        // 将数字转化为字符串以便逐位检查
        String numStr = String.valueOf(num);
        int nonZeroCount = 0;

        for (char c : numStr.toCharArray()) {
            if (c != '0') {
                nonZeroCount++;
            }
            // 如果非零数字超过一个，则不是完美数
            if (nonZeroCount > 1) {
                return false;
            }
        }
        // 非零数字正好是一个则是完美数
        return nonZeroCount == 1;
    }
}
