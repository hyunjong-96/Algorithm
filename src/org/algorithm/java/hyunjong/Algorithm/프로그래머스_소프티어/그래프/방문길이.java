package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.그래프;

import java.util.Map;
import java.util.HashMap;

/*
배열의 크기는 11,11이고 출발점은 좌표에서 (0,0)이므로 배열좌표에서는 (5,5)부터가 출발점이다.
주어진 방향으로부터 좌표를 이동하면서 좌표를 넘는 부분은 무시하면서 이동한다.

U : 0, L : 1, D : 2, R : 3 으로 각 방향의 배열 index를 적용한다. (이유는 아래에서)
이때, 지나가는 길의 방문여부를 확인해야하는데, 만약 UD의 명령어라면 위,아래로 왕복으로 움직인것이기 때문에 한번의 움직임으로 생각해야한다.
그렇기 때문에 해당 길의 방문여부를 확인할 수 있도록 3차원 배열을 이용해서 check[i][j][d]로 y축,x축,해당 좌표 접근 방향으로 나타낸다.
만약 (5,5)에서 (4,5)로 위로 이동했다고하면 check[4][5][0] 은 (4,5)좌표에 아래쪽에서 접근(위로 이동했으니),
check[5][5][2]는 (5,5)좌표에 위쪽에서 접근이라고 표시를 한다.
그러므로 좌표를 이동했을때 특정 좌표에 특정 방향으로 이동했고 그 반대 좌표에 반대 방향으로 접근하는 경우 중복으로 여기게 하는 것이다.
즉 check[nextY][nextX][dir] = ture, check[currentY][currentX][(dir+2)%4] = true로 해서 방향의 반대방향을 나눗셈의 특징을 이용해서 반대 방향을 체크해준다.
 */
class 방문길이 {
	public static void main(String[] args) {
		String dirs = "UDU";
		System.out.println(solution(dirs));
	}
	static int[][] direction = {{-1,0},{0,-1},{1,0},{0,1}};
	static Map<Character, Integer> pos;
	static public int solution(String dirs) {
		pos = new HashMap<>();
		pos.put('U',0);
		pos.put('L',1);
		pos.put('D',2);
		pos.put('R',3);

		int answer = 0;
		int y = 5;
		int x = 5;
		boolean[][][] map = new boolean[11][11][4];
		for(int i=0;i<dirs.length();i++){
			char dir = dirs.charAt(i);

			int idx = pos.get(dir);

			int nextY = y + direction[idx][0];
			int nextX = x + direction[idx][1];

			if(nextY <= 10 && nextX <= 10 && nextY>=0 && nextX>=0){
				if(!map[nextY][nextX][idx]) answer++;
				map[nextY][nextX][idx] = true;
				map[y][x][(idx+2)%4] = true;
				y = nextY;
				x = nextX;
			}
		}
		return answer;
	}
}
