import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
  
class SWEA_1240 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] code = new int[8];
            for (int i = 0; i < code.length; i++) {
                code[i] = -1;
            }
            String s = "";
            Map<String, Integer> pw = new HashMap();
            pw.put("0001101", 0);
            pw.put("0011001", 1);
            pw.put("0010011", 2);
            pw.put("0111101", 3);
            pw.put("0100011", 4);
            pw.put("0110001", 5);
            pw.put("0101111", 6);
            pw.put("0111011", 7);
            pw.put("0110111", 8);
            pw.put("0001011", 9);
            int count = 0;
            String[] num = new String[n];
            for (int i = 0; i < num.length; i++) {
                num[i] = sc.next();
            }
            int check = 0;
            while (count == 0) {
                s = num[check];
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '1') {
                        count = 1;
                        break;
                    }
                }
                check++;
            }
            int a = 0;
            String ss = "";
            for (int i = 0; i < s.length() - 6; i++) {
                for (int j = i; j < i + 7; j++)
                    ss += s.charAt(j);
                if (pw.containsKey(ss)) {
                    a = i;
                    ss = "";
                    for (int k = 0; k < code.length; k++) {
                            ss += s.substring(a, a + 7);
                        if (!pw.containsKey(ss))
                            break;
                        code[k] = pw.get(ss);
                        a += 7;
                        ss = "";
                    }
                    if (code[code.length - 1] != -1) 
                        break;
                }
                ss = "";
            }
            int pwcode = ((code[0] + code[2] + code[4] + code[6]) * 3) + code[1] + code[3] + code[5] + code[7];
            if (pwcode % 10 == 0) {
                int sum = 0;
                for (int v : code)
                    sum += v;
                System.out.println("#" + t + " " + sum);
            }
            else
                System.out.println("#" + t + " 0");
        }
    }
}
