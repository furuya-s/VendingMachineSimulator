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
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]", vmf.getCanBuy());

		vmf.pushButton(5);
		assertEquals("[]", vmf.getCanBuy());
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
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]", vmf.getCanBuy());
		
		vmf.pushButton(5);
		assertEquals("[]", vmf.getCanBuy());
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
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29]", vmf.getCanBuy());
		
		vmf.pushButton(29);
		assertEquals(150, vmf.getAmount());
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]", vmf.getCanBuy());
	
		vmf.pushButton(15);
		assertEquals(0, vmf.getAmount());
		assertEquals("[]", vmf.getCanBuy());
	}
	
	/**
	 * 120�~�̃W���[�X�̃{�^����������IC�ɂ���Ĕ���
	 */
	@Test
	public void test4() {
		vmf.pushButton(0);
		assertEquals(0, vmf.getAmount());
		
		assertTrue(vmf.touchIC());
		assertEquals("[]", vmf.getCanBuy());
		assertEquals(0, vmf.getChange());
	}
	
	/**
	 * �{�^������������ɂ�����200�~�����200�~�̃W���[�X�𔃂�
	 */
	@Test
	public void test5() {
		vmf.pushButton(0);
		vmf.insertMoney(100);
		vmf.insertMoney(100);
		
		assertEquals(200, vmf.getAmount());
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29]", vmf.getCanBuy());

		vmf.pushButton(29);
		assertEquals("[]", vmf.getCanBuy());
	}
	
	/**
	 * 1�~������Ǝ󂯕t���Ȃ�
	 */
	@Test
	public void test6() {
		vmf.insertMoney(1);
		assertEquals(0, vmf.getAmount());
	}
}
