/**
 * �헪�C���^�[�t�F�[�X�ɑΉ������W�����P���v���O����
 */
public class ObjectJanken
{
  public static void main(String[] args)
  {
	// �R���̃C���X�^���X����
	Judge judge = new Judge();
    
	// �v���C���[�P�i���c����j�̐���
	Player murata = new Player("���c����");
    
	// �v���C���[�Q�i�R�c����j�̐���
	Player yamada = new Player("�R�c����");
    
	// ���c����ƎR�c������v���C���[�Ƃ��ăW�����P�����J�n����
	judge.startJanken(murata, yamada);
  }
}
