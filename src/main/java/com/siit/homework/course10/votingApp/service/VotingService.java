package com.siit.homework.course10.votingApp.service;

import com.siit.homework.course10.votingApp.entity.Person;
import com.siit.homework.course10.votingApp.repository.VotingRepository;

import java.util.*;

public class VotingService {
    public static void main(String[] args) {
        getCandidatesNames();
        System.out.println("\nThe voters are:");
        TreeSet<Person> persons = getVoters();
        persons.forEach(person -> System.out.println(person.toString()));
        Map<Person, String> votes = vote(persons);

        System.out.println("\nPersons who voted:");
        votes.entrySet()
                .stream()
                .map(e -> e.getKey() + " " + e.getValue())
                .forEach(System.out::println);
    }

    public static TreeSet<String> getCandidatesNames() {
        TreeSet<String> candidates = new TreeSet<>();
        candidates.add("Marian Antonescu");
        candidates.add("Florin Ionescu");
        candidates.add("Ioana Damian");
        candidates.add("Ciprian Popescu");

        return candidates;
    }

    public static TreeSet<Person> getVoters() {
        return VotingRepository.personsTreeSet;
    }

    public static Map<Person, String> vote(TreeSet<Person> persons) {
        Scanner scanner = new Scanner(System.in);
        Map<Person, String> votingPersons = new HashMap<>();

        while (persons.iterator().hasNext()) {
            boolean invalidInput = true;
            while (invalidInput) {
                System.out.println("\n\nPlease enter your vote as following: CNP + Candidate name from below");
                TreeSet<String> candidatesNames = getCandidatesNames();
                int counter = 1;
                for (String cadidateName : candidatesNames) {
                    System.out.println(counter + ". " + cadidateName);
                    counter++;
                }
                String voteOption = scanner.nextLine();
                String[] splitVoteOption = voteOption.split(" ");

                if (splitVoteOption.length != 0) {
                    String cnp = splitVoteOption[0];
                    boolean isCnpValid = validateCnp(cnp);

                    StringBuilder candidateName = new StringBuilder();

                    if (!isCnpValid) {
                        System.out.println("\n\n===============================================");
                        System.out.println("Your cnp is not in the vote list! Please retry!");
                    } else if (!isValidCandidateName(candidatesNames, counter, splitVoteOption, candidateName)) {
                        System.out.println("\n\n===============================================");
                        System.out.println("The candidate name is not valid! Please retry!");
                    } else {
                        if (candidatesNames.contains(candidateName.toString().trim())) {
                            for (Person person : persons) {
                                if (!person.isVoted()) {
                                    if (person.getCnp().equals(cnp)) {
                                        person.setVoted(true);
                                        votingPersons.put(person, candidateName.toString().trim());
                                    }
                                } else {
                                    System.out.println("\nYou allready voted!");
                                }
                            }
                            invalidInput = false;
                        }
                    }
                }
            }

            System.out.println("\nContinue voting? Y / N");
            String votingFlag = scanner.next();
            votingFlag = votingFlag.toUpperCase();

            if (votingFlag.equals("N")) {
                break;
            }
        }

        return votingPersons;
    }

    private static boolean isValidCandidateName(TreeSet<String> candidatesNames, int counter, String[] splitVoteOption, StringBuilder candidateName) {
        for (int i = 1; i < splitVoteOption.length; i++) {
            candidateName.append(" ").append(splitVoteOption[i]);
        }

        if (!candidatesNames.contains(candidateName.toString().trim())) {
            System.out.println("Please vote a person from the given list:");
            for (String cadidateName : candidatesNames) {
                System.out.println(counter + ". " + cadidateName);
            }
            return false;
        }
        return true;
    }

    public static boolean validateCnp(String cnp) {
        TreeSet<Person> persons = getVoters();
        for (Person person : persons) {
            if (person.getCnp().equals(cnp)) {
                return true;
            }
        }
        return false;
    }
}
