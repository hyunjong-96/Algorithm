package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.HashMap;
import java.util.Map;

/*
enroll[i]를 Person 객체로 만들고 referral[i]가 "-"이 아니라면 referral[i]는 Person객체가 만들어져있다.
그렇기 때문에 enroll[i]의 Person에 personMap.get(referal[i])를 만들어서 부모-자식 관계를 가지는 트리를 만들어준다.

seller를 반복하여 부모가 민수거나 10% profit이 1미만일때까지 자신에게 profit - profit/10을 추가해주고
자신의 부모와 profit을 넘겨주어 반복한다.

seller를 돌고 부모를 타고 재귀함수를 돌게 되는데 seller가 100000, enroll이 10000이라서 O(100000*10000)이라 시간초과가 발생할줄 알았다.
하지만 또하나의 조건인 amount는 최대 100이기 때문에 시작 이익값이 최대 10000이다.
결국 최대 5번까지 부모를 타고 올라가기 때문에 최악에는 O(100000 * 5)이기 때문에 시간복잡도가 발생하지 않는것.
 */
public class 다단계칫솔판매 {
	public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};

		int[] result = solution(enroll, referral, seller, amount);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		Map<String, Person> personMap = new HashMap<>();    //이름의 Person

		for (int i = 0; i < enroll.length; i++) {
			Person person = new Person(enroll[i]);
			personMap.put(enroll[i], person);

			//부모가 "-"이면 민수가 부모
			if (!referral[i].equals("-")) {
				//부모(referral[i])는 무조건 존재한다.
				Person parent = personMap.get(referral[i]);
				person.setParent(parent);
			}
		}

		for (int i = 0; i < seller.length; i++) {
			sendProfit(personMap.get(seller[i]), amount[i] * 100);
		}

		int[] answer = new int[enroll.length];
		for (int i = 0; i < enroll.length; i++) {
			answer[i] = personMap.get(enroll[i]).profit;
		}

		return answer;
	}

	static void sendProfit(Person person, int profit) {
		//민수는 계산하지 않는다.
		if (person == null) return;

		//부모가 민수가 아니라면 10%이익에서 뺀 값을 나한테 추가한다.
		person.addProfit(profit - profit / 10);

		//10%이익이 1원 미만이라면 부모로 넘어갈 필요가 없다.
		if (profit / 10 == 0) return;

		//부모에게 10%이익을 넘겨줌
		sendProfit(person.parent, profit / 10);
	}

	static class Person {
		Person parent;
		String name;
		int profit;

		public Person(String name) {
			this.parent = null;
			this.name = name;
			this.profit = 0;
		}

		public void setParent(Person parent) {
			this.parent = parent;
		}

		public void addProfit(int profit) {
			this.profit += profit;
		}
	}
}
