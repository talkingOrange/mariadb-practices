package bookshop.vo;

public class BookVo {
	private int no;
	private String title;
	private String rent;
	private int authorNo;
	private String name;

	public BookVo() {
	}

	public BookVo(int no, String title, String rent, int authorNo, String name) {
		super();
		this.no = no;
		this.title = title;
		this.rent = rent;
		this.authorNo = authorNo;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public int getAuthorNo() {
		return authorNo;
	}

	public void setAuthorNo(int authorNo) {
		this.authorNo = authorNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", rent=" + rent + ", authorNo=" + authorNo + ", name=" + name
				+ "]";
	}


		

}
