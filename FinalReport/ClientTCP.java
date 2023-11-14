package FinalReport;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
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
import java.net.UnknownHostException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ClientTCP extends JFrame {
private JPanel contentPane;
private JTextField msg_text;
private static JTextArea textArea_history;
static Socket socket;
static DataInputStream dataInput;
static DataOutputStream dout;
private JLabel lblNewLabel;
static Component fame = null;
/**
* Launch the application.
*/
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			ClientTCP frame = new ClientTCP();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	});
	try {
		socket = new Socket("localhost",2020);
		dataInput = new DataInputStream(socket.getInputStream());
		dout = new DataOutputStream(socket.getOutputStream());
		String msgin="";
		while(!msgin.equals("exit")) {
			msgin = dataInput.readUTF();
			textArea_history.setText(textArea_history.getText().trim()+"\nServer:"+msgin);
		}
	} catch (UnknownHostException e) {
	// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(fame, "UnknownHostException\n We can chat now", "Note",JOptionPane.WARNING_MESSAGE);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(fame, "IOException\n We can not chat now", "Note",JOptionPane.WARNING_MESSAGE);
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
public ClientTCP() {
	setTitle("Client");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 559, 371);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	textArea_history = new JTextArea();
	textArea_history.setEditable(false);
	textArea_history.setBounds(26, 13, 484, 226);
	contentPane.add(textArea_history);
	JScrollPane scrollPane = new JScrollPane(textArea_history);
	
	scrollPane.setBounds(26, 13, 484, 226);
	contentPane.add(scrollPane);
	msg_text = new JTextField();
	msg_text.setBounds(24, 280, 374, 36);
	contentPane.add(msg_text);
	msg_text.setColumns(10);
	JButton msg_send = new JButton("Send");
	/*msg_send.setHorizontalAlignment(SwingConstants.LEFT);
	msg_send.setIcon(new
	ImageIcon(ClientTCP.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));*/
	msg_send.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String msgOut =" ";
			msgOut = msg_text.getText().trim();
			try {
				dout.writeUTF(msgOut);
				textArea_history.setText(textArea_history.getText().trim()+"\n Me: "+msgOut);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			msg_text.setText("");
		}
	});
	
	msg_send.setFont(new Font("Times New Roman", Font.BOLD, 16));
	msg_send.setBounds(410, 282, 100, 31);
	contentPane.add(msg_send);
	/*lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(new ImageIcon("D:\\Giao An\\Basic NetworkProgramming\\Software\\Hoc Java\\Sever_Client_TCP\\Image\\DestTop5.jpg"));
	lblNewLabel.setBounds(0, 0, 541, 324);
	contentPane.add(lblNewLabel);*/
	}
}