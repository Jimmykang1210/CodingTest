package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day25 {

    /**
     * 다음에 올 숫자
     *
     * 문제 설명
     * 등차수열 혹은 등비수열 common이 매개변수로 주어질 때,
     * 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 2 < common의 길이 < 1,000
     * -1,000 < common의 원소 < 2,000
     * common의 원소는 모두 정수입니다.
     * 등차수열 혹은 등비수열이 아닌 경우는 없습니다.
     * 등비수열인 경우 공비는 0이 아닌 정수입니다.
     */
    public int solution_01(int[] common) {
        // 등차수열인 경우
        int cha = common[1] - common[0];
        if (common[2] == common[1] + cha) {
            return common[common.length-1] + cha;
        }
        // 등비수열인 경우
        int div = common[1] / common[0];
        if (common[2] == common[1] * div) {
            return common[common.length-1] * div;
        }
        return 0;
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(new int[]{1,2,3,4})).isEqualTo(5);
        Assertions.assertThat(solution_01(new int[]{2,4,8})).isEqualTo(16);
    }

    /**
     * 연속된 수의 합
     *
     * 문제 설명
     * 연속된 세 개의 정수를 더해 12가 되는 경우는 3, 4, 5입니다.
     * 두 정수 num과 total이 주어집니다. 연속된 수 num개를 더한 값이 total이 될 때,
     * 정수 배열을 오름차순으로 담아 return하도록 solution함수를 완성해보세요.
     *
     * 제한사항
     * 1 ≤ num ≤ 100
     * 0 ≤ total ≤ 1000
     * num개의 연속된 수를 더하여 total이 될 수 없는 테스트 케이스는 없습니다.
     */
    public int[] solution_02(int num, int total) {
        double middle = (double) total / num;
        int start = (int) Math.ceil(middle - (num / 2));
        int end = (int) Math.floor(middle + (num / 2));
        return IntStream.rangeClosed(start, end).toArray();
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(3,12)).isEqualTo(new int[]{3,4,5});
        Assertions.assertThat(solution_02(5,15)).isEqualTo(new int[]{1,2,3,4,5});
        Assertions.assertThat(solution_02(4,14)).isEqualTo(new int[]{2,3,4,5});
        Assertions.assertThat(solution_02(5,5)).isEqualTo(new int[]{-1,0,1,2,3});
    }

    /**
     * 종이 자르기 ★
     *
     * 문제 설명
     * 머쓱이는 큰 종이를 1 x 1 크기로 자르려고 합니다.
     * 예를 들어 2 x 2 크기의 종이를 1 x 1 크기로 자르려면 최소 가위질 세 번이 필요합니다.
     *
     * https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/37cec804-18c5-4c58-95fc-37b4d52e6e7f/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-07-25%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%204.49.44.png
     *
     * 정수 M, N이 매개변수로 주어질 때,
     * M x N 크기의 종이를 최소로 가위질 해야하는 횟수를 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 0 < M, N < 100
     * 종이를 겹쳐서 자를 수 없습니다.
     */
    public int solution_03(int M, int N) {
        int answer = 0;
        answer = M * N -1;
        return answer;
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(2,2)).isEqualTo(3);
        Assertions.assertThat(solution_03(2,5)).isEqualTo(9);
        Assertions.assertThat(solution_03(1,1)).isEqualTo(0);
    }

    /**
     * 문자열 밀기 ★
     *
     * 문제 설명
     * 문자열 "hello"에서 각 문자를 오른쪽으로 한 칸씩 밀고 마지막 문자는 맨 앞으로 이동시키면 "ohell"이 됩니다.
     * 이것을 문자열을 민다고 정의한다면 문자열 A와 B가 매개변수로 주어질 때,
     * A를 밀어서 B가 될 수 있다면 밀어야 하는 최소 횟수를 return하고 밀어서 B가 될 수 없으면 -1을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 0 < A의 길이 = B의 길이 < 100
     * A, B는 알파벳 소문자로 이루어져 있습니다.
     */
    public int solution_04(String A, String B) {
        int answer = 0;
        String copy = A;

        for (int i = 0; i < A.length(); i++) {
            if (copy.equals(B)) {
                return answer;
            }

            String a = copy.substring(copy.length() - 1);
            copy = a + copy.substring(0, copy.length() - 1);
            answer++;
        }

        return -1;

        //================ 더 좋은 풀이
//        String tempB = B.repeat(3);
//        return tempB.indexOf(A);
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04("hello","ohell")).isEqualTo(1);
        Assertions.assertThat(solution_04("apple","elppa")).isEqualTo(-1);
        Assertions.assertThat(solution_04("atat","tata")).isEqualTo(1);
        Assertions.assertThat(solution_04("abc","abc")).isEqualTo(0);
    }
}