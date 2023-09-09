package bookmall.vo;

public class CartVo {
	private int count;
	private Long memberNo;
	private Long bookNo;

	public CartVo() {
	}

	public CartVo(int count, Long memberNo, Long bookNo) {
		super();
		this.count = count;
		this.memberNo = memberNo;
		this.bookNo = bookNo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	@Override
	public String toString() {
		return "CartVo [count=" + count + ", memberNo=" + memberNo + ", bookNo=" + bookNo + "]";
	}

}
