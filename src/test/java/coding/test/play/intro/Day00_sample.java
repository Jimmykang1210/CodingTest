package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Day00_sample {

    /**
     * 문제
     */
    int solution_01(int num1, int num2) {
        return num1 == num2 ? 1 : 0;
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(2,2)).isEqualTo(1);
    }

    /**
     * 문제
     */
    int solution_02(int num1, int num2) {
        return num1 == num2 ? 1 : 0;
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(2,2)).isEqualTo(1);
    }

    /**
     * 문제
     */
    int solution_03(int num1, int num2) {
        return num1 == num2 ? 1 : 0;
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(2,2)).isEqualTo(1);
    }

    /**
     * 문제
     */
    int solution_04(int num1, int num2) {
        return num1 == num2 ? 1 : 0;
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(2,2)).isEqualTo(1);
    }
}
