package FinalReport;
import java.io.*;
import java.net.*;
import java.util.*;
 
public class PTServer {
	public static void main(String[] args) {
		try{
			final ServerSocket svr = new ServerSocket(2025);
			System.out.println("Server listening on port 2025...");
			while(true){
				Socket d = svr.accept();
				new Thread(new PTRunnable(d)).start();
			}
		}catch(Exception ex){
		ex.printStackTrace();
		}
	}
}
	 
	class PTRunnable implements Runnable{
		Socket client = null;
		PTRunnable(Socket client){
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
			//1st
			double a1 = Double.parseDouble(in.nextLine());
			double b1 = Double.parseDouble(in.nextLine());
			double c1 = Double.parseDouble(in.nextLine());
			//2nd
			double a2 = Double.parseDouble(in.nextLine());
			double b2 = Double.parseDouble(in.nextLine());
			double c2 = Double.parseDouble(in.nextLine());
			
			//output 
			String result = "";
			result = returnValue(a1, b1, c1, a2, b2, c2);
			out.println(result);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
	}
	private String returnValue(double a1, double b1, double c1, double a2, double b2, double c2) {
		String result = ""; 
		double x = 0;
		double y = 0;
		String s1, s2, s3, s4 = "";
		
		//Processing
		double a = 0; 
		double b = 0;
		double c = 0;
		double ax = 0; 
		double by = 0;
		
		//check case 
		double checkA = (double) a1 / a2; 
		double checkB = (double) b1 / b2; 
		double checkC = (double) c1 / c2; 
		
		//Case 1: He pt co 1 nghiem duy nhat: a1/a2 # b1/b2 
		if(checkA != checkB) {
			//Cach 1: Cong dai so khi a1 + a2 = 0 || a1 - a2 = 0 || b1 + b2 = 0 || b1 - b2 = 0
			if(a1 + a2 == 0 || a1 - a2 == 0 || b1 + b2 == 0 || b1 - b2 == 0) {
				if(a1 + a2 == 0) {
					a = 0;
					b = b1 + b2;
					c = c1 + c2;
					y = (double) c / b;
					x = (double) (c2 - b2*y) / (a2);
				}
				if(a1 - a2 == 0) {
					a = 0;
					b = b1 - b2;
					c = c1 - c2;
					y = (double) c / b;
					x = (double) (c2 - b2*y) / (a2);
				}
				if(b1 + b2 == 0) {
					a = a1 + a2;
					b = 0;
					c = c1 + c2;
					x = (double) c / a;
					y = (double) (c2 - a2*x) / (b2);
				}
				if(b1 - b2 == 0) {
					a = a1 - a2;
					b = 0;
					c = c1 - c2;
					x = (double) c / a;
					y = (double) (c2 - a2*x) / (b2);
				}
				result += Double.toString(x) + "\n" + Double.toString(y);
			}
			//Cach 2: Dung phuong phap the, dat x hoac y.
				//Neu dat x: x = (c - by) / a
				//Neu dat y: y = (c - ax) / b
			else if(a1 + a2 != 0 && a1 - a2 != 0 && b1 + b2 != 0 && b1 - b2 != 0) {
				if(a1 + a2 != 0 && a1 - a2 != 0) {
					if(a1 < a2) {
						y = (double) (c2 * a1 - a2 * c1) / (-a2 * b1 + a1 * b2);
						x = (double) (c1 - b1 * y) / a1;
					} 
					else {
						y = (double) (c1 * a2 - a1 * c2) / (-a1 * b2 + a2 * b1);
						x = (double) (c2 - b2 * y) / a2; 
					}
				}
				result += Double.toString(x) + "\n" + Double.toString(y);
			}
		}
		//Case 2: He pt vo nghiem: a1/a2 = b1/b2 # c1/c2 
		else if(checkA == checkB && checkB != checkC || checkA != checkC) {
			s1 = "Không có nghiệm.";
			s2 = "Không có nghiệm.";
			result += s1 + "\n" + s2;
		}
		//Case 3: He pt co vo so nghiem: a1/a2 = b1/b2 = c1/c2 
		else if(checkA == checkB && checkB == checkC && checkA == checkC) {
			s3 = "Vô số nghiệm.";
			s4 = "Vô số nghiệm.";
			result += s3 + "\n" + s4;
		}
		//
		System.out.println(result);
		return result;
	}
}

