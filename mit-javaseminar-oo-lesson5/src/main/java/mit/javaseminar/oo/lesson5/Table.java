package mit.javaseminar.oo.lesson5;

import java.util.ArrayList;
import java.util.List;

/**
 * テーブルを表すクラス。
 */
public class Table
{
    /** 捨てられたカードを保持しておくためのリスト */
    private List<Card> disposedCards_ = new ArrayList<Card>();

    /**
     * カードを捨てる。
     * 
     * @param sameCards 捨てるカードの配列
     */
    public void disposeCard(List<Card> sameCards)
    {
        for (int index = 0; index < sameCards.size(); index++)
        {
            // 捨てられたカードを宣言する
            System.out.print(sameCards.get(index).showCard() + " ");
            // 捨てられたカードはリストに追加して保持しておく。
            // 使われることはないけど、捨てられたものが存在している気分にする
            disposedCards_.add(sameCards.get(index));
        }

        // 捨てた動作を宣言する
        System.out.println("を捨てました");

    }
}