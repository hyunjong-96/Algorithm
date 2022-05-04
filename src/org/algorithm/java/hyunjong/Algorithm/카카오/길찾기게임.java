package org.algorithm.java.hyunjong.Algorithm.카카오;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 길찾기게임 {
	public static void main(String[] args) {
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		int[][] result = solution(nodeinfo);
		for(int i=0;i<2;i++){
			for(int j=0;j<result[i].length;j++){
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}

	static int[][] solution(int[][] nodeinfo){
		Node[] nodes = new Node[nodeinfo.length];

		for(int i=0;i<nodeinfo.length;i++){
			nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1], null,null);
		}
		//y좌표를 내림차순, 같은 깊이라면 x좌표 오름차순
		Arrays.sort(nodes, new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2){
				if(o1.y==o2.y){
					return o1.x-o2.x;
				}else{
					return o2.y-o1.y;
				}
			}
		});

		Node root = nodes[0];
		for(int i=0;i<nodes.length;i++){
			setLink(root, nodes[i]);
		}

		List<Integer> prevList = new ArrayList<>();
		List<Integer> postList = new ArrayList<>();
		setPrev(root, prevList);
		setPost(root, postList);

		int[][] answer = new int[2][nodes.length];
		for(int i=0;i<nodes.length;i++){
			answer[0][i] = prevList.get(i);
			answer[1][i] = postList.get(i);
		}
		return answer;
	}

	static void setPrev(Node node, List<Integer> prevList){
		if(node == null) return;

		prevList.add(node.num);
		setPrev(node.left, prevList);
		setPrev(node.right, prevList);
	}

	static void setPost(Node node, List<Integer> postList){
		if(node == null) return;

		setPost(node.left, postList);
		setPost(node.right, postList);
		postList.add(node.num);
	}

	static void setLink(Node parents, Node child){
		if(parents.y == child.y) return;
		if(parents.x>child.x){
			if(parents.left==null){
				parents.left = child;
			}else{
				setLink(parents.left, child);
			}
		}else{
			if(parents.right==null){
				parents.right = child;
			}else{
				setLink(parents.right, child);
			}
		}
	}

	static class Node{
		int num;
		int x;
		int y;
		Node left;
		Node right;
		public Node(int num, int x, int y, Node left, Node right){
			this.num = num;
			this.x = x;
			this.y = y;
			this.left = left;
			this.right = right;
		}
	}
}
