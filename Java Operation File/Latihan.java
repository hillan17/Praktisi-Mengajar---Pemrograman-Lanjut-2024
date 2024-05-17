import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

public class Latihan {
  public static void main(String[] args) {

    //Menampilkan isi teks
     /* int kar;
     try {
       FileInputStream file1 = new FileInputStream("C:\\Users\\WINDOWS 11\\Documents\\teks.txt");
       FileOutputStream fileout = new FileOutputStream("teks.txt");
       while ((kar = file1.read()) != -1) {
         fileout.write(kar);
         System.out.print((char) kar);
       }
       fileout.close();
       file1.close();
     } catch (Exception e) {
       System.out.println("File Tidak Ada");
     }
     System.out.println(""); */


     //Membaca isi teks
    try {
       File input = new File("C:\\Users\\WINDOWS 11\\Documents\\Latihan.Java\\Semester 2\\Java Operation File\\teks.txt");
       System.out.println(input.getCanonicalPath());
       FileReader reader = new FileReader(input);
       BufferedReader buff = new BufferedReader(reader);
       String out = buff.readLine();
       while (out != null) {
         System.out.println(out);
         out = buff.readLine();
       }
       buff.close();
       reader.close();
     } catch (Exception e) {
       System.out.println("File Tidak Ada");
     }
  }
}
