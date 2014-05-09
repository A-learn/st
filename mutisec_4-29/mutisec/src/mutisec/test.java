package mutisec;

import java.util.Scanner;



public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner c= new Scanner(System.in);
		System.out.println("請輸入明文");
		String x=c.next();
		x=x.toUpperCase();
		Encryption p= new Encryption(x);
		System.out.println("請輸入密文");
		String x2=c.next();
		x2=x2.toUpperCase();
		De2 p2=new De2(x2);
		
		
	}
}
