package cells;

public class Grass extends EmptyCell{

    public Grass(int x, int y) {
        super(x, y);
        intType = 2;
    }

    @Override
    public EmptyCell step(EmptyCell[][] field){
        getSum(field);
        if (sumOfEntity[2] < sumOfEntity[1]){
            return new EmptyCell(x, y);
        }
        return this;
    }

    @Override
    public String toString() {
        return "G";
    }

}
