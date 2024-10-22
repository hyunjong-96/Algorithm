package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.카카오;

import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class 오픈채팅방 {
	public static void main(String[] args){
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] result = solution(record);
		for(String r : result){
			System.out.println(r);
		}
	}

	static String[] solution(String[] record){
		Map<String, String> nickname_map = new HashMap<>();
		LinkedList<Message> ll = new LinkedList<>();

		//record를 돌면서 행동과 uid를 ll에 저장, 그리고 uid를 기준으로 nicknameMap에 nickname저장
		for(String r : record){
			String[] arr = r.split(" ");
			String behave = arr[0];
			String uid = arr[1];
			if(behave.equals("Leave")){
				ll.add(new Message(behave, uid));
				continue;
			}
			String nickName = arr[2];
			nickname_map.computeIfAbsent(uid, n->nickName);
			nickname_map.put(uid, nickName);
			ll.add(new Message(behave, uid));
		}

		List<String> answer = new ArrayList<>();
		//ll을 돌면서 저장된 행동에 따른 메시지 sb에 저장
		while(!ll.isEmpty()){
			Message m = ll.getFirst();
			String nickName = nickname_map.get(m.uid);
			if(m.behave.equals("Enter")){
				answer.add(nickName+"님이 들어왔습니다.");
			}else if(m.behave.equals("Leave")){
				answer.add(nickName+"님이 나갔습니다.");
			}
			ll.remove();
		}

		return answer.toArray(new String[0]);
	}

}

class Message{
	String behave;
	String uid;
	public Message(String behave, String uid){
		this.behave = behave;
		this.uid = uid;
	}
}
