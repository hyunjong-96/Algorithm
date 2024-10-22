package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
장르의 총합 재생횟수 playOfGenre, 장르별 노래 musicOfGenre
genres를 돌면서 playOfGenre에 총합 재생횟수를 갱신해주고 musicOfGenre에 노래 고유 번호와 재생횟수를 PQ에 저장한다.

playOfGenre에서 장르와 총 재생횟수가 큰 순으로 정렬하기 위해 PQ에 장르와 재생횟수를 저장한다.

재생횟수가 많은 장르 순으로 playOfGenre에서 가져와 2개씩 뽑아준다 (만약 1개의 노래만 있다면 1개만 뽑아준다)

주의할 점 PQ를 사용할때 pq.poll()을 해주지 않으면 pq 내부적으로 정렬이 일어나지 않는다.
	for(Genre g : genres) 이런 식으로 반복문을 돌리게 되면 정렬되지 않고 최대또는 최소값만 정렬된 상태로 가져와진다.
	꼭  pq.size()를 통해 pq.poll()로 해당 오브젝트를 가져와야 정렬이 되어진다.
 */
public class 베스트앨범 {
	public static void main(String[] args) {
		String[] genres = {"A", "B", "A", "B", "A", "C"};
		int[] plays = {500, 600, 150, 800, 2500, 5000};
		int[] result = solution(genres, plays);
		for (int r : result) {
			System.out.println(r);
		}
	}

	static int[] solution(String[] genres, int[] plays) {
		Map<String, Integer> playOfGenre = new HashMap<>();
		Map<String, PriorityQueue<Music>> musicOfGenre = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			String genre = genres[i];
			int play = plays[i];

			playOfGenre.put(genre, playOfGenre.getOrDefault(genre, 0) + play);

			if (!musicOfGenre.containsKey(genre)) {
				musicOfGenre.put(genre, new PriorityQueue<>());
			}
			musicOfGenre.get(genre).offer(new Music(i, play));
		}

		PriorityQueue<Genre> pq = new PriorityQueue<>();
		for (String g : playOfGenre.keySet()) {
			pq.offer(new Genre(g, playOfGenre.get(g)));
		}

		List<Integer> list = new ArrayList<>();
		int size = pq.size();
		for (int i=0;i<size;i++) {
			Genre g = pq.poll();
			PriorityQueue<Music> musicPQ = musicOfGenre.get(g.genre);

			for (int j = 0; j < 2; j++) {
				if (!musicPQ.isEmpty()) {
					list.add(musicPQ.poll().idx);
				}
			}
		}

		return list.stream().mapToInt(Integer::new).toArray();
	}

	static class Music implements Comparable<Music> {
		int idx;
		int play;

		Music(int idx, int play) {
			this.idx = idx;
			this.play = play;
		}

		@Override
		public int compareTo(Music o) {
			int result = o.play - this.play;
			if (result == 0) {
				result = this.idx - o.idx;
			}
			return result;
		}
	}

	static class Genre implements Comparable<Genre> {
		String genre;
		int totalPlay;

		public Genre(String genre, int totalPlay) {
			this.genre = genre;
			this.totalPlay = totalPlay;
		}

		@Override
		public int compareTo(Genre o1) {
			return Integer.compare(o1.totalPlay, this.totalPlay);
			// return o1.totalPlay - this.totalPlay;
		}
	}
}
