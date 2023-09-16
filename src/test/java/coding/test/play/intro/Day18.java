package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day18 {

    /**
     * 문자열안에 문자열
     *
     * 문제 설명
     * 문자열 str1, str2가 매개변수로 주어집니다. str1 안에 str2가 있다면 1을 없다면 2를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ str1의 길이 ≤ 100
     * 1 ≤ str2의 길이 ≤ 100
     * 문자열은 알파벳 대문자, 소문자, 숫자로 구성되어 있습니다.
     */
    public int solution_01(String str1, String str2) {
        return str1.contains(str2) ? 1 : 2;
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01("ab6CDE443fgh22iJKlmn1o", "6CD")).isEqualTo(1);
        Assertions.assertThat(solution_01("ppprrrogrammers", "pppp")).isEqualTo(2);
        Assertions.assertThat(solution_01("AbcAbcA", "AAA")).isEqualTo(2);
    }

    /**
     * 제곱수 판별하기
     *
     * 문제 설명
     * 어떤 자연수를 제곱했을 때 나오는 정수를 제곱수라고 합니다.
     * 정수 n이 매개변수로 주어질 때, n이 제곱수라면 1을 아니라면 2를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ n ≤ 1,000,000
     */
    public int solution_02(int n) {
        int answer = (int) IntStream.rangeClosed(1, n)
                .filter(i -> n % i == 0)
                .filter(j -> j * j == n)
                .count();
        return answer > 0 ? 1 : 2;
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(144)).isEqualTo(1);
        Assertions.assertThat(solution_02(976)).isEqualTo(2);
    }

    /**
     * 세균 증식
     *
     * 문제 설명
     * 어떤 세균은 1시간에 두배만큼 증식한다고 합니다.
     * 처음 세균의 마리수 n과 경과한 시간 t가 매개변수로 주어질 때 t시간 후 세균의 수를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ n ≤ 10
     * 1 ≤ t ≤ 15
     */
    public int solution_03(int n, int t) {
        int answer = n;
        for (int i = 0; i < t; i++) {
            answer *= 2;
        }
        return answer;
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(2, 10)).isEqualTo(2_048);
        Assertions.assertThat(solution_03(7, 15)).isEqualTo(229_376);
    }

    /**
     * 문자열 정렬하기 (2)
     *
     * 문제 설명
     * 영어 대소문자로 이루어진 문자열 my_string이 매개변수로 주어질 때,
     * my_string을 모두 소문자로 바꾸고 알파벳 순서대로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 0 < my_string 길이 < 100
     */
    public String solution_04(String my_string) {
        return Arrays.stream(my_string.split(""))
                    .map(v -> v.toLowerCase())
                    .sorted()
                    .collect(Collectors.joining());
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04("Bcad")).isEqualTo("abcd");
        Assertions.assertThat(solution_04("heLLo")).isEqualTo("ehllo");
        Assertions.assertThat(solution_04("Python")).isEqualTo("hnopty");
    }
}
