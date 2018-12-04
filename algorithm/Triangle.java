package Algo;

import java.util.Scanner;
/*문제
7
3   8
8   1   0
2   7   4   4
4   5   2   6   5
위 그림은 크기가 5인 정수 삼각형의 한 모습이다.

맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라. 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.

삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.*/

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
