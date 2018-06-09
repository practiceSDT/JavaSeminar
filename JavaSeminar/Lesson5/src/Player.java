/**
 * �W�����P�����s���v���C���[�N���X�B
 */
public class Player
{
	/** �O�[ */
	public static final int STONE = 0;

	/** �`���L */
	public static final int SCISSORS = 1;

	/** �p�[ */
	public static final int PAPER = 2;

	/** �v���C���[�̖��O */
	private String name;

	/** �v���C���[�̏������� */
	private int winCount = 0;

	/** �^����ꂽ�헪 */
	private Tactics tactics_;

	/**
	 * �v���C���[�N���X�̃R���X�g���N�^�B
	 * 
	 * @param name ���O
	 */
	public Player(String name)
	{
		this.name = name;
	}

	/**
	 * �v���C���[�ɐ헪��n���B
	 * 
	 * @param tactics �헪
	 */
	void setTactics(Tactics tactics)
	{
		tactics_ = tactics;
	}

	/**
	 * �W�����P���̎���o���B
	 *
	 * @return �W�����P���̎�
	 */
	int showHand()
	{
		// �^����ꂽ�헪��ǂ�ŃW�����P���̎�����߂�
		int hand = tactics_.readTactics();

		// ���肵�����߂�l�Ƃ��ĕԂ�
		return hand;
	}

	/**
	 * ���s�𕷂�(������)�B
	 *
	 * @param result true:����,false:����
	 */
	void notifyResult(boolean result)
	{
		if (true == result)
		{
			// �������ꍇ�͏����������Z����
			winCount += 1;
		}
	}

	/**
	 * �����̏������񐔂𓚂���
	 *
	 * @return ��������
	 */
	int getWinCount()
	{
		return winCount;
	}

	/**
	 * �����̖��O�𓚂���B
	 * 
	 * @return ���O
	 */
	String getName()
	{
		return name;
	}
}
