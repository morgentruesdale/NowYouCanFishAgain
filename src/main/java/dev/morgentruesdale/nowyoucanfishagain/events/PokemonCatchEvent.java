package dev.morgentruesdale.nowyoucanfishagain.events;

import com.pixelmonmod.pixelmon.api.events.FishingEvent;
import dev.morgentruesdale.nowyoucanfishagain.config.Config;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import java.util.Random;

@EventBusSubscriber
public class PokemonCatchEvent {

	Config config = new Config();

	@SubscribeEvent
	public void onFishCatch(FishingEvent.Catch e) {

		Player player = e.player;
		Level level = player.level();

		if (level.isClientSide) {
			return;
		}

		ServerLevel serverLevel = (ServerLevel) level;
		Random random = new Random();
		serverLevel.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
		if(config.getcatchMessage()!="false") {
			e.player.sendSystemMessage(Component.literal(config.getcatchMessage()));
		}
	}
}
