package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

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
}
