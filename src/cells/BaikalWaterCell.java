package cells;

public class BaikalWaterCell implements CellInterface{

    @Override
    public CellInterface step(int sumRus, int sumLizard, int sumBaikalWater) {
        if (sumBaikalWater+1 < sumLizard){
            return new EmptyCell();
        }
        return this;
    }

}
