/**
 * �헪�C���^�[�t�F�[�X�ɑΉ������W�����P���v���O�����B
 */
public class ObjectJanken
{
  public static void main(String[] args)
  {
	// �R���̃C���X�^���X����
	Judge judge = new Judge();
    
	// �v���C���[�P�i���c����j�̐���
	Player murata = new Player("���c����");
    
	// ���c����ɓn���헪�N���X�𐶐�����
	Tactics murataTactics = new StoneOnlyTactics();
    
	// ���c����ɐ헪�N���X��n��
	murata.setTactics(murataTactics);
    
	// �v���C���[�Q�i�R�c����j�̐���
	Player yamada = new Player("�R�c����");
    
	// �R�c����ɓn���헪�N���X�𐶐�����
	Tactics yamadaTactics = new RandomTactics();
    
	// �R�c����ɐ헪�N���X��n��
	yamada.setTactics(yamadaTactics);
    
	// ���c����ƎR�c������v���C���[�Ƃ��ăW�����P�����J�n����
	judge.startJanken(murata, yamada);
  }
}
