package FinalReport;
import java.awt.BorderLayout;
import java.net.*;
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
import javax.swing.JTabbedPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class ServerUDP extends JFrame {
	private JPanel contentPane;
	private JTextField PortNo;
	private InetAddress server;
	private InetAddress client;
	private DatagramSocket theServer;
	private DatagramSocket theSocket;
	private int portNo;
	private int clientPort;
	private String hostName;
	private String message;
	private JButton backS;
	private JButton menu;
	private JTextArea textArea;
	private JTextField text;
	private JButton send;
	private JTextField IP;
	private DatagramPacket packet;
	private DatagramPacket re;
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
					ServerUDP frame = new ServerUDP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	* Create the frame.
	 * @throws IOException 
	*/
	
	public void rec(DatagramPacket p) {
		//get message from client for address
		try {
			theServer.receive(p);
			//rec message and display
			String message ="";
			Component fame = null;
			message = new String(p.getData(), 0, p.getLength( ), "UTF-8");
			textArea.setText(textArea.getText().trim()+"\n"
			+p.getAddress( ) + " at port "
			+ p.getPort( ) +" say: " + message);
			JOptionPane.showMessageDialog(fame, "New data is received");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ServerUDP() {
		setTitle("Server");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 579, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		PortNo = new JTextField();
		PortNo.setHorizontalAlignment(SwingConstants.CENTER);
		PortNo.setText("2022");
		PortNo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		PortNo.setBounds(112, 34, 72, 32);
		contentPane.add(PortNo);
		PortNo.setColumns(10);
		JLabel lblNewLabel = new JLabel("Port:");
		
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(76, 34, 45, 32);
		contentPane.add(lblNewLabel);
		
		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				//
				portNo = Integer.parseInt(PortNo.getText());
				String getData = text.getText();
				byte[] data = getData.getBytes();
				try {
					textArea.setText(textArea.getText().trim()+"\n" + "Starting chat...");
					theServer = new DatagramSocket(portNo);
					Component fame = null;
					JOptionPane.showMessageDialog(fame, "Ready to receive data"," UDP Protocal",JOptionPane.WARNING_MESSAGE);
					
					//get message from client for address
					packet = new DatagramPacket(buffer, buffer.length);
					rec(packet);
					

					//send conncet accept
					
				} catch (SocketException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					theServer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					theServer.close();
				}
				text.setText("");
			}

		});
		
		start.setFont(new Font("Times New Roman", Font.BOLD, 16));
		start.setBounds(382, 34, 97, 32);
		contentPane.add(start);
		
		backS = new JButton("Back");
		backS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServerUDP frame = new ServerUDP();
				frame.setVisible(true);
			}
		});
		
		backS.setFont(new Font("Times New Roman", Font.BOLD, 16));
		backS.setBounds(318, 343, 105, 32);
		contentPane.add(backS);
		
		menu = new JButton("Menu");
		menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
			 	Menu frame = new Menu();
			 	frame.setVisible(true);
            }
		});
		menu.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menu.setBounds(137, 343, 105, 32);
		contentPane.add(menu);
		
		textArea = new JTextArea();
		textArea.setBounds(76, 92, 403, 148);
		contentPane.add(textArea);
		
		text = new JTextField();
		text.setText("");
		text.setBounds(121, 262, 312, 58);
		contentPane.add(text);
		text.setColumns(10);
		
		send = new JButton("Send");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				portNo = Integer.parseInt(PortNo.getText()); 
				try {
					Component fame = null;
					//send
					String getdata = text.getText();
					client = packet.getAddress();
					clientPort = packet.getPort();
					theServer = new DatagramSocket();
					byte[] dataS = getdata.getBytes();
					DatagramPacket packetS = new DatagramPacket(dataS, dataS.length, client, clientPort);
					theServer.send(packetS);
					textArea.setText(textArea.getText().trim() + "\n" + "Server say: " + getdata);
					text.setText("");
				}
				catch (SocketException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				text.setText("");
			}
		}); 
		
		send.setFont(new Font("Times New Roman", Font.BOLD, 16));
		send.setBounds(443, 261, 81, 58);
		contentPane.add(send);
		
		JLabel lblIp = new JLabel("IP:");
		lblIp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblIp.setBounds(194, 34, 45, 32);
		contentPane.add(lblIp);
		
		IP = new JTextField();
		IP.setText("localhost");
		IP.setHorizontalAlignment(SwingConstants.CENTER);
		IP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		IP.setColumns(10);
		IP.setBounds(232, 34, 105, 32);
		contentPane.add(IP);
		
		clr = new JButton("Clear");
		clr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		clr.setFont(new Font("Times New Roman", Font.BOLD, 16));
		clr.setBounds(30, 262, 81, 58);
		contentPane.add(clr);
		
	}
}