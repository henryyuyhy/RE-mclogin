package org.molaei.mclogin.listeners;

import org.molaei.mclogin.LoginMod;
import org.molaei.mclogin.PlayerLogin;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;

public class OnPlayerMove {
    public static boolean canMove(ServerPlayNetworkHandler networkHandler) {
        ServerPlayerEntity player = networkHandler.player;
        PlayerLogin playerLogin = LoginMod.getPlayer(networkHandler.player);
        boolean isLoggedIn = playerLogin.isLoggedIn();
        if (!isLoggedIn) {
            player.teleport(player.getX(), player.getY(), player.getZ()); // teleport to sync client position
        }
        return isLoggedIn;
    }
}
