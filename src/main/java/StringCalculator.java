import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class StringCalculator {

    public int add(String numbers) throws Exception {
        if (!numbers.isEmpty()) {
            String delimiter = ",";
            String actualInput = numbers;

            if (numbers.startsWith("//")) {
                delimiter = numbers.substring(2,3);
                actualInput = actualInput.substring(3 + delimiter.length());
            }

            String[] refactoredList = actualInput.replace("\n", delimiter).split(delimiter);

            List<String> negativeNumbers = Arrays
                     .stream(refactoredList)
                     .filter(number -> number.startsWith("-"))
                     .collect(Collectors.toList());

            if (!negativeNumbers.isEmpty()) throw new Exception(String.join(",",negativeNumbers));

            return Arrays
                    .stream(refactoredList)
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .filter(number -> isSmallerThan(1000, number))
                    .sum();
        } else {
            return 0;
        }
    }

    private boolean isSmallerThan(int limit, int number) {
        return limit > number;
    }
}
