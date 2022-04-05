package org.algorithm.java.hyunjong;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.algorithm.java.hyunjong.Algorithm.ArrayList.MyArrayList;
import org.algorithm.java.hyunjong.Algorithm.카카오.거리두기확인하기;
import org.algorithm.java.hyunjong.Algorithm.카카오.실패율;
import org.algorithm.java.hyunjong.Algorithm.카카오.오픈채팅방;
import org.algorithm.java.hyunjong.Algorithm.카카오.카카오_문자열압축;
import org.algorithm.java.hyunjong.Algorithm.CenterWord.CenterWord;
import org.algorithm.java.hyunjong.Algorithm.DartGame.DartGame;
import org.algorithm.java.hyunjong.Algorithm.Distinct.Distinct;
import org.algorithm.java.hyunjong.Algorithm.DivideAndFallNumber.DivideAndFallNumber;
import org.algorithm.java.hyunjong.Algorithm.FailedRate.FailedRate;
import org.algorithm.java.hyunjong.Algorithm.FindMinority.FindMinority;
import org.algorithm.java.hyunjong.Algorithm.Find김서방.FindKimInSeoul;
import org.algorithm.java.hyunjong.Algorithm.Internal.내적;
import org.algorithm.java.hyunjong.Algorithm.K번째.K번째;
import org.algorithm.java.hyunjong.Algorithm.LinkedList.Linked_List_Node;
import org.algorithm.java.hyunjong.Algorithm.LinkedList.Linked_List_Node_Duplicate;
import org.algorithm.java.hyunjong.Algorithm.LinkedList.Linked_List_One_Way;
import org.algorithm.java.hyunjong.Algorithm.LinkedList.Linked_List_select_index_from_end;
import org.algorithm.java.hyunjong.Algorithm.LottoMaxAndMin.LottoMaxAndMin;
import org.algorithm.java.hyunjong.Algorithm.PandYCount.P_Y_Count;
import org.algorithm.java.hyunjong.Algorithm.Queue.QueueByStack;
import org.algorithm.java.hyunjong.Algorithm.SecretMap.secretMap;
import org.algorithm.java.hyunjong.Algorithm.StringBasic.StringBasic;
import org.algorithm.java.hyunjong.Algorithm.StringDESC.StringDesc;
import org.algorithm.java.hyunjong.Algorithm.StringSorted.StringSorted;
import org.algorithm.java.hyunjong.Algorithm.StringToInteger.StringToInteger;
import org.algorithm.java.hyunjong.Algorithm.SumBetween.SumBetween;
import org.algorithm.java.hyunjong.Algorithm.TriadFlip.TriadFlip;
import org.algorithm.java.hyunjong.Algorithm.animalShelter.Animal;
import org.algorithm.java.hyunjong.Algorithm.animalShelter.AnimalShelter;
import org.algorithm.java.hyunjong.Algorithm.animalShelter.Cat;
import org.algorithm.java.hyunjong.Algorithm.animalShelter.Dog;
import org.algorithm.java.hyunjong.Algorithm.codeUp.CodeUp_100;
import org.algorithm.java.hyunjong.Algorithm.graph.Graph;
import org.algorithm.java.hyunjong.Algorithm.graph.IsThereAWay;
import org.algorithm.java.hyunjong.Algorithm.hash.HashTable;
import org.algorithm.java.hyunjong.Algorithm.sort.BubbleSort;
import org.algorithm.java.hyunjong.Algorithm.sort.MergeSort;
import org.algorithm.java.hyunjong.Algorithm.sort.QuickSort;
import org.algorithm.java.hyunjong.Algorithm.sort.SelectSort;
import org.algorithm.java.hyunjong.Algorithm.stack.Stack;
import org.algorithm.java.hyunjong.Algorithm.stack.StackSort;
import org.algorithm.java.hyunjong.Algorithm.tree.BinarySearchTree;
import org.algorithm.java.hyunjong.Algorithm.tree.BinarySearchTreeByLinkedList;
import org.algorithm.java.hyunjong.Algorithm.tree.BinarySearchWithParents;
import org.algorithm.java.hyunjong.Algorithm.tree.Tree;
import org.algorithm.java.hyunjong.Algorithm.year2016.year2016;
import org.algorithm.java.hyunjong.Algorithm.두개뽑아서더하기.두개더뽑아서더하기;
import org.algorithm.java.hyunjong.Algorithm.모의고사.모의고사;
import org.algorithm.java.hyunjong.Algorithm.문자열압축.StringCompression;
import org.algorithm.java.hyunjong.Algorithm.소수만들기.소수만들기;
import org.algorithm.java.hyunjong.Algorithm.수박수박수.수박수박수;
import org.algorithm.java.hyunjong.Algorithm.시저암호.시저암호;
import org.algorithm.java.hyunjong.Algorithm.신규아이디추천.신규아이디추천;
import org.algorithm.java.hyunjong.Algorithm.약수개수덧셈.Divisor;
import org.algorithm.java.hyunjong.Algorithm.예산.예산;
import org.algorithm.java.hyunjong.Algorithm.완주하지못한선수.완주하지못한선수;
import org.algorithm.java.hyunjong.Algorithm.음양더하기.MiunsPlusAdd;
import org.algorithm.java.hyunjong.Algorithm.체육복.체육복;
import org.algorithm.java.hyunjong.Algorithm.크레인인형뽑기게임.크레인인형뽑기게임;
import org.algorithm.java.hyunjong.Algorithm.키패드누르기.키패드누르기;
import org.algorithm.java.hyunjong.Algorithm.폰켓.PhoneMonster;

