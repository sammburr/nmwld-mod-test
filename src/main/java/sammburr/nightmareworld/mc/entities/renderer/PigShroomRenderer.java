package sammburr.nightmareworld.mc.entities.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import sammburr.nightmareworld.mc.entities.custom.PigShroom;
import sammburr.nightmareworld.mc.entities.custom.PigShroomGeo;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PigShroomRenderer extends GeoEntityRenderer<PigShroom> {

    public PigShroomRenderer(Context ctx) {
        super(ctx, new PigShroomGeo());

    }

}
