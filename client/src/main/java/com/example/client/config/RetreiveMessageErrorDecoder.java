package com.example.client.config;

import com.example.client.exception.AlreadyAvailableException;
import com.example.client.exception.BadRequestException;
import com.example.client.exception.NotAvailableException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class RetreiveMessageErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    private final Map<Integer, Function<String, RuntimeException>> exceptionMappings;

    public RetreiveMessageErrorDecoder() {
        this.exceptionMappings = new HashMap<>();
        exceptionMappings.put(400, responseBody -> new BadRequestException(responseBody));
        exceptionMappings.put(404, responseBody -> new NotAvailableException(responseBody));
        exceptionMappings.put(409, responseBody -> new AlreadyAvailableException(responseBody));
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        var status = response.status();
        if (exceptionMappings.containsKey(status)) {
            return decodeException(methodKey, response, status);
        }

        return errorDecoder.decode(methodKey, response);
    }

    private Exception decodeException(String methodKey, Response response, int status) {
        try {

            InputStream inputStream = response.body().asInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String responseBody = bufferedReader.lines().collect(Collectors.joining("\n"));

            var entry = exceptionMappings.get(response.status());
            return entry.apply(responseBody);


        } catch (IOException e) {
            throw new RuntimeException("Error decoding response", e);
        }
    }
}
