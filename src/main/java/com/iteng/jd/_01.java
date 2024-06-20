package com.iteng.jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 夹吃棋
 * https://kamacoder.com/problemcontest.php?cid=1048&pid=0
 */
public class _01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<String> ans = new ArrayList<>();
        scanner.nextLine();
        while(t-- > 0){
            char[][] ch = new char[3][3];
            for(int i = 0; i < 3; i++){
                String s = scanner.nextLine();
                ch[i] = s.toCharArray();
            }
            int white = 0;
            int black = 0;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    char c = ch[i][j];
                    if(j == 1){
                        if(c == '.') continue;
                        if(c == 'o'){
                            if(ch[i][j - 1] == '*' && ch[i][j + 1] == '*'){
                                white+=1;
                            }
                        }
                        if(c == '*'){
                            if(ch[i][j - 1] == 'o' && ch[i][j + 1] == 'o'){
                                black+=1;
                            }
                        }
                    }
                    if(i == 1){
                        if(c == '.') continue;
                        if(c == 'o'){
                            if(ch[i - 1][j] == '*' && ch[i + 1][j] == '*'){
                                white+=1;
                            }
                        }
                        if(c == '*'){
                            if(ch[i - 1][j] == 'o' && ch[i + 1][j] == 'o'){
                                black+=1;
                            }
                        }
                    }
                }
            }
            if((white > 0 && black > 0) || (white == 0 && black == 0)){
                ans.add("draw");
            }else if(white > black){
                ans.add("kou");
            }else{
                ans.add("yukan");
            }
        }
        for (String an : ans) {
            System.out.println(an);
        }
    }
}
