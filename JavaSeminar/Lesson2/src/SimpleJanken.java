/**
 * �I�u�W�F�N�g�w�����g�p���Ȃ��W�����P���v���O����
 */
public class SimpleJanken
{
	// �W�����P���̎��\���萔
	public static final int STONE = 0; // �O�[
	public static final int SCISSORS = 1; // �`���L
	public static final int PAPER = 2; // �p�[
	
	// ������������������������������������������������������������
	// �@�v���O�����̃X�^�[�g�͂�������
	// ������������������������������������������������������������
	public static void main(String[] args)
	{
		// �v���C���[�P�̏�����
		int player1WinCount = 0;
		
		// �v���C���[�Q�̏�����
		int player2WinCount = 0;

		// �v���C���[�P���o����
		int player1Hand = 0;
		
		// �v���C���[�Q���o����
		int player2Hand = 0;

		// �W�����P���̎�����߂�̂Ɏg�p���闐��
		double randomNum = 0;

		// ��������������������������������������������������������
		// �@�@ �v���O�������J�n�������Ƃ�\������
		// ��������������������������������������������������������
		// �v���O�����J�n���b�Z�[�W��\������
		System.out.println("�y�W�����P���J�n�z\n");

		// �W�����P�����R����{����
		// ��������������������������������������������������������
		// �@�E ���������񐔂����Z����
		// �@�F �R�񏟕����I��������H
		// ��������������������������������������������������������
		for (int cnt = 0; cnt < 3; cnt++)
		{
			// �����ڂ���\������
			System.out.println("�y" + (cnt + 1) + "���ځz");

			// ����������������������������������������������������
			// �@�A �v���C���[�P�������o�������߂�
			// ����������������������������������������������������
			// 0.0�ȏ�3.0�����̏����Ƃ��ė����𓾂�
			randomNum = Math.random() * 3;

			if (randomNum < 1)
			{
				// randomNum �� 0.0�ȏ�1.0���� �̏ꍇ�A�O�[
				player1Hand = STONE;

				// �v���C���[�P�̎��\������
				System.out.print("�O�[");
			}
			else if (randomNum < 2)
			{
				// randomNum �� 1.0�ȏ�2.0���� �̏ꍇ�A�`���L
				player1Hand = SCISSORS;

				// �v���C���[�P�̎��\������
				System.out.print("�`���L");
			}
			else if (randomNum < 3)
			{
				// randomNum �� 2.0�ȏ�3.0���� �̏ꍇ�A�p�[
				player1Hand = PAPER;

				// �v���C���[�P�̎��\������
				System.out.print("�p�[");
			}

			System.out.print(" vs. ");

			// ����������������������������������������������������
			// �@�B �v���C���[�Q�������o�������߂�
			// ����������������������������������������������������

			// 0.0�ȏ�3.0�����̏����Ƃ��ė����𓾂�
			randomNum = Math.random() * 3;

			if (randomNum < 1)
			{
				// randomNum �� 0.0�ȏ�1.0���� �̏ꍇ�A�O�[
				player2Hand = STONE;

				// �v���C���[�Q�̎��\������
				System.out.print("�O�[");
			}
			else if (randomNum < 2)
			{
				// randomNum �� 1.0�ȏ�2.0���� �̏ꍇ�A�`���L
				player2Hand = SCISSORS;

				// �v���C���[�Q�̎��\������
				System.out.print("�`���L");
			}
			else if (randomNum < 3)
			{
				// randomNum �� 2.0�ȏ�3.0���� �̏ꍇ�A�p�[
				player2Hand = PAPER;

				// �v���C���[�R�̎��\������
				System.out.print("�p�[");
			}

			// ����������������������������������������������������
			// �@�C �ǂ��炪�������𔻒肵�A���ʂ�\������
			// ����������������������������������������������������

			// �v���C���[�P�����ꍇ
			if ((player1Hand == STONE && player2Hand == SCISSORS)
					|| (player1Hand == SCISSORS && player2Hand == PAPER)
					|| (player1Hand == PAPER && player2Hand == STONE))
			{
				// �W�����P���̌��ʂ�\������
				System.out.println("\n�v���C���[�P�������܂����I\n");

				// ������������������������������������������������
				// �@�D �v���C���[�P�̏������񐔂����Z����
				// ������������������������������������������������
				player1WinCount++;
			}
			// �v���C���[�Q�����ꍇ
			else if ((player1Hand == STONE && player2Hand == PAPER)
					|| (player1Hand == SCISSORS && player2Hand == STONE)
					|| (player1Hand == PAPER && player2Hand == SCISSORS))
			{
				// �W�����P���̌��ʂ�\������
				System.out.println("\n�v���C���[�Q�������܂����I\n");

				// ������������������������������������������������
				// �@�D �v���C���[�Q�̏������񐔂����Z����
				// ������������������������������������������������
				player2WinCount++;
			}
			// ���������̏ꍇ
			else
			{
				// �W�����P���̌��ʂ�\������
				System.out.println("\n���������ł��I\n");
			}
		}

		// ��������������������������������������������������������
		// �@�G �ŏI�I�ȏ��҂𔻒肵�A��ʂɕ\������
		// ��������������������������������������������������������
		System.out.println("�y�W�����P���I���z\n");

		// �v���C���[�P�̏�������������
		if (player1WinCount > player2WinCount)
		{
			// �v���C���[�P�̏�����\������B
			System.out.println(player1WinCount + "��" + player2WinCount
					+ "�Ńv���C���[�P�̏����ł��I\n");
		}
		// �v���C���[�Q�̏�������������
		else if (player1WinCount < player2WinCount)
		{
			// �v���C���[�Q�̏�����\������B
			System.out.println(player1WinCount + "��" + player2WinCount
					+ "�Ńv���C���[�Q�̏����ł��I\n");
		}
		// �v���C���[�P�ƂQ�̏�������������
		else if (player1WinCount == player2WinCount)
		{
			// ����������\������B
			System.out.println(player1WinCount + "��" + player2WinCount
					+ "�ň��������ł��I\n");
		}
	}
}
