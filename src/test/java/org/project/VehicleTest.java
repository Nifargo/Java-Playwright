package org.project;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.project.commonUse.Drama;
import org.project.commonUse.testRunners.DramaExtension;
import org.project.vehicle.VehiclePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DramaExtension.class)
public class VehicleTest {


    @Test
    @DisplayName("Test Brand Visibility")
    @Description("Verify that the brand dropdown is visible on the vehicle page")

    public void testBrandVisibility() {

        Drama.open("/next-gen/electric-routes/select-vehicle?redirect=%2Fselect-destination");

        VehiclePage vehiclePage = new VehiclePage();

        vehiclePage.isVisibleBrandDD();

        assertTrue(vehiclePage.visibilityBrandField());
    }
}