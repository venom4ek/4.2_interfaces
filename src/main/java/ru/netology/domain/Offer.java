package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Offer implements Comparable<Offer> {
    private int id;
    private int price;
    private String depart;
    private String arrival;
    private int timeFlight;

    @Override
    public int compareTo(@NotNull Offer o) {
        return price - o.price;
    }

    public class OfferByPriceAscComparator implements Comparator<Offer> {

        @Override
        public int compare(Offer o1, Offer o2) {
            return o1.timeFlight - o2.timeFlight;
        }
    }




    @Override
    public int hashCode() {
        return Objects.hash(id, price, depart, arrival, timeFlight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return id == offer.id &&
                price == offer.price &&
                timeFlight == offer.timeFlight &&
                depart.equals(offer.depart) &&
                arrival.equals(offer.arrival);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", price=" + price +
                ", depart='" + depart + '\'' +
                ", arrival='" + arrival + '\'' +
                ", timeFlight=" + timeFlight +
                '}';
    }
}
