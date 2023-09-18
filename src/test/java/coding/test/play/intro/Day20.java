package coding.test.play.intro;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Day20 {

    /**
     * 직사각형 넓이 구하기 ★★
     *
     * 문제 설명
     * 2차원 좌표 평면에 변이 축과 평행한 직사각형이 있습니다.
     * 직사각형 네 꼭짓점의 좌표 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]가 담겨있는 배열 dots가 매개변수로 주어질 때,
     * 직사각형의 넓이를 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * dots의 길이 = 4
     * dots의 원소의 길이 = 2
     * -256 < dots[i]의 원소 < 256
     * 잘못된 입력은 주어지지 않습니다.
     */
    public int solution_01(int[][] dots) {
        // x좌표의 최소&최대값, y좌표의 최소&최대값
        int minX = dots[0][0];
        int minY = dots[0][1];
        int maxX = dots[0][0];
        int maxY = dots[0][1];

        for(int i = 1; i < dots.length; i++) {
            minX = Math.min(minX, dots[i][0]);
            minY = Math.min(minY, dots[i][1]);
            maxX = Math.max(maxX, dots[i][0]);
            maxY = Math.max(maxY, dots[i][1]);
        }

        //직사각형의 넓이는 가로x세로
        return (maxX - minX) * (maxY - minY);
    }

    @Test
    void solution_01_test() {
        Assertions.assertThat(solution_01(new int[][]{new int[]{1, 1},new int[] {2,1},new int[] {2,2},new int[] {1,2}})).isEqualTo(1);
        Assertions.assertThat(solution_01(new int[][]{new int[]{-1,-1},new int[] {1,1},new int[] {1,-1},new int[] {-1,1}})).isEqualTo(4);
    }

    /**
     * 캐릭터의 좌표
     *
     * 문제 설명
     * 머쓱이는 RPG게임을 하고 있습니다. 게임에는 up, down, left, right 방향키가 있으며
     * 각 키를 누르면 위, 아래, 왼쪽, 오른쪽으로 한 칸씩 이동합니다. 예를 들어 [0,0]에서 up을 누른다면
     * 캐릭터의 좌표는 [0, 1], down을 누른다면 [0, -1], left를 누른다면 [-1, 0], right를 누른다면 [1, 0]입니다.
     * 머쓱이가 입력한 방향키의 배열 keyinput와 맵의 크기 board이 매개변수로 주어집니다.
     * 캐릭터는 항상 [0,0]에서 시작할 때 키 입력이 모두 끝난 뒤에 캐릭터의 좌표 [x, y]를
     * return하도록 solution 함수를 완성해주세요.
     *
     * [0, 0]은 board의 정 중앙에 위치합니다. 예를 들어 board의 가로 크기가 9라면 캐릭터는
     * 왼쪽으로 최대 [-4, 0]까지 오른쪽으로 최대 [4, 0]까지 이동할 수 있습니다.
     *
     * 제한사항
     * board은 [가로 크기, 세로 크기] 형태로 주어집니다.
     * board의 가로 크기와 세로 크기는 홀수입니다.
     * board의 크기를 벗어난 방향키 입력은 무시합니다.
     * 0 ≤ keyinput의 길이 ≤ 50
     * 1 ≤ board[0] ≤ 99
     * 1 ≤ board[1] ≤ 99
     * keyinput은 항상 up, down, left, right만 주어집니다.
     */
    public int[] solution_02(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < keyinput.length; i++){
            if(keyinput[i].equals("left")) x -= x>-(board[0]/2)?1:0;
            else if(keyinput[i].equals("right")) x += x<(board[0]/2)?1:0;
            else if(keyinput[i].equals("down")) y -= y>-(board[1]/2)?1:0;
            else if(keyinput[i].equals("up")) y += y<(board[1]/2)?1:0;
        }

        return new int[] {x, y};
    }

    @Test
    void solution_02_test() {
        Assertions.assertThat(solution_02(new String[]{"left","right","up","right","right"},new int[]{11,11})).isEqualTo(new int[]{2,1});
        Assertions.assertThat(solution_02(new String[]{"down","down","down","down","down"},new int[]{7,9})).isEqualTo(new int[]{0,-4});
    }

    /**
     * 최댓값 만들기 (2)
     *
     * 문제 설명
     * 정수 배열 numbers가 매개변수로 주어집니다.
     * numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * -10,000 ≤ numbers의 원소 ≤ 10,000
     * 2 ≤ numbers 의 길이 ≤ 100
     */
    public int solution_03(int[] numbers) {
        int maxIndex = numbers.length-1;
        int[] arr = Arrays.stream(numbers).sorted().toArray();
        return (arr[0] * arr[1]) > (arr[maxIndex] * arr[maxIndex-1])
                    ? arr[0] * arr[1]
                    : arr[maxIndex] * arr[maxIndex-1];

        //================ 더 좋은 풀이
//        return Math.max(numbers[0] * numbers[1], numbers[maxIndex-1] * numbers[maxIndex]);
    }

    @Test
    void solution_03_test() {
        Assertions.assertThat(solution_03(new int[]{1,2,-3,4,-5})).isEqualTo(15);
        Assertions.assertThat(solution_03(new int[]{0,-31,24,10,1,9})).isEqualTo(240);
        Assertions.assertThat(solution_03(new int[]{10,20,30,5,5,20,5})).isEqualTo(600);
    }

    /**
     * 다항식 더하기
     *
     * 문제 설명
     * 한 개 이상의 항의 합으로 이루어진 식을 다항식이라고 합니다.
     * 다항식을 계산할 때는 동류항끼리 계산해 정리합니다.
     * 덧셈으로 이루어진 다항식 polynomial이 매개변수로 주어질 때,
     * 동류항끼리 더한 결괏값을 문자열로 return 하도록 solution 함수를 완성해보세요.
     * 같은 식이라면 가장 짧은 수식을 return 합니다.
     *
     * 제한사항
     * 0 < polynomial에 있는 수 < 100
     * polynomial에 변수는 'x'만 존재합니다.
     * polynomial은 양의 정수, 공백, ‘x’, ‘+'로 이루어져 있습니다.
     * 항과 연산기호 사이에는 항상 공백이 존재합니다.
     * 공백은 연속되지 않으며 시작이나 끝에는 공백이 없습니다.
     * 하나의 항에서 변수가 숫자 앞에 오는 경우는 없습니다.
     * " + 3xx + + x7 + "와 같은 잘못된 입력은 주어지지 않습니다.
     * 0으로 시작하는 수는 없습니다.
     * 문자와 숫자 사이의 곱하기는 생략합니다.
     * polynomial에는 일차 항과 상수항만 존재합니다.
     * 계수 1은 생략합니다.
     * 결괏값에 상수항은 마지막에 둡니다.
     * 0 < polynomial의 길이 < 50
     */
    public String solution_04(String polynomial) {
        StringBuilder answer = new StringBuilder();
        int coefficient = 0;
        int constant = 0;
        String[] arr = polynomial.split(" ");

        for (int i = 0; i < arr.length; i+=2) {
            if (arr[i].contains("x")) {
                String xVal = arr[i].replace("x","");
                xVal = xVal.equals("") ? "1" : xVal;
                coefficient += Integer.parseInt(xVal);
            } else {
                constant += Integer.parseInt(arr[i]);
            }
        }

        if (coefficient == 1) {
            answer.append("x");
        } else if (coefficient != 0) {
            answer.append(coefficient).append("x");
        }

        if (coefficient != 0 && constant != 0) {
            answer.append(" ").append("+").append(" ");
        }

        if (constant != 0) {
            answer.append(constant);
        }
        return  answer.toString();

//================ 더 좋은 풀이
//        int xCount = 0;
//        int num = 0;
//
//        for (String s : polynomial.split(" ")) {
//            if (s.contains("x")) {
//                xCount += s.equals("x") ? 1 : Integer.parseInt(s.replaceAll("x", ""));
//            } else if (!s.equals("+")) {
//                num += Integer.parseInt(s);
//            }
//        }
//        return (xCount != 0 ? xCount > 1 ? xCount + "x" : "x" : "") + (num != 0 ? (xCount != 0 ? " + " : "") + num : xCount == 0 ? "0" : "");
    }

    @Test
    void solution_04_test() {
        Assertions.assertThat(solution_04("3x + 7 + x")).isEqualTo("4x + 7");
        Assertions.assertThat(solution_04("x + x + x")).isEqualTo("3x");
        Assertions.assertThat(solution_04("3 + 4 + 3")).isEqualTo("10");
    }
}
