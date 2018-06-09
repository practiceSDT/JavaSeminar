/**
 * オブジェクト指向を使用しないジャンケンプログラム
 */
public class SimpleJanken
{
	// ジャンケンの手を表す定数
	public static final int STONE = 0; // グー
	public static final int SCISSORS = 1; // チョキ
	public static final int PAPER = 2; // パー
	
	// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 　プログラムのスタートはここから
	// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	public static void main(String[] args)
	{
		// プレイヤー１の勝ち数
		int player1WinCount = 0;
		
		// プレイヤー２の勝ち数
		int player2WinCount = 0;

		// プレイヤー１が出す手
		int player1Hand = 0;
		
		// プレイヤー２が出す手
		int player2Hand = 0;

		// ジャンケンの手を決めるのに使用する乱数
		double randomNum = 0;

		// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		// 　① プログラムが開始したことを表示する
		// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		// プログラム開始メッセージを表示する
		System.out.println("【ジャンケン開始】\n");

		// ジャンケンを３回実施する
		// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		// 　⑥ 勝負した回数を加算する
		// 　⑦ ３回勝負が終わったか？
		// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		for (int cnt = 0; cnt < 3; cnt++)
		{
			// 何回戦目かを表示する
			System.out.println("【" + (cnt + 1) + "回戦目】");

			// ■■■■■■■■■■■■■■■■■■■■■■■■■■
			// 　② プレイヤー１が何を出すか決める
			// ■■■■■■■■■■■■■■■■■■■■■■■■■■
			// 0.0以上3.0未満の小数として乱数を得る
			randomNum = Math.random() * 3;

			if (randomNum < 1)
			{
				// randomNum が 0.0以上1.0未満 の場合、グー
				player1Hand = STONE;

				// プレイヤー１の手を表示する
				System.out.print("グー");
			}
			else if (randomNum < 2)
			{
				// randomNum が 1.0以上2.0未満 の場合、チョキ
				player1Hand = SCISSORS;

				// プレイヤー１の手を表示する
				System.out.print("チョキ");
			}
			else if (randomNum < 3)
			{
				// randomNum が 2.0以上3.0未満 の場合、パー
				player1Hand = PAPER;

				// プレイヤー１の手を表示する
				System.out.print("パー");
			}

			System.out.print(" vs. ");

			// ■■■■■■■■■■■■■■■■■■■■■■■■■■
			// 　③ プレイヤー２が何を出すか決める
			// ■■■■■■■■■■■■■■■■■■■■■■■■■■

			// 0.0以上3.0未満の小数として乱数を得る
			randomNum = Math.random() * 3;

			if (randomNum < 1)
			{
				// randomNum が 0.0以上1.0未満 の場合、グー
				player2Hand = STONE;

				// プレイヤー２の手を表示する
				System.out.print("グー");
			}
			else if (randomNum < 2)
			{
				// randomNum が 1.0以上2.0未満 の場合、チョキ
				player2Hand = SCISSORS;

				// プレイヤー２の手を表示する
				System.out.print("チョキ");
			}
			else if (randomNum < 3)
			{
				// randomNum が 2.0以上3.0未満 の場合、パー
				player2Hand = PAPER;

				// プレイヤー３の手を表示する
				System.out.print("パー");
			}

			// ■■■■■■■■■■■■■■■■■■■■■■■■■■
			// 　④ どちらが勝ちかを判定し、結果を表示する
			// ■■■■■■■■■■■■■■■■■■■■■■■■■■

			// プレイヤー１が勝つ場合
			if ((player1Hand == STONE && player2Hand == SCISSORS)
					|| (player1Hand == SCISSORS && player2Hand == PAPER)
					|| (player1Hand == PAPER && player2Hand == STONE))
			{
				// ジャンケンの結果を表示する
				System.out.println("\nプレイヤー１が勝ちました！\n");

				// ■■■■■■■■■■■■■■■■■■■■■■■■
				// 　⑤ プレイヤー１の勝った回数を加算する
				// ■■■■■■■■■■■■■■■■■■■■■■■■
				player1WinCount++;
			}
			// プレイヤー２が勝つ場合
			else if ((player1Hand == STONE && player2Hand == PAPER)
					|| (player1Hand == SCISSORS && player2Hand == STONE)
					|| (player1Hand == PAPER && player2Hand == SCISSORS))
			{
				// ジャンケンの結果を表示する
				System.out.println("\nプレイヤー２が勝ちました！\n");

				// ■■■■■■■■■■■■■■■■■■■■■■■■
				// 　⑤ プレイヤー２の勝った回数を加算する
				// ■■■■■■■■■■■■■■■■■■■■■■■■
				player2WinCount++;
			}
			// 引き分けの場合
			else
			{
				// ジャンケンの結果を表示する
				System.out.println("\n引き分けです！\n");
			}
		}

		// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		// 　⑧ 最終的な勝者を判定し、画面に表示する
		// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		System.out.println("【ジャンケン終了】\n");

		// プレイヤー１の勝ち数が多い時
		if (player1WinCount > player2WinCount)
		{
			// プレイヤー１の勝ちを表示する。
			System.out.println(player1WinCount + "対" + player2WinCount
					+ "でプレイヤー１の勝ちです！\n");
		}
		// プレイヤー２の勝ち数が多い時
		else if (player1WinCount < player2WinCount)
		{
			// プレイヤー２の勝ちを表示する。
			System.out.println(player1WinCount + "対" + player2WinCount
					+ "でプレイヤー２の勝ちです！\n");
		}
		// プレイヤー１と２の勝ち数が同じ時
		else if (player1WinCount == player2WinCount)
		{
			// 引き分けを表示する。
			System.out.println(player1WinCount + "対" + player2WinCount
					+ "で引き分けです！\n");
		}
	}
}
