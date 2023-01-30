package dk.magnusjensen.diversadditions.util;

import dk.magnusjensen.diversadditions.DiversAdditions;
import dk.magnusjensen.diversadditions.util.registry.DiverItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = DiversAdditions.MOD_ID)
public class ServerEvents {
    private static final AttributeModifier FLIPPERS_LAND_SPEED_MODIFIER = new AttributeModifier(UUID.fromString("1175c7b7-e816-40df-a0ba-2466a44b51f5"), "Divers Additions Flippers Land Speed Reduction", -0.2, AttributeModifier.Operation.MULTIPLY_TOTAL);
    private static final AttributeModifier FLIPPERS_SWIM_SPEED_MODIFIER = new AttributeModifier(UUID.fromString("3e70deab-25ae-4a70-8f8a-43919e5ae6fa"), "Divers Additions Flippers Swim Speed Increase", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL);

    @SubscribeEvent
    public static void onPlayerEquipmentChange(LivingEquipmentChangeEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (event.getSlot() != EquipmentSlot.FEET) return;

            AttributeInstance movementSpeed = player.getAttribute(Attributes.MOVEMENT_SPEED);
            AttributeInstance swimSpeed = player.getAttribute(ForgeMod.SWIM_SPEED.get());

            if (event.getFrom().getItem() == DiverItems.FLIPPERS.get()) {
                // Remove the modifiers

                if (movementSpeed == null) return;
                movementSpeed.removeModifier(FLIPPERS_LAND_SPEED_MODIFIER);

                if (swimSpeed == null ) return;
                swimSpeed.removeModifier(FLIPPERS_SWIM_SPEED_MODIFIER);

            } else if (event.getTo().getItem() == DiverItems.FLIPPERS.get()) {
                // Apply the modifiers

                if (movementSpeed == null || movementSpeed.hasModifier(FLIPPERS_LAND_SPEED_MODIFIER)) return;
                movementSpeed.addPermanentModifier(FLIPPERS_LAND_SPEED_MODIFIER);

                if (swimSpeed == null || swimSpeed.hasModifier(FLIPPERS_SWIM_SPEED_MODIFIER)) return;
                swimSpeed.addPermanentModifier(FLIPPERS_SWIM_SPEED_MODIFIER);

            }
        }
    }
}
