import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class MainFrame extends JFrame {

    private DefaultListModel<String> computerListModel;
    private JList<String> computerList;
    private Map<String, Customer> customerMap;

    public MainFrame() {
        setTitle("Sistem Antrian Warnet");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        computerListModel = new DefaultListModel<>();
        computerList = new JList<>(computerListModel);
        customerMap = new HashMap<>();

        for (int i = 1; i <= 10; i++) {
            computerListModel.addElement("Computer " + i);
        }

        JButton addCustomerButton = new JButton("Add Customer");
        addCustomerButton.addActionListener(e -> new AddCustomerDialog(this).setVisible(true));

        JButton viewComputersButton = new JButton("View Computers");
        viewComputersButton.addActionListener(e -> viewComputers());

        JButton removeCustomerButton = new JButton("Remove Customer");
        removeCustomerButton.addActionListener(e -> removeCustomer());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(computerList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addCustomerButton);
        buttonPanel.add(viewComputersButton);
        buttonPanel.add(removeCustomerButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        loadQueueData();
    }

    private void viewComputers() {
        int selectedIndex = computerList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedComputer = computerListModel.get(selectedIndex);
            Customer customer = customerMap.get(selectedComputer);
            if (customer != null) {
                JOptionPane.showMessageDialog(this, "Computer sedang digunakan oleh: " + customer.getName());
            } else {
                JOptionPane.showMessageDialog(this, "Computer tersedia.");
            }
        }
    }

    private void removeCustomer() {
        int selectedIndex = computerList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedComputer = computerListModel.get(selectedIndex);
            Customer customer = customerMap.get(selectedComputer);
            if (customer != null) {
                JOptionPane.showMessageDialog(this, "Computer sedang digunakan oleh: " + customer.getName());
            } else {
                int index = computerListModel.indexOf(selectedComputer);
                computerListModel.set(index, selectedComputer + " (Kosong)");
                customerMap.remove(selectedComputer); 
                saveQueueData(); 
                JOptionPane.showMessageDialog(this, "Customer berhasil dihapus");
            }
        }
    }
    

    public void addCustomer(String computer, Customer customer) {
        if (customerMap.containsKey(computer)) {
            JOptionPane.showMessageDialog(this, "Computer sedang digunakan!");
        } else {
            customerMap.put(computer, customer);
            int index = computerListModel.indexOf(computer);
            computerListModel.set(index, computer + " (Digunakan)");
            saveQueueData();
        }
    }

    private void loadQueueData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Antrian.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String computer = parts[0];
                    String name = parts[1];
                    String age = parts[2];
                    String laptopNumber = parts[3];
                    customerMap.put(computer, new Customer(name, Integer.parseInt(age), laptopNumber));
                    int index = computerListModel.indexOf(computer);
                    if (index != -1) {
                        computerListModel.set(index, computer + " (Digunakan)");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveQueueData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Antrian.txt"))) {
            for (Map.Entry<String, Customer> entry : customerMap.entrySet()) {
                String computer = entry.getKey();
                Customer customer = entry.getValue();
                writer.write(computer + "," + customer.getName() + "," + customer.getAge() + "," + customer.getLaptopNumber() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


