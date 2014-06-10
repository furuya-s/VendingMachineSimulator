
public class Account {
	private int amount;
	
	public Account() {
		initMoney();
	}
	
	public void initMoney() {
		amount = 0;
	}
	
	public void insertMoney(int money) {
		amount += money;
	}
	
	public int getMoney() {
		return amount;
	}
	
	public void minusAmount(int money) {
		amount -= money;
	}
	
	public int getChange() {
		int change = amount;
		amount = 0;
		return change;
	}
	
	public int getAmount() {
		return amount;
	}
}
