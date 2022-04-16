package sammburr.nightmareworld.mc.entities.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.easing.EasingType;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class PigShroom extends PigEntity implements IAnimatable {

    private final AnimationFactory factory = new AnimationFactory(this);
    private final Integer idleAnimLen = 100;
    private Integer idleAnimTick = 0;
    private boolean isIdleing = false;

    public PigShroom(EntityType<? extends PigEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(
                new AnimationController<>(this, "idle_controller", 0, EasingType.Linear,
                        this::idle_predicate));
        data.addAnimationController(
                new AnimationController<>(this, "walk_controller", 0, EasingType.Linear,
                        this::walk_predicate));
    }

    private <E extends IAnimatable> PlayState idle_predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.pigshroom.shake", true));

        if (random.nextInt(300) == 0) {
            isIdleing = true;
        }

        if (isIdleing) {
            if (idleAnimTick < idleAnimLen) {
                idleAnimTick++;
                return PlayState.CONTINUE;

            }
        }
        idleAnimTick = 0;
        isIdleing = false;

        return PlayState.STOP;

    }

    private <E extends IAnimatable> PlayState walk_predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.pigshroom.walk", true));
        if (event.isMoving()) {
            return PlayState.CONTINUE;
        } else {
            return PlayState.STOP;
        }
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
