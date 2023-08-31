package coding.test.play.intro;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

public class Day02 {

    /**
     * 두 수의 나눗셈
     *
     * 문제 설명
     * 정수 num1과 num2가 매개변수로 주어질 때, num1을 num2로 나눈 값에 1,000을 곱한 후 정수 부분을 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 0 < num1 ≤ 100
     * 0 < num2 ≤ 100
     */
    int solution_05(int num1, int num2) {
        int minValue = 0;
        int maxValue = 100;
        if (minValue <= num1 && minValue <= num2 && num1 <= maxValue && num2 <= maxValue ) {
            float result = ((float) num1 / (float) num2) * 1000;
            return (int)result;
        }
        return 0;
    }

    @Test
    void solution_05_test() {
        Assertions.assertThat(solution_05(3,2)).isEqualTo(1500);
        Assertions.assertThat(solution_05(7,3)).isEqualTo(2333);
        Assertions.assertThat(solution_05(1,16)).isEqualTo(62);
    }

    /**
     * 숫자 비교하기
     *
     * 문제 설명
     * 정수 num1과 num2가 매개변수로 주어집니다. 두 수가 같으면 1 다르면 -1을 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 0 ≤ num1 ≤ 10,000
     * 0 ≤ num2 ≤ 10,000
     */

    int solution_06(int num1, int num2) {
        int minValue = 0;
        int maxValue = 10_000;
        if (minValue <= num1 && minValue <= num2 && num1 <= maxValue && num2 <= maxValue ) {
            return num1 == num2 ? 1 : -1;
        }
        return 0;
    }

    @Test
    void solution_06_test() {
        Assertions.assertThat(solution_06(2,3)).isEqualTo(-1);
        Assertions.assertThat(solution_06(11,11)).isEqualTo(1);
        Assertions.assertThat(solution_06(7,99)).isEqualTo(-1);
    }

    /**
     * 분수의 덧셈
     *
     * 문제 설명
     * 첫 번째 분수의 분자와 분모를 뜻하는 num1, denom1,
     * 두 번째 분수의 분자와 분모를 뜻하는 num2, denom2가 매개변수로 주어집니다.
     * 두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 0 <num1, denom1, num2, denom2 < 1,000
     */
    int[] solution_07(int num1, int denom1, int num2, int denom2) {
        int numerator = num1 * denom2 + num2 * denom1; // 분자 계산
        int denominator = denom1 * denom2; // 분모 계산
        // 최대공약수 계산
        while (denominator != 0) {
            int r = numerator % denominator;
            numerator = denominator;
            denominator = r;
        }
        int gcd = Math.abs(numerator);
        return new int[] {numerator / gcd, denominator / gcd}; // 기약분수로 나타낸 결과 배열 반환
    }

    @Test
    void solution_07_test() {
        Assertions.assertThat(solution_07(1,2,3,4)).isEqualTo(new int[]{5,4});
        Assertions.assertThat(solution_07(9,2,1,3)).isEqualTo(new int[]{29,6});
    }

    /**
     * 배열 두배 만들기
     *
     * 문제 설명
     * 정수 배열 numbers가 매개변수로 주어집니다. numbers의 각 원소에 두배한 원소를 가진 배열을 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * -10,000 ≤ numbers의 원소 ≤ 10,000
     * 1 ≤ numbers의 길이 ≤ 1,000
     */
    int[] solution_08(int[] numbers) {
//        int minValue = 0;
//        int maxValue = 100;
//        if (minValue <= num1 && minValue <= num2 && num1 <= maxValue && num2 <= maxValue ) {
        return Arrays.stream(numbers).map(n -> n * 2).toArray(); // 각 원소를 2배하여 새로운 배열 생성
//        }
//        return 0;
    }

    @Test
    void solution_08_test() {
        Assertions.assertThat(solution_08(new int[]{1, 2, 3, 4, 5})).isEqualTo(new int[]{2, 4, 6, 8, 10});
        Assertions.assertThat(solution_08(new int[]{1, 2, 100, -99, 1, 2, 3})).isEqualTo(new int[]{2, 4, 200, -198, 2, 4, 6});
    }
}
