package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if(isValidSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또번호는 6자로 입력해야합니다.");
        }

        if(isDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또번호는 중복될 수 없습니다.");
        }
    }

    private boolean isValidSize(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }
}
