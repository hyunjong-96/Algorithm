package org.algorithm.java.hyunjong.Algorithm.BOJ.트리;

import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

/*
삭제할 트리를 tree배열에서 찾은 후 해당 트리의 부모 노드에서 해당 트래를 삭제한다면 tree 탐색시 삭제된 노드를 방문하지 않게된다.
그리고나서 루트노드에서부터 모든 노드를 탐색하여 자식노드가 없는 노드라면은 현재 count에서 +1을 해주어 반환해주고 반복한다.
 */
public class 트리{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Node[] tree = new Node[N];

		for(int i=0;i<N;i++){
			tree[i] = new Node(i);
		}

		//각 노드의 부모노드
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Node root = null;
		for(int i=0;i<N;i++){
			int parents = Integer.parseInt(st.nextToken());
			if(parents == -1) root = tree[i];
			else{
				tree[i].setParents(tree[parents]);
			}
		}

		int removeNode = Integer.parseInt(br.readLine());

		tree[removeNode].remove();
		int answer = 0;
		if(removeNode != root.idx) {
			answer = root.countLeafNode(0);
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static class Node{
		int idx;
		Node parents;
		List<Node> childs;
		public Node(int idx){
			this.idx = idx;
			parents = null;
			childs = new ArrayList<>();
		}

		public void setChild(Node child){
			this.childs.add(child);
		}

		public void setParents(Node parents){
			this.parents = parents;
			parents.setChild(this);
		}

		public void remove(){
			if(parents != null){
				parents.removeChild(this);
			}
		}

		public void removeChild(Node child){
			childs.remove(child);
		}

		public int countLeafNode(int count){
			if(this.childs.size() == 0) return count+1;

			for(Node child : childs){
				count = child.countLeafNode(count);
			}
			return count;
		}
	}
}
