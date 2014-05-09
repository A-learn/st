package threadpra;

//package com.ch07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class CounterServer {
String fileName = "counter.txt";
private static boolean  nextball=true;
public static  void  setb(boolean t){
	nextball=t;
}
public static boolean getb(){
	return nextball;
}
public void listen() {
  File file = new File(fileName);
  checkFile(file);
  int xxx=0;
  try {
    ServerSocket server = new ServerSocket(3335);
    while (true) {
      System.out.println("�����s�u��");
      Socket socket = server.accept();
      // ��ѫ���]�p��AddThread�B�z�����
      AddThread add = new AddThread(file);
      
      EchoThread echo = new EchoThread(socket);
      pitchadj pit =new pitchadj(socket);
      pitchgo pgo =new pitchgo(socket);
      add.start();
	  echo.start();
	  pit.start();
	  pgo.start();
	 
	 
    }
  } catch (IOException e) {
    e.printStackTrace();
    System.out.println("���A����X�J�o�Ϳ��~");
  }
}

public void checkFile(File file) {
  if (!file.exists()) {
    try {
      FileWriter out = new FileWriter(file, false);
      out.write("0\n");
      out.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class AddThread extends Thread {
  File file;

  public AddThread(File file) {
    this.file = file;
  }

  public void run() {
    synchronized (file) {
      System.out.println(getName() + "�s���ɮפ�");
      BufferedReader in = null;
      FileWriter out = null;
      try {
        in = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(in.readLine());
        in.close();
        n++;
        out = new FileWriter(file, false);
        out.write(String.valueOf(n) + "\n");
        out.flush();
        out.close();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println(getName() + "�����s��");
    }
  }
}

public static void main(String[] args) {
  CounterServer counter = new CounterServer();
  counter.listen();
}
}
