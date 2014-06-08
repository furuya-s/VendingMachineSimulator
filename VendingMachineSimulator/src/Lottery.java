import java.util.Random;

public class Lottery {
	public int getRandomNumber() {
		int num;
		Random rnd = new Random();

		num = rnd.nextInt(10);

		return num;
	}
	
	public boolean judgment(int num) {
		Random rnd = new Random();
		
		if (num == rnd.nextInt(10))
			return (true);
		else
			return (false);
	}
}