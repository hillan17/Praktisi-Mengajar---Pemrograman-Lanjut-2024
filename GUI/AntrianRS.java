import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class AntrianRS extends JFrame {
    private Queue<String> queue = new LinkedList<>();
    private JTextArea daftarAntrianArea;
    private JTextArea sedangDiprosesArea;
    private JTextArea sudahDiprosesArea;
    private JTextField inputNamaField;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public AntrianRS() {
        setTitle("Sistem Antrian RSUB");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new BorderLayout());

        // Panel Utama
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // Panel Kiri
        JPanel leftPanel = new JPanel(new BorderLayout());
        daftarAntrianArea = new JTextArea(10, 20);
        daftarAntrianArea.setEditable(false);
        leftPanel.add(new JScrollPane(daftarAntrianArea), BorderLayout.CENTER);
        JPanel inputPanel = new JPanel();
        inputNamaField = new JTextField(15);
        JButton addButton = new JButton("Tambah Antrian");
        inputPanel.add(new JLabel("Nama Pasien:"));
        inputPanel.add(inputNamaField);
        inputPanel.add(addButton);
        leftPanel.add(inputPanel, BorderLayout.SOUTH);

        // Panel Kanan
        JPanel rightPanel = new JPanel(new GridLayout(2, 1));

        // Sedang Diproses
        JPanel processingPanel = new JPanel(new BorderLayout());
        sedangDiprosesArea = new JTextArea(5, 20);
        sedangDiprosesArea.setEditable(false);
        processingPanel.add(new JScrollPane(sedangDiprosesArea), BorderLayout.CENTER);
        JButton processButton = new JButton("Proses Antrian");
        processingPanel.add(processButton, BorderLayout.SOUTH);

        // Sudah Diproses
        JPanel donePanel = new JPanel(new BorderLayout());
        sudahDiprosesArea = new JTextArea(5, 20);
        sudahDiprosesArea.setEditable(false);
        donePanel.add(new JScrollPane(sudahDiprosesArea), BorderLayout.CENTER);

        rightPanel.add(processingPanel);
        rightPanel.add(donePanel);

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        add(mainPanel, BorderLayout.CENTER);

        // Event Handlers
        addButton.addActionListener(e -> tambahAntrian());
        processButton.addActionListener(e -> prosesAntrian());

    }

    private void tambahAntrian() {
        String namaPasien = inputNamaField.getText().trim();
        if (namaPasien.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama pasien tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        queue.add(namaPasien);
        updateDaftarAntrian();
        inputNamaField.setText("");
    }

    private void prosesAntrian() {
        if (queue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tidak ada antrian untuk diproses!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String pasienDiproses = queue.poll();
        String waktuDiproses = dateFormat.format(new Date());
        sedangDiprosesArea.setText(pasienDiproses + " sedang diproses pada " + waktuDiproses);
        sudahDiprosesArea.append(pasienDiproses + " selesai diproses pada " + waktuDiproses + "\n");
        updateDaftarAntrian();
        simpanAntrianKeFile(pasienDiproses, waktuDiproses);
    }

    private void updateDaftarAntrian() {
        daftarAntrianArea.setText("");
        int nomorAntrian = 1;
        for (String pasien : queue) {
            daftarAntrianArea.append(nomorAntrian + ". " + pasien + "\n");
            nomorAntrian++;
        }
    }

    private void simpanAntrianKeFile(String pasien, String waktu) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data_antrian.txt", true))) {
            writer.write(pasien + " diproses pada " + waktu + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
