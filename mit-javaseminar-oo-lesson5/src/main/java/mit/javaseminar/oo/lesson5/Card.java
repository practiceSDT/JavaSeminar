package mit.javaseminar.oo.lesson5;
/**
 * トランプのカードを表すクラス。
 */
public class Card
{
	/** ジョーカーを表す定数 */
	public static final int JOKER = 0;
	
	/** スペードを表す定数 */
	public static final int SUIT_SPADE   = 1;
	
	/** ダイヤを表す定数 */
	public static final int SUIT_DIAMOND = 2;
	
	/** クラブを表す定数 */
	public static final int SUIT_CLUB    = 3;
	
	/** ハートを表す定数 */
	public static final int SUIT_HEART   = 4;
	
	/** カードの示すスート */
	private int suit_;
	
	/** カードの示す数 */
	private int number_;
	
	/**
	 * コンストラクタ。
	 * 
	 * @param suit スート
	 * @param number 数 (0の場合はジョーカーとして扱う)
	 */
	public Card(int suit, int number)
	{
		this.suit_ = suit;
		this.number_ = number;
	}
	
	/**
	 * 数字を見る。
	 * 
	 * @return 数 
	 */
	public int getNumber()
	{
		return number_;
	}
	
	/**
	 * カードを文字列で表現する。
	 * 
	 * @return カードの文字表現
	 */
	public String showCard()
	{
		StringBuffer string = new StringBuffer();
		
		if (number_ > 0)
		{
			// スートの表示
			switch (suit_)
			{
				case SUIT_SPADE :
					string.append("S");
					break;
			
				case SUIT_DIAMOND :
					string.append("D");
					break;
			
				case SUIT_CLUB :
					string.append("C");
					break;
				
				case SUIT_HEART :
					string.append("H");
					break;
			
				default :
					break;
			}
			
			// 数の表示
			switch (number_)
			{
				case 1 :
					string.append("A");
					break;

				case 10 :
					string.append("T");
					break;
				
				case 11 :
					string.append("J");
					break;
				
				case 12 :
					string.append("Q");
					break;
					
				case 13 :
					string.append("K");
					break;
				
				default :
					string.append(number_);
					break;
			}
		}
		else
		{
			// ジョーカーを表す
			string.append("JK");
		}
		
		return string.toString();
	}
}
