
public class VendingMachineFacade extends Facade {
	
	private ConcreteMediator mediator;
	
	public VendingMachineFacade() {
		mediator = new ConcreteMediator();
	}
	
	public void insertMoney(int money) {
		mediator.insertMoney(money);
	}
	
	public boolean pushButton(int button) {
		return mediator.pushButton(button);
	}
	
	public String showCanBuy() {
		return mediator.showCanBuy();
	}
	
	public int getChange() {
		return mediator.getChange();
	}
}
