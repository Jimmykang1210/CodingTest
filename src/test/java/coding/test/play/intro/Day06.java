package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day06 {

    /**
     * 문자열 뒤집기
     *
     * 문제 설명
     * 문자열 my_string이 매개변수로 주어집니다.
     * my_string을 거꾸로 뒤집은 문자열을 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ my_string의 길이 ≤ 1,000
     */
    String solution_01(String my_string) {
        // String 문자열을 한글자씩 List<String>으로 변환
        List<String> list = Arrays.asList(my_string.split(""));

        // List reverse
        Collections.reverse(list);

        // List를 원본 String으로 변환
        return list.stream().collect(Collectors.joining());
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01("jaron")).isEqualTo("noraj");
        Assertions.assertThat(solution_01("bread")).isEqualTo("daerb");
    }

    /**
     * 직각삼각형 출력하기
     *
     * 문제 설명
     * "*"의 높이와 너비를 1이라고 했을 때, "*"을 이용해 직각 이등변 삼각형을 그리려고합니다.
     * 정수 n 이 주어지면 높이와 너비가 n 인 직각 이등변 삼각형을 출력하도록 코드를 작성해보세요.
     *
     * 제한사항
     * 1 ≤ n ≤ 10
     */
    int solution_02(int n) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        return n;
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(3)).isEqualTo(3);
        Assertions.assertThat(solution_02(5)).isEqualTo(5);
    }

    /**
     * 짝수 홀수 개수
     *
     * 문제 설명
     * 정수가 담긴 리스트 num_list가 주어질 때,
     * num_list의 원소 중 짝수와 홀수의 개수를 담은 배열을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 1 ≤ num_list의 길이 ≤ 100
     * 0 ≤ num_list의 원소 ≤ 1,000
     */
    int[] solution_03(int[] num_list) {
        int evenLength = (int) Arrays.stream(num_list).filter(n -> n % 2 == 0).count();
        int oddLength = (int) Arrays.stream(num_list).filter(n -> n % 2 != 0).count();
        return new int[] {evenLength, oddLength};
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(new int[] {1, 2, 3, 4, 5})).isEqualTo(new int[] {2, 3});
        Assertions.assertThat(solution_03(new int[] {1, 3, 5, 7})).isEqualTo(new int[] {0, 4});
    }

    /**
     * 문자 반복 출력하기
     *
     * 문제 설명
     * 문자열 my_string과 정수 n이 매개변수로 주어질 때,
     * my_string에 들어있는 각 문자를 n만큼 반복한 문자열을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 2 ≤ my_string 길이 ≤ 5
     * 2 ≤ n ≤ 10
     * "my_string"은 영어 대소문자로 이루어져 있습니다.
     */
    public String solution_04(String my_string, int n) {
        // String 문자열을 한글자씩 List<String>으로 변환
        List<String> list = Arrays.asList(my_string.split(""));
        StringBuilder sb = new StringBuilder();

        // 문자마다 * n번 진행
        for (String str: list) {
            sb.append(str.repeat(n));
        }

        // 문자열 합치기
        return sb.toString();
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04("hello",3)).isEqualTo("hhheeellllllooo");
    }
}
