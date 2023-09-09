package bookmall.main;

import java.util.List;
import java.util.Scanner;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderVo;
import bookmall.vo.CartVo;

public class BookMall {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("##1 회원 리스트"); //2
		doMemberInsertAndDelete();
		doMemberList();
		
		System.out.println();
		System.out.println("##2 카테고리 리스트"); //3
		doCategoryInsertAndDelete();
		doCategoryList();
		
		System.out.println();
		System.out.println("##3 상품 리스트"); //3
		doBookInsertAndDelete();
		doBookList();

		System.out.println();
		System.out.println("##4 카트 리스트"); //2
		doCartInsertAndDelete();
		doCartList();

		System.out.println();
		System.out.println("##5 주문 리스트"); //1
		doOrderInsertAndDelete();
		doOrderList();

		System.out.println();
		System.out.println("##6 주문도서"); //2
		doOrderBookInsertAndDelete();
		doOrderBookList();


	}

	private static void doMemberInsertAndDelete() {
		new MemberDao().insert(new MemberVo("에옹씨", "01034781504", "sonrisa-bonita@naver.com", "1111"));
		new MemberDao().insert(new MemberVo("은영씨", "01024796740", "rlo0_jjang@naver.com", "2222"));
		new MemberDao().insert(new MemberVo("용현씨", "01099809915", "yonghyn@naver.com", "3333"));
		new MemberDao().delete("3333");
	}

	private static void doMemberList() {
		List<MemberVo> list = new MemberDao().findAll();
		for (MemberVo vo : list) {
			System.out.println("이름:" + vo.getName() + ", 전화번호:" + vo.getTel() + ", 이메일:" + vo.getEmail() + ", 비밀번호:"
					+ vo.getPasswd());
		}
	}
	
	private static void doCategoryInsertAndDelete() {
		new CategoryDao().insert(new CategoryVo("철학"));
		new CategoryDao().insert(new CategoryVo("기술과학"));
		new CategoryDao().insert(new CategoryVo("문학"));
		new CategoryDao().insert(new CategoryVo("역사"));
		new CategoryDao().delete("역사");
	}


	private static void doCategoryList() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for (CategoryVo vo : list) {
			System.out.println("카테고리명:" + vo.getName());
		}
		
	}
	
	private static void doBookInsertAndDelete() {
		new BookDao().insert(new BookVo("자바가 사람 자바", 36000, 2L ));
		new BookDao().insert(new BookVo("설득의 심리학", 24000, 1L ));
		new BookDao().insert(new BookVo("불편한 편의점", 18000, 3L ));
		new BookDao().insert(new BookVo("이것이 자바다", 32000, 2L ));
		new BookDao().delete("이것이 자바다");
	}
	
	private static void doBookList() {
		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println("도서명:" + vo.getTitle() + ", 가격:" + vo.getPrice());
		}
		
	}

	private static void doCartInsertAndDelete() {
		new CartDao().insert(new CartVo(2, 1L, 2L));
		new CartDao().insert(new CartVo(5, 2L, 3L));
		new CartDao().insert(new CartVo(1, 1L, 3L));
		new CartDao().delete(2L, 3L);
	}
	
	private static void doCartList() {
		List<CartVo> list = new CartDao().findAll();
		for (CartVo vo : list) {
			BookDao bdao = new BookDao();
			System.out.println("도서명:"+bdao.findBookTitleByNo(vo.getBookNo()) + ", 수량:" + vo.getCount() + ", 가격:" + bdao.findBookPriceByNo(vo.getBookNo())  );
		}
	}

	private static void doOrderInsertAndDelete() {
		new OrderDao().insert(new OrderVo("a123", 30000, "경기도 용인시 기흥구", 1L));
		new OrderDao().insert(new OrderVo("b123", 40000, "서울특별시 성북구", 2L));
		new OrderDao().delete("b123");
	}
	
	private static void doOrderList() {
		List<OrderVo> list = new OrderDao().findAll();
		for (OrderVo vo : list) {
			MemberDao mdao = new MemberDao();
			System.out.println("주문번호:" + vo.getOrderNumber() +  ", 주문자:" + mdao.findMemberNameByNo(vo.getMemberNo())  + "/" + mdao.findMemberEmailByNo(vo.getMemberNo())  +", 결제금액:"+ vo.getOrderPrice() + ", 배송지:" + vo.getAddress() );
		}
	}
	
	
	private static void doOrderBookInsertAndDelete() {
		new OrderDao().orderBookInsert(new OrderVo(1L, 2L, 3));
		new OrderDao().orderBookInsert(new OrderVo(2L, 1L, 2));
		//new OrderDao().orderBookdelete(1L);
	}
	
	private static void doOrderBookList() {
		List<OrderVo> list = new OrderDao().findOrderBookAll();
		for (OrderVo vo : list) {
			BookDao bdao = new BookDao();
			System.out.println("도서번호:" + vo.getBookNo() + ", 도서제목:" + bdao.findBookTitleByNo(vo.getBookNo()) +  ", 수량:" + vo.getCount() );
		}
		
		
		
	}

}
