package com.bip.lotteryNumber.service;

import com.bip.lotteryNumber.model.LotteryTicket;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class NameBasedLotteryGenerator {

    public LotteryTicket generateTicket(String playerName) {
        Set<Integer> numbers = generateNumbersFromName(playerName, 4, 5, 45);
        int bonusNumber = generateBonusNumberFromName(playerName, 5, 86);
        return new LotteryTicket(numbers, bonusNumber);
    }

    private Set<Integer> generateNumbersFromName(String name, int count, int min, int max) {
        Set<Integer> numbers = new HashSet<>();
        char[] chars = name.toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum += c;
        }

        while (numbers.size() < count) {
            numbers.add(min + (sum % (max - min + 1)));
            sum = sum / 2 + 7;
        }
        return numbers;
    }

    private int generateBonusNumberFromName(String name, int min, int max) {
        int sum = name.chars().sum();
        return min + (sum % (max - min + 1));
    }
}
