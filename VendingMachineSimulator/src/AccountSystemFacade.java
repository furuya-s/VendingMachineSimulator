

public class AccountSystemFacade extends Facade {
	private Account account;
	
	public AccountSystemFacade() {
		account = new Account();
	}
	
	public boolean insertMoney(int money) {
		return account.insertMoney(money);
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
	
	public boolean payByIC() {
		return account.payByIC();
	}
}
