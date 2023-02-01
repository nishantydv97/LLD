package util;

import model.Board;
import model.Difficulty;
import model.Ladder;
import model.Snake;
import org.apache.commons.lang3.RandomUtils;

import java.util.HashSet;
import java.util.Set;

public class GameUtil {

    public static Board initBoard(Integer boardSize, Difficulty difficulty){

        Board board = new Board(boardSize, difficulty);

        //init snake
        Set<Integer> sneakHeads = new HashSet<Integer>();
        Integer snakeNo = difficulty.getSnake();
        Set<Snake> snakes = new HashSet<Snake>();
        while(snakeNo>=0){
            int snaketail = RandomUtils.nextInt(1, boardSize);
            int snakeHead = RandomUtils.nextInt(snaketail, boardSize);
            if(snakeHead<=snaketail) continue;
            if(!sneakHeads.contains(snaketail) && !sneakHeads.contains(snakeHead)){
                Snake snake = Snake.builder()
                        .start(snakeHead)
                        .end(snaketail)
                        .build();
                snakes.add(snake);
                sneakHeads.add(snakeHead);
                snakeNo--;
            }
        }
        board.setSnakes(snakes);

        //init ladder
        Integer ladderNo = difficulty.getLadder();
        Set<Ladder> ladders = new HashSet<>();
        while(ladderNo>=0){
            int ladderTail = RandomUtils.nextInt(1, boardSize);
            int ladderHead = RandomUtils.nextInt(ladderTail, boardSize);
            if(ladderHead<=ladderTail) continue;
            if(!sneakHeads.contains(ladderHead) && !sneakHeads.contains(ladderTail)){
                Ladder ladder = Ladder.builder()
                        .start(ladderHead)
                        .end(ladderTail)
                        .build();
                ladders.add(ladder);
                sneakHeads.add(ladderHead);
                sneakHeads.add(ladderTail);
                ladderNo--;
            }
        }
        board.setLadders(ladders);

        return board;
    }
}
