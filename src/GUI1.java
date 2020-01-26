import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

public class GUI1 {

	private JFrame frmNewUser;
	private JTextField txtName;
	private JTextField txtPassword;
	private JTextField txtInterests;
	private JTextField txtInterests_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//String userName, String pass, ArrayList <String> inters
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI1 window = new GUI1();
					window.frmNewUser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});


	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public GUI1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewUser = new JFrame();
		frmNewUser.setTitle("New User");
		frmNewUser.setBounds(100, 100, 450, 300);
		frmNewUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewUser.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(0, 0, 236, 39);
		frmNewUser.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setBounds(0, 39, 236, 39);
		frmNewUser.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		
		txtInterests = new JTextField();
		txtInterests.setText("Interests1");
		txtInterests.setBounds(0, 78, 236, 39);
		frmNewUser.getContentPane().add(txtInterests);
		txtInterests.setColumns(10);
		
		txtInterests_1 = new JTextField();
		txtInterests_1.setText("Interests2");
		txtInterests_1.setColumns(10);
		txtInterests_1.setBounds(0, 116, 236, 39);
		frmNewUser.getContentPane().add(txtInterests_1);
		
		JButton btnNewButton = new JButton("Create New User");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ArrayList<String> interests = new ArrayList<String>();
				interests.add(txtInterests.getText());
				interests.add(txtInterests_1.getText());
				User newFren = new User(txtName.getText(), txtPassword.getText(),interests);
				newFren.friendSearch();
				newFren.toStringFriend();
								
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(0, 171, 171, 41);
		frmNewUser.getContentPane().add(btnNewButton);
		
		
		


	}
}
