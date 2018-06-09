package fantan;

import trump.Card;
import trump.Master;
import trump.Table;
import trump.Player;
import trump.Rule;

/**
 * �����חp�v���C���[�N���X�B
 */
public class FantanPlayer extends Player
{
    /** �p�X������ */
    private int pass_;

    /**
     * �R���X�g���N�^�B
     * 
     * @param name    �v���C���[�̖��O
     * @param master �i�s��
     * @param table  �e�[�u��
     * @param rule    ���[��
     */
    public FantanPlayer(String name, Master master, Table table, Rule rule)
    {
        super(name, master, table, rule);
    }

    /**
     * �J�[�h��z��B
     * 
     * @param card �󂯎�����J�[�h
     */
    public void receiveCard(Card card)
    {
        if (card.getNumber() == 7)
        {
            // �J�[�h��7�̏ꍇ�́A�e�[�u���ɃJ�[�h��u��
            System.out.println(name_ + "�F" + card + "��u���܂����B");
            table_.putCard(new Card[] { card });
        }
        else
        {
            // �J�[�h��7�łȂ��ꍇ�́A�󂯎�����J�[�h����D�։�����
            super.receiveCard(card);
        }
    }

    /**
     * ���Ԃ��w������B
     * 
     * @param nextPlayer ���̃v���C���[
     */
    public void play(Player nextPlayer)
    {
        // ���݂̎�D��\������
        System.out.println("  " + myHand_);

        // ���݂̎�D����e�[�u���ɏo������̂�T��
        Card[] candidate = rule_.findCandidate(myHand_, table_);

        // ��₪����ꍇ�̓e�[�u���ɏo��
        if (candidate != null)
        {
            System.out.println("  " + candidate[0] + "��u���܂����B\n");
            table_.putCard(candidate);
            
            // �e�[�u���̏�Ԃ�\������
            System.out.println(table_);

            // ��D���Ȃ��Ȃ�����A�オ���錾����
            if (myHand_.getNumberOfCards() == 0)
            {
                master_.declareWin(this);
            }
        }
        else
        {
            // �e�[�u���ɏo����J�[�h���Ȃ������ꍇ�A�p�X����
            pass_++;
            ((FantanMaster)master_).pass(this);

            // �p�X�񐔂������񐔈ȏ�Ȃ�΃J�[�h��S�ăe�[�u���ɒu��
            if (pass_ > FantanMaster.PASS_LIMIT)
            {
                int numberOfHand = myHand_.getNumberOfCards();
                // ��D��S�ăe�[�u���ɒu��
                for (int count = 0; count < numberOfHand; count++)
                {
                    table_.putCard(new Card[] { myHand_.pickCard(0)});
                }
            }
        }
    }

    /**
     * �p�X�񐔂�������B
     * 
     * @return �p�X��
     */
    public int getPass()
    {
        return pass_;
    }
}
