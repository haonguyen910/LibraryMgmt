package entities;

public class Author {
	private int id;
	private String name;

//ToString
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}

//Get-Set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//Constructor
	public Author(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Author() {
		super();
	}

}
