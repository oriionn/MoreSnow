package fr.oriondev.moresnow.entities.client

import fr.oriondev.moresnow.MoreSnow
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.util.Identifier

object BlueSnowGolemModel {
    val BLUE_SNOW_GOLEM = EntityModelLayer(
        Identifier.of(MoreSnow.MOD_ID, "blue_snow_golem"), "main"
    )
}