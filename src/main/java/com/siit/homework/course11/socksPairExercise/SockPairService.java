package com.siit.homework.course11.socksPairExercise;

import java.util.HashSet;
import java.util.Set;

public class SockPairService {
    public int sockMerchant(int[] socks) {
        int pairs = 0;
        Set<Integer> socksWithoutPair = new HashSet<>();

        for (int sock : socks) {
            if (!socksWithoutPair.add(sock)) {
                pairs++;
                socksWithoutPair.remove(sock);
            }
        }

        socksWithoutPair.forEach(v ->
                System.out.println("Socks without pair: " + v));
        System.out.println("Total pairs: " + pairs);

        return pairs;
    }
}
