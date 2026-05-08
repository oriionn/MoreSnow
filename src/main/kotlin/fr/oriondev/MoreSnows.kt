package fr.oriondev

import fr.oriondev.blocks.ModBlocks
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object MoreSnows : ModInitializer {
	const val MOD_ID = "moresnows"
    val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		logger.info("Hello Fabric world!")
		ModBlocks.register()
	}
}