package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.*;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제
 * fileName       : 택배상자꺼내기
 * author         : leehyunjong
 * date           : 2025/04/13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/04/13        leehyunjong       최초 생성
 */
public class 택배상자꺼내기 {
    public static void main(String[] args) {
        int n=22;
        int w=6;
        int num=8;

        int result = solution(n,w,num);

        System.out.println(result);
    }

    static List<Integer[]> list;

    public static int solution(int n, int w, int num) {
            int answer = 0;

            init(n, w);

            int h = getIdx(w ,num);

            answer = getCnt(h, num);

            return answer;
    }

    public static int getCnt(int h, int num) {
        int cnt = 0;

        int idx = Arrays.asList(list.get(h)).indexOf(num);

        for(int i=h;i<list.size();i++) {
            Integer[] row = list.get(i);

            int e = row[idx];

            if(e != -1) {
                cnt++;
            }
        }

        return cnt;
    }

    public static int getIdx(int w, int num) {
        int size = list.size();

        int result = 0;
        for(int i=1;i<=size;i++) {
            if(i*w >= num) {
                result = i-1;
                break;
            }
        }

        return result;
    }

    public static void init(int n, int w) {
        list = new ArrayList<>();

        int wIdx = 0;
        int box = 1;
        boolean isFlag = true;
        while(box <= n) {
            Integer[] arr = new Integer[w];
            Arrays.fill(arr, -1);

            for(int i=0;i<w;i++) {
                if(box > n) {
                    break;
                }

                if(isFlag) {
                    arr[wIdx++] = box;
                }
                else {
                    arr[--wIdx] = box;
                }

                box++;
            }
            isFlag = !isFlag;

            list.add(arr);
        }

    }
}
