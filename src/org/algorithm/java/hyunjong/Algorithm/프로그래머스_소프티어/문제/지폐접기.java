package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제
 * fileName       : 지폐접기
 * author         : leehyunjong
 * date           : 2025/04/16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/04/16        leehyunjong       최초 생성
 */
public class 지폐접기 {
    public static void main(String[] args) {
        int[] wallet = {50, 50};
        int[] bill = {100,241};

        int result = solution(wallet, bill);

        System.out.println(result);
    }

    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;

        setSize(wallet);
        setSize(bill);

        while(compareSize(wallet, bill)) {
            bill[0] = bill[0]/2;

            setSize(bill);
            answer++;
        }

        return answer;
    }

    public static boolean compareSize(int[] w, int[] b) {
        int wb = w[0];
        int ws = w[1];
        int bb = b[0];
        int bs = b[1];

        return (ws < bs || wb < bb);
    }

    //0 : 큰쪽, 1 : 작은쪽
    public static void setSize(int[] arr) {
        int a = arr[0];
        int b = arr[1];

        if(a>b) {
            arr[0] = a;
            arr[1] = b;
        }
        else {
            arr[0] = b;
            arr[1] = a;
        }
    }
}
