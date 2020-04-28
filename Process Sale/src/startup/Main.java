package startup;

import controller.Controller;
import integration.CreateSystems;
import integration.Printer;
import view.View;

public class Main {

	public static void main(String[] args) {

		CreateSystems system = new CreateSystems();
		Printer printer = new Printer();
		Controller controller = new Controller(system, printer);
		View view = new View(controller);
		
		//view.hardcodedTestRun();
		view.userTestRun();
		
		
		
	}

}
