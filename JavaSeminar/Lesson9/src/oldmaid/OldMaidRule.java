package oldmaid;

import trump.Card;
import trump.Table;
import trump.Hand;
import trump.Rule;

/**
 * �΂Δ����p���[���N���X�B
 */
public class OldMaidRule implements Rule
{
	/**
	 * ��D�ƃe�[�u������A�e�[�u���ɏo������J�[�h�̑g�ݍ��킹��T���B
	 * 
	 * @param hand  ��D
	 * @param table �e�[�u��
	 * @return ���������J�[�h�̑g�ݍ��킹�B������Ȃ������ꍇ��null��Ԃ��B
	 */
	public Card[] findCandidate(Hand hand, Table table)
	{
		// ��D�ɂ���J�[�h�����ԂɌ��ē����l�̑g�ݍ��킹��T��
		// ��D�̋t�����璲�ׂĂ���͍̂Ō�ɒǉ����ꂽ�J�[�h����
		// �D��I�Ƀ`�F�b�N���Ĕ�r�񐔂����炷����
		int numberOfHand = hand.getNumberOfCards();
		for (int position = numberOfHand - 1; position >= 0; position--)
		{
			Card firstCard = hand.lookCard(position);
			for (int comparePos = position - 1; comparePos >= 0; comparePos--)
			{
				Card secondCard = hand.lookCard(comparePos);

				// �����l�̑g�ݍ��킹������������J�[�h�������Ė߂�
				if (firstCard.getNumber() == secondCard.getNumber())
				{
					Card[] candidate = new Card[2];
					candidate[0] = hand.pickCard(position);
					candidate[1] = hand.pickCard(comparePos);
					return candidate;
				}
			}
		}

		// �����l��������Ȃ������ꍇ�Anull��Ԃ�
		return null;
	}
}
