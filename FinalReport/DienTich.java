package FinalReport;
import java.awt.BorderLayout;
import java.awt.*;
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
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;

public class DienTich extends JFrame{
	public static final double pi = 3.14159265358979323846;
	private JTextField ahv;
	private JTextField ahcn;
	private JTextField bhcn;
	private JTextField ahbh;
	private JTextField hhbh;
	private JTextField ahtg;
	private JTextField hhtg;
	private JTextField d1;
	private JTextField d2;
	private JTextField r;
	private JTextField d;
	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DienTich frame = new DienTich();
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
	
	/*public void checkInput() {
		if(ahv.getText().isEmpty()  || 
		   ahcn.getText().isEmpty() || bhcn.getText().isEmpty() || 
		   ahbh.getText().isEmpty() || hhbh.getText().isEmpty() || 
		   ahtg.getText().isEmpty() || hhtg.getText().isEmpty() ||
		   d1.getText().isEmpty()   || d2.getText().isEmpty()   ||
		   r.getText().isEmpty()) {
			//Show message
			Component fame = null;
			JOptionPane.showMessageDialog(fame, "Vui lòng không nhập trống.", null, JOptionPane.WARNING_MESSAGE);	
		}
	}*/
	
	public DienTich() {			
		setTitle("Tính diện tích hình học");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 552, 400);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		//Hinh vuong
		JPanel hv = new JPanel();
		tabbedPane.addTab("Hình vuông", null, hv, null);  
		hv.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("S = a x a ");
		lblNewLabel.setBounds(178, 23, 145, 48);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		hv.add(lblNewLabel);
		
		JLabel lblACnhHnh = new JLabel("a: cạnh hình vuông");
		lblACnhHnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblACnhHnh.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblACnhHnh.setBounds(178, 52, 145, 48);
		hv.add(lblACnhHnh);
		
		JLabel lblNhpCnh = new JLabel("Nhập cạnh:");
		lblNhpCnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpCnh.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhpCnh.setBounds(45, 125, 145, 48);
		hv.add(lblNhpCnh);
		
		ahv = new JTextField();
		ahv.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ahv.setHorizontalAlignment(SwingConstants.CENTER);
		ahv.setBounds(76, 165, 86, 83);
		hv.add(ahv);
		ahv.setColumns(10);
		
		JTextArea Shv = new JTextArea();
		Shv.setBounds(328, 165, 135, 83);
		hv.add(Shv);
		
