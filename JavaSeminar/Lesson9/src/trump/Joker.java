package trump;

/**
 * �W���[�J�[��\���N���X�B
 * Card�N���X���p�����Ă���B
 * setNumber()�AsetSuit()���\�b�h�𗘗p���邱�ƂŁA�ǂ̂悤�ȃJ�[�h�Ƃ��Ă�
 * �������Ƃ��ł���B
 */
public class Joker extends Card
{
	/**
	 * �R���X�g���N�^�B
	 * �f�t�H���g�ł́A�W���[�J�[�͉��̒l�E�X�[�g���\���Ȃ��B 
	 * getNumber()�AgetSuit()��0��Ԃ��B
	 */
	public Joker()
	{
		super(0, 0);
	}
	
	/**
	 * ����ύX����B
	 * 
	 * @param number ��
	 */
	public void setNumber(int number)
	{
		this.number_ = number;
	}
	
	/**
	 * �X�[�g��ύX����B
	 * @param suit
	 */
	public void setSuit(int suit)
	{
		this.suit_ = suit;
	}
	
	/**
	 * �J�[�h�𕶎���ŕ\������B
	 * Object�N���X��toString���\�b�h���I�[�o�[���C�h�������\�b�h�B
	 * 
	 * @return �J�[�h�̕����\��
	 */
	public String toString()
	{
		return "JK";
	}	
}
