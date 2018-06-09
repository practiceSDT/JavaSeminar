/**
 * �΂Δ����̃v���C���[�N���X�B
 */
public class Player
{
    /** �i�s�� */
    private Master master_;

    /** �e�[�u�� */
    private Table  table_;

    /** �����̎�D */
    private Hand   myHand_ = new Hand();

    /** ���O */
    private String name_;

    /**
     * �R���X�g���N�^�B
     * 
     * @param name ���O
     * @param master �i�s��
     * @param table �e�[�u��
     */
    public Player(String name, Master master, Table table)
    {
        this.name_ = name;
        this.master_ = master;
        this.table_ = table;
    }

    /**
     * ���Ԃ��w������B
     * 
     * @param nextPlayer ���̃v���C���[
     */
    public void play(Player nextPlayer)
    {
        // ���̃v���C���[�Ɏ�D���o���Ă��炤
        Hand nextHand = nextPlayer.showHand();

        // ����̎�D����J�[�h���ꖇ����
        Card pickedCard = nextHand.pickCard();

        // ���������ʂ�\��
        System.out.println(this + "�F" + nextPlayer + "���񂩂� " + pickedCard
                + " �������܂���");

        // �������J�[�h�������̎�D�ɉ����A�������̃J�[�h����������̂Ă�
        dealCard(pickedCard);

        // ��D���[���ɂȂ������ǂ������ׂ�
        if (myHand_.getNumberOfCards() == 0)
        {
            // �i�s���ɏオ���錾����
            master_.declareWin(this);
        }
        else
        {
            // ���݂̎�D��\������
            System.out.println(this + "�F�c��̎�D�� " + myHand_ + "�ł�");
        }
    }

    /**
     * ��D��������B
     * 
     * @return �����̎�D
     */
    public Hand showHand()
    {
        // �������̎��_�Ŏ�D���c��1���Ȃ�Ώオ��ƂȂ�̂Ő錾����
        if (myHand_.getNumberOfCards() == 1)
        {
            master_.declareWin(this);
        }

        // ������O�ɃV���b�t������
        myHand_.shuffle();

        return myHand_;
    }

    /**
     * �J�[�h���󂯎��B
     * 
     * @param card �󂯎�����J�[�h
     */
    public void receiveCard(Card card)
    {
        // �������J�[�h�������̎�D�ɉ����A�������̃J�[�h����������̂Ă�
        dealCard(card);
    }

    /**
     * �J�[�h�������̎�D�ɉ����A�������̃J�[�h����������̂Ă�B
     * 
     * @param card
     */
    private void dealCard(Card card)
    {
        // �J�[�h�������̎�D�ɉ�����
        myHand_.addCard(card);

        // ���������J�[�h�Ɠ����J�[�h��T��
        Card[] sameCards = myHand_.findSameNumberCard();

        // �����J�[�h�̑g�ݍ��킹�����݂����ꍇ
        if (sameCards != null)
        {
            // �e�[�u���փJ�[�h���̂Ă�
            System.out.print(this + "�F");
            table_.disposeCard(sameCards);
        }
    }

    /**
     * �v���C���[�̖��O��Ԃ��B <br>
     * Object�N���X��toString���\�b�h���I�[�o�[���C�h�������\�b�h�B
     * 
     * @return �v���C���[�̖��O
     */
    public String toString()
    {
        return name_;
    }
}