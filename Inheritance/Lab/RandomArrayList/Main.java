package InheritanceLab.RandomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList randomArrayList = new RandomArrayList();

        randomArrayList.add(8);
        randomArrayList.add(18);
        randomArrayList.add(28);

        System.out.println(randomArrayList.getRandomElement());
    }
}
