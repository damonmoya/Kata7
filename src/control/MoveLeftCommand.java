package control;

import view.BlockDisplay;

public class MoveLeftCommand implements Command{
    
    private final BlockDisplay display;
    
    public MoveLeftCommand(BlockDisplay display) {
        this.display = display;
    }
    
    @Override
    public void execute() {
        display.show(display.block().moveLeft());
    }
    
}