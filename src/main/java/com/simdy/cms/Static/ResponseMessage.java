package com.simdy.cms.Static;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseMessage {

    public final static String SUCCESS_MESSAGE = "success";

    public final static String ERROR_MESSAGE = "error";

    public final static void DEAL_CROSS_DOMAIN(HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", "*");

    }

}
