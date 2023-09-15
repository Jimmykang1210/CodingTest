package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day17 {

    /**
     * 숫자 찾기
     *
     * 문제 설명
     * 정수 num과 k가 매개변수로 주어질 때,
     * num을 이루는 숫자 중에 k가 있으면 num의 그 숫자가 있는 자리 수를 return하고 없으면 -1을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 0 < num < 1,000,000
     * 0 ≤ k < 10
     * num에 k가 여러 개 있으면 가장 처음 나타나는 자리를 return 합니다.
     */
    public int solution_01(int num, int k) {
        String[] arr = String.valueOf(num).split("");
        for (int i = 0; i < arr.length; i++) {
            if (k == Integer.parseInt(arr[i])) {
                return i+1;
            }
        }
        return -1;

        //================ 더 좋은 풀이
//        int answer = String.valueOf(num)
//                          .indexOf(String.valueOf(k));
//        return answer < 0 ? -1 : answer + 1 ;
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(29183,1)).isEqualTo(3);
        Assertions.assertThat(solution_01(232443,4)).isEqualTo(4);
        Assertions.assertThat(solution_01(123456,7)).isEqualTo(-1);
    }

    /**
     * n의 배수 고르기
     *
     * 문제 설명
     * 정수 n과 정수 배열 numlist가 매개변수로 주어질 때,
     * numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ n ≤ 10,000
     * 1 ≤ numlist의 크기 ≤ 100
     * 1 ≤ numlist의 원소 ≤ 100,000
     */
    public int[] solution_02(int n, int[] numlist) {
        return Arrays.stream(numlist).filter(v -> v % n == 0).toArray();
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(3,	new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12})).isEqualTo(new int[]{6, 9, 12});
        Assertions.assertThat(solution_02(5,	new int[]{1, 9, 3, 10, 13, 5})).isEqualTo(new int[]{10, 5});
        Assertions.assertThat(solution_02(12, new int[]{2, 100, 120, 600, 12, 12})).isEqualTo(new int[]{120, 600, 12, 12});
    }

    /**
     * 자릿수 더하기
     *
     * 문제 설명
     * 정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요
     *
     * 제한사항
     * 0 ≤ n ≤ 1,000,000
     */
    public int solution_03(int n) {
        return Arrays.stream(String.valueOf(n).split("")).mapToInt(v -> Integer.parseInt(v)).sum();
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(1234)).isEqualTo(10);
        Assertions.assertThat(solution_03(930211)).isEqualTo(16);
    }

    /**
     * OX퀴즈
     *
     * 문제 설명
     * 덧셈, 뺄셈 수식들이 'X [연산자] Y = Z' 형태로 들어있는 문자열 배열 quiz가 매개변수로 주어집니다.
     * 수식이 옳다면 "O"를 틀리다면 "X"를 순서대로 담은 배열을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 연산 기호와 숫자 사이는 항상 하나의 공백이 존재합니다. 단 음수를 표시하는 마이너스 기호와 숫자 사이에는 공백이 존재하지 않습니다.
     * 1 ≤ quiz의 길이 ≤ 10
     * X, Y, Z는 각각 0부터 9까지 숫자로 이루어진 정수를 의미하며, 각 숫자의 맨 앞에 마이너스 기호가 하나 있을 수 있고 이는 음수를 의미합니다.
     * X, Y, Z는 0을 제외하고는 0으로 시작하지 않습니다.
     * -10,000 ≤ X, Y ≤ 10,000
     * -20,000 ≤ Z ≤ 20,000
     * [연산자]는 + 와 - 중 하나입니다.
     */
    public String[] solution_04(String[] quiz) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < quiz.length; i++) {
            String[] arr = quiz[i].split(" ");
            int leftValue = Integer.parseInt(arr[0]);

            for (int j=1; j<arr.length-2; j++) {
                if (arr[j].equals("+")) {
                    leftValue += Integer.parseInt(arr[j+1]);
                } else if (arr[j].equals("-")) {
                    leftValue -= Integer.parseInt(arr[j+1]);
                }
            }

            answer.add(leftValue == Integer.parseInt(arr[arr.length-1]) ? "O" : "X");
        }
        return answer.toArray(new String[0]);
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(new String[]{"3 - 4 = -3", "5 + 6 = 11"})).isEqualTo(new String[]{"X", "O"});
        Assertions.assertThat(solution_04(new String[]{"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"})).isEqualTo(new String[]{"O", "O", "X", "O"});
    }
}

