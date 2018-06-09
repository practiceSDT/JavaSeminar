package mit.javaseminar.oo.lesson2;
/**
 * オブジェクト指向によるジャンケンプログラム
 */
public class ObjectJanken
{
    public static void main(String[] args)
    {
        // 審判（斎藤さん）のインスタンス生成
        Judge saito = new Judge();

        // プレイヤー１（村田さん）の生成
        Player murata = new Player("村田さん");

        // プレイヤー２（山田さん）の生成
        Player yamada = new Player("山田さん");

        // 村田さんと山田さんをプレイヤーとしてジャンケンを開始する
        saito.startJanken(murata, yamada);
    }
}
