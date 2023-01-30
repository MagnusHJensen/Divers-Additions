package dk.magnusjensen.diversadditions.datagen.client;

import dk.magnusjensen.diversadditions.util.registry.DiverItems;
import net.minecraft.data.DataGenerator;

public class LanguageProvider extends net.minecraftforge.common.data.LanguageProvider {
    public LanguageProvider(DataGenerator gen, String modid, String locale) {
        super(gen, modid, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.diversadditions", "Diver's Additions");

        this.add(DiverItems.FLIPPERS.get(), "Flippers");
        this.add(DiverItems.WEIGHTED_VEST.get(), "Weighted Vest");
    }
}
