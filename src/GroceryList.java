import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<String> groceryList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput;

        do {
            System.out.println("Lütfen yapmak istediğiniz işlemi seçin:");
            System.out.println("0 - Uygulamayı Kapat");
            System.out.println("1 - Eleman Ekle");
            System.out.println("2 - Eleman Sil");
            System.out.println("3 - Eleman Kontrol Et");
            System.out.println("\n");
            userInput = scanner.nextInt();

            switch (userInput) {
                case 0:
                    System.out.println("Uygulama durduruldu.");
                    break;
                case 1:
                    addItems();
                    break;
                case 2:
                    removeItems();
                    printSorted();
                    break;
                case 3:
                    checkItemIsInList();
                    printSorted();
                    break;
                default:
                    System.out.println("Geçersiz giriş. Lütfen 0 ile 2 arasında bir değer girin.");
            }
        } while (userInput != 0);

        scanner.close();
    }

    private static void addItems() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen eklemek istediğiniz elemanları girin:");
        String input = scanner.nextLine();
        String[] addElements = input.split(",\\s*");

        for (String element : addElements) {
            groceryList.add(element);
        }
        Collections.sort(groceryList);
        System.out.println("Alışveriş listesi güncellendi."+groceryList);
    }

    private static void removeItems() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen silmek istediğiniz elemanları girin:");
        System.out.println(groceryList);
        String input = scanner.nextLine();
        String[] removeElements = input.split(",\\s*");

        for (String element : removeElements) {
            if (groceryList.contains(element)) {
                groceryList.remove(element);
                System.out.println(element + " çıkarıldı.");

            } else {
                System.out.println(element + " alışveriş listesinde bulunamadı.");
            }
        }

        Collections.sort(groceryList);
    }

    private static void checkItemIsInList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen kontrol etmek istediğiniz elemanı girin:");
        String item = scanner.nextLine();

        if (groceryList.contains(item)) {
            System.out.println(item + " alışveriş listesinde bulunuyor.");
        } else {
            System.out.println(item + " alışveriş listesinde bulunmuyor.");
        }
    }

    private static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Sıralı alışveriş listesi:");
        for (String item : groceryList) {
            System.out.println("- " + item);
        }
    }
}