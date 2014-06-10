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
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]", vmf.showCanBuy());

		vmf.pushButton(5);
		assertEquals("[]", vmf.showCanBuy());
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
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]", vmf.showCanBuy());
		
		vmf.pushButton(5);
		assertEquals("[]", vmf.showCanBuy());
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
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29]", vmf.showCanBuy());
		
		vmf.pushButton(29);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]", vmf.showCanBuy());
	
		vmf.pushButton(15);
		assertEquals("[]", vmf.showCanBuy());
		
		assertEquals(0, vmf.getChange());
	}
}
