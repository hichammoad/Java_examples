package collections.gestion_exam;

public class Reponse {
	private int id;
	private String ennonce;
	private boolean verite;

	public Reponse(int id, String ennonce, boolean verite) {
		this.id = id;
		this.ennonce = ennonce;
		this.verite = verite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnnonce() {
		return ennonce;
	}

	public void setEnnonce(String ennonce) {
		this.ennonce = ennonce;
	}

	public boolean isVerite() {
		return verite;
	}

	public void setVerite(boolean verite) {
		this.verite = verite;
	}

}
