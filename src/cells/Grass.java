package cells;

public class Grass extends EmptyCell{

    public Grass(int x, int y) {
        super(x, y);
    }

    @Override
    public EmptyCell step(String[][] field){
        int[] entitySum = super.getSum(field);
        int snake = entitySum[0];
        int rabbit = entitySum[1];
        int grass = entitySum[2];
        if (grass < rabbit){
            return new EmptyCell(super.getX(), super.getY());
        }
        return this;
    }


}
