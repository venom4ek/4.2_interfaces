package ru.netology.manager;

import org.jetbrains.annotations.NotNull;
import ru.netology.domain.Offer;
import ru.netology.repository.Repository;

import java.util.Arrays;
import java.util.Comparator;

public class Manager {
    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Offer offer) {
        repository.save(offer);
    }

    public boolean matches(@NotNull Offer offer, String depart, String arrival) {
        return offer.getDepart().equalsIgnoreCase(depart) && offer.getArrival().equalsIgnoreCase(arrival);
//        if (offer.getDepart().equalsIgnoreCase(depart) && offer.getArrival().equalsIgnoreCase(arrival)) {
//            return true;
//        }
//        return false;
    }

    public Offer[] findByDepartAndArrival(String departure, String arrival) {
        Offer[] result = new Offer[0];
        for (Offer offer : repository.getAll()) {
            if (matches(offer, departure, arrival)) {
                Offer[] temp = new Offer[result.length + 1];
                System.arraycopy(result, 0, temp, 0, result.length);
                temp[temp.length - 1] = offer;
                result = temp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Offer[] findByDepartAndArrivalAscTime(String departure, String arrival, Comparator<Offer> comparator) {
        Offer[] result = new Offer[0];
        for (Offer offer : repository.getAll()) {
            if (matches(offer, departure, arrival)) {
                Offer[] temp = new Offer[result.length + 1];
                System.arraycopy(result, 0, temp, 0, result.length);
                temp[temp.length - 1] = offer;
                result = temp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }


}
