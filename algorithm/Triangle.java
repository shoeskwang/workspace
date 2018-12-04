package Algo;

import java.util.Scanner;
/*����
7
3   8
8   1   0
2   7   4   4
4   5   2   6   5
�� �׸��� ũ�Ⱑ 5�� ���� �ﰢ���� �� ����̴�.

�� ���� 7���� �����ؼ� �Ʒ��� �ִ� �� �� �ϳ��� �����Ͽ� �Ʒ������� ������ ��, �������� ���õ� ���� ���� �ִ밡 �Ǵ� ��θ� ���ϴ� ���α׷��� �ۼ��϶�. �Ʒ����� �ִ� ���� ���� ������ ���õ� ���� �밢�� ���� �Ǵ� �밢�� �����ʿ� �ִ� �� �߿����� ������ �� �ִ�.

�ﰢ���� ũ��� 1 �̻� 500 �����̴�. �ﰢ���� �̷�� �ִ� �� ���� ��� �����̸�, ������ 0 �̻� 9999 �����̴�.*/

/*
input
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5

output
30
*/
public class Triangle {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] n = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=i;j++) {
				n[i][j]=sc.nextInt();
			}
		}
		
		
		int[][] dp = new int[N+1][N+1];
		dp[1][1]=n[1][1];
		for(int i=1;i<N;i++) {
			for(int j=1;j<=i;j++) {
				if(dp[i+1][j]<dp[i][j]+n[i+1][j]) {
					dp[i+1][j]=dp[i][j]+n[i+1][j];
				}
				if(dp[i+1][j+1]<dp[i][j]+n[i+1][j+1]) {
					dp[i+1][j+1]=dp[i][j]+n[i+1][j+1];
				}
			}
		}
		int max=dp[N][1];
		for(int a=2;a<=N;a++) {
			if(max<dp[N][a]) max = dp[N][a];
		}
		System.out.println(max);
	}

}
