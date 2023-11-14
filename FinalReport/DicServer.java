package FinalReport;
import java.io.*;
import java.net.*;
import java.util.*;
 
public class DicServer {
	public static void main(String[] args) {
		try{
			final ServerSocket svr = new ServerSocket(2022);
			System.out.println("Server listening on port 2022...");
			while(true){
				Socket d = svr.accept();
				new Thread(new DicRunnable(d)).start();
			}
		}catch(Exception ex){
		ex.printStackTrace();
		}
	}
}
	 
	class DicRunnable implements Runnable{
		Socket client = null;
		DicRunnable(Socket client){
			this.client = client;
		}
	@Override
	public void run() {
	try {
		//lay word tu client
		InputStream is = client.getInputStream();
		Scanner in = new Scanner(is);
		
		//tra ket qua
		OutputStream os = client.getOutputStream();
		PrintWriter out = new PrintWriter(os,true/*auto-flush*/);
		while(in.hasNextLine()){
			String word = in.nextLine();
			String result = returnValue(word);
			out.println(result);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
	}
	private String returnValue(String s) {
		Map<String, String> dic = new HashMap<String, String>();
		dic.put("con chó", "dog");
		dic.put("con mèo", "cat");
		dic.put("con gà", "chicken");
		dic.put("con vịt", "duck");
		dic.put("con heo", "pig");
		dic.put("con cáo", "fox");
		dic.put("con gấu", "bear");
		dic.put("con voi", "elephant");
		dic.put("con sư tử", "lion");
		dic.put("con nhím", "porcupine"); 
		
		String result = "";
		
		//Khoi tao ArrayList chua key
		List<String> keyL = new ArrayList<String>(dic.keySet());
		
		//Khoi tao ArrayList chua value
		List<String> valueL = new ArrayList<String>();
		for(String key1 : keyL) {
			valueL.add(dic.get(key1));
		}
		
		try {
			//Check neu input rong thi yeu cau nhap lai
			//Check neu list key chua word thi lay ra value tuong ung tu key
			for(String key : keyL) {
				if(key.contains(s)){
					result += dic.get(key);
				}
			}
			
			//Hoac lay ra key tuong ung tu value
			for(String value :valueL) {
				if(value.contains(s)){
					result += keyL.get(valueL.indexOf(value));
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();	
		}
		return result;
	}
}

