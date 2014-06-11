
public class VendingMachineFacade extends Facade {
	
	private ConcreteMediator mediator;
	
	public VendingMachineFacade() {
		mediator = new ConcreteMediator();
	}
	
	public boolean insertMoney(int money) {
		return mediator.insertMoney(money);
	}
	
	public boolean pushButton(int button) {
		return mediator.pushButton(button);
	}
	
	public String getCanBuy() {
		return mediator.getCanBuy();
	}
	
	public int getAmount() {
		return mediator.getAmount();
	}
	
	public int getChange() {
		return mediator.getChange();
	}
	
	public boolean touchIC() {
		return mediator.touchIC();
	}
}
