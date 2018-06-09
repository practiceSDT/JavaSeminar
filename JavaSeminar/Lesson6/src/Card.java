/**
 * �g�����v�̃J�[�h��\���N���X�B
 */
public class Card
{
	/** �W���[�J�[��\���萔 */
	public static final int JOKER = 0;
	
	/** �X�y�[�h��\���萔 */
	public static final int SUIT_SPADE   = 1;
	
	/** �_�C����\���萔 */
	public static final int SUIT_DIAMOND = 2;
	
	/** �N���u��\���萔 */
	public static final int SUIT_CLUB    = 3;
	
	/** �n�[�g��\���萔 */
	public static final int SUIT_HEART   = 4;
	
	/** �J�[�h�̎����X�[�g */
	private int suit_;
	
	/** �J�[�h�̎����� */
	private int number_;
	
	/**
	 * �R���X�g���N�^�B
	 * 
	 * @param suit �X�[�g
	 * @param number �� (0�̏ꍇ�̓W���[�J�[�Ƃ��Ĉ���)
	 */
	public Card(int suit, int number)
	{
		this.suit_ = suit;
		this.number_ = number;
	}
	
	/**
	 * ����������B
	 * 
	 * @return �� 
	 */
	public int getNumber()
	{
		return number_;
	}
	
	/**
	 * �J�[�h�𕶎���ŕ\������B
	 * Object�N���X��toString���\�b�h���I�[�o�[���C�h�������\�b�h�B
	 * 
	 * @return �J�[�h�̕����\��
	 */
	public String toString()
	{
		StringBuffer string = new StringBuffer();
		
		if (number_ > 0)
		{
			// �X�[�g�̕\��
			switch (suit_)
			{
				case SUIT_SPADE :
					string.append("S");
					break;
			
				case SUIT_DIAMOND :
					string.append("D");
					break;
			
				case SUIT_CLUB :
					string.append("C");
					break;
				
				case SUIT_HEART :
					string.append("H");
					break;
			
				default :
					break;
			}
			
			// ���̕\��
			switch (number_)
			{
				case 1 :
					string.append("A");
					break;

				case 10 :
					string.append("T");
					break;
				
				case 11 :
					string.append("J");
					break;
				
				case 12 :
					string.append("Q");
					break;
					
				case 13 :
					string.append("K");
					break;
				
				default :
					string.append(number_);
					break;
			}
		}
		else
		{
			// �W���[�J�[��\��
			string.append("JK");
		}
		
		return string.toString();
	}
}
