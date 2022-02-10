package org.algorithm.java.hyunjong;

import java.util.Arrays;

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
import org.algorithm.java.hyunjong.Algorithm.stack.Stack;
import org.algorithm.java.hyunjong.Algorithm.stack.StackSort;
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

    public static void main(String[] args) {
        sortStack();
    }
    private static void 두뽑더(){
        int[] number = {2,1,3,4,1};
        두개더뽑아서더하기 first = new 두개더뽑아서더하기();
        first.solution(number);
    }
    private static void 크인게(){
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        크레인인형뽑기게임 second = new 크레인인형뽑기게임();
        second.solution(board,moves);
    }
    private static void 아이디추천(){
        String new_id="=.=";
        신규아이디추천 third = new 신규아이디추천();
        third.solution(new_id);
    }
    private static void 완주하지못한선수(){
        String[] participant={"mislav", "stanko", "mislav", "ana"};
        String[] completion={"stanko", "ana", "mislav"};
        완주하지못한선수 fourth = new 완주하지못한선수();
        fourth.solution(participant,completion);
    }
    private static void 모의고사(){
        int[] answers = {1,3,2,4,2};
        모의고사 fifth = new 모의고사();
        fifth.solution(answers);
    }

    private static void 체육복(){
        int n = 5;
        int[] lost = {2,3,4};
        int[] reserve = {2,5};
        체육복 six = new 체육복();
        System.out.print(six.solution(n,lost,reserve));
    }

    private static void 키패드누르기(){
        int[] numbers = new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        키패드누르기 seven = new 키패드누르기();
        System.out.println(seven.solution(numbers,hand));
    }

    private static void K번째수(){
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        K번째 k번째 = new K번째();
        System.out.println(k번째.solution(array,commands));
    }

    private static void 소수만들기(){
        int[] nums = {1,2,7,6,4};
        소수만들기 S = new 소수만들기();
        System.out.println(S.solution(nums));
    }

    private static void 예산(){
        int[] d = {2,2,3,3};
        int budget = 10;
        예산 s = new 예산();
        System.out.println(s.solution(d,budget));
    }

    private static void lotto(){
        int[] lottos = {45,4,35,20,3,9};
        int[] win_nums = {20,9,3,45,4,35};
        LottoMaxAndMin s = new LottoMaxAndMin();
        s.solution(lottos,win_nums);
    }

    private static void monster(){
        int[] nums = {3,3,3,2,2,2};
        PhoneMonster s = new PhoneMonster();
        System.out.println(s.solution(nums));
    }

    private static void failRate(){
        int[] stages={2, 1, 2, 6, 2, 4, 3, 3};
        int N = 5;
        FailedRate s = new FailedRate();
        System.out.println(s.solution(N,stages).toString());
    }

    private static void Inners(){
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};
        내적 s = new 내적();
        System.out.println(s.solution(a,b));
    }

    private static void Divisor(){
        int left = 13;
        int right = 17;
        Divisor s = new Divisor();
        System.out.print(s.soilution(left,right));
    }

    private static void MiunsPlusAdd(){
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};
        MiunsPlusAdd s = new MiunsPlusAdd();
        System.out.println(s.solution(absolutes,signs));
    }

    private static void TriadFlip(){
        int n=45;
        TriadFlip s = new TriadFlip();
        System.out.println(s.solution(n));
    }

    private static void Year2016(){
        int a= 4;
        int b = 7;
        year2016 s = new year2016();
        System.out.println(s.solution(a,b));
    }

    private static void SecretMap(){
        int n = 6;
        int[] arr1 = {46,33,33,22,31,50};
        int[] arr2 = {27,56,19,14,14,10};
        secretMap s = new secretMap();
        System.out.println(Arrays.toString(s.solution(n, arr1, arr2)));
    }

    private static void CenterWord(){
        String s = "abcd";
        CenterWord c = new CenterWord();
        System.out.println(c.solution(s));
    }

    private static void Distinct(){
        int[] arr = {4,4,4,3,3};
        Distinct s = new Distinct();
        System.out.println(Arrays.toString(s.solution(arr)));
    }

    private static void DartGame(){
        String dartResult = "1D2S#10S";
        DartGame s = new DartGame();
        System.out.println(s.solution(dartResult));
    }

    private static void DivideAndFallNumber(){
        int[] arr = {2,36,1,3};
        int divisor = 1;
        DivideAndFallNumber s = new DivideAndFallNumber();
        System.out.println(Arrays.toString(s.solution(arr, divisor)));
    }

    private static void SumBetween(){
        int a = 3;
        int b = 5;
        SumBetween s = new SumBetween();
        System.out.println(s.solution(a,b));
    }

    private static void StringSorted(){
        String[] strings = {"abce","abcd","cdx"};
        int n = 2;
        StringSorted s = new StringSorted();
        System.out.println(Arrays.toString(s.solution(strings,2)));
    }

    private static void StringCompression(){
        String s = "ababcdcdababcdcd";
        StringCompression result = new StringCompression();
        System.out.println(result.solution(s));
    }

    private static void StringCharCount(){
        String s = "pPoooyY";
        P_Y_Count result = new P_Y_Count();
        System.out.println(result.solution(s));
    }

    private static void StringDescSort(){
        String s = "Zbcdefg";
        StringDesc result = new StringDesc();
        System.out.println(result.solution(s));
    }

    private static void StringBasic(){
        String s = "1234";
        StringBasic result = new StringBasic();
        System.out.println(result.solution(s));
    }

    private static void FindKim(){
        String[] s = new String[]{"Jane", "Kim"};
        FindKimInSeoul result = new FindKimInSeoul();
        System.out.println(result.solution(s));
    }

    private static void FindMinority(){
        int s = 10;
        FindMinority result = new FindMinority();
        System.out.println(result.solution(s));
    }

    private static void 수박수박수(){
        int s = 3;
        수박수박수 result = new 수박수박수();
        System.out.println(result.solution(s));
    }

    private static void 문자열을_숫자로(){
        String s = "1234";
        StringToInteger result = new StringToInteger();
        System.out.println(result.solution(s));
    }

    private static void 시저암호(){
        String s = "a B z";
        int n = 4;
        시저암호 result = new 시저암호();
        System.out.println(result.solution(s,n));
    }

    private static void linkedList_oneWay(){
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

    private static void linkedListNode(){
        Linked_List_Node ll = new Linked_List_Node();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.delete(1);
        ll.retrieve();
    }

    private static void linkedListNodeDuplicate(){
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

    private static void linedListNode_Select_Index_From_End(){
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

    private static void my_stack(){
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

    private static void my_queue(){
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

    private static void sortStack(){
        StackSort stackSort = new StackSort(new int[] {3,5,1,6});
        stackSort.sort();
        Stack<Integer> result = stackSort.getSort();
        while (!result.isEmpty()){
            System.out.println(result.pop());
        }
    }
}
