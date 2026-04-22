package dto;

public class LbMemberDTO {

	private int book_code;
	private String book_name;
	private String book_author;
	private String book_publication;
	private String book_date;
	private String book_loc;


	public LbMemberDTO() {
	}

	public LbMemberDTO(int book_code, String book_name, String book_author, String book_publication, String book_date,
			String book_loc) {
		this.book_code = book_code;
		this.book_name = book_name;
		this.book_author = book_author;
		this.book_publication = book_publication;
		this.book_date = book_date;
		this.book_loc = book_loc;

	}

	

	@Override
	public String toString() {
		return book_code + "\t" + book_name + "\t" + book_author + "\t" + book_publication + "\t" + book_date + "\t" + book_loc;
	}
	public int getBook_code() {
		return book_code;
	}

	public String getBook_loc() {
		return book_loc;
	}

	public void setBook_loc(String book_loc) {
		this.book_loc = book_loc;
	}

	public void setBook_code(int book_code) {
		this.book_code = book_code;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_publication() {
		return book_publication;
	}

	public void setBook_publication(String book_publication) {
		this.book_publication = book_publication;
	}

	public String getBook_date() {
		return book_date;
	}

	public void setBook_date(String book_date) {
		this.book_date = book_date;
	}

}
