import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Main {
    
    public static long gt(int n) {
        if(n == 0 || n == 1) return 1;
        else return n * gt(n - 1);
    }
    
    
    public static int tong(int n) {
        int tong = 0;
        while(n > 0) {
            tong += n % 10;
            n /= 10;
        }
        return tong;
    }
    
    public static boolean nt(int n) {
        if(n < 2) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    
    public static void sort(int[] a, int n) {
        for(int i = 0; i < n - 1; i++) {
            int min = i;
            for(int j = i + 1; j < n; j++) {
                if(a[min] > a[j]) {
                    min = j;
                }
            }
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }
    
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Bài 1, 1.2, 1.3
        /*
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int tong = x + y;
        int hieu = x - y;
        int tich = x * y;
        int thuong = x / y;
        System.out.print("Tong: " + tong + "\n" + "Hieu: " + hieu + "\n" + "Tich: " + tich + "\n" + "Thuong: " + thuong + "\n");
        */

        //Bài 2.1, 2.2
        /*
        int n = sc.nextInt();
        int[] a = new int[n];
        int tong = 0;
        int tchan = 0;
        
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        for(int i = 0; i < n; i++) {
            tong += a[i];
            if(a[i] % 2 == 0) {
                tchan += a[i];
            }
        }
        
        System.out.print("Tong: " + tong + "\n" + "Tong chan: " + tchan + "\n");
        */
        
        //Bài 3: Phương trình bậc nhất y = ax + b;
        
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();
        
//        if(a == 0) {
//            System.out.println("Vui lòng chạy lại với a khác 0");
//        } else {
//                float x = -b / (float)a;
//                System.out.println(x);
//        }

        //Bài 4: Phương trình bậc hai: ax^2 + bx + c
//        float x;
//        if(a == 0) {
//            x = -c / (float)b;
//            System.out.println(x);
//        } else {
//            float denta = b * b - 4 * a * c;
//            if(denta < 0) {
//                System.out.println("Phương trình vô nghiệm");
//            } else if(denta == 0) {
//                x = (float) (-b / (2.0 * a));
//                System.out.println(x);
//            } else {
//                float x1 = (float) ((-b + Math.sqrt(denta)) / (2.0 * a));
//                float x2 = (float) ((-b - Math.sqrt(denta)) / (2.0 * a));
//                System.out.printf("Phương trình có hai nghiệm: x1 = %.2f, x2 = %.2f\n", x1, x2);
//            }
//        }
        
        //Bài 6: 
//        int n = sc.nextInt();
//        double tong = 0;
//        for(int i = 1; i <= n; i++) {
//            tong += 1.0 / i;
//        }
//        System.out.println("Tong: " + tong);
        
        //Bài 7: Tính giai thừa
//        int n = sc.nextInt();
//        System.out.println(gt(n));

        //Bài 8: Tổng giai thừa
//        int n = sc.nextInt();
//        double tong = 0;
//        for(int i = 1; i <= n; i++) {
//            tong += 1.0 / gt(i);
//        }
//        System.out.println("Tong: " + tong);

        //Bài 9: Fibonacci
        //Bài 10: Tổng chữ số
//        int n = sc.nextInt();
//        System.out.println(tong(n));
        
        //Bài 11: Số NT
//        int n = sc.nextInt();
//        if(nt(n) == 1) {
//            System.out.println("YES");
//        } else {
//            System.out.println("NO");
//        }

        //Bài 12: Mảng
//        int n = sc.nextInt();
//        int[] a = new int[n];
//        for(int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//        
//        int max = -10000000, min = 10000000;
//        int chan = 0, nto = 0;
//        for(int i = 0; i < n; i++) {
//            if(max < a[i]) {
//                max = a[i];
//            }
//            if(min > a[i]) {
//                min = a[i];
//            }
//            if(a[i] % 2 == 0) {
//                chan++;
//            }
//            if(nt(a[i]) == true) {
//                nto++;
//            }
//        }
//        
//        for (int x : a) {
//            System.out.print(x + " ");
//        }
//        System.out.println();
//        System.out.println("Max = " + max);
//        System.out.println("Min = " + min);
//        System.out.println("Chan: " + chan);
//        System.out.println("Nguyen to: " + nto);
//        
//        int y = sc.nextInt();
//        boolean check = false;
//        for(int x : a) {
//            if(x == y) {
//                System.out.println("Giá trị cần tìm: " + x);
//                check = true;
//                break;
//            }
//        }
//        
//        if(!check) {
//            System.out.println("Không có giá trị cần tìm");
//        }
//        
//        Arrays.sort(a);
//        sort(a, n);
//        System.out.println("Mảng sau khi sắp xếp:");
//        for (int x : a) {
//            System.out.print(x + " ");
//        }
//        System.out.println();
        
        //Bài 13: mảng 2 chiều
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] a = new int[n][m];
//        
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//        }
//        
//        System.out.println();
//        
//        int max = -100000000, min = 100000000, maxTong = 0, index = -1;
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                if(min > a[i][j]) {
//                    min = a[i][j];
//                }
//                
//                if(a[i][j] % 2 != 0 && a[i][j] > max) {
//                    max = a[i][j];
//                }
//                
//            }
//        }
//        
//        System.out.println("Max = " + max + "\n" + "Min = " + min);
//        
//        for(int i = 0; i < n; i++) {
//            int tong = 0;
//            for(int j = 0; j < m; j++) {
//                tong += a[i][j];
//            }
//            if(tong > maxTong) {
//                maxTong = tong;
//                index = i;
//            }
//        }
//        
//        System.out.println("Dòng có tổng lớn nhất: " + (index + 1) + " (tổng = " + maxTong + ")");

        //Bai 14:
		
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        int[][] b = new int[m][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                b[i][j] = a[j][i];
            }
        }
        
        for(int i = 0; i < m; i++) {
            sort(b[i], n);
        }
        
//        for(int i = 0; i < m; i++) {
//            for(int j = 0; j < n; j++) {
//                System.out.print(b[i][j] + " ");
//            }
//            System.out.println();
//        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = b[j][i];
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}
