package com.marginallyclever.makelangelo.preview;

import static org.junit.jupiter.api.Assertions.*;
import com.marginallyclever.convenience.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class CameraTest {

    private Camera camera;

    @BeforeEach
    public void setUp() {
        // ARRANGE - create camera object
        camera = new Camera();
    }

    @Test
    public void testZoomOut() {
        camera.zoom(-1); // ACT
        assertEquals(1.0 + Camera.ZOOM_STEP_SIZE, camera.getZoom()); // ASSERT - expect 1.15
    }

    @Test
    public void testZoomIn() {
        camera.zoom(1); // ACT
        assertEquals(1.0 - Camera.ZOOM_STEP_SIZE, camera.getZoom()); // ASSERT - expect 0.85
    }

    @Test
    public void testZoomMinAndMax() {
        camera.zoom(Integer.MIN_VALUE); // ACT
        assertEquals(Camera.CAMERA_ZOOM_MAX, camera.getZoom()); // ASSERT - expect 1000.0

        camera.zoom(Integer.MAX_VALUE); // ACT
        assertEquals(Camera.CAMERA_ZOOM_MIN, camera.getZoom()); // ASSERT - expect 0.25
    }

    @Test
    public void testMoveRelative() {
        // ARRANGE - set offset
        double initialOffsetX = 20.0;
        double initialOffsetY = 10.0;
        // ACT - move camera
        camera.moveRelative(initialOffsetX, initialOffsetY);
        // ASSERT - expect position to be (20.0, 10.0)
        assertEquals(initialOffsetX, camera.getX());
        assertEquals(initialOffsetY, camera.getY());


        // ARRANGE - set offset
        double secondOffsetX = -10.0;
        double secondOffsetY = -5.0;
        // ACT - move camera
        camera.moveRelative(secondOffsetX, secondOffsetY);
        // ASSERT - expect position to be (10, 5)
        assertEquals(initialOffsetX + secondOffsetX, camera.getX());
        assertEquals(initialOffsetY + secondOffsetY, camera.getY());
    }

    @Test
    public void testScreenToWorldSpace() {

        // Equation: output.xy = input.xy/zoom + offsetXY;

        // ARRANGE - create input data
        Point2D input = new Point2D(100, 100);
        // ACT - convert to world space
        Point2D output = camera.screenToWorldSpace(input);
        // ASSERT - position is (100, 100) so equation should be:
        // output.xy = 100.0/1.0 + 0.0;
        assertEquals(input.x, output.x);
        assertEquals(input.y, output.y);


        // ARRANGE - move camera to test offset
        camera.moveRelative(100.0, 100.0);
        // ACT - convert to world space
        output = camera.screenToWorldSpace(input);
        // ASSERT - offset is (100, 100) so equation should be:
        // output.xy = 100.0/1.0 + 100.0;
        assertEquals(input.x + 100.0, output.x);
        assertEquals(input.y + 100.0, output.y);
        

        // ARRANGE - zoom camera to test zoom
        camera.moveRelative(-100.0, -100.0); // reset position
        camera.zoom((int) (-9.0/Camera.ZOOM_STEP_SIZE));
        // ACT - convert to world space
        output = camera.screenToWorldSpace(input);
        // ASSERT - zoom is (1 + 9) = 10 so equation should be:
        // output.xy = 100.0/10.0 + 0.0;
        assertEquals(input.x / 10.0, output.x);
        assertEquals(input.y / 10.0, output.y);


        // ARRANGE - move camera to test offset and zoom simultaneously
        camera.zoom((int) (9.0/Camera.ZOOM_STEP_SIZE)); // undo zoom
        camera.moveRelative(100.0, 100.0);
        camera.zoom((int) (-9.0/Camera.ZOOM_STEP_SIZE));
        // ACT - convert to world space
        output = camera.screenToWorldSpace(input);
        // ASSERT - offset is (100, 100) and zoom is 10 so equation should be:
        // output.xy = 100.0/10.0 + 100.0;
        assertEquals(input.x / 10.0 + 100.0, output.x);
        assertEquals(input.y / 10.0 + 100.0, output.y);
    }


    @Test
    public void testZoomToFit() {
        // ARRANGE - set initial width and height
        double initialWidth = 1000;
        camera.setWidth(initialWidth);
        double initialHeight = 500;
        camera.setHeight(initialHeight);

        // ACT - call zoomToFit with new dimensions
        double newWidth = 2000;
        double newHeight = 1000;
        camera.zoomToFit(newWidth, newHeight);

        // ASSERT - check if the zoom level is correctly set
        double expectedZoom = Math.max(newWidth / initialHeight, newHeight / initialWidth);
        assertEquals(expectedZoom, camera.getZoom());
    }
}