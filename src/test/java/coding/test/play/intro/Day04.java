package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Day04 {

    /**
     * 피자 나눠 먹기 (1)
     *
     * 문제 설명
     * 머쓱이네 피자가게는 피자를 일곱 조각으로 잘라 줍니다.
     * 피자를 나눠먹을 사람의 수 n이 주어질 때, 모든 사람이 피자를 한 조각 이상 먹기 위해
     * 필요한 피자의 수를 return 하는 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 1 ≤ n ≤ 100
     */
    int solution_01(int n) {
        int quotient = n / 7;
        int remainder = n % 7;

        // 7 나눈 나머지가 존재하는 경우 몫 + 1, 딱 맞는 경우 몫
        return remainder != 0 ? quotient + 1 : quotient;
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(7)).isEqualTo(1);
        Assertions.assertThat(solution_01(1)).isEqualTo(1);
        Assertions.assertThat(solution_01(15)).isEqualTo(3);
    }

    /**
     * 피자 나눠 먹기 (2)
     *
     * 문제 설명
     * 머쓱이네 피자가게는 피자를 여섯 조각으로 잘라 줍니다.
     * 피자를 나눠먹을 사람의 수 n이 매개변수로 주어질 때,
     * n명이 주문한 피자를 남기지 않고 모두 같은 수의 피자 조각을 먹어야 한다면
     * 최소 몇 판을 시켜야 하는지를 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 1 ≤ n ≤ 100
     */
    int solution_02(int n) {
        // 최대 공약수 계산
        int gcdValue = gcd(6, n);

        // 최소 공배수 계산
        int lcmValue = (6 * n) / gcdValue;

        // 피자의 판 수 계산
        return lcmValue / 6;
    }

    // 최대 공약수 (유클리드 알고리즘)
    int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(6)).isEqualTo(1);
        Assertions.assertThat(solution_02(10)).isEqualTo(5);
        Assertions.assertThat(solution_02(4)).isEqualTo(2);
    }

    /**
     * 피자 나눠 먹기 (3)
     *
     * 문제 설명
     * 머쓱이네 피자가게는 피자를 두 조각에서 열 조각까지 원하는 조각 수로 잘라줍니다.
     * 피자 조각 수 slice와 피자를 먹는 사람의 수 n이 매개변수로 주어질 때,
     * n명의 사람이 최소 한 조각 이상 피자를 먹으려면
     * 최소 몇 판의 피자를 시켜야 하는지를 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 2 ≤ slice ≤ 10
     * 1 ≤ n ≤ 100
     */
    int solution_03(int slice, int n) {
        // n명 >= slice의 개수 * 피자 판수 개수
        int quotient = n / slice;
        int remainder = n % slice;

        // slice의 개수 나눈 나머지가 존재하는 경우 몫 + 1, 딱 맞는 경우 몫
        return remainder != 0 ? quotient + 1 : quotient;
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(7,10)).isEqualTo(2);
        Assertions.assertThat(solution_03(4,12)).isEqualTo(3);
    }

    /**
     * 배열의 평균값
     *
     * 문제 설명
     * 정수 배열 numbers가 매개변수로 주어집니다.
     * numbers의 원소의 평균값을 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 0 ≤ numbers의 원소 ≤ 1,000
     * 1 ≤ numbers의 길이 ≤ 100
     * 정답의 소수 부분이 .0 또는 .5인 경우만 입력으로 주어집니다.
     */
    double solution_04(int[] numbers) {
        return Arrays.stream(numbers).average().getAsDouble();
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})).isEqualTo(5.5);
        Assertions.assertThat(solution_04(new int[]{89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99})).isEqualTo(94.0);
    }
}
