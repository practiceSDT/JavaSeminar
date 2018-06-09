import java.util.ArrayList;

/**
 * �i�s����\���N���X�B<br>
 */
public class Master
{
	/** �v���C���[�̃��X�g */
	private ArrayList players = new ArrayList();
	
	/**
	 * �Q�[���̏���������B
	 * 
	 * @param cards �g�����v��i�s���̎�D�Ƃ��ēn��
	 */
	public void prepareGame(Hand cards)
	{
		System.out.println("�y�J�[�h��z��܂��z");
		
		// �g�����v���V���b�t������
		cards.shuffle();
		
		// �g�����v�̖������擾����
		int numberOfCards = cards.getNumberOfCards();
		
		// �v���C���[�̐l�����擾����
		int numberOfPlayers = players.size();
		
		for (int index = 0; index < numberOfCards; index++)
		{
			// �J�[�h����ꖇ����
			Card card = cards.pickCard(0);
			
			// �e�v���C���[�ɏ��ԂɃJ�[�h��z��
			Player player = (Player)players.get(index % numberOfPlayers);
			player.receiveCard(card);
		}
	}
	
	/**
	 * �Q�[�����J�n����B
	 */
	public void startGame()
	{
		System.out.println("\n�y�����ׂ��J�n���܂��z");
		
		// �v���C���[�̐l�����擾����
		for (int count = 0; players.size() > 1; count++)
		{
			int playerIndex = count % players.size(); 
			int nextPlayerIndex = (count + 1) % players.size();
			
			// �w������v���C���[�̎擾
			Player player = (Player)players.get(playerIndex);
			
			// �v���C���[���w������
			System.out.println("\n" + player + "����̔Ԃł��B");
			player.play(); 
		}
		
		// �v���C���[���オ���Ďc��1���ɂȂ�ƃ��[�v�𔲂���
		System.out.println("�y�����ׂ��I�����܂����z");
	}
	
	/**
	 * �オ���錾����B
	 * 
	 * @param winner �オ�����v���C���[
	 */
	public void declareWin(Player winner)
	{
		// �オ�����v���C���[
		System.out.println("  " + winner + "���񂪏オ��܂����I");
		
		// �オ�����v���C���[�����X�g����͂���
		players.remove(players.indexOf(winner));
		
		// �c��v���C���[���P�l�ɂȂ������͔s�҂�\������
		if (players.size() == 1)
		{
			Player loser = (Player)players.get(0);
			System.out.println("  " + loser + "����̕����ł��I");
		}
	}
	
	/**
	 * �p�X��錾����B
	 * 
	 * @param player �p�X����v���C���[
	 */
	public void pass(Player player)
	{
		// �p�X��\��
		System.out.println("  " + player + "����� " + player.getPass() + " ��ڂ̃p�X���܂����I");
		
		if (player.getPass() > 3)
		{
			// �p�X�񐔂�3��𒴂��Ă���ꍇ�͕����B
			System.out.println("  " + player + "����͕����ł��I");
			players.remove(players.indexOf(player));
			
		}
		
		// �c��v���C���[���P�l�ɂȂ������͔s�҂�\������
		if (players.size() == 1)
		{
			Player loser = (Player)players.get(0);
			System.out.println("  " + loser + "����̕����ł��I");
		}
	}
	
	/**
	 * �Q�[���ɎQ������v���C���[��o�^����B
	 * 
	 * @param player �Q������v���C���[
	 */
	public void registerPlayer(Player player)
	{
		// ���X�g�ɎQ���҂�ǉ�����
		players.add(player);
		
		// �v���C���[�̎Q����\������
		System.out.println(player + "���񂪎Q�����܂��B");
	}
}
