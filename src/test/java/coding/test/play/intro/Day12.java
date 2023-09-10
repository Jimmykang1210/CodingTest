package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day12 {

    /**
     * 모음 제거
     *
     * 문제 설명
     * 영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다.
     * 문자열 my_string이 매개변수로 주어질 때 모음을 제거한 문자열을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * my_string은 소문자와 공백으로 이루어져 있습니다.
     * 1 ≤ my_string의 길이 ≤ 1,000
     */
    public String solution_01(String my_string) {
        List<String> list = Arrays.asList("a","e","i","o","u");
        return Arrays.stream(my_string.split("")).filter(v -> !list.contains(v)).collect(Collectors.joining());

//================ 더 좋은 풀이
//        return myString.replaceAll("a|e|i|o|u", "");
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01("bus")).isEqualTo("bs");
        Assertions.assertThat(solution_01("nice to meet you")).isEqualTo("nc t mt y");
    }

    /**
     * 문자열 정렬하기 (1)
     *
     * 문제 설명
     * 문자열 my_string이 매개변수로 주어질 때,
     * my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 return 하도록 solution 함수를 작성해보세요.
     *
     * 제한사항
     * 1 ≤ my_string의 길이 ≤ 100
     * my_string에는 숫자가 한 개 이상 포함되어 있습니다.
     * my_string은 영어 소문자 또는 0부터 9까지의 숫자로 이루어져 있습니다. - - -
     */
    public int[] solution_02(String my_string) {
        return Arrays.stream(my_string.replaceAll("[a-z]", "").split(""))
                        .sorted()
                        .mapToInt(Integer::parseInt)
                        .toArray();
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02("hi12392")).isEqualTo(new int[]{1,2,2,3,9});
        Assertions.assertThat(solution_02("p2o4i8gj2")).isEqualTo(new int[]{2,2,4,8});
        Assertions.assertThat(solution_02("abcde0")).isEqualTo(new int[]{0});
    }

    /**
     * 숨어있는 숫자의 덧셈 (1)
     *
     * 문제 설명
     * 문자열 my_string이 매개변수로 주어집니다.
     * my_string안의 모든 자연수들의 합을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ my_string의 길이 ≤ 1,000
     * my_string은 소문자, 대문자 그리고 한자리 자연수로만 구성되어있습니다.
     */
    public int solution_03(String my_string) {
        return Arrays.stream(my_string.replaceAll("[a-z|A-Z]", "").split(""))
                        .mapToInt(Integer::parseInt)
                        .sum();
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03("aAb1B2cC34oOp")).isEqualTo(10);
        Assertions.assertThat(solution_03("1a2b3c4d123")).isEqualTo(16);
    }

    /**
     * 소인수분해 ★★
     *
     * 문제 설명
     * 소인수분해란 어떤 수를 소수들의 곱으로 표현하는 것입니다.
     * 예를 들어 12를 소인수 분해하면 2 * 2 * 3 으로 나타낼 수 있습니다. 따라서 12의 소인수는 2와 3입니다.
     * 자연수 n이 매개변수로 주어질 때 n의 소인수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 2 ≤ n ≤ 10,000
     */
    public int[] solution_04(int n) {
        List<Integer> list = new ArrayList<>();

        //자연수 n의 소인수를 구하기 위한 반복문
        for(int i = 2; i <= n; i++) {
            // 나누어 떨어지면 i는 소인수, 몫이 2이상인 경우도 있기 때문에 안 나눠질 때까지 나눠줌
            if(n % i == 0) {
                while(n % i == 0) {
                    n /= i;
                }
                //구한 소인수를 list에 넣어줌
                list.add(i);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(12)).isEqualTo(new int[]{2,3});
        Assertions.assertThat(solution_04(17)).isEqualTo(new int[]{17});
        Assertions.assertThat(solution_04(420)).isEqualTo(new int[]{2,3,5,7});
    }
}
