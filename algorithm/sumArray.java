package Algo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*����
2���� �迭�� �־����� �� (i, j) ��ġ���� (x, y) ��ġ������ ����Ǿ� �ִ� ������ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. �迭�� (i, j) ��ġ�� i�� j���� ��Ÿ����.

�Է�
ù° �ٿ� �迭�� ũ�� N, M(1 �� N, M �� 300)�� �־�����. ���� N���� �ٿ��� M���� ������ �迭�� �־�����. �迭�� ���ԵǾ� �ִ� ���� ������ 10,000���� �۰ų� ���� �����̴�. �� ���� �ٿ��� ���� ���� �κ��� ���� K(1 �� K �� 10,000)�� �־�����. ���� K���� �ٿ��� �� ���� ������ i, j, x, y�� �־�����(i �� x, j �� y).

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
