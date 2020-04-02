package com.siit.strings;

import com.siit.homework.course6.StringManipulation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class StringManipulationTest {
    private StringManipulation sut;

    @Before
    public void setup() {
        sut = new StringManipulation();
    }

    @Test
    public void given_empty_input_when_compute_inverse_then_empty_is_returned() {
        String input = "";
        String returnedString = sut.reverseGivenString(input);
        assertThat(returnedString).isEmpty();
    }

    @Test
    public void given_string_input_when_compute_inverse_then_inverse_is_returned() {
        String input = "abcde";
        String returnedString = sut.reverseGivenString(input);
        assertThat(returnedString).isEqualTo("edcba");
    }

    @Test
    public void given_string_input_when_compute_inverse_then_print_duplicates_is_returned() {
        String input = "java";
        String duplicatesChars = sut.printDuplicateCharactersFromString(input);
        assertThat(duplicatesChars).isEqualTo("a");
    }

    @Test
    public void given_empty_duplicates_input_when_compute_inverse_then_empty_is_returned() {
        String input = "";
        String duplicatesChars = sut.printDuplicateCharactersFromString(input);
        assertThat(duplicatesChars).isEqualTo("");
    }

    @Test
    public void given_null_duplicates_input_when_compute_inverse_then_null_is_returned() {
        String input = null;
        String duplicatesChars = sut.printDuplicateCharactersFromString(input);
        assertThat(duplicatesChars).isNull();
    }
}
