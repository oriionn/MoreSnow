package fr.oriondev.moresnow.blocks

import fr.oriondev.moresnow.MoreSnow
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.resource.featuretoggle.FeatureFlag
import net.minecraft.util.Identifier

object ModBlocks {
    val BLUE_SNOW_BLOCK = registerBlock(
        "blue_snow_block",
        Block(
            AbstractBlock.Settings.copy(Blocks.SNOW_BLOCK)
        )
    )

    val BLUE_SNOW_GOLEM_CORE = registerBlock(
        "blue_snow_golem_core",
        Block(
            AbstractBlock.Settings.copy(Blocks.SNOW_BLOCK)
        )
    )

    private fun registerBlock(name: String, block: Block): Block {
        registerBlockItem(name, block)
        return Registry.register(
            Registries.BLOCK,
            Identifier.of(MoreSnow.MOD_ID, name),
            block
        )
    }

    private fun registerBlockItem(name: String, block: Block) {
        Registry.register(
            Registries.ITEM,
            Identifier.of(MoreSnow.MOD_ID, name),
            BlockItem(block, Item.Settings())
        )
    }

    fun register() {
        MoreSnow.logger.info("Registering blocks.")

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register {
            it.add(BLUE_SNOW_BLOCK)
        }
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register {
            it.add(BLUE_SNOW_GOLEM_CORE)
        }
    }
}