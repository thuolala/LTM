package FinalReport;
import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UploadFile extends JFrame{
	private String hostName;
	private int portNo;
	private File[] files = new File[1];
	private Component fame = null;
	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadFile frame = new UploadFile();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * 
	 */
	
	public UploadFile() {
		setTitle("Upload File");
		setBounds(100, 100, 450, 350);
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(33, 51, 366, 124);
		getContentPane().add(textArea);
		
		JButton send = new JButton("Gửi");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(files[0] == null) {
					JOptionPane.showMessageDialog(fame, "Vui lòng chọn file", "Xác nhận", JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
						FileInputStream in = new FileInputStream(files[0].getAbsoluteFile());
						Socket client = new Socket("localhost", 2026);
						
						DataOutputStream out = new DataOutputStream(client.getOutputStream());
						
						//get name
						String name = files[0].getName();
						byte[] b = name.getBytes();
						
						//get length
						byte[] c = new byte[(int) files[0].length()];
						
						//in
						in.read(c);
						
						//out 
						out.writeInt(b.length);
						out.write(b);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		send.setFont(new Font("Times New Roman", Font.BOLD, 14));
		send.setBounds(165, 248, 89, 37);
		getContentPane().add(send);
		
		JButton choose = new JButton("Chọn");
		choose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setDialogTitle("Chọn file để gửi");
				
				if(file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					files[0] = file.getSelectedFile();
					String name = files[0].getName();
					JOptionPane.showMessageDialog(fame, "File bạn đã chọn là " + name, "Xác nhận", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		choose.setFont(new Font("Times New Roman", Font.BOLD, 14));
		choose.setBounds(310, 186, 89, 37);
		getContentPane().add(choose);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(33, 186, 267, 37);
		getContentPane().add(progressBar);
	}
}
