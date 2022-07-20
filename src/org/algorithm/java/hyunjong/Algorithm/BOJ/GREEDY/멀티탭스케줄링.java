package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

//Set<Integer> set에 콘센트에 꽂히는 용품을 저장한다.
//set이 N이상이고 중복되는 용품이 있다면 해당 용품을 콘센트에 꽂아야한다.
//콘센트에 꽂혀있는 용품 중 하나를 뽑아야하는데, 더 이상 꽂을 필요가 없는 용품 또는 가장 나중에 사용되는 용품을 뽑는게 좋다.
//그래야지 다시 용품을 꽂을때 최대한 늦게 용품 교체를 할 수 있기 때문이다.(중요)
//더 이상 사용되지 않는 용품 또는 가장 나중에 사용되는 용품을 구하는 방법은
//elements.get(i)가 콘센트에 꽂아야하는 용품일 때 elements.subList(i+1,K)까지를 잘라서 set에 있는 용품이 다시 사용되는 index또는
//사용되지 않는 용품이라면 K-i로 index를 갱신하여 가장 큰 index(가장 늦게 사용되는 용품)을 set.remove(s)를 해주고 해당 용품을 set.add(e)로 넣어준다.
//이때 콘센트에서 빠지는 횟수를 카운트 해준다.
public class 멀티탭스케줄링 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		List<Integer> elements = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			elements.add(Integer.parseInt(st.nextToken()));
		}
		Set<Integer> set = new HashSet<>();

		int outCount = 0;

		for (int i = 0; i < K; i++) {
			int element = elements.get(i);
			if (set.contains(element))
				continue;
			if (set.size() < N) {
				set.add(element);
				continue;
			}

			int max = -1;
			int out = -1;
			List<Integer> remains = elements.subList(i + 1, K);
			for (int s : set) {
				int idx = 0;
				if (remains.contains(s)) {
					idx = remains.indexOf(s);
				} else {
					idx = K - i + 1;
				}

				if (idx > max) {
					max = idx;
					out = s;
				}
			}
			set.remove(out);
			set.add(element);
			outCount++;
		}

		bw.write(String.valueOf(outCount));
		bw.flush();
		bw.close();
	}
}
