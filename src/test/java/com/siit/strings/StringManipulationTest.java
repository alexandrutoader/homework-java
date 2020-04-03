package com.siit.strings;

import com.siit.homework.course6.StringManipulation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

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

    @Test
    public void given_two_inputs_when_compute_inverse_then_string_anagrams_is_returned() {
        String inputOne = "irtngs";
        String inputTwo = "string";

        String response = sut.checkIfTwoStringsAreAnagrams(inputOne, inputTwo);

        assertThat(response).isEqualTo("The strings are anagrams!");
    }

    @Test
    public void given_first_input_null_when_compute_inverse_then_null_is_returned() {
        String inputOne = null;
        String inputTwo = "string";

        String response = sut.checkIfTwoStringsAreAnagrams(inputOne, inputTwo);
        assertThat(response).isNull();
    }

    @Test
    public void given_second_input_null_when_compute_inverse_then_null_is_returned() {
        String inputOne = "irtngss";
        String inputTwo = null;

        String response = sut.checkIfTwoStringsAreAnagrams(inputOne, inputTwo);
        assertThat(response).isNull();
    }

    @Test
    public void given_two_inputs_when_compute_inverse_then_are_not_anagrams_is_returned() {
        String inputOne = "irtngs";
        String inputTwo = "ftring";

        String response = sut.checkIfTwoStringsAreAnagrams(inputOne, inputTwo);
        assertThat(response).isEqualTo("The strings are not anagrams!");
    }

    @Test
    public void given_string_digits_input_when_compute_inverse_then_contains_digits_is_returned() {
        String inputOne = "1234";

        String response = sut.isDigitOnly(inputOne);
        assertThat(response).isEqualTo("The string '" + inputOne + "' contains digits only.");
    }

    @Test
    public void given_string_input_when_compute_inverse_then_not_contains_digits_only_is_returned() {
        String inputOne = "abc1234";

        String response = sut.isDigitOnly(inputOne);
        assertThat(response).isEqualTo("The string '" + inputOne + "' doesn't contains only digits.");
    }

    @Test
    public void given_empty_input_when_compute_inverse_then_string_is_empty_is_returned() {
        String inputOne = "";

        String response = sut.isDigitOnly(inputOne);
        assertThat(response).isEqualTo("The string is empty!");
    }

    @Test
    public void given_null_input_when_compute_inverse_then_null_is_returned() {
        String inputOne = null;

        String response = sut.isDigitOnly(inputOne);
        assertThat(response).isNull();
    }

    @Test
    public void given_string_input_when_compute_inverse_then_vowels_and_consonants_are_returned() {
        String inputOne = "string";

        List<Integer> response = sut.printNumberOfVowelsAndConsonants(inputOne);
        assertThat(response.get(0)).isEqualTo(1);
        assertThat(response.get(1)).isEqualTo(5);
    }

    @Test
    public void given_empty_input_on_vowels_and_consonants_when_compute_inverse_then_empty_is_returned() {
        String inputOne = "";

        List<Integer> response = sut.printNumberOfVowelsAndConsonants(inputOne);
        assertThat(response.isEmpty());
    }

    @Test
    public void given_null_input_on_vowels_and_consonants_when_compute_inverse_then_null_is_returned() {
        String inputOne = null;

        List<Integer> response = sut.printNumberOfVowelsAndConsonants(inputOne);
        assertThat(response).isNull();
    }
}
