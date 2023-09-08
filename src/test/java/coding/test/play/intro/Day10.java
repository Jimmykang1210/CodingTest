package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day10 {

    /**
     * 점의 위치 구하기
     *
     * 문제 설명
     * 사분면은 한 평면을 x축과 y축을 기준으로 나눈 네 부분입니다. 사분면은 아래와 같이 1부터 4까지 번호를매깁니다.
     *
     * x 좌표와 y 좌표가 모두 양수이면 제1사분면에 속합니다.
     * x 좌표가 음수, y 좌표가 양수이면 제2사분면에 속합니다.
     * x 좌표와 y 좌표가 모두 음수이면 제3사분면에 속합니다.
     * x 좌표가 양수, y 좌표가 음수이면 제4사분면에 속합니다.
     * x 좌표 (x, y)를 차례대로 담은 정수 배열 dot이 매개변수로 주어집니다.
     * 좌표 dot이 사분면 중 어디에 속하는지 1, 2, 3, 4 중 하나를 return 하도록 solution 함수를 완성해주세요.
     */
    public int solution_01(int[] dot) {
        if (dot[0] > 0 && dot[1] > 0) {
            return 1;
        } else if (dot[0] < 0 && dot[1] > 0) {
            return 2;
        } else if (dot[0] < 0 && dot[1] < 0) {
            return 3;
        } else {
            return 4;
        }
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(new int[]{2, 4})).isEqualTo(1);
        Assertions.assertThat(solution_01(new int[]{-7, 9})).isEqualTo(2);
    }

    /**
     * 2차원으로 만들기 ★★
     *
     * 문제 설명
     * 정수 배열 num_list와 정수 n이 매개변수로 주어집니다.
     * num_list를 다음 설명과 같이 2차원 배열로 바꿔 return하도록 solution 함수를 완성해주세요.
     *
     * num_list가 [1, 2, 3, 4, 5, 6, 7, 8] 로 길이가 8이고 n이 2이므로 num_list를 2 * 4 배열로 다음과 같이 변경합니다.
     * 2차원으로 바꿀 때에는 num_list의 원소들을 앞에서부터 n개씩 나눠 2차원 배열로 변경합니다.
     *
     * num_list             	| n	| result
     * [1, 2, 3, 4, 5, 6, 7, 8]	| 2	| [[1, 2], [3, 4], [5, 6], [7, 8]]
     *
     * 제한사항
     * num_list의 길이는 n의 배 수개입니다.
     * 0 ≤ num_list의 길이 ≤ 150
     * 2 ≤ n < num_list의 길이
     */
    public int[][] solution_02(int[] num_list, int n) {
        int len = num_list.length / n;
        int[][] answer = new int[len][n];
        
        for (int i = 0; i < num_list.length; i++) {
            answer[(i/n)][(i%n)] = num_list[i];
        }
        return answer;
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(new int[]{1,2,3,4,5,6,7,8},2)).isEqualTo(new int[][]{{1,2},{3,4},{5,6},{7,8}});
        Assertions.assertThat(solution_02(new int[]{100,95,2,4,5,6,18,33,948},3)).isEqualTo(new int[][]{{100,95,2},{4,5,6},{18,33,948}});
    }

    /**
     * 공 던지기
     *
     * 문제 설명
     * 머쓱이는 친구들과 동그랗게 서서 공 던지기 게임을 하고 있습니다.
     * 공은 1번부터 던지며 오른쪽으로 한 명을 건너뛰고 그다음 사람에게만 던질 수 있습니다.
     * 친구들의 번호가 들어있는 정수 배열 numbers와 정수 K가 주어질 때,
     * k번째로 공을 던지는 사람의 번호는 무엇인지 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 2 < numbers의 길이 < 100
     * 0 < k < 1,000
     * numbers의 첫 번째와 마지막 번호는 실제로 바로 옆에 있습니다.
     * numbers는 1부터 시작하며 번호는 순서대로 올라갑니다.
     */
    public int solution_03(int[] numbers, int k) {
        return numbers[(k - 1) * 2 % numbers.length];
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(new int[]{1,2,3,4},2)).isEqualTo(3);
        Assertions.assertThat(solution_03(new int[]{1,2,3,4,5,6},5)).isEqualTo(3);
        Assertions.assertThat(solution_03(new int[]{1,2,3},3)).isEqualTo(2);
    }

    /**
     * 배열 회전시키기
     *
     * 문제 설명
     * 정수가 담긴 배열 numbers와 문자열 direction가 매개변수로 주어집니다.
     * 배열 numbers의 원소를 direction방향으로 한 칸씩 회전시킨 배열을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 3 ≤ numbers의 길이 ≤ 20
     * direction은 "left" 와 "right" 둘 중 하나입니다.
     */
    public int[] solution_04(int[] numbers, String direction) {
        int len = numbers.length;
        int[] answer = new int[len];
        if (direction.equals("right")) {
            answer[0] = numbers[len-1];
            for (int i = 0; i < len-1; i++) {
                answer[i+1] = numbers[i];
            }
        } else {
            answer[len-1] = numbers[0];
            for (int i = 0; i < len-1; i++) {
                answer[i] = numbers[i+1];
            }
        }
        return answer;

//================ 더 좋은 풀이
//        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
//
//        if (direction.equals("right")) {
//            list.add(0, list.get(list.size() - 1));
//            list.remove(list.size() - 1);
//        } else {
//            list.add(list.size(), list.get(0));
//            list.remove(0);
//        }
//        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(new int[]{1,2,3},"right")).isEqualTo(new int[]{3,1,2});
        Assertions.assertThat(solution_04(new int[]{4,455,6,4,-1,45,6},"left")).isEqualTo(new int[]{455,6,4,-1,45,6,4});
    }
}
