package fairyShop.models;

public class ShopImpl implements Shop {

    @Override
    public void craft(Present present, Helper helper) {

        for (Instrument helperInstrument : helper.getInstruments()) {
            while (!helperInstrument.isBroken() && !present.isDone()){
                helper.work();
                helperInstrument.use();
                present.getCrafted();

                if (!helper.canWork()) {
                    return;
                }
            }
        }
    }
}
