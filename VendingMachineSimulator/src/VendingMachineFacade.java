
public class VendingMachineFacade extends Facade {
	
	private ConcreteMediator mediator;
	
	public VendingMachineFacade() {
		mediator = new ConcreteMediator();
	}
	
	public void insertMoney(int money) {
		mediator.insertMoney(money);
		
	}
}
