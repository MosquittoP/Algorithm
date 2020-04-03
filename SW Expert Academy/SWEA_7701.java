import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
  
class SWEA_7701 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            Set<String> set = new TreeSet<>(new Comparator<String>() {
                public int compare(String o1, String o2) {
                    if (o1.length() == o2.length()) {
                        int max = Math.min(o1.length(), o2.length());
                        int length = 0;
                        while(length < max) {
                            if (o1.charAt(length) == o2.charAt(length)) {
                                length++;
                                continue;
                            }
                            return o1.charAt(length) - o2.charAt(length);
                        }
                        return o1.charAt(length - 1) - o2.charAt(length - 1);
                    }
                    else
                        return o1.length() - o2.length();
                }
            });
            for (int i = 0; i < n; i++)
                set.add(sc.next());
            System.out.println("#" + test_case);
            Iterator<String> it = set.iterator();
            while (it.hasNext())
                System.out.println(it.next());
        }
    }
}
