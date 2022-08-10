package glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer {

    private static final double INITIAL_UNIT_ENERGY = 40;

    public GlacierExplorer(String name) {
        super(name, INITIAL_UNIT_ENERGY);
    }
}
