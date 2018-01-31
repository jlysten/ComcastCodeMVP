package com.example.joel.comcastcodemvp.main.data;

import java.util.List;

/**
 * Created by Joel on 1/25/2018.
 */

public interface Implementor {
    interface onResponse {
        void onSuccess(List<String> list, List<String> urls);
        void onFailure(String message);
    }
    void callAPI(onResponse listener);
}
