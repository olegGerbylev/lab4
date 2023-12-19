import cells.*;
import utils.StringToCoordinate;

public class Field {
    CellInterface[][] currentField = new CellInterface[20][20];
    StringToCoordinate utils = new StringToCoordinate();
    int stepGame, sumRus = 0, sumLizard = 0, sumBaikalWater = 0;;
    String[][] copyCurrentField = new String[20][20];
    public Field(String rusCoordinates, String lizardCoordinates, String baikalWaterCoordinates, int N){
        utils.ArrayFill(rusCoordinates, currentField, "Рус");
        utils.ArrayFill(lizardCoordinates, currentField, "Ящер");
        utils.ArrayFill(baikalWaterCoordinates, currentField, "Вода Байкальская");
        for(int i =0; i < currentField.length; i++){
            for (int j =0; j < currentField[0].length; j++){
                if (currentField[i][j] == null){
                    currentField[i][j] = new EmptyCell();
                }
            }
        }
        stepGame = N;
        printAndCopyState();
        game();
    }

    public void game(){
        while (stepGame > 0) {
            for (int i = 0; i < currentField.length; i++){
                for (int j = 0; j < currentField[0].length; j++){
                    this.sumRus = 0;
                    this.sumLizard = 0;
                    this.sumBaikalWater = 0;
                    getNeighborValue(copyCurrentField, i-1, j-1);
                    getNeighborValue(copyCurrentField, i-1, j);
                    getNeighborValue(copyCurrentField, i-1, j+1);
                    getNeighborValue(copyCurrentField, i, j-1);
                    getNeighborValue(copyCurrentField, i, j+1);
                    getNeighborValue(copyCurrentField, i+1, j-1);
                    getNeighborValue(copyCurrentField, i+1, j);
                    getNeighborValue(copyCurrentField, i+1, j+1);
                    currentField[i][j] = currentField[i][j].step(sumRus,sumLizard,sumBaikalWater);
                }
            }
            stepGame--;
            printAndCopyState();

        }
    }

    public void getNeighborValue(String[][] field, int neighborRow, int neighborCol) {
        if (neighborRow >= 0 && neighborRow < field.length && neighborCol >= 0 && neighborCol < field[0].length) {
            if (field[neighborRow][neighborCol] == "W"){
                sumBaikalWater++;
            }else if (field[neighborRow][neighborCol] == "L"){
                sumLizard++;
            }else if (field[neighborRow][neighborCol] == "R"){
                sumRus++;
            }
        }
    }
    
    public void printAndCopyState(){
        for(int i =0; i < this.currentField.length; i++){
            for (int j =0; j < this.currentField[0].length; j++){
                String symbol = switch (currentField[i][j].getClass().getSimpleName()) {
                    case ("BaikalWaterCell"):
                        yield "W";
                    case ("LizardCell"):
                        yield "L";
                    case ("RusCell"):
                        yield "R";
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
