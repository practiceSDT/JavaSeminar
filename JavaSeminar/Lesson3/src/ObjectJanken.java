/**
 * �I�u�W�F�N�g�w���ɂ��W�����P���v���O����
 */
public class ObjectJanken
{
    public static void main(String[] args)
    {
        // �R���i�֓�����j�̃C���X�^���X����
        Judge saito = new Judge();

        // �v���C���[�P�i���c����j�̐���
        Player murata = new Player("���c����");

        // �v���C���[�Q�i�R�c����j�̐���
        Player yamada = new Player("�R�c����");

        // ���c����ƎR�c������v���C���[�Ƃ��ăW�����P�����J�n����
        saito.startJanken(murata, yamada);
    }
}
