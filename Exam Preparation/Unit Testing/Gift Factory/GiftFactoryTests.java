package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class GiftFactoryTests {

    private GiftFactory giftFactory;
    private Gift gift;

    @Before
    public void setup() {
        giftFactory = new GiftFactory();
        gift = new Gift("Hat", 8);
    }

    @Test
    public void test_CreateGiftAndGetFactoryCount() {
        Assert.assertEquals(0, giftFactory.getCount());

        giftFactory.createGift(gift);

        Assert.assertEquals(1, giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CreateAndAdExistingGiftFailed() {
        giftFactory.createGift(gift);
        giftFactory.createGift(gift);
    }

    @Test(expected = NullPointerException.class)
    public void test_RemoveNullGiftFailed() {
        String gift = null;
        giftFactory.removeGift(gift);
    }

    @Test(expected = NullPointerException.class)
    public void test_RemoveEmptyGiftFailed() {
        String gift = "";
        giftFactory.removeGift(gift);
    }

    @Test
    public void test_RemoveGift() {
        giftFactory.createGift(gift);
        Gift gift2 = new Gift("Shoes", 10);
        giftFactory.createGift(gift2);

        String giftToRemove = gift2.getType();
        giftFactory.removeGift(giftToRemove);

        Assert.assertEquals(1, giftFactory.getCount());
        Assert.assertEquals("Hat", gift.getType());
    }

    @Test
    public void test_GetPresentWithLeastMagic() {
        giftFactory.createGift(gift);
        gift = new Gift("Shoes", 10);
        giftFactory.createGift(gift);

        Gift presentWithLeastMagic = giftFactory.getPresentWithLeastMagic();

        Assert.assertEquals("Hat", presentWithLeastMagic.getType());
    }

    @Test
    public void test_GetPresent() {
        giftFactory.createGift(gift);
        gift = new Gift("Shoes", 10);
        giftFactory.createGift(gift);

        Gift getPresentByName = giftFactory.getPresent("Shoes");

        Assert.assertEquals("Shoes", getPresentByName.getType());
    }

    @Test
    public void test_GetPresents_UnmodifiableList() {
        Collection<Gift> unmodifiableCollection = giftFactory.getPresents();
    }
}
