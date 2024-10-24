import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberBaseballGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GenerateRandomNumbers grn = new GenerateRandomNumbers();
        SelectThreeDigitNumber stdn = new SelectThreeDigitNumber();
        int selectMenu;
        int[] computerNumbers;

        while(true) {
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            selectMenu = scanner.nextInt();

            if (selectMenu == 1) {
                // 세 자리 랜덤 숫자 생성
                computerNumbers = grn.generateRandomNumbers();
                System.out.println("컴퓨터가 숫자를 선택했습니다. 게임을 시작하세요!");
                stdn.selectThreeDigitNumber(computerNumbers);
            } else if (selectMenu == 2){
                // 게임 기록 보기
                System.out.println("게임 기록 보기");
            } else if (selectMenu == 3) {
                // 숫자야구게임 종료
                System.out.println("숫자야구게임을 종료합니다.");
                scanner.close();
                break;
            }
        }
    }
}