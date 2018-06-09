package oldmaid;

import trump.Card;
import trump.Hand;

/**
 * �������猩����D��\���N���X�B
 * �ׂ̃v���C���[�ɃJ�[�h����������ہA�J�[�h�̗��������������邽�߂�
 * �g�p�ł��郁�\�b�h�𐧌����Ă���B
 */
public class BackHand
{
	/** ��D */
	private Hand hand_;
	
	/**
	 * �R���X�g���N�^�B
	 * 
	 * @param hand ��D
	 */
	public BackHand(Hand hand)
	{
		this.hand_ = hand;
	}
	
	/**
	 * �����𐔂���B
	 * 
	 * @return ��D�ɂ���J�[�h�̖���
	 */
	public int getNumberOfCards()
	{
		return hand_.getNumberOfCards();
	}

	/**
	 * �J�[�h�������B
	 * �������J�[�h�͎�D����폜�����B
	 * 
	 * @param position �J�[�h�̈ʒu�B
	 * @return position �Ŏw�肳�ꂽ�ʒu�̃J�[�h�B�͈͊O�̏ꍇ��null��Ԃ��B
	 */
	public Card pickCard(int position)
	{
		return hand_.pickCard(position);
	}
}
