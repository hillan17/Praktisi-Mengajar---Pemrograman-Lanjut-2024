import javax.swing.SwingUtilities;

public class Main {
   public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AntrianRS frame = new AntrianRS();
            frame.setVisible(true);
        });
    }
}
