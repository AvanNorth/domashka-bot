import org.telegram.telegrambots.extensions.bots.commandbot.commands.ICommandRegistry;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import orm.Thing;
import orm.ThingDao;

public final class StartCommand extends BotsCommand {

    private final ICommandRegistry mCommandRegistry;

    public StartCommand(ICommandRegistry commandRegistry) {
        super("start", "старт");
        mCommandRegistry = commandRegistry;
    }
    private String[] subjects =
            {
                    "Алгебра",
                    "Геома",
                    "ЕГЭ",
                    "Русский",
                    "Литра",
                    "Биология",
                    "Физика",
                    "История",
                    "География",
                    "Физра",
                    "Общага",
                    "Группа Кузьмина Н.О",
                    "Группа Серебрякова М.Г",
                    "Группа Шубинкин В.Н",
                    "Группа Бамбуркина Л.В",
            };

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage message = new SendMessage();
        message.setChatId(chat.getId().toString());
        message.setText("Привет, я бот по домашке");

        ThingDao dao = new ThingDao();
        Thing thing = new Thing();
        thing.setText("Пусто");
        for (int i=0;i<subjects.length;i++){
            thing.setId(i);
            thing.setTag(subjects[i]);
            dao.save(thing);
        }
        Menu menu = new Menu();
        if (chat.getId() == 430148873 || chat.getId() == 339293658 || chat.getId() == 396945086)
        message.setReplyMarkup(menu.getAdminMainMenuReplyKeyboard());
        else
            message.setReplyMarkup(menu.getMainMenuReplyKeyboard());
        execute(absSender, message, user);
        System.out.println("ChatId: "+chat.getId());
    }
}