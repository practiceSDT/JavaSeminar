package mit.javaseminar.oo.lesson6;

import java.util.ArrayList;

/**
 * 手札を表すクラス。
 */
public class Hand
{
	/** 手札にあるカードを保持するためのリスト */
	private ArrayList<Card> deal_ = new ArrayList<Card>();

	/**
	 * カードを加える。
	 * 
	 * @param card 加えるカード
	 */
	public void addCard(Card card)
	{
		// カードをリストの最後に追加する
		deal_.add(card);
	}

	/**
	 * 手札にあるカードを見る。
	 * positionは 0 から getNumberOfCards() の範囲で指定するすること。
	 * 
	 * @param position カードの位置。
	 * @return position で指定された位置のカード。範囲外の場合はnullを返す。
	 */
	public Card lookCard(int position)
	{
		Card lookingCard = null;

		// 引数で指定された位置が妥当であるかチェックする 
		if ((0 <= position) && (position < deal_.size()))
		{
			lookingCard = (Card)deal_.get(position);
		}

		return lookingCard;
	}

	/**
	 * 手札からカードを引く。
	 * 引いたカードは手札から削除される。
	 * 
	 * @param position カードの位置。
	 * @return position で指定された位置のカード。範囲外の場合はnullを返す。
	 */
	public Card pickCard(int position)
	{
		Card pickedCard = null;

		// 引数で指定された位置が妥当であるかチェックする 
		if ((0 <= position) && (position < deal_.size()))
		{
			pickedCard = (Card)deal_.remove(position);
		}

		return pickedCard;
	}

	/**
	 * シャッフルする。
	 */
	public void shuffle()
	{
		// 手札の枚数を取得
		int number = deal_.size();

		// カードを抜き出す位置
		int pos;

		// カードをランダムに抜き取って最後に加える動作を繰り返す
		for (int count = 0; count < number * 2; count++)
		{
			// ランダムな位置からカードを一枚抜き取る
			pos = (int) (Math.random() * number);
			Card pickedCard = (Card)deal_.remove(pos);

			// 抜き取ったカードを最後に加える
			deal_.add(pickedCard);
		}
	}

	/**
	 * 枚数を数える。
	 * 
	 * @return 手札にあるカードの枚数
	 */
	public int getNumberOfCards()
	{
		return deal_.size();
	}

	/**
	 * 手札にあるカードを文字列で表現する。
	 * ObjectクラスのtoStringメソッドをオーバーライドしたメソッド。
	 * 
	 * @return 手札にあるカードの文字列表現
	 */
	public String toString()
	{
		StringBuffer string = new StringBuffer();

		int size = deal_.size();
		if (size > 0)
		{
			for (int index = 0; index < size; index++)
			{
				Card card = (Card)deal_.get(index);
				string.append(card);
				string.append(" ");
			}
		}

		return string.toString();
	}
}
