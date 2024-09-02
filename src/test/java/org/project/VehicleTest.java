package org.project;

import org.project.commonUse.Drama;
import org.project.commonUse.testRunners.DramaExtension;
import org.project.vehicle.VehiclePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DramaExtension.class)
public class VehicleTest {

    @Test
    public void testBrandVisibility() {
        Drama.open("/next-gen/electric-routes/select-vehicle?redirect=%2Fselect-destination");

        VehiclePage vehiclePage = new VehiclePage();


       vehiclePage.isVisibleBrandDD();

       assertTrue(vehiclePage.visibilityBrandField());
    }
}