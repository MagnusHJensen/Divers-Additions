package dk.magnusjensen.diversadditions.mixin;


import dk.magnusjensen.diversadditions.util.registry.DiverItems;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity implements net.minecraftforge.common.extensions.IForgePlayer {

    @Shadow public abstract ItemStack getItemBySlot(EquipmentSlot pSlot);

    @Shadow @Final private Inventory inventory;

    protected PlayerMixin(EntityType<? extends LivingEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    @Override
    public int getMaxAirSupply() {
        if (hasFlippersOn()) {
            return 350;
        }
        return 300;
    }

    @Override
    protected void goDownInWater() { // This is only called when holding shift.
        if (hasWeightedVestOn()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, (double)-0.08F * this.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).getValue(), 0.0D));
            return;
        }
        super.goDownInWater();
    }

    @Override
    protected void jumpInLiquid(TagKey<Fluid> pFluidTag) {
        if (hasWeightedVestOn()) {
            return;
        }
        super.jumpInLiquid(pFluidTag);
    }

    private boolean hasFlippersOn() {
        return this.inventory != null && this.getItemBySlot(EquipmentSlot.FEET).getItem() == DiverItems.FLIPPERS.get();
    }

    private boolean hasWeightedVestOn() {
        return this.inventory != null && this.getItemBySlot(EquipmentSlot.CHEST).getItem() == DiverItems.WEIGHTED_VEST.get();
    }

}
