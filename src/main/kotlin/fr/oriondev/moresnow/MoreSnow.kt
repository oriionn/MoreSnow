package fr.oriondev.moresnow

import fr.oriondev.moresnow.blocks.ModBlocks
import fr.oriondev.moresnow.items.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object MoreSnow : ModInitializer {
	const val MOD_ID = "moresnow"
    val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		ModBlocks.register()
		ModItems.register()
	}
}