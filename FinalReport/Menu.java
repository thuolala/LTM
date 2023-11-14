package FinalReport;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.View;
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
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {
	private JPanel contentPane;
	private InetAddress Menu1;
	private DatagramSocket theSocket;
	private int portNo;
	private int maxSize;
	private String message;
	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 
	/**
	* Create the frame.
	*/
	public Menu() { 
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 577, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton cal = new JButton("Máy Tính");
		cal.setBackground(Color.PINK);
		cal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculator frame = new Calculator(); 
				frame.setVisible(true);
			}
		});
		cal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cal.setBounds(106, 227, 134, 47);
		contentPane.add(cal);
		
		JButton dic = new JButton("Từ Điển");
		dic.setBackground(Color.PINK);
		dic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dictionary frame = new Dictionary ();
				frame.setVisible(true);
			}
		});
		dic.setFont(new Font("Times New Roman", Font.BOLD, 14));
		dic.setBounds(106, 155, 134, 47);
		contentPane.add(dic);
		
		JButton dienTich = new JButton("Diện Tích");
		dienTich.setBackground(Color.PINK);
		dienTich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DienTich frame = new DienTich();
				frame.setVisible(true);
			}
		});
		dienTich.setFont(new Font("Times New Roman", Font.BOLD, 14));
		dienTich.setBounds(315, 155, 134, 47);
		contentPane.add(dienTich);
		
		JButton pt = new JButton("Phương Trình");
		pt.setBackground(Color.PINK);
		pt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhuongTrinh frame = new PhuongTrinh();
				frame.setVisible(true);
			}
		});
		pt.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pt.setBounds(315, 227, 134, 47);
		contentPane.add(pt);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(252, 38, 81, 14);
		contentPane.add(lblNewLabel);
		
		JButton ftp = new JButton("FTP");
		ftp.setBackground(Color.PINK);
		ftp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadFile frame = new UploadFile();
				frame.setVisible(true);
			}
		});
		ftp.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ftp.setBounds(212, 301, 134, 47);
		contentPane.add(ftp);
		
		JButton cUDP = new JButton("Chat UDP");
		cUDP.setBackground(Color.PINK);
		cUDP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientUDP frame = new ClientUDP();
				frame.setVisible(true);
			}
		});
		cUDP.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cUDP.setBounds(315, 80, 134, 47);
		contentPane.add(cUDP);
		
		JButton cTCP = new JButton("Chat TCP");
		cTCP.setBackground(Color.PINK);
		cTCP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientTCP frame = new ClientTCP();
				frame.setVisible(true);
			}
		});
		cTCP.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cTCP.setBounds(106, 80, 134, 47);
		contentPane.add(cTCP);
		
	}
}