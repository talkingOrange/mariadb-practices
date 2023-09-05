package bookmall.main;

import java.util.List;
import java.util.Scanner;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;
import emaillist.dao.EmaillistDao;
import emaillist.vo.EmaillistVo;

public class BookMall {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("##1 회원리스트");
		doMemberList();
		doMemberInsert();
		doMemberDelete();
		System.out.println("##2 카테고리");
		doCategoryList();
		System.out.println("##3 상품(3) - 제목, 가격");
		doBookList();
		System.out.println("##4 카트(2) - 책제목, 수량, 가격");
		doCartList();
		System.out.println("##5 주문(1) - 주문 번호, 주문자, 가격, 배송지");
		doOrderList();
		System.out.println("##6 주문도서(1) - 주문 번호, 주문자, 가격, 배송지");

//		while (true) {
//		System.out.println("이동하고자 하는 페이지 번호를 입력하세요 > ");
//		String command = scanner.nextLine();
//		
//		if("1".equals(command)) {
//			//bookMallCRUD(page);
//		}
//		
//		}

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

	private static void doOrderList() {
		// TODO Auto-generated method stub

	}

	private static void doCartList() {
		// TODO Auto-generated method stub

	}

	private static void doBookList() {
		// TODO Auto-generated method stub

	}

	private static void doCategoryList() {
		// TODO Auto-generated method stub

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
}
