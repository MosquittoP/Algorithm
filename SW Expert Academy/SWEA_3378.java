import java.util.Scanner;
 
 
class SWEA_3378 {
    static int[][] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            char al;
            int r[] = new int[p];
            int c[] = new int[p];
            int s[] = new int[p];
            int d[] = new int[p];
            int nr[] = new int[q];
            int nc[] = new int[q];
            int ns[] = new int[q];
            int nd[] = new int[q];
            String[] mas = new String[p];
            String[] me = new String[q];
            for (int i = 0; i < p; i++)
                mas[i] = sc.next();
            for (int i = 0; i < q; i++)
                me[i] = sc.next();
            for (int i = 0; i < p; i++) {
                check = new int[3][2];
                int a = 0;
                if (i > 0) {
                    r[i] = r[i - 1];
                    c[i] = c[i - 1];
                    s[i] = s[i - 1];
                }
                while (mas[i].charAt(a) == '.')
                    a++;
                d[i] = a;
                for (int j = a; j < mas[i].length(); j++) {
                    al = mas[i].charAt(j);
                    switch(al) {
                    case '(':
                        check[0][0]++;
                        break;
                    case ')':
                        check[0][1]++;
                        break;
                    case '{':
                        check[1][0]++;
                        break;
                    case '}':
                        check[1][1]++;
                        break;
                    case '[':
                        check[2][0]++;
                        break;
                    case ']':
                        check[2][1]++;
                        break;
                    }
                }
                r[i] += check[0][0] - check[0][1];
                c[i] += check[1][0] - check[1][1];
                s[i] += check[2][0] - check[2][1];
            }
            for (int i = 0; i < q; i++) {
                check = new int[3][2];
                int a = 0;
                nd[i] = -2;
                if (i > 0) {
                    nr[i] = nr[i - 1];
                    nc[i] = nc[i - 1];
                    ns[i] = ns[i - 1];
                }
                for (int j = 0; j < me[i].length(); j++) {
                    al = me[i].charAt(j);
                    switch(al) {
                    case '(':
                        check[0][0]++;
                        break;
                    case ')':
                        check[0][1]++;
                        break;
                    case '{':
                        check[1][0]++;
                        break;
                    case '}':
                        check[1][1]++;
                        break;
                    case '[':
                        check[2][0]++;
                        break;
                    case ']':
                        check[2][1]++;
                        break;
                    }
                }
                nr[i] += check[0][0] - check[0][1];
                nc[i] += check[1][0] - check[1][1];
                ns[i] += check[2][0] - check[2][1];
            }
            int cnt = 0;
            for (int i = 1; i < 21; i++) {
                for (int j = 1; j < 21; j++) {
                    for (int k = 1; k < 21; k++) {
                        cnt = 0;
                        for (int l = 1; l < p; l++) {
                            if (d[l] != r[l - 1] * i + c[l - 1] * j + s[l - 1] * k)
                                cnt = 1;
                        }
                        if (cnt == 0) {                             
                            for (int m = 1; m < q; m++) {
                                int x = nr[m - 1] * i + nc[m - 1] * j + ns[m - 1] * k;
                                if (nd[m] == -2) 
                                    nd[m] = x;
                                else if (nd[m] != x)
                                    nd[m] = -1;
                            }
                        }
                    }
                }
            }
            System.out.print("#" + test_case + " 0");
            for (int i = 1; i < q; i++)
                System.out.print(" " + nd[i]);
            System.out.println();
        }
    }
}
