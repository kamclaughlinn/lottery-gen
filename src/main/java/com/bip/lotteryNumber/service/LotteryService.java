package com.bip.lotteryNumber.service;

import com.bip.lotteryNumber.exception.InvalidNameException;
import com.bip.lotteryNumber.model.LotteryTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LotteryService {

    @Autowired
    private RandomLotteryGenerator randomLotteryGenerator;

    @Autowired
    private NameBasedLotteryGenerator nameBasedLotteryGenerator;

    public LotteryTicket generateRandomTicket() {
        return randomLotteryGenerator.generateTicket();
    }

    public LotteryTicket generateTicketBasedOnName(String playerName) {
        if (playerName.length() < 2 || playerName.length() > 50) {
            throw new InvalidNameException("Player name must be between 2 and 50 characters");
        }
        return nameBasedLotteryGenerator.generateTicket(playerName);
    }
}
