package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day22 {

    /**
     * 저주의 숫자 3
     *
     * 문제 설명
     * 3x 마을 사람들은 3을 저주의 숫자라고 생각하기 때문에 3의 배수와 숫자 3을 사용하지 않습니다.
     * 3x 마을 사람들의 숫자는 다음과 같습니다.
     *
     * 10진법	3x 마을에서 쓰는 숫자	10진법	3x 마을에서 쓰는 숫자
     * 1	1	6	8
     * 2	2	7	10
     * 3	4	8	11
     * 4	5	9	14
     * 5	7	10	16
     * 정수 n이 매개변수로 주어질 때, n을 3x 마을에서 사용하는 숫자로 바꿔 return하도록 solution 함수를 완성해주세요.
     */
    public int solution_01(int n) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer++;
            while (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                answer++;
            }
        }
        return answer;
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(15)).isEqualTo(25);
        Assertions.assertThat(solution_01(40)).isEqualTo(76);
    }

    /**
     * 평행 ★★★
     *
     * 문제 설명
     * 점 네 개의 좌표를 담은 이차원 배열  dots가 다음과 같이 매개변수로 주어집니다.
     *
     * [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
     * 주어진 네 개의 점을 두 개씩 이었을 때,
     * 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * dots의 길이 = 4
     * dots의 원소는 [x, y] 형태이며 x, y는 정수입니다.
     * 0 ≤ x, y ≤ 100
     * 서로 다른 두개 이상의 점이 겹치는 경우는 없습니다.
     * 두 직선이 겹치는 경우(일치하는 경우)에도 1을 return 해주세요.
     * 임의의 두 점을 이은 직선이 x축 또는 y축과 평행한 경우는 주어지지 않습니다.
     */
    public int solution_02(int[][] dots) {
        int x1 = dots[0][0];
        int y1 = dots[0][1];
        int x2 = dots[1][0];
        int y2 = dots[1][1];
        int x3 = dots[2][0];
        int y3 = dots[2][1];
        int x4 = dots[3][0];
        int y4 = dots[3][1];
        int answer = 0;

        double slope1 = (double) (y2 - y1) / (x2 - x1);
        double slope2 = (double) (y4 - y3) / (x4 - x3);
        if (slope1 == slope2) answer = 1;

        slope1 = (double) (y3 - y1) / (x3 - x1);
        slope2 = (double) (y2 - y4) / (x2 - x4);
        if (slope1 == slope2) answer = 1;

        slope1 = (double) (y4 - y1) / (x4 - x1);
        slope2 = (double) (y2 - y3) / (x2 - x3);
        if (slope1 == slope2) answer = 1;

        return answer;
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(new int[][]{new int[]{1,4},new int[]{9,2},new int[]{3,8},new int[]{11,6}})).isEqualTo(1);
        Assertions.assertThat(solution_02(new int[][]{new int[]{3,5},new int[]{4,1},new int[]{2,4},new int[]{5,10}})).isEqualTo(0);
    }

    /**
     * 겹치는 선분의 길이
     *
     * 문제 설명
     * 선분 3개가 평행하게 놓여 있습니다.
     * 세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로
     * 들어있는 2차원 배열 lines가 매개변수로 주어질 때,
     * 두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.
     *
     * lines가 [[0, 2], [-3, -1], [-2, 1]]일 때 그림으로 나타내면 다음과 같습니다.
     *
     * line_2.png
     *
     * 선분이 두 개 이상 겹친 곳은 [-2, -1], [0, 1]로 길이 2만큼 겹쳐있습니다.
     */
    public int solution_03(int[][] lines) {
        Set<Integer> answer = new HashSet<>();
        Set<Integer> range1 =  IntStream.range(lines[0][0],lines[0][1]).boxed().collect(Collectors.toSet());
        Set<Integer> range2 = IntStream.range(lines[1][0],lines[1][1]).boxed().collect(Collectors.toSet());
        Set<Integer> range3 = IntStream.range(lines[2][0],lines[2][1]).boxed().collect(Collectors.toSet());

        answer.addAll(findCommonCount(range1, range2));
        answer.addAll(findCommonCount(range1, range3));
        answer.addAll(findCommonCount(range2, range3));
        return answer.size();
    }

    public static Set<Integer> findCommonCount(Set<Integer> collection1, Set<Integer> collection2) {
        Set<Integer> target1 = new HashSet<>(collection1);
        target1.retainAll(collection2);
        return target1;
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(new int[][]{new int[]{0,1},new int[]{2,5},new int[]{3,9}})).isEqualTo(2);
        Assertions.assertThat(solution_03(new int[][]{new int[]{-1,1},new int[]{1,3},new int[]{3,9}})).isEqualTo(0);
        Assertions.assertThat(solution_03(new int[][]{new int[]{0,5},new int[]{3,9},new int[]{1,10}})).isEqualTo(8);
    }

    /**
     * 유한소수 판별하기
     *
     * 문제 설명
     * 소수점 아래 숫자가 계속되지 않고 유한개인 소수를 유한소수라고 합니다.
     * 분수를 소수로 고칠 때 유한소수로 나타낼 수 있는 분수인지 판별하려고 합니다.
     * 유한소수가 되기 위한 분수의 조건은 다음과 같습니다.
     *
     * 기약분수로 나타내었을 때, 분모의 소인수가 2와 5만 존재해야 합니다.
     * 두 정수 a와 b가 매개변수로 주어질 때, a/b가 유한소수이면 1을, 무한소수라면 2를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * a, b는 정수
     * 0 < a ≤ 1,000
     * 0 < b ≤ 1,000
     */
    public int solution_04(int a, int b) {
        // 최대 공약수 계산
        int gcdValue = gcd(a, b);
        if (gcdValue > 1) {
            b = b / gcdValue;
        }

        // 분모를 소인수분해하여 2와 5외의 다른 소인수가 있는지 확인
        while (b % 2 == 0) {
            b /= 2;
        }
        while (b % 5 == 0) {
            b /= 5;
        }

        // 소인수분해 후 분모가 1이라면, 그 분수는 유한소수
        return b != 1 ? 2 : b;
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
    void solution_04_test() {
        Assertions.assertThat(solution_04(7, 20)).isEqualTo(1);
        Assertions.assertThat(solution_04(11, 22)).isEqualTo(1);
        Assertions.assertThat(solution_04(12, 21)).isEqualTo(2);
    }
}
