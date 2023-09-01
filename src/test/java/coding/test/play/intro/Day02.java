package coding.test.play.intro;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

public class Day02 {

    /**
     * 두 수의 나눗셈
     *
     * 문제 설명
     * 정수 num1과 num2가 매개변수로 주어질 때,
     * num1을 num2로 나눈 값에 1,000을 곱한 후 정수 부분을 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 0 < num1 ≤ 100
     * 0 < num2 ≤ 100
     */
    int solution_01(int num1, int num2) {
        float result = ((float) num1 / (float) num2) * 1000;
        return (int)result;
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(3,2)).isEqualTo(1500);
        Assertions.assertThat(solution_01(7,3)).isEqualTo(2333);
        Assertions.assertThat(solution_01(1,16)).isEqualTo(62);
    }

    /**
     * 숫자 비교하기
     *
     * 문제 설명
     * 정수 num1과 num2가 매개변수로 주어집니다.
     * 두 수가 같으면 1 다르면 -1을 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 0 ≤ num1 ≤ 10,000
     * 0 ≤ num2 ≤ 10,000
     */

    int solution_02(int num1, int num2) {
        return num1 == num2 ? 1 : -1;
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(2,3)).isEqualTo(-1);
        Assertions.assertThat(solution_02(11,11)).isEqualTo(1);
        Assertions.assertThat(solution_02(7,99)).isEqualTo(-1);
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
    public int[] solution_03(int denum1, int num1, int denum2, int num2) {
        int[] answer;

        denum1 *= num2;
        denum2 *= num1;

        answer = new int[]{denum1 + denum2, num1 * num2};

        int greatest_common_divisor = GCD(answer[0], answer[1]);
        answer[0] /= greatest_common_divisor;
        answer[1] /= greatest_common_divisor;

        return answer;
    }
    public int GCD(int num1, int num2) {
        if (num1 % num2 == 0)
            return num2;
        return GCD(num2, num1 % num2);
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(1,2,3,4)).isEqualTo(new int[]{5,4});
        Assertions.assertThat(solution_03(9,2,1,3)).isEqualTo(new int[]{29,6});
    }

    /**
     * 배열 두배 만들기
     *
     * 문제 설명
     * 정수 배열 numbers가 매개변수로 주어집니다.
     * numbers의 각 원소에 두배한 원소를 가진 배열을 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * -10,000 ≤ numbers의 원소 ≤ 10,000
     * 1 ≤ numbers의 길이 ≤ 1,000
     */
    int[] solution_04(int[] numbers) {
        return Arrays.stream(numbers).map(n -> n * 2).toArray(); // 각 원소를 2배하여 새로운 배열 생성
    }

    @Test
    void solution_08_test() {
        Assertions.assertThat(solution_04(new int[]{1, 2, 3, 4, 5})).isEqualTo(new int[]{2, 4, 6, 8, 10});
        Assertions.assertThat(solution_04(new int[]{1, 2, 100, -99, 1, 2, 3})).isEqualTo(new int[]{2, 4, 200, -198, 2, 4, 6});
    }
}
