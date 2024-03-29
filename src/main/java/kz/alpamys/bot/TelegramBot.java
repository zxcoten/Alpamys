package kz.alpamys.bot;

import kz.alpamys.search.SearchLogicClass;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "test09128302951bot";
    }

    @Override
    public String getBotToken() {
        return "7128516836:AAHLkveXtBLJt4c_84Ihirw3xzNSHsQbuLs";
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public void onUpdateReceived(Update update) {
        String chatID = update.getMessage().getChatId().toString();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID);
        String emailByClient = update.getMessage().getText();
        SearchLogicClass searchLogicClass = new SearchLogicClass();
        sendMessage.setText(String.valueOf(searchLogicClass.doSmth(emailByClient,"auto")));
        if (sendMessage.equals("")){
            sendMessage.setText(String.valueOf(searchLogicClass.doSmth(emailByClient,"mass")));
        }
        try {
            this.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }
}
