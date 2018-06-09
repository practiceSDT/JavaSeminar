package mit.javaseminar.oo.lesson5;

import java.util.ArrayList;

/**
 * テーブルを表すクラス。
 */
public class Table
{
    /** 捨てられたカードを保持しておくためのリスト */
    private ArrayList<Card[]> disposedCards_ = new ArrayList<Card[]>();

    /**
     * カードを捨てる。
     * 
     * @param card 捨てるカードの配列
     */
    public void disposeCard(Card card[])
    {
        for (int index = 0; index < card.length; index++)
        {
            // 捨てられたカードを表示する
            System.out.print(card[index] + " ");
        }

        System.out.println("を捨てました");

        // 捨てられたカードはリストに追加して保持しておく。
        disposedCards_.add(card);
    }
}