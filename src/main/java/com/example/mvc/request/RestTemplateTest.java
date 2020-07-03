package com.example.mvc.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Author by Sun, Date on 2019/2/18.
 * PS: Not easy to write code, please indicate.
 */
public class RestTemplateTest {


    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    static RestTemplate restTemplate;

    public static void main(String[] args) {
        restTemplateDo();
        // httpClientDo();
    }

    private static void httpClientDo() {

    }

    private static void restTemplateDo() {
        // restTemplate.getForEntity("http://GATESERVICE/gate/openGate?gateIP=test", null);
        try {
            restTemplate.execute(new URI("http://192.168.1.142:8080/manager-system/ParkingLot/selectData?page=1&limit=10&parkingLotID=WHJA0"), HttpMethod.GET, null, null);
            // restTemplate.execute();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


    }


}
