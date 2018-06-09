package mit.javaseminar.oo.lesson4;

/**
 * ランダムに手を決める戦略クラス。
 */
public class RandomTactics implements Tactics
{
	/**
	 * 戦略を読み、ジャンケンの手を得る。
	 * グー・チョキ・パーのいずれかをPlayerクラスに定義された
	 * 以下の定数で返す。
	 * Player.STONE    ・・・ グー
	 * Player.SCISSORS ・・・ チョキ
	 * Player.PAPER    ・・・ パー
	 * 
	 * @return ジャンケンの手
	 */
	public int readTactics()
	{
		// プレイヤーの手
		int hand = 0;
        
		// 0以上3未満の小数として乱数を得る
		double randomNum = Math.random() * 3;
		if (randomNum < 1)
		{
			// randomNum が 0以上1未満の場合、グー
			hand = Player.STONE;
		}
		else if (randomNum < 2)
		{
			// randomNum が 1以上2未満の場合、チョキ
			hand = Player.SCISSORS;
		}
		else if (randomNum < 3)
		{
			// randomNum が 2以上3未満の場合、パー
			hand = Player.PAPER;
		}
        
		// 決定した手を戻り値として返す
		return hand;
	}
}

