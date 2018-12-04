package Algo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 10250��
// https://www.acmicpc.net/problem/10250

/*ACM ȣ�� �Ŵ��� ����� �մ��� �����ϴ� ��� �� ���� �����ϰ� �ִ�. �� �������翡 ������ �մԵ��� ȣ�� �������κ��� �ɾ ���� ª�� �Ÿ��� �ִ� ���� ��ȣ�Ѵٰ� �Ѵ�. �������� ���츦 ���� �� ���α׷��� �ۼ��ϰ��� �Ѵ�. �� �������� ��� ��� ȣ�� �������κ��� �ȴ� �Ÿ��� ���� ª���� ���� �����ϴ� ���α׷��� �ۼ��ϰ��� �Ѵ�.

������ �ܼ�ȭ�ϱ� ���ؼ� ȣ���� ���簢�� ����̶�� ��������. �� ���� W ���� ���� �ִ� H �� �ǹ��̶�� �������� (1 �� H, W �� 99). �׸��� ���������ʹ� ���� ���ʿ� �ִٰ� ��������(�׸� 1 ����). �̷� ������ ȣ���� H �� W ���� ȣ���̶�� �θ���. ȣ�� ������ ���� ���������� �ٷ� �տ� �ִµ�, �������� ���������ͱ����� �Ÿ��� �����Ѵ�. �� ��� ������ �� �� ������ �Ÿ��� ���� �Ÿ�(�Ÿ� 1)��� �����ϰ� ȣ���� ���� �ʿ��� ���� �ִٰ� �����Ѵ�.
input
2
6 12 10
30 50 72

output
402
1203*/

public class ACMHotel {
	static int getRoomNumber(int h,int w, int k) {
		if(k%h==0) return h*100+k/h;
		return k%h*100+k/h+1;
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();
		
		int H,W,K;
		while(N-->0) {
			H=sc.nextInt();
			W=sc.nextInt();
			K=sc.nextInt();
			bw.write(getRoomNumber(H, W, K)+"\n");
		}
		bw.flush();
		bw.close();
	}

}
