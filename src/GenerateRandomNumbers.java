import java.util.HashSet;
import java.util.Set;

public class GenerateRandomNumbers {
    // 세 자리 랜덤 숫자 생성 메서드 (중복되지 않도록)
    public int[] generateRandomNumbers() {
        Set<Integer> numberSet = new HashSet<>();
        int[] numbers = new int[3];
        int index = 0;

        while (numberSet.size() < 3) {
            int randomNumber = (int) (Math.random() * 9) + 1; // 1~9까지 숫자 생성
            if (!numberSet.contains(randomNumber)) {
                numberSet.add(randomNumber);
                numbers[index++] = randomNumber;
            }
        }
        return numbers;
    }
}
