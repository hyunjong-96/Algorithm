package org.algorithm.java.hyunjong.Algorithm.hash;

import java.util.LinkedList;

public class HashTable {
	public class Node {
		String key;
		String value;

		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String value() {
			return value;
		}

		public void value(String value) {
			this.value = value;
		}
	}

	LinkedList<Node>[] data;

	public HashTable(int size) {
		this.data = new LinkedList[size];
	}

	public int getHashCode(String key) {
		int hashCode = 0;
		for (char c : key.toCharArray()) {
			hashCode += c;
		}
		return hashCode;
	}

	public int convertToIndex(int hashCode) {
		return hashCode % data.length;
	}

	public Node searchKey(LinkedList<Node> list, String key){
		if(list == null) return null;
		for(Node node : list){
			if(node.key.equals(key)){
				return node;
			}
		}
		return null;
	}

	public void put(String key, String value){
		int hashCode = getHashCode(key);
		int index = convertToIndex(hashCode);
		LinkedList<Node> list = data[index];
		if(list == null){
			list = new LinkedList<>();
			data[index] = list;
		}
		Node node = searchKey(list, key);
		if(node == null){
			list.addLast(new Node(key, value));
		}else{
			node.value(value);
		}
	}

	public String get(String key){
		int hashCode = getHashCode(key);
		int index = convertToIndex(hashCode);
		LinkedList<Node> list = data[index];
		Node node = searchKey(list, key);

		return node == null ? "Not Found Value" : node.value;
	}
}
