package sammburr.nightmareworld.mc;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemGroup;
import sammburr.nightmareworld.mc.blocks.ModBlocks;
import sammburr.nightmareworld.mc.entities.ModEntities;
import sammburr.nightmareworld.mc.items.ModItems;
import software.bernie.geckolib3.GeckoLib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NightmareWorldMC implements ModInitializer {

	public static String ModID = "nmwld";
	public static final Logger LOGGER = LoggerFactory.getLogger("nmwld");

	@Override
	public void onInitialize() {

		LOGGER.info("NightmareWorldMC : NightmareWorldMC Started");
		GeckoLib.initialize();
		LOGGER.info("NightmareWorldMC : GeckoLib Started");

		// Identifier must only be lower case and _ otherwise crash
		ModItems.REG_ITEM(ModItems.STAR_DUST, ModID, "star_dust");
		ModItems.REG_ITEM(ModItems.PIG_SHROOM_SPAWN_EGG, ModID, "pig_shroom_spawn_egg");

		ModBlocks.REG_BLOCK(ModBlocks.STAR_DUST_BLOCK, ModID, "star_dust_block", ItemGroup.DECORATIONS);
		ModBlocks.REG_BLOCK(ModBlocks.STAR_MOSS, ModID, "star_moss", ItemGroup.DECORATIONS);

		ModEntities.REG_PIGSHROOM();

	}
}
