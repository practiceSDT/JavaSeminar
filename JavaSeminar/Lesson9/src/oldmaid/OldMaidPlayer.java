package oldmaid;

import trump.Card;
import trump.Master;
import trump.Table;
import trump.Player;
import trump.Rule;

/**
 * �΂Δ����̃v���C���[�N���X�B
 */
public class OldMaidPlayer extends Player
{
    /** �����猩����D��\���N���X */
    private BackHand backHand_ = new BackHand(myHand_);

    /**
     * �R���X�g���N�^�B
     * 
     * @param name   ���O
     * @param master �i�s��
     * @param table  �e�[�u��
     * @param rule   ���[��
     */
    public OldMaidPlayer(String name, Master master, Table table, Rule rule)
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
        // �󂯎�����J�[�h����D�։�����
        super.receiveCard(card);

        // ���[�����g�p���ăe�[�u���ɏo����J�[�h�����邩�T��
        Card[] candidate = rule_.findCandidate(myHand_, table_);

        // �e�[�u���ɏo����J�[�h������ꍇ�͏�ɏo��
        if (candidate != null)
        {
            System.out.print(this +"�F");
            table_.putCard(candidate);
        }
    }

    /**
     * ���Ԃ��w������B
     * 
     * @param nextPlayer ���̃v���C���[
     */
    public void play(Player nextPlayer)
    {
        // ���̃v���C���[�Ɏ�D��񎦂��Ă��炤
        BackHand nextPlayersHand = ((OldMaidPlayer)nextPlayer).showHand();

        // ����̎�D����J�[�h���ꖇ����
        int numberOfHands = nextPlayersHand.getNumberOfCards();
        Card pickedCard =
            nextPlayersHand.pickCard((int) (Math.random() * numberOfHands));

        // ���������ʂ�\��
        System.out.println(
            this +"�F" + nextPlayer + "���񂩂� " + pickedCard + "�������܂���");

        // �������J�[�h�������̎�D�ɉ�����
        myHand_.addCard(pickedCard);

        // �e�[�u���ɏo����J�[�h�̑g�ݍ��킹�����邩�T��
        Card[] sameCards = rule_.findCandidate(myHand_, table_);

        // �����J�[�h�̑g�ݍ��킹�����݂����ꍇ
        if (sameCards != null)
        {
            System.out.print(this +"�F");
            table_.putCard(sameCards);

            // ��D���[���ɂȂ������ǂ������ׂ�
            if (myHand_.getNumberOfCards() == 0)
            {
                // �i�s���ɏオ���錾����
                master_.declareWin(this);
            }
        }

        // ���݂̎�D��\��
        System.out.println(this +"�F�c��̎�D�� " + myHand_ + "�ł�");
    }

    /**
     * ��D���o���B
     * ����ɃJ�[�h�������Ă��炤���߂ɁA��D��������B
     * 
     * @return �����̎�D
     */
    public BackHand showHand()
    {
        // �������̎��_�Ŏ�D���c��1���Ȃ�Ώオ��ƂȂ�̂Ő錾����
        if (myHand_.getNumberOfCards() == 1)
        {
            master_.declareWin(this);
        }

        // ������O�ɃV���b�t������
        myHand_.shuffle();

        // ����Ɏ�D�𗠂��猩���邽�߁ABackHand��Ԃ�
        return backHand_;
    }
}
