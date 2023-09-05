package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDaoTest {
	public static void main(String[] args) {
		CategoryVo vo = new CategoryVo();
		vo.setName("예술");

		System.out.println("===FindAll===");
		testFindAll();

		System.out.println("===Insert===");
		testInsert(vo);
		testFindAll();
		
		System.out.println("===Delete===");
		testDeleteByPasswd("예술");
		testFindAll();
	}

	private static void testDeleteByPasswd(String passwd) {
		new CategoryDao().delete(passwd);
	}

	private static void testInsert(CategoryVo vo) {
		new CategoryDao().insert(vo);
	}

	private static void testFindAll() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for (CategoryVo vo : list) {
			System.out.println(vo);
		}
	}

}
