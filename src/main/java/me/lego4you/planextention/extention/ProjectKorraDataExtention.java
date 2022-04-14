package me.lego4you.planextention.extention;

import com.djrapitops.plan.extension.CallEvents;
import com.djrapitops.plan.extension.DataExtension;
import com.djrapitops.plan.extension.annotation.PluginInfo;
import com.djrapitops.plan.extension.annotation.StringProvider;
import com.djrapitops.plan.extension.icon.Color;
import com.djrapitops.plan.extension.icon.Family;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;


@PluginInfo(
        name = "ProjectKorra",
        iconName = "water",
        iconFamily = Family.SOLID,
        color = Color.NONE
)
public class ProjectKorraDataExtention implements DataExtension {
    @Override
    public CallEvents[] callExtensionMethodsOn() {
        return new CallEvents[]{
                CallEvents.PLAYER_JOIN,
                CallEvents.PLAYER_LEAVE
        };
    }

    @StringProvider(
            text = "Bending",
            description = "What Bending Abilaties Has This Player",
            priority = 1,
            iconName = "atom",
            iconFamily = Family.SOLID,
            iconColor = Color.NONE,
            playerName = false
    )
    public String mainBendingAbility(UUID playerUUID) {
        Player player = Bukkit.getPlayer(playerUUID);
        //BendingPlayer bPlayer = BendingPlayer.getBendingPlayer(player);
        //String mainBending = bPlayer.getAbilities().toString();
        //return mainBending;
        return "Bending-of-" + player.getDisplayName();
    }
}
