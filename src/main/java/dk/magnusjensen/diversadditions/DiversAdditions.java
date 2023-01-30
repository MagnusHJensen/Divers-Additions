package dk.magnusjensen.diversadditions;

import com.mojang.logging.LogUtils;
import dk.magnusjensen.diversadditions.util.registry.DiverItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("diversadditions")
public class DiversAdditions {

    public static final String MOD_ID = "diversadditions";
    public static final CreativeModeTab DIVERS_TAB = new CreativeModeTab(MOD_ID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(DiverItems.FLIPPERS.get());
        }
    };
    private static final Logger LOGGER = LogUtils.getLogger();

    public DiversAdditions() {
        DiverItems.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }



}
