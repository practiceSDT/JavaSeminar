/**
 * �u�O�[����D���I�v�헪�N���X�B
 */
public class StoneOnlyTactics implements Tactics
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
		// �K���O�[���o��
		return Player.STONE;
	}
}
