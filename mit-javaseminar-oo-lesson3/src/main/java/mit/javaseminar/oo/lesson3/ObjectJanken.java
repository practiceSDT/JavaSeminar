package mit.javaseminar.oo.lesson3;
/**
 * 戦略インターフェースに対応したジャンケンプログラム
 */
public class ObjectJanken
{
  public static void main(String[] args)
  {
	// 審判のインスタンス生成
	Judge judge = new Judge();
    
	// プレイヤー１（村田さん）の生成
	Player murata = new Player("村田さん");
    
	// プレイヤー２（山田さん）の生成
	Player yamada = new Player("山田さん");
    
	// 村田さんと山田さんをプレイヤーとしてジャンケンを開始する
	judge.startJanken(murata, yamada);
  }
}
