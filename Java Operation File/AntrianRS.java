import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class AntrianRS {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    //Inisialisasi objek Queue
    Queue<String> queue = new LinkedList<String>();

    //Input nama pasien (tidak boleh kosong)
    try {
      System.out.println("==================== SELAMAT DATANG DI RSUB ====================");
      System.out.print("Masukkan nama pasien (Ketikkan 'Stop' untuk berhenti): ");
      String pasien = input.nextLine();
      
      while (!pasien.equalsIgnoreCase("stop")) {
        if (pasien.trim().isEmpty()) {
          throw new IllegalArgumentException("Nama pasien tidak boleh kosong!");
        } else {
          queue.add(pasien);
          System.out.print("Masukkan nama pasien (Ketikkan 'Stop' untuk berhenti): ");
          pasien = input.nextLine();
        }
      }

      // Mendapatkan tanggal saat ini
      String currentDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());

      // Menambahkan daftar pasien ke file
      try (FileWriter writer = new FileWriter("data_antrian.txt");
           BufferedWriter buffer = new BufferedWriter(writer)) {

        buffer.write("========== DAFTAR PASIEN ==========\n");
        int queueNum = 1;
        for(String pasienList : queue) {
          buffer.write(queueNum + ". " + pasienList + " - " + currentDate + "\n");
          queueNum++;
        }

        buffer.write("\n========== RAWAT PASIEN ==========\n");
        int serveNum = 1;
        while (!queue.isEmpty()) {
          String servePasien = queue.poll();
          buffer.write(serveNum + ". " + servePasien + " sedang dirawat pada tanggal " + currentDate + "\n");
          serveNum++;
        }

        if (queue.isEmpty()) {
          buffer.write("\n----- PASIEN DALAM ANTRIAN SUDAH DIRAWAT -----\n");
        }

        System.out.println("\nData antrian pasien telah disimpan ke dalam file 'data_antrian.txt'.");
      } catch (IOException e) {
        System.out.println("Terjadi kesalahan saat menyimpan data antrian ke file: " + e.getMessage());
        e.printStackTrace();
      }

    //Exception handling
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      System.out.println("Sistem ditutup.");
    } finally {
      input.close();
    }
  }
}