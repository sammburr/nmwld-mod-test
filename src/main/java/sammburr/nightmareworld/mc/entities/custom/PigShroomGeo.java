package sammburr.nightmareworld.mc.entities.custom;

import net.minecraft.util.Identifier;
import sammburr.nightmareworld.mc.NightmareWorldMC;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class PigShroomGeo extends AnimatedGeoModel<PigShroom> {

    @Override
    public Identifier getModelLocation(PigShroom animatable) {
        return new Identifier(NightmareWorldMC.ModID, "geo/pig_shroom.geo.json");
    }

    @Override
    public Identifier getTextureLocation(PigShroom animatable) {
        return new Identifier(NightmareWorldMC.ModID, "textures/item/pig_shroom.png");
    }

    @Override
    public Identifier getAnimationFileLocation(PigShroom animatable) {
        return new Identifier(NightmareWorldMC.ModID, "animations/pig_shroom.animation.json");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void setLivingAnimations(PigShroom entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = getAnimationProcessor().getBone("Head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }

}
