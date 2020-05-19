package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;
import ru.netology.repository.Repository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Repository repository = new Repository();
    private Manager manager = new Manager(repository);
    private Offer tick1 = new Offer(1, 1900, "SVO", "KZN", 95);
    private Offer tick2 = new Offer(2, 2500, "VKO", "KZN", 110);
    private Offer tick3 = new Offer(3, 2400, "VKO", "VKO", 90);
    private Offer tick4 = new Offer(4, 3000, "DME", "KZN", 85);
    private Offer tick5 = new Offer(5, 900, "VKO", "KZN", 140);

    @BeforeEach
    @Test
    public void shouldSave() {
        manager.add(tick1);
        manager.add(tick2);
        manager.add(tick3);
        manager.add(tick4);
        manager.add(tick5);
    }

    @Test
    void shouldGetAll() {
        Offer[] expected = new Offer[]{tick1, tick2, tick3, tick4, tick5};
        Offer[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindBy() {
        Offer[] actual = manager.findByDepartAndArrival("VKO", "KZN");
        Offer[] expected = new Offer[]{tick5, tick2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindBy11111() {
        Offer[] actual = manager.findByDepartAndArrivaAscTime("VKO", "KZN", OfferByPriceAscComparator);
        Offer[] expected = new Offer[]{tick2, tick5};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        Offer[] expected = new Offer[]{tick1, tick3, tick4, tick5};
        assertArrayEquals(expected, repository.removeById(2));
    }
}