package com.siit.course11.socks;

import com.siit.homework.course11.socksPairExercise.SockPairService;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SockPairServiceTest {
    private SockPairService sut;

    @Before
    public void setup() {
        sut = new SockPairService();
    }

    @Test
    public void given_two_pairs_input_on_array_when_compute_inverse_then_two_pairs_are_returned() {
        int[] pairsInput = {1, 2, 1, 2};
        int pairsNo = sut.sockMerchant(pairsInput);

        assertThat(pairsNo).isEqualTo(2);
    }

    @Test
    public void given_empty_array_input_when_compute_inverse_then_zero_pairs_is_returned() {
        int[] pairsInput = {};
        int pairsNo = sut.sockMerchant(pairsInput);

        assertThat(pairsNo).isEqualTo(0);
    }

    @Test
    public void given_three_pairs_input_on_array_when_compute_inverse_then_three_pairs_are_returned() {
        int[] pairsInput = {1, 2, 1, 2, 4, 5, 2, 4};
        int pairsNo = sut.sockMerchant(pairsInput);

        assertThat(pairsNo).isEqualTo(3);
    }
}