public class Main {

	public static void main(String[] args) throws Exception {
		실패율.main(args);
	}

	private static void 두뽑더() {
		int[] number = {2, 1, 3, 4, 1};
		두개더뽑아서더하기 first = new 두개더뽑아서더하기();
		first.solution(number);
	}

	private static void 크인게() {
		int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
		크레인인형뽑기게임 second = new 크레인인형뽑기게임();
		second.solution(board, moves);
	}

	private static void 아이디추천() {
		String new_id = "=.=";
		신규아이디추천 third = new 신규아이디추천();
		third.solution(new_id);
	}

	private static void 완주하지못한선수() {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		완주하지못한선수 fourth = new 완주하지못한선수();
		fourth.solution(participant, completion);
	}

	private static void 모의고사() {
		int[] answers = {1, 3, 2, 4, 2};
		모의고사 fifth = new 모의고사();
		fifth.solution(answers);
	}

	private static void 체육복() {
		int n = 5;
		int[] lost = {2, 3, 4};
		int[] reserve = {2, 5};
		체육복 six = new 체육복();
		System.out.print(six.solution(n, lost, reserve));
	}

	private static void 키패드누르기() {
		int[] numbers = new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		키패드누르기 seven = new 키패드누르기();
		System.out.println(seven.solution(numbers, hand));
	}

	private static void K번째수() {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		K번째 k번째 = new K번째();
		System.out.println(k번째.solution(array, commands));
	}

	private static void 소수만들기() {
		int[] nums = {1, 2, 7, 6, 4};
		소수만들기 S = new 소수만들기();
		System.out.println(S.solution(nums));
	}

	private static void 예산() {
		int[] d = {2, 2, 3, 3};
		int budget = 10;
		예산 s = new 예산();
		System.out.println(s.solution(d, budget));
	}

	private static void lotto() {
		int[] lottos = {45, 4, 35, 20, 3, 9};
		int[] win_nums = {20, 9, 3, 45, 4, 35};
		LottoMaxAndMin s = new LottoMaxAndMin();
		s.solution(lottos, win_nums);
	}

	private static void monster() {
		int[] nums = {3, 3, 3, 2, 2, 2};
		PhoneMonster s = new PhoneMonster();
		System.out.println(s.solution(nums));
	}

	private static void failRate() {
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		int N = 5;
		FailedRate s = new FailedRate();
		System.out.println(s.solution(N, stages).toString());
	}

	private static void Inners() {
		int[] a = {1, 2, 3, 4};
		int[] b = {-3, -1, 0, 2};
		내적 s = new 내적();
		System.out.println(s.solution(a, b));
	}

	private static void Divisor() {
		int left = 13;
		int right = 17;
		Divisor s = new Divisor();
		System.out.print(s.soilution(left, right));
	}

