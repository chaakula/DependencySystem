import java.util.List;

import com.ds.input.FileInputReader;
import com.ds.input.InputReader;
import com.ds.input.processor.DependencyProcessor;
import com.ds.input.validator.ComandValidator;

public class DependencySystem {

	public static void main(String[] args) {

		InputReader reader = new FileInputReader();
		List<String> commands;
		try {
			commands = reader.readInput();
			commands = ComandValidator.getValidCommands(commands);

			DependencyProcessor processor = new DependencyProcessor();

			processor.processCommands(commands);
		} catch (Exception e) {
			System.out.println("Error while processing the Request. Please contact System admin");
		}

	}

}
