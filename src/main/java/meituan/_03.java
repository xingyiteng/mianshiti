package meituan;

import java.util.Scanner;

/**
 * 小美的蛋糕切割
 * https://kamacoder.com/problemcontest.php?cid=1047&pid=2
 * https://www.cnblogs.com/ganyq/p/18114989
 */
public class _03 {
    public static void main(String[] args) {
        _03 c = new _03();
        c.main();
    }

    public void main(){
        final long MOD = (long) (1e9 + 7);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        long sum = 0;
        int[] sumRow = new int[n];
        int[] sumCol = new int[m];
        for(int i = 0; i < n; i++){
            if(i > 0){
                sumRow[i] = sumRow[i - 1];
            }
            for(int j = 0; j < m; j++){
                arr[i][j] = scanner.nextInt();
                sum += arr[i][j];
                sumRow[i] += arr[i][j];
            }
        }
        for(int i = 0; i < m; i++){
            if(i > 0){
                sumCol[i] = sumCol[i - 1];
            }
            for(int j = 0; j < n; j++){
                sumCol[i] += arr[j][i];
            }
        }
        long diff1 = sum;
        for (int i = 0; i < n - 1; i++) {
            long t1 = sumRow[i];
            long t2 = sum - t1;
            diff1 = Math.min(diff1, Math.abs(t1 - t2));
        }
        long diff2 = sum;
        for (int i = 0; i < m - 1; i++) {
            long t1 = sumCol[i];
            long t2 = sum - t1;
            diff2 = Math.min(diff2, Math.abs(t1 - t2));
        }
        System.out.println(Math.min(diff1, diff2));
    }

    public void main2(){
        final long MOD = (long) (1e9 + 7);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        long[] preSumCol = new long[m]; // 列前缀和
        long[] preSumRow = new long[n]; // 行前缀和
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int in = scanner.nextInt();
                preSumCol[j] += in; // 只是当前列的值
                preSumRow[i] += in; // 只是当前行的值
            }
            if(i > 0)
                preSumRow[i] += preSumRow[i - 1]; // 计算行前缀和
        }
        for(int j = 1; j < m; j++) preSumCol[j] += preSumCol[j - 1]; // 计算列前缀和

        // 先竖着切
        // 初始值 表示在第0列的左边竖着切一刀
        long res = preSumCol[m - 1];
        //j表示在第j列的右边竖着切一刀
        for(int j = 0; j < m; j++){
            long left = preSumCol[j];
            long right = preSumCol[m - 1] - preSumCol[j];
            res = Math.min(res, Math.abs(left - right));
        }

        // 横着切 同样先是第0行的上边横着切一刀
        res = Math.min(res, preSumRow[n - 1]);
        // i表示在第i行的上边横着切一刀
        for(int i = 0; i < n; i++){
            long up = preSumRow[i];
            long down = preSumRow[n - 1] - preSumRow[i];
            res = Math.min(res, Math.abs(up - down));
        }


        System.out.println(res);
    }
}
