package com.bip.lotteryNumber.service;

import com.bip.lotteryNumber.model.LotteryTicket;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class RandomLotteryGenerator {

    private Set<LotteryTicket> generatedTickets = new HashSet<>();
    private Random random = new Random();

    public LotteryTicket generateTicket() {
        LotteryTicket ticket;
        do {
            ticket = new LotteryTicket(generateNumbers(5, 1, 69), generateBonusNumber(1, 8));
        } while (generatedTickets.contains(ticket));

        generatedTickets.add(ticket);
        return ticket;
    }

    private Set<Integer> generateNumbers(int count, int min, int max) {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < count) {
            numbers.add(random.nextInt(max - min + 1) + min);
        }
        return numbers;
    }

    private int generateBonusNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
