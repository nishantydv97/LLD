package model;

import lombok.Getter;

public enum Difficulty {
    EASY(3, 3),
    MEDIUM(4, 4),
    HARD(6, 6);
    @Getter
    private final Integer snake;
    @Getter
    private final Integer ladder;
    Difficulty(int snake, int ladder) {
        this.snake = snake;
        this.ladder = ladder;
    }

}
