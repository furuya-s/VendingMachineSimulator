import java.util.ArrayList;


public class ConcreteMediator implements Mediator {
	
	
	private SaleSystemFacade saleSystemFacade;
	private LotterySystemFacade lotterySystemFacade;
	private AccountSystemFacade accountSystemFacade;
	private AdminSystemFacade adminSystemFacade;
	
	private ArrayList<Integer> canBuy;
	
	private boolean ICmode;
	private int touchedButton;
	private boolean WINmode;
	
	public ConcreteMediator() {
		saleSystemFacade = new SaleSystemFacade();
		lotterySystemFacade = new LotterySystemFacade();
		accountSystemFacade = new AccountSystemFacade();
		adminSystemFacade = new AdminSystemFacade();
	
		canBuy = new ArrayList<Integer>();
		
		ICmode = false;
	}
	
	public boolean insertMoney(int money) {
		boolean result = accountSystemFacade.insertMoney(money);
		canBuy = saleSystemFacade.getCanBuy(accountSystemFacade.getAmount());
		
		return result;
	}
	
	public String getSoldOut() {
		ArrayList<Integer> soldOut = new ArrayList<Integer>();
		for (int i = 0; i < 30; i++) {
			if (saleSystemFacade.isEmpty(i)) {
				soldOut.add(i);
			}
		}
		
		return soldOut.toString();
	}
	
	public boolean pushButton(int button) {
		// ŒœÜó‘Ô‚¾‚Á‚½‚ç
		
		// ‚¨‹à‚ð“ü‚ê‚¸‚Éƒ{ƒ^ƒ“‚ð‰Ÿ‚·‚ÆICŽó•tó‘Ô‚É‚È‚é
		if (!ICmode && accountSystemFacade.getAmount() == 0) {
			ICmode = true;
			touchedButton = button;
			return true;
		}
		
		// ÝŒÉ‚ª‚È‚¢‚Æ‚«
		if (!canBuy.contains(new Integer(button))) {
			return false;
		}
		
		saleSystemFacade.buy(button);
		accountSystemFacade.minusAmount(saleSystemFacade.getPrice(button));
		
		canBuy.clear();
		
		canBuy = saleSystemFacade.getCanBuy(accountSystemFacade.getAmount());
		
		if (!WINmode && lotterySystemFacade.drawlot()) {
			WINmode = true;
			for (int i = 0; i < 30; i++) {
				if (!saleSystemFacade.isEmpty(i)) {
					canBuy.add(i);
				}
			}
		}
		
		return true;
	}
	
	public String getCanBuy() {
		return canBuy.toString();
	}
	
	public int getAmount() {
		return accountSystemFacade.getAmount();
	}
	
	public int getChange() {
		return accountSystemFacade.getChange();
	}
	
	public boolean touchIC() {
		if (!ICmode || accountSystemFacade.getAmount() != 0) {
			return false;
		}
		
		boolean result = accountSystemFacade.payByIC();
		if (!result) {
			return false;
		} else {
			saleSystemFacade.buy(touchedButton);
			ICmode = false;
			return true;
		}
	}
	
	public void setPrice(int juice, int money) {
		adminSystemFacade.setPrice(juice, money);
	}
	
	public void setMaxAmount(int max) {
		adminSystemFacade.setMaxAmount(max);
	}
	
	public void setAvailableTime(int time) {
		adminSystemFacade.setAvailableTime(time);
	}
	
	public String getSaleInfo() {
		return adminSystemFacade.getSaleInfo();
	}
	
	public void sendDatabase() {
		adminSystemFacade.sendDatabase();
	}
}
