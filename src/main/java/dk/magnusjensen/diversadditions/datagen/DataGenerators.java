package dk.magnusjensen.diversadditions.datagen;


import dk.magnusjensen.diversadditions.DiversAdditions;
import dk.magnusjensen.diversadditions.datagen.client.LanguageProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = DiversAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator data = event.getGenerator();
        if (event.includeClient()) {
            data.addProvider(new LanguageProvider(data, DiversAdditions.MOD_ID, "en_us"));
        }
    }
}
