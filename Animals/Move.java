package Animals;

public class Move {

    String moveType;
    String moveName;
    String traitChange = "";

    int traitChangeValue;
    int power;


    public Move(String moveType, String moveName, String traitChange, int power, int traitChangeValue) {

        this.moveType = moveType;
        this.traitChange = traitChange;
        this.moveName = moveName;
        this.power = power;

    }

    public String getMoveType() {

        return this.moveType;
    }
    
    public String getTraitChange() {

        return this.traitChange;
    }

    public String getMoveName() {

        return this.moveName;
    }

    public int getPower() {

        return this.power;
    }


    public void setMoveType(String moveType) {

        this.moveType = moveType;

    }

    public void setTraitChange(String traitChange) {

        this.traitChange = traitChange;
    }

    public void setPower(int power) {

        this.power = power;

    }

    public void setMoveName(String moveName) {
    
        this.moveName = moveName;

    }

    public void setTraitChangeValue(int traitChangeValue) {
        this.traitChangeValue = traitChangeValue;
    }

    public void getTraitChangeValue(int traitChangeValue) {
        this.traitChangeValue = traitChangeValue;
    }
}
