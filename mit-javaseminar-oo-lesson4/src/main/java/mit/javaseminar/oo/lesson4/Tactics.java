package mit.javaseminar.oo.lesson4;

/**
 * ジャンケン戦略インターフェース。
 */
public interface Tactics
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
	public int readTactics();
}
