package org.algorithm.java.hyunjong.Algorithm.ArrayList;

public class MyArrayList {
	private Object[] data;
	private int capacity;//data의 크기
	private int size;    //현재 데이터가 들어있는 배열의 크기(size()요청시 나오는 size)

	public MyArrayList() {
		capacity = 1;
		data = new Object[capacity];
		size = 0;
	}

	public MyArrayList(int capacity) {
		data = new Object[capacity];
		size = 0;
	}

	public void add(Object obj) {
		if (capacity == size) {
			doubling();
		}
		data[size] = obj;
		size++;
	}

	public void add(int index, Object obj) {
		if (capacity == size) {
			doubling();
		}

		for (int i = size; i > index; i--) {
			data[i] = data[i-1];
		}

		data[index] = obj;
		size++;
	}

	private void doubling() {
		capacity = capacity * 2;
		Object[] newData = new Object[capacity];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	public Object get(int i) throws Exception {
		if(i > size-1){
			throw new Exception("ArrayIndexOutOfBound");
		}else if (i < 0) {
			throw new Exception("Negative Value");
		}

		return data[i];
	}

	public int size() {
		return this.size;
	}

	public void remove(int i) throws Exception {
		if (i > size - 1) {
			throw new Exception("ArrayIndexOutOfBound");
		} else if (i < 0) {
			throw new Exception("Negative Value");
		}

		for (int x = i; x < data.length - 1; x++) {
			data[x] = data[x + 1];
		}
		size--;
	}

	public void getArray(){
		for(Object obj : data){
			System.out.print(obj + " ");
		}
		System.out.println();
	}
}
