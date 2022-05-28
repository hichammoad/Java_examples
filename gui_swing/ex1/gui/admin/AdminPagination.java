package gui_swing.ex1.gui.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import gui_swing.ex1.gui.Helper;
import gui_swing.ex1.model.DBUsers;
import gui_swing.ex1.model.User;

public class AdminPagination extends JFrame {

	int position = 0;
	static JTable jTable;
	static DefaultTableModel model;

	public AdminPagination() {
		// TODO Auto-generated constructor stub
		// setVisible(true);
		setSize(500, 700);

		JLabel label_id = new JLabel("ID :");
		JTextField text_id = new JTextField(20);

		JLabel label_nom = new JLabel("Nom : ");
		JTextField text_nom = new JTextField(20);

		JLabel label_email = new JLabel("Email :");
		JTextField text_email = new JTextField(20);

		JLabel label_pass = new JLabel("Password :");
		JTextField text_pass = new JTextField(20);

		JLabel label_role = new JLabel("Role : ");
		JTextField text_role = new JTextField(20);

		JTextField text_search = new JTextField(20);
		jTable = new JTable();

		/*
		 * String[] columnNames = { "ID", "NOM", "EMAIL", "ROLE", "Note" }; model = new
		 * DefaultTableModel(columnNames, 0); jTable.setModel(model); //
		 * jTable.setTableHeader(tableHeader);
		 * 
		 * for (User auser : DBUsers.listUsers.values()) { String[] row = {
		 * String.valueOf(auser.getId()), auser.getNom(), auser.getEmail(),
		 * auser.getRole().toString(), auser.getNote() + "" }; model.addRow(row); }
		 */

		// AdminHome.j
		jTable.setModel(Helper.getUpdatedModel(DBUsers.listUsers.values()));
		;

		text_search.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				String req = text_search.getText();
				List<User> subList = DBUsers.search(req);

				/*
				 * System.out.println("size=" + subList.size());
				 * 
				 * String[] columnNames = { "ID", "NOM", "EMAIL", "ROLE", "Note" };
				 * AdminPagination.model = new DefaultTableModel(columnNames, 0);
				 * 
				 * // jTable.setTableHeader(tableHeader);
				 * 
				 * for (User auser : subList) { String[] row = { String.valueOf(auser.getId()),
				 * auser.getNom(), auser.getEmail(), auser.getRole().toString(), auser.getNote()
				 * + "" }; model.addRow(row); } jTable.setModel(model);
				 */
				jTable.setModel(Helper.getUpdatedModel(subList));

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(2, 1));

		JButton btn_sort = new JButton("SORT");

		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		p3.add(text_search);
		p3.add(btn_sort);

		p2.add(p3);

		JScrollPane jScrollPane = new JScrollPane(jTable);
		// p2.add(jTable);
		p2.add(jScrollPane);

		add(p2, BorderLayout.CENTER);

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(7, 2));

		p1.add(label_id);
		p1.add(text_id);
		p1.add(label_nom);
		p1.add(text_nom);
		p1.add(label_email);
		;
		p1.add(text_email);
		p1.add(label_pass);
		p1.add(text_pass);
		p1.add(label_role);
		p1.add(text_role);
		// add(btn_logout);
		JButton btn_next = new JButton("Next");
		JButton btn_prev = new JButton("Prev");

		JButton btn_delete = new JButton("Delete");
		JButton btn_add = new JButton("Add");

		p1.add(btn_prev);

		p1.add(btn_next);

		p1.add(btn_delete);
		p1.add(btn_add);

		add(p1, BorderLayout.NORTH);

		User u = (User) DBUsers.listUsers.values().toArray()[position];
		text_id.setText(String.valueOf(u));
		text_nom.setText(u.getNom());
		text_email.setText(u.getEmail());
		text_pass.setText(u.getPassword());
		text_role.setText(u.getRole().toString());

		setSize(500, 500);

		btn_next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				position++;

				if (position == DBUsers.listUsers.size()) {
					position = 0;
				}

				User u = (User) DBUsers.listUsers.values().toArray()[position];
				text_id.setText(String.valueOf(u));
				text_nom.setText(u.getNom());
				text_email.setText(u.getEmail());
				text_pass.setText(u.getPassword());
				text_role.setText(u.getRole().toString());

			}
		});

		btn_prev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				position--;

				if (position == -1) {
					position = DBUsers.listUsers.size() - 1;
				}

				User u = (User) DBUsers.listUsers.values().toArray()[position];
				text_id.setText(String.valueOf(u));
				text_nom.setText(u.getNom());
				text_email.setText(u.getEmail());
				text_pass.setText(u.getPassword());
				text_role.setText(u.getRole().toString());

			}
		});

		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String selectedEmail = text_email.getText();
				DBUsers.listUsers.remove(selectedEmail);

				position++;

				if (position >= DBUsers.listUsers.size()) {
					position = 0;
				}

				User u = (User) DBUsers.listUsers.values().toArray()[position];
				text_id.setText(String.valueOf(u));
				text_nom.setText(u.getNom());
				text_email.setText(u.getEmail());
				text_pass.setText(u.getPassword());
				text_role.setText(u.getRole().toString());

			}
		});

		btn_sort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Collections.sort(User.users);

				List<User> sorted = new ArrayList<>(DBUsers.listUsers.values());

				String[] columnNames = { "ID", "NOM", "EMAIL", "ROLE", "Note" };
				AdminPagination.model = new DefaultTableModel(columnNames, 0);

				// jTable.setTableHeader(tableHeader);

				for (User auser : sorted) {
					String[] row = { String.valueOf(auser.getId()), auser.getNom(), auser.getEmail(),
							auser.getRole().toString(), auser.getNote() + "" };
					model.addRow(row);
				}
				jTable.setModel(model);

			}
		});

		jTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(jTable.getSelectedColumn());
				System.out.println(jTable.getSelectedRow());

			}
		});

	}

//	 public static void main(String[] args) {
//	 new AdminHome(new User(1, "a", "a", "a", Role.admin));
//	 }

}
