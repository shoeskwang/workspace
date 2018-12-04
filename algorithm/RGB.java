package workspace;

import java.util.Scanner;
/*1149

RGB�Ÿ��� ��� ������� ���� ����, �ʷ�, �Ķ��߿� �ϳ��� ĥ�Ϸ��� �Ѵ�. ����, �׵��� ��� �̿��� ���� ������ ĥ�� �� ���ٴ� ��Ģ�� ���ߴ�. �� i�� �̿��� �� i-1�� �� i+1�̴�.

�� ���� �������� ĥ�� �� ��� ���, �ʷ����� ĥ�� �� ��� ���, �Ķ����� ��� ����� �־��� ��, ��� ���� ĥ�� �� ��� ����� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

input
3
26 40 83
49 60 57
13 89 99

output
96*/

public class RGB {
	public static int min(int a,int b) {
		return a<b?a:b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] rgb = new int[N+1][3];
		for(int i=1;i<=N;i++) {
			rgb[i][0]=sc.nextInt();
			rgb[i][1]=sc.nextInt();
			rgb[i][2]=sc.nextInt();
		}
		
		int[][] dp = new int[N+1][3];
		dp[0][0]=dp[0][1]=dp[0][2]=rgb[0][0]=rgb[0][1]=rgb[0][2]=0;
		
		for(int x=1;x<=N;x++) {
			dp[x][0]=min(dp[x-1][1],dp[x-1][2])+rgb[x][0];
			dp[x][1]=min(dp[x-1][0],dp[x-1][2])+rgb[x][1];
			dp[x][2]=min(dp[x-1][0],dp[x-1][1])+rgb[x][2];
		}
		System.out.println(min(min(dp[N][0],dp[N][1]),dp[N][2]));
	}

}
