
public class NumExam {
	public static void anotherSum() {
		int num = 54321;
		int sum = 0;
		
		String s = String.valueOf(num);
		char[] c = s.toCharArray();
		
		for(int i=0;i<c.length;i++) {
			sum+=(int)c[i]-48;
		}
		System.out.println("sum = " + sum );
	}
	public static void bestSum() {
		int num = 54321;
		int sum = 0;
		
		while(num>0) {
			sum+=num%10;
			num/=10;
		}
		System.out.println("sum = " + sum );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		anotherSum();
	}

}
