
public class LotterySystemFacade extends Facade {
	private Lottery lottery;
	
	public LotterySystemFacade() {
		lottery = new Lottery();
	}
	
	/*
	 * ���I����
	 */
	public boolean drawlot() {
		// �_�~�[�F�K���O���
		return false;
		
		// ���I����ꍇ�͂��̃R�[�h�����s����
		/*
		int num = lottery.getRandomNumber();
		return lottery.judgment(num);
		*/
	}
}
