/**
 * �v���C���[��\���N���X�B
 */
public class Player
{
	/** ���O */
	private String name_;

	/** �e�[�u�� */
	Table table_;

	/** ��D */
	Hand myHand_ = new Hand();

	/** �i�s�� */
	Master master_;

	/** �p�X������ */
	int pass_;

	/**
	 * �R���X�g���N�^�B
	 * 
	 * @param name ���O
	 * @param master �i�s��
	 * @param table �e�[�u��
	 */
	public Player(String name, Master master, Table table)
	{
		this.name_ = name;
		this.master_ = master;
		this.table_ = table;
	}

	/**
	 * ���Ԃ��w������B
	 */
	public void play()
	{
		// ���݂̎�D��\������
		System.out.println("  " + myHand_);
		
		// ��D�ɂ���J�[�h��1�����`�F�b�N���āA��ɒu���邩���ׂ�
		int handSize = myHand_.getNumberOfCards();
		for (int position = 0; position < handSize; position++)
		{
			// ��D�ɂ���J�[�h������
			Card lookingCard = myHand_.lookCard(position);

			int number = lookingCard.getNumber();
			int suit = lookingCard.getSuit();

			// �����ڂ��Ă����D�̍����E�ɃJ�[�h������΁A�J�[�h��u����
			int leftNumber = (number != 1) ? number - 1 : 13;
			int rightNumber = (number != 13) ? number + 1 : 1;

			if ((true == table_.isThereCard(suit, leftNumber))
				|| (true == table_.isThereCard(suit, rightNumber)))
			{
				// ��D����J�[�h�������ăe�[�u���ɒu��
				table_.putCard(myHand_.pickCard(position));

				// ��D���Ȃ��Ȃ�����A�オ���錾����
				if (myHand_.getNumberOfCards() == 0)
				{
					master_.declareWin(this);
				}

				return;
			}
		}

		// �e�[�u���ɒu����J�[�h���Ȃ������ꍇ�A�p�X����
		pass_++;
		master_.pass(this);

		// �p�X�񐔂�4��ȏ�Ȃ�΃J�[�h��S�ăe�[�u���ɒu��
		if (pass_ > 3)
		{
			// ��D��S�ăe�[�u���ɒu��
			for (int count = 0; count < handSize; count++)
			{
				table_.putCard(myHand_.pickCard(0));
			}
		}
	}

	/**
	 * �J�[�h���󂯎��B
	 * 
	 * @param card �󂯎�����J�[�h
	 */
	public void receiveCard(Card card)
	{
		if (card.getNumber() == 7)
		{
			// �J�[�h��7�̏ꍇ�́A�e�[�u���ɃJ�[�h��u��
			table_.putCard(card);
		}
		else
		{
			// �J�[�h��7�łȂ��ꍇ�́A�󂯎�����J�[�h����D�։�����
			myHand_.addCard(card);
		}
	}

	/**
	 * �p�X�񐔂𕷂��B
	 * 
	 * @return �p�X��
	 */
	public int getPass()
	{
		return pass_;
	}

	/**
	 * �v���C���[�̖��O��Ԃ��B
	 * Object�N���X��toString���\�b�h���I�[�o�[���C�h�������\�b�h�B
	 * 
	 * @return �v���C���[�̖��O
	 */
	public String toString()
	{
		return name_;
	}
}
