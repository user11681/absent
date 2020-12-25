package user11681.absent.mixin;

import java.time.Instant;
import java.util.Date;
import net.minecraft.client.resource.SplashTextResourceSupplier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SplashTextResourceSupplier.class)
abstract class SplashTextResourceSupplierMixin {
    @Redirect(method = "get",
              at = @At(value = "NEW",
                       target = "java/util/Date"))
    public Date returnFakeDate() {
        return Date.from(Instant.ofEpochSecond(31 * 86400));
    }
}
