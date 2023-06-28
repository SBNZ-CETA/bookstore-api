package sbnz.integracija.example.service;

import dtos.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpClientService {
    private static final String API_URL = "http://localhost:8081/api";
    private final RestTemplate restTemplate;

    @Autowired
    public HttpClientService() {
        this.restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    public boolean payWithCard(TransactionDto transactionDto) {
        boolean result;
        try {
            transactionDto.setPayingFromBookstore(true);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            ResponseEntity<Void> response = restTemplate.exchange(API_URL + "/transactions/process",
                    HttpMethod.POST, new HttpEntity<TransactionDto>(transactionDto, headers), Void.class);
            result = response.getStatusCodeValue() == 200;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
}
