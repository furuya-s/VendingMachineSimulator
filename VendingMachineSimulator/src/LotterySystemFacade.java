
public class LotterySystemFacade extends Facade {
	private Lottery lottery;
	
	public LotterySystemFacade() {
		lottery = new Lottery();
	}
	
	/*
	 * ’Š‘I‚·‚é
	 */
	public boolean drawlot() {
		int num = lottery.getRandomNumber();
		return lottery.judgment(num);
	}
}
