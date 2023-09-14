package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day16 {

    /**
     * 편지
     *
     * 문제 설명
     * 머쓱이는 할머니께 생신 축하 편지를 쓰려고 합니다.
     * 할머니가 보시기 편하도록 글자 한 자 한 자를 가로 2cm 크기로 적으려고 하며, 편지를 가로로만 적을 때,
     * 축하 문구 message를 적기 위해 필요한 편지지의 최소 가로길이를 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 공백도 하나의 문자로 취급합니다.
     * 1 ≤ message의 길이 ≤ 50
     * 편지지의 여백은 생각하지 않습니다.
     * message는 영문 알파벳 대소문자, ‘!’, ‘~’ 또는 공백으로만 이루어져 있습니다.
     */
    public int solution_01(String message) {
        return message.length() * 2;
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01("happy birthday!")).isEqualTo(30);
        Assertions.assertThat(solution_01("I love you~")).isEqualTo(22);
    }

    /**
     * 가장 큰 수 찾기
     *
     * 문제 설명
     * 정수 배열 array가 매개변수로 주어질 때,
     * 가장 큰 수와 그 수의 인덱스를 담은 배열을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 1 ≤ array의 길이 ≤ 100
     * 0 ≤ array 원소 ≤ 1,000
     * array에 중복된 숫자는 없습니다.
     */
    public int[] solution_02(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        for (int i = 0; i < array.length; i++) {
            if (max == array[i]) {
                return new int[]{max, i};
            }
        }
        return new int[]{};

        //================ 더 좋은 풀이
//        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
//        int max = list.stream().max(Integer::compareTo).orElse(0);
//        int index = list.indexOf(max);
//        return new int[] {max, index};
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(new int[]{1, 8, 3})).isEqualTo(new int[]{8,1});
        Assertions.assertThat(solution_02(new int[]{9, 10, 11, 8})).isEqualTo(new int[]{11,2});
    }

    /**
     * 문자열 계산하기
     *
     * 문제 설명
     * my_string은 "3 + 5"처럼 문자열로 된 수식입니다.
     * 문자열 my_string이 매개변수로 주어질 때, 수식을 계산한 값을 return 하는 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 연산자는 +, -만 존재합니다.
     * 문자열의 시작과 끝에는 공백이 없습니다.
     * 0으로 시작하는 숫자는 주어지지 않습니다.
     * 잘못된 수식은 주어지지 않습니다.
     * 5 ≤ my_string의 길이 ≤ 100
     * my_string을 계산한 결과값은 1 이상 100,000 이하입니다.
     * my_string의 중간 계산 값은 -100,000 이상 100,000 이하입니다.
     * 계산에 사용하는 숫자는 1 이상 20,000 이하인 자연수입니다.
     * my_string에는 연산자가 적어도 하나 포함되어 있습니다.
     * return type 은 정수형입니다.
     * my_string의 숫자와 연산자는 공백 하나로 구분되어 있습니다.
     */
    public int solution_03(String my_string) {
        String[] arr = my_string.split(" ");
        int answer = Integer.parseInt(arr[0]);

        for (int i=1; i<arr.length-1; i++) {
            if (arr[i].equals("+")) {
                answer += Integer.parseInt(arr[i+1]);
            } else if (arr[i].equals("-")) {
                answer -= Integer.parseInt(arr[i+1]);
            }
        }
        return answer;

        //================ 더 좋은 풀이
//        return Arrays.stream(myString.replaceAll("- ", "-")
//                                    .replaceAll("[+] ", "")
//                                    .trim()
//                                    .split(" "))
//                    .mapToInt(Integer::parseInt)
//                    .sum();
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03("3 + 4")).isEqualTo(7);
    }

    /**
     * 배열의 유사도
     *
     * 문제 설명
     * 두 배열이 얼마나 유사한지 확인해보려고 합니다.
     * 문자열 배열 s1과 s2가 주어질 때 같은 원소의 개수를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ s1, s2의 길이 ≤ 100
     * 1 ≤ s1, s2의 원소의 길이 ≤ 10
     * s1과 s2의 원소는 알파벳 소문자로만 이루어져 있습니다
     * s1과 s2는 각각 중복된 원소를 갖지 않습니다.
     */
    public int solution_04(String[] s1, String[] s2) {
        int answer = 0;
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if(s1[i].equals(s2[j])) {
                    answer++;
                }
            }
        }
        return answer;

        //================ 더 좋은 풀이
//        Set<String> set = new HashSet<>(Arrays.asList(s1));
//        return (int)Arrays.stream(s2).filter(set::contains).count();
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(new String[]{"a", "b", "c"}, new String[]{"com", "b", "d", "p", "c"})).isEqualTo(2);
        Assertions.assertThat(solution_04(new String[]{"n", "omg"}, new String[]{"m", "dot"})).isEqualTo(0);
    }
}
