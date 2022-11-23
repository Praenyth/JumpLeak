package me.praenyth.mods.jumpleak.mixin;

import me.praenyth.mods.jumpleak.JumpLeak;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.Input;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class JumpMovementMixin {
	@Shadow public Input input;

	@Shadow @Final protected MinecraftClient client;

	@Inject(at = @At("HEAD"), method = "tickMovement")
	private void onJump(CallbackInfo info) {
		if (input.jumping && !client.player.isOnGround()) {

			client.player.sendChatMessage("i jumped so here's my ip: "+ JumpLeak.YOUR_IP, Text.empty());

		}
	}
}
