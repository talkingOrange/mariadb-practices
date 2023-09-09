package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;


public class CartDaoTest {
	public static void main(String[] args) {
		CartVo vo = new CartVo();
		vo.setCount(2);
		vo.setMemberNo(6L);
		vo.setBookNo(22L);

		System.out.println("===FindAll===");
		testFindAll();

		System.out.println("===Insert===");
		testInsert(vo);
		testFindAll();
		
		System.out.println("===Delete===");
		testDeleteByPasswd(6L, 22L);
		testFindAll();
	}

	private static void testDeleteByPasswd(Long memberNo, Long bookNo) {
		new CartDao().delete(memberNo, bookNo);
	}

	private static void testInsert(CartVo vo) {
		new CartDao().insert(vo);
	}

	private static void testFindAll() {
		List<CartVo> list = new CartDao().findAll();
		for (CartVo vo : list) {
			System.out.println(vo);
		}
	}


}
