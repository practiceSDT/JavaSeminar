/**
 * �헪�C���^�[�t�F�[�X�ɑΉ������W�����P���v���O����(�N���X���[�_�Ή���)
 */
public class ObjectJanken2
{
	public static void main(String[] args)
	{
		try
		{
			// �R���̃C���X�^���X����
			Judge judge = new Judge();

			// �v���C���[�P�i���c����j�̐���
			Player murata = new Player("���c����");
			
			// �����Ŏw�肳�ꂽ�N���X����Class�I�u�W�F�N�g���擾����
			Class tacticsClass = Class.forName(args[0]);
			
			// Class�I�u�W�F�N�g���g�p���Ĉ����Ŏw�肳�ꂽ�N���X�𐶐�����
			Tactics murataTactics = (Tactics)tacticsClass.newInstance();

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
		catch (ClassNotFoundException ex)
		{
			System.err.println("�N���X��������܂��� : " + args[0]);
		}
		catch (InstantiationException e)
		{
			System.err.println("�N���X�̐����Ɏ��s���܂��� : " + args[0]);
		}
		catch (IllegalAccessException e)
		{
			System.err.println("�N���X�̐����Ɏ��s���܂��� : " + args[0]);
		}
	}
}
