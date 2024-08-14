package com.bip.lotteryNumber.controller;

import com.bip.lotteryNumber.model.LotteryTicket;
import com.bip.lotteryNumber.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lottery")
public class LotteryController {

    @Autowired
    private LotteryService lotteryService;

    @GetMapping("/random")
    public LotteryTicket generateRandomTicket() {
        return lotteryService.generateRandomTicket();
    }

    @GetMapping("/name-based")
    public LotteryTicket generateTicketBasedOnName(@RequestParam String playerName) {
        return lotteryService.generateTicketBasedOnName(playerName);
    }
}
