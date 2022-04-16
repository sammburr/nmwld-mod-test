package sammburr.nightmareworld.mc.entities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import sammburr.nightmareworld.mc.NightmareWorldMC;
import sammburr.nightmareworld.mc.entities.custom.PigShroom;

public class ModEntities {

    public static final EntityType<PigShroom> PIGSHROOM = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(NightmareWorldMC.ModID, "pig_shroom"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PigShroom::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());

    public static void REG_PIGSHROOM() {

        FabricDefaultAttributeRegistry.register(PIGSHROOM,
                PigShroom.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                        .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0));

    }

}
