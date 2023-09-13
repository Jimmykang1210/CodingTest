package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day14 {

    /**
     * 가까운 수 ★★
     *
     * 문제 설명
     * 정수 배열 array와 정수 n이 매개변수로 주어질 때,
     * array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ array의 길이 ≤ 100
     * 1 ≤ array의 원소 ≤ 100
     * 1 ≤ n ≤ 100
     * 가장 가까운 수가 여러 개일 경우 더 작은 수를 return 합니다.
     */
    public int solution_01(int[] array, int n) {
        int answer = 100;
        for(int num : array){
            int diff = num - n;
            if(Math.abs(diff) < Math.abs(answer)){
                answer = diff;
            }else if(Math.abs(diff) == Math.abs(answer) && diff < answer){
                answer = diff;
            }
        }
        answer = n + answer;
        return answer;
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(new int[]{3,10,28},20)).isEqualTo(28);
        Assertions.assertThat(solution_01(new int[]{10,11,12},13)).isEqualTo(12);
    }

    /**
     * 369게임
     *
     * 문제 설명
     * 머쓱이는 친구들과 369게임을 하고 있습니다.
     * 369게임은 1부터 숫자를 하나씩 대며 3, 6, 9가 들어가는 숫자는 숫자 대신 3, 6, 9의 개수만큼 박수를 치는 게임입니다.
     * 머쓱이가 말해야하는 숫자 order가 매개변수로 주어질 때, 머쓱이가 쳐야할 박수 횟수를 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 1 ≤ order ≤ 1,000,000
     */
    public int solution_02(int order) {
        return (int) String.valueOf(order).chars()
                .mapToObj(c -> (char) c)
                .filter(v -> v.equals('3') || v.equals('6') || v.equals('9'))
                .count();
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(3)).isEqualTo(1);
        Assertions.assertThat(solution_02(29423)).isEqualTo(2);
    }

    /**
     * 암호 해독
     *
     * 문제 설명
     * 군 전략가 머쓱이는 전쟁 중 적군이 다음과 같은 암호 체계를 사용한다는 것을 알아냈습니다.
     *
     * 암호화된 문자열 cipher를 주고받습니다.
     * 그 문자열에서 code의 배수 번째 글자만 진짜 암호입니다.
     * 문자열 cipher와 정수 code가 매개변수로 주어질 때 해독된 암호 문자열을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ cipher의 길이 ≤ 1,000
     * 1 ≤ code ≤ cipher의 길이
     * cipher는 소문자와 공백으로만 구성되어 있습니다.
     * 공백도 하나의 문자로 취급합니다.
     */
    public String solution_03(String cipher, int code) {
        AtomicInteger cnt = new AtomicInteger();
        return cipher.chars().mapToObj(Character::toString).filter(v -> {
                                cnt.getAndIncrement();
                                return (cnt.get() % code == 0) ? true : false;
                            }).collect(Collectors.joining());

//================ 더 좋은 풀이
//        String answer = "";
//        for(int i=code-1; i<cipher.length(); i+=code){
//            answer += cipher.substring(i, i+1);
//        }
//        return answer;
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03("dfjardstddetckdaccccdegk",4)).isEqualTo("attack");
        Assertions.assertThat(solution_03("pfqallllabwaoclk",2)).isEqualTo("fallback");
    }

    /**
     * 대문자와 소문자
     *
     * 문제 설명
     * 문자열 my_string이 매개변수로 주어질 때,
     * 대문자는 소문자로 소문자는 대문자로 변환한 문자열을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ my_string의 길이 ≤ 1,000
     * my_string은 영어 대문자와 소문자로만 구성되어 있습니다.
     */
    public String solution_04(String my_string) {
        return Arrays.asList(my_string.split("")).stream()
                    .map(v -> Pattern.matches("[a-z]+", v) ? v.toUpperCase() : v.toLowerCase())
                    .collect(Collectors.joining());
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04("cccCCC")).isEqualTo("CCCccc");
        Assertions.assertThat(solution_04("abCdEfghIJ")).isEqualTo("ABcDeFGHij");
    }
}
