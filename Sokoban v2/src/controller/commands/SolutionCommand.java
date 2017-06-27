package controller.commands;

import java.io.IOException;

import model.Model;
import view.View;

public class SolutionCommand extends CommonModelViewCommand{

	public SolutionCommand(Model model,View view){
		this.model = model;
		this.view = view;
	}
	@Override
	public void execute() throws IOException {
		String orders = params.removeFirst();
		String solution = model.requestSolution();
		if(solution != null){
			if(orders.equals("solution"))
				view.displaySolution(solution);
			else if(orders.equals("hint"))
				view.displayHint(solution);
		}
		
	}

}