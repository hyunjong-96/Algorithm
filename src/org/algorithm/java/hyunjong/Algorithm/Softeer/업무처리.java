package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;


public class 업무처리
{
	static int H;
	static int K;
	static int R;
	static Worker[] tree;
	static int answer;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		H = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		tree = new Worker[((int)Math.pow(2,H)+1)*2];
		init(1,0);
		for(int i=(int)Math.pow(2,H);i<(int)Math.pow(2,H+1);i++){
			st = new StringTokenizer(br.readLine()," ");
			for(int k=0;k<K;k++){
				tree[i].job.offer(Integer.parseInt(st.nextToken()));
			}
		}

		answer = 0;
		for(int r=1;r<=R;r++){
			workProcess(1, r, 0);
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void workProcess(int idx, int r, int depth){
		if(depth > H) return;

		Worker worker = tree[idx];
		if(depth == H && !worker.job.isEmpty()){
			int job = worker.job.poll();
			if(idx%2==0) tree[idx/2].leftJob.offer(job);
			else tree[idx/2].rightJob.offer(job);
		}
		else if(depth < H && r%2 == 0 && !worker.rightJob.isEmpty()){
			int job = worker.rightJob.poll();
			if(idx==1) answer += job;
			else{
				if(idx%2==0) tree[idx/2].leftJob.offer(job);
				else tree[idx/2].rightJob.offer(job);
			}
		}else if(depth < H && r%2 == 1 && !worker.leftJob.isEmpty()){
			int job = worker.leftJob.poll();
			if(idx==1) answer += job;
			else{
				if(idx%2==0) tree[idx/2].leftJob.offer(job);
				else tree[idx/2].rightJob.offer(job);
			}
		}

		workProcess(idx*2, r, depth+1);
		workProcess(idx*2+1, r, depth+1);
	}

	static void init(int idx, int depth){
		if(depth > H) return;

		Worker newWorker = new Worker(depth);
		tree[idx] = newWorker;

		init(idx*2, depth+1);
		init(idx*2+1, depth+1);
	}

	static class Worker{
		int depth;
		Queue<Integer> leftJob;
		Queue<Integer> rightJob;
		Queue<Integer> job;

		public Worker(int depth){
			this.depth = depth;
			initJob();
		}

		public void initJob(){
			if(depth == H){
				job = new LinkedList<>();
			}else{
				leftJob = new LinkedList<>();
				rightJob = new LinkedList<>();
			}
		}
	}
}
