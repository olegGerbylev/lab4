package cells;

public class LizardCell implements CellInterface {
    int age = 0;

    @Override
    public CellInterface step(int sumRus, int sumLizard, int sumBaikalWater) {
        if (sumLizard+1 <= sumRus || age > 3){
            return new EmptyCell();
        }
        age++;
        return this;
    }

}
