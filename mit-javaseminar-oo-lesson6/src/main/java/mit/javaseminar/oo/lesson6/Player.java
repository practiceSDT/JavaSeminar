package mit.javaseminar.oo.lesson6;

/**
 * プレイヤーを表すクラス。
 */
public class Player
{
	/** 名前 */
	private String name_;

	/** テーブル */
	Table table_;

	/** 手札 */
	Hand myHand_ = new Hand();

	/** 進行役 */
	Master master_;

	/** パスした回数 */
	int pass_;

	/**
	 * コンストラクタ。
	 * 
	 * @param name 名前
	 * @param master 進行役
	 * @param table テーブル
	 */
	public Player(String name, Master master, Table table)
	{
		this.name_ = name;
		this.master_ = master;
		this.table_ = table;
	}

	/**
	 * 順番を指名する。
	 */
	public void play()
	{
		// 現在の手札を表示する
		System.out.println("  " + myHand_);
		
		// 手札にあるカードを1枚ずつチェックして、場に置けるか調べる
		int handSize = myHand_.getNumberOfCards();
		for (int position = 0; position < handSize; position++)
		{
			// 手札にあるカードを見る
			Card lookingCard = myHand_.lookCard(position);

			int number = lookingCard.getNumber();
			int suit = lookingCard.getSuit();

			// 今注目している手札の左か右にカードがあれば、カードを置ける
			int leftNumber = (number != 1) ? number - 1 : 13;
			int rightNumber = (number != 13) ? number + 1 : 1;

			if ((true == table_.isThereCard(suit, leftNumber))
				|| (true == table_.isThereCard(suit, rightNumber)))
			{
				// 手札からカードを引いてテーブルに置く
				table_.putCard(myHand_.pickCard(position));

				// 手札がなくなったら、上がりを宣言する
				if (myHand_.getNumberOfCards() == 0)
				{
					master_.declareWin(this);
				}

				return;
			}
		}

		// テーブルに置けるカードがなかった場合、パスする
		pass_++;
		master_.pass(this);

		// パス回数が4回以上ならばカードを全てテーブルに置く
		if (pass_ > 3)
		{
			// 手札を全てテーブルに置く
			for (int count = 0; count < handSize; count++)
			{
				table_.putCard(myHand_.pickCard(0));
			}
		}
	}

	/**
	 * カードを受け取る。
	 * 
	 * @param card 受け取ったカード
	 */
	public void receiveCard(Card card)
	{
		if (card.getNumber() == 7)
		{
			// カードが7の場合は、テーブルにカードを置く
			table_.putCard(card);
		}
		else
		{
			// カードが7でない場合は、受け取ったカードを手札へ加える
			myHand_.addCard(card);
		}
	}

	/**
	 * パス回数を聞く。
	 * 
	 * @return パス回数
	 */
	public int getPass()
	{
		return pass_;
	}

	/**
	 * プレイヤーの名前を返す。
	 * ObjectクラスのtoStringメソッドをオーバーライドしたメソッド。
	 * 
	 * @return プレイヤーの名前
	 */
	public String toString()
	{
		return name_;
	}
}
