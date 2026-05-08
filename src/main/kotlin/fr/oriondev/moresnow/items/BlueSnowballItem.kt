package fr.oriondev.moresnow.items

import fr.oriondev.moresnow.entities.BlueSnowballEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.projectile.ProjectileEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ProjectileItem
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.stat.Stats
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.util.math.Direction
import net.minecraft.util.math.Position
import net.minecraft.world.World


class BlueSnowballItem(settings: Item.Settings): Item(settings), ProjectileItem {
    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack?>? {
        val itemStack = user.getStackInHand(hand)
        world.playSound(
            null,
            user.x, user.y, user.z,
            SoundEvents.ENTITY_SNOWBALL_THROW,
            SoundCategory.NEUTRAL,
            0.5f,
            0.4f / (world.random.nextFloat() * 0.4f + 0.8f)
        )

        if (!world.isClient) {
            val snowballEntity = BlueSnowballEntity(world, user)
            snowballEntity.setItem(itemStack)
            snowballEntity.setVelocity(user, user.pitch, user.yaw, 0.0F, 1.5F, 1.0F)
            world.spawnEntity(snowballEntity)
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this))
        itemStack.decrementUnlessCreative(1, user)
        return TypedActionResult.success<ItemStack?>(itemStack, world.isClient())
    }

    override fun createEntity(
        world: World,
        pos: Position,
        stack: ItemStack?,
        direction: Direction?
    ): ProjectileEntity {
        val snowballEntity = BlueSnowballEntity(world, pos.x, pos.y, pos.z)
        snowballEntity.setItem(stack)
        return snowballEntity
    }
}