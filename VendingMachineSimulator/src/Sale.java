import java.util.ArrayList;


public class Sale {

	// 0�Ԗڂ���29�Ԗڂ̃W���[�X�̍݌ɐ�
	private ArrayList<Integer> stock;
	// �e�W���[�X�̒l�i
	private ArrayList<Integer> price;
	// �W���[�X�̎�ނ̌�
	private static int NUMJ = 30;
	// �����݌ɐ�
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
	
	// ������W���[�X�̔ԍ��̃��X�g��Ԃ�
	public ArrayList<Integer> getCanBuy(int amount) {
		ArrayList<Integer> buyList = new ArrayList<Integer>();
		for(int i = 0; i < NUMJ; i++) {
			if (stock.get(i) != 0 && price.get(i) <= amount) {
				buyList.add(i);
			}
		}
		
		return buyList;
	}
	
	// juice�Ԗڂ̃W���[�X�̒l�i��Ԃ�
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
