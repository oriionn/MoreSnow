package fr.oriondev.moresnow.entities

import fr.oriondev.moresnow.effects.ModEffects
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.projectile.thrown.SnowballEntity
import net.minecraft.util.hit.EntityHitResult
import net.minecraft.world.World

class BlueSnowballEntity: SnowballEntity {
    constructor(world: World, owner: LivingEntity) : super(world, owner)
    constructor(world: World, x: Double, y: Double, z: Double) : super(world, x, y, z)
    constructor(entityType: EntityType<out SnowballEntity?>, world: World?): super(entityType, world)


    override fun onEntityHit(entityHitResult: EntityHitResult) {
        super.onEntityHit(entityHitResult)

        val entity = entityHitResult.entity
        if (entity is LivingEntity && !entity.isInCreativeMode) {
            val instance = StatusEffectInstance(ModEffects.SNOWY, 20 * 5, 0, false, false, false)
            entity.addStatusEffect(instance)
        }
    }
}