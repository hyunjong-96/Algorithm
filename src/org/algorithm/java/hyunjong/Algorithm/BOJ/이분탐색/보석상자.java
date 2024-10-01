package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 보석상자 {
    static int[] jArr;
    static int maxJ;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        jArr = new int[M+1];
        maxJ = 0;
        for(int i=0;i<M;i++){
            jArr[i] = Integer.parseInt(br.readLine());
            maxJ = Math.max(jArr[i], maxJ);
        }

        int result = binarySearch();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    /*
    보석을 나눠줄수 있는 최대의 개수 중 최소값을 구하는 문제
    10억 명의 아이들에게 보석을 나누워줄수 있는 최대의 최소를 구하려면 가지고있는 보석의 종류 중 가장 많은 개수까지에서 정의해야한다.

    보석의 개수는 최대 10만이기 때문에 logN의 시간복잡도인 이분탐색을 사용해야한다.

    예를 들어 5명의 아이들에게 1번 보석 4개와 2번 보석 7개를 가지고 있을때 최대 7개 중에서 최소한의 개수로 최대한 많은 아이들에게 나눠줘야한다.
    1~7개의 보석에서 우선 절반인 4개의 보석을 기준으로
    1번 보석은 4개 1명을 줄수 있고 2번 보석은 4개 1명, 3개 1명을 줄 수 있다.
    그러면 총 3명의 아이들에게 보석을 줄 수 있다.

    못 받는 아이가 있을수 있다고 했으므로 4개 보석보다 더 적은 보석 개수를 줄 수 있는지 확인해보기 위해 최대 보석 4개는 킵해놓는다. (answer = mid)

    그 다음 2개 보석을 나눠주는 케이스를 본다. (right = mid-1)
    1번 보석은 2개 2명을 줄 수 있고 2번 보석은 2개 3명, 1개 1명에게 줄 수 있다.
    그러면 총 6명에게 줄 수 있다.
    나눠 줄 수는 있지만 나눠줄 아이는 5명이기 때문에 2개보다는 더 많은 보석을 아이들에게 줄 수 있다. 그렇기 때문에 최대 보석 2개는 제외한다.

    그 다음 3개 보석을 나눠주는 케이스를 본다. (left = mid+1)
    1번 보석은 3개 1명, 1개 1명에게 줄 수 있다. 2번 보석은 3개 2명, 1개 1명에게 줄 수 있다.
    그러면 총 5명에게 줄 수 있다.
    나눠줄 아이들에게 딱 맞게 나눠줄수 있는 보석 개수이기 때문에 최대 보석 3개도 킵해놓는다. (answer = mid)

    아이들에게 나눠줄수 있는 최대의 보석 수 중에서 최소는 마지막 3개의 보석이 된다.

     */
    private static int binarySearch() {
        int left = 1;
        int right = maxJ;

        int answer = maxJ;

        while (left <= right) {
            int mid = (left + right) / 2;

            int sum = 0;
            for (int i = 0; i < M; i++) {
                sum += jArr[i] / mid;

                if (jArr[i] % mid != 0) {
                    sum++;
                }
            }

            if (sum > N) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}
