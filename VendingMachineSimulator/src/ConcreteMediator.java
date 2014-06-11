import java.util.ArrayList;


public class ConcreteMediator implements Mediator {
	
	
	private SaleSystemFacade saleSystemFacade;
	private LotterySystemFacade lotterySystemFacade;
	private AccountSystemFacade accountSystemFacade;
	
	private ArrayList<Integer> canBuy;
	
	private boolean ICmode;
	private int touchedButton;
	private boolean WINmode;
	
	public ConcreteMediator() {
		saleSystemFacade = new SaleSystemFacade();
		lotterySystemFacade = new LotterySystemFacade();
		accountSystemFacade = new AccountSystemFacade();
	
		canBuy = new ArrayList<Integer>();
		
		ICmode = false;
	}
	
	public boolean insertMoney(int money) {
		boolean result = accountSystemFacade.insertMoney(money);
		canBuy = saleSystemFacade.getCanBuy(accountSystemFacade.getAmount());
		
		return result;
	}
	
	public boolean pushButton(int button) {
		// ���܏�Ԃ�������
		
		// ��������ꂸ�Ƀ{�^����������IC��t��ԂɂȂ�
		if (!ICmode && accountSystemFacade.getAmount() == 0) {
			ICmode = true;
			touchedButton = button;
			return true;
		}
		
		// �݌ɂ��Ȃ��Ƃ�
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
}
