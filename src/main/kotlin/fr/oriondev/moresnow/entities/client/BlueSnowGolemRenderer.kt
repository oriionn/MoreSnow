package fr.oriondev.moresnow.entities.client

import fr.oriondev.moresnow.MoreSnow
import fr.oriondev.moresnow.entities.BlueSnowGolemEntity
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.entity.model.SnowGolemEntityModel
import net.minecraft.util.Identifier

class BlueSnowGolemRenderer(context: EntityRendererFactory.Context)
    : MobEntityRenderer<BlueSnowGolemEntity, SnowGolemEntityModel<BlueSnowGolemEntity>>(
    context,
    SnowGolemEntityModel(context.getPart(BlueSnowGolemModel.BLUE_SNOW_GOLEM)),
    0.5f
) {
    override fun getTexture(entity: BlueSnowGolemEntity): Identifier {
        return Identifier.of(MoreSnow.MOD_ID, "textures/entity/blue_snow_golem.png")
    }
}