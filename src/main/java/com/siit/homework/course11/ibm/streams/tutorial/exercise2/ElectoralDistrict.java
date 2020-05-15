package com.siit.homework.course11.ibm.streams.tutorial.exercise2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ElectoralDistrict {

    CROYDON("CR"),
    BARKING("BA"),
    HACKNEY("HA"),
    EDMONTON("ED");

    private final String prefix;

    ElectoralDistrict(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Complete this method to pass Exercise_2_Test#setOfVotersInDistrict()
     *
     * @param district - District to vote in
     * @param voters   - voters to filter
     * @return filtered set of registered voters in a district
     */
    public static Set<RegisteredVoter> votersIn(ElectoralDistrict district, Collection<RegisteredVoter> voters) {
        // [your code here]

        return voters.stream()
                .filter(voter -> voter.getElectorId().contains(district.getPrefix())).collect(Collectors.toUnmodifiableSet());
    }

    /**
     * Complete this method to pass Exercise_2_Test#removeAllSpoiledBallots()
     *
     * @param ballots - ballots to filter
     * @return filtered set of unspoiled ballots
     */
    public static Set<Ballot> unspoiledBallots(Set<Ballot> ballots) {
        // [your code here]
        return ballots.stream()
                .filter(ballot -> !ballot.isSpoiled())
                .collect(Collectors.toSet());
    }

    public String getPrefix() {
        return prefix;
    }
}

