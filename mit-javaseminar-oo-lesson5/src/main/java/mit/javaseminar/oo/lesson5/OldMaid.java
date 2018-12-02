package mit.javaseminar.oo.lesson5;
/**
 * ばば抜きプログラム。
 */
public class OldMaid
{
    public static void main(String args[])
    {
        // 進行役の生成
        Master master = new Master();
        
        // 場の生成
        Table field = new Table();
        
        // プレイヤーの生成
        Player murata = new Player("村田", master, field);
        Player yamada = new Player("山田", master, field);
        Player saito  = new Player("斎藤", master, field);
        
        // 進行役へプレイヤーを登録
        master.registerPlayer(murata);
        master.registerPlayer(yamada);
        master.registerPlayer(saito);
        
        // トランプを生成する
        Hand trump = createTrump();
        
        // ゲームの準備をする
        master.prepareGame(trump);
        
        // ゲームを開始する
        master.startGame();
        
    }
    
    /**
     * 53枚のトランプを生成する。
     * 
     * @return トランプを格納したHand
     */
    private static Hand createTrump()
    {
        Hand trump = new Hand();
        
        // 各スート53枚のカードを生成する
        for (int number = 1; number <= 13; number++)
        {
            trump.addCard(new Card(Card.SUIT_CLUB, number));
            trump.addCard(new Card(Card.SUIT_DIAMOND, number));
            trump.addCard(new Card(Card.SUIT_HEART, number));
            trump.addCard(new Card(Card.SUIT_SPADE, number));
        }
        
        // ジョーカーの作成
        trump.addCard(new Card(0, Card.JOKER));
        
        return trump;
    }
}
