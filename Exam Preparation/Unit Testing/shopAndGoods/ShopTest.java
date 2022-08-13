package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
    private Shop shop;

    @Before
    public void setup() {
        shop = new Shop();
    }

    @Test
    public void test_ReturnUnmodifiableMap() {
        shop.getShelves();
    }

    @Test
    public void test_AddGoodsSuccess() throws OperationNotSupportedException {
        Goods good1 = new Goods("Cheese", "41");
        Goods good2 = new Goods("Steak", "34");

        Assert.assertEquals("Cheese", good1.getName());
        Assert.assertEquals("Steak", good2.getName());

        Assert.assertEquals("Goods: 41 is placed successfully!", shop.addGoods("Shelves1", good1));
        Assert.assertEquals("Goods: 34 is placed successfully!", shop.addGoods("Shelves2", good2));

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddGoods_NonExistingShelf() throws IllegalArgumentException, OperationNotSupportedException {
        Goods good1 = new Goods("Cheese", "41");

        shop.addGoods("Joro", good1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddGoods_ExistingShelf_NotEmpty() throws IllegalArgumentException, OperationNotSupportedException {
        Goods good1 = new Goods("Cheese", "41");
        Goods good2 = new Goods("Steak", "34");

        shop.addGoods("Shelves1", good1);
        shop.addGoods("Shelves1", good2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_AddGoods_ItemExist() throws OperationNotSupportedException {
        Goods good1 = new Goods("Cheese", "41");

        shop.addGoods("Shelves1", good1);
        shop.addGoods("Shelves2", good1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveGoodFromNonExistingShelf() throws OperationNotSupportedException {
        Goods good1 = new Goods("Cheese", "41");
        Goods good2 = new Goods("Steak", "34");

        shop.addGoods("Shelves1", good1);
        shop.addGoods("Shelves2", good2);

        shop.removeGoods("Kaspichan", good1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveNonExistingGood() throws OperationNotSupportedException {
        Goods good1 = new Goods("Cheese", "41");
        Goods good2 = new Goods("Steak", "34");

        shop.addGoods("Shelves1", good1);
        shop.addGoods("Shelves2", good2);

        shop.removeGoods("Shelves2", good1);
    }

    @Test
    public void test_RemoveGoodSuccess() throws OperationNotSupportedException {
        Goods good1 = new Goods("Cheese", "41");
        Goods good2 = new Goods("Steak", "34");

        shop.addGoods("Shelves1", good1);
        shop.addGoods("Shelves2", good2);

        Assert.assertEquals("Goods: 34 is removed successfully!", shop.removeGoods("Shelves2", good2));
        Assert.assertNull(shop.getShelves().get("Shelves2"));
    }
}