package activities;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

import java.util.Arrays;

public class ActionsBase {
	
	//create the pointer
	private static final PointerInput pointer = new PointerInput(PointerInput.Kind.TOUCH,"fingure");
	
	//create the action
	public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {
		
		//Create the sequence of actions
		Sequence swipe = new Sequence(pointer, 1).
				addAction(pointer.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY())).
				addAction(pointer.createPointerDown(LEFT.asArg())).
				addAction(pointer.createPointerMove(ofMillis(duration), viewport(), end.getX(), end.getY())).
				addAction(pointer.createPointerUp(LEFT.asArg()));
		
		
		//perform the actions
		driver.perform(Arrays.asList(swipe));
	}
	

}


