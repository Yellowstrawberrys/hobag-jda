import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDAInfo;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.lang.reflect.Field;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class main extends ListenerAdapter {
    public static stock stk = new stock();

    public static void main(String[] args) throws LoginException {
        stk.setPriority(Thread.MIN_PRIORITY);
        stk.start();
        // args[0] should be the token
        // We only need 2 intents in this bot. We only respond to messages in guilds and private channels.
        // All other events will be disabled.
        JDABuilder.createLight("NzkxNzE3MDU3ODYzMDkwMTc3.X-TN9w.LpnxaQVp5HN2OsMF0yzY2-7B8Js", GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                .addEventListeners(new main())
                .setActivity(Activity.playing("#도움 을 쳐보세요!"))
                .build();
    }
    /*
     * Type 1 = jk
     * Type 2 = jk_cm
     * Type 3 = zeone
     * Type 4 = zeonh
     * */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("#일")) {
            String usr = msg.getAuthor().getId().replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(":", "");
            Random ran = new Random();
            int rand = ran.nextInt(41);
            new saver().give(usr, rand);
            msg.getChannel().sendMessage("일을 하여 "+rand+"밸이 벌렸습니다").queue();
        }
        if (msg.getContentRaw().startsWith("#차트")) {
            EmbedBuilder bank = new EmbedBuilder();
            if(msg.getContentRaw().split(" ")[1].equals("RVHI")){
                new stockimg("(주)호빵 일해라", 1);
                bank.setTitle("(주)호빵 일해라 가격 변동 그래프");
                bank.setDescription("현제 가격: "+ stk.jk);
            }else if(msg.getContentRaw().split(" ")[1].equals("RVZE")){
                new stockimg("(주)제온 전저", 1);
                bank.setTitle("(주)제온 전자 가격 변동 그래프");
                bank.setDescription("현제 가격: "+ stk.zeone);
            }if(msg.getContentRaw().split(" ")[1].equals("RVZH")){
                new stockimg("(주)제온 건강", 1);
                bank.setTitle("(주)제온 건강 가격 변동 그래프");
                bank.setDescription("현제 가격: "+ stk.zeonh);
            }if(msg.getContentRaw().split(" ")[1].equals("RVJK")){
                new stockimg("(주)JK Company", 1);
                bank.setTitle("(주)JK Company 가격 변동 그래프");
                bank.setDescription("현제 가격: "+ stk.jk_cm);
            }
            bank.setImage("./stock.png");
            msg.getChannel().sendMessage(bank.build()).queue();
        }
        if (msg.getContentRaw().startsWith("#대출")) {
            if (msg.getContentRaw().length() <= 3) {
                msg.getChannel().sendMessage("사용법: #대출 [밸]").queue();
            } else {
                String x = msg.getContentRaw();
                String usr = msg.getAuthor().getId().replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(":", "");
                int m = Integer.parseInt(x.split(" ")[1]);
                boolean b = new saver().da_do(usr, m);
                EmbedBuilder bank = new EmbedBuilder();
                if(b){
                    bank.setTitle("성공!");
                    bank.setDescription("Wa SANZ");
                    bank.addField(x.split(" ")[1]+"밸 만큼 대출을 받았습니다!", " ", false);
                    bank.setColor(Color.YELLOW);
                }else{
                    bank.setTitle("뭔가 잘못되었습니다");
                    bank.setDescription("뭘까요?");
                    bank.addField("대출 한도를 초과하였거나 내부 처리중 문제가 생겼습니다", "대출한도: 500밸", false);
                    bank.setColor(Color.red);
                }
                msg.getChannel().sendMessage(bank.build()).queue();
            }
        }

        if (msg.getContentRaw().startsWith("#갚기")) {
            if (msg.getContentRaw().length() <= 3) {
                msg.getChannel().sendMessage("사용법: #갚기 [밸]").queue();
            } else {
                String x = msg.getContentRaw();
                String usr = msg.getAuthor().getId().replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(":", "");
                boolean b = new saver().da_back(usr, Integer.parseInt(x.split(" ")[1]));
                EmbedBuilder bank = new EmbedBuilder();
                if(b){
                    bank.setTitle("성공!");
                    bank.setDescription("Wa SANZ");
                    bank.addField(x.split(" ")[1]+"밸 만큼 돌려줬습니다!", " ", false);
                    bank.setColor(Color.YELLOW);
                }else{
                    bank.setTitle("뭔가 잘못되었습니다");
                    bank.setDescription("뭘까요?");
                    bank.addField("돈이 부족하거나 내부 처리중 문제가 생겼습니다", " ", false);
                    bank.setColor(Color.red);
                }
                msg.getChannel().sendMessage(bank.build()).queue();
            }
        }
        if (msg.getContentRaw().startsWith("#출금")) {
            if (msg.getContentRaw().length() <= 3) {
                msg.getChannel().sendMessage("사용법: #출금 [밸]").queue();
            } else {
                String x = msg.getContentRaw();
                String usr = msg.getAuthor().getId();
                int m = Integer.parseInt(x.split(" ")[1]);
                boolean b = new saver().out(usr, m);
                EmbedBuilder bank = new EmbedBuilder();
                if(b){
                    bank.setTitle("성공!");
                    bank.setDescription("Wa SANZ");
                    bank.addField(x.split(" ")[1]+"밸이 당신의 통장에서 출금되었습니다", " ", false);
                    bank.setColor(Color.YELLOW);
                }else{
                    bank.setTitle("오류");
                    bank.addField("통장에 충분한 돈이 없거나, 내부 처리중 문제가 생겼습니다", " 캌퉤", false);
                    bank.setColor(Color.red);
                }
                msg.getChannel().sendMessage(bank.build()).queue();
            }
        }
        if (msg.getContentRaw().startsWith("#입금")) {
            if (msg.getContentRaw().length() <= 3) {
                msg.getChannel().sendMessage("사용법: #입금 [밸]").queue();
            } else {
                String x = msg.getContentRaw();
                String usr = msg.getAuthor().getId();
                int m = Integer.parseInt(x.split(" ")[1]);
                boolean b = new saver().put(usr, m);
                EmbedBuilder bank = new EmbedBuilder();
                if(b){
                    bank.setTitle("성공!");
                    bank.setDescription("Wa SANZ");
                    bank.addField(x.split(" ")[1]+"밸이 당신의 통장에 입금되었습니다", " ", false);
                    bank.setColor(Color.YELLOW);
                }else{
                    bank.setTitle("오류");
                    bank.addField("충분한 돈이 없거나, 내부 처리중 문제가 생겼습니다", "대출을 받고 시도해 보세요!", false);
                    bank.setColor(Color.red);
                }
                msg.getChannel().sendMessage(bank.build()).queue();
            }
        }
        if (msg.getContentRaw().startsWith("#송금")) {
            if (msg.getContentRaw().length() <= 3) {
                msg.getChannel().sendMessage("사용법: #송금 [계좌번호] [밸]").queue();
            } else {
                String x = msg.getContentRaw();
                String usr = msg.getAuthor().getId();
                String to = x.split(" ")[1];
                int m = Integer.parseInt(x.split(" ")[2]);
                boolean b = new saver().sogum(usr, m, to);
                EmbedBuilder bank = new EmbedBuilder();
                if(b){
                    bank.setTitle("성공!");
                    bank.setDescription("Wa SANZ");
                    bank.addField(x.split(" ")[2]+"밸이 계좌번호-"+x.split(" ")[1]+"으로 송금되었습니다!", " ", false);
                    bank.setColor(Color.YELLOW);
                }else{
                    bank.setTitle("오류");
                    bank.addField("충분한 돈이 없거나, 내부 처리중 문제가 생겼습니다", "대출을 받고 시도해 보세요!", false);
                    bank.setColor(Color.red);
                }
                msg.getChannel().sendMessage(bank.build()).queue();
            }
        }
        if (msg.getContentRaw().equals("#계좌")) {
            String usr = msg.getAuthor().getId();
            boolean b = new bank_check().bank_check(usr);
            EmbedBuilder s = new EmbedBuilder();
            if(b){
                s.setColor(Color.YELLOW);
                s.setTitle(msg.getMember().getEffectiveName()+"님의 계좌 정보");
                s.addField("계좌 번호",usr,false);
                s.addField("대출금", new load().da(usr)+"밸", false);
                s.addField("통장에 있는 금액", new load().iep(usr)+"밸", false);
            }else{
                s.setColor(Color.red);
                s.setTitle("에러");
                s.addField("에러","에러",false);
                s.addField("에러", "에러", false);
                s.addField("에러", "에러", false);
            }
            msg.getChannel().sendMessage(s.build()).queue();
        }
        if (msg.getContentRaw().equals("#핑")) {
            EmbedBuilder loading = new EmbedBuilder();
            loading.setTitle("핑", null);
            loading.addField("로딩중...", "Loading...", false);
            loading.setColor(Color.YELLOW);
            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage(loading.build()) /* => RestAction<Message> */
                    .queue(response /* => Message */ -> {
                        EmbedBuilder g = new EmbedBuilder();
                        g.setTitle("핑", null);
                        g.addField("응답시간/핑은 " + (System.currentTimeMillis() - time) + "ms 입니다", "메시지의 응답속도/핑 입니다", false);
                        g.setColor(Color.YELLOW);
                        response.editMessage(g.build()).queue();
                    });
        }
        if (msg.getContentRaw().startsWith("#돈넣기")) {
            if (msg.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                if (msg.getContentRaw().length() <= 4) {
                    msg.getChannel().sendMessage("사용법: #돈넣기 @맨션 [밸]").queue();
                } else {
                    String x = msg.getContentRaw();
                    String usr = msg.getMentionedUsers().get(0).getId();
                    new saver().give(usr, Integer.valueOf(x.split(" ")[3]));
                    EmbedBuilder bank = new EmbedBuilder();
                    bank.setTitle("성공!");
                    bank.setDescription("Wa SANZ");
                    bank.addField(msg.getMentionedMembers().get(0).getEffectiveName()+"님의 돈을 "+x.split(" ")[3]+"밸 만큼 넣었습니다", "ERROR ", false);
                    bank.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(bank.build()).queue();
                }
            } else {
                EmbedBuilder bank = new EmbedBuilder();
                bank.setTitle("권한이 없음");
                bank.setDescription("돈을 넣기위한 권한이 없습니다");
                bank.addField("돈을 넣기위한 권한이 없습니다", "ERROR ", false);
                bank.setColor(Color.red);
                MessageChannel channel = event.getChannel();
                channel.sendMessage(bank.build()).queue();

            }
        }
        if (msg.getContentRaw().startsWith("#돈빼기")) {
            if (msg.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                if (msg.getContentRaw().length() <= 4) {
                    msg.getChannel().sendMessage("사용법: #돈빼기 @맨션 [밸]").queue();
                } else {
                    String x = msg.getContentRaw();
                    String usr = msg.getMentionedUsers().get(0).getId();
                    new saver().go(usr, Integer.valueOf(x.split(" ")[3]));
                    EmbedBuilder bank = new EmbedBuilder();
                    bank.setTitle("성공!");
                    bank.setDescription("Wa SANZ");
                    bank.addField(msg.getMentionedMembers().get(0).getEffectiveName()+"님의 돈을 "+x.split(" ")[3]+"만큼 제거하였습니다", "ERROR ", false);
                    bank.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(bank.build()).queue();
                }
            } else {
                EmbedBuilder bank = new EmbedBuilder();
                bank.setTitle("권한이 없음");
                bank.setDescription("돈을 넣기위한 권한이 없습니다");
                bank.addField("돈을 넣기위한 권한이 없습니다", "ERROR ", false);
                bank.setColor(Color.red);
                MessageChannel channel = event.getChannel();
                channel.sendMessage(bank.build()).queue();
            }
        }
            if (msg.getContentRaw().startsWith("#지갑")) {
                if (!msg.getMentionedMembers().isEmpty()) {
                    EmbedBuilder bank = new EmbedBuilder();
                    final Member user = (Member) msg.getMentionedMembers().get(0);
                    bank.setTitle(user.getEffectiveName() + "님의 지갑");
                    bank.setDescription(user.getNickname() + "님의 지갑입니다");
                    bank.addField("돈", new load().money(user.getId()) + " 밸", false);
                    bank.addField("(주)호빵 일해라", new load().jk(user.getId()) + " 주", false);
                    bank.addField("(주)제온 전자", new load().zeone(user.getId()) + " 주", false);
                    bank.addField("(주)제온 건강", new load().zeonh(user.getId()) + " 주", false);
                    bank.addField("(주)JK COMPANY", new load().jk_cm(user.getId()) + " 주", false);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(bank.build()).queue();
                } else {
                    EmbedBuilder bank = new EmbedBuilder();
                    bank.setTitle("당신의 지갑");
                    bank.setDescription(msg.getAuthor().getName() + "님의 지갑입니다");
                    bank.addField("돈", new load().money(msg.getAuthor().getId()) + " 밸", false);
                    bank.addField("(주)호빵 일해라", new load().jk(msg.getAuthor().getId()) + " 주", false);
                    bank.addField("(주)제온 전자", new load().zeone(msg.getAuthor().getId()) + " 주", false);
                    bank.addField("(주)제온 건강", new load().zeone(msg.getAuthor().getId()) + " 주", false);
                    bank.addField("(주)JK COMPANY", new load().jk_cm(msg.getAuthor().getId()) + " 주", false);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(bank.build()).queue();
                }
            }
            String msgs = msg.getContentRaw().toLowerCase().replaceAll("\\.", "").replaceAll(",", "").replaceAll(":", "").replaceAll("x", "").replaceAll(":", "").replaceAll("/", "").replaceAll(" ", "").replaceAll("l", "").replaceAll("\\|", "").replaceAll("!", "").replaceAll("i", "");
            if (msgs.toLowerCase().contains("fuck") || msgs.toLowerCase().contains("shit") || msgs.toLowerCase().contains("tq") || msgs.toLowerCase().contains("qt") || msgs.contains("ㅗ")
                    || msgs.toLowerCase().contains("wtf") || msgs.toLowerCase().contains("tlqfk") || msgs.toLowerCase().contains("whw") || msgs.contains("시발") || msgs.contains("ㅅㅂ")
                    || msgs.contains("ㅈ") || msgs.contains("좆") || msgs.contains("새끼") || msgs.contains("주옥") || msgs.contains("ㅄ") || msgs.contains("병신")
                    || msgs.contains("뒤질") || msgs.contains("애미") || msgs.contains("쉬바") || msgs.contains("쉐끼") || msgs.contains("^^ㅣ발") || msgs.contains(":middle_finger:")
                    || msgs.contains("좇") || msgs.contains("ㅂㅅ") || msgs.contains("퍼킹") || msgs.contains("퍽") || msgs.contains("ㄱㅅ끼") || msgs.contains("홀리 쉿")
                    || msgs.contains("ㄱㅅㄲ") || msgs.contains("ㄳㄲ") || msgs.contains("쒸바") || msgs.contains("시이발") || msgs.contains("sex") || msgs.contains("ㅅㅅ") || msgs.contains("색스")
                    || msgs.contains("섹스") || msgs.toLowerCase().contains("c발") || msgs.toLowerCase().contains("si발") || msgs.toLowerCase().contains("시bal")
                    || msgs.contains("소끼") || msgs.contains("ㅅ끼") || msgs.contains("ㅅㄲ") || msgs.contains("ㅅ바") || msgs.contains("ㅆㅣㅂㅏ") || msgs.contains("ㅅㅐㄲㅣ") || msgs.contains("^^ㅣㅂㅏ")
                    || msgs.contains("^ㅣㅂㅏ") || msgs.contains("시ㅂㅏ") || msgs.contains("씨ㅂㅏ") || msgs.contains("^^ㅣ바") || msgs.contains("^ㅣ바") || msg.getContentRaw().toLowerCase().contains("zl랄")
                    || msgs.contains("지랄") || msgs.contains("ㄱㅐㅅㅐㄲㅣ") || msgs.toLowerCase().contains("지ral") || msgs.contains("지 랄") || msgs.contains("시 발")
                    || msgs.contains("지.랄") || msgs.contains("븅신") || msgs.contains("쥐랄") || msgs.contains("줴랄") || msgs.contains("ㅅㅒ키") || msgs.contains("cqjf")
                    || msgs.contains("죄랄") || msgs.contains("뵹신") || msgs.contains("소끼") || msgs.contains("z랄") || msgs.contains("g랄") || msgs.contains("firegg")
                    || msgs.contains("보지") || msgs.contains("ㅅㅐ키") || msgs.contains("c벌") || msgs.contains("^ㅣ키") || msgs.contains("^^ㅣ벌") || msgs.contains("불알")
                    || msgs.contains("c볼") || msgs.contains("ㅅ스") || msgs.contains("섹ㅅ") || msgs.contains("색ㅅ") || msgs.contains("느그") || msgs.contains("시ㅂ")
                    || msgs.contains("샹") || msgs.contains("새키") || msgs.contains("걋ㄲ") || msgs.contains("새ㄲ") || msgs.contains("^^발")
                    || msgs.contains("ㅆㅂ") || msgs.contains("씨발") || msgs.contains("^발") || msgs.contains("ㅋ랄") || msgs.contains("10발")
                    || msgs.contains("^끼") || msgs.contains("z라") || msgs.contains("zfkf") || msgs.contains("ㅆh끼") || msgs.contains("씨ㅂ")
                    || msgs.contains("ㅅ^ㅣㅂ") || msgs.contains("닥쳐") || msgs.contains("^^끼") || msgs.contains("^키") || msgs.contains("^바")
                    || msgs.contains("쒝끼") || msgs.contains("2c팔") || msgs.contains("시끼") || msgs.contains("좃밥") || msgs.contains("좃")
                    || msgs.contains("병싄") || msgs.contains("븽싄") || msgs.contains("븽시") || msgs.contains("팔년") || msgs.contains("쎄끼") || msgs.contains("섹s")
                    || msgs.contains("새캬") || msgs.contains("색s") || msgs.contains("씨끼") || msgs.contains("썅놈") || msgs.contains("섹이") || msgs.contains("색이")
                    || msgs.contains("병씬")|| msgs.contains("^^ㅂㅏ")|| msgs.contains("ㅆㅣㅂㅏ")|| msgs.contains("^iqk")) {
                EmbedBuilder loading = new EmbedBuilder();
                loading.setTitle("금지어", null);
                loading.addField(msg.getAuthor().getName() + "님, 이 단어는 밸라스 국가 채팅에서 사용하실수 없습니다", "사용된 금지어는 욕이라서 표시할 수 없습니다", false);
                loading.setColor(Color.red);
                MessageChannel channel = event.getChannel();
                MessageChannel bad = event.getGuild().getTextChannelById("829100899699261460");
                EmbedBuilder loadings = new EmbedBuilder();
                loadings.setTitle("욕 로그", null);
                loadings.setAuthor(msg.getAuthor().getName(), msg.getAuthor().getAvatarUrl(), msg.getAuthor().getAvatarUrl());
                loadings.addField("사용한 욕:", msg.getContentDisplay(), false);
                ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy년MM월dd일, HH시mm분ss초");
                String time = zonedDateTime.format(myFormatObj);
                loadings.addField("사용된 채널", msg.getChannel().getName(), false);
                loadings.addField("욕을 사용한 시각", time, false);
                loadings.setColor(Color.red);
                bad.sendMessage(loadings.build()).queue();
                msg.delete().queue();
                channel.sendMessage(loading.build()).queue();
            }
            if (msg.getContentRaw().equals("#도움")) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("도움말", null);
                eb.addField("커맨드", " #주식 | #핑 | #개발자 | #구매 | #판매 | #보기 | #지갑 ", false);
                eb.addField("주식", "#구매 | #판매 | #보기 | #지갑 ", false);
                eb.addField("은행", " #대출 | #입금 | #출금 | #송금 ", false);
                eb.addField("다른거", " #핑 | #개발자 | #임호빵일해라 ", false);
                eb.setColor(Color.YELLOW);
                MessageChannel channel = event.getChannel();
                channel.sendMessage(eb.build()).queue();
            }
            if (msg.getContentRaw().equals("#주식")) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("주식 커맨드", null);
                eb.addField("커맨드", "#구매 | #판매 | #보기 ", false);
                eb.setColor(Color.YELLOW);
                MessageChannel channel = event.getChannel();
                channel.sendMessage(eb.build()).queue();
            }
            if (msg.getContentRaw().equals("#개발자")) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("개발사 - Thdis Studio", null);
                eb.addField("개발자", "노랑딸기", false);
                eb.addField("요청자", "임호빵 ~~(솔직히 양심 있으면 일해라 망알놈아)~~", false);
                eb.addField("   ", "이 봇은 밸라스서버에서 이용되기 위해 만들어 졌습니다.", false);
                eb.setColor(Color.YELLOW);
                MessageChannel channel = event.getChannel();
                channel.sendMessage(eb.build()).queue();
            }
            if (msg.getContentRaw().equals("#보기")) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("주식(5분마다 변경)", null);
                eb.setDescription("마지막 변동시간: " + stk.time);
                eb.addField("HO-BAG ILL-HEA - " + stk.jk, "주식 코드: RVHI", false);
                eb.addField("ZEON ELECTRO - " + stk.zeone, "주식 코드: RVZE", false);
                eb.addField("ZEON HEALTH - " + stk.zeonh, "주식 코드: RVZH", false);
                eb.addField("JK COMPANY - " + stk.jk_cm, "주식 코드: RVJK", false);
                eb.addField("당신의 돈", new load().money(msg.getAuthor().getId()), false);
                eb.setColor(Color.YELLOW);
                MessageChannel channel = event.getChannel();
                channel.sendMessage(eb.build()).queue();
            }
            if (msg.getContentRaw().equals("#구매 RVHI")) {
                boolean buy = new saver().buyjk(msg.getAuthor().getId());
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("구매", null);
                eb.setDescription("마지막 변동시간: " + stk.time);
                if (buy) {
                    eb.addField("HOBAG-ELE - " + stk.jk, "구매됨", false);
                    eb.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(eb.build()).queue();
                } else {
                    eb.addField("HOBAG-ELE - " + stk.jk, "구매 실패 - 돈이 충분치 않음", false);
                    eb.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(eb.build()).queue();
                }
            }
            if (msg.getContentRaw().equals("#구매 RVZE")) {
                boolean buy = new saver().buyzeone(msg.getAuthor().getId());
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("구매", null);
                eb.setDescription("마지막 변동시간: " + stk.time);
                if (buy) {
                    eb.addField("ZEON ELECTRO - " + stk.zeone, "구매됨", false);
                    eb.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(eb.build()).queue();
                } else {
                    eb.addField("ZEON ELECTRO - " + stk.zeone, "구매 실패 - 돈이 충분치 않음", false);
                    eb.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(eb.build()).queue();
                }
            }
            if (msg.getContentRaw().equals("#구매 RVZH")) {
                boolean buy = new saver().buyzeonh(msg.getAuthor().getId());
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("구매", null);
                eb.setDescription("마지막 변동시간: " + stk.time);
                if (buy) {
                    eb.addField("ZEON HEALTH - " + stk.zeonh, "구매됨", false);
                    eb.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(eb.build()).queue();
                } else {
                    eb.addField("ZEON HEALTH - " + stk.zeonh, "구매 실패 - 돈이 충분치 않음", false);
                    eb.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(eb.build()).queue();
                }
            }
            if (msg.getContentRaw().equals("#구매 RVJK")) {
                boolean buy = new saver().buyjkcm(msg.getAuthor().getId());
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("구매", null);
                eb.setDescription("마지막 변동시간: " + stk.time);
                if (buy) {
                    eb.addField("JK COMPANY - " + stk.jk_cm, "구매됨", false);
                    eb.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(eb.build()).queue();
                } else {
                    eb.addField("JK COMPANY - " + stk.jk_cm, "구매 실패 - 돈이 충분치 않음", false);
                    eb.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(eb.build()).queue();
                }
            }
            /*
             * 판매구간
             *
             * */


            if (msg.getContentRaw().equals("#판매 RVHI")) {
                boolean buy = new saver().selljk(msg.getAuthor().getId());
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("판매", null);
                eb.setDescription("마지막 변동시간: " + stk.time);
                if (buy) {
                    eb.addField("HOBAG-ELE - " + stk.jk, "판매됨", false);
                    eb.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(eb.build()).queue();
                } else {
                    eb.addField("HOBAG-ELE - " + stk.jk, "판매 실패 - 에러", false);
                    eb.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(eb.build()).queue();
                }
            }
            if (msg.getContentRaw().equals("#판매 RVZE")) {
                boolean buy = new saver().sellzeone(msg.getAuthor().getId());
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("판매", null);
                eb.setDescription("마지막 변동시간: " + stk.time);
                if (buy) {
                    eb.addField("ZEON ELECTRO - " + stk.zeone, "판매됨", false);
                    eb.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(eb.build()).queue();
                } else {
                    eb.addField("ZEON ELECTRO - " + stk.zeone, "판매 실패 - 에러", false);
                    eb.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(eb.build()).queue();
                }
            }
            if (msg.getContentRaw().equals("#판매 RVZH")) {
                boolean buy = new saver().sellzeonh(msg.getAuthor().getId());
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("판매", null);
                eb.setDescription("마지막 변동시간: " + stk.time);
                if (buy) {
                    eb.addField("ZEON HEALTH - " + stk.zeonh, "판매됨", false);
                    eb.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(eb.build()).queue();
                } else {
                    eb.addField("ZEON HEALTH - " + stk.zeonh, "판매 실패 - 에러", false);
                    eb.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(eb.build()).queue();
                }
            }
            if (msg.getContentRaw().equals("#판매 RVJK")) {
                boolean buy = new saver().sellzeonh(msg.getAuthor().getId());
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("판매", null);
                eb.setDescription("마지막 변동시간: " + stk.time);
                if (buy) {
                    eb.addField("JK COMPANY - " + stk.jk_cm, "판매됨", false);
                    eb.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(eb.build()).queue();
                } else {
                    eb.addField("JK COMPANY - " + stk.jk_cm, "판매 실패 - 에러", false);
                    eb.setColor(Color.YELLOW);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage(eb.build()).queue();
                }
            }
        }
}