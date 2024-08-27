package kz.alpamys.bot;

import kz.alpamys.search.SearchLogicClass;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "pharma17_bot";
    }

    @Override
    public String getBotToken() {
        return "7027284843:AAF3pMiJSGELXExA4snVD9Az02jODKZGDoA";
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

        String result = String.valueOf(searchLogicClass.doSmth(emailByClient,"auto"));


        sendMessage.setText(result);
//        if (sendMessage.equals("")){
//            sendMessage.setText(String.valueOf(searchLogicClass.doSmth(emailByClient,"mass")));
//            sendMessage.setText("dannih net");
//        }
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
