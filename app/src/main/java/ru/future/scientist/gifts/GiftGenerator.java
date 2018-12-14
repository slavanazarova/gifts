package ru.future.scientist.gifts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GiftGenerator {

    private static final String[] names = new String[]{"Мишка", "Сапожки", "Духи", "Конфеты", "Книга", "Мороженое", "Чехол", "Ананас"};
    private static final String[] images = new String[] {
        "http://i3.stat01.com/1/1719/17184668/afacdb/120-sm-3900-140-sm-5900-160-sm-6900-200-sm-8900-jpg.jpg",
        "https://s1.kaercher-media.com/products/00174520/main/2/d0.jpg",
        "https://mylitta.ru/uploads/posts/2012-03/1330601806_guerlain-shalimar-4.jpg" ,
        "https://besplatka.ua/aws/24/74/99/28/prodavec---konsultant---konfety-trc---karavan---m-photo-e597.jpg",
        "http://www.al24.ru/wp-content/uploads/2014/09/preview.jpg",
        "http://verytiksi.ru/_nw/2/98861.jpg" ,
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRwcjKKSWsa7OaDzG-S5Tg1whqpPKJ0DCyUOVY_29QPCXzz3efaw",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBv56RwFzKfP8su7-v7pCTd5IbHIg0NF-ANN96v4wD9MFWCo2l"
    };
    private static final String[] notes = new String[]{"Rich Toys","Мосье Башмаков", "Avoun","Коркунов","Litres", "Джелато", "H&M", "Окей" };


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
