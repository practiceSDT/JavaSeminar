package mit.javaseminar.oo.lesson6;

/**
 * テーブルを表すクラス。
 */
public class Table
{
	/** テーブルを並べる場を表す２次元配列 */
	private Card[][] table_ = new Card[4][13];
	
	/**
	 * テーブルにカードを置く。
	 * 
	 * @param card カード
	 */
	public void putCard(Card card)
	{
		int number = card.getNumber();
		int suit = card.getSuit();
		
		// 場にカードを置く
		table_[suit - 1][number - 1] = card;
		
		// 置かれたカードを表示する
		System.out.println("  " + card + "を置きました。\n");
		
		// 現在の場の状態を表示する
		System.out.println(toString());
	}
	
	/**
	 * テーブルにカードが置かれているか調べる。
	 * 
	 * @return カードが置かれている場合はtrue
	 */
	public boolean isThereCard(int suit, int number)
	{
		if (table_[suit - 1][number - 1] != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	/**
	 * テーブルを文字列で表現する。
	 * ObjectクラスのtoStringメソッドをオーバーライドしたメソッド。
	 * 
	 * @return 場の文字列表現
	 */
	public String toString()
	{
		StringBuffer fieldString = new StringBuffer(200);
		for (int suit = 0; suit < 4; suit++)
		{
			for (int number = 0; number < 13; number++)
			{
				if (table_[suit][number] != null)
				{
					fieldString.append(table_[suit][number]);
				}
				else
				{
					fieldString.append("..");
				}
				
				fieldString.append(" ");
			}
			
			fieldString.append("\n");
		}
		
		return fieldString.toString();
	}
}
