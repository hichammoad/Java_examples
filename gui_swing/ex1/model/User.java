package gui_swing.ex1.model;

import java.util.ArrayList;
import java.util.List;

public class User implements Comparable<User> {

	int id;
	String email;
	String password;
	String nom;
	Roles role;
	int note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String nom, String email, String password, Roles role, int note) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.role = role;
		this.note = note;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + nom + " " + email;
	}

	public int compareTo(User o) {
		/*
		 * if (this.note > o.getNote()) { return 1; } else if (this.note < o.getNote())
		 * { return -1; } else { return 0; }
		 */
		return note - o.getNote();
	}

}
