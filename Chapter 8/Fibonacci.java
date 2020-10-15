import java.util.*;

public class Fibonacci {
	static long[] d = new long[100];
	public static void main(String[] args) {
		fibo(99);
		System.out.print(d[40]);
	}
	public static long fibo(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		if (d[n] != 0) {
			return d[n];
		}
		d[n] = fibo(n-1) + fibo(n-2);
		return d[n];
	}
}

