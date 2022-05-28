package gui_swing.ex1.gui.user;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui_swing.ex1.gui.Auth;
import gui_swing.ex1.gui.UserDetails;
import gui_swing.ex1.model.User;

public class UserHome extends JFrame {


	public UserHome(User u) {
		// TODO Auto-generated constructor stub
		setVisible(true);
		setSize(500, 500);

		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu = new JMenu("Options");
		JMenuItem jMenuItem_logout = new JMenuItem("Logout");
		JMenuItem jMenuItem_exitapp = new JMenuItem("Exit app");

		jMenuBar.add(jMenu);
		jMenu.add(jMenuItem_logout);
		jMenu.add(jMenuItem_exitapp);
		setJMenuBar(jMenuBar);


		JLabel label_welcome = new JLabel();
		label_welcome.setText("Welcome " + u.getNom());
		label_welcome.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		add(label_welcome, BorderLayout.NORTH);

		
		JButton btn_profile = new JButton("Show Profile");
		add(btn_profile, BorderLayout.SOUTH);
		
		UserDetails userDetails = new UserDetails(u);
		userDetails.disableElements();
		
		btn_profile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userDetails.setVisible(true);
				
			}
		});
		
		
		jMenuItem_logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserHome.this.dispose();
				new Auth();
			}
		});

		jMenuItem_exitapp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});


	}

}
