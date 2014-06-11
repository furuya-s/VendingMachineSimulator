
public class Account {
	private int amount;
	
	public Account() {
		initMoney();
	}
	
	public void initMoney() {
		amount = 0;
	}
	
	public boolean insertMoney(int money) {
		if (money == 1000 || money == 500 || money == 100 || money == 50 || money == 10) {
			amount += money;
			return true;
		} else {
			return false;
		}
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
	
	public boolean payByIC() {
		// É_É~Å[
		return true;
	}
}
