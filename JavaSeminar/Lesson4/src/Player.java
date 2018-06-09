/**
 * �W�����P���̃v���C���[��\���N���X�B
 */
public class Player
{
	// �W�����P���̎��\���萔
	public static final int STONE = 0; // �O�[
	public static final int SCISSORS = 1; // �`���L
	public static final int PAPER = 2; // �p�[

	//------------------------
	// �v���C���[�N���X�̑���
	//------------------------
	/** �v���C���[�̖��O */
	private String name_;

	/** �v���C���[�̏������� */
	private int winCount_ = 0;

	//------------------------
	// �v���C���[�N���X�̑���
	//------------------------
	/**
	 * �v���C���[�N���X�̃R���X�g���N�^�B
	 * 
	 * @param name ���O
	 */
	public Player(String name)
	{
		this.name_ = name;
	}

	/**
	 * �W�����P���̎���o���B
	 *
	 * @return �W�����P���̎�
	 */
	public int showHand()
	{
		// �v���C���[�̎�
		int hand = 0;

		// 0.0�ȏ�3.0�����̏����Ƃ��ė����𓾂�
		double randomNum = Math.random() * 3;
		if (randomNum < 1)
		{
			// randomNum �� 0.0�ȏ�1.0�����̏ꍇ�A�O�[
			hand = STONE;
		}
		else if (randomNum < 2)
		{
			// randomNum �� 1.0�ȏ�2.0�����̏ꍇ�A�`���L
			hand = SCISSORS;
		}
		else if (randomNum < 3)
		{
			// randomNum �� 2.0�ȏ�3.0�����̏ꍇ�A�p�[
			hand = PAPER;
		}

		// ���肵�����߂�l�Ƃ��ĕԂ�
		return hand;
	}

	/**
	 * �R�����珟�s�𕷂��B
	 *
	 * @param result true:����,false:����
	 */
	public void notifyResult(boolean result)
	{
		if (true == result)
		{
			// �������ꍇ�͏����������Z����
			winCount_ += 1;
		}
	}

	/**
	 * �����̏������񐔂𓚂���B
	 *
	 * @return ��������
	 */
	public int getWinCount()
	{
		return winCount_;
	}

	/**
	 * �����̖��O�𓚂���B
	 * 
	 * @return ���O
	 */
	public String getName()
	{
		return name_;
	}
}
