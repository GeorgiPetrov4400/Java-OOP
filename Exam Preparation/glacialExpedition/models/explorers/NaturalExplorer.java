package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {

    private static final double INITIAL_UNIT_ENERGY = 60;
    private static final double EXPLORER_WORK_ENERGY = 7;

    public NaturalExplorer(String name) {
        super(name, INITIAL_UNIT_ENERGY);
    }

    @Override
    public void search() {
        setEnergy(Math.max(0, getEnergy() - EXPLORER_WORK_ENERGY));
//        setEnergy(getEnergy() - EXPLORER_WORK_ENERGY);
//        if (getEnergy() < 0) {
//            setEnergy(0);
//        }
    }
}
