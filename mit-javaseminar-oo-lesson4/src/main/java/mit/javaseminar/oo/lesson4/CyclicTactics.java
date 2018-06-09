package mit.javaseminar.oo.lesson4;

/**
 * グー・チョキ・パーの順番で出す戦略クラス。
 */
class CyclicTactics implements Tactics
{
    /** 最後に出した手(未開始:-1) */
    int lastHand = -1;

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
		// 最後に出した手により、次の手を決める。
		// 最後に出した手は記憶しておく。
		// +-----------------+
		// | 最後   | 次の手 |
		// +-----------------+
		// | グー   | チョキ |
		// | チョキ | パー   |
		// | パー   | グー   |
		// +-----------------+
		lastHand = (lastHand + 1) % 3;

		// 次の手を出す
		return lastHand;
	}
}