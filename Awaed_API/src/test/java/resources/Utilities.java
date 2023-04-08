package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Utilities {

    RequestSpecification request;
    public RequestSpecification requestSpecification() throws IOException {

        PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));
   //     RestAssured.baseURI = "https://63fe35bb571200b7b7c75edc.mockapi.io";
        request = new RequestSpecBuilder().setBaseUri(PropertyFileSetUp.GetGlobalValue("baseURL"))
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType("application/json").build();
        return request;
    }
}
