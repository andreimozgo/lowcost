package dto;

public class News extends Entity {
	
	private int id;
	private String title;
	private String annotation;
	private String author;
	private String date;
	
	public News(){
		
	}
	
	public News(int id, String title, String annotation, String author, String date){
		
		this.id = id;
		this.title = title;
		this.annotation = annotation;
		this.author = author;
		this.date = date;
	}
	
	public int getId(){
		return id;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getAnnotation(){
		return annotation;
	}

	public String getAuthor(){
		return author;
	}
	
	public String toString(){
		return title+annotation+author+date;
	}
}
