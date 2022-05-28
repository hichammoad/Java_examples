package gui_swing.ex1.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui_swing.ex1.model.Roles;
import gui_swing.ex1.model.User;

public class UserDetails extends JFrame {

	JLabel label_id = new JLabel("ID: ");
	JTextField text_id = new JTextField(20);
	JLabel label_nom = new JLabel("Nom: ");
	JTextField text_nom = new JTextField(20);
	JLabel label_email = new JLabel("Email: ");
	JTextField text_email = new JTextField(20);
	JLabel label_pass = new JLabel("Password: ");
	JPasswordField text_pass = new JPasswordField(20);
	JLabel label_role = new JLabel("Role: ");
	//JTextField text_role = new JTextField(20);
	JComboBox<Roles> comboBox_role = new JComboBox<Roles>(Roles.values()); // Enums :)
	JButton btn_save = new JButton("Save");
	JButton btn_close = new JButton("Close");

	public void disableElements() {
		text_id.setEnabled(false);
		text_nom.setEnabled(false);
		text_email.setEnabled(false);
		text_pass.setEnabled(false);
		comboBox_role.setEnabled(false);
		btn_save.setEnabled(false);
	}

	public UserDetails(User u) {
		// TODO Auto-generated constructor stub
		// setVisible(true);
		setSize(500, 500);
		setLayout(new GridLayout(6, 2));

		if (u != null) {
			text_id.setText(String.valueOf(u.getId()));
			text_nom.setText(u.getNom());
			text_email.setText(u.getEmail());
			text_pass.setText(u.getPassword());
			//text_role.setText(u.getRole().toString());
			comboBox_role.setSelectedItem(u.getRole());
		}

		add(label_id);
		add(text_id);

		add(label_nom);
		add(text_nom);

		add(label_email);
		add(text_email);

		add(label_pass);
		add(text_pass);

		add(label_role);
		add(comboBox_role);

		add(btn_save);
		add(btn_close);

		pack();

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		btn_close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserDetails.this.dispose();
			}
		});

	}

}
