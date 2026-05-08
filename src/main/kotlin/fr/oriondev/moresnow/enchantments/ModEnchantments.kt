package fr.oriondev.moresnow.enchantments

import fr.oriondev.moresnow.MoreSnow
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object ModEnchantments {
    val COLD_PROTECTION_KEY = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(MoreSnow.MOD_ID, "cold_protection"))
}