package threadpra;

import java.io.BufferedReader;
import	java.io.IOException;
import	java.io.InputStreamReader;
import	java.io.OutputStreamWriter;
import	java.io.PrintWriter;
import	java.net.Socket;

public	class EchoThread extends Thread
{
	BufferedReader in;
    PrintWriter out;

   public EchoThread(Socket ss) throws IOException{
	in=new BufferedReader(new InputStreamReader(ss.getInputStream()));
	out=new PrintWriter(new OutputStreamWriter(ss.getOutputStream()));
	}
   private String rec,rec2;
   public void run()
   {
		try {
			rec=in.readLine();
			System.out.println(rec);
			
			out.println("*球5秒後到達*");
			out.flush();
			sleep(5000);
			out.println("*ball come*");
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){
			try {
				rec2=in.readLine();
				System.out.println(rec2);
				if(rec2.equals("0")==true){
					out.println("槍! 打擊出去");
					out.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
   }
		
}