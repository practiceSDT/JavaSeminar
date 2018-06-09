package fantan;

import trump.Card;
import trump.Table;

/**
 * �����ׂ̃e�[�u����\���N���X�B
 */
public class FantanTable implements Table
{
	/** �J�[�h����ׂ�e�[�u����\���Q�����z�� */
	private Card[][] table_ = new Card[Card.SUIT_NUM][Card.CARD_NUM];
	
	/**
	 * �J�[�h��u���B
	 * 
	 * @param card �J�[�h
	 */
	public void putCard(Card[] card)
	{
		int number = card[0].getNumber();
		int suit = card[0].getSuit();
		
		// �e�[�u���ɃJ�[�h��u��
		table_[suit - 1][number - 1] = card[0];
	}

	/**
	 * �J�[�h������B
	 * 
	 * @return �e�[�u���ɒu���ꂽ�J�[�h��\���z��
	 */
	public Card[][] getCards()
	{
		Card[][] table = new Card[Card.SUIT_NUM][Card.CARD_NUM];
		for (int suit = 0; suit < Card.SUIT_NUM; suit++)
		{
			System.arraycopy(table_[suit], 0, table[suit], 0, Card.CARD_NUM);
		}
		
		return table;
	}
	
	/**
	 * �e�[�u���𕶎���ŕ\������B
	 * Object�N���X��toString���\�b�h���I�[�o�[���C�h�������\�b�h�B
	 * 
	 * @return �e�[�u���̕�����\��
	 */
	public String toString()
	{
		StringBuffer tableString = new StringBuffer(200);
		for (int suit = 0; suit < Card.SUIT_NUM; suit++)
		{
			for (int number = 0; number < Card.CARD_NUM; number++)
			{
				if (table_[suit][number] != null)
				{
					tableString.append(table_[suit][number]);
				}
				else
				{
					tableString.append("..");
				}
				
				tableString.append(" ");
			}
			
			tableString.append("\n");
		}
		
		return tableString.toString();
	}
}
