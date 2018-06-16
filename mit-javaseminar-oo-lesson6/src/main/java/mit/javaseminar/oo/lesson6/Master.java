package mit.javaseminar.oo.lesson6;

import java.util.ArrayList;

/**
 * 進行役を表すクラス。<br>
 */
public class Master
{
	/** プレイヤーのリスト */
	private ArrayList<Player> players = new ArrayList<Player>();
	
	/**
	 * ゲームの準備をする。
	 * 
	 * @param cards トランプを進行役の手札として渡す
	 */
	public void prepareGame(Hand cards)
	{
		System.out.println("【カードを配ります】");
		
		// トランプをシャッフルする
		cards.shuffle();
		
		// トランプの枚数を取得する
		int numberOfCards = cards.getNumberOfCards();
		
		// プレイヤーの人数を取得する
		int numberOfPlayers = players.size();
		
		for (int index = 0; index < numberOfCards; index++)
		{
			// カードから一枚引く
			Card card = cards.pickCard(0);
			
			// 各プレイヤーに順番にカードを配る
			Player player = (Player)players.get(index % numberOfPlayers);
			player.receiveCard(card);
		}
	}
	
	/**
	 * ゲームを開始する。
	 */
	public void startGame()
	{
		System.out.println("\n【七並べを開始します】");
		
		// プレイヤーの人数を取得する
		for (int count = 0; players.size() > 1; count++)
		{
			int playerIndex = count % players.size(); 
			int nextPlayerIndex = (count + 1) % players.size();
			
			// 指名するプレイヤーの取得
			Player player = (Player)players.get(playerIndex);
			
			// プレイヤーを指名する
			System.out.println("\n" + player + "さんの番です。");
			player.play(); 
		}
		
		// プレイヤーが上がって残り1名になるとループを抜ける
		System.out.println("【七並べを終了しました】");
	}
	
	/**
	 * 上がりを宣言する。
	 * 
	 * @param winner 上がったプレイヤー
	 */
	public void declareWin(Player winner)
	{
		// 上がったプレイヤー
		System.out.println("  " + winner + "さんが上がりました！");
		
		// 上がったプレイヤーをリストからはずす
		players.remove(players.indexOf(winner));
		
		// 残りプレイヤーが１人になった時は敗者を表示する
		if (players.size() == 1)
		{
			Player loser = (Player)players.get(0);
			System.out.println("  " + loser + "さんの負けです！");
		}
	}
	
	/**
	 * パスを宣言する。
	 * 
	 * @param player パスするプレイヤー
	 */
	public void pass(Player player)
	{
		// パスを表示
		System.out.println("  " + player + "さんは " + player.getPass() + " 回目のパスしました！");
		
		if (player.getPass() > 3)
		{
			// パス回数が3回を超えている場合は負け。
			System.out.println("  " + player + "さんは負けです！");
			players.remove(players.indexOf(player));
			
		}
		
		// 残りプレイヤーが１人になった時は敗者を表示する
		if (players.size() == 1)
		{
			Player loser = (Player)players.get(0);
			System.out.println("  " + loser + "さんの負けです！");
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
		players.add(player);
		
		// プレイヤーの参加を表示する
		System.out.println(player + "さんが参加します。");
	}
}
