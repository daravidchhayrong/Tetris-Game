import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;  // Import statement for ActionListener

public abstract class BaseForm extends JFrame {
    protected Font font = new Font("Arial", Font.PLAIN, 30);
    protected GridBagConstraints gbc = new GridBagConstraints();

    public BaseForm() {
        setLayout(new GridBagLayout());
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(13, 40, 13, 40);

        initializeComponents();
        layoutComponents();
        configureFrame();
    }

    protected abstract void initializeComponents();
    protected abstract void layoutComponents();

    protected void addComponent(Component component) {
        add(component, gbc);
    }

    protected JLabel createTextLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    protected JTextField createTextField(short width, short height) {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(width, height));
        textField.setFont(font);
        return textField;
    }

    protected JPasswordField createPasswordField(short width, short height) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(width, height));
        passwordField.setFont(font);
        return passwordField;
    }

    protected JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setPreferredSize(new Dimension(300, 50));
        button.addActionListener(action);
        return button;
    }

    protected JCheckBox createCheckBox(String text, ActionListener action) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(font);
        checkBox.setPreferredSize(new Dimension(300, 50));
        checkBox.addActionListener(action);
        return checkBox;
    }

    private void configureFrame() {
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

