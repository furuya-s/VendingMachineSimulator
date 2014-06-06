
public class ConcreteMediator implements Mediator {
	
	
	private SaleSystemFacade saleSystemFacade;
	private LotterySystemFacade lotterySystemFacade;
	private AccountSystemFacade accountSystemFacade;
	
	public ConcreteMediator() {
		saleSystemFacade = new SaleSystemFacade();
		lotterySystemFacade = new LotterySystemFacade();
		accountSystemFacade = new AccountSystemFacade();
	}
	
	public void insertMoney(int money) {

	}
}
