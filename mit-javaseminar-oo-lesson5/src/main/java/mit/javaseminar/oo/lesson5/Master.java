package mit.javaseminar.oo.lesson5;

import java.util.ArrayList;

/**
 * ばば抜きの進行役を表すクラス。
 */
public class Master
{
    /** プレイヤーのリスト */
    private ArrayList<Player> players_ = new ArrayList<Player>();

    /**
     * ゲームの準備をする。
     * 
     * @param cards トランプを進行役の手札として渡す
     */
    public void prepareGame(Hand cards)
    {
    	// カードを配る宣言する
        System.out.println("【カードを配ります】");

        // トランプをシャッフルする
        cards.shuffle();

        // トランプの枚数を取得する
        int numberOfCards = cards.getNumberOfCards();

        // プレイヤーの人数を取得する
        int numberOfPlayers = players_.size();

        // カードの枚数分カードを配る処理を繰り返すが。。。引かれることを考慮してループしすぎないように。
        // 日本語とプログラムの間には少し隙間がある。そこにUTバグもある。難しいね。BPさんは大変なんです。
        for (int index = 0; index < numberOfCards; index++)
        {
            // カードから一枚引く
            Card card = cards.pickCard();

            // 各プレイヤーに順番にカードを配る
            Player player = (Player) players_.get(index % numberOfPlayers);
            player.receiveCard(card);
        }
    }

    /**
     * ゲームを開始する。
     */
    public void startGame()
    {
    	// ばば抜き開始を宣言する
        System.out.println("\n【ばば抜きを開始します】");

        // プレイヤーの人数分繰り返す
        for (int count = 0; players_.size() > 1; count++)
        {
        	// %つまり除算の余りを利用するといいかもね。人数とカウンタの関係を利用します。
        	// カウンタは指名されたプレイヤー
            int playerIndex = count % players_.size();
            // 次のプレイヤーの番号を決める
            int nextPlayerIndex = (count + 1) % players_.size();

            // 指名するプレイヤーの取得
            Player player = (Player) players_.get(playerIndex);

            // 次のプレイヤーの取得
            Player nextPlayer = (Player) players_.get(nextPlayerIndex);

            // 指名されたプレイヤーを宣言する
            System.out.println("\n" + player.getName() + "さんの番です");
            player.play(nextPlayer);
        }

        // プレイヤーが上がって残り1名になるとループを抜ける
        System.out.println("【ばば抜きを終了しました】");
    }

    /**
     * 上がりを宣言する。
     * 
     * @param winner 上がったプレイヤー
     */
    public void declareWin(Player winner)
    {
        // 上がったプレイヤーを宣言する
        System.out.println(winner.getName() + "さんが上がりました！");

        // 上がったプレイヤーをリストからはずす
        players_.remove(players_.indexOf(winner));

        // 残りプレイヤーが１人になった時は敗者を表示する
        if (players_.size() == 1)
        {
            Player loser = (Player) players_.get(0);
            // 敗者を宣言する
            // ババ抜きだからね。。。
            // じじ抜きを考慮するならこの部分含めて処理の構造は汎化が必要だね。
            System.out.println(loser.getName() + "さんの負けです！");
        }
    }

    /**
     * ゲームに参加するプレイヤーを登録する。
     * 
     * @param player 参加するプレイヤー
     */
    public void registerPlayer(Player player)
    {
        // リストに参加者を追加する
        players_.add(player);
    }
}