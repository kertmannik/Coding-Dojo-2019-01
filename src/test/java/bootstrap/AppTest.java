package bootstrap;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

class AppTest {

    @Test
    void should_return_zero_when_empty_string() throws Exception {
        App calculator = new App();
        String empty_string = "";

        assertThat(calculator.add(empty_string)).isEqualTo(0);
    }

    @Test
    void should_return_sum_when_one_number() throws Exception {
        App calculator = new App();
        String numbers = "1";

        assertThat(calculator.add(numbers)).isEqualTo(1);
    }

    @Test
    void should_return_sum_when_two_numbers() throws Exception {
        App calculator = new App();
        String numbers = "1,2";

        assertThat(calculator.add(numbers)).isEqualTo(3);
    }


    @Test
    void should_return_sum_when_multiple_numbers() throws Exception {
        App calculator = new App();
        String numbers = "1,2,88";

        assertThat(calculator.add(numbers)).isEqualTo(91);
    }

    @Test
    void should_return_sum_with_new_line_delimiter() throws Exception {
        App calculator = new App();
        String numbers = "1\n2,88";

        assertThat(calculator.add(numbers)).isEqualTo(91);
    }


    @Test
    void should_return_sum_with_configurable_delimiter() throws Exception {
        App calculator = new App();
        String numbers = "//;\n1;2";

        assertThat(calculator.add(numbers)).isEqualTo(3);
    }

    @Test
    void should_throw_an_error_when_negative_number() {
        App calculator = new App();
        String numbers = "//;\n-1;2";


        try {
            calculator.add(numbers);
            fail("Should throw Exception if negative number");
        } catch (Exception expected) {

        }
    }

    @Test
    void should_throw_an_error_with_message_containing_negative_number() {
        App calculator = new App();
        String numbers = "//;\n-1;2";


        try {
            calculator.add(numbers);
            fail("Should throw Exception if negative number");
        } catch (Exception expected) {
            assertThat(expected.getMessage()).isEqualTo("-1");
        }
    }

    @Test
    void should_throw_an_error_when_multiple_negative_numbers() throws Exception {
        App calculator = new App();
        String numbers = "//;\n-1;-2";


        try {
            calculator.add(numbers);
            fail("Should throw Exception if negative number");
        } catch (Exception expected) {
            assertThat(expected.getMessage()).isEqualTo("-1,-2");
        }
    }

    @Test
    void should_return_sum_without_large_numbers() throws Exception {
        App calculator = new App();
        String numbers = "//;\n1000;2;1000";

        assertThat(calculator.add(numbers)).isEqualTo(2);
    }
}

