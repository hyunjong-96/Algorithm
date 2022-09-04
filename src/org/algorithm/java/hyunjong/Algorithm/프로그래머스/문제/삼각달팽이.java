package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

/*
변의 길이 n, 높이 n인 삼각형을 상단 꼭대기 부터 반시계방향으로 숫자를 1씩 늘려가며 채워넣을 떄
1부터 n*(1+n)/2 (등차수열) 까지의 숫자를 구할 수 있다.

삼각형을 왼쪽 정렬하게 된다면 계단 형식이 되고
계단 형식으로 생각하여 삼각형을 돌 때 상단 꼭짓점부터 아래, 오른쪽, 왼쪽 대각선으로 회전하게 된다.
해당 방향으로 이동할때 n부터 시작해서 방향을 바꿀때마다 1개씩 이동할 칸이 줄어들게 된다.

계단 형식으로 값을 채워넣었다면 0번 index부터 n-1번 index까지 탐색하면서 각 index에서 index+1만큼의 수를 가져와 순서대로 배열에 저장한다.
 */
public class 삼각달팽이 {
	public static void main(String[] args) {
		int n = 6;
		int[] result = solution(n);
		for(int r : result){
			System.out.print(r+" ");
		}
	}

	static int[] dy = {1,0,-1};
	static int[] dx = {0,1,-1};
	static int[] solution(int n){
		int[][] triangle = new int[n][n];
		//[0][0]부터 값을 채워넣어야하는데 첫번째 방향이 아래쪽이기 때문에 y좌표는 -1부터 시작
		int y = -1;
		int x = 0;
		int d = 0;
		int num = 1;

		//해당 방향으로 이동할 칸 수
		for(int t = n;t>0;t--){
			//칸 수 만큼 이동
			for(int i=0;i<t;i++){
				y = y + dy[d];
				x = x + dx[d];
				triangle[y][x] = num++;
			}
			//해당 방향으로 해당 칸 수 만큼 이동했다면 방향 변경
			d = (d+1)%3;
		}

		//모든 삼각형을 채워넣었을 때 마지막 값 (등차수열)
		int limit = ((n*(1+n))/2);
		int[] answer = new int[limit];
		int idx=0;
		//해당 index에서 index+1만큼의 값을 순서대로 배열에 저장한다
		for(int i=0;i<n;i++){
			for(int j=0;j<=i;j++){
				answer[idx++] = triangle[i][j];
			}
		}

		return answer;
	}
}
