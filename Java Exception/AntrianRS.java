import java.util.*;

public class AntrianRS {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    Queue<String> queue = new LinkedList<String>();

    try {
    System.out.println("==================== SELAMAT DATANG DI RSUB ====================");
    System.out.print("Masukkan nama pasien (Ketikkan 'Stop' untuk berhenti): ");
    String pasien = input.nextLine();
    
    while (!pasien.equalsIgnoreCase("stop")) {
      if (pasien.trim().isEmpty()) {
        throw new IllegalArgumentException("Nama pasien tidak boleh kosong!");
      }
      queue.add(pasien);
      System.out.print("Masukkan nama pasien (Ketikkan 'Stop' untuk berhenti): ");
      pasien = input.nextLine();
    }

    System.out.println("\n========== DAFTAR PASIEN ==========");
    int queueNum = 1;
    for(String pasienList : queue) {
      System.out.println(queueNum + ". " + pasienList);
      queueNum++;
    }

    System.out.println("\n========== RAWAT PASIEN ==========");
    int serveNum = 1;
    while (!queue.isEmpty()) {
      String servePasien = queue.poll();
      System.out.println(serveNum + ". " + servePasien + " sedang dirawat.");
      serveNum++;
    }
  
      if (queue.isEmpty()) {
        System.out.println("\n----- PASIEN DALAM ANTRIAN SUDAH DIRAWAT -----");
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      System.out.println("SIstem ditutup.");
    }
  } 
}