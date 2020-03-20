package com.atfcm.airportlogistics.common.Myexception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class MyNullException extends NullPointerException {
        public MyNullException(){
            super();
        }

}
