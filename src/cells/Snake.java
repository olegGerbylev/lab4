package cells;

public class Snake extends Rabbit{
    public Snake(int x, int y) {
        super(x, y);
    }

    @Override
    public EmptyCell step(String[][] field){
        int[] entitySum = super.getSum(field);
        int snake = entitySum[0];
        int rabbit = entitySum[1];
        int grass = entitySum[2];
        if (snake > 5 || super.getAge() > 6){
            return new EmptyCell(super.getX(), super.getY());
        }
        super.setAge(super.getAge()+1);
        return this;
    }
}
