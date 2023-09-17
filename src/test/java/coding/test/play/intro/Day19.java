package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day19 {

    /**
     * 7의 개수
     *
     * 문제 설명
     * 머쓱이는 행운의 숫자 7을 가장 좋아합니다.
     * 정수 배열 array가 매개변수로 주어질 때,
     * 7이 총 몇 개 있는지 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 1 ≤ array의 길이 ≤ 100
     * 0 ≤ array의 원소 ≤ 100,000
     */
    public int solution_01(int[] array) {
        return Arrays.stream(array).mapToObj(String::valueOf)
                .mapToInt(val -> ((int) val.chars().filter(c -> c == '7').count()))
                .sum();

//================ 더 좋은 풀이
//        return (int) Arrays.stream(
//                        Arrays.stream(array)
//                                .mapToObj(String::valueOf)
//                                .collect(Collectors.joining())
//                                .split("")
//                )
//                .filter(s -> s.equals("7"))
//                .count();
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(new int[]{7,77,17})).isEqualTo(4);
        Assertions.assertThat(solution_01(new int[]{10,29})).isEqualTo(0);
    }

    /**
     * 잘라서 배열로 저장하기
     *
     * 문제 설명
     * 문자열 my_str과 n이 매개변수로 주어질 때,
     * my_str을 길이 n씩 잘라서 저장한 배열을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ my_str의 길이 ≤ 100
     * 1 ≤ n ≤ my_str의 길이
     * my_str은 알파벳 소문자, 대문자, 숫자로 이루어져 있습니다.
     */
    public String[] solution_02(String my_str, int n) {
        List<String> list = new ArrayList<>();
        int arrLen = my_str.length() % n == 0 ? my_str.length() / n : (my_str.length() / n) + 1;
        for (int i = 0; i < arrLen; i++) {
            int endIndex = my_str.length() > (i+1) * n ? (i+1) * n : my_str.length();
            list.add(my_str.substring(i*n, endIndex));
        }
        return list.toArray(new String[0]);
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02("abc1Addfggg4556b",6)).isEqualTo(new String[]{"abc1Ad","dfggg4","556b"});
        Assertions.assertThat(solution_02("abcdef123",3)).isEqualTo(new String[]{"abc","def","123"});
    }

    /**
     * 중복된 숫자 개수
     *
     * 문제 설명
     * 정수가 담긴 배열 array와 정수 n이 매개변수로 주어질 때,
     * array에 n이 몇 개 있는 지를 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 1 ≤ array의 길이 ≤ 100
     * 0 ≤ array의 원소 ≤ 1,000
     * 0 ≤ n ≤ 1,000
     */
    public int solution_03(int[] array, int n) {
        return (int) Arrays.stream(array)
                            .filter(v -> v == n)
                            .count();
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(new int[]{1, 1, 2, 3, 4, 5},1)).isEqualTo(2);
        Assertions.assertThat(solution_03(new int[]{0, 2, 3, 4},1)).isEqualTo(0);
    }

    /**
     * 머쓱이보다 키 큰 사람
     * 문제 설명
     * 머쓱이는 학교에서 키 순으로 줄을 설 때 몇 번째로 서야 하는지 궁금해졌습니다.
     * 머쓱이네 반 친구들의 키가 담긴 정수 배열 array와 머쓱이의 키 height가 매개변수로 주어질 때,
     * 머쓱이보다 키 큰 사람 수를 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 1 ≤ array의 길이 ≤ 100
     * 1 ≤ height ≤ 200
     * 1 ≤ array의 원소 ≤ 200
     */
    public int solution_04(int[] array, int height) {
        return (int) Arrays.stream(array)
                .filter(v -> v > height)
                .count();
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(new int[]{149, 180, 192, 170}, 167)).isEqualTo(3);
        Assertions.assertThat(solution_04(new int[]{180, 120, 140}, 190)).isEqualTo(0);
    }
}
