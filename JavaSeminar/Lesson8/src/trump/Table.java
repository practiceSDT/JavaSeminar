package trump;

/**
 * �e�[�u����\���C���^�[�t�F�[�X�B
 */
public interface Table
{
	/**
	 * �J�[�h��u���B
	 * �e�[�u���ɒu���ꂽ�J�[�h���ǂ̂悤�Ɉ������́A�T�u�N���X�Ŏ�������B
	 * 
	 * @param card �J�[�h
	 */
	public void putCard(Card[] card);
	
	/**
	 * �J�[�h������B
	 * 
	 * @return �e�[�u���ɒu���ꂽ�J�[�h��\���z��
	 */
	public Card[][] getCards();
}
