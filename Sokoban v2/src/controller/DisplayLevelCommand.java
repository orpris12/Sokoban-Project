package controller;

import view.LevelDisplayer;

public class DisplayLevelCommand implements Command {

	LevelDisplayer disp;
	
	public DisplayLevelCommand(LevelDisplayer disp) {
		this.disp=disp;
	}
	@Override
	public void execute() {
		disp.display();
		
	}

}
