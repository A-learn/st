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
//送出"Hello"字串






//停頓5秒,可依需求加長時間



//讀取伺服器EchoServer送來的回音字串,並印出
//String rec =in.readLine();
//System.out.println("伺服器傳來:"+rec);
//Scanthr scan=new Scanthr();
//scan.start();

//System.out.println("輸入的是: "+Scanthr.cc);
//while(true){
//	rec =in.readLine();
//System.out.println("  "+rec);
//
//}
}catch(IOException e)
	{}
		

	}
}
