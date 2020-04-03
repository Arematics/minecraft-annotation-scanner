package com.arematics.minecraft.core;

import com.arematics.minecraft.core.hooks.CommandHooks;
import com.arematics.minecraft.core.hooks.ListenerHook;
import com.arematics.minecraft.core.hooks.ScanEnvironment;
import org.bukkit.Bukkit;

class Engine {

    private static Engine INSTANCE;

    /**
     * @return Instance Engine Object
     */
    public static Engine getInstance(){
        return INSTANCE;
    }

    /**
     * Generates new Engine Class as Instace
     * @param bootstrap JavaPlugin
     */
    static void startEngine(Bootstrap bootstrap){
        INSTANCE = new Engine(bootstrap);
    }

    /**
     * Stopping Engine and calling Shutdown Hooks
     */
    static void shutdownEngine(){
        if(INSTANCE != null){
            //TODO Fire Shutdown Hook
        }else{
            Bukkit.getLogger().severe("Instance not found System shutdown whiteout saving");
        }
    }

    private Bootstrap plugin;

    /**
     * Starts the Reflections Hooks scanning for Annotations in specified Package and
     * generates the Configuration Builder Instance
     * @param bootstrap JavaPlugin
     */
    public Engine(Bootstrap bootstrap){
        this.plugin = bootstrap;
        String url = "com.arematics.minecraft.core";
        ScanEnvironment.generateBuilder();
        CommandHooks.hookCommands(url, this.getClass().getClassLoader(), bootstrap);
        ListenerHook.hookListeners(url, this.getClass().getClassLoader(), bootstrap);
    }

    public Bootstrap getPlugin() {
        return plugin;
    }
}
