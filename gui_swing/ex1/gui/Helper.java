package gui_swing.ex1.gui;

import java.util.Collection;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import gui_swing.ex1.model.User;

public class Helper {

	
	static String[] tableHeader = { "ID", "NOM", "EMAIL", "ROLE", "Note" };;
	
	
	public static TableModel getUpdatedModel(Collection<User> newData) {
		DefaultTableModel newModel = new DefaultTableModel(tableHeader, 0);
		for (User u : newData) {
			Object[] rowData = { u.getId(), u.getNom(), u.getEmail(), u.getRole(), u.getNote() };
			newModel.addRow(rowData);
		}
		return newModel;
	}

}
