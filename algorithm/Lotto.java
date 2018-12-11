package Algo;

public class Lotto {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 6;
		int[] a = new int[N];
		boolean chk = false;
		int temp;
		for(int i=0;i<N;i++) {
			chk=false;
			temp =(int)(Math.random()*46)+1;
			
			for(int j=0;j<i;j++){
				if(temp == a[j]) {
					i--;
					chk=true;
					break;
				}
			}
			
			if(!chk) {
				a[i]=temp;
			}
		}
		
		for (int i : a) {
			System.out.print(i+" ");
		}
		
	}

}
