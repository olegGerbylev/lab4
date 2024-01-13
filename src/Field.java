import cells.*;


import java.util.Arrays;

public class Field {
    EmptyCell[][] currentField = new EmptyCell[20][20];
    EmptyCell[][] copyCurrentField = new EmptyCell[20][20];

    public Field()  {
//        fillFieldRabbits(new int[]{1,2}, new int[]{1,2}, new int[]{1,2}, new int[]{1,2});
//        fillFieldSnake(new int[]{1,2}, new int[]{1,2}, new int[]{1,2}, new int[]{1,2});
        fillFieldGrass(new int[]{1,2});
        for(int i =0; i < currentField.length; i++){
            for (int j =0; j < currentField[0].length; j++){
                if (currentField[i][j] == null){
                    currentField[i][j] = new EmptyCell(i,j);
                }
            }
        }

    }

    public void step(){
        for(int k = 0; k < 20; k++){
            copyCurrentField[k] = Arrays.copyOf(currentField[k], 20);
        }
        for (int i = 0; i < currentField.length; i++){
            for (int j = 0; j < currentField[0].length; j++){
                currentField[i][j] = currentField[i][j].step(copyCurrentField);
            }
        }
    }

    public void print(){
        for(int i =0; i < this.currentField.length; i++){
            for (int j =0; j < this.currentField[0].length; j++){
               System.out.print(" " + currentField[i][j]);
            }
            System.out.println();
        }
        System.out.println("================================================================");
    }

    private void fillFieldRabbits(int[] ... coordinates)  {
        for(int[] coordinate: coordinates){
            if (coordinate.length != 2){
                return;
            }
            currentField[coordinate[0]][coordinate[1]] = new Rabbit(coordinate[0], coordinate[1]);
        }

    }
    private void fillFieldSnake(int[] ... coordinates)  {
        for(int[] coordinate: coordinates){
            if (coordinate.length != 2){
                return;
            }
            currentField[coordinate[0]][coordinate[1]] = new Snake(coordinate[0], coordinate[1]);
        }

    }
    private void fillFieldGrass(int[] ... coordinates)  {
        for(int[] coordinate: coordinates){
            if (coordinate.length != 2){
                return;
            }
            currentField[coordinate[0]][coordinate[1]] = new Grass(coordinate[0], coordinate[1]);
        }

    }
}
