package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.util.Comparator;
public class 날짜비교하기 {

    public static void main(String[] args) {
        int[] date1 = {2022, 1, 1};
        int[] date2 = {2021, 12, 31};

        ArrayComparator arrCompare = new ArrayComparator();

        int result = arrCompare.compare(date1, date2);

        int test = Integer.compare(2022, 2021);
        System.out.println(test);

        System.out.println(result);
    }
}

class ArrayComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] arr1, int[] arr2) {

        int result = 0;
        if(arr1[0] != arr2[0]) {
            result = Integer.compare(arr2[0], arr1[0]);
        }

        else if(arr1[1] != arr2[1]) {
            result = Integer.compare(arr2[1], arr1[1]);
        }

        else if(arr1[2] != arr2[2]) {
            result = Integer.compare(arr2[2], arr1[2]);
        }

        return result == -1 ? 0 : result;

    }
}
