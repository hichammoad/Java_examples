package gui_swing.ex1.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui_swing.ex1.gui.admin.AdminHome;
import gui_swing.ex1.gui.user.UserHome;
import gui_swing.ex1.model.DBUsers;
import gui_swing.ex1.model.Roles;
import gui_swing.ex1.model.User;

public class Auth extends JFrame {
	// Auth class is now a JFrame.

	public Auth() {
		setVisible(true);
		// Design:
		/*  ________________________________________// A JFrame, by default it uses BorderLayout
		 * |									    |// we need to create some Panel or use another Layout. 
		 * |                                        |
		 * |	                 ________________   | 
		 * | 	Email :         |________________|  |// Panel p1, North 
		 * |										| 
		 * |					 ________________   | 
		 * |	Password :		|________________|  |// Panel p2, Center 
		 * | 										|
		 * |  		 ________ 		 _______ 		| 
		 * |  		|_Submit_| 		|_Close_| 		|// Panel p3, South | |
		 * |________________________________________|
		 */

		JLabel label_email = new JLabel("Email :");
		JLabel label_password = new JLabel("Password :");
		JTextField text_email = new JTextField(20);
		JPasswordField text_pass = new JPasswordField(20);
		JButton btn_ok = new JButton("Submit");
		JButton btn_close = new JButton("Close");

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.add(label_email);
		p1.add(text_email);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(label_password);
		p2.add(text_pass);

		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		p3.add(btn_ok);
		p3.add(btn_close);

		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		
		pack();
		setSize(500, 200);
		setLocationRelativeTo(null); // put the jframe in the center of the screen
		

		// Quit the app
		btn_close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		btn_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = text_email.getText();
				// This is not secure, we need to get the password as char[]
				// but we can accept that in this small exercise.
				String password = text_pass.getText();

				User u = new User();
				u.setEmail(email);
				u.setPassword(password);

				u = DBUsers.verifierUser(u);

				if (u == null) {
					JOptionPane.showMessageDialog(null, "erreur d'authentification!!", "Erreur",
							JOptionPane.ERROR_MESSAGE);
					text_email.setText("");
					text_pass.setText("");
				} else {
					Auth.this.dispose(); 
					if (u.getRole().equals(Roles.admin)) {
						// admin interface
						new AdminHome(u);
					} else if(u.getRole().equals(Roles.user)){
						// user interface
						new UserHome(u);
					}
				}
			}
		});
	
	}
}
