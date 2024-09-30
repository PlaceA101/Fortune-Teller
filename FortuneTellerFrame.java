import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
public class FortuneTellerFrame extends JFrame {
    private int lastIndex = -1;
    private final JTextArea textArea;
    private final ArrayList<String> fortunes;
    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();
        URL imageUrl = getClass().getResource("The-Orb.png");
        ImageIcon imageIcon = new ImageIcon(imageUrl);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel("Fortune Teller", imageIcon, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 36));
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);
        topPanel.add(label);
        add(topPanel, BorderLayout.NORTH);
        textArea = new JTextArea(10, 40);
        textArea.setFont(new Font("Verdana", Font.PLAIN, 24));
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        JButton readButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        readButton.setFont(new Font("Arial", Font.PLAIN, 24));
        quitButton.setFont(new Font("Arial", Font.PLAIN, 24));
        bottomPanel.add(readButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);
        fortunes = new ArrayList<>();
        fortunes.add("A path of death lays in your wake, where you will tread mirrors your past.");
        fortunes.add("Greed is a poor man’s compass, I see gold and riches in your future.");
        fortunes.add("So many souls are weaved into your destiny, but the pattern is burnt, I can’t make out any more.");
        fortunes.add("The weapon you hold, it will be the straw that breaks the camels back.");
        fortunes.add("Your soul shall never rest, death will not cease the pain...");
        fortunes.add("When opposed by the wyrms, silver will not mean second best.");
        fortunes.add("I have not seen darkness burn so brightly before, I fear for all.");
        fortunes.add("Something exciting will happen on Friday.");
        fortunes.add("You will have good luck today.");
        fortunes.add("Blue is your lucky colour.");
        fortunes.add("Someone new will come into your life soon.");
        fortunes.add("You will have a fun adventure.");
        readButton.addActionListener((ActionEvent e) -> readFortune());
        quitButton.addActionListener((ActionEvent e) -> System.exit(0));
    }
    private void readFortune() {
        Random random = new Random();
        int index;
        do {
            index = random.nextInt(fortunes.size());
        } while (index == lastIndex);
        lastIndex = index;
        String fortune = fortunes.get(index);
        textArea.append(fortune + "\n");
    }
}