	private static void MiunsPlusAdd() {
		int[] absolutes = {4, 7, 12};
		boolean[] signs = {true, false, true};
		MiunsPlusAdd s = new MiunsPlusAdd();
		System.out.println(s.solution(absolutes, signs));
	}

	private static void TriadFlip() {
		int n = 45;
		TriadFlip s = new TriadFlip();
		System.out.println(s.solution(n));
	}

	private static void Year2016() {
		int a = 4;
		int b = 7;
		year2016 s = new year2016();
		System.out.println(s.solution(a, b));
	}

	private static void SecretMap() {
		int n = 6;
		int[] arr1 = {46, 33, 33, 22, 31, 50};
		int[] arr2 = {27, 56, 19, 14, 14, 10};
		secretMap s = new secretMap();
		System.out.println(Arrays.toString(s.solution(n, arr1, arr2)));
	}

	private static void CenterWord() {
		String s = "abcd";
		CenterWord c = new CenterWord();
		System.out.println(c.solution(s));
	}

	private static void Distinct() {
		int[] arr = {4, 4, 4, 3, 3};
		Distinct s = new Distinct();
		System.out.println(Arrays.toString(s.solution(arr)));
	}

	private static void DartGame() {
		String dartResult = "1D2S#10S";
		DartGame s = new DartGame();
		System.out.println(s.solution(dartResult));
	}

	private static void DivideAndFallNumber() {
		int[] arr = {2, 36, 1, 3};
		int divisor = 1;
		DivideAndFallNumber s = new DivideAndFallNumber();
		System.out.println(Arrays.toString(s.solution(arr, divisor)));
	}

	private static void SumBetween() {
		int a = 3;
		int b = 5;
		SumBetween s = new SumBetween();
		System.out.println(s.solution(a, b));
	}

	private static void StringSorted() {
		String[] strings = {"abce", "abcd", "cdx"};
		int n = 2;
		StringSorted s = new StringSorted();
		System.out.println(Arrays.toString(s.solution(strings, 2)));
	}

	private static void StringCompression() {
		String s = "ababcdcdababcdcd";
		StringCompression result = new StringCompression();
		System.out.println(result.solution(s));
	}

	private static void StringCharCount() {
		String s = "pPoooyY";
		P_Y_Count result = new P_Y_Count();
		System.out.println(result.solution(s));
	}

	private static void StringDescSort() {
		String s = "Zbcdefg";
		StringDesc result = new StringDesc();
		System.out.println(result.solution(s));
	}

	private static void StringBasic() {
		String s = "1234";
		StringBasic result = new StringBasic();
		System.out.println(result.solution(s));
	}

	private static void FindKim() {
		String[] s = new String[] {"Jane", "Kim"};
		FindKimInSeoul result = new FindKimInSeoul();
		System.out.println(result.solution(s));
	}

	private static void FindMinority() {
		int s = 10;
		FindMinority result = new FindMinority();
		System.out.println(result.solution(s));
	}

	private static void 수박수박수() {
		int s = 3;
		수박수박수 result = new 수박수박수();
		System.out.println(result.solution(s));
	}

	private static void 문자열을_숫자로() {
		String s = "1234";
		StringToInteger result = new StringToInteger();
		System.out.println(result.solution(s));
	}

	private static void 시저암호() {
		String s = "a B z";
		int n = 4;
		시저암호 result = new 시저암호();
		System.out.println(result.solution(s, n));
	}

