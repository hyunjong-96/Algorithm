package org.algorithm.java.hyunjong.Algorithm.PandYCount;

public class P_Y_Count {
	public boolean solution(String s) {
		System.out.println("s : "+s);
		boolean answer = true;

		String[] convertArray = s.split("");

		String compareY = "Y";
		String compareP = "P";

		int countY = 0;
		int countP = 0;

		for (String value : convertArray) {
			String pc = value.toUpperCase();
			if (pc.equals(compareP))
				countP++;
			if (pc.equals(compareY))
				countY++;
		}
		System.out.println("countP : "+countP);
		System.out.println("county : "+countY);

		if(countP != countY) answer = false;

		return answer;
	}
}
