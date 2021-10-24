package model;

public class FilmModel extends Model {
	private int filmID;
	private String filmName;
	private String category;
	private String subtitle;
	
	public FilmModel() {
	
	}
	
	public FilmModel(int filmID, String filmName, String category, String subtitle) {
		super();
		this.filmID = filmID;
		this.filmName = filmName;
		this.category = category;
		this.subtitle = subtitle;
	}
	
	public int getFilmID() {
		return filmID;
	}
	
	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}
	
	public String getFilmName() {
		return filmName;
	}
	
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getSubtitle() {
		return subtitle;
	}
	
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}	
}
