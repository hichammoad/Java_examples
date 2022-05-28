package gui_swing.ex1.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gui_swing.ex1.gui.admin.AdminHome;
import gui_swing.ex1.model.DBUsers;
import gui_swing.ex1.model.Roles;
import gui_swing.ex1.model.User;

public class AddUserInterface extends UserDetails {

	public AddUserInterface(JFrame parent, User u) {
		// TODO Auto-generated constructor stub
		super(u);

		text_pass.setText("1234");
		text_pass.setEnabled(false);

		// text_role.setText(Roles.user.toString());
		// text_role.setEnabled(false);

		btn_save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				User u = new User();
				u.setId(Integer.parseInt(text_id.getText()));
				u.setNom(text_nom.getText());
				u.setEmail(text_email.getText());
				u.setPassword(text_pass.getText());
				// u.setRole(Roles.user);
				u.setRole((Roles) comboBox_role.getSelectedItem());

				if (DBUsers.userExists(u.getEmail())) {
					JOptionPane.showMessageDialog(AddUserInterface.this,
							"A user with the mail '" + u.getEmail() + "' already exists");
					return;
				}

				DBUsers.listUsers.put(u.getEmail(), u);
				JOptionPane.showMessageDialog(AddUserInterface.this, "User added successfully !");

				AdminHome lhome = (AdminHome) parent;
				lhome.getjTable().setModel(Helper.getUpdatedModel(DBUsers.listUsers.values()));

			}
		});

	}

}
