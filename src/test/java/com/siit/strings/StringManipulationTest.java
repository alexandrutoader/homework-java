package com.siit.strings;

import com.siit.homework.course6.StringManipulation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
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

    @Test
    public void given_string_input_on_occurence_when_compute_inverse_then_occurence_is_returned() {
        String inputOne = "teste";

        HashMap<Character, Integer> response = sut.printTheOccurenceOfAGivenString(inputOne);
        assertThat(response.get('t')).isEqualTo(2);
        assertThat(response.get('e')).isEqualTo(2);
        assertThat(response.get('s')).isEqualTo(1);
    }

    @Test
    public void given_empty_input_on_occurence_when_compute_inverse_then_empty_is_returned() {
        String inputOne = "";

        HashMap<Character, Integer> response = sut.printTheOccurenceOfAGivenString(inputOne);
        assertThat(response.size()).isEqualTo(0);
    }

    @Test
    public void given_null_input_on_occurence_when_compute_inverse_then_null_is_returned() {
        String inputOne = null;

        HashMap<Character, Integer> response = sut.printTheOccurenceOfAGivenString(inputOne);
        assertThat(response).isNull();
    }

    @Test
    public void given_string_input_on_when_compute_inverse_then_first_non_repeated_character_is_returned() {
        String inputOne = "abbcdeaf";

        String string = sut.findFirstNonRepeatingCharacter(inputOne);
        assertThat(string).isEqualTo("The first non repeated character in string is: c");
    }

    @Test
    public void given_empty_input_on_non_repeated_character_when_compute_inverse_then_empty_is_returned() {
        String inputOne = "abbcdeaf";

        String string = sut.findFirstNonRepeatingCharacter(inputOne);
        assertThat(string).isEqualTo("The first non repeated character in string is: c");
    }

    @Test
    public void given_string_input_when_compute_inverse_then_int_is_returned() {
        String inputOne = "123";

        Number string = sut.printStringToInt(inputOne);
        assertThat(string).isEqualTo(123);
    }

    @Test
    public void given_null_input_on_print_string_to_int_when_compute_inverse_then_null_is_returned() {
        String inputOne = null;

        Number string = sut.printStringToInt(inputOne);
        assertThat(string).isNull();
    }

    @Test
    public void given_input_when_compute_inverse_then_reverse_input_is_returned() {
        String inputOne = "scoala informala";

        String string = sut.reverseWordsFromSentence(inputOne);
        assertThat(string).isEqualTo("Reversed sentence: informala scoala");
    }

    @Test
    public void given_null_when_compute_inverse_then_reverse_null_is_returned() {
        String inputOne = null;

        String string = sut.reverseWordsFromSentence(inputOne);
        assertThat(string).isNull();
    }

    @Test
    public void given_input_when_compute_inverse_then_string_rotation_is_returned() {
        String inputOne = "java";
        String inputTwo = "avaj";

        String string = sut.isRotation(inputOne, inputTwo);
        assertThat(string).isEqualTo("The two strings are a rotation of each other.");
    }

    @Test
    public void given_null_parameter_on_rotation_when_compute_inverse_then_null_is_returned() {
        String inputOne = "java";
        String inputTwo = null;

        String string = sut.isRotation(inputOne, inputTwo);
        assertThat(string).isNull();
    }

    @Test
    public void given_input_when_compute_inverse_then_palindrome_is_returned() {
        String inputOne = "radar";

        String string = sut.stringIsPalindrome(inputOne);
        assertThat(string).isEqualTo("The string is a palindrome.");
    }

    @Test
    public void given_input_when_compute_inverse_then_not_palindrome_is_returned() {
        String inputOne = "scoala";

        String string = sut.stringIsPalindrome(inputOne);
        assertThat(string).isEqualTo("The string is not a palindrome.");
    }

    @Test
    public void given_input_when_compute_inverse_then_longest_substring_is_returned_without_repeating_chars() {
        String inputOne = "developer";

        String string = sut.longestSubstringWithoutRepeatingChars(inputOne);
        assertThat(string).isEqualTo("The length of the longest substring is 7");
    }

    @Test
    public void given_input_when_compute_inverse_then_longest_palindrom_substring_is_returned() {
        String inputOne = "programming";

        String string = sut.findLongestPalindromeSubstring(inputOne);
        assertThat(string).isEqualTo("The longest palindrome from string 'programming' is: mm.");
    }

    @Test
    public void given_input_when_compute_inverse_then_string_without_duplicates_characters_removed_is_returned() {
        String inputOne = "scoalainformaladeit";

        String string = sut.removeDuplicateCharactersFromString(inputOne);
        assertThat(string).isEqualTo("String after removing characters: scoalinfrmdet");
    }

    @Test
    public void given_empty_when_compute_inverse_then_empty_is_returned() {
        String inputOne = "";

        String string = sut.removeDuplicateCharactersFromString(inputOne);
        assertThat(string).isEmpty();
    }

    @Test
    public void given_input_when_compute_inverse_then_string_is_returned_without_duplicate_chars() {
        String inputOne = "acasa";
        char inputTwo = 'a';

        String string = sut.removeAGivenCharacterFromString(inputOne, inputTwo);
        assertThat(string).isEqualTo("String after removing duplicate chars: cs");
    }

    @Test
    public void given_null_when_compute_inverse_then_null_is_returned() {
        String inputOne = null;
        char inputTwo = 'a';

        String string = sut.removeAGivenCharacterFromString(inputOne, inputTwo);
        assertThat(string).isNull();
    }

    @Test
    public void given_input_when_compute_inverse_then_most_frequent_word_is_returned() {
        String inputOne = "def def def abc abc";

        String string = sut.findMostFrequentWordInArray(inputOne);
        assertThat(string).isEqualTo("Most frequent word in array: def");
    }
}
