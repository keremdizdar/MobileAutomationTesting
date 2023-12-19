package Utilities;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class PageActionsHelper extends DriverManager {
    Dimension size = getAppiumDriver().manage().window().getSize();

    public void performScroll(String direction) {
        if (direction.equalsIgnoreCase("down")) {
            int startX = size.getWidth() / 2;
            int startY = (int) (size.getHeight() * 0.8);
            int endX = startX;
            int endY = (int) (size.getHeight() * 0.1);
            swipeWithCoordinates(startX, startY, endX, endY);
        } else if (direction.equalsIgnoreCase("right")) {
            int startX = (int) (size.getWidth() * 0.9);
            int startY = (int) (size.getHeight() * 0.8);
            int endX = (int) (size.getWidth() * 0.1);
            int endY = startY;
            swipeWithCoordinates(startX, startY, endX, endY);
        } else {
            System.out.println("Invalid direction");
        }
    }

    public void swipeWithCoordinates(int startX, int startY, int endX, int endY) {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 0)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(2)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getAppiumDriver().perform(Collections.singletonList(sequence));
    }

    public void dragAndDrog() {
        String leftCenterRight = "lcr";
        for (int i = 0; i < leftCenterRight.length(); i++) {
            for (int j = 1; j <= leftCenterRight.length(); j++) {
                char letter = leftCenterRight.charAt(i);
                WebElement source = getAppiumDriver().findElement(AppiumBy.accessibilityId("drag-" + letter + j));
                WebElement target = getAppiumDriver().findElement(AppiumBy.accessibilityId("drop-" + letter + j));
                Point sourceElementCenter = new Point(source.getLocation().getX() + source.getSize().getWidth() / 2, source.getLocation().getY() + source.getSize().getHeight() / 2);
                Point targetElementCenter = new Point(target.getLocation().getX() + target.getSize().getWidth() / 2, target.getLocation().getY() + target.getSize().getHeight() / 2);
                PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
                Sequence sequence = new Sequence(finger1, 0)
                        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceElementCenter))
                        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                        .addAction(new Pause(finger1, Duration.ofSeconds(1)))
                        .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), targetElementCenter))
                        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                getAppiumDriver().perform(Collections.singletonList(sequence));
            }
        }
    }
}