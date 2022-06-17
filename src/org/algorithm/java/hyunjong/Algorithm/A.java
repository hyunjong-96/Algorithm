package org.algorithm.java.hyunjong.Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A {
	static int N, L, P;
	static int ans = 0;
	static Queue<Station> stations;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		stations = new PriorityQueue<>(new Comparator<Station>() {
			@Override
			public int compare(Station o1, Station o2) {
				return Integer.compare(o1.location, o2.location);
			}
		});

		int sum = 0;
		for (int i = 0; i < N; i++) {
			int tempL = sc.nextInt();
			int tempV = sc.nextInt();
			stations.add(new Station(tempL, tempV));

			sum += tempV;
		}

		L = sc.nextInt();
		P = sc.nextInt();

		// 모든 주유소를 들리더라도 최정 거리에 도달할 수 없다면 미리 끝냅니다.
		if (sum + P < L) {
			System.out.println(-1);
			return;
		}

		int currentLocation = 0; // 갈 수 있는 가장 먼 주유소의 위치
		int reachableLocation = P;
		int currentPetrol = P;

		Queue<Station> reachableStations = new PriorityQueue<>(new Comparator<Station>() {
			@Override
			public int compare(Station o1, Station o2) {
				return Integer.compare(o1.Petrol, o2.Petrol) * -1;
			}
		});

		Station nextStation;
		while (reachableLocation < L) {

			//범위내 갈 수 있는 주유소를 확인
			while (!stations.isEmpty() && stations.peek().location <= reachableLocation) {
				reachableStations.add(stations.remove());
			}

			//더이상 갈 수 있는 주유소가 없을 경우
			if (reachableStations.isEmpty()) {
				ans = -1;
				break;
			}

			//멈추는 주유소를 추가
			nextStation = reachableStations.remove();
			ans++;

			if (nextStation.location < currentLocation){
				// 가장 먼 주유소보다 이전에 있던 주유소라면 거리와 상관없이 연료만 추가
				reachableLocation += nextStation.Petrol;
				currentPetrol += nextStation.Petrol;
			}else {
				// 다음 멈추는 주유소가 가장 먼 거리라면 이동하면서 사용된 연료 계산
				int usedPetrol = nextStation.location-currentLocation;
				currentLocation = nextStation.location;
				currentPetrol = currentPetrol + nextStation.Petrol - usedPetrol;
				reachableLocation = currentLocation+currentPetrol;
			}
		}

		System.out.println(ans);
	}

	static class Station {
		int location, Petrol;

		Station(int location, int Petrol) {
			this.location = location;
			this.Petrol = Petrol;
		}
	}
}
