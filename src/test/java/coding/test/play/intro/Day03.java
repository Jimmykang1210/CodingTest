package coding.test.play.intro;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Day03 {

    /**
     * 제한 사항을 validation 체크한다면 아래와 같이 쓸 수 있으나
     * 이미 데이터가 가려져서 들어오기 때문에 앞으로는 삭제함
     * 제한사항
     * 0 < array의 길이 < 100
     * 0 ≤ array의 원소 < 1000
     *
        int minLength = 0;
        int maxLength = 100;
        int minValue= 0;
        int maxValue = 1000;
        if (minLength < array.length && array.length < maxLength
                && Arrays.stream(array).allMatch(i -> i >= minValue && i < maxValue)) {
            return 문제풀이
        } else {
            return 0;
        }
    */


    /**
     * 나머지 구하기
     *
     * 문제 설명
     * 정수 num1, num2가 매개변수로 주어질 때, num1를 num2로 나눈 나머지를 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 0 < num1 ≤ 100
     * 0 < num2 ≤ 100
     */
    int solution_01(int num1, int num2) {
        return num1 % num2;
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(3,2)).isEqualTo(1);
        Assertions.assertThat(solution_01(10,5)).isEqualTo(0);
    }


    /**
     * 중앙값 구하기
     *
     * 문제 설명
     * 중앙값은 어떤 주어진 값들을 크기의 순서대로 정렬했을 때 가장 중앙에 위치하는 값을 의미합니다.
     * 예를 들어 1, 2, 7, 10, 11의 중앙값은 7입니다.
     * 정수 배열 array가 매개변수로 주어질 때, 중앙값을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * array의 길이는 홀수입니다.
     * 0 < array의 길이 < 100
     * -1,000 < array의 원소 < 1,000
     */
    int solution_02(int[] array) {
        Arrays.sort(array);
        int centerIndex = array.length / 2;
        return array[centerIndex];
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(new int[]{1, 2, 7, 10, 11})).isEqualTo(7);
        Assertions.assertThat(solution_02(new int[]{9,-1,0})).isEqualTo(0);
    }

    /**
     * 최빈값 구하기
     *
     * 문제 설명
     * 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
     * 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요.
     * 최빈값이 여러 개면 -1을 return 합니다.
     *
     * 제한사항
     * 0 < array의 길이 < 100
     * 0 ≤ array의 원소 < 1000
     */
    int solution_03(int[] array) {
        // array 정렬
        Arrays.sort(array);

        // 맵에 키별 카운트 입력
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        for (int key: array) {
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }

        // 카운트가 가장 높은 애들 리스트업
        int answer = 0;
        int sameCount = 0;
        int maxCount = hm.values().stream().max(Integer::compareTo).get();

        for( Map.Entry<Integer, Integer> entry : hm.entrySet() ){
            int key = entry.getKey();
            int value = entry.getValue();

            if(maxCount == value) {
                sameCount++;
                answer = key;
            }
        }

        // 하나일 경우 키 값 리턴, 여러개일 경우 -1 리턴
        return sameCount == 1 ? answer : -1;
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(new int[]{1, 2, 3, 3, 3, 4})).isEqualTo(3);
        Assertions.assertThat(solution_03(new int[]{1, 1, 2, 2})).isEqualTo(-1);
        Assertions.assertThat(solution_03(new int[]{1})).isEqualTo(1);
    }

    /**
     * 짝수는 싫어요
     *
     * 문제 설명
     * 정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return 하도록
     * solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ n ≤ 100
     */
    int[] solution_04(int n) {
        // 1부터 n까지의 숫자를 생성
        // 홀수 값 구해, 배열화
        return IntStream.rangeClosed(1, n)
                .filter(num -> num % 2 != 0)
                .toArray();
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(10)).isEqualTo(new int[]{1, 3, 5, 7, 9});
        Assertions.assertThat(solution_04(15)).isEqualTo(new int[]{1, 3, 5, 7, 9, 11, 13, 15});
    }
}
