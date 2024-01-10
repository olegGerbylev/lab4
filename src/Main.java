
import utils.StringToCoordinate;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.println("вводите кординаты через пробел(x;y) и через запятую новые кординаты, так же они должны быть в диапозоне от 0 до 20");
        System.out.printf("Кординаты Русов:");
        String RusCoordinates = in.nextLine();
        System.out.printf("Кординаты Ящеров: ");
        String LizardCoordinates = in.nextLine();
        System.out.printf("Кординаты вода Байкальска: ");
        String BaikalWaterCoordinates = in.nextLine();
        in.close();

        int N = 20;
        Field field = new Field(RusCoordinates, LizardCoordinates, BaikalWaterCoordinates);
        for(int i =0; i < 20; i++){
            field.step();
        }
    }
}