package kz.alpamys;
import kz.alpamys.bot.TelegramBot;
import kz.alpamys.search.SearchLogicClass;
import org.mortbay.util.ajax.JSON;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import java.io.IOException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws TelegramApiException, IOException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new TelegramBot());
    }
}