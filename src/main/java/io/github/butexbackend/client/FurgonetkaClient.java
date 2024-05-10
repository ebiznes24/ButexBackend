package io.github.butexbackend.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.butexbackend.dto.OrderDTO;
import io.github.butexbackend.dto.furgonetka.FurgonetkaTokenResponseDTO;
import io.micrometer.common.util.StringUtils;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FurgonetkaClient {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Value("${furgonetka.environment-url}")
    private String environmentUrl;

    @Value("${furgonetka.endpoint.package-validate}")
    private String packageValidateUrl;

    @Value("${furgonetka.api-token}")
    private String apiToken;

    public void validateOrderPackage(OrderDTO orderDTO) {
        String apiKey = provideApiKey();
        if(StringUtils.isEmpty(apiKey)){
            return;
        }

        String apiAccessToken = "Bearer " + apiKey;

        RequestBody requestBody = RequestBody.create(body, JSON);
        Request request = new Request.Builder()
                .url(environmentUrl + packageValidateUrl)
                .addHeader("Authorization", apiAccessToken)
                .post(requestBody)
                .build();

        try {
            Response response = new OkHttpClient().newCall(request).execute();
            System.out.println("dupa");
        }catch (Exception ignored){
            return;
        }
    }

    private String provideApiKey() {
        FormBody body = new FormBody.Builder()
                .addEncoded("grant_type", "password")
                .addEncoded("scope", "api")
                .addEncoded("username", "240788@edu.p.lodz.pl")
                .addEncoded("password", "testowehaslo123")
                .build();

        Request request = new Request.Builder()
                .url("https://api.sandbox.furgonetka.pl/oauth/token")
                .addHeader("Authorization", "Basic " + apiToken)
                .post(body)
                .build();

        try {
            Response response = new OkHttpClient().newCall(request).execute();
            return new ObjectMapper().readValue(Objects.requireNonNull(response.body()).string(), FurgonetkaTokenResponseDTO.class).getAccessToken();
        } catch (Exception sa) {
            return null;
        }
    }
}
