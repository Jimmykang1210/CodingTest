package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day15 {

    /**
     * 영어가 싫어요
     *
     * 문제 설명
     * 영어가 싫은 머쓱이는 영어로 표기되어있는 숫자를 수로 바꾸려고 합니다.
     * 문자열 numbers가 매개변수로 주어질 때, numbers를 정수로 바꿔 return 하도록 solution 함수를 완성해 주세요.
     *
     * 제한사항
     * numbers는 소문자로만 구성되어 있습니다.
     * numbers는 "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" 들이 공백 없이 조합되어 있습니다.
     * 1 ≤ numbers의 길이 ≤ 50
     * "zero"는 numbers의 맨 앞에 올 수 없습니다.
     */
    public long solution_01(String numbers) {
        String[] arr = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < arr.length; i++) {
            numbers = numbers.replaceAll(arr[i], String.valueOf(i));
        }
        return Long.parseLong(numbers);
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01("onetwothreefourfivesixseveneightnine")).isEqualTo(123456789);
        Assertions.assertThat(solution_01("onefourzerosixseven")).isEqualTo(14067);
    }

    /**
     * 인덱스 바꾸기
     *
     * 문제 설명
     * 문자열 my_string과 정수 num1, num2가 매개변수로 주어질 때,
     * my_string에서 인덱스 num1과 인덱스 num2에 해당하는 문자를 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 1 < my_string의 길이 < 100
     * 0 ≤ num1, num2 < my_string의 길이
     * my_string은 소문자로 이루어져 있습니다.
     * num1 ≠ num2
     */
    public String solution_02(String my_string, int num1, int num2) {
        String[] arr = my_string.split("");
        String temp = "";

        temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;

        // Collectors.swap(arr, num1, num2);

        return Arrays.stream(arr).collect(Collectors.joining());
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02("hello",1,2)).isEqualTo(	"hlelo");
        Assertions.assertThat(solution_02("I love you",3,6)).isEqualTo(	"I l veoyou");
    }

    /**
     * 한 번만 등장한 문자
     *
     * 문제 설명
     * 문자열 s가 매개변수로 주어집니다.
     * s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.
     * 한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.
     *
     * 제한사항
     * 0 < s의 길이 < 1,000
     * s는 소문자로만 이루어져 있습니다.
     */
    public String solution_03(String s) {
        String[] arr = s.split("");
        Arrays.sort(arr);

        Map<String, Long> frequencyMap = Arrays.stream(arr)
                                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return Arrays.stream(arr)
                .distinct()
                .filter(ch -> frequencyMap.get(ch) == 1)
                .collect(Collectors.joining());

        //================ 더 좋은 풀이
//        return Arrays.stream(s.split(""))
//                .collect(Collectors.groupingBy(s1 -> s1))
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue().size() <= 1)
//                .map(Map.Entry::getKey)
//                .sorted()
//                .collect(Collectors.joining());
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03("abcabcadc")).isEqualTo("d");
        Assertions.assertThat(solution_03("abdc")).isEqualTo("abcd");
        Assertions.assertThat(solution_03("hello")).isEqualTo("eho");
    }

    /**
     * 약수 구하기
     *
     * 문제 설명
     * 정수 n이 매개변수로 주어질 때,
     * n의 약수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ n ≤ 10,000
     */
    public int[] solution_04(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> n % i == 0)
                .toArray();
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(24)).isEqualTo(new int[]{1, 2, 3, 4, 6, 8, 12, 24});
        Assertions.assertThat(solution_04(29)).isEqualTo(new int[]{1, 29});
    }
}
