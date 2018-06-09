
import java.util.ArrayList;

/**
 * �΂Δ����̎�D��\���N���X�B
 */
public class Hand
{
    /** ��D�ɂ���J�[�h��ێ����邽�߂̃��X�g */
    private ArrayList hand_ = new ArrayList();

    /**
     * �J�[�h��������B
     * 
     * @param card ������J�[�h
     */
    public void addCard(Card card)
    {
        // �J�[�h�����X�g�̍Ō�ɒǉ�����
        hand_.add(card);
    }

    /**
     * �J�[�h�������B
     * 
     * @return �������J�[�h
     */
    public Card pickCard()
    {
        Card pickedCard = (Card) hand_.remove(0);

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
            Card pickedCard = (Card) hand_.remove(pos);

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
     * �������̃J�[�h��T���B
     * �������̃J�[�h���Ȃ��ꍇ�� null ��Ԃ��܂��B
     * 
     * @return �������̃J�[�h
     */
    public Card[] findSameNumberCard()
    {
        int numberOfCards = hand_.size();
        Card[] sameCards = null;

        // ��D�ɃJ�[�h��1�����Ȃ��ꍇ�͉������Ȃ�
        if (numberOfCards > 0)
        {
            // �Ō�ɒǉ����ꂽ�J�[�h���擾����
            int lastIndex = numberOfCards - 1;
            Card lastAddedCard = (Card) hand_.get(lastIndex);

            // �Ō�ɒǉ����ꂽ�J�[�h�̐������擾����
            int lastAddedCardNum = lastAddedCard.getNumber();

            for (int index = 0; index < lastIndex; index++)
            {
                Card card = (Card) hand_.get(index);
                if (card.getNumber() == lastAddedCardNum)
                {
                    // �Ō�ɒǉ����ꂽ�J�[�h�Ɠ����J�[�h�����������ꍇ
                    // ���������g�ݍ��킹��sameCards�Ɋi�[���A���[�v�𔲂���
                    sameCards = new Card[2];
                    sameCards[0] = (Card) hand_.remove(lastIndex);
                    sameCards[1] = (Card) hand_.remove(index);

                    break;
                }

                // �������̑g�ݍ��킹��������Ȃ������ꍇ�A
                // sameCards��null�̂܂܂ƂȂ�B
            }
        }

        return sameCards;
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
                Card card = (Card) hand_.get(index);
                string.append(card);
                string.append(" ");
            }
        }

        return string.toString();
    }
}