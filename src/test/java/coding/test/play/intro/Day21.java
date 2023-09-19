package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Day21 {

    /**
     * 숨어있는 숫자의 덧셈 (2)
     *
     * 문제 설명
     * 문자열 my_string이 매개변수로 주어집니다.
     * my_string은 소문자, 대문자, 자연수로만 구성되어있습니다.
     * my_string안의 자연수들의 합을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ my_string의 길이 ≤ 1,000
     * 1 ≤ my_string 안의 자연수 ≤ 1000
     * 연속된 수는 하나의 숫자로 간주합니다.
     * 000123과 같이 0이 선행하는 경우는 없습니다.
     * 문자열에 자연수가 없는 경우 0을 return 해주세요.
     */
    public int solution_01(String my_string) {
        return Arrays.stream(my_string.replaceAll("[^0-9]+", " ")
                        .trim()
                        .split(" "))
                        .filter(v -> !v.equals(""))
                        .mapToInt(v -> Integer.parseInt(v)).sum();
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01("aAb1B2cC34oOp")).isEqualTo(37);
        Assertions.assertThat(solution_01("1a2b3c4d123Z")).isEqualTo(133);
        Assertions.assertThat(solution_01("aaaaa")).isEqualTo(0);
    }

    /**
     * 안전지대
     *
     * 문제 설명
     * 다음 그림과 같이 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
     *
     * https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/124a2c93-da99-4643-96a8-292bb871f553/image.png
     *
     * 지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
     * 지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * board는 n * n 배열입니다.
     * 1 ≤ n ≤ 100
     * 지뢰는 1로 표시되어 있습니다.
     * board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.
     */
    public int solution_02(int[][] board) {
        int len = board.length;
        boolean[][] result = new boolean[len][len];
        for (boolean[] row : result) {
            Arrays.fill(row, true);
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == 1) {

                    result[i][j] = false;

                    if (j >= 1) {
                        result[i][j-1] = false;
                        if (i >= 1) {
                            result[i-1][j-1] = false;
                        }
                        if (i < len-1) {
                            result[i+1][j-1] = false;
                        }
                    }
                    if (j < len-1) {
                        result[i][j+1] = false;
                        if (i >= 1) {
                            result[i-1][j+1] = false;
                        }
                        if (i < len-1) {
                            result[i+1][j+1] = false;
                        }
                    }
                    if (i >= 1) {
                        result[i-1][j] = false;
                    }
                    if (i < len-1) {
                        result[i+1][j] = false;
                    }
                }
            }

        }

        return (int) Arrays.stream(result)
                .flatMapToLong(row -> IntStream.range(0, row.length).filter(i -> row[i]).mapToLong(i -> 1))
                .sum();
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(new int[][]{new int[]{0,0,0,0,0},new int[]{0,0,0,0,0},new int[]{0,0,0,0,0},new int[]{0,0,1,0,0},new int[]{0,0,0,0,0}})).isEqualTo(16);
        Assertions.assertThat(solution_02(new int[][]{new int[]{0,0,0,0,0},new int[]{0,0,0,0,0},new int[]{0,0,0,0,0},new int[]{0,0,1,1,0},new int[]{0,0,0,0,0}})).isEqualTo(13);
        Assertions.assertThat(solution_02(new int[][]{new int[]{1,1,1,1,1},new int[]{1,1,1,1,1},new int[]{1,1,1,1,1},new int[]{1,1,1,1,1},new int[]{1,1,1,1,1}})).isEqualTo(0);
    }

    /**
     * 삼각형의 완성조건 (2)
     *
     * 문제 설명
     * 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
     *
     * 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
     * 삼각형의 두 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다.
     * 나머지 한 변이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * sides의 원소는 자연수입니다.
     * sides의 길이는 2입니다.
     * 1 ≤ sides의 원소 ≤ 1,000
     */
    public int solution_03(int[] sides) {
        int max = Math.max(sides[0], sides[1]);
        int min = max - Math.min(sides[0], sides[1]);
        int low = Math.min(sides[0], sides[1]);

        // case. max가 가장 긴 경우와 다른 한변이 가장 긴 경우
        return (int) (IntStream.rangeClosed(min+1, max).count() + IntStream.range(max+1, (low+max)).count());

//================ 더 좋은 풀이
//        int max = Math.max(sides[0], sides[1]);
//        int min = Math.min(sides[0], sides[1]);
//        answer += min * 2 - 1;

    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(new int[]{1,2})).isEqualTo(1);
        Assertions.assertThat(solution_03(new int[]{3,6})).isEqualTo(5);
        Assertions.assertThat(solution_03(new int[]{11,7})).isEqualTo(13);
    }

    /**
     * 외계어 사전
     *
     * 문제 설명
     * PROGRAMMERS-962 행성에 불시착한 우주비행사 머쓱이는 외계행성의 언어를 공부하려고 합니다.
     * 알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다.
     * spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1,
     * 존재하지 않는다면 2를 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * spell과 dic의 원소는 알파벳 소문자로만 이루어져있습니다.
     * 2 ≤ spell의 크기 ≤ 10
     * spell의 원소의 길이는 1입니다.
     * 1 ≤ dic의 크기 ≤ 10
     * 1 ≤ dic의 원소의 길이 ≤ 10
     * spell의 원소를 모두 사용해 단어를 만들어야 합니다.
     * spell의 원소를 모두 사용해 만들 수 있는 단어는 dic에 두 개 이상 존재하지 않습니다.
     * dic과 spell 모두 중복된 원소를 갖지 않습니다.
     */
    public int solution_04(String[] spell, String[] dic) {
        int answer = (int) Arrays.stream(dic)
                .filter(v -> Arrays.stream(spell).allMatch(v::contains))
                .count();

        return answer == 0 ? 2 : 1;
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04(new String[]{"p","o","s"}, new String[]{"sod", "eocd", "qixm", "adio", "soo"})).isEqualTo(2);
        Assertions.assertThat(solution_04(new String[]{"z","d","x"}, new String[]{"def", "dww", "dzx", "loveaw"})).isEqualTo(1);
        Assertions.assertThat(solution_04(new String[]{"s","o","m","d"}, new String[]{"moos","dzx","smm","sunmmo","som"})).isEqualTo(2);
    }
}
