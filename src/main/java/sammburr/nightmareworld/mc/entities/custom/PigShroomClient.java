package sammburr.nightmareworld.mc.entities.custom;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import sammburr.nightmareworld.mc.entities.ModEntities;
import sammburr.nightmareworld.mc.entities.renderer.PigShroomRenderer;

@Environment(EnvType.CLIENT)
public class PigShroomClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.PIGSHROOM, PigShroomRenderer::new);

    }

}
