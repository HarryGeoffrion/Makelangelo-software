package com.marginallyclever.makelangelo.paper;

import com.marginallyclever.util.PreferencesHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.geom.Rectangle2D;

public class PaperTest {
	@BeforeEach
	public void beforeEach() {
		PreferencesHelper.start();
	}

	@Test
	public void testPaperSettingChanges() {
		Paper a = new Paper();
		a.loadConfig();
		double w = a.getPaperWidth();
		double h = a.getPaperHeight();
		a.setPaperSize(w/2,h/2,0,0);
		a.saveConfig();
		Paper b = new Paper();
		b.loadConfig();
		Assertions.assertEquals(w/2, b.getPaperWidth());
		Assertions.assertEquals(h/2, b.getPaperHeight());
		a.setPaperSize(w,h,0,0);
		a.saveConfig();
		// TODO: this is a potentially destructive change if the test fails.
	}
}
