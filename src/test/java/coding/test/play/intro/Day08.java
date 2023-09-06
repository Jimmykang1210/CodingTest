package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Day08 {

    /**
     * 배열 자르기
     *
     * 문제 설명
     * 정수 배열 numbers와 정수 num1, num2가 매개변수로 주어질 때,
     * numbers의 num1번 째 인덱스부터 num2번째 인덱스까지 자른 정수 배열을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 2 ≤ numbers의 길이 ≤ 30
     * 0 ≤ numbers의 원소 ≤ 1,000
     * 0 ≤num1 < num2 < numbers의 길이
     */
    int[] solution_01(int[] numbers, int num1, int num2) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = num1; i <= num2; i++) {
            list.add(numbers[i]);
        }
        return list.stream().mapToInt(i -> i).toArray();

        //================ 더 좋은 풀이
//        return Arrays.copyOfRange(numbers, num1, num2 + 1);
//        return Arrays.stream(numbers, num1, num2+1).toArray();
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(new int[]{1, 2, 3, 4, 5},1,3)).isEqualTo(new int[] {2,3,4});
        Assertions.assertThat(solution_01(new int[]{1, 3, 5},1,2)).isEqualTo(new int[] {3,5});
    }

    /**
     * 외계행성의 나이
     *
     * 문제 설명
     * 우주여행을 하던 머쓱이는 엔진 고장으로 PROGRAMMERS-962 행성에 불시착하게 됐습니다.
     * 입국심사에서 나이를 말해야 하는데, PROGRAMMERS-962 행성에서는 나이를 알파벳으로 말하고 있습니다.
     * a는 0, b는 1, c는 2, ..., j는 9입니다. 예를 들어 23살은 cd, 51살은 fb로 표현합니다.
     * 나이 age가 매개변수로 주어질 때 PROGRAMMER-962식 나이를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * age는 자연수입니다.
     * age ≤ 1,000
     * PROGRAMMERS-962 행성은 알파벳 소문자만 사용합니다.
     */
    String solution_02(int age) {
        // 숫자와 알파벳 매핑
        String [] arr = new String[]{"a","b","c","d","e","f","g","h","i","j"};
        List<String> list = new ArrayList<>();

        // age를 한글자씩 잘라 숫자와 알파벳 매핑
        String.valueOf(age)
                .chars()  // IntStream을 반환
                .map(Character::getNumericValue)  // 각 char 값을 해당하는 int로 변환
                .forEach(i -> {
                    list.add(arr[i]);
                });

        // 매핑된 데이터 결합
        return String.join("", list);
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(23)).isEqualTo("cd");
        Assertions.assertThat(solution_02(51)).isEqualTo("fb");
        Assertions.assertThat(solution_02(100)).isEqualTo("baa");
    }

    /**
     * 진료 순서 정하기 ★★
     * <p>
     * 문제 설명
     * 외과의사 머쓱이는 응급실에 온 환자의 응급도를 기준으로 진료 순서를 정하려고 합니다.
     * 정수 배열 emergency가 매개변수로 주어질 때 응급도가 높은 순서대로 진료 순서를 정한 배열을 return하도록 solution 함수를 완성해주세요.
     * <p>
     * 제한사항
     * 중복된 원소는 없습니다.
     * 1 ≤ emergency의 길이 ≤ 10
     * 1 ≤ emergency의 원소 ≤ 100
     */
    int[] solution_03(int[] emergency) {
        int[] answer = new int[emergency.length];

        //배열 값 비교, 자신보다 응급도가 높은 값이 있으면 순서 배열에 +1해줌
        for(int i = 0; i < emergency.length; i ++) {
            for(int j = 0; j < emergency.length; j++) {
                if(emergency[i] < emergency[j]) {
                    answer[i]++;
                }
            }
            /*순서 배열의 모든 값에 +1해줌
            (순서를 나타내야 하기 때문에 0이 아닌 1부터 하기 위함)*/
            answer[i]++;
        }
        return answer; //순서를 나타낸 배열 return

        //================ 더 좋은 풀이
//        return Arrays.stream(e)
//                    .map(i -> Arrays.stream(e)
//                                    .boxed()
//                                    .sorted(Comparator.reverseOrder())
//                                    .collect(Collectors.toList())
//                                    .indexOf(i) + 1)
//                                    .toArray();
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(new int[]{3, 76, 24})).isEqualTo(new int[] {3,1,2});
        Assertions.assertThat(solution_03(new int[]{1, 2, 3, 4, 5, 6, 7})).isEqualTo(new int[] {7, 6, 5, 4, 3, 2, 1});
        Assertions.assertThat(solution_03(new int[]{30, 10, 23, 6, 100})).isEqualTo(new int[] {2, 4, 3, 5, 1});
    }

    /**
     * 순서쌍의 개수
     *
     * 문제 설명
     * 순서쌍이란 두 개의 숫자를 순서를 정하여 짝지어 나타낸 쌍으로 (a, b)로 표기합니다.
     * 자연수 n이 매개변수로 주어질 때 두 숫자의 곱이 n인 자연수 순서쌍의 개수를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ n ≤ 1,000,000
     */
    int solution_04(int n) {
        return (int) IntStream.rangeClosed(1, n).filter(k -> n % k == 0).count();
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(20)).isEqualTo(6);
        Assertions.assertThat(solution_04(100)).isEqualTo(9);
    }
}
