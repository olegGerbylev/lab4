package cells;

public class Rabbit extends EmptyCell{

    protected int age = 0;
    public Rabbit(int x, int y) {
        super(x, y);
    }

    @Override
    public EmptyCell step(EmptyCell[][] field){
        getSum(field);
        if (rabbit <= snake || age > 3){
            return new EmptyCell(x, y);
        }
        age++;
        return this;
    }

    @Override
    public String toString() {
        return "R";
    }
}
