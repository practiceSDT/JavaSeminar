package mit.javaseminar.oo.lesson7.oldmaid;

import java.util.ArrayList;

import mit.javaseminar.oo.lesson7.trump.Card;
import mit.javaseminar.oo.lesson7.trump.Table;

/**
 * �΂Δ����̃e�[�u����\���N���X�B
 */
public class OldMaidTable implements Table
{
    /** �̂Ă�ꂽ�J�[�h��ێ����Ă������߂̃��X�g */
    private ArrayList<Card> disposedCards_ = new ArrayList<Card>();
    
    /**
     * �J�[�h���̂Ă�B
     * 
     * @param cards �̂Ă�J�[�h
     */
    public void putCard(Card[] cards)
    {
        for (int index = 0; index < cards.length; index++)
        {
            // �̂Ă�ꂽ�J�[�h��\������
            System.out.print(cards[index] + " ");
        
            // �̂Ă�ꂽ�J�[�h�̓��X�g�ɒǉ����ĕێ����Ă����B
            disposedCards_.add(cards[index]);
        }
        
        System.out.println("���̂Ă܂���");
    }
    
    /**
     * �J�[�h������B
     * 
     * @return �e�[�u���ɒu���ꂽ�J�[�h��\���z��
     */
    public Card[][] getCards()
    {
        // �΂Δ����ł̓J�[�h������K�v�͂Ȃ����߁Anull��Ԃ�
        return null;
    }
}