	private static void linkedList_oneWay() {
		Linked_List_One_Way head = new Linked_List_One_Way(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.retrieve();
		// head.delete(2);
		// head.delete(3);
		head.delete(1);
		head.retrieve();
	}

	private static void linkedListNode() {
		Linked_List_Node ll = new Linked_List_Node();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		ll.delete(1);
		ll.retrieve();
	}

	private static void linkedListNodeDuplicate() {
		Linked_List_Node_Duplicate llnp = new Linked_List_Node_Duplicate();

		llnp.append(1);
		llnp.append(2);
		llnp.append(2);
		llnp.append(3);
		llnp.append(4);
		llnp.append(3);
		llnp.retrieve();
		llnp.duplicateDelete_with_buffer();
		llnp.duplicateDelete_with_out_buffer();
		llnp.retrieve();
	}

	private static void linedListNode_Select_Index_From_End() {
		Linked_List_select_index_from_end ll = new Linked_List_select_index_from_end();

		ll.append(1);
		ll.append(1);
		ll.append(3);
		ll.append(1);
		// ll.KthToLast(3);
		ll.retrieve();
		ll.deleteSomethingNode(ll.get(2));
		ll.retrieve();
	}

	private static void my_stack() {
		Stack<Integer> myStack = new Stack<>();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		System.out.println(myStack.peek());//4
		myStack.pop();
		System.out.println(myStack.peek());//3
		System.out.println(myStack.isEmpty());//false
		myStack.pop();
		myStack.pop();
		myStack.pop();
		System.out.println(myStack.isEmpty());//true
		myStack.pop();
	}

	private static void my_queue() {
		// Queue<Integer> myQueue = new Queue<>();
		//
		QueueByStack<Integer> myQueue = new QueueByStack<>();

		myQueue.add(1);
		myQueue.add(2);
		myQueue.add(3);
		myQueue.add(4);
		myQueue.peek();
		System.out.println(myQueue.isEmpty());//false
		System.out.println(myQueue.remove());//1
		System.out.println(myQueue.peek());//2
		System.out.println(myQueue.remove());//2
		System.out.println(myQueue.remove());//3
		System.out.println(myQueue.remove());//4
		System.out.println(myQueue.isEmpty());//true
		System.out.println(myQueue.peek());//npe
	}

	private static void sortStack() {
		StackSort stackSort = new StackSort(new int[] {3, 5, 1, 6});
		stackSort.sort();
		Stack<Integer> result = stackSort.getSort();
		while (!result.isEmpty()) {
			System.out.println(result.pop());
		}
	}

	private static void animalShelter() {
		AnimalShelter animalShelter = new AnimalShelter();
		Dog dog1 = new Dog("강아지1");
		Dog dog2 = new Dog("강아지2");
		Dog dog3 = new Dog("강아지3");

		Cat cat1 = new Cat("고양이1");
		Cat cat2 = new Cat("고양이2");

		animalShelter.saveAnimal(cat1);
		animalShelter.saveAnimal(dog1);
		animalShelter.saveAnimal(dog2);
		animalShelter.saveAnimal(dog3);
		animalShelter.saveAnimal(cat2);

		Animal parcelOutDog1 = animalShelter.parcelOutDog();
		Animal parcelOutDog2 = animalShelter.parcelOutDog();
		System.out.println("강아지 입양1 : " + parcelOutDog1.getName() + " / order : " + parcelOutDog1.getOrder());
		System.out.println("강아지 입양1 : " + parcelOutDog2.getName() + " / order : " + parcelOutDog2.getOrder());

		for (int i = 6; i > 0; i--) {
			Animal animal = animalShelter.parcelOut();

			if (animal == null) {
				System.out.println("분양 끝!");
			} else {
				System.out.println(i + "번째 사람의 입양 : " + animal.getName() + " / order : " + animal.getOrder());
			}
		}
	}

	private static void tree() {
		Tree tree = new Tree();

		// Tree.Node n12 = tree.makeNode(null, 12, null);
		// Tree.Node n7 = tree.makeNode(n12, 7, null);
		// Tree.Node n7 = tree.makeNode(null, 7, null);
		// Tree.Node n8 = tree.makeNode(null, 8, null);
		// Tree.Node n9 = tree.makeNode(null, 9, null);
		// Tree.Node n10 = tree.makeNode(null, 10, null);
		// Tree.Node n11 = tree.makeNode(null, 11, null);
		// Tree.Node n3 = tree.makeNode(n7, 3, n8);
		// Tree.Node n4 = tree.makeNode(n9, 4, n10);
		// Tree.Node n5 = tree.makeNode(n11, 5, null);
		// Tree.Node n6 = tree.makeNode(null, 6, null);
		// Tree.Node n1 = tree.makeNode(n3, 1, n4);
		// Tree.Node n2 = tree.makeNode(n5, 2, n6);
		// Tree.Node root = tree.makeNode(n1, 0, n2);

		Tree.Node n10 = tree.makeNode(null, 10, null);
		Tree.Node n3 = tree.makeNode(null, 3, null);
		Tree.Node n6 = tree.makeNode(null, 6, null);
		Tree.Node n9 = tree.makeNode(null, 9, n10);
		Tree.Node n0 = tree.makeNode(null, 0, null);
		Tree.Node n2 = tree.makeNode(null, 2, n3);
		Tree.Node n5 = tree.makeNode(null, 5, n6);
		Tree.Node n8 = tree.makeNode(null, 8, n9);
		Tree.Node n1 = tree.makeNode(n0, 1, n2);
		Tree.Node n7 = tree.makeNode(n5, 7, n8);
		Tree.Node root = tree.makeNode(n1, 4, n7);
		tree.setRoot(root);
		//
		// // tree.inOrder(tree.getRoot());
		// // tree.preOrder(tree.getRoot());
		// tree.postOrder(tree.getRoot());

		System.out.println(tree.isBalance());
	}

	private static void graph() {
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 7);
		g.addEdge(5, 6);
		g.addEdge(6, 8);

		// g.dfs();
		// g.bfs();
		g.dfsR();
	}

