package sammburr.nightmareworld.mc.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.*;
import sammburr.nightmareworld.mc.entities.ModEntities;

public class ModItems {

    public static final Item STAR_DUST = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final SpawnEggItem PIG_SHROOM_SPAWN_EGG = new SpawnEggItem(ModEntities.PIGSHROOM, 0, 0,
            new FabricItemSettings().group(ItemGroup.MISC));

    public static void REG_ITEM(Item _item, String _mid, String _name) {

        Registry.register(Registry.ITEM, new Identifier(_mid, _name), _item);

    }

}
