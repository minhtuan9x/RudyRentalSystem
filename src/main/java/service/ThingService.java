package service;

import model.Video;

public interface ThingService {
    void showAllThing();
    void save();
    void findBySerialAndUpdate(Long serial);
}
