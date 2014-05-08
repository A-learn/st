package threadpra;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class EchoServer {
public static void main(String[] args)
{ try
	{ 
	ServerSocket server =new ServerSocket(3335);

	while(true)
		{System.out.println("接收連線中..");

		Socket socket =server.accept();	//��ѫ���]�p��AddThread�B�z�����

		EchoThread add=new EchoThread(socket);
		System.out.println(" "+add.getName());
		add.start();
		}
	 
	}
catch(IOException e){
	e.printStackTrace();
	System.out.println("IO錯誤");
	}

}

}
