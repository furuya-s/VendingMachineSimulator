import java.util.ArrayList;


public class ConcreteMediator implements Mediator {
	
	
	private SaleSystemFacade saleSystemFacade;
	private LotterySystemFacade lotterySystemFacade;
	private AccountSystemFacade accountSystemFacade;
	
	private ArrayList<Integer> canBuy;
	
	public ConcreteMediator() {
		saleSystemFacade = new SaleSystemFacade();
		lotterySystemFacade = new LotterySystemFacade();
		accountSystemFacade = new AccountSystemFacade();
	
		canBuy = new ArrayList<Integer>();
	}
	
	public void insertMoney(int money) {
		
		int amount = accountSystemFacade.insertMoney(money);
		canBuy = saleSystemFacade.getCanBuy(amount);
		
	}
	
	public boolean pushButton(int button) {
		if (!canBuy.contains(new Integer(button))) {
			return false;
		}
		
		saleSystemFacade.buy(button);
		accountSystemFacade.minusAmount(saleSystemFacade.getPrice(button));
		
		canBuy.clear();
		
		if (lotterySystemFacade.drawlot()) {
			for (int i = 0; i < 30; i++) {
				if (!saleSystemFacade.isEmpty(i)) {
					canBuy.add(i);
				}
			}
		}
		
		canBuy = saleSystemFacade.getCanBuy(accountSystemFacade.getAmount());
		
		return true;
	}
	
	public String showCanBuy() {
		return canBuy.toString();
	}
	
	public int getChange() {
		return accountSystemFacade.getChange();
	}
}
