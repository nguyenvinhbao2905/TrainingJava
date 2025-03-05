package homework.oop.test;
import java.util.LinkedList;



public class NewTest {


        public static void main(String[] args) {

            factorize(60);
            factorize2(60, 2);

            recursionExample(3, 'A', 'B', 'C');
        }
        public static void factorize(int n) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                while (n % i == 0) {
                    System.out.println(i);
                    n /= i;
                }
            }
            if (n > 1) {
                System.out.println(n);
            }
        }

        public static void factorize2(int n, int i) {
            if (n <= 1) return;

            if (n % i == 0) {
                System.out.println(i);
                factorize2(n / i, i);
            } else {
                factorize2(n, i + 1);
            }

        }
        public static void recursionExample(int n, char A, char C, char B) {
            if (n == 1) {
                System.out.println(String.format("Move 1 from %s to %s", A, C));
            } else {
                recursionExample(n - 1, A, B, C);

                System.out.println(String.format("Move 1 from %s to %s", A, C));

                recursionExample(n - 1, B, C, A);
            }
        }


}
