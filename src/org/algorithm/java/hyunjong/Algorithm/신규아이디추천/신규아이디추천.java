package org.algorithm.java.hyunjong.Algorithm.신규아이디추천;

public class 신규아이디추천 {
    public String solution(String new_id){
        //1단계
        new_id = new_id.toLowerCase()
                .replaceAll("[^\\w-.]","")//2단계
                .replaceAll("[.]{2,}",".")//3단계
                .replaceAll("^[.]|[.]$","");//4단계
        if(new_id.length()<1) new_id="a";//5단계
        if(new_id.length()>=16) new_id=new_id.substring(0,15).replaceAll("[.]$","");//6단계
        if(new_id.length()<=2){
            while(new_id.length()<3){
                new_id+=new_id.charAt(new_id.length()-1);
            }
        }
        System.out.println(new_id);
        return new_id;
    }
}
