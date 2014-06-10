import java.util.ArrayList;


public class Sale {

	// 0番目から29番目のジュースの在庫数
	private ArrayList<Integer> stock;
	// 各ジュースの値段
	private ArrayList<Integer> price;
	// ジュースの種類の個数
	private static int NUMJ = 30;
	// 初期在庫数
	private static int ZAIKO = 20;
	
	
	public Sale() {
		stock = new ArrayList<Integer>();
		price = new ArrayList<Integer>();
		for (int i = 0; i < NUMJ; i++) {
			stock.add(ZAIKO);
			if (i < 15) {
				price.add(120);
			} else if (i < 25) {
				price.add(150);
			} else {
				price.add(200);
			}
		}
	}
	
	// 買えるジュースの番号のリストを返す
	public ArrayList<Integer> getCanBuy(int amount) {
		ArrayList<Integer> buyList = new ArrayList<Integer>();
		for(int i = 0; i < NUMJ; i++) {
			if (stock.get(i) != 0 && price.get(i) <= amount) {
				buyList.add(i);
			}
		}
		
		return buyList;
	}
	
	// juice番目のジュースの値段を返す
	public int getPrice(int juice) {
		return price.get(juice);
	}
	
	public void reduceStock(int juice) {
		stock.set(juice, stock.get(juice)-1); 
	}
	
	public boolean isEmpty(int juice) {
		return stock.get(juice) == 0 ? true : false;
	}
}