		JButton calhv = new JButton("Tính");
		calhv.setFont(new Font("Times New Roman", Font.BOLD, 14));
		calhv.setBounds(204, 165, 89, 35);
		hv.add(calhv);
		calhv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//checkInput();
				double aHV = Double.valueOf(ahv.getText());
				double SHV = 0.0;
				SHV = aHV * aHV; 
				Shv.setText(Double.toString(SHV));
			}
		});
		
		JLabel lblKtQu = new JLabel("Kết quả:");
		lblKtQu.setHorizontalAlignment(SwingConstants.CENTER);
		lblKtQu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblKtQu.setBounds(318, 125, 145, 48);
		hv.add(lblKtQu);
		
		JButton delhv = new JButton("Xóa");
		delhv.setFont(new Font("Times New Roman", Font.BOLD, 14));
		delhv.setBounds(204, 213, 89, 35);
		hv.add(delhv);
		delhv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ahv.setText("");
				Shv.setText("");
			}
		});
		
		//Hinh chu nhat
		JPanel hcn = new JPanel();
		tabbedPane.addTab("Hình chữ nhật", null, hcn, null);
		hcn.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("S = a x b ");
		lblNewLabel1.setBounds(178, 23, 145, 48);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		hcn.add(lblNewLabel1);
		
		JLabel lblACnhHnh1a = new JLabel("a: chiều dài");
		lblACnhHnh1a.setHorizontalAlignment(SwingConstants.CENTER);
		lblACnhHnh1a.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblACnhHnh1a.setBounds(178, 52, 145, 48);
		hcn.add(lblACnhHnh1a);
		
		JLabel lblACnhHnh1b = new JLabel("b: chiều rộng");
		lblACnhHnh1b.setHorizontalAlignment(SwingConstants.CENTER);
		lblACnhHnh1b.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblACnhHnh1b.setBounds(178, 82, 145, 48);
		hcn.add(lblACnhHnh1b);
		
		JLabel lblNhpCnh1a = new JLabel("Nhập chiều dài:");
		lblNhpCnh1a.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpCnh1a.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhpCnh1a.setBounds(49, 125, 145, 48);
		hcn.add(lblNhpCnh1a);
		
		JLabel lblNhpCnh1b = new JLabel("Nhập chiều rộng:");
		lblNhpCnh1b.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpCnh1b.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhpCnh1b.setBounds(49, 200, 145, 48);
		hcn.add(lblNhpCnh1b);
		
		ahcn = new JTextField();
		ahcn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ahcn.setHorizontalAlignment(SwingConstants.CENTER);
		ahcn.setBounds(79, 165, 86, 35);
		hcn.add(ahcn);
		ahcn.setColumns(10);
		
		JTextArea Shcn = new JTextArea();
		Shcn.setBounds(328, 165, 135, 111);
		hcn.add(Shcn);
		
		JButton calhcn = new JButton("Tính");
		calhcn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		calhcn.setBounds(204, 180, 89, 35);
		hcn.add(calhcn);
		calhcn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//checkInput();
				double aHCN = Double.valueOf(ahcn.getText());
				double bHCN = Double.valueOf(bhcn.getText());
				double SHCN = 0.0;
				SHCN = aHCN * bHCN; 
				Shcn.setText(Double.toString(SHCN));
			}
		});
		
		JLabel lblKtQu1 = new JLabel("Kết quả:");
		lblKtQu1.setHorizontalAlignment(SwingConstants.CENTER);
		lblKtQu1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblKtQu1.setBounds(318, 125, 145, 48);
		hcn.add(lblKtQu1);
		
		JButton delhcn = new JButton("Xóa");
		delhcn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ahcn.setText("");
				bhcn.setText("");
				Shcn.setText("");
			}
		});
		delhcn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		delhcn.setBounds(204, 229, 89, 35);
		hcn.add(delhcn);
		
		bhcn = new JTextField();
		bhcn.setHorizontalAlignment(SwingConstants.CENTER);
		bhcn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		bhcn.setColumns(10);
		bhcn.setBounds(79, 241, 86, 35);
		hcn.add(bhcn);
		
		//Hinh binh hanh
		JPanel hbh = new JPanel();
		tabbedPane.addTab("Hình bình hành", null, hbh, null);
		hbh.setLayout(null);
		
		JLabel lblNewLabel2 = new JLabel("S = a x h ");
		lblNewLabel2.setBounds(178, 23, 145, 48);
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		hbh.add(lblNewLabel2);
		
		JLabel lblACnhHnh2a = new JLabel("a: cạnh đáy");
		lblACnhHnh2a.setHorizontalAlignment(SwingConstants.CENTER);
		lblACnhHnh2a.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblACnhHnh2a.setBounds(178, 52, 145, 48);
		hbh.add(lblACnhHnh2a);
		
		JLabel lblACnhHnh2b = new JLabel("h: đường cao");
		lblACnhHnh2b.setHorizontalAlignment(SwingConstants.CENTER);
		lblACnhHnh2b.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblACnhHnh2b.setBounds(178, 82, 145, 48);
		hbh.add(lblACnhHnh2b);
		
		JLabel lblNhpCnh2a = new JLabel("Nhập cạnh đáy:");
		lblNhpCnh2a.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpCnh2a.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhpCnh2a.setBounds(49, 125, 145, 48);
		hbh.add(lblNhpCnh2a);
		
		JLabel lblNhpCnh2b = new JLabel("Nhập đường cao:");
		lblNhpCnh2b.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpCnh2b.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhpCnh2b.setBounds(49, 200, 145, 48);
		hbh.add(lblNhpCnh2b);
		
		ahbh = new JTextField();
		ahbh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ahbh.setHorizontalAlignment(SwingConstants.CENTER);
		ahbh.setBounds(79, 165, 86, 35);
		hbh.add(ahbh);
		ahbh.setColumns(10);
		
		JTextArea Shbh = new JTextArea();
		Shbh.setBounds(328, 165, 135, 111);
		hbh.add(Shbh);
		
		hhbh = new JTextField();
		hhbh.setHorizontalAlignment(SwingConstants.CENTER);
		hhbh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		hhbh.setColumns(10);
		hhbh.setBounds(79, 241, 86, 35);
		hbh.add(hhbh);
		
		JButton calhbh = new JButton("Tính");
		calhbh.setFont(new Font("Times New Roman", Font.BOLD, 14));
		calhbh.setBounds(204, 180, 89, 35);
		hbh.add(calhbh);
		calhbh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//checkInput();
				double aHBH = Double.valueOf(ahbh.getText());
				double hHBH = Double.valueOf(hhbh.getText());
				double SHBH = 0.0;
				SHBH = aHBH * hHBH; 
				Shbh.setText(Double.toString(SHBH));
			}
		});
		
		JLabel lblKtQu2 = new JLabel("Kết quả:");
		lblKtQu2.setHorizontalAlignment(SwingConstants.CENTER);
		lblKtQu2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblKtQu2.setBounds(318, 125, 145, 48);
		hbh.add(lblKtQu2);
		
		JButton delhbh = new JButton("Xóa");
		delhbh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ahbh.setText("");
				hhbh.setText("");
				Shbh.setText("");
			}
		});
		delhbh.setFont(new Font("Times New Roman", Font.BOLD, 14));
		delhbh.setBounds(204, 229, 89, 35);
		hbh.add(delhbh);
		
		//Hinh tam giac
		JPanel htg = new JPanel();
		tabbedPane.addTab("Hình tam giác", null, htg, null);
		htg.setLayout(null);
		
		JLabel lblNewLabel3 = new JLabel("S = (a x h) / 2 ");
		lblNewLabel3.setBounds(178, 23, 145, 48);
		lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		htg.add(lblNewLabel3);
		
		JLabel lblACnhHnh3a = new JLabel("a: cạnh đáy");
		lblACnhHnh3a.setHorizontalAlignment(SwingConstants.CENTER);
		lblACnhHnh3a.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblACnhHnh3a.setBounds(178, 52, 145, 48);
		htg.add(lblACnhHnh3a);
		
		JLabel lblACnhHnh3b = new JLabel("h: đường cao");
		lblACnhHnh3b.setHorizontalAlignment(SwingConstants.CENTER);
		lblACnhHnh3b.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblACnhHnh3b.setBounds(178, 82, 145, 48);
		htg.add(lblACnhHnh3b);
		
		JLabel lblNhpCnh3a = new JLabel("Nhập cạnh đáy:");
		lblNhpCnh3a.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpCnh3a.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhpCnh3a.setBounds(49, 125, 145, 48);
		htg.add(lblNhpCnh3a);
		
		JLabel lblNhpCnh3b = new JLabel("Nhập đường cao:");
		lblNhpCnh3b.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpCnh3b.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhpCnh3b.setBounds(49, 200, 145, 48);
		htg.add(lblNhpCnh3b);
		
		ahtg = new JTextField();
		ahtg.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ahtg.setHorizontalAlignment(SwingConstants.CENTER);
		ahtg.setBounds(79, 165, 86, 35);
		htg.add(ahtg);
		ahtg.setColumns(10);
		
		JTextArea Shtg = new JTextArea();
		Shtg.setBounds(328, 165, 135, 111);
		htg.add(Shtg);
		
		hhtg = new JTextField();
		hhtg.setHorizontalAlignment(SwingConstants.CENTER);
		hhtg.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		hhtg.setColumns(10);
		hhtg.setBounds(79, 241, 86, 35);
		htg.add(hhtg);
		
		JButton calhtg = new JButton("Tính");
		calhtg.setFont(new Font("Times New Roman", Font.BOLD, 14));
		calhtg.setBounds(204, 180, 89, 35);
		htg.add(calhtg);
		calhtg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//checkInput();
				double aHTG = Double.valueOf(ahtg.getText());
				double hHTG = Double.valueOf(hhtg.getText());
				double SHTG = 0.0;
				SHTG = (aHTG * hHTG) / 2; 
				Shtg.setText(Double.toString(SHTG));
			}
		});
		
		JLabel lblKtQu3 = new JLabel("Kết quả:");
		lblKtQu3.setHorizontalAlignment(SwingConstants.CENTER);
		lblKtQu3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblKtQu3.setBounds(318, 125, 145, 48);
		htg.add(lblKtQu3);
		
		JButton delhtg = new JButton("Xóa");
		delhtg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ahtg.setText("");
				hhtg.setText("");
				Shtg.setText("");
			}
		});
		delhtg.setFont(new Font("Times New Roman", Font.BOLD, 14));
		delhtg.setBounds(204, 229, 89, 35);
		htg.add(delhtg);
		
		//Hinh thoi
		JPanel hthoi = new JPanel();
		tabbedPane.addTab("Hình thoi", null, hthoi, null);
		hthoi.setLayout(null);
		
		JLabel lblNewLabel4 = new JLabel("S = (d1 x d2) / 2 ");
		lblNewLabel4.setBounds(178, 23, 145, 48);
		lblNewLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		hthoi.add(lblNewLabel4);
		
		JLabel lblACnhHnh4a = new JLabel("d1: đường chéo thứ nhất");
		lblACnhHnh4a.setHorizontalAlignment(SwingConstants.CENTER);
		lblACnhHnh4a.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblACnhHnh4a.setBounds(154, 52, 193, 48);
		hthoi.add(lblACnhHnh4a);
		
		JLabel lblACnhHnh4b = new JLabel("d2: đường chéo thứ hai");
		lblACnhHnh4b.setHorizontalAlignment(SwingConstants.CENTER);
		lblACnhHnh4b.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblACnhHnh4b.setBounds(154, 80, 183, 48);
		hthoi.add(lblACnhHnh4b);
		
		JLabel lblNhpCnh4a = new JLabel("Nhập đường chéo I:");
		lblNhpCnh4a.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpCnh4a.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhpCnh4a.setBounds(49, 125, 145, 48);
		hthoi.add(lblNhpCnh4a);
		
		JLabel lblNhpCnh4b = new JLabel("Nhập đường chéo II:");
		lblNhpCnh4b.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpCnh4b.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhpCnh4b.setBounds(49, 200, 145, 48);
		hthoi.add(lblNhpCnh4b);
		
		d1 = new JTextField();
		d1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		d1.setHorizontalAlignment(SwingConstants.CENTER);
		d1.setBounds(79, 165, 86, 35);
		hthoi.add(d1);
		d1.setColumns(10);
		
		JTextArea Shthoi = new JTextArea();
		Shthoi.setBounds(328, 165, 135, 111);
		hthoi.add(Shthoi);
		
		
		d2 = new JTextField();
		d2.setHorizontalAlignment(SwingConstants.CENTER);
		d2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		d2.setColumns(10);
		d2.setBounds(79, 241, 86, 35);
		hthoi.add(d2);
		
		JButton calhthoi = new JButton("Tính");
		calhthoi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		calhthoi.setBounds(204, 180, 89, 35);
		hthoi.add(calhthoi);
		calhthoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//checkInput();
				double d1HT = Double.valueOf(d1.getText());
				double d2HT = Double.valueOf(d2.getText());
				double SHT = 0.0;
				SHT = (d1HT * d2HT) / 2; 
				Shthoi.setText(Double.toString(SHT));
			}
		});
		
		JLabel lblKtQu4 = new JLabel("Kết quả:");
		lblKtQu4.setHorizontalAlignment(SwingConstants.CENTER);
		lblKtQu4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblKtQu4.setBounds(318, 125, 145, 48);
		hthoi.add(lblKtQu4);
		
		JButton delhthoi = new JButton("Xóa");
		delhthoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d1.setText("");
				d2.setText("");
				Shthoi.setText("");
			}
		});
		delhthoi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		delhthoi.setBounds(204, 229, 89, 35);
		hthoi.add(delhthoi);
		
		//Hinh tron
		JPanel htron = new JPanel();
		tabbedPane.addTab("Hình tròn", null, htron, null);
		htron.setLayout(null);
		
		JLabel lblNewLabel5 = new JLabel("S = pi x r^2 hoặc S = (pi x  d^2) / 4");
		lblNewLabel5.setBounds(49, 23, 414, 48);
		lblNewLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		htron.add(lblNewLabel5);
		
		JLabel lblACnhHnh5a = new JLabel("r: bán kính");
		lblACnhHnh5a.setHorizontalAlignment(SwingConstants.CENTER);
		lblACnhHnh5a.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblACnhHnh5a.setBounds(154, 52, 193, 48);
		htron.add(lblACnhHnh5a);
		
		JLabel lblACnhHnh5b = new JLabel("d: đường kính");
		lblACnhHnh5b.setHorizontalAlignment(SwingConstants.CENTER);
		lblACnhHnh5b.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblACnhHnh5b.setBounds(154, 80, 183, 48);
		htron.add(lblACnhHnh5b);
		
		JLabel lblNhpCnh5a = new JLabel("Nhập bán kính:");
		lblNhpCnh5a.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpCnh5a.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhpCnh5a.setBounds(49, 125, 145, 48);
		htron.add(lblNhpCnh5a);
		
		JLabel lblNhpCnh5b = new JLabel("Nhập đường kính:");
		lblNhpCnh5b.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpCnh5b.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhpCnh5b.setBounds(49, 216, 145, 48);
		htron.add(lblNhpCnh5b);
		
		r = new JTextField();
		r.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		r.setHorizontalAlignment(SwingConstants.CENTER);
		r.setBounds(79, 165, 86, 35);
		htron.add(r);
		r.setColumns(10);
		
		JTextArea Shtron = new JTextArea();
		Shtron.setBounds(328, 165, 135, 128);
		htron.add(Shtron);
		
		d = new JTextField();
		d.setHorizontalAlignment(SwingConstants.CENTER);
		d.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		d.setColumns(10);
		d.setBounds(79, 258, 86, 35);
		htron.add(d);
		
		JButton calhtron = new JButton("Tính");
		calhtron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//checkInput();
				double SHTR = 0.0;
				//Neu nhap d
				if(r.getText().isEmpty() && !d.getText().isEmpty()) {
					double dHT = Double.valueOf(d.getText());
					SHTR = (pi * Math.pow(dHT,  2)) / 4; 
				}
				//Neu nhap r
				if(d.getText().isEmpty() && !r.getText().isEmpty()) {
					double rHT = Double.valueOf(r.getText());
					SHTR = pi * Math.pow(rHT,  2); 
				}
				Shtron.setText(Double.toString(SHTR));
			}
		});
		calhtron.setFont(new Font("Times New Roman", Font.BOLD, 14));
		calhtron.setBounds(204, 180, 89, 35);
		htron.add(calhtron);
		
		JLabel lblKtQu5 = new JLabel("Kết quả:");
		lblKtQu5.setHorizontalAlignment(SwingConstants.CENTER);
		lblKtQu5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblKtQu5.setBounds(318, 125, 145, 48);
		htron.add(lblKtQu5);
		
		JButton delhtron = new JButton("Xóa");
		delhtron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.setText("");
				d.setText("");
				Shtron.setText("");
			}
		});
		delhtron.setFont(new Font("Times New Roman", Font.BOLD, 14));
		delhtron.setBounds(204, 241, 89, 35);
		htron.add(delhtron);
		
		JLabel lblHoc = new JLabel("hoặc");
		lblHoc.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoc.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblHoc.setBounds(49, 191, 145, 48);
		htron.add(lblHoc);
	}
}
