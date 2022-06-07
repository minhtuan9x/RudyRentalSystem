package repository;

import model.BookOnTape;
import model.Video;

import java.util.List;

public interface BookOnTapeRepository {
    List<BookOnTape> getAllBookOnTape();
    void save(BookOnTape bookOnTape);
    BookOnTape findById(Long serial);
}
