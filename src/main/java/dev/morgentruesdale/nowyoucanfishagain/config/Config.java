package dev.morgentruesdale.nowyoucanfishagain.config;

import com.pixelmonmod.pixelmon.api.config.api.data.ConfigPath;
import com.pixelmonmod.pixelmon.api.config.api.yaml.AbstractYamlConfig;
import info.pixelmon.repack.org.spongepowered.objectmapping.ConfigSerializable;

@ConfigSerializable
@ConfigPath("config/nowyoucanfishagain/config.yml")
public class Config extends AbstractYamlConfig{

    public String onCatchMessage = "Uh oh, you may have a Pokemon on the line!";

    public Config() {
        super();
    }

    public String getcatchMessage() {
        return this.onCatchMessage;
    }

}
