
import java.util.ArrayList;

/**
 * �e�[�u����\���N���X�B
 */
public class Table
{
    /** �̂Ă�ꂽ�J�[�h��ێ����Ă������߂̃��X�g */
    private ArrayList disposedCards_ = new ArrayList();

    /**
     * �J�[�h���̂Ă�B
     * 
     * @param card �̂Ă�J�[�h�̔z��
     */
    public void disposeCard(Card card[])
    {
        for (int index = 0; index < card.length; index++)
        {
            // �̂Ă�ꂽ�J�[�h��\������
            System.out.print(card[index] + " ");
        }

        System.out.println("���̂Ă܂���");

        // �̂Ă�ꂽ�J�[�h�̓��X�g�ɒǉ����ĕێ����Ă����B
        disposedCards_.add(card);
    }
}