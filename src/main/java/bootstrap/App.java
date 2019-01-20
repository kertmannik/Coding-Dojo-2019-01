package bootstrap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class App {

    public static void main(String[] args) {
        System.out.println("Hello world");
    }

    public int add(String numbers) throws Exception {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            String delimiter = ",";
            String actualInput = numbers;

            if (numbers.startsWith("//")) {
                delimiter = numbers.substring(2,3);
                actualInput = actualInput.substring(3 + delimiter.length());
            }

             List<String> negativeNumbers = Arrays.stream(actualInput.replace("\n",delimiter)
                    .split(delimiter))
                    .filter(number -> number.startsWith("-"))
                    .collect(Collectors.toList());

            if (negativeNumbers.isEmpty()) throw new Exception(String.join(",",negativeNumbers));

            return Arrays.stream(actualInput.replace("\n",delimiter)
                    .split(delimiter))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .filter(number -> isBiggerThan(1000, number))
                    .sum();
        }
    }

    private boolean isBiggerThan(int limit, int number) {
        return limit > number;
    }
}
