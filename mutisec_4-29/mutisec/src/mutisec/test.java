package mutisec;

import java.util.Scanner;



public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner c= new Scanner(System.in);
		System.out.println("�п�J����");
		String x=c.next();
		x=x.toUpperCase();
		Encryption p= new Encryption(x);
		System.out.println("�п�J�K��");
		String x2=c.next();
		x2=x2.toUpperCase();
		De2 p2=new De2(x2);
		
		
	}
}
