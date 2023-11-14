package FinalReport;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.TextArea;
 
public class FTPServer{
	public FTPServer() {
	}
		
	private static int portNo = 2026;
	public static void main(String[] args) {
		try{
			final ServerSocket svr = new ServerSocket(portNo);
			System.out.println("Server listening on port " + Integer.toString(portNo) + " . . .");
			while(true){
				Socket d = svr.accept();
				new Thread(new DicRunnable(d)).start();
			}
		}catch(Exception ex){
		ex.printStackTrace();
		}
	
}
	 
	class FTPRunnable implements Runnable{
		Socket client = null;
		FTPRunnable(Socket client){
			this.client = client;
		}
	@Override
	public void run() {
	try {
		//
		DataInputStream in = new DataInputStream(client.getInputStream());
		int n = in.readInt();
		if(n > 0) {
			byte[] file = new byte[n];
			in.readFully(file, 0, n);
			String name = file.getClass().getName();
			
			int con = in.readInt();
			if(con > 0) {
				byte[] file1 = new byte[con]; 
				in.readFully(file1, 0, con);
			}
			//System.out.println("Server đã nhận được file " + name);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
	}
}
}

