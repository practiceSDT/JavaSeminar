package fantan;

import trump.Master;

/**
 * �����חp�i�s���N���X�B
 */
public class FantanMaster extends Master
{
    /** �p�X�ł��鐧���� */
    public static final int PASS_LIMIT = 3;

    /**
     * �p�X��錾����B<br>
     * 
     * @param player �p�X����v���C���[
     */
    public void pass(FantanPlayer player)
    {
        // �p�X��\��
        System.out.println(
            "  " + player + "����� " + player.getPass() + " ��ڂ̃p�X���܂����I");

        if (player.getPass() > PASS_LIMIT)
        {
            // �p�X�񐔂������l�𒴂��Ă���ꍇ�͕����B
            System.out.println("  " + player + "����͕����ł��I");
            deregisterPlayer(player);
        }
    }
}
