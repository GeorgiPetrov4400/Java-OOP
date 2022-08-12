package fairyShop.repositories;

import fairyShop.models.BaseHelper;
import fairyShop.models.Helper;

import java.util.*;

public class HelperRepository implements Repository<Helper> {

    private Map<String, Helper> helpers;

    public HelperRepository() {
        this.helpers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(helpers.values());
    }

    @Override
    public void add(Helper model) {
        helpers.put(model.getName(), model);
    }

    @Override
    public boolean remove(Helper model) {
        return helpers.remove(model.getName()) != null;

//        String existingHelper = String.valueOf(helpers.get(model.getName()));
//        if (existingHelper.equals(model.getName())) {
//            helpers.remove(existingHelper);
//            return true;
//        }
//        return false;
    }

    @Override
    public Helper findByName(String name) {
        if (helpers.containsKey(name)) {
            return helpers.get(name);
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        helpers.values().stream().forEach(helper -> builder.append(helper).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}
