package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
		BookVo vo = new BookVo();
		vo.setTitle("이것이 자바다");
		vo.setPrice(30000);
		vo.setCategoryNo(2);

		System.out.println("===FindAll===");
		testFindAll();

		System.out.println("===Insert===");
		testInsert(vo);
		testFindAll();
		
		System.out.println("===Delete===");
		testDeleteByTitle("이것이 자바다");
		testFindAll();
	}

	private static void testDeleteByTitle(String title) {
		new BookDao().delete(title);
	}

	private static void testInsert(BookVo vo) {
		new BookDao().insert(vo);
	}

	private static void testFindAll() {
		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}


}
