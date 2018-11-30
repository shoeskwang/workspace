package Algo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*문제
2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오. 배열의 (i, j) 위치는 i행 j열을 나타낸다.

입력
첫째 줄에 배열의 크기 N, M(1 ≤ N, M ≤ 300)이 주어진다. 다음 N개의 줄에는 M개의 정수로 배열이 주어진다. 배열에 포함되어 있는 수는 절댓값이 10,000보다 작거나 같은 정수이다. 그 다음 줄에는 합을 구할 부분의 개수 K(1 ≤ K ≤ 10,000)가 주어진다. 다음 K개의 줄에는 네 개의 정수로 i, j, x, y가 주어진다(i ≤ x, j ≤ y).

input

2 3
1 2 4
8 16 32
3
1 1 2 3
1 2 1 2
1 3 2 3

output

63
2
36

*
*/
public class sumArray {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] arr = new int[N+1][M+1];
		
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<M+1;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		int K = sc.nextInt();
		int[][] test = new int[K][4];
		
		for(int i=0;i<K;i++){
			for(int j=0;j<4;j++){
				test[i][j]=sc.nextInt();
			}
		}
		int idx=0;
		int sum=0;
		int i,j,x,y;
		while(K-->0) {
			i=test[idx][0];
			j=test[idx][1];
			x=test[idx][2];
			y=test[idx][3];
			
			for(int a=i;a<=x;a++) {
				for(int b=j;b<=y;b++) {
					sum+=arr[a][b];
				}
			}
			bw.write(sum+"\n");
			sum=0;
			idx++;
		}
		bw.flush();
		bw.close();
	}

}
