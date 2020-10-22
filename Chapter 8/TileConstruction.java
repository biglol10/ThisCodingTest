import java.util.*;

public class TileConstruction {
	static int[] dp = new int[100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] d = new int[1001];
		d[1] = 1;
		d[2] = 3;
		
		for (int i = 3; i < n+1; i++) {
			d[i] = (d[i-1] + 2 * d[i-2]) % 796796;
		}
		System.out.println(d[n]);
	}
}

