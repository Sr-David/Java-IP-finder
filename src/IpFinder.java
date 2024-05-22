import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IpFinder {

    public static void main(String[] args) {
        IpFinder ipFinder = new IpFinder();
        ipFinder.createUI();
    }

    private void createUI() {
        JFrame frame = new JFrame("IP Finder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Enter the host name:");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Find IP");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String hostName = textField.getText();
                try {
                    InetAddress inetAddress = InetAddress.getByName(hostName);
                    String ip = inetAddress.getHostAddress();
                    JOptionPane.showMessageDialog(frame, "IP Address: " + ip);
                    
                } catch (UnknownHostException ex) {
                    JOptionPane.showMessageDialog(frame, "Unknown host: " + hostName);
                }
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(button);
        frame.setVisible(true);
    }

}
