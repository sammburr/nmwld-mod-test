package sammburr.nightmareworld.mc.blocks;

import java.util.function.ToIntFunction;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.*;
import sammburr.nightmareworld.mc.blocks.custom.StarDustBlock;
import sammburr.nightmareworld.mc.blocks.custom.StarMoss;

public class ModBlocks {

        private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
                return state -> state.get(Properties.LIT) != false ? litLevel : 0;
        }

        public static final Block STAR_DUST_BLOCK = new StarDustBlock(
                        FabricBlockSettings.of(Material.STONE).strength(5.0f, 6.0f).sounds(BlockSoundGroup.STONE)
                                        .requiresTool().ticksRandomly()
                                        .luminance(createLightLevelFromLitBlockState(7)));

        public static final Block STAR_MOSS = new StarMoss(
                        FabricBlockSettings.of(Material.LEAVES).ticksRandomly().noCollision().nonOpaque()
                                        .luminance(createLightLevelFromLitBlockState(9)));

        public static void REG_BLOCK(Block _block, String _mid, String _name, ItemGroup _group) {

                Registry.register(Registry.BLOCK, new Identifier(_mid, _name), _block);
                Registry.register(Registry.ITEM, new Identifier(_mid, _name),
                                new BlockItem(_block, new FabricItemSettings().group(_group)));
        }
}
