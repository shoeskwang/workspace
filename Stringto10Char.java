package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Stringto10Char {
	public static void main(String[] args)throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		for(int i=0;i<len;i++){
			System.out.print(str.charAt(i));
			if((i+1)%10==0) System.out.println();
		}
	}

}
