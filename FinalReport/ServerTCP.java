package FinalReport;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
public class ServerTCP extends JFrame {
private JPanel contentPane;
private JTextField msg_text;
private static JTextArea msg_area;
static ServerSocket serverScoket;
static Socket socket;
static DataInputStream dataIn;
static DataOutputStream dataOut;
private JLabel lblNewLabel;
static Component fame = null;

/**
* Launch the application.
*/
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				ServerTCP frame = new ServerTCP();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	String msgin ="";
	try {
		serverScoket = new ServerSocket(2020);
		JOptionPane.showMessageDialog(fame, "The Server is waiting ....",
		"Note",JOptionPane.WARNING_MESSAGE);
		socket = serverScoket.accept();
		JOptionPane.showMessageDialog(fame, "A Client is connected to the Server\n We can chat now", "Note",JOptionPane.WARNING_MESSAGE);
		dataIn = new DataInputStream(socket.getInputStream());
		dataOut = new DataOutputStream(socket.getOutputStream());
		while(!msgin.equals("exit")) {
		msgin = dataIn.readUTF();
		msg_area.setText(msg_area.getText().trim()+"\n Client: "+msgin);
		}
	} catch (IOException e) {
	JOptionPane.showMessageDialog(fame, "Sever gap van de ve I/O", "Note",JOptionPane.WARNING_MESSAGE);
	}
	finally{
		try{
			if(socket!=null){
			socket.close();
			}
		}
		catch(IOException e){}
	}
}
/**
* Create the frame.
*/
public ServerTCP() {
	setTitle("Server");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setBounds(100, 100, 532, 387);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	msg_area = new JTextArea();
	msg_area.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	msg_area.setEditable(false);
	msg_area.setBounds(24, 13, 470, 232);
	contentPane.add(msg_area);
	JScrollPane scrollPane = new JScrollPane(msg_area);
	
	scrollPane.setBounds(24, 13, 470, 232);
	contentPane.add(scrollPane);
	msg_text = new JTextField();
	msg_text.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	msg_text.setBounds(24, 276, 360, 44);
	contentPane.add(msg_text);
	msg_text.setColumns(10);
	
	JButton msg_send = new JButton("Send");
	/*msg_send.setHorizontalAlignment(SwingConstants.LEFT);
	msg_send.setIcon(new
	ImageIcon(ServerTCP.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));*/
	msg_send.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String msgOut = " ";
			msgOut = msg_text.getText().trim();
			try {
				dataOut.writeUTF(msgOut);
				msg_area.setText(msg_area.getText().trim()+"\n Me: "+msgOut);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			msg_text.setText("");
		}
	});
	msg_send.setFont(new Font("Times New Roman", Font.BOLD, 20));
	msg_send.setBounds(389, 280, 99, 34);
	contentPane.add(msg_send);
	/*lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(new ImageIcon("D:\\Giao An\\Basic NetworkProgramming\\Software\\Hoc Java\\Sever_Client_TCP\\Image\\DestTop4.jpg"));
	
	lblNewLabel.setBounds(0, 2, 514, 338);
	contentPane.add(lblNewLabel);*/
	}
}