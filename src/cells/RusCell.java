package cells;

public class RusCell implements CellInterface{
    int age = 0;

    @Override
    public CellInterface step(int sumRus, int sumLizard, int sumBaikalWater) {
        if (sumLizard > 5 || age > 6){
            return new EmptyCell();
        }
        age++;
        return this;
    }

}
