package dev.morgentruesdale.nowyoucanfishagain.config;


import net.minecraftforge.common.ForgeConfigSpec;

public class Config {

    public static final ForgeConfigSpec GENERAL_SPEC;

    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        setupConfig(configBuilder);
        GENERAL_SPEC = configBuilder.build();
    }

    public static ForgeConfigSpec.ConfigValue<String> catchMessage;

    private static void setupConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Now You Can Fish Again Config!");
        builder.comment("");
        builder.push("Settings:");
            catchMessage = builder
                    .comment("The message that will be sent to the player when something has been hooked")
                    .comment("Set to 'false' to disable")
                    .define("catch_message","Uh oh, you may have a Pokemon on the line!");
        builder.pop();
    }
}
