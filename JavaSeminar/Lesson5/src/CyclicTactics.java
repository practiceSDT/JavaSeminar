/**
 * �O�[�E�`���L�E�p�[�̏��Ԃŏo���헪�N���X�B
 */
class CyclicTactics implements Tactics
{
    /** �Ō�ɏo������(���J�n:-1) */
    int lastHand = -1;

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
		// �Ō�ɏo������ɂ��A���̎�����߂�B
		// �Ō�ɏo������͋L�����Ă����B
		// +-----------------+
		// | �Ō�   | ���̎� |
		// +-----------------+
		// | �O�[   | �`���L |
		// | �`���L | �p�[   |
		// | �p�[   | �O�[   |
		// +-----------------+
		lastHand = (lastHand + 1) % 3;

		// ���̎���o��
		return lastHand;
	}
}