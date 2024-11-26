package it.gualtierotesta.playwithjava.problems.leetcode;

public class P0860_lemonadChange {
    public boolean lemonadeChange(int[] bills) {
        int bill5 = 0;
        int bill10 = 0;
        for (int i = 0; i < bills.length; i++) {
            System.out.println("Bill=" + bills[i] + " " + bill5 + " " + bill10);
            int bill = bills[i];
            if (bill == 5) {
                bill5++;
                continue;
            }
            if (bill == 10) {
                if (bill5 < 1) return false;
                bill5--;
                bill10++;
            }

            if (bill == 20) {
                if (bill10 == 0) {
                    if (bill5 < 3) return false;
                    bill5 -= 3;
                }
                if (bill10 > 0) {
                    if (bill5 == 0) return false;
                    bill10--;
                    bill5--;
                }
            }

        }
        return true;
    }
}
