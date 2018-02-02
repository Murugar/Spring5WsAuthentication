package com.iqmsoft;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.iqmsoft.client.TicketAgentClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringWsApplicationTests {

  @Autowired
  private TicketAgentClient ticketAgentClient;

  @Test
  public void testListFlights() {
    List<BigInteger> flights = ticketAgentClient.listFlights();
    
    assertNotNull(flights);
    assertThat(flights.get(0)).isEqualTo(BigInteger.valueOf(100));
    assertThat(flights.get(1)).isEqualTo(BigInteger.valueOf(1000));
    assertThat(flights.get(2)).isEqualTo(BigInteger.valueOf(2000));
    assertThat(flights.get(3)).isEqualTo(BigInteger.valueOf(3000));
  }
}
