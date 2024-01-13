package cells;

public class Snake extends Rabbit{
    public Snake(int x, int y) {
        super(x, y);
    }

    @Override
    public EmptyCell step(EmptyCell[][] field){
        getSum(field);
        if (snake > 5 || age > 6){
            return new EmptyCell(x, y);
        }
        age = age+1;
        return this;
    }

    @Override
    public String toString() {
        return "S";
    }
}