	private static void isThereAWay() {
		IsThereAWay g = new IsThereAWay(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 7);
		g.addEdge(5, 6);
		g.addEdge(6, 8);

		System.out.println(g.search(0, 6));
	}

	private static void makeBinarySearchTree() {
		int[] a = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		BinarySearchTree tree = new BinarySearchTree(a);
		// tree.searchBTree(tree.getRoot(), 10);
		// System.out.println(tree.isValidateBST1());
		System.out.println(tree.isValidateBST2());
	}

	private static void makeBinarySearchTreeToList() {
		int[] a = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		BinarySearchTreeByLinkedList result = new BinarySearchTreeByLinkedList(a);
		// ArrayList<LinkedList<BinarySearchTreeByLinkedList.Node>> list1 = result.BSTToList();
		ArrayList<LinkedList<BinarySearchTreeByLinkedList.Node>> list2 = result.BSTtoList2();

		// result.printList(list1);

		result.printList(list2);
	}

	private static void findNextNodeInBST() {
		int[] a = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		BinarySearchWithParents t = new BinarySearchWithParents(a);

		t.findNext(t.root.left.right.right);
		t.findNext(t.root.left);
		t.findNext(t.root);
		t.findNext(t.root.left.left);
		t.findNext(t.root.right.left);
	}

	public static void makeHashTable() {
		HashTable h = new HashTable(3);
		h.put("sung", "She is pretty");
		h.put("jin", "She is model");
		h.put("hee", "She is an angel");
		h.put("min", "She is cute");
		System.out.println(h.get("sung"));
		System.out.println(h.get("jin"));
		System.out.println(h.get("hee"));
		System.out.println(h.get("min"));
	}

	private static void makeArrayList() throws Exception {
		MyArrayList al = new MyArrayList();
		System.out.println(al.size());
		al.add("0");
		al.add("1");
		al.add("2");
		al.add("3");
		al.add("4");
		al.add("5");
		al.add("6");
		al.add("7");
		al.add("8");
		al.add("9");
		System.out.println(al.get(5));
		al.getArray();
		al.remove(5);
		al.getArray();
		System.out.println(al.get(5));
		al.getArray();
		al.add(0, 22);
		al.getArray();
	}

	private static void makeQuickSort() {
		int[] a = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};

		for(int e : a){
			System.out.print(e + " ");
		}
		System.out.println();

		QuickSort qs = new QuickSort(a);
		qs.printArr(a);
	}

	private static void makeMergeSort(){
		int[] a = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
		for(int e : a){
			System.out.print(e + " ");
		}
		System.out.println();

		MergeSort ms = new MergeSort(a);
		ms.printArray(a);
	}

	private static void makeBubbleSort(){
		int[] a = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
		for(int e : a){
			System.out.print(e + " ");
		}
		System.out.println();

		BubbleSort bs = new BubbleSort(a);
		bs.printArray(a);
	}

	private static void makeSelectSort(){
		int[] a = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
		for(int e : a){
			System.out.print(e + " ");
		}
		System.out.println();

		SelectSort ss = new SelectSort(a);
		ss.printArray(a);
	}

	private static void codeUp_100() throws IOException {
		new CodeUp_100();
	}
}
