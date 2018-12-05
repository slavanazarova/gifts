package ru.future.scientist.gifts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GiftGenerator {

    private static final String[] names = new String[]{"Мишка", "Сапожки", "Духи", "Конфеты", "Книга", "Мороженное", "Чехол для телефона", "Ананас"};
    private static final String[] images = new String[]{
            "https://www.prohandmade.ru/wp-content/uploads/2015/09/starwarsiconsawakens-16-900x900.png",
            "http://img.scoop.it/GroGTPKlZ4COVytp24pJdoXXXL4j3HpexhjNOf_P3YmryPKwJ94QGRtDb3Sbc6KY",
            "https://storage.googleapis.com/replit/images/1509526663063_78cee07358a3fd43480ae7fa5b4d76e3.png",
            "https://yt3.ggpht.com/a-/AJLlDp13bM8yFuEE7HVlYHFt7zvZPSMWbGEz4OrxOw=s900-mo-c-c0xffffffff-rj-k-no",
            "http://comic-cons.xyz/wp-content/uploads/Star-Wars-avatar-icon-Ewok.png",
            "https://cdn.dribbble.com/users/588874/screenshots/2249423/dribbble_1x.png",
            "https://avatarko.ru/img/kartinka/32/Star_Wars_pistolet_31680.jpg",
            "http://weclipart.com/gimg/31A72F8B8986D00C/obiwan_kenobi_rots_by_kaal_jhyy.jpg"};
    private static final String[] notes = new String[]{"Размер: 36, цена: 3000", "Для Айфона", "",};


    private Random random = new Random();

    public Gift getGift() {
        final String name = names[random.nextInt(names.length)];
        final String image = images[random.nextInt(images.length)];
        final String note = notes[random.nextInt(notes.length)];
        return new Gift(name, note, image, true);
    }

    public List<Gift> getGifts(final int count){
        List<Gift> gifts = new ArrayList<>(count);
        for(int i=0; i < count; i++) {
            gifts.add(getGift());
        }
        return gifts;
    }

    public String getAvatarLink(){
        return images[random.nextInt(images.length)];
    }
}
