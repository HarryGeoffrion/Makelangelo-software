package com.marginallyclever.makelangelo.preview;

import static org.junit.jupiter.api.Assertions.*;
import com.marginallyclever.convenience.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CameraTest {

    private Camera camera;

    @BeforeEach
    public void setUp() {
        camera = new Camera();
    }

    @Test
    public void testZoomOut() {
        camera.zoom(-1);
        assertEquals(1.0 + Camera.ZOOM_STEP_SIZE, camera.getZoom());
    }

    @Test
    public void testZoomIn() {
        camera.zoom(1);
        assertEquals(1.0 - Camera.ZOOM_STEP_SIZE, camera.getZoom());
    }

    @Test
    public void testZoomMinAndMax() {
        camera.zoom(Integer.MIN_VALUE);
        assertEquals(Camera.CAMERA_ZOOM_MAX, camera.getZoom()); // should be 0.25

        camera.zoom(Integer.MAX_VALUE);
        assertEquals(Camera.CAMERA_ZOOM_MIN, camera.getZoom()); // should be 1000.0
    }

    @Test
    public void testScreenToWorldSpace() {

        // Equation: output.xy = input.xy/zoom + offsetXY;

        // ARRANGE - create input data
        Point2D input = new Point2D(100, 100);
        // ACT
        Point2D output = camera.screenToWorldSpace(input);
        // ASSERT - position is (100, 100) so equation should be:
        // output.xy = 100.0/1.0 + 0.0;
        assertEquals(input.x, output.x);
        assertEquals(input.y, output.y);


        // ARRANGE - move camera to test offset
        camera.moveRelative(100.0, 100.0);
        // ACT
        output = camera.screenToWorldSpace(input);
        // ASSERT - offset is (100, 100) so equation should be:
        // output.xy = 100.0/1.0 + 100.0;
        assertEquals(input.x + 100.0, output.x);
        assertEquals(input.y + 100.0, output.y);
        

        // ARRANGE - zoom camera to test zoom
        camera.moveRelative(-100.0, -100.0); // reset position
        camera.zoom((int) (-9.0/Camera.ZOOM_STEP_SIZE));
        // ACT
        output = camera.screenToWorldSpace(input);
        // ASSERT - zoom is (1 + 9) = 10 so equation should be:
        // output.xy = 100.0/10.0 + 0.0;
        assertEquals(input.x / 10.0, output.x);
        assertEquals(input.y / 10.0, output.y);



        // ARRANGE - move camera to test offset and zoom simultaneously
        camera.moveRelative(100.0, 100.0);
        // ACT
        output = camera.screenToWorldSpace(input);
        // ASSERT - offset is (100, 100) and zoom is 10 so equation should be:
        // output.xy = 100.0/10.0 + 100.0;
        assertEquals(input.x / 10.0 + 100.0, output.x);
        assertEquals(input.y / 10.0 + 100.0, output.y);
    }

}