package fr.oriondev.moresnow.effects

import fr.oriondev.moresnow.enchantments.ModEnchantments
import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory
import net.minecraft.registry.RegistryKeys

class SnowyEffect(category: StatusEffectCategory, color: Int): StatusEffect(category, color) {
    override fun applyUpdateEffect(entity: LivingEntity, amplifier: Int): Boolean {
        val registry = entity.world.registryManager.get(RegistryKeys.ENCHANTMENT)
        val enchantment = registry.getEntry(ModEnchantments.COLD_PROTECTION_KEY)

        if (enchantment.isPresent) {
            if (EnchantmentHelper.getEquipmentLevel(enchantment.get(), entity) > 0) {
                entity.setInPowderSnow(false)
                return super.applyUpdateEffect(entity, amplifier)
            }
        }

        entity.setInPowderSnow(true)
        entity.frozenTicks = entity.minFreezeDamageTicks
        return super.applyUpdateEffect(entity, amplifier)
    }

    override fun onEntityRemoval(entity: LivingEntity, amplifier: Int, reason: Entity.RemovalReason) {
        super.onEntityRemoval(entity, amplifier, reason)
        entity.setInPowderSnow(false)
    }

    override fun canApplyUpdateEffect(duration: Int, amplifier: Int): Boolean = true
}