package service;

import model.Video;
import repository.VideoRepository;

import java.util.List;

public class VideoService {
    private VideoRepository videoRepository = new VideoRepository();

    public List<Video> getAllVideo(){
        videoRepository.getAllVideo().forEach(item-> System.out.println(item.toString()));
        return videoRepository.getAllVideo();
    }
}
