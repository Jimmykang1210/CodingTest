package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day24 {

    /**
     * 치킨 쿠폰 ★★
     *
     * 문제 설명
     * 프로그래머스 치킨은 치킨을 시켜먹으면 한 마리당 쿠폰을 한 장 발급합니다.
     * 쿠폰을 열 장 모으면 치킨을 한 마리 서비스로 받을 수 있고, 서비스 치킨에도 쿠폰이 발급됩니다.
     * 시켜먹은 치킨의 수 chicken이 매개변수로 주어질 때 받을 수 있는 최대 서비스 치킨의 수를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * chicken은 정수입니다.
     * 0 ≤ chicken ≤ 1,000,000
     */
    public int solution_01(int chicken) {
        int coupon = chicken;
        int service = 0;
        while (coupon >= 10) {
            service += coupon / 10;
            coupon = coupon % 10 + coupon / 10;
        }

        return service;
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(100)).isEqualTo(11);
        Assertions.assertThat(solution_01(1_081)).isEqualTo(120);
    }

    /**
     * 이진수 더하기 ★
     *
     * 문제 설명
     * 이진수를 의미하는 두 개의 문자열 bin1과 bin2가 매개변수로 주어질 때,
     * 두 이진수의 합을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * return 값은 이진수를 의미하는 문자열입니다.
     * 1 ≤ bin1, bin2의 길이 ≤ 10
     * bin1과 bin2는 0과 1로만 이루어져 있습니다.
     * bin1과 bin2는 "0"을 제외하고 0으로 시작하지 않습니다.
     */
    public String solution_02(String bin1, String bin2) {
        return Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2));
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02("10","11")).isEqualTo("101");
        Assertions.assertThat(solution_02("1001","1111")).isEqualTo("11000");
    }

    /**
     * A로 B 만들기
     *
     * 문제 설명
     * 문자열 before와 after가 매개변수로 주어질 때,
     * before의 순서를 바꾸어 after를 만들 수 있으면 1을,
     * 만들 수 없으면 0을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 0 < before의 길이 == after의 길이 < 1,000
     * before와 after는 모두 소문자로 이루어져 있습니다.
     */
    public int solution_03(String before, String after) {
        List<String> arr = Arrays.stream(after.split("")).collect(Collectors.toList());
        Arrays.stream(before.split("")).forEach(v -> {
            for (int i = 0; i < arr.size(); i++) {
                if (v.equals(arr.get(i))) {
                    arr.remove(v);
                    break;
                }
            }
        });

        return arr.isEmpty() ? 1 : 0;

        //================ 더 좋은 풀이
//        char[] a = before.toCharArray();
//        char[] b = after.toCharArray();
//        Arrays.sort(a);
//        Arrays.sort(b);
//
//        return new String(a).equals(new String(b)) ? 1 :0;
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03("olleh","hello")).isEqualTo(1);
        Assertions.assertThat(solution_03("allpe","apple")).isEqualTo(0);

    }

    /**
     * k의 개수
     *
     * 문제 설명
     * 1부터 13까지의 수에서, 1은 1, 10, 11, 12, 13 이렇게 총 6번 등장합니다.
     * 정수 i, j, k가 매개변수로 주어질 때, i부터 j까지 k가 몇 번 등장하는지 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ i < j ≤ 100,000
     * 0 ≤ k ≤ 9
     */
    public int solution_04(int i, int j, int k) {
        AtomicInteger answer = new AtomicInteger();
        IntStream.rangeClosed(i, j).forEach(v -> {
            String.valueOf(v).chars()
                    .filter(ch -> ch == String.valueOf(k).charAt(0))
                    .forEach(z -> answer.getAndIncrement());
        });
        return answer.get();
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(1,13,1)).isEqualTo(6);
        Assertions.assertThat(solution_04(10,50,5)).isEqualTo(5);
        Assertions.assertThat(solution_04(3,10,2)).isEqualTo(0);
    }
}
