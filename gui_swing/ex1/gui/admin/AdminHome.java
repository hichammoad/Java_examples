package gui_swing.ex1.gui.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import gui_swing.ex1.gui.AddUserInterface;
import gui_swing.ex1.gui.Auth;
import gui_swing.ex1.gui.Helper;
import gui_swing.ex1.gui.UserDetails;
import gui_swing.ex1.model.DBUsers;
import gui_swing.ex1.model.User;

public class AdminHome extends JFrame {

	JTable jTable;
	User connected;
	DefaultTableModel model;

	public JTable getjTable() {
		return jTable;
	}

	
	
	
	
	
	public AdminHome(User admin) {
		this.setVisible(true);
		//this.setSize(500, 500);

		this.connected = admin;

		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu = new JMenu("Options");
		JMenuItem jMenuItem_logout = new JMenuItem("Logout");
		JMenuItem jMenuItem_pagination = new JMenuItem("Show pagination");
		JMenuItem jMenuItem_profile = new JMenuItem("My Profile");
		JMenuItem jMenuItem_exitapp = new JMenuItem("Exit app");

		jMenuBar.add(jMenu);
		jMenu.add(jMenuItem_logout);
		jMenu.add(jMenuItem_exitapp);
		jMenu.add(jMenuItem_profile);
		jMenu.add(jMenuItem_pagination);
		setJMenuBar(jMenuBar);

		jTable = new JTable();
		jTable.setModel(Helper.getUpdatedModel(DBUsers.listUsers.values()));
		jTable.setDefaultEditor(Object.class, null);

		JLabel label_welcome = new JLabel();
		label_welcome.setText("Welcome " + admin.getNom());
		label_welcome.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

		JTextField text_search = new JTextField(20);
		text_search.setToolTipText("search");

		JPanel panelTop = new JPanel();
		panelTop.setLayout(new FlowLayout());

		panelTop.add(label_welcome);
		panelTop.add(text_search);

		add(panelTop, BorderLayout.NORTH);

		JButton btn_add = new JButton("Add user");
		JButton btn_delete = new JButton("Delete");
		JButton btn_update = new JButton("Update");
		// JButton btn_logout = new JButton("Logout");
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.add(btn_add);
		p1.add(btn_delete);
		p1.add(btn_update);
		btn_update.setEnabled(false);
		// p1.add(btn_logout);

		JButton btn_refrech = new JButton("RESET");
		p1.add(btn_refrech);

		JButton btn_sort = new JButton("sort");
		p1.add(btn_sort);

		JScrollPane jScrollPane = new JScrollPane(jTable);
		this.add(jScrollPane, BorderLayout.CENTER);
		// this.add(jTable, BorderLayout.CENTER);

		this.add(p1, BorderLayout.SOUTH);

		
		pack();
		setLocationRelativeTo(null); // put the jframe in the center of the screen
		setSize(700, 500);
		

		btn_refrech.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text_search.setText("");
				jTable.setModel(Helper.getUpdatedModel(DBUsers.listUsers.values()));

			}
		});

		btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jTable.getSelectedRow();

				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(AdminHome.this, "Select a user first");
					return;
				}

				String selectedEmail = (String) jTable.getValueAt(selectedRow, 2); // position of email field is 2
				// System.out.println(selectedEmail);
				System.out.println(jTable.getValueAt(selectedRow, 2));
				if (selectedEmail != null && selectedEmail != "") {
					int res = JOptionPane.showConfirmDialog(AdminHome.this, "Delete the user : " + selectedEmail);
					System.out.println("res = " + res);
					if (res == JOptionPane.YES_OPTION) {
						DBUsers.listUsers.remove(selectedEmail);
						// System.out.println(DBUsers.listUsers.size());
						// model = reloadData();
						jTable.setModel(Helper.getUpdatedModel(DBUsers.listUsers.values()));
					}
				}
				/*
				 * a very ugly ugly bad bad bad way to do it:
				 * User.listUsers.remove(jTable.getSelectedRow());
				 * model.removeRow(jTable.getSelectedRow());
				 * System.err.println(User.listUsers.size()); jTable.setModel(model);
				 * model.fireTableStructureChanged();
				 * 
				 * 
				 */

			}
		});

		jMenuItem_pagination.addActionListener(new ActionListener() {
			AdminPagination adminPagination = new AdminPagination();

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				adminPagination.setVisible(true);
			}
		});

		AddUserInterface addUserInterface = new AddUserInterface(AdminHome.this, null);
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addUserInterface.setVisible(true);
			}
		});

		jMenuItem_logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminHome.this.dispose();
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

		UserDetails userDetails = new UserDetails(admin);
		userDetails.disableElements();
		jMenuItem_profile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userDetails.setVisible(true);
			}
		});

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

				/*System.out.println("size=" + subList.size());

				String[] columnNames = { "ID", "NOM", "EMAIL", "ROLE", "Note" };
				model = new DefaultTableModel(columnNames, 0);

				// jTable.setTableHeader(tableHeader);

				for (User auser : subList) {
					String[] row = { String.valueOf(auser.getId()), auser.getNom(), auser.getEmail(),
							auser.getRole().toString(), String.valueOf(auser.getNote()) };
					model.addRow(row);
				}
				jTable.setModel(model);*/
				jTable.setModel(Helper.getUpdatedModel(subList));
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		btn_sort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String req = text_search.getText();
				List<User> subList = DBUsers.search(req);
				
				Collections.sort(subList);
				
				
				/*String[] columnNames = { "ID", "NOM", "EMAIL", "ROLE", "Note" };
				model = new DefaultTableModel(columnNames, 0);
				for (User auser : sorted) {
					String[] row = { String.valueOf(auser.getId()), auser.getNom(), auser.getEmail(),
							auser.getRole().toString(), String.valueOf(auser.getNote()) };
					model.addRow(row);
				}
				jTable.setModel(model);*/
				jTable.setModel(Helper.getUpdatedModel(subList));
			}
		});

		
	}

}
