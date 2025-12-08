package dev.lightdev.config;


import dev.lightdev.config.message.Message;
import dev.lightdev.config.message.MessageType;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.platform.core.annotation.Configuration;

@Configuration(path = "messages.yml")
public class MessageConfig extends OkaeriConfig {

    @Comment()
    @Comment("Wiadomości przy zmienieniu trybu gry /gm:")
    public Message changeGamemode = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fUstawiono tryb gry na &#ffae42{GAMEMODE} &8∙");
    public Message changeGamemodeOthers = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fUstawiono tryb gry na &#ffae42{GAMEMODE} &fgraczowi &#f8de7e{TARGET} &8∙");

    @Comment()
    @Comment("Wiadomości przy uleczeniu się /heal:")
    public Message onHealOwn = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie uleczono! &8∙");
    public Message onHealOthers = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie uleczono &fgracza &#ffae42{TARGET} &8∙");

    @Comment()
    @Comment("Wiadomości przy najedzeniu się /feed:")
    public Message onFeedOwn = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie najedzono! &8∙");
    public Message onFeedOthers = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie najedzono &fgracza &#ffae42{TARGET} &8∙");

    @Comment
    @Comment("Wiadomość przy użyciu /tphere")
    public Message onTpherePlayer = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie przywołano &cgracza! &8∙");

    @Comment
    @Comment("Wiadomość przy zmianie szybkości latania /flyspeed")
    public Message onFlySpeedUse = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie zmieniono tryb latania na &#FFAE42{SPEED} &8∙");
    public Message onFlySpeedUsePlayer = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie zmieniono tryb latania na &#FFAE42{SPEED} &fgraczowi &6{TARGET} &8∙");

    @Comment
    @Comment("Wiadomość przy zmianie szybkości chodzenia /speed")
    public Message onSpeedUse = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie zmieniono szybkość chodzenia na &#FFAE42{SPEED} &8∙");
    public Message onSpeedUsePlayer = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie zmieniono szybkość chodzenia na &#FFAE42{SPEED} &fgraczowi &6{TARGET} &8∙");

    @Comment()
    @Comment("Wiadomości przy włączeniu/wyłączeniu fly:")
    public Message onFlyToggle = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie &awłączono &ftryb latania &8∙");
    public Message offFlyToggle = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie &cwyłączono &ftryb latania &8∙");
    public Message onFlyToggleOthers = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie &awłączono &ftryb latania graczowi &#ffae42{TARGET} &8∙");
    public Message offFlyToggleOthers = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie &cwyłączono &ftryb latania graczowi &#ffae42{TARGET} &8∙");

    @Comment()
    @Comment("Wiadomości przy wejściu/wyjściu gracza na serwer:")
    public Message onJoinNewPlayer = new Message(MessageType.CHAT, "&8[&4⭐&8] &fGracz &6{TARGET} &fwbił pierwszy raz na &#ffae42serwer.");
    public Message onJoinPlayer = new Message(MessageType.CHAT, "&8[&#ffae42⚡&8] &fGracz &6{TARGET} &fwbił na &#ffae42serwer.");
    public Message onQuitPlayer = new Message(MessageType.CHAT, "&8[&#ffae42❌&8] &fGracz &6{TARGET} &fwyszedł z &#ffae42serwera.");

    @Comment()
    @Comment("Wiadomości przy włączeniu/wyłączeniu gammy:")
    public Message changeOnGamma = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie &awłączono &fgammę! &8∙");
    public Message changeOffGamma = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie &cwyłączono &fgammę! &8∙");
    public Message changeOnGammaOthers = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie &awłączono &fgamme dla &#ffae42{TARGET} &8∙");
    public Message changeOffGammaOthers = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie &cwyłączono &fgamme dla &#ffae42{TARGET} &8∙");

    @Comment
    @Comment("Wiadomość po wpisaniu /adminchat <message>:")
    public Message onAdminChatMessage = new Message(MessageType.CHAT, "&8[&6❄&8] &7Administrator &f{PLAYER} &7napisał: &#ffae42{MESSAGE}");

    @Comment
    @Comment("Wiadomość po wpisaniu /alert <message>")
    public Message onAlertSend = new Message(MessageType.CHAT, "&2✔ &8| &aPomyślnie wysłano &2ogłoszenie &ado wszystkich!");
    public Message onAlertSendPlayers = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&f{MESSAGE}");

    @Comment()
    @Comment("Wiadomości przy wyczyszczeniu ekwipunku /clear:")
    public Message onClearOwn = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie wyczyszczono &#ffae42ekwipunek! &8∙");
    public Message onClearOthers = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &fPomyślnie wyczyszczono ekwipunek &fgracza &#ffae42{TARGET} &8∙");

