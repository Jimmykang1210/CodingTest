package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Day11 {

    /**
     * 주사위의 개수
     *
     * 문제 설명
     * 머쓱이는 직육면체 모양의 상자를 하나 가지고 있는데 이 상자에 정육면체 모양의 주사위를 최대한 많이 채우고 싶습니다.
     * 상자의 가로, 세로, 높이가 저장되어있는 배열 box와 주사위 모서리의 길이 정수 n이 매개변수로 주어졌을 때,
     * 상자에 들어갈 수 있는 주사위의 최대 개수를 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * box의 길이는 3입니다.
     * box[0] = 상자의 가로 길이
     * box[1] = 상자의 세로 길이
     * box[2] = 상자의 높이 길이
     * 1 ≤ box의 원소 ≤ 100
     * 1 ≤ n ≤ 50
     * n ≤ box의 원소
     * 주사위는 상자와 평행하게 넣습니다.
     */
    public int solution_01(int[] box, int n) {
        return Arrays.stream(box)
                    .map(v -> (int) ((double) v / n))
                    .reduce(1, (a, b) -> a * b);
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(new int[]{1,1,1},1)).isEqualTo(1);
        Assertions.assertThat(solution_01(new int[]{10,8,6},3)).isEqualTo(12);
    }

    /**
     * 합성수 찾기
     *
     * 문제 설명
     * 약수의 개수가 세 개 이상인 수를 합성수라고 합니다.
     * 자연수 n이 매개변수로 주어질 때 n이하의 합성수의 개수를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ n ≤ 100
     */
    public int solution_02(int n) {
        return (int) IntStream.rangeClosed(1, n)
                .filter(m-> findDivisorsCount(m) >= 3)
                .count();
    }

    public static int findDivisorsCount(int n) {
        return (int) IntStream.rangeClosed(1, n)
                .filter(i -> n % i == 0)
                .count();
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(10)).isEqualTo(5);
        Assertions.assertThat(solution_02(15)).isEqualTo(8);
    }

    /**
     * 최댓값 만들기 (1)
     *
     * 문제 설명
     * 정수 배열 numbers가 매개변수로 주어집니다.
     * numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 0 ≤ numbers의 원소 ≤ 10,000
     * 2 ≤ numbers의 길이 ≤ 100
     */
    public int solution_03(int[] numbers) {
        // array 정렬
        Arrays.sort(numbers);

        // 최대값 두개로 곱셈
        return numbers[numbers.length-1] * numbers[numbers.length-2];
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(new int[]{1,2,3,4,5})).isEqualTo(20);
        Assertions.assertThat(solution_03(new int[]{0,31,24,10,1,9})).isEqualTo(744);
    }

    /**
     * 팩토리얼
     *
     * 문제 설명
     * i팩토리얼 (i!)은 1부터 i까지 정수의 곱을 의미합니다.
     * 예를들어 5! = 5 * 4 * 3 * 2 * 1 = 120 입니다.
     * 정수 n이 주어질 때 다음 조건을 만족하는 가장 큰 정수 i를 return 하도록 solution 함수를 완성해주세요.
     *
     * i! ≤ n
     * 제한사항
     * 0 < n ≤ 3,628,800
     */
    public int solution_04(int n) {
        int answer = 0;
        for (int i = 10; i > 0; i--) {
            answer = i;
            // n보다 작거나 같으면 해당값
            if (factorialIterative(i) <= n) {
                break;
            }
        }
        return answer;
    }

    public static int factorialIterative(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(3_628_800)).isEqualTo(10);
        Assertions.assertThat(solution_04(7)).isEqualTo(3);
    }
}
