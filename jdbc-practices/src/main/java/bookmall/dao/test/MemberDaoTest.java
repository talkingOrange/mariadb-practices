package bookmall.dao.test;

import java.util.List;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest {
	public static void main(String[] args) {
		MemberVo vo = new MemberVo();
		vo.setName("에옹씨");
		vo.setTel("01055555555");
		vo.setEmail("5555@gmail.com");
		vo.setPasswd("5555");

		System.out.println("===FindAll===");
		testFindAll();

		System.out.println("===Insert===");
		testInsert(vo);
		testFindAll();
		
		System.out.println("===Delete===");
		testDeleteByPasswd("3333");
		testFindAll();
	}

	private static void testDeleteByPasswd(String passwd) {
		new MemberDao().delete(passwd);
	}

	private static void testInsert(MemberVo vo) {
		new MemberDao().insert(vo);
	}

	private static void testFindAll() {
		List<MemberVo> list = new MemberDao().findAll();
		for (MemberVo vo : list) {
			System.out.println(vo);
		}
	}



}
