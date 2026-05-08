package fr.oriondev.moresnow.effects

import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory

class SnowyEffect(category: StatusEffectCategory, color: Int): StatusEffect(category, color) {
    override fun applyUpdateEffect(entity: LivingEntity, amplifier: Int): Boolean {
        entity.setInPowderSnow(true)
        return super.applyUpdateEffect(entity, amplifier)
    }

    override fun onEntityRemoval(entity: LivingEntity, amplifier: Int, reason: Entity.RemovalReason) {
        super.onEntityRemoval(entity, amplifier, reason)
        entity.setInPowderSnow(false)
    }

    override fun canApplyUpdateEffect(duration: Int, amplifier: Int): Boolean = true
}