package gui_swing.ex1.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUsers {

	// Users are identified by their email address;

	// public static List<User> listUsers = new ArrayList<User>();
	public static Map<String, User> listUsers = new HashMap<String, User>();

	// we can also call it in the Main.main function
	static {
		generate_users();
		show_users();
	}

	// generate random users:
	public static void generate_users() {
		listUsers.put("emailu", new User(1, "default user", "emailu", "emailu", Roles.user, 10));
		listUsers.put("admin", new User(2, "Admin user", "admin", "admin", Roles.admin, 20));

		// generate random users using a loop:
		for (int i = 0; i < 3; i++) {
			listUsers.put("email" + i, new User(i + 10, i + "th User ", "email" + i, "1234", Roles.user, i));
		}
	}

	// show users:
	public static void show_users() {
		// lambda expression
		listUsers.forEach((key, val) -> {
			System.out.println(val);
		});
	}

	// validate email/password credentials:
	public static User verifierUser(User u) {
		User myUser = listUsers.get(u.getEmail());
		if (myUser != null) {
			if (myUser.getPassword().equals(u.getPassword())) {
				return myUser;
			}
		}
		return null;
	}

	// vérifie si l'email existe dans la liste des utilisateurs:
	public static boolean userExists(String email) {
		return listUsers.containsKey(email);
	}

	public static List<User> search(String req) {
		List<User> trouve = new ArrayList<User>();
		for (User u : listUsers.values()) {
			if (u.getNom().contains(req) || u.getEmail().contains(req)) {
				trouve.add(u);
			}
		}
		return trouve;
	}

}
