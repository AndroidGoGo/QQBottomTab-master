package com.converter;

import com.lzq.modle.BaseResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by lzq on 2017/6/22.
 */

public class StringResponseBodyConverter implements Converter<ResponseBody, BaseResponse<String>> {
    @Override
    public BaseResponse<String> convert(ResponseBody value) throws IOException {
        String str = value.string();
        BaseResponse<String> response = null;
        try {
            JSONObject json = new JSONObject(str);
            response =  BaseResponse.getInstance();
            response.setError_code(json.optInt("code"));
//            response.setValue(json.optString("value"));
//            response.setMessage(json.optString("message"));
            response.setData(json.optString("data"));
            response.setReturnStatus(true);
            response.setError(json.optString("data"));

            response.setSubjects(json.optString("subjects"));

        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            value.close();
        }
        return response;
    }
}
