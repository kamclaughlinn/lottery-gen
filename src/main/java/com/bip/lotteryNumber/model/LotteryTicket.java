package com.bip.lotteryNumber.model;

import java.util.Objects;
import java.util.Set;

public class LotteryTicket {

    private Set<Integer> numbers;
    private int bonusNumber;

    public LotteryTicket(Set<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryTicket that = (LotteryTicket) o;
        return bonusNumber == that.bonusNumber && Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, bonusNumber);
    }
}
