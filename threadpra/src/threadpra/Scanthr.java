package threadpra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Scanthr extends Thread{
	BufferedReader in;
    PrintWriter out;
	public Scanthr(Socket ss) throws IOException {
		// TODO Auto-generated method stub
		in=new BufferedReader(new InputStreamReader(ss.getInputStream()));
		out=new PrintWriter(new OutputStreamWriter(ss.getOutputStream()));
	}
	private static String cc;
	private String rec;
	 public void run(){
		 out.println("Hello");
		 out.flush();
		 System.out.println("已送出Hello");
		 
		 while(true){
			
			 try {
				rec = in.readLine();
			 } catch (IOException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }
			 System.out.println("伺服器端收到:"+rec);
		 }
//		 Scanner c=new Scanner(System.in);
//		 cc=c.next();
//		 System.out.println("��J���O: "+cc);
	 }
//	 public String gets(){
//		 return  cc;
//	 }

}
