package fantan;

import trump.Card;
import trump.Master;
import trump.Table;
import trump.Hand;
import trump.Player;
import trump.Rule;

/**
 * �����׃v���O�����B
 */
public class Fantan
{
    public static void main(String args[])
    {
        // �i�s���̐���
        Master master = new FantanMaster();
        
        // �e�[�u���̐���
        Table table = new FantanTable();
        
        // ���[���̐���
        Rule rule = new FantanRule();
        
        // �v���C���[�̐���
        Player murata = new FantanPlayer("���c", master, table, rule);
        Player yamada = new FantanPlayer("�R�c", master, table, rule);
        Player saito  = new FantanPlayer("�֓�", master, table, rule);
        
        // �v���C���[��o�^
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
     * @return �g�����v���i�[����Deal
     */
    private static Hand createTrump()
    {
        Hand trump = new Hand();
        
        // �e�X�[�g53���̃J�[�h�𐶐�����
        for (int number = 1; number <= Card.CARD_NUM; number++)
        {
            trump.addCard(new Card(Card.SUIT_CLUB, number));
            trump.addCard(new Card(Card.SUIT_DIAMOND, number));
            trump.addCard(new Card(Card.SUIT_HEART, number));
            trump.addCard(new Card(Card.SUIT_SPADE, number));
        }
        
        return trump;
    }
}

