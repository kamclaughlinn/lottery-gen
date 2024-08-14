package com.bip.lotteryNumber;

import com.bip.lotteryNumber.model.LotteryTicket;
import com.bip.lotteryNumber.service.NameBasedLotteryGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NameBasedLotteryGeneratorTest {
    private NameBasedLotteryGenerator generator = new NameBasedLotteryGenerator();

    @Test
    public void testGenerateTicket() {
        LotteryTicket ticket = generator.generateTicket("John Doe");
        assertNotNull(ticket);
        assertEquals(4, ticket.getNumbers().size());
        assertTrue(ticket.getBonusNumber() >= 5 && ticket.getBonusNumber() <= 86);
    }

    @Test
    public void testGenerateTicketSameName() {
        LotteryTicket ticket1 = generator.generateTicket("John Doe");
        LotteryTicket ticket2 = generator.generateTicket("John Doe");
        assertEquals(ticket1, ticket2);
    }
}
