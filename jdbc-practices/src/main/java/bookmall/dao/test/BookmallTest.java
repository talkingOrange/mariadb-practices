package bookmall.dao.test;

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

public class BookmallTest {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("##1 회원리스트");
		doMemberList();
		doMemberInsert();
		doMemberDelete();
		System.out.println("##2 카테고리");
		doCategoryList();
		doCategoryInsert();
		doCategoryDelete();
		System.out.println("##3 상품");
		doBookList();
		doBookInsert();
		doBookDelete();
		System.out.println("##4 카트");
		doCartList();
		doCartInsert();
		doCartDelete();
		System.out.println("##5 주문");
		doOrderList();
		doOrderInsert();
		doOrderDelete();
		System.out.println("##6 주문도서");
		doOrderBookList();


		MemberDao memberDao = new MemberDao();

		// memberDao.insert(memberVo1);
		// memberDao.insert(memberVo2);

	}

	private static void bookMallCRUD(String page) {
		while (true) {
			System.out.println("(l)ist (i)nsert (d)elete (q)uit > ");
			String command = scanner.nextLine();
			if ("l".equals(command)) {
				// doList();
			} else if ("i".equals(command)) {
				// doInsert();
			} else if ("d".equals(command)) {
				// doDelete();
			} else if ("q".equals(command)) {
				scanner.close();
				break;
			}
		}
	}


	private static void doMemberList() {
		List<MemberVo> list = new MemberDao().findAll();
		for (MemberVo vo : list) {
			System.out.println("이름:" + vo.getName() + ", 전화번호:" + vo.getTel() + ", 이메일:" + vo.getEmail() + ", 비밀번호:"
					+ vo.getPasswd());
		}
	}
	
	private static void doMemberInsert() {
		System.out.print("이름:");
		String name = scanner.nextLine();
		System.out.print("전화번호:");
		String tel = scanner.nextLine();
		System.out.print("이메일:");
		String email = scanner.nextLine();
		System.out.print("비밀번호:");
		String passwd = scanner.nextLine();
		
		
		
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setTel(tel);
		vo.setEmail(email);
		vo.setPasswd(passwd);
		
		
		
		new MemberDao().insert(vo);
		
		
		doMemberList();
		
	}
	
	private static void doMemberDelete() {
		System.out.print("비밀번호:");
		String passwd = scanner.nextLine();
		new MemberDao().delete(passwd);
		
		doMemberList();
	}
	
	private static void doCategoryList() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for (CategoryVo vo : list) {
			System.out.println("카테고리명:" + vo.getName());
		}
		
	}
	
	private static void doCategoryInsert() {
		System.out.print("카테고리명:");
		String name = scanner.nextLine();
		
		CategoryVo vo = new CategoryVo();
		vo.setName(name);
		
		new CategoryDao().insert(vo);
		
		doCategoryList();
	}
	
	private static void doCategoryDelete() {
		System.out.print("카테고리명:");
		String name = scanner.nextLine();
		new CategoryDao().delete(name);
		
		doCategoryList();
	}
	
	
	private static void doBookList() {
		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println("도서명:" + vo.getTitle() + ", 가격:" + vo.getPrice());
		}
		
	}
	
	private static void doBookInsert() {
		System.out.print("도서명:");
		String title = scanner.nextLine();
		System.out.print("가격:");
		int price = scanner.nextInt();
	    scanner.nextLine();
	    System.out.print("카테고리넘버:");
	    int categoryNo = scanner.nextInt();
	    scanner.nextLine();	
	    
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setPrice(price);
		
		new BookDao().insert(vo);
		
		doBookList();
	}
	
	private static void doBookDelete() {
		System.out.print("도서명:");
		String title = scanner.nextLine();
		new BookDao().delete(title);
		
		doBookList();
	}
	
	private static void doCartList() {
		List<CartVo> list = new CartDao().findAll();
		for (CartVo vo : list) {
			System.out.println("도서명:" +  ", 수량:" + vo.getCount() + ", 가격:");
		}
		
	}

	private static void doCartInsert() {
		System.out.print("개수:");
		int count = scanner.nextInt();
		scanner.nextLine();
		System.out.print("memberNo:");
		int memberNo = scanner.nextInt();
	    scanner.nextLine();
	    System.out.print("bookNo:");
	    int bookNo = scanner.nextInt();
	    scanner.nextLine();	
	    
		CartVo vo = new CartVo();
		vo.setCount(count);
		
		new CartDao().insert(vo);
		
		doCartList();
	}

	
	private static void doCartDelete() {
		System.out.print("memberNo:");
		int memberNo = scanner.nextInt();
	    scanner.nextLine();
	    System.out.print("bookNo:");
		int bookNo = scanner.nextInt();
	    scanner.nextLine();
		//new CartDao().delete(memberNo,bookNo );
		
		doCartList();
	}
	
	private static void doOrderList() {
		List<OrderVo> list = new OrderDao().findAll();
		for (OrderVo vo : list) {
			System.out.println("주문번호:" + vo.getOrderNumber() + ", 주문자:" + vo.getName() + "/" + vo.getEmail()+ ", 결제금액:" + vo.getOrderPrice() + ", 배송지:" + vo.getAddress() );
		}
	}
	
	private static void doOrderInsert() {
		System.out.print("주문번호:");
		String orderNum = scanner.nextLine();
		System.out.print("주문가격:");
		int orderPrice = scanner.nextInt();
	    scanner.nextLine();
	    System.out.print("주소:");
	    String address = scanner.nextLine();
	    System.out.print("memberNo:");
	    Long memberNo = scanner.nextLong();
	    scanner.nextLine();	
	    
	    OrderVo vo = new OrderVo();
		vo.setOrderNumber(orderNum);
		vo.setOrderPrice(orderPrice);
		vo.setAddress(address);
		vo.setMemberNo(memberNo);
		
		new OrderDao().insert(vo);
		
		doOrderList();
	}

	
	private static void doOrderDelete() {
		System.out.print("memberNo:");
		String orderNum = scanner.nextLine();
	  
		new OrderDao().delete(orderNum);
		
		doOrderList();
	}
	
	private static void doOrderBookList() {
		List<OrderVo> list = new OrderDao().findAll();
		for (OrderVo vo : list) {
			System.out.println("도서번호:" + vo.getBookNo() + ", 도서제목:" + vo.getTitle() +  ", 수량:" + vo.getCount() );
		}
	}

}
