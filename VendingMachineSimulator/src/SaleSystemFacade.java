import java.util.ArrayList;


public class SaleSystemFacade extends Facade {
	private Sale sale;
	
	public SaleSystemFacade() {
		sale = new Sale();
	}
	
	public ArrayList<Integer> getCanBuy(int amount) {
		return sale.getCanBuy(amount);
	}
	
	public int getPrice(int juice) {
		return sale.getPrice(juice);
	}
	
	public void buy(int juice) {
		sale.reduceStock(juice);
		// ƒWƒ…[ƒX‚ğ‚Í‚«‚¾‚·
	}
	
	public boolean isEmpty(int juice) {
		return sale.isEmpty(juice);
	}
}
