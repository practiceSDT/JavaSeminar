package mit.javaseminar.oo.lesson7.fantan;

import mit.javaseminar.oo.lesson7.trump.Master;

/**
 * 七並べ用進行役クラス。
 */
public class FantanMaster extends Master
{
    /** パスできる制限回数 */
    public static final int PASS_LIMIT = 3;

    /**
     * パスを宣言する。<br>
     * 
     * @param player パスするプレイヤー
     */
    public void pass(FantanPlayer player)
    {
        // パスを表示
        System.out.println(
            "  " + player + "さんは " + player.getPass() + " 回目のパスしました！");

        if (player.getPass() > PASS_LIMIT)
        {
            // パス回数が制限値を超えている場合は負け。
            System.out.println("  " + player + "さんは負けです！");
            deregisterPlayer(player);
        }
    }
}
