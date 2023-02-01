import model.*;
import util.ConsolePrint;
import util.GameUtil;
import util.InputUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    public static void main(String[] args) {
        ConsolePrint consolePrint = new ConsolePrint();
        Scanner sc = InputUtil.getScanner();
        consolePrint.print("Enter the Board Size");
        Integer boardSize = sc.nextInt();
        consolePrint.print("Enter the Difficulty \nFor Easy enter EASY \nFor Medium easy MEDIUM \nFor Hard enter HARD");
        String difficultyName = sc.next();
        Difficulty difficulty = Difficulty.valueOf(difficultyName);
        consolePrint.print("Enter the Dice Face Size");
        Integer diceFaceSize = sc.nextInt();
        Dice dice = new Dice(diceFaceSize);
        consolePrint.print("Enter the no of Player");
        Integer playerNo = sc.nextInt();
        Queue<Player> playersQueue = new ArrayDeque<Player>();
        //Board board = new Board(boardSize, difficulty);
        Board board = GameUtil.initBoard(boardSize, difficulty);
        for(int i=0; i<playerNo; i++){
            consolePrint.print("Enter the Player Name one at a time");
            String playerName = sc.next();
            Player player = new Player(playerName, false, 1);
            playersQueue.offer(player);
        }

        while (playersQueue.size()>1){
            Player player = playersQueue.poll();
            Integer diceValue = dice.getRollValue();
            if(player.getCurrentPosition()+diceValue>board.getEnd()){
                playersQueue.add(player);
            } else {
                Integer newPosition = player.getCurrentPosition()+diceValue;
                //snake bite
                Snake snake = board.getSnakes().stream().filter(snake1 -> snake1.getStart()==newPosition).findFirst().orElse(null);
                if(snake!=null){
                    player.setCurrentPosition(snake.getEnd());
                }

                //ladder
                Ladder ladder = board.getLadders().stream().filter(ladder1 -> ladder1.getStart()==newPosition).findFirst().orElse(null);
                if(ladder!=null){
                    player.setCurrentPosition(ladder.getEnd());
                }
                player.setCurrentPosition(newPosition);
                if(player.getCurrentPosition()==boardSize){
                    consolePrint.print(player.getName() + "WON");
                    player.setIsWon(true);
                }else{
                    playersQueue.add(player);
                }

            }
        }



    }
}
