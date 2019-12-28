package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.Command;
import control.MoveLeftCommand;
import control.MoveRightCommand;
import model.Block;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class Main extends JFrame {

    private Map<String, Command> commands = new HashMap<>();
    private BlockPanel applicationShowBlock;
    private int xMousePosition;
    
    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    public Main() throws HeadlessException {
        deployUI();
        addCommands();
    }

    private void addCommands() {
        commands.put("Right",new MoveRightCommand(applicationShowBlock));
        commands.put("Prev",new MoveLeftCommand(applicationShowBlock));
    }

    private void deployUI() {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500,500));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(ShowBlock());
        this.add(toolBar(),BorderLayout.SOUTH);
    }

    private BlockPanel showBlock() {
        BlockPanel panel = new BlockPanel(block());
        panel.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xMousePosition = e.getX();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if((xMousePosition - e.getX()) >= 0 ) commands.get("Next").execute();
                else commands.get("Prev").execute();
            }
        });
        applicationDisplayPanel = panel;
        return panel;
    }

    private Block block() {
        return new FileImageReader("C:\\Users\\Asus\\Pictures").read();
    }

    private JMenuBar toolBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        menuBar.add(prevButton());
        menuBar.add(nextButton());
        return menuBar;
    }

    private JButton nextButton() {
        JButton nextButton = new JButton(">");
        nextButton.addActionListener(e -> commands.get("Right").execute());
        return nextButton;
    }

    private JButton prevButton() {
        JButton prevButton = new JButton("<");
        prevButton.addActionListener(e -> commands.get("Left").execute());
        return prevButton;
    }
    
}
