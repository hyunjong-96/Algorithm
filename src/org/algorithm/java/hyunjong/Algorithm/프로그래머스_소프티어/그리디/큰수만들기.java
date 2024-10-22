package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.그리디;

/*
처음에 구현했을때는 정렬하고 최대 index구하려는 식 만들고 난리법석을 폈다.
시험보는것처럼 마음을 가지고 해봤는데 안풀리니까 멘탈이 나가졌다..
아무튼 구하려고 하는 흐름을 비슷했다. 다만 좀더 복잡하게 풀려고했었다.
K개의 숫자를 짜르게 되면 number.length()-k 자릿수의 숫자를 반환해야한다.
그리고 해당 자릿수 만큼 숫자를 만들기 위해서는 최대로 접근할수 있는 index는 k+i가 된다.
예를 들어 number="1231234", k=3 일 때, 4자리수의 숫자를 반환해야한다.
이때 index가 3이하의 숫자만 첫번째 숫자에 들어올수 있다. 왜냐면 4자리 수를 만들려고할때 index가 4인 숫자를 넣게되면
그 뒤에 남은 숫자는 2개만 남기때문에 더이상 4자리 숫자를 만들 숫자가 부족해지기 때문이다.
그렇기 떄문에 반환하려는 자릿수 만큼 반복문을 실행시키고 각 자릿수를 i라고 했을때 prevIndex부터 k+i까지의 숫자만 반환 숫자에 포함시킬수 있다.
i=0일때 number.charAt(0)부터 number.charAt(3)까지의 숫자중 하나를 넣을수 있고 그 중 가장 큰수를 넣어야한다.
큰 수를 찾게되면 prevIndex와 maxNum에 해당 index와 숫자를 갱신해주고 i가 length-k자릿수를 만들때까지 반복시켜준다.
 */
public class 큰수만들기 {
	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;
		System.out.println(solution(number, k));
	}
	static String solution(String number,  int k){
		StringBuilder sb = new StringBuilder();

		int prevIndex=0;
		//각 자릿수에 대한 숫자를 찾아내기 위한 반복
		for(int i=0;i<number.length()-k;i++){
			int maxNum=0;
			//prevIndex부터 최대 접근가능 index까지 돌면서 가장 큰 수를 찾는다.
			//가장 큰값을 찾으면 해당 index를 prevIndex에 갱신시켜주고
			//다음 자릿수에 대한 반복문을 실행할때 이전 index다음 index부터 k+i까지 중 큰 수를 다시 찾는 식으로 반복한다.
			for(int j=prevIndex;j<=k+i;j++){
				if(maxNum < number.charAt(j)-'0'){
					maxNum = number.charAt(j)-'0';
					prevIndex = j+1;
				}
			}
			sb.append(maxNum);
		}
		return sb.toString();
	}

	/*
	첫번쨰로 구현한 코드
	3개의 시간초과 발생
	 */
	// public String solution(String number, int k) {
	// 	//0~number.length()-k+1까지의 각 number의 숫자를 Number에 초기화
	// 	//Number정렬(num 내림차순, index 오름차순)
	// 	StringBuilder sb = new StringBuilder();
	// 	List<Number> numberList = new ArrayList<>();
	// 	for(int i=0;i<number.length();i++){
	// 		numberList.add(new Number(i, number.charAt(i)));
	// 	}
	// 	Collections.sort(numberList);
	//
	//
	// 	int numberSize = number.length()-k;
	// 	int prevIndex = 0;
	// 	for(int i=0;i<numberList.size();i++){
	// 		if(numberList.get(i).index <= k){
	// 			prevIndex = numberList.get(i).index;
	// 			sb.append(numberList.get(i).num);
	// 			numberList.remove(numberList.get(i));
	// 			numberSize--;
	// 			break;
	// 		}
	// 	}
	// 	//number.length()-k번 반복
	// 	for(int i=0;i<number.length()-k-1;i++){
	// 		for(int j=0;j<numberList.size();j++){
	// 			Number current = numberList.get(j);
	// 			if(current.index > prevIndex && number.length()-numberSize>= current.index){
	// 				prevIndex = current.index;
	// 				numberList.remove(current);
	// 				numberSize--;
	// 				sb.append(current.num);
	// 				break;
	// 			}
	// 		}
	// 	}
	//
	// 	String answer = sb.toString();
	// 	return answer;
	// }
	//
	// class Number implements Comparable<Number>{
	// 	int index;
	// 	int num;
	// 	public Number(int index, char num){
	// 		this.index = index;
	// 		this.num = num-'0';
	// 	}
	// 	@Override
	// 	public int compareTo(Number n){
	// 		if(this.num < n.num) return 1;
	// 		else if(this.num == n.num){
	// 			if(this.index > n.index) return 1;
	// 		}
	// 		return -1;
	// 	}
	// }
}
