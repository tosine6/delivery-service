package com.diplomaticdelivery.diplomatic.http;

import okhttp3.*;

import java.io.IOException;

public class HttpService {


    OkHttpClient client = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/json");

    String content = "{\n  \"to\": \"08100991054\",\n  \"message\": \"FIRST TEST\",\n  \"from\": \"victor\",\n  \"normalize\": \"\",\n  \"group\": \"\",\n  \"encoding\": \"\",\n  \"flash\": \"\",\n  \"test\": \"\",\n  \"details\": \"\",\n  \"date\": \"\",\n  \"date_validate\": \"\",\n  \"time_restriction\": \"follow\",\n  \"allow_duplicates\": \"\",\n  \"idx\": \"\",\n  \"check_idx\": \"\",\n  \"max_parts\": \"\",\n  \"fast\": \"\",\n  \"notify_url\": \"\",\n  \"format\": \"json\"\n}";

    public Response post(String data) throws IOException {
        RequestBody body = RequestBody.create(mediaType, content);
        Request request = new Request.Builder()
                .url("https://smsapi-com3.p.rapidapi.com/sms.do?access_token=%3CREQUIRED%3E")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("x-rapidapi-host", "smsapi-com3.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "14c4634755msh3061ecc29a1f900p168f7ajsn91804078af32")
                .build();
        return send(request);
    }

    private Response send(Request request) throws IOException{
        Response response = null;
        try{
            response = client.newCall(request).execute();
            System.out.println("response "+ response);
        }catch (IOException e){
            System.out.println("Message "+ e.getMessage());
        }
        return response;
    }
}
