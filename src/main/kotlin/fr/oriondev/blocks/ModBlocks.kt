package fr.oriondev.blocks

import fr.oriondev.MoreSnows
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModBlocks {
    val BLUE_SNOW_BLOCK = registerBlock(
        "blue_snow_block",
        Block(
            AbstractBlock.Settings.copy(Blocks.SNOW_BLOCK)
        )
    )

    private fun registerBlock(name: String, block: Block): Block {
        registerBlockItem(name, block)
        return Registry.register(
            Registries.BLOCK,
            Identifier.of(MoreSnows.MOD_ID, name),
            block
        )
    }

    private fun registerBlockItem(name: String, block: Block) {
        Registry.register(
            Registries.ITEM,
            Identifier.of(MoreSnows.MOD_ID, name),
            BlockItem(block, Item.Settings())
        )
    }

    fun register() {
        MoreSnows.logger.info("Registering Mod Blocks")

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register {
            it.add(BLUE_SNOW_BLOCK)
        }
    }
}