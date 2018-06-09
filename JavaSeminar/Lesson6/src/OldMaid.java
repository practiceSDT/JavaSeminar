/**
 * �΂Δ����v���O�����B
 */
public class OldMaid
{
    public static void main(String args[])
    {
        // �i�s���̐���
        Master master = new Master();
        
        // ��̐���
        Table field = new Table();
        
        // �v���C���[�̐���
        Player murata = new Player("���c", master, field);
        Player yamada = new Player("�R�c", master, field);
        Player saito  = new Player("�֓�", master, field);
        
        // �i�s���փv���C���[��o�^
        master.registerPlayer(murata);
        master.registerPlayer(yamada);
        master.registerPlayer(saito);
        
        // �g�����v�𐶐�����
        Hand trump = createTrump();
        
        // �Q�[���̏���������
        master.prepareGame(trump);
        
        // �Q�[�����J�n����
        master.startGame();
        
    }
    
    /**
     * 53���̃g�����v�𐶐�����B
     * 
     * @return �g�����v���i�[����Hand
     */
    private static Hand createTrump()
    {
        Hand trump = new Hand();
        
        // �e�X�[�g53���̃J�[�h�𐶐�����
        for (int number = 1; number <= 13; number++)
        {
            trump.addCard(new Card(Card.SUIT_CLUB, number));
            trump.addCard(new Card(Card.SUIT_DIAMOND, number));
            trump.addCard(new Card(Card.SUIT_HEART, number));
            trump.addCard(new Card(Card.SUIT_SPADE, number));
        }
        
        // �W���[�J�[�̍쐬
        trump.addCard(new Card(0, Card.JOKER));
        
        return trump;
    }
}
