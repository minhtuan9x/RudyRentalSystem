package view;

import service.ThingService;
import service.impl.ThingServiceImpl;

import java.util.Scanner;

public class RudyRentalSystem {
    private ThingService thingService = new ThingServiceImpl();

    public void ui() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=======================");
            System.out.println("1. Nhap thong tin");
            System.out.println("2. In thong tin");
            System.out.println("3. Find and update by serial");
            System.out.println("4. Exit!!!");
            System.out.println("====Moi chon menu====");
            int chon = scanner.nextInt();
            switch (chon) {
                case 1:
                    thingService.save();
                    break;
                case 2:
                    thingService.showAllThing();
                    break;
                case 3:
                    System.out.println("Nhap serial: ");
                    Long serial = scanner.nextLong();
                    thingService.findBySerialAndUpdate(serial);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Moi ban chon lai!!");
            }
        }
    }
}
