package FinalReport;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Dictionary extends JFrame{
	private JTextField text;
	private JTextArea res;
	
	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dictionary frame = new Dictionary();
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
	public Dictionary() {
		setTitle("Dictionary");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập từ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(66, 37, 69, 28);
		getContentPane().add(lblNewLabel);
		
		text = new JTextField();
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setBounds(29, 76, 132, 66);
		getContentPane().add(text);
		text.setColumns(10);
		
		JLabel lblKtQu = new JLabel("Kết quả");
		lblKtQu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblKtQu.setBounds(307, 37, 60, 28);
		getContentPane().add(lblKtQu);
		
		JButton trans = new JButton("Dịch");
		trans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//
					String word = text.getText(); 
					String result = "";
					
					if(word.length() == 0){
						result += "";
						res.setText(result);
						JOptionPane.showMessageDialog(null, "Vui lòng nhập từ hoặc từ không có trong từ điển.");
					}
					//Neu khong rong
					else {
						//connect 
						Socket dic = new Socket("localhost", 2022);
						
						//tao inputstream chua ket qua tu server 
						Scanner in = new Scanner(dic.getInputStream());
						
						//tao outputstream chua word gui den server
						PrintWriter out = new PrintWriter(dic.getOutputStream(),true);
						out.println(word);
						
						//lay result tu in
						result = in.nextLine();
						res.setText(result);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		trans.setFont(new Font("Times New Roman", Font.BOLD, 14));
		trans.setBounds(171, 67, 86, 39);
		getContentPane().add(trans);
		
		res = new JTextArea();
		res.setColumns(2);
		res.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		res.setBounds(267, 76, 138, 66);
		getContentPane().add(res);
		
		JButton back = new JButton("Menu");
		back.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // TODO Auto-generated method stub
				 	Menu frame = new Menu();
				 	frame.setVisible(true);
	            }
		});
		back.setFont(new Font("Times New Roman", Font.BOLD, 14));
		back.setBounds(171, 211, 86, 39);
		getContentPane().add(back);
		
		JButton del = new JButton("Xóa");
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String word = text.getText(); 
				String result = "";
				
				text.setText("");
				res.setText("");
			}
		});
		del.setFont(new Font("Times New Roman", Font.BOLD, 14));
		del.setBounds(171, 117, 86, 39);
		getContentPane().add(del);
		}
}
