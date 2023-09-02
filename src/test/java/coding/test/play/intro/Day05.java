package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day05 {

    /**
     * 옷가게 할인 받기
     *
     * 문제 설명
     * 머쓱이네 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만 원 이상 사면 20%를 할인해줍니다.
     * 구매한 옷의 가격 price가 주어질 때, 지불해야 할 금액을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 10 ≤ price ≤ 1,000,000
     * price는 10원 단위로(1의 자리가 0) 주어집니다.
     * 소수점 이하를 버린 정수를 return합니다.
     */
    int solution_01(int price) {
        if (price >= 500_000) {
            return (int) (price * 0.8);
        } else if (price >= 300_000) {
            return (int) (price * 0.9);
        } else if (price >= 100_000) {
            return (int) (price * 0.95);
        } else {
            return price;
        }
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(150_000)).isEqualTo(142_500);
        Assertions.assertThat(solution_01(580_000)).isEqualTo(464_000);
    }

    /**
     * 아이스 아메리카노
     *
     * 문제 설명
     * 머쓱이는 추운 날에도 아이스 아메리카노만 마십니다. 아이스 아메리카노는 한잔에 5,500원입니다.
     * 머쓱이가 가지고 있는 돈 money가 매개변수로 주어질 때,
     * 머쓱이가 최대로 마실 수 있는 아메리카노의 잔 수와 남는 돈을 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 0 < money ≤ 1,000,000
     */
    int[] solution_02(int money) {
        return new int[] {money / 5_500, money % 5_500};
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(5_500)).isEqualTo(new int[]{1, 0});
        Assertions.assertThat(solution_02(15_000)).isEqualTo(new int []{2, 4000});
    }

    /**
     * 나이 출력
     *
     * 문제 설명
     * 머쓱이는 40살인 선생님이 몇 년도에 태어났는지 궁금해졌습니다.
     * 나이 age가 주어질 때, 2022년을 기준 출생 연도를 return 하는 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 0 < age ≤ 120
     * 나이는 태어난 연도에 1살이며 1년마다 1씩 증가합니다.
     */
    int solution_03(int age) {
        return 2022 - age + 1;
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(40)).isEqualTo(1983);
        Assertions.assertThat(solution_03(23)).isEqualTo(2000);
    }

    /**
     * 배열 뒤집기
     *
     * 문제 설명
     * 정수가 들어 있는 배열 num_list가 매개변수로 주어집니다.
     * num_list의 원소의 순서를 거꾸로 뒤집은 배열을 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ num_list의 길이 ≤ 1,000
     * 0 ≤ num_list의 원소 ≤ 1,000
     */
    int[] solution_04(int[] num_list) {
        // 원본 배열을 List로 변환
        List<Integer> list = Arrays.stream(num_list)
                .boxed()
                .collect(Collectors.toList());

        // List reverse
        Collections.reverse(list);

        // List를 원본 배열로 변환
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(new int[]{1, 2, 3, 4, 5})).isEqualTo(new int[]{5, 4, 3, 2, 1});
        Assertions.assertThat(solution_04(new int[]{1, 1, 1, 1, 1, 2})).isEqualTo(new int[]{2, 1, 1, 1, 1, 1});
        Assertions.assertThat(solution_04(new int[]{1, 0, 1, 1, 1, 3, 5})).isEqualTo(new int[]{5, 3, 1, 1, 1, 0, 1});
    }
}
