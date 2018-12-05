package workspace;

import java.util.Scanner;

/* 2293
 * n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.

사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.*/

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
