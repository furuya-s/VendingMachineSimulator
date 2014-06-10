import java.util.ArrayList;


public class AccountSystemFacade extends Facade {
	private Account account;
	
	public AccountSystemFacade() {
		account = new Account();
	}
	
	public int insertMoney(int money) {
		account.insertMoney(money);
		return account.getMoney();
	}
	
	public void minusAmount(int money) {
		account.minusAmount(money);
	}
	
	public int getChange() {
		return account.getChange();
	}
	
	public int getAmount() {
		return account.getAmount();
	}
}
