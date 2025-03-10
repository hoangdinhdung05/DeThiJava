import java.util.*;

public class JavaBasic {

    //Tim kiem
    public static boolean search(int[] a, int n, int x) {
        for(int i = 0; i < n; i++) {
            if(a[i] == x) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // List<Integer> a = new ArrayList<>();
        Integer[] a = new Integer[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a, new Comparator<Integer>() {
            @Override

            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");

        }
        sc.close();
    }
}