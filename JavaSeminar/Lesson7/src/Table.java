/**
 * �e�[�u����\���N���X�B
 */
public class Table
{
	/** �e�[�u������ׂ���\���Q�����z�� */
	private Card[][] table_ = new Card[4][13];
	
	/**
	 * �e�[�u���ɃJ�[�h��u���B
	 * 
	 * @param card �J�[�h
	 */
	public void putCard(Card card)
	{
		int number = card.getNumber();
		int suit = card.getSuit();
		
		// ��ɃJ�[�h��u��
		table_[suit - 1][number - 1] = card;
		
		// �u���ꂽ�J�[�h��\������
		System.out.println("  " + card + "��u���܂����B\n");
		
		// ���݂̏�̏�Ԃ�\������
		System.out.println(toString());
	}
	
	/**
	 * �e�[�u���ɃJ�[�h���u����Ă��邩���ׂ�B
	 * 
	 * @return �J�[�h���u����Ă���ꍇ��true
	 */
	public boolean isThereCard(int suit, int number)
	{
		if (table_[suit - 1][number - 1] != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	/**
	 * �e�[�u���𕶎���ŕ\������B
	 * Object�N���X��toString���\�b�h���I�[�o�[���C�h�������\�b�h�B
	 * 
	 * @return ��̕�����\��
	 */
	public String toString()
	{
		StringBuffer fieldString = new StringBuffer(200);
		for (int suit = 0; suit < 4; suit++)
		{
			for (int number = 0; number < 13; number++)
			{
				if (table_[suit][number] != null)
				{
					fieldString.append(table_[suit][number]);
				}
				else
				{
					fieldString.append("..");
				}
				
				fieldString.append(" ");
			}
			
			fieldString.append("\n");
		}
		
		return fieldString.toString();
	}
}
