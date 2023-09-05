package bookmall.vo;

public class CartVo {
	private int count;
	private int memberNo;
	private int bookNo;
	private String title;
	private int price;
	
	public CartVo() {
	}

	public CartVo(int count, int memberNo, int bookNo, String title, int price) {
		super();
		this.count = count;
		this.memberNo = memberNo;
		this.bookNo = bookNo;
		this.title = title;
		this.price = price;
	}



	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "CartVo [count=" + count + ", memberNo=" + memberNo + ", bookNo=" + bookNo + ", title=" + title
				+ ", price=" + price + "]";
	}
	
}
