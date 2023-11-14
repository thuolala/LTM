package FinalReport;
import java.awt.BorderLayout; 
import java.net.*; 
import java.io.*;
import java.lang.*;
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
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ClientUDP extends JFrame {
	private JPanel contentPane;
	private JTextField IP;
	private DatagramSocket theClient;
	private DatagramSocket theSocket;
	private int portNo;
	private String hostName;
	private String message;
	private JButton backC;
	private JButton start;
	private JButton send;
	private JTextField PortNo;
	private JTextField name;
	private JLabel lblName;
	private JButton menu;
	private JTextField text;
	private InetAddress server;
	private JTextArea textArea;
	private DatagramPacket packet;
	private int maxSize = 56507;
	private byte[] buffer = new byte[maxSize];
	private JButton clr;
	
	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientUDP frame = new ClientUDP();
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
	public ClientUDP() {
		setTitle("Client");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 579, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		IP = new JTextField();
		IP.setHorizontalAlignment(SwingConstants.CENTER);
		IP.setText("localhost");
		IP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		IP.setBounds(247, 34, 72, 32);
		contentPane.add(IP);
		IP.setColumns(10);
		JLabel lblNewLabel = new JLabel("Port");
		
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(329, 34, 34, 32);
		contentPane.add(lblNewLabel);
		
		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hostName = IP.getText();
				portNo = Integer.parseInt(PortNo.getText());
				String getdata = text.getText();
				try {
					//connect
					server = InetAddress.getByName(hostName);
					theClient = new DatagramSocket();
					Component fame = null;
					JOptionPane.showMessageDialog(fame, "Ready to send data","UDP Protocal",JOptionPane.WARNING_MESSAGE);
				} catch (SocketException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		start.setFont(new Font("Times New Roman", Font.BOLD, 16));
		start.setBounds(434, 34, 97, 32);
		contentPane.add(start);
		
		backC = new JButton("Back");
		backC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientUDP frame = new ClientUDP();
				frame.setVisible(true);	
			}
		});
		backC.setFont(new Font("Times New Roman", Font.BOLD, 16));
		backC.setBounds(292, 338, 105, 32);
		contentPane.add(backC);
		
		PortNo = new JTextField();
		PortNo.setText("2022");
		PortNo.setHorizontalAlignment(SwingConstants.CENTER);
		PortNo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		PortNo.setColumns(10);
		PortNo.setBounds(362, 34, 62, 32);
		contentPane.add(PortNo);
		
		JLabel lblIp = new JLabel("IP");
		lblIp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblIp.setBounds(226, 34, 25, 32);
		contentPane.add(lblIp);
		
		name = new JTextField();
		name.setText("Phạm Huỳnh Anh Thư");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		name.setColumns(10);
		name.setBounds(70, 34, 146, 32);
		contentPane.add(name);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblName.setBounds(28, 34, 54, 32);
		contentPane.add(lblName);
		
		menu = new JButton("Menu");
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu frame = new Menu();
				frame.setVisible(true);				
			}
		});
		menu.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menu.setBounds(142, 338, 105, 32);
		contentPane.add(menu);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(70, 96, 416, 136);
		contentPane.add(textArea);
		
		text = new JTextField();
		text.setBounds(112, 257, 327, 57);
		contentPane.add(text);
		text.setColumns(10);
		
		JButton send = new JButton("Send");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getdata = text.getText();
				Component fame = null;
				try {
					packet = new DatagramPacket(buffer, buffer.length);
					byte[] data = getdata.getBytes();
					
					//send
					getdata = text.getText();
					data = getdata.getBytes();
					DatagramPacket packetS = new DatagramPacket(data, data.length, server, portNo);
					theClient.send(packetS);
					textArea.setText(textArea.getText().trim()+"\n Me say: " + getdata);
					text.setText("");
					
					theClient.receive(packet);
					String rep = new String(packet.getData(), 0, packet.getLength());
					textArea.setText(textArea.getText().trim()+"\n" + "|__Server says: " + rep); 
					
					packetS = new DatagramPacket(data, data.length, server, portNo);
					theClient.send(packetS);

					/*if(getdata.equals("Exit")) {
						JOptionPane.showMessageDialog(fame, "End chat!");
						theClient.send(packetS);
						theClient.close();
					}*/
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e2) { 
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}	
				text.setText("");
			}
		});
		send.setFont(new Font("Times New Roman", Font.BOLD, 16));
		send.setBounds(449, 256, 72, 57);
		contentPane.add(send);
		
		clr = new JButton("Clear");
		clr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		clr.setFont(new Font("Times New Roman", Font.BOLD, 16));
		clr.setBounds(30, 256, 72, 57);
		contentPane.add(clr);
	}
}