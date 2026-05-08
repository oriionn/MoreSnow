package fr.oriondev.moresnow.mixins;

import fr.oriondev.moresnow.entities.BlueSnowGolemEntity;
import fr.oriondev.moresnow.entities.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CreeperEntity.class)
public abstract class CreeperBlueSnowGolem extends MobEntity {
    protected CreeperBlueSnowGolem(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initGoals", at = @At("TAIL"))
    private void modifyGoals(CallbackInfo ci) {
        this.goalSelector.add(1, new ActiveTargetGoal<>(
                (CreeperEntity) (Object) this,
                BlueSnowGolemEntity.class,
                true
        ));


    }
}