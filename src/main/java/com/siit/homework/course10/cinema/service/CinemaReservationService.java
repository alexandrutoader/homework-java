package com.siit.homework.course10.cinema.service;

import com.siit.homework.course10.cinema.entity.Cinema;
import com.siit.homework.course10.cinema.entity.Seat;

import java.math.BigDecimal;
import java.util.*;

public class CinemaReservationService {
    private final static int ROWS = 10;
    private final static int SEATS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Seat[][] seats = createSeats();
            System.out.println("=========CINEMA DISPLAY=========");
            displaySeats(seats);
            reserveSeats(scanner, seats);
            cancelReservation(scanner, seats);
            System.out.println("=========CINEMA DISPLAY=========");
            displaySeats(seats);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void displaySeats(Seat[][] seats) {
        Map<Integer, Seat[]> mapSeats = new HashMap<>();
        int i = 1;

        for (Seat[] row : seats) {
            mapSeats.put(i, row);
            i++;
        }

        Cinema cinema = Cinema.builder()
                .name("Hollywood Multiplex")
                .seats(mapSeats)
                .build();

        cinema.getSeats().forEach((key, value) ->
                System.out.println(key + ":" + (Arrays.toString(value)) + " "));
    }

    public static Seat[][] createSeats() {
        Seat[][] seats = new Seat[ROWS][SEATS];

        char seat = 'A';
        for (int i = 0; i < seats.length; i++) {
            for (int y = 0; y < seats[i].length; y++) {
                for (int j = 1; j <= 10; ++j) {
                    seats[i][y] = new Seat(String.valueOf(j), String.valueOf(seat), false, seatPrice(String.valueOf(seat)));
                    y++;
                }
                seat++;
            }
        }

        return seats;
    }

    public static BigDecimal seatPrice(String seatRow) {
        BigDecimal price = new BigDecimal(0);
        if (seatRow.equals("A") || seatRow.equals("B") || seatRow.equals("C")) {
            return new BigDecimal(12);
        }

        if (seatRow.equals("D") || seatRow.equals("E") || seatRow.equals("F")) {
            return new BigDecimal(15);
        }

        if (seatRow.equals("G") || seatRow.equals("H") || seatRow.equals("I") || seatRow.equals("J")) {
            return new BigDecimal(18);
        }
        return price;
    }

    public static Seat[][] reserveSeats(Scanner scanner, Seat[][] seats) throws Exception {
        if (seats.length == 0) {
            throw new Exception("No available allSeats!");
        }

        System.out.println("Please enter a number for how many tickets do you want:");
        int ticketsNo = scanner.nextInt();

        if (ticketsNo < 1) {
            throw new IllegalArgumentException("Please select a number greater than 0!");
        }

        System.out.println("Do you want tickets in: 1 - Front (A-C), 2 - Middle(D-F), 3 - Back(H-J)");
        int seatsChoice = scanner.nextInt();

        if (seatsChoice < 1 || seatsChoice > 3) {
            throw new Exception("Please provide a zone for tickets between 1 and 3!");
        }

        boolean choiceOption = true;
        int ticketCounter = ticketsNo;
        BigDecimal ticketsSum = new BigDecimal(0);

        while (choiceOption) {
            if (seatsChoice == 1) {
                for (int i = 0; i <= 2; i++) {
                    for (Seat seat2 : seats[i]) {
                        if (ticketCounter == 0) {
                            System.out.println("Total sum of tickets: " + ticketsSum.toString());
                            break;
                        }
                        if (!seat2.isReserved()) {
                            seat2.setReserved(true);
                            ticketCounter--;

                            System.out.println("\n=======================================");
                            System.out.println("You have reserved seat no " + (seat2.getSeatRow()
                                    + seat2.getSeatNumber()));
                            System.out.println("=======================================");
                            ticketsSum = ticketsSum.add(seat2.getPrice());
                        }
                    }
                    if (ticketCounter == 0) {
                        break;
                    }
                }

                choiceOption = false;
            }
            if (seatsChoice == 2) {
                for (int i = 3; i <= 5; i++) {
                    for (Seat seat2 : seats[i]) {
                        if (ticketCounter == 0) {
                            System.out.println("Total sum of tickets: " + ticketsSum.toString());
                            break;
                        }
                        if (!seat2.isReserved()) {
                            seat2.setReserved(true);
                            ticketCounter--;

                            System.out.println("\n=======================================");
                            System.out.println("You have reserved seat no " + (seat2.getSeatRow()
                                    + seat2.getSeatNumber()));
                            System.out.println("=======================================");
                            ticketsSum = ticketsSum.add(seat2.getPrice());
                        }
                    }
                    if (ticketCounter == 0) {
                        break;
                    }
                }

                choiceOption = false;
            }
            if (seatsChoice == 3) {
                for (int i = 6; i <= 10; i++) {
                    for (Seat seat2 : seats[i]) {
                        if (ticketCounter == 0) {
                            System.out.println("Total sum of tickets: " + ticketsSum.toString());
                            break;
                        }
                        if (!seat2.isReserved()) {
                            seat2.setReserved(true);
                            ticketCounter--;

                            System.out.println("\n=======================================");
                            System.out.println("You have reserved seat no " + (seat2.getSeatRow()
                                    + seat2.getSeatNumber()));
                            System.out.println("=======================================");
                            ticketsSum = ticketsSum.add(seat2.getPrice());
                        }
                    }
                    if (ticketCounter == 0) {
                        break;
                    }
                }

                choiceOption = false;
            }
        }
        return seats;
    }

    public static void cancelReservation(Scanner scanner, Seat[][] seats) {
        System.out.println("Would you like to cancel all reservation? Y - Yes / N - No / R - I've changed my mind");
        String cancelOption = scanner.next();
        cancelOption = cancelOption.toUpperCase();

        String seatsToBeCanceled = "";
        boolean inputOption = true;
        boolean cancelAllReservation = false;
        boolean abortReservationCall = true;

        while (inputOption) {
            switch (cancelOption) {
                case "Y":
                    System.out.println("Your reservation will be removed shortly.");
                    inputOption = false;
                    cancelAllReservation = true;
                    break;
                case "N":
                    System.out.println("Please specify which seat do you want to cancel from reservation? Ex: A2 or A2,A3,A4");
                    seatsToBeCanceled = scanner.next();
                    inputOption = false;
                    break;
                case "R":
                    inputOption = false;
                    abortReservationCall = false;
                    break;
                default:
                    System.out.println("Please choose Y, N or R:");
                    cancelOption = scanner.next();
                    break;
            }
        }

        if (abortReservationCall) {
            for (Seat[] row : seats) {
                for (Seat seat : row) {
                    if (cancelAllReservation) {
                        seat.setReserved(false);
                    }
                    if (!cancelAllReservation) {
                        String[] inputSeats = seatsToBeCanceled.split("\\s*,\\s*");

                        for (String seatToBeRemoved : inputSeats) {
                            if (seatToBeRemoved.equals(seat.getSeatNumber() + seat.getSeatRow())) {
                                seat.setReserved(false);
                                System.out.println("Seat " + (seat.getSeatRow() + seat.getSeatNumber()) + " have been removed from reservation.");
                            }
                        }
                    }
                }
            }
        }
    }
}
