package control;

import view.BlockDisplay;

public class MoveUpCommand implements Command{
    
    private final BlockDisplay display;
    
    public MoveUpCommand(BlockDisplay display) {
        this.display = display;
    }
    
    @Override
    public void execute() {
        display.show(display.block().moveUp());
    }
    
}