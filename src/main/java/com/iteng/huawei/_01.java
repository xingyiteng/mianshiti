package com.iteng.huawei;

import java.util.*;

public class _01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        Set<Integer> A = new HashSet<>();
        for(int i = 0; i < m; i++){
            int t = scanner.nextInt();
            A.add(t);
        }

        List<Integer> ans = new ArrayList<>();
        int n = scanner.nextInt();

        while(n-- > 0){
            int name = scanner.nextInt();
            int cnt = scanner.nextInt();
            System.out.println("name:" + name);
            System.out.println("cnt:" + cnt);

            boolean flag = false;
            while(cnt-- > 0){
                int t = scanner.nextInt();
                if (A.contains(t)) {
                    flag = true;
                }
                System.out.println("t:" + t);
            }
            if(flag){
                ans.add(name);
            }
        }
        int len = ans.size();
        System.out.println(len);
        Collections.sort(ans);
        for (Integer t : ans) {
            System.out.print(t);
            System.out.print(" ");
        }
    }
}
