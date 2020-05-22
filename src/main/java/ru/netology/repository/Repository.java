package ru.netology.repository;

import ru.netology.domain.Offer;
import ru.netology.exception.NotFoundException;

public class Repository {
    private Offer[] offers = new Offer[0];

    public void save(Offer item) {
        int length = offers.length + 1;
        Offer temp[] = new Offer[length];
        System.arraycopy(offers, 0, temp, 0, offers.length);
        int lastIndex = temp.length - 1;
        temp[lastIndex] = item;
        offers = temp;
    }

    public Offer[] getAll() {
        return offers;
    }

    private Number findById (int id) {
        for (Offer offer : offers) {
            if (offer.getId() == id) {
                return id;
            }
        } return null;
    }

    public Offer[] removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id " + id + " not found");
        }
        int length = offers.length - 1;
        Offer[] temp = new Offer[length];
        int index = 0;
        for (Offer offer : offers) {
            if (offer.getId() != id) {
                temp[index] = offer;
                index++;
            }
        }
        offers = temp;
        return offers;
    }
}
