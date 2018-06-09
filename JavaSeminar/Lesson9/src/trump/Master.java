package trump;

import java.util.ArrayList;

/**
 * �i�s����\���N���X�B
 */
public class Master
{
    /** �v���C���[�̃��X�g */
    private ArrayList players_ = new ArrayList();
    
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
        int numberOfPlayers = players_.size();
        
        for (int index = 0; index < numberOfCards; index++)
        {
            // �J�[�h����ꖇ����
            Card card = cards.pickCard(0);
            
            // �e�v���C���[�ɏ��ԂɃJ�[�h��z��
            Player player = (Player)players_.get(index % numberOfPlayers);
            player.receiveCard(card);
        }
    }
    
    /**
     * �Q�[�����J�n����B
     */
    public void startGame()
    {
        System.out.println("\n�y�Q�[�����J�n���܂��z");
        
        // �v���C���[�̐l�����擾����
        for (int count = 0; players_.size() > 1; count++)
        {
            int playerIndex = count % players_.size(); 
            int nextPlayerIndex = (count + 1) % players_.size();
            
            // �w������v���C���[�̎擾
            Player player = (Player)players_.get(playerIndex);
            
            // ���̃v���C���[�̎擾
            Player nextPlayer = (Player)players_.get(nextPlayerIndex);
                        
            // �v���C���[���w������
            System.out.println("\n" + player + "����̔Ԃł��B");
            player.play(nextPlayer); 
        }
        
        // �v���C���[���オ���Ďc��1���ɂȂ�ƃ��[�v�𔲂���
        System.out.println("�y�Q�[�����I�����܂����z");
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
        deregisterPlayer(winner);
        
    }
    
    /**
     * �Q�[���ɎQ������v���C���[��o�^����B
     * 
     * @param player �Q������v���C���[
     */
    public void registerPlayer(Player player)
    {
        // ���X�g�ɎQ���҂�ǉ�����
        players_.add(player);
    }
    
    /**
     * �Q�[���ɎQ������v���C���[��o�^����폜����B
     * �������v���C���[���Q�[�����甲���Ƃ��Ɏg�p����B
     * 
     * @param player �폜����v���C���[
     */
    public void deregisterPlayer(Player player)
    {
        // ���X�g�ɎQ���҂�ǉ�����
        players_.remove(players_.indexOf(player));
        
        // �c��v���C���[���P�l�ɂȂ������͔s�҂�\������
        if (players_.size() == 1)
        {
            Player loser = (Player)players_.get(0);
            System.out.println("  " + loser + "����̕����ł��I");
        }
    }
}
