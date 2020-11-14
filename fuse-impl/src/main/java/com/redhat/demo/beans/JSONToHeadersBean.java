package com.redhat.demo.beans;

import org.apache.camel.Headers;

import java.io.IOException;
import java.util.Map;

//import org.codehaus.jackson.JsonParser;
import com.fasterxml.jackson.core.JsonParser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONToHeadersBean {

    public void jsonToHeaders(String body, @Headers Map<String, String> headers) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        //Map<String, String> map = mapper.readValue(body, Map.class);
        Map<String, String> map = mapper.readValue(body, new TypeReference<Map<String, String>>() {});
        map.keySet().forEach(key -> headers.put(key.toString(), map.get(key).toString()));
    }
}