package trump;

/**
 * �g�����v���[���C���^�[�t�F�[�X�B
 * ���݂̎�D�ƃe�[�u������A�e�[�u���ɏo������J�[�h�̑g�ݍ��킹��������B
 */
public interface Rule
{
	/**
	 * �e�[�u���ɒu����J�[�h��T���B
	 * ��D�ƃe�[�u������A�e�[�u���ɏo������J�[�h�̑g�ݍ��킹��T���B
	 * 
	 * @param hand ��D
	 * @param table �e�[�u��
	 * @return ���������J�[�h�̑g�ݍ��킹�B������Ȃ������ꍇ��null��Ԃ��B
	 */
	public Card[] findCandidate(Hand hand, Table table);
}
