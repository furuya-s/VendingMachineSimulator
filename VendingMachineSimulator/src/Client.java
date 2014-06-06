
public class Client {
	
	private VendingMachineFacade vendingMachineFacade;
	
	public Client() {
		vendingMachineFacade = new VendingMachineFacade();
		test();
	}
	
	public void test() {
		vendingMachineFacade.insertMoney(100);
	}
}
