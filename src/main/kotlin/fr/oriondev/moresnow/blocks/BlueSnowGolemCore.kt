package fr.oriondev.moresnow.blocks

import fr.oriondev.moresnow.entities.ModEntities
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.SpawnReason
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class BlueSnowGolemCore(settings: AbstractBlock.Settings): Block(settings) {
    override fun onPlaced(
        world: World,
        pos0: BlockPos,
        state: BlockState?,
        placer: LivingEntity?,
        itemStack: ItemStack?
    ) {
        super.onPlaced(world, pos0, state, placer, itemStack)

        if (world.isClient) return
        val pos1 = pos0.down()
        val pos2 = pos1.down()

        val block1 = world.getBlockState(pos1)
        val block2 = world.getBlockState(pos2)

        if (block1.isOf(ModBlocks.BLUE_SNOW_BLOCK) && block2.isOf(ModBlocks.BLUE_SNOW_BLOCK)) {
            world.setBlockState(pos0, Blocks.AIR.defaultState, 3)
            world.setBlockState(pos1, Blocks.AIR.defaultState, 3)
            world.setBlockState(pos2, Blocks.AIR.defaultState, 3)

            val golem = ModEntities.BLUE_SNOW_GOLEM.create(world) ?: return
            golem.refreshPositionAndAngles(
                pos2.x + 0.5,
                pos2.y.toDouble(),
                pos2.z + 0.5,
                0f, 0f
            )

            world.spawnEntity(golem)
        }
    }
}