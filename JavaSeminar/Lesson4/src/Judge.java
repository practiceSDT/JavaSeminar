/**
 * �W�����P�����s���R���N���X�B
 */
public class Judge
{
	/**
	 * �W�����P�����J�n����B
	 * 
	 * @param player1 ����Ώۃv���C���[1
	 * @param player2 ����Ώۃv���C���[2
	 */
	void startJanken(Player player1, Player player2)
	{
		// �W�����P���̊J�n��錾����
		System.out.println("�y�W�����P���J�n�z\n");
		
		// �W�����P����3��s��
		for (int cnt = 0; cnt < 3; cnt++)
		{
			// �����ڂ��\������
			System.out.println("�y" + (cnt + 1) + "���ځz");

			// �v���C���[�̎�����āA�ǂ��炪�������𔻒肷��B
			Player winner = judgeJanken(player1, player2);

			if (winner != null)
			{
				// ���҂�\������
				System.out.println("\n" + winner.getName() + "�������܂���!\n");

				// �������v���C���[�֌��ʂ�`����
				winner.notifyResult(true);
			}
			else
			{
				// ���������̏ꍇ
				System.out.println("\n���������ł��I\n");
			}
		}

		// �W�����P���̏I����錾����
		System.out.println("�y�W�����P���I���z\n");

		// �ŏI�I�ȏ��҂𔻒肷��
		Player finalWinner = judgeFinalWinner(player1, player2);

		// ���ʂ̕\��
		System.out.print(
			player1.getWinCount() + " �� " + player2.getWinCount() + "��");

		if (finalWinner != null)
		{
			System.out.println(finalWinner.getName() + "�̏����ł��I\n");
		}
		else
		{
			System.out.println("���������ł��I\n");
		}
	}

	/**
	 * �u�W�����P���A�|���I�v�Ɛ��������A
	 * �v���C���[�̎�����āA�ǂ��炪�������𔻒肷��B
	 * 
	 * @param player1 ����Ώۃv���C���[1
	 * @param player2 ����Ώۃv���C���[2
	 * @return �������v���C���[�B���������̏ꍇ�� null ��Ԃ��B
	 */
	Player judgeJanken(Player player1, Player player2)
	{
		Player winner = null;

		// �v���C���[�P�̎���o��
		int player1hand = player1.showHand();
		
		// �v���C���[�Q�̎���o��
		int player2hand = player2.showHand();
		
		// ���ꂼ��̎��\������
		printHand(player1hand);
		System.out.print(" vs. ");
		printHand(player2hand);
		System.out.print("\n");

		// �v���C���[�P�����ꍇ
		if ((player1hand == Player.STONE && player2hand == Player.SCISSORS)
			|| (player1hand == Player.SCISSORS && player2hand == Player.PAPER)
			|| (player1hand == Player.PAPER && player2hand == Player.STONE))
		{
			winner = player1;
		}
		// �v���C���[�Q�����ꍇ
		else if (
			(player1hand == Player.STONE && player2hand == Player.PAPER)
				|| (player1hand == Player.SCISSORS && player2hand == Player.STONE)
				|| (player1hand == Player.PAPER
					&& player2hand == Player.SCISSORS))
		{
			winner = player2;
		}

		// �ǂ���ł��Ȃ��ꍇ�͈�������(null��Ԃ�)

		return winner;
	}

	/**
	 * �ŏI�I�ȏ��҂𔻒肷��B
	 * 
	 * @param player1 ����Ώۃv���C���[2
	 * @param player2 ����Ώۃv���C���[2
	 * @return �������v���C���[�B���������̏ꍇ�� null ��Ԃ��B
	 */
	Player judgeFinalWinner(Player player1, Player player2)
	{
		Player winner = null;

		// Player1���珟�����𕷂�
		int player1WinCount = player1.getWinCount();

		// Player2���珟�����𕷂�
		int player2WinCount = player2.getWinCount();

		if (player1WinCount > player2WinCount)
		{
			// �v���C���[1�̏���
			winner = player1;
		}
		else if (player1WinCount < player2WinCount)
		{
			// �v���C���[2�̏���
			winner = player2;
		}

		// �ǂ���ł��Ȃ��ꍇ�͈�������(null��Ԃ�)

		return winner;
	}
	
	
	/**
	 * �W�����P���̎��\������B
	 * 
	 * @param hand �W�����P���̎�
	 */
	private void printHand(int hand)
	{
		switch (hand)
		{
			case Player.STONE :
				System.out.print("�O�[");
				break;

			case Player.SCISSORS :
				System.out.print("�`���L");
				break;
			
			case Player.PAPER :
				System.out.print("�p�[");
				break;
			
			default :
				break;
		}
	}
}
