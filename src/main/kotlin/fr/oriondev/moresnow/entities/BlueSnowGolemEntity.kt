package fr.oriondev.moresnow.entities

import net.minecraft.entity.EntityType
import net.minecraft.entity.ai.goal.LookAtEntityGoal
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.mob.CreeperEntity
import net.minecraft.entity.passive.PassiveEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.world.World

class BlueSnowGolemEntity(entityType: EntityType<out PassiveEntity>, world: World): PassiveEntity(entityType, world) {
    override fun initGoals() {
        this.goalSelector.add(0, LookAtEntityGoal(this, CreeperEntity::class.java, 4.0f))
    }

    companion object {
        fun createAttributes(): DefaultAttributeContainer.Builder {
            return createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1)
        }
    }

    override fun createChild(world: ServerWorld?, entity: PassiveEntity?): PassiveEntity? {

        return ModEntities.BLUE_SNOW_GOLEM.create(world)
    }
}