package com.rotsyl.trollsmpplugin;

import java.util.List;

public interface SaveLoad {
    List<String> getSaveData();
    void init(List<String> saveData);
}
