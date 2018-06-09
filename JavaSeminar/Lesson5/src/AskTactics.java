import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * �W�����͂ɂ��W�����P���̎�����[�U�ɕ����헪�N���X�B
 */
class AskTactics implements Tactics
{
	/**
	 * �헪��ǂ݁A�W�����P���̎�𓾂�B
	 * �O�[�E�`���L�E�p�[�̂����ꂩ��Player�N���X�ɒ�`���ꂽ
	 * �ȉ��̒萔�ŕԂ��B
	 * Player.STONE    �E�E�E �O�[
	 * Player.SCISSORS �E�E�E �`���L
	 * Player.PAPER    �E�E�E �p�[
	 * 
	 * @return �W�����P���̎�
	 */
	public int readTactics()
	{
		BufferedReader br =
			new BufferedReader(new InputStreamReader(System.in));

		System.out.println("\n�W�����P���̎����͂��ĉ������B");
		System.out.println("0: �O�[");
		System.out.println("1: �`���L");
		System.out.println("2: �p�[\n");
		System.out.print("? ");

		// �W�����P���̎�
		int hand = 0;

		while (true)
		{
			try
			{
				// ���͕�������󂯎��
				String inputStr = br.readLine();

				// ���͕�����𐔒l�ɕϊ�����B
				hand = Integer.parseInt(inputStr);

				// 0�`2�̂����ꂩ�����͂��ꂽ�烋�[�v�𔲂���
				if (hand == Player.STONE
					|| hand == Player.SCISSORS
					|| hand == Player.PAPER)
				{
					break;
				}
				else
				{
					System.out.println("���͂�����������܂���B�ēx���͂��ĉ������B");
					System.out.print("? ");
				}
			}
			catch (Exception ex)
			{
				System.out.println("���͂�����������܂���B�ēx���͂��ĉ������B");
				System.out.print("? ");
			}
		}

		return hand;
	}
}
