package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderVo;


public class OrderDaoTest {
	public static void main(String[] args) {
		OrderVo vo = new OrderVo();
		vo.setOrderNumber("c456");
		vo.setOrderPrice(50000);
		vo.setAddress("서울시 성북구 돈암동");
		vo.setMemberNo(14L);

		System.out.println("===FindAll===");
		testFindAll();

		System.out.println("===Insert===");
		testInsert(vo);
		testFindAll();
		
		System.out.println("===Delete===");
		testDeleteByOrderNum("c456");
		testFindAll();
	}

	private static void testDeleteByOrderNum(String orderNum) {
		new OrderDao().delete(orderNum);
	}

	private static void testInsert(OrderVo vo) {
		new OrderDao().insert(vo);
	}

	private static void testFindAll() {
		List<OrderVo> list = new OrderDao().findAll();
		for (OrderVo vo : list) {
			System.out.println(vo);
		}
	}

}
