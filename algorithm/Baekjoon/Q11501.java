package DP;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Q11501 {
	/*
	 * 문제
	홍준이는 요즘 주식에 빠져있다. 그는 미래를 내다보는 눈이 뛰어나, 날 별로 주가를 예상하고 언제나 그게 맞아떨어진다. 매일 그는 아래 세 가지 중 한 행동을 한다.
	
	주식 하나를 산다.
	원하는 만큼 가지고 있는 주식을 판다.
	아무것도 안한다.
	홍준이는 미래를 예상하는 뛰어난 안목을 가졌지만, 어떻게 해야 자신이 최대 이익을 얻을 수 있는지 모른다. 따라서 당신에게 날 별로 주식의 가격을 알려주었을 때, 최대 이익이 얼마나 되는지 계산을 해달라고 부탁했다.
	
	예를 들어 날 수가 3일이고 날 별로 주가가 10, 7, 6일 때, 주가가 계속 감소하므로 최대 이익은 0이 된다. 그러나 만약 날 별로 주가가 3, 5, 9일 때는 처음 두 날에 주식을 하나씩 사고, 마지막날 다 팔아 버리면 이익이 10이 된다.
	
	입력
	입력의 첫 줄에는 테스트케이스 수를 나타내는 자연수 T가 주어진다. 각 테스트케이스 별로 첫 줄에는 날의 수를 나타내는 자연수 N(2 ≤ N ≤ 1,000,000)이 주어지고, 둘째 줄에는 날 별 주가를 나타내는 N개의 자연수들이 공백으로 구분되어 순서대로 주어진다. 날 별 주가는 10,000이하다.
	
	출력
	각 테스트케이스 별로 최대 이익을 나타내는 정수 하나를 출력한다. 답은 부호있는 64bit 정수형으로 표현 가능하다.
	
	예제 입력 1 
	3
	3
	10 7 6
	3
	3 5 9
	5
	1 1 3 1 2
	예제 출력 1 
	0
	10
	5
	 * */

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = sc.nextInt();
		// 1. 테스트 케이스 수 만큼 반복
		while(t-->0){
			// 1.1 N일 동안 예측 주식 가격 입력
			int n = sc.nextInt();
			int[] intArr = new int[n];
			
			for(int j=0;j<n;j++){
				intArr[j]=sc.nextInt();
			}
			
			// 1.2 수익 계산 후 출력
			bw.write(getProfit(intArr.length,intArr)+"\n");
		}
		
		sc.close();
		bw.flush();
		bw.close();
}	
	
	// start변수 날짜로부터 가장 주식의 가경이 비싼 날짜 찾기
		public static int getMaxIndex(int start, int[] arrList){
			int idx=start;
			int maxVal = arrList[start];
			
			for(int i=start;i<arrList.length;i++){
				if(arrList[i]>maxVal){
					idx=i;
					maxVal=arrList[i];
				}
			}
			return idx;
		}
		 
		// 최고의 수익 계산 처리
		public static int getProfit(int n, int[] arrList){
			int profit=0;
			int idx=0;
			int stock=0;
			
			while(idx<n){
				int maxIdx = getMaxIndex(idx, arrList);
				
				//가장 큰 수익을 낼수 있는날까지 구매하고 판매하는 처리
				if(maxIdx>idx){
					for(int i=idx;i<maxIdx;i++){
						profit -= arrList[i];
						stock++;
					}
					profit += arrList[maxIdx]*stock;
					stock=0;
					
					idx=maxIdx+1;
				}else{
					//수익이 날 수 없는 경우 패스
					idx++;
				}
			}
			
			return profit;
		}

}
