package FinalReport;
import java.io.*;
import java.net.*;
import java.util.*;
 
public class CalServer {
	public static void main(String[] args) {
		try{
			final ServerSocket svr = new ServerSocket(2023);
			System.out.println("Server listening on port 2023...");
			while(true){
				Socket d = svr.accept();
				new Thread(new CalRunnable(d)).start();
			}
		}catch(Exception ex){
		ex.printStackTrace();
		}
	}
}
	 
	class CalRunnable implements Runnable{
		Socket client = null;
		CalRunnable(Socket client){
			this.client = client;
		}
	@Override
	public void run() {
	try {
		//lay input tu client
		InputStream is = client.getInputStream();
		Scanner in = new Scanner(is);
		
		//tra ket qua
		OutputStream os = client.getOutputStream();
		PrintWriter out = new PrintWriter(os,true/*auto-flush*/);
		while(in.hasNextLine()){
			double a = Double.parseDouble(in.nextLine());
			double b = Double.parseDouble(in.nextLine());
			String op = in.nextLine();
			double result = returnValue(a, b, op);
			String res = Double.toString(result);
			out.println(res);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
	}
	private double returnValue(double a, double b, String op) {
		double result = 0.0;
		if(op.equals("+")) {
			result = a + b;
		}
		else if(op.equals("-")) {
			result = a - b;
		}
		else if(op.equals("x") || op.equals("*")) {
			result = a * b;
		}
		else if(op.equals(":") || op.equals("/")) {
			result = (double) a / b;
		}
		return result;
	}
}

