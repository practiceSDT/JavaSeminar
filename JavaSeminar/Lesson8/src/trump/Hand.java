package trump;

import java.util.ArrayList;

/**
 * ��D��\���N���X�B
 */
public class Hand
{
	/** ��D�ɂ���J�[�h��ێ����邽�߂̃��X�g */
	private ArrayList hand_ = new ArrayList();

	/**
	 * �J�[�h��������B<br>
	 * 
	 * @param card ������J�[�h
	 */
	public void addCard(Card card)
	{
		// �J�[�h�����X�g�̍Ō�ɒǉ�����
		hand_.add(card);
	}

	/**
	 * �J�[�h������B
	 * position�� 0 ���� getNumberOfCards() �͈̔͂Ŏw�肷�邷�邱�ƁB
	 * 
	 * @param position �J�[�h�̈ʒu�B
	 * @return position �Ŏw�肳�ꂽ�ʒu�̃J�[�h�B�͈͊O�̏ꍇ��null��Ԃ��B
	 */
	public Card lookCard(int position)
	{
		Card lookingCard = null;

		// �����Ŏw�肳�ꂽ�ʒu���Ó��ł��邩�`�F�b�N���� 
		if ((0 <= position) && (position < hand_.size()))
		{
			lookingCard = (Card)hand_.get(position);
		}

		return lookingCard;
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
		Card pickedCard = null;

		// �����Ŏw�肳�ꂽ�ʒu���Ó��ł��邩�`�F�b�N���� 
		if ((0 <= position) && (position < hand_.size()))
		{
			pickedCard = (Card)hand_.remove(position);
		}

		return pickedCard;
	}

	/**
	 * �V���b�t������B
	 */
	public void shuffle()
	{
		// ��D�̖������擾
		int number = hand_.size();

		// �J�[�h�𔲂��o���ʒu
		int pos;

		// �J�[�h�������_���ɔ�������čŌ�ɉ����铮����J��Ԃ�
		for (int count = 0; count < number * 2; count++)
		{
			// �����_���Ȉʒu����J�[�h���ꖇ�������
			pos = (int) (Math.random() * number);
			Card pickedCard = (Card)hand_.remove(pos);

			// ����������J�[�h���Ō�ɉ�����
			hand_.add(pickedCard);
		}
	}

	/**
	 * �����𐔂���B
	 * 
	 * @return ��D�ɂ���J�[�h�̖���
	 */
	public int getNumberOfCards()
	{
		return hand_.size();
	}

	/**
	 * ��D�ɂ���J�[�h�𕶎���ŕ\������B
	 * Object�N���X��toString���\�b�h���I�[�o�[���C�h�������\�b�h�B
	 * 
	 * @return ��D�ɂ���J�[�h�̕�����\��
	 */
	public String toString()
	{
		StringBuffer string = new StringBuffer();

		int size = hand_.size();
		if (size > 0)
		{
			for (int index = 0; index < size; index++)
			{
				Card card = (Card)hand_.get(index);
				string.append(card);
				string.append(" ");
			}
		}

		return string.toString();
	}
}
