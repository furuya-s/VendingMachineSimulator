
public class LotterySystemFacade extends Facade {
	private Lottery lottery;
	
	/*
	 * ’Š‘I‚·‚é
	 */
	public void drawlot() {
		int num = lottery.getRandomNumber();
		boolean result = lottery.judgment(num);
	}
}
