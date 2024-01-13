package cells;

public class Grass extends EmptyCell{

    public Grass(int x, int y) {
        super(x, y);
    }

    @Override
    public EmptyCell step(EmptyCell[][] field){
        getSum(field);
        if (grass < rabbit){
            return new EmptyCell(x, y);
        }
        return this;
    }

    @Override
    public String toString() {
        return "G";
    }

}
