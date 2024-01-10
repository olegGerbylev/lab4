package cells;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class EmptyCell {

    private int x,y;

    public EmptyCell(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    protected int[] getSum(String[][] field){
        int rabbit = 0, grass = 0, snake = 0;
        String[] neighbors = new String[8];
        neighbors[0] = getNeighborValue(field, x-1, y-1);
        neighbors[1] =getNeighborValue(field, x-1, y);
        neighbors[2] =getNeighborValue(field, x-1, y+1);
        neighbors[3] =getNeighborValue(field, x, y-1);
        neighbors[4] =getNeighborValue(field, x, y+1);
        neighbors[5] =getNeighborValue(field, x+1, y-1);
        neighbors[6] =getNeighborValue(field, x+1, y);
        neighbors[7] =getNeighborValue(field, x+1, y+1);
        for (String neighbor: neighbors){
            switch (neighbor){
                case("S"):
                    snake++;
                    break;
                case("G"):
                    grass++;
                    break;
                case("R"):
                    rabbit++;
                    break;
                default:;
            }
        }

        return new int[] {snake, rabbit ,grass};
    }

    public EmptyCell step(String[][] field) {
        int[] entitySum = getSum(field);
        int snake = entitySum[0];
        int rabbit = entitySum[1];
        int grass = entitySum[2];
        if (snake > 2){
            return new Snake(x,y);
        }else if (rabbit >= 2){
            return new Rabbit(x,y);
        }else if (grass >= 1){
            return new Grass(x,y);
        }
        return this;
    }

    private String getNeighborValue(String[][] field, int neighborRow, int neighborCol) {
        if (neighborRow >= 0 && neighborRow < field.length && neighborCol >= 0 && neighborCol < field[0].length) {
            return field[neighborRow][neighborCol];
        }
        return "";
    }

}
