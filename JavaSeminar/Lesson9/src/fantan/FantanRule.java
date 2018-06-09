package fantan;

import trump.Card;
import trump.Table;
import trump.Hand;
import trump.Rule;

/**
 * �����חp���[���N���X�B
 */
public class FantanRule implements Rule
{
	/**
	 * �e�[�u���ɒu����J�[�h��T���B
	 * 
	 * @param hand ��D
	 * @param table �e�[�u��
	 * @return ���������J�[�h�̑g�ݍ��킹�B������Ȃ������ꍇ��null��Ԃ��B
	 */
	public Card[] findCandidate(Hand hand, Table table)
	{
		// �e�[�u���ɒu����J�[�h�̌��
		Card[] candidate = null;

		// ��D�ɂ���J�[�h��1�����`�F�b�N���āA�e�[�u���ɒu���邩���ׂ�
		int numberOfHand = hand.getNumberOfCards();
		for (int position = 0; position < numberOfHand; position++)
		{
			// ��D�ɂ���J�[�h������
			Card lookingCard = hand.lookCard(position);
			int number = lookingCard.getNumber();
			int suit = lookingCard.getSuit();

			// �����ڂ��Ă����D�̍����E�ɃJ�[�h������΁A�J�[�h��u����
			int leftNumber = (number != 1) ? number - 1 : Card.CARD_NUM;
			int rightNumber = (number != Card.CARD_NUM) ? number + 1 : 1;

			if ((true == isThereCard(table, suit, leftNumber))
				|| (true == isThereCard(table, suit, rightNumber)))
			{
				// ��D����J�[�h�������Č��Ƃ���
				candidate = new Card[1];
				candidate[0] = hand.pickCard(position);
				break;
			}
		}

		return candidate;
	}

	/**
	 * �e�[�u���ɃJ�[�h���u����Ă��邩���ׂ�B
	 * 
	 * @param table �e�[�u��
	 * @param suit �X�[�g
	 * @param number ��
	 * @return �J�[�h���u����Ă���ꍇ��true
	 */
	private boolean isThereCard(Table table, int suit, int number)
	{
		// �e�[�u���ɂ���J�[�h�𒲂ׁA�J�[�h���u����Ă��邩���ׂ�
		Card[][] cards = table.getCards();
		if (cards[suit - 1][number - 1] != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
