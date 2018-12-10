package im430.xmas.business;

public class Gift {
	
	private int id;
	private String description;
	
	public Gift() {
		this.id = -1;
		this.description = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
