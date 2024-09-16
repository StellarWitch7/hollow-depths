package stellarwitch7.hollow_depths.mixin;

import net.minecraft.block.entity.SculkCatalystBlockEntity;
import net.minecraft.block.entity.SculkSpreadManager;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.PositionSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import stellarwitch7.hollow_depths.cca.block.ModBlockComponents;

import java.util.Optional;

@Mixin(SculkCatalystBlockEntity.Listener.class)
public class SculkCatalystBlockEntityListenerMixin {
    @Shadow
    @Final
    SculkSpreadManager spreadManager;

    @Shadow
    @Final
    private PositionSource positionSource;

    @Inject(
            method = "listen",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/entity/SculkSpreadManager;spread(Lnet/minecraft/util/math/BlockPos;I)V"
            )
    )
    private void approachCataclysm(ServerWorld world, RegistryEntry<GameEvent> event, GameEvent.Emitter emitter, Vec3d emitterPos, CallbackInfoReturnable<Boolean> cir) {
        var be = positionSource.getPos(world).flatMap(v -> Optional.ofNullable(world.getBlockEntity(BlockPos.ofFloored(v))));

        be.ifPresent(blockEntity -> {
            if (blockEntity instanceof SculkCatalystBlockEntity catalyst) {
                var cataclysm = ModBlockComponents.INSTANCE.getCataclysm().get(catalyst);

                if (cataclysm.getLocked()) {
                    cataclysm.charge();
                    cir.setReturnValue(true);
                } else {
                    cataclysm.approach();
                }
            }
        });
    }
}
