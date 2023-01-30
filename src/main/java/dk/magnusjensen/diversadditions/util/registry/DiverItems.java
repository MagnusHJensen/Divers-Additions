package dk.magnusjensen.diversadditions.util.registry;

import dk.magnusjensen.diversadditions.DiversAdditions;
import dk.magnusjensen.diversadditions.item.FlippersItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DiverItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DiversAdditions.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    public static final RegistryObject<Item> FLIPPERS = ITEMS.register("flippers", () -> new FlippersItem(ArmorMaterials.LEATHER, EquipmentSlot.FEET, new Item.Properties().defaultDurability(59).tab(DiversAdditions.DIVERS_TAB)));
    public static final RegistryObject<Item> WEIGHTED_VEST = ITEMS.register("weighted_vest", () -> new ArmorItem(ArmorMaterials.IRON, EquipmentSlot.CHEST, new Item.Properties().defaultDurability(131).tab(DiversAdditions.DIVERS_TAB)));
}
