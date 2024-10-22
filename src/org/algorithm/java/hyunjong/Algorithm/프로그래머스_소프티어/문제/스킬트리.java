package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Map에 Skill에있는 각 스킬의 선행 스킬을 Set에 저장한다.
skill_trees의 각 스킬트리에서 각 스킬의 이전 스킬들을 비교하면서 해당 스킬의 선행스킬의 개수를 구한다.
그 후 구해진 개수와 set에 저장된 선행 스킬 개수를 비교해서 같지 않다면 불가능한 스킬트리로 지정하고
그렇지 않다면 answer를 +1 증가해준다.

풀이가 지저분해서 다른 분의 풀이를 확인해보니 skill_trees의 각 스킬트리의 스킬 하나하나를 비교하면서
skill에 존재하지 않는 스킬이라면 빈문자열로 변경해준다.
해당 스킬트리를 모두 변경하고난뒤 skill과 비교해서 동일하다면 가능한 스킬트리, 동일하지 않다면 불가능한 스킬트리가 된다.
메모리상, 시간상 훨씬 좋다.
 */
public class 스킬트리 {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill, skill_trees));
	}

	static int solution(String skill, String[] skill_trees){
		Map<Character, Set<Character>> map = new HashMap<>();

		for(int i=0;i<skill.length();i++){
			char c = skill.charAt(i);
			if(!map.containsKey(c)) map.put(c, new HashSet<>());
			for(int j=0;j<i;j++){
				map.get(c).add(skill.charAt(j));
			}
		}

		int answer = 0;

		for(String skillTree : skill_trees){
			boolean flag = true;
			for(int i=0;i<skillTree.length();i++){
				char s = skillTree.charAt(i);
				if(!map.containsKey(s)) continue;
				int preCount = 0;
				for(int j=0;j<i;j++){
					if(map.get(s).contains(skillTree.charAt(j))) {
						preCount++;
					}
				}
				if(preCount < map.get(s).size()) {
					flag = false;
					break;
				}
			}
			if(flag) {
				answer++;
			}
		}

		return answer;
	}
}
