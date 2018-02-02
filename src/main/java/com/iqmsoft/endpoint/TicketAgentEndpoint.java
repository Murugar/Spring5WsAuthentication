package com.iqmsoft.endpoint;

import java.math.BigInteger;

import javax.xml.bind.JAXBElement;

import com.iqmsoft.ticketagent.ObjectFactory;
import com.iqmsoft.ticketagent.TFlightsResponse;
import com.iqmsoft.ticketagent.TListFlights;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TicketAgentEndpoint {

  @PayloadRoot(namespace = "http://iqmsoft.com/TicketAgent.xsd", localPart = "listFlightsRequest")
  @ResponsePayload
  public JAXBElement<TFlightsResponse> listFlights(
      @RequestPayload JAXBElement<TListFlights> request) {
    ObjectFactory factory = new ObjectFactory();
    TFlightsResponse tFlightsResponse = factory.createTFlightsResponse();
    tFlightsResponse.getFlightNumber().add(BigInteger.valueOf(100));
    tFlightsResponse.getFlightNumber().add(BigInteger.valueOf(1000));
    tFlightsResponse.getFlightNumber().add(BigInteger.valueOf(2000));
    tFlightsResponse.getFlightNumber().add(BigInteger.valueOf(3000));

    return factory.createListFlightsResponse(tFlightsResponse);
  }
}