    @Comment()
    @Comment("Wiadomość przy użyciu /chat:")
    public Message onDisableChat = new Message(MessageType.CHAT, "&r\n     &#F8DE7E&lᴄ&#F8DE7E&lʜ&#F8DE7E&lᴀ&#F8DE7E&lᴛ &#F8DE7E&lᴢ&#F8DE7E&lᴀ&#F8DE7E&lꜱ&#F8DE7E&lᴛ&#F8DE7E&lᴏ&#F8DE7E&lᴘ&#F8DE7E&lᴏ&#F8DE7E&lᴡ&#F8DE7E&lᴀ&#F8DE7E&lɴ&#F8DE7E&lʏ\n&r\n&8&l⏵ &fAdministrator o nicku &c{PLAYER}\n&8&l⏵ &fPomyślnie &#ffae42wyłączył &fchat!\n&r");
    public Message onClearChat = new Message(MessageType.CHAT, "&r\n    &#F8DE7E&lᴄ&#F8DE7E&lʜ&#F8DE7E&lᴀ&#F8DE7E&lᴛ &#F8DE7E&lᴡ&#F8DE7E&lʏ&#F8DE7E&lᴄ&#F8DE7E&lᴢ&#F8DE7E&lʏ&#F8DE7E&lꜱ&#F8DE7E&lᴢ&#F8DE7E&lᴄ&#F8DE7E&lᴢ&#F8DE7E&lᴏ&#F8DE7E&lɴ&#F8DE7E&lʏ\n&r\n&8&l⏵ &fAdministrator o nicku &c{PLAYER}\n&8&l⏵ &fPomyślnie &#ffae42wyczyścił &fchat!\n&r");
    public Message onEnableChat = new Message(MessageType.CHAT, "&r\n     &#F8DE7E&lᴄ&#F8DE7E&lʜ&#F8DE7E&lᴀ&#F8DE7E&lᴛ &#F8DE7E&lᴡ&#F8DE7E&lᴢ&#F8DE7E&lɴ&#F8DE7E&lᴏ&#F8DE7E&lᴡ&#F8DE7E&lɪ&#F8DE7E&lᴏ&#F8DE7E&lɴ&#F8DE7E&lʏ\n&r\n&8&l⏵ &fAdministrator o nicku &c{PLAYER}\n&8&l⏵ &fPomyślnie &#ffae42włączył &fchat!\n&r");

    @Comment
    @Comment("Wiadomość po zabiciu gracza:")
    public Message onKillPlayer = new Message(MessageType.TITLE_SUBTITLE, "&#FFAE42&lᴍ&#FEB84E&lᴇ&#FCC15A&lᴛ&#FBCB66&lᴇ&#F9D472&lᴏ&#F8DE7E&lʀ&f&lᴅᴇᴠ%NOWA_LINIA%&8∙ &7Wydropiłeś &fczaszkę &7z gracza &f{PLAYER}&7! &8∙");

    @Comment
    @Comment("Wiadomość po wpisaniu /repair opocjonalnie /repair all")
    public Message repairItem = new Message(MessageType.TITLE_SUBTITLE, "%NOWA_LINIA% &8∙ &aPomyślnie naprawiłeś &2przedmiot! &8∙");
    public Message repairNoItem = new Message(MessageType.TITLE_SUBTITLE, "%NOWA_LINIA% &8∙ &cNie masz przedmiotu w &4ręce! &8∙");
    public Message repairItemNotRepair = new Message(MessageType.TITLE_SUBTITLE, "%NOWA_LINIA% &8∙ &cTen przedmiot nie jest do &4naprawy! &8∙");

    public Message repairAllNoItemRepair = new Message(MessageType.TITLE_SUBTITLE, "%NOWA_LINIA% &8∙ &cNie znaleziono &4żadnych &cprzedmiotów do naprawy! &8∙");
    public Message repairAllSucces = new Message(MessageType.TITLE_SUBTITLE, "%NOWA_LINIA% &8∙ &aPomyślnie naprawiłeś &2{COUNT} &aprzedmiotów! &8∙");
    @Comment
    @Comment("Wiadomość po wyświetlania helpop:")
    public Message helpopAdminMessage = new Message(MessageType.CHAT, "&8[&6❄&8] &7Gracz &f{PLAYER} &7napisał: &#ffae42{MESSAGE}");
    public Message helpopUserMessage = new Message(MessageType.CHAT, "&8[&6❄&8] &aPomyślnie wysłałeś wiadomość do administracji o treści: &#ffae42{MESSAGE}");

    @Comment
    @Comment("Wiadomość po wpisaniu /discord")
    public Message discordSend = new Message(MessageType.CHAT, "\n &8→ &fNasz discord: &#ffae42dc.lightdev.pl \n");

    @Comment
    @Comment("Wiadomość po wpisaniu /strona,/store")
    public Message storeSend = new Message(MessageType.CHAT, "\n &8→ &fNasza strona: &#ffae42www.lightdev.pl \n");
}
