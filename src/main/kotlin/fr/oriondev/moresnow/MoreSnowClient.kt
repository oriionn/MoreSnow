package fr.oriondev.moresnow

import fr.oriondev.moresnow.entities.BlueSnowGolemEntity
import fr.oriondev.moresnow.entities.ModEntities
import fr.oriondev.moresnow.entities.client.BlueSnowGolemModel
import fr.oriondev.moresnow.entities.client.BlueSnowGolemRenderer
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.minecraft.client.render.entity.EntityRenderer
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.client.render.entity.model.SnowGolemEntityModel
import net.minecraft.util.Identifier

class MoreSnowClient : ClientModInitializer {
    override fun onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(BlueSnowGolemModel.BLUE_SNOW_GOLEM) {
            SnowGolemEntityModel.getTexturedModelData()
        }

        EntityRendererRegistry.register(ModEntities.BLUE_SNOW_GOLEM) { context ->
            BlueSnowGolemRenderer(context)
        }
    }
}