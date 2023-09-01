package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day01 {

    /**
     * 두 수의 합
     *
     * 문제 설명
     * 정수 num1과 num2가 주어질 때,
     * num1과 num2의 합을 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * -50,000 ≤ num1 ≤ 50,000
     * -50,000 ≤ num2 ≤ 50,000
     */
    int solution_01(int num1, int num2) {
        return num1 + num2;
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(2,3)).isEqualTo(5);
        Assertions.assertThat(solution_01(100,2)).isEqualTo(102);

    }

    /**
     * 두 수의 차
     *
     * 문제 설명
     * 정수 num1과 num2가 주어질 때,
     * num1에서 num2를 뺀 값을 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * -50000 ≤ num1 ≤ 50000
     * -50000 ≤ num2 ≤ 50000
     */

    int solution_02(int num1, int num2) {
        return num1 - num2;
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(2,3)).isEqualTo(-1);
        Assertions.assertThat(solution_02(100,2)).isEqualTo(98);
    }

    /**
     * 두 수의 곱
     *
     * 문제 설명
     * 정수 num1, num2가 매개변수 주어집니다.
     * num1과 num2를 곱한 값을 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 0 ≤ num1 ≤ 100
     * 0 ≤ num2 ≤ 100
     */
    int solution_03(int num1, int num2) {
        return num1 * num2;
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(3,4)).isEqualTo(12);
        Assertions.assertThat(solution_03(27,19)).isEqualTo(513);
    }

    /**
     * 몫 구하기
     *
     * 문제 설명
     * 정수 num1, num2가 매개변수로 주어질 때, num1을 num2로 나눈 몫을 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 0 < num1 ≤ 100
     * 0 < num2 ≤ 100
     */
    int solution_04(int num1, int num2) {
        return num1 / num2;
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(10,5)).isEqualTo(2);
        Assertions.assertThat(solution_04(7,2)).isEqualTo(3);
    }
}
