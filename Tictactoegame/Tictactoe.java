import java.util.Scanner;
import java.util.Random;
public class Tictactoe{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        char[][] board={{' ',' ',' '},
                        {' ',' ',' '},
                        {' ',' ',' '}};
        printBoard(board);
        while(true){
        playerTurn(board,sc);
        if(isGameOver(board)){
            break;
        }
        printBoard(board);
        computerMove(board);
        if(isGameOver(board)){
            break;
        }
        printBoard(board);
    }
    
    //sc.close()
    }
    private static boolean isGameOver(char[][] board){
        if((board[0][0]=='X' && board[0][1]=='X' && board[0][2]=='X')||
            (board[1][0]=='X' && board[1][1]=='X' && board[1][2]=='X')||
            (board[1][0]=='X' && board[1][1]=='X' && board[1][2]=='X')||
            (board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X')||
            (board[0][2]=='X' && board[1][1]=='X' && board[2][0]=='X')||
            (board[0][0]=='x' && board[1][0]=='X' && board[2][0]=='X')||
            (board[0][1]=='X' && board[1][1]=='X' && board[2][1]=='X')||
            (board[0][2]=='X' && board[1][2]=='X' && board[2][2]=='X')){
                System.out.println("you won");
            }else if((board[0][0]=='O' && board[0][1]=='O' && board[0][2]=='O')||
            (board[1][0]=='O' && board[1][1]=='O' && board[1][2]=='O')||
            (board[1][0]=='O' && board[1][1]=='O' && board[1][2]=='O')||
            (board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O')||
            (board[0][2]=='O' && board[1][1]=='O' && board[2][0]=='O')||
            (board[0][0]=='O' && board[1][0]=='O' && board[2][0]=='O')||
            (board[0][1]=='O' && board[1][1]=='O' && board[2][1]=='O')||
            (board[0][2]=='O' && board[1][2]=='O' && board[2][2]=='O')){
                System.out.println("computer won");
            }
        else{for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length;j++){
                    if(board[i][j]==' '){
                        return false;
                    }
                }
            }
        printBoard(board);
        System.out.println("it's a tie");}
        return true;
    }
    private static void computerMove(char[][] board){
        Random rand=new Random();
        int computerTurn;
        while(true){
        computerTurn=rand.nextInt(9)+1;
        if(isSpaceAvailable(board,computerTurn)){
            break;
        }
        }
        System.out.println("computer chose: "+ computerTurn);
        placeMove(board,Integer.toString(computerTurn),'O');
    }

    private static boolean isSpaceAvailable(char[][] board,int position){
        switch(position){
            case 1:
                if(board[0][0]==' ')
                {
                    return true;
                }else{
                    return false;
                }
            case 2:
                if(board[0][1]==' ')
                {
                    return true;
                }else{
                    return false;
                }
            case 3:
                if(board[0][2]==' ')
                {
                    return true;
                }else{
                    return false;
                }
            case 4:
                if(board[1][0]==' ')
                {
                    return true;
                }else{
                    return false;
                }
            case 5:
                if(board[1][1]==' ')
                {
                    return true;
                }else{
                    return false;
                }
            case 6:
                if(board[1][2]==' ')
                {
                    return true;
                }else{
                    return false;
                }
            case 7:
                if(board[2][0]==' ')
                {
                    return true;
                }else{
                    return false;
                }
            case 8:
                if(board[2][1]==' ')
                {
                    return true;
                }else{
                    return false;
                }
            case 9:
                if(board[2][2]==' ')
                {
                    return true;
                }else{
                    return false;
                }
            default:
                return false;
        }
    }

    private static void playerTurn(char[][] board,Scanner sc){
        String userInput;
        while(true){
        System.out.println("where would you like to place(1-9)");
        userInput=sc.nextLine();
        if(isSpaceAvailable(board,Integer.parseInt(userInput))){
            break;
        }else{
            System.out.println(userInput + "is not a valid option");
        }
        }
        placeMove(board,userInput,'X');
        
    }
    private static void placeMove(char[][] board,String position,char symbol){
        switch(position){
            case "1":
                board[0][0]=symbol;
                break;
            case "2":
                board[0][1]=symbol;
                break;
            case "3":
                board[0][2]=symbol;
                break;
            case "4":
                board[1][0]=symbol;
                break;
            case "5":
                board[1][1]=symbol;
                break;
            case "6":
                board[1][2]=symbol;
                break;
            case "7":
                board[2][0]=symbol;
                break;
            case "8":
                board[2][1]=symbol;
                break;
            case "9":
                board[2][2]=symbol;
                break;
            default:
                System.out.println("error :[");
        }

    }

    private static void printBoard(char[][] board){
        System.out.println(board[0][0] + "|"+ board[0][1] +"|"+ board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|"+ board[1][1] +"|"+ board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|"+ board[2][1] +"|"+ board[2][2]);
    }
}