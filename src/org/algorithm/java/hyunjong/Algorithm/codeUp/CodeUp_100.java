package org.algorithm.java.hyunjong.Algorithm.codeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CodeUp_100 {

	private boolean movie(int[][] space, int[]position){
		int positionX = position[0];
		int positionY = position[1];
		if(positionX==8 && positionY==8 || space[positionX][positionY] == 2){
			space[positionX][positionY] = 9;
			return true;
		}
		if(space[positionX][positionY+1] == 1){
			position[0]++;
			space[positionX][positionY] = 9;
			return false;
		}else{
			position[1]++;
			space[positionX][positionY] = 9;
			return false;
		}
	}
	public CodeUp_100() throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//1099
		int[][] space = new int[10][10];
		for (int i = 0; i < 10; i++) {
			space[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		}
		boolean success = false;
		int[] position = new int[]{1,1};
		while(!success){
			success = movie(space, position);
		}

		for(int i =0;i<10;i++){
			for(int j=0;j<10;j++){
				bw.write(String.valueOf(space[i][j]));
				bw.write(" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		// //1098
		// int[] size = Arrays.stream(br.readLine().split(" "))
		// 	.mapToInt(Integer::parseInt).toArray();
		// int[][] space = new int[size[0]][size[1]];
		// int n = Integer.parseInt(br.readLine());
		// int[][] info = new int[n][4];
		// for (int i = 0; i < n; i++) {
		// 	info[i] = Arrays.stream(br.readLine().split(" "))
		// 		.mapToInt(Integer::parseInt).toArray();
		// }
		//
		// for (int i = 0; i < n; i++) {
		// 	int len = info[i][0];
		// 	int arrow = info[i][1];
		// 	int x = info[i][2] - 1;
		// 	int y = info[i][3] - 1;
		//
		// 	for (int l = 0; l < len; l++) {
		// 		space[x][y] = 1;
		// 		if(arrow == 0){
		// 			y++;
		// 		}else{
		// 			x++;
		// 		}
		// 	}
		// }
		//
		// for(int i=0;i<size[0];i++){
		// 	for(int j=0;j<size[1];j++){
		// 		bw.write(String.valueOf(space[i][j]));
		// 		bw.write(" ");
		// 	}
		// 	bw.write("\n");
		// }
		// bw.flush();
		// bw.close();
		// //1097
		// int[][] space = new int[19][19];
		// for (int i = 0; i < 19; i++) {
		// 	int[] row = Arrays.stream(br.readLine().split(" "))
		// 		.mapToInt(Integer::parseInt).toArray();
		// 	space[i] = row;
		// }
		// int n = Integer.parseInt(br.readLine());
		// int[][] point = new int[n][2];
		// for (int i = 0; i < n; i++) {
		// 	point[i] = Arrays.stream(br.readLine().split(" "))
		// 		.mapToInt(Integer::parseInt).toArray();
		// }
		// for (int i = 0; i < n; i++) {
		// 	int x = point[i][0]-1;
		// 	int y = point[i][1]-1;
		// 	for (int j = 0; j < 19; j++) {
		// 		space[x][j] = space[x][j] == 1 ? 0 : 1;
		// 		space[j][y] = space[j][y] == 1 ? 0 : 1;
		// 	}
		// }
		//
		// for(int i = 0;i<19;i++){
		// 	for(int j = 0;j<19;j++){
		// 		bw.write(String.valueOf(space[i][j]));
		// 		bw.write(" ");
		// 	}
		// 	bw.write("\n");
		// }
		// bw.flush();
		// bw.close();
		// //1096
		// int stoneCount = Integer.parseInt(br.readLine());
		// // int[][] input = new int[stoneCount][2];
		// int[][] space = new int[19][19];
		// for (int i = 0; i < stoneCount; i++) {
		// 	int[] s = Arrays.stream(br.readLine().split(" "))
		// 		.mapToInt(Integer::parseInt).toArray();
		//
		// 	space[s[0]-1][s[1]-1] = 1;
		// }
		//
		// for (int i = 0; i < space.length; i++) {
		// 	for (int j = 0; j < space[i].length; j++) {
		// 		bw.write(String.valueOf(space[i][j]));
		// 		bw.write(" ");
		// 	}
		// 	bw.write("\n");
		// }
		// bw.flush();
		// bw.close();
		// //1095
		// String length = br.readLine();
		// String[] call = br.readLine().split(" ");
		// int[] callNum = Arrays.stream(call).mapToInt(Integer::parseInt).toArray();
		// for (int i = 0; i < call.length-1; i++) {
		// 	if(callNum[i]<callNum[i+1]){
		// 		int tmp = callNum[i];
		// 		callNum[i] = callNum[i+1];
		// 		callNum[i+1] = tmp;
		// 	}
		// }
		// bw.write(String.valueOf(callNum[callNum.length-1]));
		// bw.flush();
		// bw.close();
		// //1094
		// String length = br.readLine();
		// String[] call = br.readLine().split(" ");
		// int start = 0;
		// int end = call.length-1;
		// while(start<end){
		// 	String tmp = call[start];
		// 	call[start] = call[end];
		// 	call[end] = tmp;
		// 	start++;
		// 	end--;
		// }
		//
		// for(String i : call){
		// 	bw.write(i+" ");
		// }
		// bw.flush();
		// bw.close();
		// //1093
		// String length = br.readLine();
		// String[] call = br.readLine().split(" ");
		// int[] callInt = Arrays.stream(call).mapToInt(Integer::parseInt).toArray();
		// int callNumber = Integer.parseInt(length);
		// int[] student = new int[23];
		// for (int i = 0; i < 23; i++) {
		// 	student[i] = 0;
		// }
		//
		// for (int i = 0; i < callNumber; i++) {
		// 	student[callInt[i]-1]++;
		// }
		//
		// for(int i : student){
		// 	bw.write(String.valueOf(i)+" ");
		// }
		// bw.flush();
		// bw.close();
		// //최대공약수
		// String[] arr = br.readLine().split(" ");
		// int a = Integer.parseInt(arr[0]);
		// int b = Integer.parseInt(arr[1]);
		// int max = Math.max(a, b);
		// int result = 0;
		// for (int i = 1; i <= max; i++) {
		// 	if (a % i == 0 && b % i == 0) {
		// 		result = i;
		// 	}
		// }
		// bw.write(String.valueOf(result));
		// bw.flush();
		// bw.close();
		// //1092
		// String[] arr = br.readLine().split(" ");
		// int a = Integer.parseInt(arr[0]);
		// int b = Integer.parseInt(arr[1]);
		// int c = Integer.parseInt(arr[2]);
		//
		// int day = a>b ? (Math.min(b, c)) : (Math.min(a, c));
		//
		// while((day%a != 0) || (day%b != 0) || (day%c != 0)){
		// 	day++;
		// }
		// bw.write(String.valueOf(day));
		// bw.flush();
		// bw.close();

		// //1091
		// String[] arr = br.readLine().split(" ");
		// int a = Integer.parseInt(arr[0]);
		// int b = Integer.parseInt(arr[1]);
		// int c = Integer.parseInt(arr[2]);
		// int d = Integer.parseInt(arr[3]);
		//
		// long result = a;
		// for (int i = 0; i < d-1; i++) {
		// 	result = (result*b)+c;
		// }
		// bw.write(String.valueOf(result));
		// bw.flush();
		// bw.close();
		// //1090
		// String[] arr = br.readLine().split(" ");
		// int a = Integer.parseInt(arr[0]);
		// int b = Integer.parseInt(arr[1]);
		// int c = Integer.parseInt(arr[2]);
		//
		// long result = a;
		// for (int i = 0; i < c-1; i++) {
		// 	result*=b;
		// }
		// bw.write(String.valueOf(result));
		// bw.flush();
		// bw.close();
		// //1089
		// String[] arr = br.readLine().split(" ");
		// int a = Integer.parseInt(arr[0]);
		// int b = Integer.parseInt(arr[1]);
		// int c = Integer.parseInt(arr[2]);
		//
		// int result = a;
		// for (int i = 0; i < c-1; i++) {
		// 	result+=b;
		// }
		// bw.write(String.valueOf(result));
		// bw.flush();
		// bw.close();
		// //1088
		// String st = br.readLine();
		// int num = Integer.parseInt(st);
		// for (int i = 1; i < num; i++) {
		// 	if(i%3!=0){
		// 		bw.write(String.valueOf(i));
		// 		bw.write(" ");
		// 	}
		// }
		// if(num%3!=0) bw.write(String.valueOf(num));
		// bw.flush();
		// bw.close();
		// // //1086
		// String st = br.readLine();
		// int num = Integer.parseInt(st);
		// int sum = 0;
		// int i = 1;
		// while(sum < num){
		// 	sum+=i;
		// 	i++;
		// 	if(sum+i > num && sum != num) sum = sum+i;
		// }
		// bw.write(String.valueOf(sum));
		// bw.flush();
		// bw.close();
		// String[] arr = br.readLine().split(" ");
		// double w = Double.parseDouble(arr[0]);
		// double h = Double.parseDouble(arr[1]);
		// double b = Double.parseDouble(arr[2]);
		// double result = (((w*h*b)/8)/Math.pow(2,10))/Math.pow(2,10);
		// String format = String.format("%.02f",result);
		// bw.write(format+" MB");
		// bw.flush();
		// bw.close();
		// //1085
		// String[] arr = br.readLine().split(" ");
		// double h = Integer.parseInt(arr[0]);//헤르츠
		// double b = Integer.parseInt(arr[1]);//비트
		// double c = Integer.parseInt(arr[2]);//채널
		// double s = Integer.parseInt(arr[3]);//초
		//
		// double result = (((h*b*c*s)/8)/Math.pow(2,10))/Math.pow(2,10);
		// String format = String.format("%.01f",result);
		// bw.write(String.valueOf(format+" MB"));
		// bw.flush();
		// bw.close();
		// //1084
		// String[] arr = br.readLine().split(" ");
		// int r = Integer.parseInt(arr[0]);
		// int g = Integer.parseInt(arr[1]);
		// int b = Integer.parseInt(arr[2]);
		//
		// int count = 0;
		// for (int i = 0; i < r; i++) {
		// 	for (int j = 0; j < g; j++) {
		// 		for (int k = 0; k < b; k++) {
		// 			bw.write(i+" "+j+" "+k);
		// 			bw.write("\n");
		// 			count++;
		// 		}
		// 	}
		// }
		// bw.write(String.valueOf(count));
		// bw.flush();
		// bw.close();
		// //1083
		// int n = sc.nextInt();
		// for (int i = 1; i < n; i++) {
		// 	if(i%3==0) System.out.print('X');
		// 	else System.out.print(i);
		// 	System.out.print(" ");
		// }
		// if(n%3==0) System.out.print("X");
		// else System.out.print(n);
		// //1082
		// int hex = sc.nextInt(16);
		// for(int i = 1;i<16;i++){
		// 	System.out.printf("%X*%X=%X",hex,i,hex*i);
		// 	System.out.println();
		// }
		// //1081
		// int a = sc.nextInt();
		// int b = sc.nextInt();
		//
		// for (int i = 1; i <= a; i++) {
		// 	for(int j = 1; j <=b; j++){
		// 		System.out.println(i+" "+j);
		// 	}
		// }
		// //1080
		// int n = sc.nextInt();
		// int sum = 0;
		// int i = 1;
		// while(sum != n){
		// 	sum+=i;
		// 	if(sum >= n){
		// 		System.out.println(i);
		// 		break;
		// 	}
		// 	i++;
		// }
		// //1079
		// char c = 0;
		// while(c != 'q'){
		// 	c = sc.next().charAt(0);
		// 	System.out.println(c);
		// }
		// //1078
		// int n = sc.nextInt();
		// int sum=0;
		// for (int i = 1; i <= n; i++) {
		// 	if(i%2==0) sum+=i;
		// }
		// System.out.println(sum);
		// //1076
		// char c = sc.next().charAt(0);
		// char alpha = 'a';
		// while(alpha <= c){
		// 	if(alpha == c){
		// 		System.out.print(alpha);
		// 		break;
		// 	}
		// 	System.out.print(alpha+" ");
		// 	alpha++;
		// }
		// //1075
		// for (int n = sc.nextInt()-1; n > -1; n--) {
		// 	System.out.println(n);
		// }
		// //1074
		// for (int n = sc.nextInt(); n > 0; n--) {
		// 	System.out.println(n);
		// }
		// //1073
		// int n = -1;
		// while(true){
		// 	n = sc.nextInt();
		// 	if(n==0) break;
		// 	System.out.println(n);
		// }
		// //1072
		// int n = sc.nextInt(), n2;
		// for (int i = 0; i < n; i++) {
		// 	n2 = sc.nextInt();
		// 	System.out.println(n2);
		// }
		// //1071
		// String s = sc.nextLine();
		// String[] arr = s.split(" ");
		// int i = 0;
		// while(!arr[i].equals("0")){
		// 	System.out.println(arr[i]);
		// 	i++;
		// }
		// //1070
		// int i = sc.nextInt();
		// switch (i){
		// 	case 12:
		// 	case 1:
		// 	case 2:
		// 		System.out.println("winter");
		// 		break;
		// 	case 3:
		// 	case 4:
		// 	case 5:
		// 		System.out.println("spring");
		// 		break;
		// 	case 6:
		// 	case 7:
		// 	case 8:
		// 		System.out.println("summer");
		// 		break;
		// 	case 9:
		// 	case 10:
		// 	case 11:
		// 		System.out.println("fall");
		// 		break;
		// }
		// //1069
		// char c = sc.next().charAt(0);
		// switch (c){
		// 	case 'A' : System.out.println("best!!!");
		// 	break;
		// 	case 'B' : System.out.println("good!!");
		// 	break;
		// 	case 'C' : System.out.println("run!");
		// 	break;
		// 	case 'D' : System.out.println("slowly~");
		// 	break;
		// 	default: System.out.println("what?");
		// }
		// //1068
		// int i = sc.nextInt();
		// if(i >= 90){
		// 	System.out.println("A");
		// }else if(i>=70){
		// 	System.out.println("B");
		// }else if(i>=40){
		// 	System.out.println("C");
		// }else{
		// 	System.out.println("D");
		// }
		// //1067
		// int i = sc.nextInt();
		// if(i>0) System.out.println("plus");
		// else System.out.println("minus");
		// if(i%2 == 0) System.out.println("even");
		// else System.out.println("odd");
		// //1066
		// String s = sc.nextLine();
		// String[] arr = s.split(" ");
		// for(String st : arr){
		// 	int a = Integer.parseInt(st);
		// 	if(a%2 == 0) System.out.println("even");
		// 	else System.out.println("odd");
		// }
		// //1065
		// String s = sc.nextLine();
		// String[] arr = s.split(" ");
		// for(String st : arr){
		// 	int a = Integer.parseInt(st);
		// 	if(a%2 == 0) System.out.println(a);
		// }
		// //1064
		// String s = sc.nextLine();
		// String[] arr = s.split(" ");
		// int a = Integer.parseInt(arr[0]);
		// int b = Integer.parseInt(arr[1]);
		// int c = Integer.parseInt(arr[2]);
		// int result = a>b ? (b>c ? c : b) : (a>c ? c : a);
		// System.out.println(result);
		// //1062
		// String s = sc.nextLine();
		// String[] arr = s.split(" ");
		// int a = Integer.parseInt(arr[0]);
		// int b = Integer.parseInt(arr[1]);
		// System.out.println(a^b);
		// //1061
		// String s = sc.nextLine();
		// String[] arr = s.split(" ");
		// int a = Integer.parseInt(arr[0]);
		// int b = Integer.parseInt(arr[1]);
		// System.out.println(a|b);
		// //1060
		// String s = sc.nextLine();
		// String[] arr = s.split(" ");
		// int a = Integer.parseInt(arr[0]);
		// int b = Integer.parseInt(arr[1]);
		// System.out.println(a&b);
		// //1059
		// int i = sc.nextInt();
		// System.out.println(~i);
		// //1053
		// int i = sc.nextInt();
		// if(i == 0){
		// 	System.out.println(1);
		// }else System.out.println(0);
		// //1049
		// String s = sc.nextLine();
		// String[] arr = s.split(" ");
		// int a = Integer.parseInt(arr[0]);
		// int b = Integer.parseInt(arr[1]);
		// if(a>b) System.out.println(1);
		// else System.out.println(0);
		// //1048
		// String s = sc.nextLine();
		// String[] arr = s.split(" ");
		// int a = Integer.parseInt(arr[0]);
		// int b = Integer.parseInt(arr[1]);
		// System.out.println(a<<b);
		// //1047
		// int i = sc.nextInt();
		// System.out.println(i<<1);
		// //1046
		// String s = sc.nextLine();
		// String[] arr = s.split(" ");
		// int a = Integer.parseInt(arr[0]);
		// int b = Integer.parseInt(arr[1]);
		// int c = Integer.parseInt(arr[2]);
		// int sum = a+b+c;
		// float avg = (float)sum/3;
		// System.out.println(sum);
		// System.out.printf("%.01f",avg);
		// //1045
		// String s = sc.nextLine();
		// String[] arr = s.split(" ");
		// int a = Integer.parseInt(arr[0]);
		// int b = Integer.parseInt(arr[1]);
		//
		// System.out.println(a+b);
		// System.out.println(a-b);
		// System.out.println(a*b);
		// System.out.println(a/b);
		// System.out.println(a%b);
		// System.out.printf("%.02f",((float)a/(float)b));
		// //1044
		// long i = sc.nextInt();
		// System.out.println(++i);
		// //1043
		// String s = sc.nextLine();
		// String[] arr = s.split(" ");
		// int a = Integer.parseInt(arr[0]);
		// int b = Integer.parseInt(arr[1]);
		// System.out.println(a%b);
		// //1042
		// String s = sc.nextLine();
		// String[] arr = s.split(" ");
		// int a = Integer.parseInt(arr[0]);
		// int b = Integer.parseInt(arr[1]);
		// System.out.println(a/b);
		// //1040
		// int num = sc.nextInt();
		// System.out.println(-num);
		// //1039
		// String s = sc.nextLine();
		// String[] arr = s.split(" ");
		// long a = Long.parseLong(arr[0]);
		// long b = Long.parseLong(arr[1]);
		// System.out.println(a+b);
		// //1038
		// int a = sc.nextInt();
		// int b = sc.nextInt();
		// System.out.println((long)a+b);
		// //1037
		// int i = sc.nextInt();
		// System.out.println((char)i);
		// //1036
		// char c = sc.next().charAt(0);
		// System.out.println((int)c);
		// //1035
		// String number = sc.next();
		// int convertNumb = Integer.parseInt(number, 16);
		// System.out.printf("%o",convertNumb);
		// //1034
		// String number = sc.next();
		// int convertNum = Integer.parseInt(number, 8);
		// System.out.println(convertNum);
		// //1033
		// int i = sc.nextInt();
		// System.out.printf("%X",i);
		// //1032
		// int i = sc.nextInt();
		// String hex = Integer.toHexString(i);
		// System.out.println(hex);
		// //1031
		// int i = sc.nextInt();
		// String octString = Integer.toOctalString(i);
		// System.out.println(octString);
		// //1029
		// double d = sc.nextDouble();
		// String format = String.format("%.11f",d);
		// System.out.println(format);
		// //1028, 1030
		// Long l = sc.nextLong();
		// System.out.println(l);
		// //1027
		// String s = sc.nextLine();
		// String[] sArr = s.split("\\.");
		// System.out.println(sArr[2]+"-"+sArr[1]+"-"+sArr[0]);
		// //1026
		// String s = sc.nextLine();
		// String[] sArr = s.split(":");
		// System.out.println(Integer.parseInt(sArr[1]));
		// //1025
		// int i = sc.nextInt();
		// String convertI = String.valueOf(i);
		// String[] convertArr = convertI.split("");
		// int p = convertI.length()-1;
		// for(String s : convertArr){
		// 	int c = Integer.parseInt(s);
		// 	int result = p<1 ? c : (int)(c * Math.pow(10, p));
		// 	System.out.println("["+result+"]");
		// 	p--;
		// }
		// //1024
		// String s = sc.nextLine();
		// char[] cArr = s.toCharArray();
		// for(char c : cArr){
		// 	System.out.println("'"+c+"'");
		// }
		// //1023
		// String f = sc.nextLine();
		// StringTokenizer st = new StringTokenizer(f,".");
		// while(st.hasMoreTokens()){
		// 	System.out.println(st.nextToken());
		// }
		// //1021, 1022
		// String st = sc.nextLine();
		// System.out.println(st);
		// //1020
		// String privateNumber = sc.nextLine();
		// String front = privateNumber.substring(0,6);
		// String end = privateNumber.substring(7,14);
		// System.out.println(front+end);
		// //1019
		// String ymd = sc.nextLine();
		// StringTokenizer tokenizer = new StringTokenizer(ymd,".");
		// int[] intArr = new int[3];
		// for (int i = 0; i < 3; i++) {
		// 	intArr[i] = Integer.parseInt(tokenizer.nextToken());
		// }
		// String y = String.format("%04d",intArr[0]);
		// String m = String.format("%02d",intArr[1]);
		// String h = String.format("%02d",intArr[2]);
		// System.out.println(y+"."+m+"."+h);
		// //1018
		// String time = sc.nextLine();
		// String[] arr = time.split(":");
		// String h = arr[0];
		// String m = arr[1];
		// System.out.println(h+":"+m);
		// //1017
		// int a = sc.nextInt();
		// System.out.println(a+" "+a+" "+a);
		// //1015
		// float f = sc.nextFloat();
		// String f3 = String.format("%.2f",f);
		// System.out.println(f3);
		// //1014
		// char x = sc.next().charAt(0);
		// char y = sc.next().charAt(0);
		// System.out.println(y+" "+x);
		// //1013
		// int a = sc.nextInt();
		// int b = sc.nextInt();
		// System.out.println(a + " "+b);
		//// 1012
		// float x = sc.nextFloat();
		// String x6 = String.format("%.6f", x);
		// System.out.println(x6);
		////1011
		// char x = sc.next().charAt(0);
		// System.out.println(x);
		////1010
		// int n = sc.nextInt();
		// System.out.println(n);
	}
}
