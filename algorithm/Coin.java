package workspace;

import java.util.Scanner;

/* 2293
 * n���� ������ ������ �ִ�. ������ ������ ��Ÿ���� ��ġ�� �ٸ���. �� ������ ������ ����ؼ�, �� ��ġ�� ���� k���� �ǵ��� �ϰ� �ʹ�. �� ����� ���� ���Ͻÿ�. ������ ������ �� ���� ����� �� �ִ�.

����� ������ ������ ������, ������ �ٸ� ���� ���� ����̴�.*/

/*input
3 10
1
2
5

output
10*/
public class Coin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] c = new int[N+1];
		
		for(int a=1;a<=N;a++) {
			c[a]=sc.nextInt();
		}
		int[] dp = new int[K+1];
		
		dp[0]=1;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=K;j++) {
				if(c[i]<=j) dp[j] += dp[j-c[i]];
			}
		}
		System.out.println(dp[K]);
 	}

}
