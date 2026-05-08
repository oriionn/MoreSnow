package fr.oriondev.moresnow.mixins;

import fr.oriondev.moresnow.MoreSnow;
import fr.oriondev.moresnow.effects.ModEffects;
import fr.oriondev.moresnow.enchantments.ModEnchantments;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.block.PowderSnowBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PowderSnowBlock.class)
public abstract class ColdProtection {
    @Inject(method = "canWalkOnPowderSnow", at= @At("HEAD"), cancellable = true)
    private static void coldProtection(Entity entity, CallbackInfoReturnable<Boolean> ci) {
        if (entity instanceof LivingEntity livingEntity) {
            var registry = livingEntity.getWorld().getRegistryManager().get(RegistryKeys.ENCHANTMENT);
            var enchantmentEntry = registry.getEntry(ModEnchantments.INSTANCE.getCOLD_PROTECTION_KEY());

            if (enchantmentEntry.isPresent()) {
                if (EnchantmentHelper.getEquipmentLevel(enchantmentEntry.get(), livingEntity) > 0) {
                    ci.setReturnValue(true);
                }
            }
        }
    }
}
