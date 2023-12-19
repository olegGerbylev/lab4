package utils;

import cells.CellInterface;
import cells.BaikalWaterCell;
import cells.LizardCell;
import cells.RusCell;

public class StringToCoordinate {
    public int[][] getCoordinates(String str){
        String[] coordinates = str.split(",");
        int[][] ArrayCoordinate = new int[coordinates.length][2];
        for (int i = 0; i < coordinates.length; i++){
            coordinates[i].split(" ");
            String[] s = coordinates[i].split(" ");
            ArrayCoordinate[i][0] = Integer.parseInt(s[0]);
            ArrayCoordinate[i][1] = Integer.parseInt(s[1]);
        }
        return ArrayCoordinate;
    }

    public void ArrayFill(String str, CellInterface[][] array, String type){
        int[][] coordinates = getCoordinates(str);
        for (int[] coordinate: coordinates){
            array[coordinate[0]][coordinate[1]] = switch (type) {
                case ("Рус"):
                    yield new RusCell();
                case ("Ящер"):
                    yield new LizardCell();
                case ("Вода Байкальская"):
                    yield new BaikalWaterCell();
                default:
                    yield null;
            };
        }
    }
}
