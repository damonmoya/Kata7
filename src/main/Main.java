package main;

import javax.swing.JFrame;

import control.*;
import model.Block;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class Main extends JFrame {

    private Map<String, Command> commands = new HashMap<>();
    private BlockPanel applicationDisplayBlock;
    private int xMousePosition;
    
    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    public Main() throws HeadlessException {
        deployUI();
        addCommands();
    }

    private void addCommands() {
        commands.put("Right",new MoveRightCommand(applicationDisplayBlock));
        commands.put("Left",new MoveLeftCommand(applicationDisplayBlock));
        commands.put("Up",new MoveUpCommand(applicationDisplayBlock));
        commands.put("Down",new MoveDownCommand(applicationDisplayBlock));
    }

    private void deployUI() {
        this.setTitle("Block Shifter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(575,640));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(blockPanel());
        this.add(toolBar(),BorderLayout.SOUTH);
    }

    private BlockPanel blockPanel() {
        BlockPanel panel = new BlockPanel(block());
        panel.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xMousePosition = e.getX();
            }

            
        });
        applicationDisplayBlock = panel;
        return panel;
    }

    private Block block() {
        return new BlockMovement().origin();
    }

    private JMenuBar toolBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        menuBar.add(leftButton());
        menuBar.add(rightButton());
        menuBar.add(upButton());
        menuBar.add(downButton());
        return menuBar;
    }

    private JButton rightButton() {
        JButton rightButton = new JButton(">");
        rightButton.addActionListener(e -> commands.get("Right").execute());
        return rightButton;
    }

    private JButton leftButton() {
        JButton leftButton = new JButton("<");
        leftButton.addActionListener(e -> commands.get("Left").execute());
        return leftButton;
    }
    
    private JButton upButton() {
        JButton upButton = new JButton("Up");
        upButton.addActionListener(e -> commands.get("Up").execute());
        return upButton;
    }
    
    private JButton downButton() {
        JButton downButton = new JButton("Down");
        downButton.addActionListener(e -> commands.get("Down").execute());
        return downButton;
    }
    
}
