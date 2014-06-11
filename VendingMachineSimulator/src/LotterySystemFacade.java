
public class LotterySystemFacade extends Facade {
	private Lottery lottery;
	
	public LotterySystemFacade() {
		lottery = new Lottery();
	}
	
	/*
	 * 抽選する
	 */
	public boolean drawlot() {
		// ダミー：必ず外れる
		return false;
		
		// 抽選する場合はこのコードを実行する
		/*
		int num = lottery.getRandomNumber();
		return lottery.judgment(num);
		*/
	}
}
