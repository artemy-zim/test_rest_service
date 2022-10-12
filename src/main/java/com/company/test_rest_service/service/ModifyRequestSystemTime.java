package com.company.test_rest_service.service;

import com.company.test_rest_service.model.Request;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ModifyRequestSystemTime implements ModifyRequestService{
    @Override
    public void modifyRq(Request request) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        request.setSystemTime(df.format(new Date()));

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost:8082/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });
    }
}
