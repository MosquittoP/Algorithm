import java.util.Scanner;
  
class SWEA_1213 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int n = sc.nextInt();
            char a[] = sc.next().toCharArray();
            char b[] = sc.next().toCharArray();
            int num = 0;
            int count = 0;
            for (int i = 0; i < b.length - a.length + 1; i++) {
                num = 0;
                if (a[num] == b[i]) {
                    while (true) {
                        num++;
                        if (a[num] != b[i + num])
                            break;
                        if (num == a.length - 1) {
                            count++;
                            break;
                        }
                    }
                }
            }
            System.out.println("#" + t + " " + count);
        }
    }
}
