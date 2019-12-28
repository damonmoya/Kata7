package main;

import javax.swing.JFrame;

import control.*;
import model.Block;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Main extends JFrame {

    private Map<String, Command> commands = new HashMap<>();
    private BlockPanel applicationDisplayBlock;
    
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
        commands.put("Reset",new ResetPositionCommand(applicationDisplayBlock));
    }

    private void deployUI() {
        this.setTitle("Block Shifter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(575,680));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(blockPanel());
        this.add(resetBar(),BorderLayout.NORTH);
        this.add(toolBar(),BorderLayout.SOUTH);
    }

    private BlockPanel blockPanel() {
        BlockPanel panel = new BlockPanel(block());
        applicationDisplayBlock = panel;
        return panel;
    }

    private Block block() {
        return new BlockMovement().origin();
    }

    private JMenuBar resetBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        menuBar.add(resetButton());
        return menuBar;
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
    
    private JButton resetButton() {
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> commands.get("Reset").execute());
        return resetButton;
    }
    
}
