package me.lego4you.planextention.extention;

import com.djrapitops.plan.capability.CapabilityService;
import com.djrapitops.plan.extension.ExtensionService;

public class PlanHook {

    public void hookIntoPlan() {
        if (!areAllCapabilitiesAvailable()) return;
        registerDataExtension();
        listenForPlanReloads();
    }

    private boolean areAllCapabilitiesAvailable() {
        CapabilityService capabilities = CapabilityService.getInstance();
        return capabilities.hasCapability("DATA_EXTENSION_VALUES");
    }

    private void registerDataExtension() {
        try {
            ExtensionService.getInstance().register(new ProjectKorraDataExtention());
        } catch (IllegalStateException planIsNotEnabled) {
            // Plan is not enabled, handle exception
        } catch (IllegalArgumentException dataExtensionImplementationIsInvalid) {
            // The DataExtension implementation has an implementation error, handle exception
        }
    }

    private void listenForPlanReloads() {
        CapabilityService.getInstance().registerEnableListener(
                isPlanEnabled -> {
                    // Register DataExtension again
                    if (isPlanEnabled) registerDataExtension();
                }
        );
    }

}
