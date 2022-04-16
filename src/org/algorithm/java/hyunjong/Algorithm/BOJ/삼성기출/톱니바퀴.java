package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
바퀴가 돌때 바퀴를 돌리는것이 아닌 바퀴를 돌리고 난뒤의 상태값을 저장해놓은 길이가 4인 배열을 가지고 구현했다.
n번째 바퀴가 1(시계)or -1(반시계)로 돌때 인접한 톱니의 극을 확인해 돌수있는지 여부를 판단후 점진적으로 다음 인접한 톱니들의 상태를 체크했다.
그리고 k번째에서 n번째 바퀴를 D방향으로 돌렸을때 직접적으로 톱니의 상태를 변경하게 되면 인접한 톱니의 극을 바꿔주는데 제약이 생기다보니
현재 톱니상태를 저장하는 임시 상태배열(statusTempt)을 생성하여 톱니의 상태를 변경 후 실제 톱니 상태에 적용.
그리고 최종 톱니상태를 가지고 4개의 톱니 배열의 첫번째 index에서 부터 얼만큼의 회전이 일어났는지를 확인하여 회전만큼의 index를 이동하여
해당 index의 값을 통해 합산하여 값 반환.
 */
public class 톱니바퀴 {
	static int[] wheelStatus = new int[5];
	static int[][] wheels = new int[5][8];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		//톱니바퀴 저장할 2차원 배열 초기화
		for(int i=1;i<=4;i++){
			String[] w = br.readLine().split("");
			for(int j=0;j<8;j++){
				wheels[i][j] = Integer.parseInt(w[j]);
			}
		}

		//톱니 회전 정보의 갯수
		int K = Integer.parseInt(br.readLine());

		for(int i=0;i<K;i++){
			st = new StringTokenizer(br.readLine(), " ");
			//회전시킬 톱니
			int N = Integer.parseInt(st.nextToken());
			//회전시킬 방향(1 : 시계방향, -1 : 반시계방향)
			int D = Integer.parseInt(st.nextToken());
			//인접한 왼쪽 톱니들의 방향
			int d = D;
			//현재 톱니 상태에서 N번 톱니를 D로 움직이고 난 후의 상태를 저장하기 위한 임시 상태 배열
			//톱니바퀴의 상태를 직접 변경하게 되면 인접한 톱니바퀴와 인접한 다음 톱니바퀴의 회전 여부를 판단하기 어렵기 때문
			int[] statusTempt = new int[5];
			for(int s = 1;s<=4;s++){
				statusTempt[s] = wheelStatus[s];
			}
			//N으로 부터 왼쪽 톱니를 변경
			for(int l = N-1;l>0;l--){
				//기준 톱니바퀴의 왼쪽 톱니
				//각 톱니바퀴의 6번째 index가 톱니바퀴의 왼쪽 톱니
				//톱니바퀴 회전 상태에 따라서 해당 왼쪽 톱니가 어떤 index에 있는지 찾아내기 위함
				int rightWheelsLeft = wheels[l+1][(6-wheelStatus[l+1]+8)%8];
				//기준의 왼쪽 톱니바퀴의 오른쪽 톱니
				int leftWheelsRight = wheels[l][(2-wheelStatus[l]+8)%8];

				//왼쪽 톱니와 오른쪽 톱톱의 값이 다르다면 wheelStatus를 변경해줘야함.
				if(rightWheelsLeft != leftWheelsRight){
					//오른쪽 방향이 -1이라면 왼쪽 톱니는 1로 변경, 오른쪽 방향이 1이라면 왼쪽톱니는 -1
					//statusTempt에 변경되는 톱니의 방향을 임시 저장.
					statusTempt[l] = wheelStatus[l]-(d);
					//회전 방향 변경
					d = -d;
				}else{
					//인접한 톱니가 같다면 그 이후로의 톱니바퀴의 회전은 없기 때문
					break;
				}
			}
			//N으로 부터 오른쪽 톱니를 변경
			//인접한 왼쪽 톱니바퀴와의 비교로 d가 변경되기때문에 인접한 오른쪽 톱니바퀴를 위한 초기화
			d = D;
			for(int r = N+1;r<=4;r++){
				//기준 톱니바퀴의 오른쪽 톱니
				int leftWheelsRight = wheels[r-1][(2-wheelStatus[r-1]+8)%8];
				//기준 톱니바퀴와 인접한 오른쪽 톱니바퀴의 왼쪽 톱니
				int rightWheelsLeft = wheels[r][(6-wheelStatus[r]+8)%8];

				if(leftWheelsRight != rightWheelsLeft){
					statusTempt[r] = wheelStatus[r]-(d);
					d = -d;
				}else{
					break;
				}
			}
			for(int s = 1;s<=4;s++){
				//톱니바퀴의 회전에 8번하게 되면 회전하지 않은것과 같음으로 8로 나눈 나머지를 저장
				wheelStatus[s] = statusTempt[s]%8;
			}
			//N번 톱니바퀴 회전
			wheelStatus[N] += D;
		}

		int sum=0;
		int value = 1;
		for(int i=1;i<=4;i++){
			//톱니바퀴 회전 상태를 통해 12시방향의 톱니의 값이 1이라면 value값을 더해줌.
			if(wheels[i][(8-wheelStatus[i])%8] == 1){
				sum += value;
			}
			//톱니바퀴의 번호가 높아질수록 2배수
			value *= 2;
		}

		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}
