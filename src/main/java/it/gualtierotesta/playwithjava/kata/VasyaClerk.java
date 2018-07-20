package it.gualtierotesta.playwithjava.kata;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
The new "Avengers" movie has just been released! There are a lot of people at the cinema box office
standing in a huge line. Each of them has a single 100, 50 or 25 dollars bill. An "Avengers"
ticket costs 25 dollars.

Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.

Can Vasya sell a ticket to each person and give the change if he initially has no money and sells
the tickets strictly in the order people follow in the line?

Return YES, if Vasya can sell a ticket to each person and give the change with the bills he has at
hand at that moment. Otherwise return NO.

###Examples:

// *** Java ***

Line.Tickets(new int[] {25, 25, 50}) // => YES
Line.Tickets(new int[]{25, 100}) // => NO. Vasya will not have enough money to give change to 100 dollars
Line.Tickets(new int[] {25, 25, 50, 50, 100}) // => NO. Vasya will not have the right bills to give 75 dollars of change (you can't make two bills of 25 from one of 50)

 */
public class VasyaClerk {

    private static final int TICKET_PRICE = 25;
    private static final int BILL_25 = 0;
    private static final int BILL_50 = 1;
    private static final int BILL_100 = 2;

    public static String tickets(int[] peopleInLine) {
        int[] changeBills = {0, 0, 0};  // 25, 50, 100
        for (int currentBill : peopleInLine) {
            if (!updateChangeBills(currentBill, changeBills)) {
                return "NO";
            }
        }
        return "YES";
    }

    private static boolean updateChangeBills(int currentBill, int[] changeBills) {
        if (currentBill == 25) {
            changeBills[BILL_25] += 1;

        } else if (currentBill == 50) {  // change is 25
            if (changeBills[BILL_25] > 0) {
                changeBills[BILL_25] -= 1;
            } else {
                return false;
            }
            changeBills[BILL_50] += 1;

        } else if (currentBill == 100) { // change is 50 + 1 * 25 or 3 * 25
            if (changeBills[BILL_50] > 0 && changeBills[BILL_25] > 0) {
                changeBills[BILL_50] -= 1;
                changeBills[BILL_25] -= 1;
            } else if (changeBills[BILL_25] > 2) {
                changeBills[BILL_25] -= 3;
            } else {
                return false;
            }
            changeBills[BILL_100] += 1;
        }
        return true;
    }
}
