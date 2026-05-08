package fr.oriondev.moresnow.entities

import fr.oriondev.moresnow.MoreSnow
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModEntities {
    val BLUE_SNOW_GOLEM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(MoreSnow.MOD_ID, "blue_snow_golem"),
        EntityType.Builder.create(::BlueSnowGolemEntity, SpawnGroup.MISC)
            .dimensions(0.7f, 1.9f)
            .build()
    )

    val BLUE_SNOWBALL = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(MoreSnow.MOD_ID, "blue_snowball"),
        EntityType.Builder.create(::BlueSnowballEntity, SpawnGroup.MISC)
            .dimensions(0.25f, 0.25f) // même taille que la snowball vanilla
            .build()
    )

    fun register() {
        MoreSnow.logger.info("Registering entities")
    }
}