package fairyShop.core;

import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private HelperRepository helperRepository;
    private PresentRepository presentRepository;
    private int countCraftedPresents;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
        countCraftedPresents = 0;
    }

    @Override
    public String addHelper(String type, String helperName) {

        Helper helper;

        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }

        helperRepository.add(helper);
        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {

        Instrument instrument = new InstrumentImpl(power);

        Helper existHelper = helperRepository.findByName(helperName);

        if (existHelper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        existHelper.addInstrument(instrument);

        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {

        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);

        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {

        Helper availableHelper = helperRepository.getModels()
                .stream()
                .filter(helper -> helper.getEnergy() > 50)
                .findFirst()
                .orElse(null);

        if (availableHelper == null) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        Present present = presentRepository.findByName(presentName);

        Shop shop = new ShopImpl();
        shop.craft(present, availableHelper);

        long countBrokenInstruments = availableHelper.getInstruments()
                .stream()
                .filter(Instrument::isBroken)
                .count();

// String done = present.isDone() ? "done" : "not done";

        String presentIsReady;

        if (present.isDone()) {
            countCraftedPresents++;
            presentIsReady = "done";
        } else {
            presentIsReady = "not done";
        }

        return String.format(PRESENT_DONE, presentName, presentIsReady)
                + String.format(COUNT_BROKEN_INSTRUMENTS, countBrokenInstruments);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%d presents are done!", countCraftedPresents));
        sb.append(System.lineSeparator());
        sb.append("Helpers info:");
        sb.append(System.lineSeparator());
        sb.append(helperRepository.toString());

        return sb.toString().trim();
    }
}
