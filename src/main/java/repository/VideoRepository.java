package repository;

import model.Video;

import java.util.List;

public interface VideoRepository {
    List<Video> getAllVideo();
    void save(Video video);
    Video findById(Long serial);
}
