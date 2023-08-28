import javax.swing.*;


public class RockPaperScissorsGame
{  static int ROCK = 0;
    static int PAPER = 1;
    static int SCISSORS= 2;

    public static void main(String[] args) {
        int turns;

        turns = beginGame();

        gamePlay(turns);

    }

    public static int beginGame ()
    {
        int rounds;
        String turns,output="An invalid option has been made please choice a number \ngreater than zero";
        Boolean control = true;

        while (control)
        {
            try {
                turns = JOptionPane.showInputDialog("Please enter the number of rounds you would like to play. The number must be greater than 0  ");
                rounds = Integer.parseInt(turns);
                if(rounds > 0){
                    control =false;
                    return rounds;
                }
            }
            catch (Exception e){

                JOptionPane.showMessageDialog(null,output,"Invalid Option",JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return -1;
    }


    public static void gamePlay(int turns )
    {  String text;
        String resultBoard="" , winner;
        Boolean check1=false, check2=false ;
        int player1Choice =0 , player1WinCount=0;
        int player2Choice =0,player2WinCount=0;
        for (int i=1; i<= turns;i++)
        {

            while (!check1) {

                text = JOptionPane.showInputDialog(null,"Player1 Please choice: 0. Rock, 1. Paper and 2.Scissors ","Round "+i, JOptionPane.INFORMATION_MESSAGE);
                player1Choice = Integer.parseInt(text);
                check1 = IsIntegerInRange(text, ROCK, SCISSORS);

                if(check1 == false)
                {
                    JOptionPane.showMessageDialog(null,"invalid input please try again ","Round "+i,JOptionPane.INFORMATION_MESSAGE);


                }

            }


            while (!check2) {

                text = JOptionPane.showInputDialog(null,"Player2 Please choice: 0. Rock, 1. Paper and 2.Scissors ","Round "+i, JOptionPane.INFORMATION_MESSAGE);
                player2Choice = Integer.parseInt(text);
                check2 = IsIntegerInRange(text, ROCK, SCISSORS);

                if(check2 == false)
                {
                    JOptionPane.showMessageDialog(null,"invalid input please try again ","Round "+i,JOptionPane.INFORMATION_MESSAGE);


                }

            }

            if(player1Choice == player2Choice)
            {
                resultBoard = resultBoard +"\n"+ "Round"+i+" is a draw ";
                JOptionPane.showMessageDialog(null,resultBoard,"Leader Board",JOptionPane.INFORMATION_MESSAGE);
            }else if(player1Choice == 0 && player2Choice == 2)
            {
                resultBoard = resultBoard +"\n"+ "Round"+i+" Player 1 is the winner  ";
                JOptionPane.showMessageDialog(null,resultBoard,"Leader Board",JOptionPane.INFORMATION_MESSAGE);
                player1WinCount++;
            }else if(player1Choice == 1 && player2Choice == 0)
            {
                resultBoard = resultBoard +"\n"+ "Round"+i+" Player 1 is the winner  ";
                JOptionPane.showMessageDialog(null,resultBoard,"Leader Board",JOptionPane.INFORMATION_MESSAGE);
                player1WinCount++;
            }else if(player1Choice == 2 && player2Choice == 1)
            {
                resultBoard = resultBoard +"\n"+ "Round"+i+" Player 1 is the winner  ";
                JOptionPane.showMessageDialog(null,resultBoard,"Leader Board",JOptionPane.INFORMATION_MESSAGE);
                player1WinCount++;
            }else if(player2Choice == 0 && player1Choice == 2)
            {
                resultBoard = resultBoard +"\n"+ "Round"+i+" Player 2 is the winner  ";
                JOptionPane.showMessageDialog(null,resultBoard,"Leader Board",JOptionPane.INFORMATION_MESSAGE);
                player2WinCount++;
            }else if(player2Choice == 1 && player1Choice == 0)
            {
                resultBoard = resultBoard +"\n"+ "Round"+i+" Player 2 is the winner  ";
                JOptionPane.showMessageDialog(null,resultBoard,"Leader Board",JOptionPane.INFORMATION_MESSAGE);
                player2WinCount++;
            }else if(player2Choice == 2 && player1Choice == 1)
            {
                resultBoard = resultBoard +"\n"+ "Round"+i+" Player 2 is the winner  ";
                JOptionPane.showMessageDialog(null,resultBoard,"Leader Board",JOptionPane.INFORMATION_MESSAGE);
                player2WinCount++;
            }

            check2 = false;
            check1 =false;

        }

        if (player1WinCount > player2WinCount)
        {
            winner = "Player 1 has won the game ";
            JOptionPane.showMessageDialog(null,winner,"congratulations",JOptionPane.INFORMATION_MESSAGE);
        }else if (player2WinCount > player1WinCount) {
            winner = "Player 2 has won the game ";
            JOptionPane.showMessageDialog(null,winner,"congratulations",JOptionPane.INFORMATION_MESSAGE);
        } else {

            winner = "It's a draw ";
            JOptionPane.showMessageDialog(null,winner,"congratulations",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public  static Boolean IsIntegerInRange(String text, int minValue, int maxValue){

        try{
            int value = Integer.parseInt(text);

            return value >= minValue && value <= maxValue;

        }catch (Exception e)
        {

            return false;
        }

    }

}
