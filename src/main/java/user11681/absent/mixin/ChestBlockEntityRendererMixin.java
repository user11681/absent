package user11681.absent.mixin;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.block.ChestAnimationProgress;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@SuppressWarnings({"unchecked", "ConstantConditions"})
@Mixin(ChestBlockEntityRenderer.class)
abstract class ChestBlockEntityRendererMixin<T extends BlockEntity & ChestAnimationProgress> {
    @Accessor("christmas")
    public abstract void christmas(boolean christmas);

    @Redirect(method = "<init>",
              at = @At(value = "FIELD",
                       target = "Lnet/minecraft/client/render/block/entity/ChestBlockEntityRenderer;christmas:Z"))
    public void disableChristmas(ChestBlockEntityRenderer<T> renderer, boolean christmas) {
        ((ChestBlockEntityRendererMixin<T>) (Object) renderer).christmas(false);
    }
}
