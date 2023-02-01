package model;

import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.RandomUtils;


@Getter
public class Dice {
    @Getter
    private static Integer face = 2;
    @Getter
    private static Integer minFaceValue = 1;
    @Getter
    private static Integer maxFaceValue = 2;
    public Dice(Integer face){
        Dice.face = face;
        minFaceValue = 1;
        maxFaceValue = face+1;
    }
    public Integer getRollValue(){
        return RandomUtils.nextInt(minFaceValue, maxFaceValue);
    }
}
