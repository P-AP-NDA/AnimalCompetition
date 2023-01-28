package Animals;

public class Move {

    //Variables
    String moveType;
    String moveName;
    String traitChange = "";

    int traitChangeValue;
    int power;

    //Description: Constructor method for move class
    //@param: String moveType, String moveName, String traitChange, int power, int traitChangeValue
    public Move(String moveType, String moveName, String traitChange, int power, int traitChangeValue) {

        this.moveType = moveType;
        this.traitChange = traitChange;
        this.moveName = moveName;
        this.power = power;
        this.traitChangeValue = traitChangeValue;

    }

    //Below are setter and getter functions that set and return variables relating to the animal moves.
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

    public int getTraitChangeValue() {
        return this.traitChangeValue;
    }
}
