package service.impl;

import model.BookOnTape;
import model.Furniture;
import model.Video;
import repository.BookOnTapeRepository;
import repository.FurnitureRepository;
import repository.VideoRepository;
import repository.impl.BookOnTapeImpl;
import repository.impl.FurnitureRepositoryImpl;
import repository.impl.VideoRepositoryImpl;
import service.ThingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ThingServiceImpl implements ThingService {
    private VideoRepository videoRepository = new VideoRepositoryImpl();
    private FurnitureRepository furnitureRepository = new FurnitureRepositoryImpl();
    private BookOnTapeRepository bookOnTapeRepository = new BookOnTapeImpl();

    @Override
    public void showAllThing() {
        List<Furniture> furnitures = furnitureRepository.getAllFurniture();
        List<Video> videos = videoRepository.getAllVideo();
        List<BookOnTape> bookOnTapes = bookOnTapeRepository.getAllBookOnTape();

        System.out.println("List furniture: ");
        furnitures.forEach(Furniture::getDescription);
        System.out.println("List video: ");
        videos.forEach(Video::getDescription);
        System.out.println("List book on tape: ");
        bookOnTapes.forEach(BookOnTape::getDescription);
    }

    @Override
    public void save() {
        System.out.println("==================");
        System.out.println("1. video");
        Video video = new Video();
        video = (Video) input(video);
        videoRepository.save(video);
        System.out.println("saved video!!");
        System.out.println("2. Book");
        Furniture furniture = new Furniture();
        furniture = (Furniture) input(furniture);
        furnitureRepository.save(furniture);
        System.out.println("saved furniture!!");
        System.out.println("3. Furniture");
        BookOnTape bookOnTape = new BookOnTape();
        bookOnTape = (BookOnTape) input(bookOnTape);
        bookOnTapeRepository.save(bookOnTape);
        System.out.println("saved bookOnTape!!");

    }

    @Override
    public void findBySerialAndUpdate(Long serial) {
        Video video = videoRepository.findById(serial);
        if (Objects.nonNull(video)) {
            System.out.println(video);
            System.out.println("===============");
            Video videoUpdate = (Video) input(video);
            videoRepository.save(videoUpdate);
            System.out.println("Updated video !!!");
            return;
        }
        BookOnTape bookOnTape = bookOnTapeRepository.findById(serial);
        if (Objects.nonNull(bookOnTape)) {
            System.out.println(bookOnTape);
            System.out.println("===============");
            BookOnTape bookOnTapeUpdate = (BookOnTape) input(bookOnTape);
            bookOnTapeRepository.save(bookOnTapeUpdate);
            System.out.println("Updated book !!!");
            return;
        }
        Furniture furniture = furnitureRepository.findById(serial);
        if (Objects.nonNull(furniture)) {
            System.out.println(furniture);
            System.out.println("===============");
            Furniture furnitureUpdate = (Furniture) input(furniture);
            furnitureRepository.save(furnitureUpdate);
            System.out.println("Saved Furniture !!!");
            return;
        }
        System.out.println("Not found !!!");
    }

    public Object input(Object o) {
        Scanner scanner = new Scanner(System.in);
        if (o instanceof Video) {
            System.out.println("Nhap ten: ");
            String name = scanner.nextLine();
            System.out.println("Nhap gia thue: ");
            Double rentCost = scanner.nextDouble();
            System.out.println("Nhap do dai video: ");
            Integer length = scanner.nextInt();
            return new Video(((Video) o).getSerialNumber(), name, rentCost, length);
        }
        if (o instanceof Furniture) {
            System.out.println("Nhap ten: ");
            String name = scanner.nextLine();
            System.out.println("Nhap gia thue: ");
            Double rentCost = scanner.nextDouble();
            System.out.println("Nhap noi sx: ");
            scanner.nextLine();
            String madeIn = scanner.nextLine();
            return new Furniture(((Furniture) o).getSerialNumber(), name, rentCost, madeIn);
        }
        if (o instanceof BookOnTape) {
            System.out.println("Nhap ten: ");
            String name = scanner.nextLine();
            System.out.println("Nhap gia thue: ");
            Double rentCost = scanner.nextDouble();
            System.out.println("Nhap the loai: ");
            scanner.nextLine();
            String category = scanner.nextLine();
            return new BookOnTape(((BookOnTape) o).getSerialNumber(), name, rentCost, category);
        }
        return null;
    }
}
