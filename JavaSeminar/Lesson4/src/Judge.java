/**
 * ジャンケンを行う審判クラス。
 */
public class Judge
{
	/**
	 * ジャンケンを開始する。
	 * 
	 * @param player1 判定対象プレイヤー1
	 * @param player2 判定対象プレイヤー2
	 */
	void startJanken(Player player1, Player player2)
	{
		// ジャンケンの開始を宣言する
		System.out.println("【ジャンケン開始】\n");
		
		// ジャンケンを3回行う
		for (int cnt = 0; cnt < 3; cnt++)
		{
			// 何回戦目か表示する
			System.out.println("【" + (cnt + 1) + "回戦目】");

			// プレイヤーの手を見て、どちらが勝ちかを判定する。
			Player winner = judgeJanken(player1, player2);

			if (winner != null)
			{
				// 勝者を表示する
				System.out.println("\n" + winner.getName() + "が勝ちました!\n");

				// 勝ったプレイヤーへ結果を伝える
				winner.notifyResult(true);
			}
			else
			{
				// 引き分けの場合
				System.out.println("\n引き分けです！\n");
			}
		}

		// ジャンケンの終了を宣言する
		System.out.println("【ジャンケン終了】\n");

		// 最終的な勝者を判定する
		Player finalWinner = judgeFinalWinner(player1, player2);

		// 結果の表示
		System.out.print(
			player1.getWinCount() + " 対 " + player2.getWinCount() + "で");

		if (finalWinner != null)
		{
			System.out.println(finalWinner.getName() + "の勝ちです！\n");
		}
		else
		{
			System.out.println("引き分けです！\n");
		}
	}

	/**
	 * 「ジャンケン、ポン！」と声をかけ、
	 * プレイヤーの手を見て、どちらが勝ちかを判定する。
	 * 
	 * @param player1 判定対象プレイヤー1
	 * @param player2 判定対象プレイヤー2
	 * @return 勝ったプレイヤー。引き分けの場合は null を返す。
	 */
	Player judgeJanken(Player player1, Player player2)
	{
		Player winner = null;

		// プレイヤー１の手を出す
		int player1hand = player1.showHand();
		
		// プレイヤー２の手を出す
		int player2hand = player2.showHand();
		
		// それぞれの手を表示する
		printHand(player1hand);
		System.out.print(" vs. ");
		printHand(player2hand);
		System.out.print("\n");

		// プレイヤー１が勝つ場合
		if ((player1hand == Player.STONE && player2hand == Player.SCISSORS)
			|| (player1hand == Player.SCISSORS && player2hand == Player.PAPER)
			|| (player1hand == Player.PAPER && player2hand == Player.STONE))
		{
			winner = player1;
		}
		// プレイヤー２が勝つ場合
		else if (
			(player1hand == Player.STONE && player2hand == Player.PAPER)
				|| (player1hand == Player.SCISSORS && player2hand == Player.STONE)
				|| (player1hand == Player.PAPER
					&& player2hand == Player.SCISSORS))
		{
			winner = player2;
		}

		// どちらでもない場合は引き分け(nullを返す)

		return winner;
	}

	/**
	 * 最終的な勝者を判定する。
	 * 
	 * @param player1 判定対象プレイヤー2
	 * @param player2 判定対象プレイヤー2
	 * @return 勝ったプレイヤー。引き分けの場合は null を返す。
	 */
	Player judgeFinalWinner(Player player1, Player player2)
	{
		Player winner = null;

		// Player1から勝ち数を聞く
		int player1WinCount = player1.getWinCount();

		// Player2から勝ち数を聞く
		int player2WinCount = player2.getWinCount();

		if (player1WinCount > player2WinCount)
		{
			// プレイヤー1の勝ち
			winner = player1;
		}
		else if (player1WinCount < player2WinCount)
		{
			// プレイヤー2の勝ち
			winner = player2;
		}

		// どちらでもない場合は引き分け(nullを返す)

		return winner;
	}
	
	
	/**
	 * ジャンケンの手を表示する。
	 * 
	 * @param hand ジャンケンの手
	 */
	private void printHand(int hand)
	{
		switch (hand)
		{
			case Player.STONE :
				System.out.print("グー");
				break;

			case Player.SCISSORS :
				System.out.print("チョキ");
				break;
			
			case Player.PAPER :
				System.out.print("パー");
				break;
			
			default :
				break;
		}
	}
}
