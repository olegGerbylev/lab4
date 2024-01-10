package utils;

import cells.EmptyCell;
import cells.Grass;
import cells.Rabbit;
import cells.Snake;

public class StringToCoordinate {
    public int[][] getCoordinates(String str){
        String[] coordinates = str.split(",");
        int[][] ArrayCoordinate = new int[coordinates.length][2];
        for (int i = 0; i < coordinates.length; i++){
            String[] s = coordinates[i].split(" ");
            ArrayCoordinate[i][0] = Integer.parseInt(s[0]);
            ArrayCoordinate[i][1] = Integer.parseInt(s[1]);
        }
        return ArrayCoordinate;
    }

    public void ArrayFill(String str, EmptyCell[][] array, String type){
        int[][] coordinates = getCoordinates(str);
        for (int[] coordinate: coordinates){
            array[coordinate[0]][coordinate[1]] = switch (type) {
                case ("Рус"):
                    yield new Snake(coordinate[0], coordinate[1]);
                case ("Ящер"):
                    yield new Rabbit(coordinate[0], coordinate[1]);
                case ("Вода Байкальская"):
                    yield new Grass(coordinate[0], coordinate[1]);
                default:
                    yield null;
            };
        }
    }
}
