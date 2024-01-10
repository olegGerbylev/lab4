import cells.*;
import utils.StringToCoordinate;

public class Field {
    EmptyCell[][] currentField = new EmptyCell[20][20];
    StringToCoordinate utils = new StringToCoordinate();

    String[][] copyCurrentField = new String[20][20];
    public Field(String rusCoordinates, String lizardCoordinates, String baikalWaterCoordinates){
        utils.ArrayFill(rusCoordinates, currentField, "Рус");
        utils.ArrayFill(lizardCoordinates, currentField, "Ящер");
        utils.ArrayFill(baikalWaterCoordinates, currentField, "Вода Байкальская");
        for(int i =0; i < currentField.length; i++){
            for (int j =0; j < currentField[0].length; j++){
                if (currentField[i][j] == null){
                    currentField[i][j] = new EmptyCell(i,j);
                }
            }
        }
        printAndCopyState();
    }

    public void step(){
        for (int i = 0; i < currentField.length; i++){
            for (int j = 0; j < currentField[0].length; j++){
                currentField[i][j] = currentField[i][j].step(copyCurrentField);
            }
        }
        printAndCopyState();
    }

    public void printAndCopyState(){
        for(int i =0; i < this.currentField.length; i++){
            for (int j =0; j < this.currentField[0].length; j++){
                String symbol = switch (currentField[i][j].getClass().getSimpleName()) {
                    case ("Grass"):
                        yield "G";
                    case ("Rabbit"):
                        yield "R";
                    case ("Snake"):
                        yield "S";
                    default:
                        yield "_";
                };
                copyCurrentField[i][j] = symbol;
                System.out.print(" " + symbol);
            }
            System.out.println();
        }
        System.out.println("================================================================");
    }
}
