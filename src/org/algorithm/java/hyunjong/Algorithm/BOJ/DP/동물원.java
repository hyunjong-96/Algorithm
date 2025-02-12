package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

/**
 * packageName    : org.algorithm.java.hyunjong.Algorithm.BOJ.DP
 * fileName       : 동물원
 * author         : leehyunjong
 * date           : 2025/02/12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025/02/12        leehyunjong       최초 생성
 */
import java.io.*;
public class 동물원 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        /*
         * dp[i][j]는 i번째 줄의 j번째 칸에 사자를 놓는 경우이다.
         * N=1일때 dp[1][0]은 1번째 줄의 0번째 칸에 사자를 놓는경우 => 1번째 줄에 사자를 놓지 않는다.
         * dp[1][1]은 1번째 줄의 1번째 칸에 사자를 놓는 경우 / dp[1][2]는 1번째 줄의 2번째 칸에 사자를 놓는 경우
         *
         * N=2일때
         * dp[2][0]은 2번째 줄에 사자를 놓지 않는 경우이다.
         * 이 경우는 1번째 줄의 1번째, 2번째 칸에 사자를 놓거나 아무것도 놓지 않는 경우, 즉 2번째 줄에 사자를 놓지 않는다면 1번째 줄 아무 칸에나 사자를 놓아도 된다.
         * dp[2][0] = dp[1][0] + dp[1][1] + dp[1][2]
         *
         * dp[2][1]은 2번째 줄의 1번째 칸에 사자를 놓는 경우이다.
         * 2번째 줄의 1번째 칸에 사자를 놓는다면 1번째 줄에는 사자를 놓지 않거나(dp[1][0]) 2번째 칸에 사자를 놓는 경우(dp[1][2])에만 가능하다.
         * dp[2][1] = dp[1][0] + dp[1][2]
         *
         * dp[2][2]는 2번째 줄의 2번째 칸에 사자를 놓는 경우이다.
         * 2번째 줄의 2번째 칸에 사자를 놓는다면 1번째 줄에는 사자를 놓지 않거나(dp[1][0]) 1번째 칸에 사자를 놓는 경우(dp[1][1])에만 가능하다.
         * dp[2][2] = dp[1][0] + dp[1][1]
         *
         * 그렇기 때문에 dp[i][0]은 i-1번째 줄의 어느 칸에 사자를 놓아도 되는 경우 dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]
         * dp[i][1]은 i-1번째 줄의 2번째 칸이나 아무값도 놓지 않는 경우 dp[i][1] = dp[i-1][0] + dp[i-1][2]
         * dp[i][2]는 i-1번째 줄의 1번째 칸이나 아무값도 놓지 않는 경우 dp[i][2] = dp[i-1][0] + dp[i-1][1]
         * 이라는 점화식이 세워지게 된다.
         *
         * N번째의 모든 [N][0], [N][1], [N][2]의 합이 N번째 줄이 주어졌을때 사자를 놓는 모든 경우의 수가 된다.
         * result = dp[N][0] + dp[N][1] + dp[N][2]
         *
         * 그리고 9901의 나머지의 값을 구하라 했기 때문에 중간의 모든 점화식에 9901의 나머지를 저장한다.
         * 그리고 100000 줄이 주어지는 경우를 가정했을때 int범위(약 20억)을 넘을 것이기 때문에 dp의 타입은 long
         */
        for(int i=2;i<=N;i++) {
            dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901;
            dp[i][1] = (dp[i-1][0]+dp[i-1][2])%9901;
            dp[i][2] = (dp[i-1][0]+dp[i-1][1])%9901;
        }

        long result = (dp[N][0]+dp[N][1]+dp[N][2])%9901;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
