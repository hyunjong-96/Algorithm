package org.algorithm.java.hyunjong.Algorithm.프로그래머스.카카오;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
id_list : 사용자 id 리스트
report : 신고한 사용자와 신고당한 사용자
k : 정지기준 횟수
id_list의 아이디와 index를 저장하는 id_map, 그리고 신고당한 사용자(from), 신고한 사용자리스트(to_list)를 저장하는 report_map
report_map을 순환하면서 to_list의 크기가 k보다 같거나 크다면 결과 배열(ans)의 index에 +1씩 해주면된다.
이때 ans에 신고한 사용자의 index는 id_map에서 id_map.get(id)를 통해 index를 가져올수 있다.
 */
public class 신고결과받기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] id_list = {"con", "ryan"};
		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int K = 2;

		int[] result = solution(id_list, report, K);
		for (int r : result) {
			sb.append(r).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int[] solution(String[] id_list, String[] report, int k) {
		int[] ans = new int[id_list.length];
		//id_list의 사용자 id와 메일 카운트를 받는다.
		Map<String, Integer> id_map = new TreeMap<>();
		for (int i = 0; i < id_list.length; i++) {
			id_map.put(id_list[i], i);
		}
		//report를 신고를 받는 사용자와 신고를 한 사용자를 map으로 묶는다.
		Map<String, List<String>> report_map = new HashMap<>();
		for (String r : report) {
			String[] spiltS = r.split(" ");
			String from = spiltS[0];
			String to = spiltS[1];

			report_map.computeIfAbsent(to, k1 -> new ArrayList<>());

			if (!report_map.get(to).contains(from)) {
				report_map.get(to).add(from);
			}
		}
		//reportMap을 돌면서 신고한 사용자의 수가 k보다 같거나 크다면 idMap의 사용자 이름으로 value의 값을 count한다.
		for (Map.Entry<String, List<String>> entry : report_map.entrySet()) {
			if (entry.getValue().size() >= k) {
				for (String id : entry.getValue()) {
					ans[id_map.get(id)]++;
				}
			}
		}

		return ans;
	}
}
