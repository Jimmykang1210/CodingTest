package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Day13 {

    /**
     * 문제 설명
     *
     * 숫자와 "Z"가 공백으로 구분되어 담긴 문자열이 주어집니다. 문자열에 있는 숫자를 차례대로 더하려고 합니다.
     * 이 때 "Z"가 나오면 바로 전에 더했던 숫자를 뺀다는 뜻입니다.
     * 숫자와 "Z"로 이루어진 문자열 s가 주어질 때, 머쓱이가 구한 값을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 1 ≤ s의 길이 ≤ 200
     * -1,000 < s의 원소 중 숫자 < 1,000
     * s는 숫자, "Z", 공백으로 이루어져 있습니다.
     * s에 있는 숫자와 "Z"는 서로 공백으로 구분됩니다.
     * 연속된 공백은 주어지지 않습니다.
     * 0을 제외하고는 0으로 시작하는 숫자는 없습니다.
     * s는 "Z"로 시작하지 않습니다.
     * s의 시작과 끝에는 공백이 없습니다.
     * "Z"가 연속해서 나오는 경우는 없습니다.
     */
    public int solution_01(String s) {
        int answer = 0;
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("Z")) {
                answer -= Integer.parseInt(arr[i-1]);
            } else {
                answer += Integer.parseInt(arr[i]);
            }
        }
        return answer;
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01("1 2 Z 3")).isEqualTo(4);
        Assertions.assertThat(solution_01("10 20 30 40")).isEqualTo(100);
        Assertions.assertThat(solution_01("10 Z 20 Z 1")).isEqualTo(1);
        Assertions.assertThat(solution_01("10 Z 20 Z")).isEqualTo(0);
        Assertions.assertThat(solution_01("-1 -2 -3 Z")).isEqualTo(-3);
    }

    /**
     * 배열 원소의 길이
     *
     * 문제 설명
     * 문자열 배열 strlist가 매개변수로 주어집니다.
     * strlist 각 원소의 길이를 담은 배열을 retrun하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ strlist 원소의 길이 ≤ 100
     * strlist는 알파벳 소문자, 대문자, 특수문자로 구성되어 있습니다.
     */
    public int[] solution_02(String[] strlist) {
        return Arrays.stream(strlist).mapToInt(v -> v.length()).toArray();
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(new String[]{"We","are","the","world!"})).isEqualTo(new int[]{2,3,3,6});
        Assertions.assertThat(solution_02(new String[]{"I","Love","Programmers."})).isEqualTo(new int[]{1,4,12});
    }

    /**
     * 중복된 문자 제거
     *
     * 문제 설명
     * 문자열 my_string이 매개변수로 주어집니다.
     * my_string에서 중복된 문자를 제거하고 하나의 문자만 남긴 문자열을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ my_string ≤ 110
     * my_string은 대문자, 소문자, 공백으로 구성되어 있습니다.
     * 대문자와 소문자를 구분합니다.
     * 공백(" ")도 하나의 문자로 구분합니다.
     * 중복된 문자 중 가장 앞에 있는 문자를 남깁니다.
     */
    public String solution_03(String my_string) {
        return Arrays.stream(my_string.split("")).distinct().collect(Collectors.joining());

//================ 더 좋은 풀이
//        return my_string.chars().mapToObj(Character::toString).distinct().collect(Collectors.joining());
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03("people")).isEqualTo("peol");
        Assertions.assertThat(solution_03("We are the world")).isEqualTo("We arthwold");
    }

    /**
     * 삼각형의 완성조건 (1)
     *
     * 문제 설명
     * 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
     *
     * 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
     * 삼각형의 세 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다.
     * 세 변으로 삼각형을 만들 수 있다면 1, 만들 수 없다면 2를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * sides의 원소는 자연수입니다.
     * sides의 길이는 3입니다.
     * 1 ≤ sides의 원소 ≤ 1,000
     */
    public int solution_04(int[] sides) {
//        Arrays.sort(sides);
        int[] arr = Arrays.stream(sides).sorted().toArray();
        return arr[2] < arr[0] + arr[1] ? 1 : 2;
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(new int[]{1,2,3})).isEqualTo(2);
        Assertions.assertThat(solution_04(new int[]{3,6,2})).isEqualTo(2);
        Assertions.assertThat(solution_04(new int[]{199,72,222})).isEqualTo(1);
    }
}
