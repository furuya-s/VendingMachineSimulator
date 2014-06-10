import org.junit.Test;
import static org.junit.Assert.*;


public class VendingMachineTest {
	
	VendingMachineFacade vmf = new VendingMachineFacade();
	
	/**
	 * 120�~������120�~�̃W���[�X��1�{����
	 */
	@Test
	public void test1() {
		// �W���[�X�̐���30��
		// 5��200�~�A10��150�~�A15��120�~
		vmf.insertMoney(100);
		vmf.insertMoney(10);
		vmf.insertMoney(10);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]", vmf.showCanBuy());

		vmf.pushButton(5);
		assertEquals("[]", vmf.showCanBuy());
	}
	
	/**
	 * 140�~������120�~�̃W���[�X��1�{�����Ă����20�~���炤
	 */
	@Test
	public void test2() {
		vmf.insertMoney(100);
		vmf.insertMoney(10);
		vmf.insertMoney(10);
		vmf.insertMoney(10);
		vmf.insertMoney(10);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]", vmf.showCanBuy());
		
		vmf.pushButton(5);
		assertEquals("[]", vmf.showCanBuy());
		assertEquals(20, vmf.getChange());
	}
	
	/**
	 * 350�~������200�~�̃W���[�X��1�{��150�~�̃W���[�X��1�{�𔃂�
	 */
	@Test
	public void test3() {
		vmf.insertMoney(100);
		vmf.insertMoney(100);
		vmf.insertMoney(100);
		vmf.insertMoney(50);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29]", vmf.showCanBuy());
		
		vmf.pushButton(29);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]", vmf.showCanBuy());
	
		vmf.pushButton(15);
		assertEquals("[]", vmf.showCanBuy());
		
		assertEquals(0, vmf.getChange());
	}
}
