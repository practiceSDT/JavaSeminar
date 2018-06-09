package mit.javaseminar.oo.lesson4;

/**
 * 戦略インターフェースに対応したジャンケンプログラム(クラスローダ対応版)
 */
public class ObjectJanken2
{
	public static void main(String[] args)
	{
		try
		{
			// 審判のインスタンス生成
			Judge judge = new Judge();

			// プレイヤー１（村田さん）の生成
			Player murata = new Player("村田さん");
			
			// 引数で指定されたクラス名のClassオブジェクトを取得する
			Class<?> tacticsClass = Class.forName(args[0]);
			
			// Classオブジェクトを使用して引数で指定されたクラスを生成する
			Tactics murataTactics = (Tactics)tacticsClass.newInstance();

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
		catch (ClassNotFoundException ex)
		{
			System.err.println("クラスが見つかりません : " + args[0]);
		}
		catch (InstantiationException e)
		{
			System.err.println("クラスの生成に失敗しました : " + args[0]);
		}
		catch (IllegalAccessException e)
		{
			System.err.println("クラスの生成に失敗しました : " + args[0]);
		}
	}
}
