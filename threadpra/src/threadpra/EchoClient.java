package threadpra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
public	static	void main(String[] args)
{
	BufferedReader in;
    PrintWriter out;
try
{ Socket s = new Socket("localhost",3335);
Scanthr thr1=new Scanthr(s);
thr1.start();

in=new BufferedReader(new InputStreamReader(s.getInputStream()));
out=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));



while(true){
	Scanner c=new Scanner(System.in);
	String cc=c.next();
	out.println(cc);
	out.flush();
}
//	BufferedReader in= new BufferedReader( new InputStreamReader(s.getInputStream()));
//	PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
//	Scanner c=new Scanner(System.in);
//�e�X"Hello"�r��






//���y5��,�i�̻ݨD�[���ɶ�



//Ū�����A��EchoServer�e�Ӫ��^���r��,�æL�X
//String rec =in.readLine();
//System.out.println("���A���Ǩ�:"+rec);
//Scanthr scan=new Scanthr();
//scan.start();

//System.out.println("��J���O: "+Scanthr.cc);
//while(true){
//	rec =in.readLine();
//System.out.println("  "+rec);
//
//}
}catch(IOException e)
	{}
		

	}
}
