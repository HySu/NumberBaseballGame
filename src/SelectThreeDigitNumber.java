import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SelectThreeDigitNumber {

    public void selectThreeDigitNumber(int[] computerNumbers){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("세 자리 숫자를 입력하세요: ");
            String input = sc.nextLine();

            // 입력 값 유효성 검사
            if (input.length() != 3 || !isValidInput(input)) {
                System.out.println("잘못된 입력입니다. 세 자리의 서로 다른 숫자를 입력하세요.");
                continue;
            }

            int[] playerNumbers = convertStringToIntArray(input);

            // 스트라이크, 볼, 아웃 계산
            int strike = calculateStrike(computerNumbers, playerNumbers);
            int ball = calculateBall(computerNumbers, playerNumbers);

            if(strike != 0 || ball != 0) {
                System.out.println("스트라이크: " + strike + ", 볼: " + ball);
            } else {
                System.out.println("아웃!");
            }

            if (strike == 3) {
                System.out.println("축하합니다! 정답입니다.");
                break;
            }
        }
    }

    // 입력 값 유효성 검사 메서드 (중복 검사)
    public boolean isValidInput(String input) {
        Set<Character> inputSet = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (inputSet.contains(ch)) {
                return false; // 중복된 값이 있을 경우 false
            }
            inputSet.add(ch);
        }
        return true;
    }

    // 문자열을 정수 배열로 변환하는 메서드
    public int[] convertStringToIntArray(String input) {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = input.charAt(i) - '0';
        }
        return numbers;
    }

    // 스트라이크 계산
    public int calculateStrike(int[] computerNumbers, int[] playerNumbers) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == playerNumbers[i]) {
                strike++;
            }
        }
        return strike;
    }

    // 볼 계산
    public int calculateBall(int[] computerNumbers, int[] playerNumbers) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && computerNumbers[i] == playerNumbers[j]) {
                    ball++;
                }
            }
        }
        return ball;
    }
}
