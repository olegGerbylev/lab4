package cells;

public class EmptyCell implements CellInterface {


    @Override
    public CellInterface step(int sumRus, int sumLizard, int sumBaikalWater) {
        if (sumRus > 2){
            return new RusCell();
        }else if (sumLizard >= 2){
            return new LizardCell();
        }else if (sumBaikalWater >= 1){
            return new BaikalWaterCell();
        }
        return this;
    }

}
