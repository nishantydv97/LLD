package model;


import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Data
public class Board {
    private Set<Snake> snakes;
    private Set<Ladder> ladders;
    private final Integer start;
    private final Integer end;
    private final Difficulty difficulty;
    public Board(Integer size, Difficulty difficulty){
        this.difficulty = difficulty;
        this.start = 1;
        this.end = size;
    }
}
