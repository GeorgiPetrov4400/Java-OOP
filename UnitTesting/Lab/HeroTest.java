package rpg_lab;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.WeakHashMap;

import static org.junit.Assert.*;

public class HeroTest {

    private static final int TARGET_XP = 10;

    @Test
    public void test_HeroGetExperienceWhenTargetDiesWithMockito() {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);

        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);


        Hero hero = new Hero("Joro", weaponMock);

        hero.attack(targetMock);

        assertEquals(TARGET_XP, hero.getExperience());
    }

    @Test
    public void test_HeroGetExperienceWhenTargetDies() {

        // Dummy dummy = new Dummy(5, 10);
        Target target = new Target() {
            @Override
            public int getHealth() {
                return 10;
            }

            @Override
            public void takeAttack(int attackPoints) {
            }

            @Override
            public int giveExperience() {
                return 10;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };

        // Axe axe = new Axe(10, 10);
        Weapon weapon = new Weapon() {
            @Override
            public int getAttackPoints() {
                return 10;
            }

            @Override
            public int getDurabilityPoints() {
                return 10;
            }

            @Override
            public void attack(Target target) {
            }
        };

        Hero hero = new Hero("Joro", weapon);

        hero.attack(target);

        assertEquals(10, hero.getExperience());
    }

    @Test
    public void test_HeroGetName() {
        Weapon weapon = new Weapon() {
            @Override
            public int getAttackPoints() {
                return 0;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }

            @Override
            public void attack(Target target) {
            }
        };

        Hero hero = new Hero("Joro", weapon);

        assertEquals("Joro", hero.getName());
    }

}