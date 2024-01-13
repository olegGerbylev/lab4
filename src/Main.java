

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        int N = 20;
        Field field = new Field();
        field.print();
        for(int i =0; i < N; i++){
            field.step();
            field.print();
        }
    }
}