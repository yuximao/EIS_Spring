package com.mercury.EconomicalInsuranceSystem.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercury.EconomicalInsuranceSystem.http.Response;


public class SecurityUtils {
	
	private static final ObjectMapper mapper = new ObjectMapper();

    public static void sendResponse(HttpServletResponse response, int status, String message, Exception exception) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(mapper.writeValueAsString(new Response(exception == null ? true : false, status, message)));
        response.setStatus(status);
        writer.flush();
        writer.close();
    }
	
}
