package cells;

public class EmptyCell {

    protected int x,y;
    protected int snake = 0, rabbit = 0, grass = 0;

    public EmptyCell(int x, int y){
        this.x = x;
        this.y = y;
    }

    protected void getSum(EmptyCell[][] field){
        snake = 0;
        rabbit = 0;
        grass = 0;
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
        if (snake > 2){
            return new Snake(x,y);
        }else if (rabbit >= 2){
            return new Rabbit(x,y);
        }else if (grass >= 1){
            return new Grass(x,y);
        }
        return this;
    }

    private void getNeighborValue(EmptyCell[][] field, int neighborRow, int neighborCol) {
        if (neighborRow >= 0 && neighborRow < field.length && neighborCol >= 0 && neighborCol < field[0].length) {
            String type = field[neighborRow][neighborCol].toString();
            if (type == "_"){
                return;
            }else if(type == "G"){
                grass++;
            } else if (type == "R") {
                rabbit++;
            } else if (type == "S") {
                snake++;
            }
        }
    }

    @Override
    public String toString() {
        return "_";
    }

}
