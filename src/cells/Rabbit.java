package cells;

public class Rabbit extends EmptyCell{

    private int age = 0;
    public Rabbit(int x, int y) {
        super(x, y);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public EmptyCell step(String[][] field){
        int[] entitySum = super.getSum(field);
        int snake = entitySum[0];
        int rabbit = entitySum[1];
        int grass = entitySum[2];
        if (rabbit <= snake || age > 3){
            return new EmptyCell(super.getX(), super.getY());
        }
        age++;
        return this;
    }

}
