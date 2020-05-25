import java.util.List;

import com.ds.input.FileInputReader;
import com.ds.input.InputReader;
import com.ds.input.processor.DependencyProcessor;
import com.ds.input.validator.ComandValidator;

public class DependencySystem {

	public static void main(String[] args) {

		InputReader reader = new FileInputReader();
		List<String> commands = reader.readInput();

		commands = ComandValidator.getValidCommands(commands);

		DependencyProcessor processor = new DependencyProcessor();

		List<String> processedCommands = processor.processCommands(commands);
		/*if (processedCommands != null) {
			for (String command : processedCommands) {
				System.out.println(command);

			}
		}*/

	}

}
