package mit.javaseminar.oo.lesson4_5;

/**
 * 戦略インターフェースに対応したジャンケンプログラム。
 */
public class ObjectJanken
{
  public static void main(String[] args)
  {
	// 審判のインスタンス生成
	Judge judge = new Judge();
    
	// プレイヤー１（村田さん）の生成
	Player murata = new Player("村田さん");
    
	// 村田さんに渡す戦略クラスを生成する
	Tactics murataTactics = new StoneOnlyTactics();
    
	// 村田さんに戦略クラスを渡す
	murata.setTactics(murataTactics);
    
	// プレイヤー２（山田さん）の生成
	Player yamada = new Player("山田さん");
    
	// 山田さんに渡す戦略クラスを生成する
	Tactics yamadaTactics = new RandomTactics();
    
	// 山田さんに戦略クラスを渡す
	yamada.setTactics(yamadaTactics);
    
	// 村田さんと山田さんをプレイヤーとしてジャンケンを開始する
	judge.startJanken(murata, yamada);
  }
}
