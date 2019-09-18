
public class BinaryExam {
	
	public static StringBuffer get8BitString(StringBuffer sb) {
		int len = sb.length();
		
		while(len++<8) {
			sb.insert(0, '0');
		}
		return sb;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i =23;
		int j = i<<1;
		
		StringBuffer sb = new StringBuffer(Integer.toBinaryString(i));
		System.out.println("decimal : " + i);
		System.out.println(sb.toString());
		System.out.println(sb.length());
		
		System.out.println(get8BitString(sb).toString());
		
		sb = new StringBuffer(Integer.toBinaryString(j));
		System.out.println("decimal : " + j);
		System.out.println(sb.toString());
		System.out.println(sb.length());
		
		System.out.println(get8BitString(sb).toString());
	}	

}
