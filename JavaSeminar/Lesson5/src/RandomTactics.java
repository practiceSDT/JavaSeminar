/**
 * �����_���Ɏ�����߂�헪�N���X�B
 */
public class RandomTactics implements Tactics
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
		// �v���C���[�̎�
		int hand = 0;
        
		// 0�ȏ�3�����̏����Ƃ��ė����𓾂�
		double randomNum = Math.random() * 3;
		if (randomNum < 1)
		{
			// randomNum �� 0�ȏ�1�����̏ꍇ�A�O�[
			hand = Player.STONE;
		}
		else if (randomNum < 2)
		{
			// randomNum �� 1�ȏ�2�����̏ꍇ�A�`���L
			hand = Player.SCISSORS;
		}
		else if (randomNum < 3)
		{
			// randomNum �� 2�ȏ�3�����̏ꍇ�A�p�[
			hand = Player.PAPER;
		}
        
		// ���肵�����߂�l�Ƃ��ĕԂ�
		return hand;
	}
}

