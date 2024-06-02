import javax.swing.*;
import java.awt.*;

public class AddCustomerDialog extends JDialog {

    private JTextField nameField;
    private JTextField ageField;
    private JComboBox<String> computerComboBox;
    private MainFrame mainFrame;

    public AddCustomerDialog(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setTitle("Choose Computer");
        setSize(350, 250);
        setLocationRelativeTo(mainFrame);
        setModal(true);

        JPanel mainPanel = new JPanel();
        JPanel inputPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        GroupLayout mainLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainLayout);

        JLabel nameLabel = new JLabel("Name:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel computerLabel = new JLabel("Computer:");

        nameField = new JTextField(20);
        ageField = new JTextField(20);
        computerComboBox = new JComboBox<>();

        for (int i = 1; i <= 10; i++) {
            computerComboBox.addItem("Computer " + i);
        }

        JButton addButton = new JButton("Rent");
        addButton.addActionListener(e -> addCustomer());

        GroupLayout.SequentialGroup hGroup = mainLayout.createSequentialGroup();
        hGroup.addGap(20);
        hGroup.addGroup(mainLayout.createParallelGroup()
                .addComponent(nameLabel)
                .addComponent(ageLabel)
                .addComponent(computerLabel));
        hGroup.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        hGroup.addGroup(mainLayout.createParallelGroup()
                .addComponent(nameField)
                .addComponent(ageField)
                .addComponent(computerComboBox)
                .addComponent(addButton));
        hGroup.addContainerGap(20, Short.MAX_VALUE);
        mainLayout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = mainLayout.createSequentialGroup();
        vGroup.addContainerGap(20, Short.MAX_VALUE);
        vGroup.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(nameLabel)
                .addComponent(nameField));
        vGroup.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED);
        vGroup.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(ageLabel)
                .addComponent(ageField));
        vGroup.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED);
        vGroup.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE));
        vGroup.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED);
        vGroup.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(computerLabel)
                .addComponent(computerComboBox));
        vGroup.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED);
        vGroup.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(addButton));
        vGroup.addContainerGap(20, Short.MAX_VALUE);
        mainLayout.setVerticalGroup(vGroup);

      
        inputPanel.add(mainPanel);
        buttonPanel.add(addButton);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addCustomer() {
        String name = nameField.getText().trim();
        String ageText = ageField.getText().trim();
        String computer = (String) computerComboBox.getSelectedItem();

        if (name.isEmpty() || ageText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lengkapi Data Dengan Benar");
            return;
        }

        try {
            int age = Integer.parseInt(ageText);
            Customer customer = new Customer(name, age);
            mainFrame.addCustomer(computer, customer);
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Umur harus angka.");
        }
    }
}

