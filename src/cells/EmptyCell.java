package cells;

public class EmptyCell {

    protected int intType = 3;
    protected int x,y;
    protected int[] sumOfEntity;

    public EmptyCell(int x, int y){
        this.x = x;
        this.y = y;
    }

    protected void getSum(EmptyCell[][] field){
        sumOfEntity = new int[4];
        getNeighborValue(field, x-1, y-1);
        getNeighborValue(field, x-1, y);
        getNeighborValue(field, x-1, y+1);
        getNeighborValue(field, x, y-1);
        getNeighborValue(field, x, y+1);
        getNeighborValue(field, x+1, y-1);
        getNeighborValue(field, x+1, y);
        getNeighborValue(field, x+1, y+1);
    }

    public EmptyCell step(EmptyCell[][] field) {
        getSum(field);
        if (sumOfEntity[0] > 2){
            return new Snake(x,y);
        }else if (sumOfEntity[1] >= 2){
            return new Rabbit(x,y);
        }else if (sumOfEntity[2] >= 1){
            return new Grass(x,y);
        }
        return this;
    }

    private void getNeighborValue(EmptyCell[][] field, int neighborRow, int neighborCol) {
        if (neighborRow >= 0 && neighborRow < field.length && neighborCol >= 0 && neighborCol < field[0].length) {
            sumOfEntity[field[neighborRow][neighborCol].intType]++;
        }
    }

    @Override
    public String toString() {
        return "_";
    }

}
