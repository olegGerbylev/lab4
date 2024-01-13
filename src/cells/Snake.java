package cells;

public class Snake extends Rabbit{
    public Snake(int x, int y) {
        super(x, y);
        intType = 0;
    }

    @Override
    public EmptyCell step(EmptyCell[][] field){
        getSum(field);
        if (sumOfEntity[0] > 5 || age > 6){
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
