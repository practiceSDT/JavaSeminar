package mit.javaseminar.oo.lesson5;

import java.util.ArrayList;

/**
 * テーブルを表すクラス。
 */
public class Table
{
    /** 捨てられたカードを保持しておくためのリスト */
    private ArrayList<ArrayList<Card>> disposedCards_ = new ArrayList<ArrayList<Card>>();

    /**
     * カードを捨てる。
     * 
     * @param sameCards 捨てるカードの配列
     */
    public void disposeCard(ArrayList<Card> sameCards)
    {
        for (int index = 0; index < sameCards.size(); index++)
        {
            // 捨てられたカードを表示する
            System.out.print(sameCards.get(index) + " ");
        }

        System.out.println("を捨てました");

        // 捨てられたカードはリストに追加して保持しておく。
        disposedCards_.add(sameCards);
    }
}