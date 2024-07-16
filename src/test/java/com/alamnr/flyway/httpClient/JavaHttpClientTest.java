package com.alamnr.flyway.httpClient;

import java.io.IOException;
import static java.util.Objects.requireNonNull;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

public class JavaHttpClientTest {
    private MockWebServer mockWebServer;
    private JavaHttpClient cut;

    private static String VALID_RESPONSE;

    static {
        try {
            VALID_RESPONSE = new String(requireNonNull(JavaHttpClientTest.class).getClassLoader()
                                    .getResourceAsStream("stubs/random-quote-success.json")
                                    .readAllBytes());
        } catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @BeforeEach
    void init(){
        this.mockWebServer = new MockWebServer();
        this.cut = new JavaHttpClient(mockWebServer.url("/").toString());
    }

    @Test
    void shouldReturnDefaultQuoteOnFailure(){
        mockWebServer.enqueue(new MockResponse()
                        .addHeader("Content-Type","application/json; charset=utf-8")
                        .setResponseCode(500));  

        String result = cut.getRandomQuote();
        System.out.println(result);

        assertEquals("Lorem ipsum dolor sit amet.", result);  
    }

    @Test
    void shouldReturnRandomQuoteOnSuccessfulResponse(){
        mockWebServer.enqueue(new MockResponse()
                        .addHeader("Content-Type", "application/json; charset=utf-8")
                        .setBody(VALID_RESPONSE)
                        .setResponseCode(200));  
        String result = cut.getRandomQuote();
        System.out.println(result);
        assertEquals("Vision without action is daydream. Action without vision is nightmare..", result);
    }
}
