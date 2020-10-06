import java.util.*;

public class NumberCardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int result = 0;

        while (n >= k) {
            while (n % k != 0) {
                n -= -1;
                result += 1;
            }
            n /= k;
            result += 1;
        }
        while (n > 1) {
            n -= 1;
            result += 1;
        }

        System.out.print(result);
    }
}