package mit.javaseminar.oo.lesson4_5;

/**
 * ジャンケンを行うプレイヤークラス。
 */
public class Player
{
	/** グー */
	public static final int STONE = 0;

	/** チョキ */
	public static final int SCISSORS = 1;

	/** パー */
	public static final int PAPER = 2;

	/** プレイヤーの名前 */
	private String name;

	/** プレイヤーの勝った回数 */
	private int winCount = 0;

	/** 与えられた戦略 */
	private Tactics tactics_;

	/**
	 * プレイヤークラスのコンストラクタ。
	 * 
	 * @param name 名前
	 */
	public Player(String name)
	{
		this.name = name;
	}

	/**
	 * プレイヤーに戦略を渡す。
	 * 
	 * @param tactics 戦略
	 */
	void setTactics(Tactics tactics)
	{
		tactics_ = tactics;
	}

	/**
	 * ジャンケンの手を出す。
	 *
	 * @return ジャンケンの手
	 */
	int showHand()
	{
		// 与えられた戦略を読んでジャンケンの手を決める
		int hand = tactics_.readTactics();

		// 決定した手を戻り値として返す
		return hand;
	}

	/**
	 * 勝敗を聞く(教える)。
	 *
	 * @param result true:勝ち,false:負け
	 */
	void notifyResult(boolean result)
	{
		if (true == result)
		{
			// 勝った場合は勝ち数を加算する
			winCount += 1;
		}
	}

	/**
	 * 自分の勝った回数を答える
	 *
	 * @return 勝った回数
	 */
	int getWinCount()
	{
		return winCount;
	}

	/**
	 * 自分の名前を答える。
	 * 
	 * @return 名前
	 */
	String getName()
	{
		return name;
	}
}
