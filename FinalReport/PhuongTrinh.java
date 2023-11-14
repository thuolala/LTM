package FinalReport;
import java.awt.BorderLayout;
import java.net.*;
import java.util.Scanner;
import java.io.*;
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
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PhuongTrinh extends JFrame{
	private JTextField a1;
	private JTextField b1;
	private JTextField c1;
	private JTextField a2;
	private JTextField b2;
	private JTextField c2;
	private double x; 
	private double y;
	private JTextArea xRes; 
	private JTextArea yRes; 
	
	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhuongTrinh frame = new PhuongTrinh();
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
	
	public void checkInput() {
		if(a1.getText().isEmpty() || b1.getText().isEmpty() || c1.getText().isEmpty() || a2.getText().isEmpty() || b2.getText().isEmpty() || c2.getText().isEmpty()) {
			Component fame = null;
			JOptionPane.showMessageDialog(fame, "Vui lòng không nhập trống.", null, JOptionPane.WARNING_MESSAGE);	
		}
		else {
			double n1, n2, n3, n4, n5, n6 = 0.0;
			try {       
			    n1 = Double.valueOf(a1.getText());
			    n2 = Double.valueOf(b1.getText());
			    n3 = Double.valueOf(c1.getText());
			    n4 = Double.valueOf(a2.getText());
			    n5 = Double.valueOf(b2.getText());
			    n6 = Double.valueOf(c2.getText());
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			    Component fame = null;
			    JOptionPane.showMessageDialog(fame, "Vui lòng nhập số.", null, JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	public PhuongTrinh() {
		setTitle("Giải hệ phương trình bật nhất 2 ẩn x và y");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		getContentPane().setLayout(null);
		
		a1 = new JTextField();
		a1.setBounds(61, 98, 38, 37);
		a1.setColumns(10);
		
		b1 = new JTextField();
		b1.setBounds(138, 98, 38, 37);
		b1.setColumns(10);
		
		c1 = new JTextField();
		c1.setBounds(227, 98, 38, 37);
		c1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(" x   + ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(99, 97, 49, 37);
		getContentPane().setLayout(null);
		getContentPane().add(a1);
		getContentPane().add(b1);
		getContentPane().add(c1);
		getContentPane().add(lblNewLabel);
		
		JLabel lblY = new JLabel(" y   = ");
		lblY.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblY.setBounds(186, 97, 49, 37);
		getContentPane().add(lblY);
		
		xRes = new JTextArea();
		xRes.setBounds(314, 98, 82, 37);
		getContentPane().add(xRes);
		
		yRes = new JTextArea();
		yRes.setBounds(314, 160, 82, 37);
		getContentPane().add(yRes);
		
		JLabel lblX = new JLabel(" x   =");
		lblX.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblX.setBounds(275, 97, 49, 37);
		getContentPane().add(lblX);
		
		JLabel lblY_1 = new JLabel(" y   =");
		lblY_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblY_1.setBounds(275, 160, 49, 37);
		getContentPane().add(lblY_1);
		
		JLabel lblNewLabel_1 = new JLabel("Giải hệ phương trình bậc nhất 2 ẩn x và y");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(37, 28, 346, 45);
		getContentPane().add(lblNewLabel_1);
		
		JButton solve = new JButton("Giải");
		solve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Check input 
				checkInput();
				//PT 1
				double numA1 = Double.valueOf(a1.getText());
				double numB1 = Double.valueOf(b1.getText());
				double numC1 = Double.valueOf(c1.getText());
				//PT 2
				double numA2 = Double.valueOf(a2.getText());
				double numB2 = Double.valueOf(b2.getText());
				double numC2 = Double.valueOf(c2.getText()); 
				
				try {
					//result 
					//connect 
					Socket pt = new Socket("localhost", 2025);
					
					//tao inputstream chua ket qua tu server 
					Scanner in = new Scanner(pt.getInputStream());
					
					//tao outputstream chua word gui den server
					PrintWriter out;
					out = new PrintWriter(pt.getOutputStream(),true);		
					out.println(numA1);
					out.println(numB1);
					out.println(numC1);
					out.println(numA2);
					out.println(numB2);
					out.println(numC2);
					
					//lay result tu in
					String x = in.nextLine();
					String y = in.nextLine();
					xRes.setText(x);
					yRes.setText(y);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		solve.setFont(new Font("Times New Roman", Font.BOLD, 14));
		solve.setBounds(160, 224, 89, 37);
		getContentPane().add(solve);
		
		a2 = new JTextField();
		a2.setColumns(10);
		a2.setBounds(61, 160, 38, 37);
		getContentPane().add(a2);
		
		b2 = new JTextField();
		b2.setColumns(10);
		b2.setBounds(138, 162, 38, 37);
		getContentPane().add(b2);
		
		c2 = new JTextField();
		c2.setColumns(10);
		c2.setBounds(227, 162, 38, 37);
		getContentPane().add(c2);
		
		JLabel lblNewLabel_2 = new JLabel(" x   + ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(99, 160, 49, 37);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblY_2 = new JLabel(" y   = ");
		lblY_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblY_2.setBounds(186, 160, 49, 37);
		getContentPane().add(lblY_2);
		
		JLabel lblNewLabel_3 = new JLabel("{");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 55));
		lblNewLabel_3.setBounds(29, 73, 22, 146);
		getContentPane().add(lblNewLabel_3);
		
		JButton del = new JButton("Xóa");
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a1.setText("");
				b1.setText("");
				c1.setText("");
				a2.setText("");
				b2.setText("");
				c2.setText("");
				xRes.setText("");
				yRes.setText("");
			}
		});
		del.setFont(new Font("Times New Roman", Font.BOLD, 14));
		del.setBounds(259, 224, 89, 37);
		getContentPane().add(del);
		
		JButton menu = new JButton("Menu");
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu frame = new Menu();
				frame.setVisible(true);
			}
		});
		menu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		menu.setBounds(61, 224, 89, 37);
		getContentPane().add(menu);
	}
}
