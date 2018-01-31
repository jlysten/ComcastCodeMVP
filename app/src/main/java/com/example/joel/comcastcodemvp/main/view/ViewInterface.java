package com.example.joel.comcastcodemvp.main.view;

import java.util.List;

/**
 * Created by Joel on 1/25/2018.
 */

public interface ViewInterface {
    void navigatetoListFragment(List<String> list, List<String> urls);
    void showError(String message);
}
