package com.temenos.microservice.test.azure;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /*@FunctionName("hello")
    public HttpResponseMessage hello(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {*/
    public HttpResponseMessage hello(HttpRequestMessage<Optional<String>> req, final ExecutionContext context) {
        //String req = "dummy req";
        System.out.println("Request is " + req);
        System.out.println("Context is " + context);
        context.getLogger().info("Context is avaialble.");
        String myRequest = "abc";

        if (myRequest == null) {
            String badMessage = "Please pass a name on the query string";
            return req.createResponseBuilder(HttpStatus.BAD_REQUEST).body(badMessage).build();
            //return  badMessage;

        } else {
            String okMessage = "Hello, " + myRequest;
            return req.createResponseBuilder(HttpStatus.OK).body(okMessage).build();
            //return okMessage;
        }
    }
}
