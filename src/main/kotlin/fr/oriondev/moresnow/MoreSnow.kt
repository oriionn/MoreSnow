package fr.oriondev.moresnow

import fr.oriondev.moresnow.blocks.ModBlocks
import fr.oriondev.moresnow.effects.ModEffects
import fr.oriondev.moresnow.entities.BlueSnowGolemEntity
import fr.oriondev.moresnow.entities.ModEntities
import fr.oriondev.moresnow.items.ModItems
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import org.slf4j.LoggerFactory

object MoreSnow : ModInitializer {
	const val MOD_ID = "moresnow"
    val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		ModBlocks.register()
		ModItems.register()
		ModEffects.register()
		ModEntities.register()

		FabricDefaultAttributeRegistry.register(ModEntities.BLUE_SNOW_GOLEM, BlueSnowGolemEntity.createAttributes())
	}
}