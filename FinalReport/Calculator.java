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
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Calculator extends JFrame{
	private JTextField num1;
	private JTextField num2;
	private JTextField operator;
	private JTextArea res;
	
	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {
		setTitle("Calculator");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập số ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(46, 80, 69, 28);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập số ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(192, 80, 69, 28);
		getContentPane().add(lblNewLabel_1);
		
		num1 = new JTextField();
		num1.setHorizontalAlignment(SwingConstants.CENTER);
		num1.setBounds(29, 119, 86, 39);
		getContentPane().add(num1);
		num1.setColumns(10);
		
		num2 = new JTextField();
		num2.setHorizontalAlignment(SwingConstants.CENTER);
		num2.setColumns(10);
		num2.setBounds(175, 119, 86, 39);
		getContentPane().add(num2);
		
		operator = new JTextField();
		operator.setHorizontalAlignment(SwingConstants.CENTER);
		operator.setBounds(125, 119, 40, 39);
		getContentPane().add(operator);
		operator.setColumns(10);
		 
		JLabel lblKtQu = new JLabel("Kết quả");
		lblKtQu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblKtQu.setBounds(332, 80, 60, 28);
		getContentPane().add(lblKtQu);
		
		JButton cal = new JButton("=");
		cal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//check rong 
					/*if(num1.getText() == null || num2.getText() == null || operator.getText() == null) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập phép tính '+', '-', 'x', '*', ':' hoặc '/'");
						res.setText("");
					}*/
					double n1 = Double.valueOf(num1.getText());
					double n2 = Double.valueOf(num2.getText());
					double n = 0.0;
					String op = operator.getText();
					String result = "";
					
					//connect 
					Socket cal = new Socket("localhost", 2023);
					
					//tao inputstream chua ket qua tu server 
					Scanner in = new Scanner(cal.getInputStream());
					
					//tao outputstream chua word gui den server
					PrintWriter out = new PrintWriter(cal.getOutputStream(),true);
					out.println(n1);
					out.println(n2);
					out.println(op);
					
					//lay result tu in
					result = in.nextLine();
					res.setText(result);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		cal.setFont(new Font("Times New Roman", Font.BOLD, 10));
		cal.setBounds(271, 120, 40, 39);
		getContentPane().add(cal);
		
		res = new JTextArea();
		res.setColumns(2);
		res.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		res.setBounds(321, 119, 86, 39);
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
		back.setBounds(164, 195, 97, 39);
		getContentPane().add(back);
		
		JButton del = new JButton("Xóa");
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1.setText("");
				num2.setText("");
				operator.setText("");
				res.setText("");
			}
		});
		del.setFont(new Font("Times New Roman", Font.BOLD, 14));
		del.setBounds(321, 164, 86, 39);
		getContentPane().add(del);
	}
}
