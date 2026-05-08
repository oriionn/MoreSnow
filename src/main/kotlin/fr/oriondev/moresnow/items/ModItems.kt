package fr.oriondev.moresnow.items

import fr.oriondev.moresnow.MoreSnow
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModItems {
    val BLUE_SNOWBALL = registerItem("blue_snowball", Item(Item.Settings().maxCount(16)))

    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier.of(MoreSnow.MOD_ID, name), item)
    }

    fun register() {
        MoreSnow.logger.info("Registering items.")

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register {
            it.add(BLUE_SNOWBALL)
        }
    }
}