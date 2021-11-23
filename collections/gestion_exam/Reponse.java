package collections.gestion_exam;

public class Reponse {

	private String ennonce;
	private boolean verite;
	
	public Reponse(String ennonce, boolean verite) {
		this.ennonce = ennonce;
		this.verite = verite;
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
