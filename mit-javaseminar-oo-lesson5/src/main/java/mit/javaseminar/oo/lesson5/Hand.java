package mit.javaseminar.oo.lesson5;

import java.util.ArrayList;

/**
 * ばば抜きの手札を表すクラス。
 */
public class Hand
{
    /** 手札にあるカードを保持するためのリスト */
    private ArrayList<Card> hand_ = new ArrayList<Card>();

    /**
     * カードを加える。
     * 
     * @param card 加えるカード
     */
    public void addCard(Card card)
    {
        // カードをリストの最後に追加する
        hand_.add(card);
    }

    /**
     * カードを引く。
     * 
     * @return 引いたカード
     */
    public Card pickCard()
    {
        Card pickedCard = (Card) hand_.remove(0);

        return pickedCard;
    }

    /**
     * シャッフルする。
     */
    public void shuffle()
    {
        // 手札の枚数を取得
        int number = hand_.size();

        // カードを抜き出す位置
        int pos;

        // カードをランダムに抜き取って最後に加える動作を繰り返す
        for (int count = 0; count < number * 2; count++)
        {
            // ランダムな位置からカードを一枚抜き取る
            pos = (int) (Math.random() * number);
            Card pickedCard = (Card) hand_.remove(pos);

            // 抜き取ったカードを最後に加える
            hand_.add(pickedCard);
        }
    }

    /**
     * 枚数を数える。
     * 
     * @return 手札にあるカードの枚数
     */
    public int getNumberOfCards()
    {
        return hand_.size();
    }

    /**
     * 同じ数のカードを探す。
     * 同じ数のカードがない場合は null を返します。
     * 
     * @return 同じ数のカード
     */
    public Card[] findSameNumberCard()
    {
        int numberOfCards = hand_.size();
        Card[] sameCards = null;

        // 手札にカードが1枚もない場合は何もしない
        if (numberOfCards > 0)
        {
            // 最後に追加されたカードを取得する
            int lastIndex = numberOfCards - 1;
            Card lastAddedCard = (Card) hand_.get(lastIndex);

            // 最後に追加されたカードの数字を取得する
            int lastAddedCardNum = lastAddedCard.getNumber();

            for (int index = 0; index < lastIndex; index++)
            {
                Card card = (Card) hand_.get(index);
                if (card.getNumber() == lastAddedCardNum)
                {
                    // 最後に追加されたカードと同じカードが見つかった場合
                    // 見つかった組み合わせをsameCardsに格納し、ループを抜ける
                    sameCards = new Card[2];
                    sameCards[0] = (Card) hand_.remove(lastIndex);
                    sameCards[1] = (Card) hand_.remove(index);

                    break;
                }

                // 同じ数の組み合わせが見つからなかった場合、
                // sameCardsはnullのままとなる。
            }
        }

        return sameCards;
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

        int size = hand_.size();
        if (size > 0)
        {
            for (int index = 0; index < size; index++)
            {
                Card card = (Card) hand_.get(index);
                string.append(card);
                string.append(" ");
            }
        }

        return string.toString();
    }
}