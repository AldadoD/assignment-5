package com.aldado.factory;

import com.aldado.domain.ResponseObj;

public class ResponseObjFactory {
    public static ResponseObj buildGenericResponseObj(String responseCode, String responseDescription) {
        return new ResponseObj(responseCode, responseDescription);
    }
}
