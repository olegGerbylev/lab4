import cells.*;


import java.util.Arrays;

public class Field {
    EmptyCell[][] currentField = new EmptyCell[22][22];
    EmptyCell[][] copyCurrentField = new EmptyCell[22][22];

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
        for(int k = 0; k < 22; k++){
            copyCurrentField[k] = Arrays.copyOf(currentField[k], 22);
        }
        for (int i = 1; i < currentField.length-1; i++){
            for (int j = 1; j < currentField[0].length-1; j++){
                currentField[i][j] = currentField[i][j].step(copyCurrentField);
            }
        }
    }

    public void print(){
        for(int i =1; i < this.currentField.length - 1; i++){
            for (int j =1; j < this.currentField[0].length - 1; j++){
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
            currentField[coordinate[0]+1][coordinate[1]+1] = new Rabbit(coordinate[0]+1, coordinate[1]+1);
        }

    }
    private void fillFieldSnake(int[] ... coordinates)  {
        for(int[] coordinate: coordinates){
            if (coordinate.length != 2){
                return;
            }
            currentField[coordinate[0]+1][coordinate[1]+1] = new Snake(coordinate[0]+1, coordinate[1]+1);
        }

    }
    private void fillFieldGrass(int[] ... coordinates)  {
        for(int[] coordinate: coordinates){
            if (coordinate.length != 2){
                return;
            }
            currentField[coordinate[0]+1][coordinate[1]+1] = new Grass(coordinate[0]+1, coordinate[1]+1);
        }
    }
}
