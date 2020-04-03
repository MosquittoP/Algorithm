import java.util.Scanner;
 
class SWEA_9760 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            boolean onepair = false;
            boolean twopair = false;
            boolean triple = false;
            boolean fourcard = false;
            boolean straight = false;
            boolean flush = false;
            String[] in = new String[5]; 
            for (int i = 0; i < 5; i++) {
                in[i] = sc.next();
            }
            char[] suit = new char[5];
            int[] num = new int[5];
            int[] numcheck = new int[14];
            for (int i = 0; i < 5; i++) {
                suit[i] = in[i].charAt(0);
                if (in[i].charAt(1) == 'T')
                    num[i] = 10;
                else if (in[i].charAt(1) == 'A')
                    num[i] = 1;
                else if (in[i].charAt(1) == 'J')
                    num[i] = 11;
                else if (in[i].charAt(1) == 'Q')
                    num[i] = 12;
                else if (in[i].charAt(1) == 'K')
                    num[i] = 13;
                else
                    num[i] = in[i].charAt(1) - '0';
            }
            int cnt1 = 0;
            for (int i = 0; i < 4; i++) {
                if (suit[i] == suit[i + 1])
                    cnt1++;
            }
            if (cnt1 == 4)
                flush = true;
            for (int i = 0; i < 5; i++) {
                numcheck[num[i]]++;
            }
            for (int i = 1; i < 14; i++) {
                if (onepair == false && numcheck[i] == 2)
                    onepair = true;
                else if (onepair == true && numcheck[i] == 2)
                    twopair = true;
                else if (numcheck[i] == 3) 
                    triple = true;
                else if (numcheck[i] >= 4)
                    fourcard = true;
            }
            for (int i = 1; i < 10; i++) {
                if (numcheck[i] == 1 && numcheck[i + 1] == 1 && numcheck[i + 2] == 1 && numcheck[i + 3] == 1 && numcheck[i + 4] == 1)
                    straight = true;
            }
            if (numcheck[1] == 1 && numcheck[10] == 1 && numcheck[11] == 1 && numcheck[12] == 1 && numcheck[13] == 1)
                straight = true;
            if (flush && straight) {
                System.out.println("#" + test_case + " " + "Straight Flush");
            }
            else if (fourcard) {
                System.out.println("#" + test_case + " " + "Four of a Kind");
            }
            else if (onepair && triple) {
                System.out.println("#" + test_case + " " + "Full House");
            }
            else if (flush) {
                System.out.println("#" + test_case + " " + "Flush");
            }
            else if (straight) {
                System.out.println("#" + test_case + " " + "Straight");
            }
            else if (triple) {
                System.out.println("#" + test_case + " " + "Three of a kind");
            }
            else if (twopair) {
                System.out.println("#" + test_case + " " + "Two pair");
            }
            else if (onepair) {
                System.out.println("#" + test_case + " " + "One pair");
            }
            else {
                System.out.println("#" + test_case + " " + "High card");
            }
        }
    }
}
