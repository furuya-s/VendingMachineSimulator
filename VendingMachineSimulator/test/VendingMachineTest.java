import org.junit.Test;
import static org.junit.Assert.*;


public class VendingMachineTest {
	
	VendingMachineFacade vmf = new VendingMachineFacade();
	
	/**
	 * 120円を入れて120円のジュースを1本買う
	 */
	@Test
	public void test1() {
		// ジュースの数は30個で
		// 5個は200円、10個は150円、15個が120円
		vmf.insertMoney(100);
		vmf.insertMoney(10);
		vmf.insertMoney(10);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]", vmf.getCanBuy());

		vmf.pushButton(5);
		assertEquals("[]", vmf.getCanBuy());
	}
	
	/**
	 * 140円を入れて120円のジュースを1本買っておつりを20円もらう
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
	 * 350円を入れて200円のジュースを1本と150円のジュースを1本を買う
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
	 * 120円のジュースのボタンを押してICによって買う
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
	 * ボタンを押した後にお金を200円入れて200円のジュースを買う
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
	 * 1円を入れると受け付けない
	 */
	@Test
	public void test6() {
		vmf.insertMoney(1);
		assertEquals(0, vmf.getAmount());
	}
}
