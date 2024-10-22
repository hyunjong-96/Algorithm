package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.ArrayList;
import java.util.List;

/*
교점을 찾는 핵심은 x와 y를 찾는것이다.
Ax+By+E=0 이고 Cx+Dy+F=0 이라면  x = BF-ED/AD-BC, y = EC-AF/AD-BC 가 되게 된다.
이때 AD-BC가 0이라면 비교하는 두 선분은 평행이게 된다.  하지만 A,B가 0인 선분은 주어주지 않는다.
	그리고 BFED%ADBC가 != 0 이면 정수의 좌표가 아니므로 제외한다 ADBC%ADBC도 마찬가지

조건을 만족한 정수 좌표는 list에 저장하고 minX, maxX, minY, maxY를 구하고 높이와 넓이를 구한다.
조건을 만족하는 y좌표는 maxY - y로 갱신한다.
	마찬가지로 조건을 만족하는  x좌표는 x-minX로 갱신하여
	갱신된 x,y좌표의 .을 *로 변경해준다.
	변경은 stinrgBuilder를 통해 쉽게 변경할 수 있다.

별을 포함하는 범위는 1000*1000이내라고 했지만 주어지는 정수는 abs(100000)이기 때문에 서로를 곱했을떄
	int타입을 넘어갈수 있으므로 long타입으로 선언하고
	별을 포함하는 범위의 좌표를 구할땐 int형으로 변경해서 구해주도록 한다.
 */
public class 교점에별만들기 {
	public static void main(String[] args) {
		int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1},{5, -8, -12}, {5, 8, 12}};
		String[] result = solution(line);
		for(String r : result){
			System.out.println(r);
		}
	}

	static String[] solution(int[][] line){
		long minY = Long.MAX_VALUE;
		long maxY = Long.MIN_VALUE;
		long minX = Long.MAX_VALUE;
		long maxX = Long.MIN_VALUE;

		List<int[]> point = new ArrayList<>();
		for(int i=0;i<line.length;i++){
			long A = line[i][0];
			long B = line[i][1];
			long E = line[i][2];
			for(int j=i+1;j<line.length;j++){
				long C = line[j][0];
				long D = line[j][1];
				long F = line[j][2];

				long adbc = A*D-B*C;
				long bfed = B*F-E*D;
				long ecaf = E*C-A*F;

				if(adbc==0) continue; // 비교대상과 평행
				if(bfed%adbc != 0 || ecaf%adbc!=0) continue; //좌표가 정수가 아님

				long x = bfed/adbc;
				long y = ecaf/adbc;

				point.add(new int[]{(int)x, (int)y});

				minY = Math.min(minY, y);
				maxY = Math.max(maxY, y);
				minX = Math.min(minX, x);
				maxX = Math.max(maxX, x);
			}
		}

		int high = (int)(maxY-minY+1);
		int weight = (int)(maxX-minX+1);

		StringBuilder[] map = new StringBuilder[high];
		for(int y = 0;y<high;y++){
			StringBuilder sb = new StringBuilder();
			for(int x = 0; x<weight;x++){
				sb.append(".");
			}
			map[y] = sb;
		}

		for(int[] p : point){
			int x = p[0];
			int y = p[1];

			int ny = (int)maxY-y;
			int nx = x-(int)minX;

			map[ny].setCharAt(nx,'*');
		}

		String[] answer = new String[map.length];
		for(int i=0;i<map.length;i++){
			answer[i] = map[i].toString();
		}

		return answer;
	}
}
