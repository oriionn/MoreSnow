package fr.oriondev.moresnow.effects

import fr.oriondev.moresnow.MoreSnow
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.util.Identifier

object ModEffects {
    val SNOWY = registerStatusEffect(
        "snowy",
        SnowyEffect(
            StatusEffectCategory.HARMFUL,
            0xfff
        )
    )

    private fun registerStatusEffect(name: String, statusEffect: StatusEffect): RegistryEntry<StatusEffect> {
        return Registry.registerReference(
            Registries.STATUS_EFFECT, Identifier.of(MoreSnow.MOD_ID, name), statusEffect)
    }

    fun register() {
        MoreSnow.logger.info("Registering effects.")
    }
}