
public class LotterySystemFacade extends Facade {
	private Lottery lottery;
	
	/*
	 * ���I����
	 */
	public void drawlot() {
		int num = lottery.getRandomNumber();
		boolean result = lottery.judgment(num);
	}
}
