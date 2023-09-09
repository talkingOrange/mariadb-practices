package bookmall.vo;

public class OrderVo {
	private Long no;
	private String orderNumber;
	private int orderPrice;
	private String address;
	private Long memberNo;
	private String name;
	private String email;
	private int count;
	private Long bookNo;
	private String title;
	
	public OrderVo() {
	}
	

	public OrderVo(String orderNumber, int orderPrice, String address, Long memberNo) {
		super();
		this.orderNumber = orderNumber;
		this.orderPrice = orderPrice;
		this.address = address;
		this.memberNo = memberNo;
	}


	public OrderVo(Long no, Long bookNo, int count) {
		super();
		this.no = no;
		this.bookNo = bookNo;
		this.count = count;
	}


	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", orderNumber=" + orderNumber + ", orderPrice=" + orderPrice + ", address="
				+ address + ", memberNo=" + memberNo + ", name=" + name + ", email=" + email + ", count=" + count
				+ ", bookNo=" + bookNo + ", title=" + title + "]";
	}

}
