package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day23 {
    /**
     * 특이한 정렬 ★★
     *
     * 문제 설명
     * 정수 n을 기준으로 n과 가까운 수부터 정렬하려고 합니다.
     * 이때 n으로부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치합니다.
     * 정수가 담긴 배열 numlist와 정수 n이 주어질 때 numlist의 원소를 n으로부터 가까운 순서대로
     * 정렬한 배열을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ n ≤ 10,000
     * 1 ≤ numlist의 원소 ≤ 10,000
     * 1 ≤ numlist의 길이 ≤ 100
     * numlist는 중복된 원소를 갖지 않습니다.
     */
    public int[] solution_01(int[] numlist, int n) {
        final Integer fix = new Integer(n);
        List<Integer> answer = Arrays.stream(numlist)
                                    .boxed()
                                    .collect(Collectors.toList());

        Collections.sort(answer, (a, b) -> {
            if(Math.abs(a-fix)!=Math.abs(b-fix)) {
                return Math.abs(a-fix)-Math.abs(b-fix);
            } else {
                return b-a;
            }
        });

        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

        //================ 더 좋은 풀이
//        return Arrays.stream(numList)
//                .boxed()
//                .sorted((a, b) -> Math.abs(a - n) == Math.abs(b - n) ? b.compareTo(a) : Integer.compare(Math.abs(a - n), Math.abs(b - n)))
//                .mapToInt(Integer::intValue)
//                .toArray();
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(new int[]{1,2,3,4,5,6},4)).isEqualTo(new int[] {4,5,3,6,2,1});
        Assertions.assertThat(solution_01(new int[]{10000,20,36,47,40,6,10,7000},30)).isEqualTo(new int[] {36,40,20,47,10,6,7000,10000});
    }

    /**
     * 등수 매기기 ★★
     *
     * 문제 설명
     * 영어 점수와 수학 점수의 평균 점수를 기준으로 학생들의 등수를 매기려고 합니다.
     * 영어 점수와 수학 점수를 담은 2차원 정수 배열 score가 주어질 때,
     * 영어 점수와 수학 점수의 평균을 기준으로 매긴 등수를 담은 배열을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 0 ≤ score[0], score[1] ≤ 100
     * 1 ≤ score의 길이 ≤ 10
     * score의 원소 길이는 2입니다.
     * score는 중복된 원소를 갖지 않습니다.
     */
    public int[] solution_02(int[][] score) {
        List<Integer> scoreList = new ArrayList<>();
        for(int[] t : score){
            scoreList.add(t[0] + t[1]);
        }
        scoreList.sort(Comparator.reverseOrder());

        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++){
            answer[i] = scoreList.indexOf(score[i][0] + score[i][1])+1;
        }
        return answer;
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(new int[][]{ new int[]{80,70}, new int[]{90,50}, new int[]{40,70}, new int[]{50,80} })).isEqualTo(new int[]{1,2,4,3});
        Assertions.assertThat(solution_02(new int[][]{ new int[]{80,70}, new int[]{70,80}, new int[]{30,50}, new int[]{90,100}, new int[]{100,90}, new int[]{100,100}, new int[]{10,30} })).isEqualTo(new int[]{4,4,6,2,2,1,7});
    }

    /**
     * 옹알이 (1)
     *
     * 문제 설명
     * 머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다.
     * 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다.
     * 문자열 배열 babbling이 매개변수로 주어질 때,
     * 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ babbling의 길이 ≤ 100
     * 1 ≤ babbling[i]의 길이 ≤ 15
     * babbling의 각 문자열에서 "aya", "ye", "woo", "ma"는 각각 최대 한 번씩만 등장합니다.
     * 즉, 각 문자열의 가능한 모든 부분 문자열 중에서 "aya", "ye", "woo", "ma"가 한 번씩만 등장합니다.
     * 문자열은 알파벳 소문자로만 이루어져 있습니다.
     */
    public int solution_03(String[] babbling) {
        String[] arr = new String[]{"aya", "ye", "woo", "ma"};
        return (int) Arrays.stream(babbling).filter(v -> {
                    for (int i = 0; i < arr.length; i++) {
                        v = v.replace(arr[i], " ");
                    }
                    return v.trim().isEmpty();
                }).count();

        //================ 더 좋은 풀이
//        int answer = 0;
//        for(int i=0; i<babbling.length; i++){
//            if(babbling[i].matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$")){
//                answer++;
//            }
//        }
//        return answer;
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(new String[]{"aya","yee","u","maa","wyeoo"})).isEqualTo(1);
        Assertions.assertThat(solution_03(new String[]{"ayaye","uuuma","ye","yemawoo","ayaa"})).isEqualTo(3);
    }

    /**
     * 로그인 성공?
     *
     * 문제 설명
     * 머쓱이는 프로그래머스에 로그인하려고 합니다.
     * 머쓱이가 입력한 아이디와 패스워드가 담긴 배열 id_pw와 회원들의 정보가 담긴 2차원 배열 db가 주어질 때,
     * 다음과 같이 로그인 성공, 실패에 따른 메시지를 return하도록 solution 함수를 완성해주세요.
     *
     * 아이디와 비밀번호가 모두 일치하는 회원정보가 있으면 "login"을 return합니다.
     * 로그인이 실패했을 때 아이디가 일치하는 회원이 없다면 “fail”를,
     * 아이디는 일치하지만 비밀번호가 일치하는 회원이 없다면 “wrong pw”를 return 합니다.
     */
    public String solution_04(String[] id_pw, String[][] db) {
        String answer = "";
        // 아이디가 존재하지 않는 경우, 아이디만 같은 경우, 아이디 비밀번호 다 같은 경우
        for (int i = 0; i < db.length; i++) {
            if (id_pw[0].equals(db[i][0])) {
                if (id_pw[1].equals(db[i][1])) {
                    return "login";
                } else {
                    answer = "wrong pw";
                }
            }
        }
        return answer.isEmpty() ? "fail" : answer;
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(new String[]{"meosseugi", "1234"}
                , new String[][]{{"rardss", "123"},{"yyoom", "1234"},{"meosseugi", "1234"}})).isEqualTo("login");
        Assertions.assertThat(solution_04(new String[]{"programmer01", "15789"}
                , new String[][]{{"programmer02", "111111"},{"programmer00", "134"},{"programmer01", "1145"}})).isEqualTo("wrong pw");
        Assertions.assertThat(solution_04(new String[]{"rabbit04", "98761"}
                , new String[][]{{"jaja11", "98761"},{"krong0313", "29440"},{"rabbit00", "111333"}})).isEqualTo("fail");
    }
}
