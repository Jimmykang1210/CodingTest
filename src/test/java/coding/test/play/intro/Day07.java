package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day07 {

    /**
     * 특정 문자 제거하기
     *
     * 문제 설명
     * 문자열 my_string과 문자 letter이 매개변수로 주어집니다.
     * my_string에서 letter를 제거한 문자열을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ my_string의 길이 ≤ 100
     * letter은 길이가 1인 영문자입니다.
     * my_string과 letter은 알파벳 대소문자로 이루어져 있습니다.
     * 대문자와 소문자를 구분합니다.
     */
    String solution_01(String my_string, String letter) {
        // String 문자열을 한글자씩 List<String>으로 변환
        List<String> list = Arrays.asList(my_string.split(""));

        // letter 문제 제거 후, 재조합
        return list.stream().filter(m-> !m.equals(letter)).collect(Collectors.joining());
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01("abcdef", "f")).isEqualTo("abcde");
        Assertions.assertThat(solution_01("BCBdbe", "B")).isEqualTo("Cdbe");
    }

    /**
     * 각도기
     *
     * 문제 설명
     * 각에서 0도 초과 90도 미만은 예각, 90도는 직각, 90도 초과 180도 미만은 둔각 180도는 평각으로 분류합니다.
     * 각 angle이 매개변수로 주어질 때 예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를 return 하도록 solution 함수를 완성해주세요.
     *
     * 예각 : 0 < angle < 90
     * 직각 : angle = 90
     * 둔각 : 90 < angle < 180
     * 평각 : angle = 180
     * 제한사항
     * 0 < angle ≤ 180
     * angle은 정수입니다.
     */
    int solution_02(int angle) {
        if (angle < 90) {
            return 1;
        } else if (angle == 90) {
            return 2;
        } else if (angle == 180) {
            return 4;
        }
        return 3;
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(70)).isEqualTo(1);
        Assertions.assertThat(solution_02(91)).isEqualTo(3);
        Assertions.assertThat(solution_02(180)).isEqualTo(4);
    }

    /**
     * 양꼬치
     *
     * 문제 설명
     * 머쓱이네 양꼬치 가게는 10인분을 먹으면 음료수 하나를 서비스로 줍니다.
     * 양꼬치는 1인분에 12,000원, 음료수는 2,000원입니다.
     *
     * 정수 n과 k가 매개변수로 주어졌을 때,
     * 양꼬치 n인분과 음료수 k개를 먹었다면 총얼마를 지불해야 하는지 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 0 < n < 1,000
     * n / 10 ≤ k < 1,000
     * 서비스로 받은 음료수는 모두 마십니다.
     */
    int solution_03(int n, int k) {
        int tip_k = n / 10;
        return (n * 12_000) + ((k - tip_k) * 2_000);
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(10, 3)).isEqualTo(124_000);
        Assertions.assertThat(solution_03(64, 6)).isEqualTo(768_000);
    }

    /**
     * 짝수의 합
     *
     * 문제 설명
     * 정수 n이 주어질 때, n이하의 짝수를 모두 더한 값을 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한사항
     * 0 < n ≤ 1000
     */
    int solution_04(int n) {
        return IntStream.rangeClosed(1, n).filter(k -> k % 2 == 0).sum();
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(10)).isEqualTo(30);
        Assertions.assertThat(solution_04(4)).isEqualTo(6);
    }
}
