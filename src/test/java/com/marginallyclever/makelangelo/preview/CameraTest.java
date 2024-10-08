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
        camera.zoom(-999999999999999);
        assertEquals(Camera.CAMERA_ZOOM_MAX, camera.getZoom()); // should be 0.25

        camera.zoom(9999999999999999);
        assertEquals(Camera.CAMERA_ZOOM_MIN, camera.getZoom()); // should be 1000.0
    }
}