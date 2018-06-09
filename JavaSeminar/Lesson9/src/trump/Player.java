package trump;

/**
 * �v���C���[��\���N���X�B
 */
public abstract class Player
{
    /** ���O */
    protected String name_;

    /** �e�[�u�� */
    protected Table table_;

    /** ��D */
    protected Hand myHand_ = new Hand();

    /** �i�s�� */
    protected Master master_;
    
    /** ���[�� */
    protected Rule rule_;
    
    /**
     * �R���X�g���N�^�B
     * 
     * @param name ���O
     * @param master �i�s��
     * @param table �e�[�u��
     * @param rule ���[��
     */
    public Player(String name, Master master, Table table, Rule rule)
    {
        this.name_ = name;
        this.master_ = master;
        this.table_ = table;
        this.rule_ = rule;
    }

    /**
     * ���Ԃ��w������B
     * ���ۂ̏����̓T�u�N���X�ŋL�q���邱�ƁB
     * 
     * @param nextPlayer ���̃v���C���[
     */
    public abstract void play(Player nextPlayer);

    /**
     * �J�[�h��z��B<br>
     * �J�[�h���󂯎�������̏������g���������ꍇ�́A
     * �{���\�b�h���T�u�N���X�ŃI�[�o�[���C�h���邱�ƁB
     *
     * @param card �󂯎�����J�[�h
     */
    public void receiveCard(Card card)
    {
        // �󂯎�����J�[�h����D�ɉ�����
        myHand_.addCard(card);
    }
    
    /**
     * �v���C���[�̖��O��Ԃ��B
     * Object�N���X��toString���\�b�h���I�[�o�[���C�h�������\�b�h�B
     * 
     * @return �v���C���[�̖��O
     */
    public String toString()
    {
        return name_;
    }
}
