package com.example.foodymoody.data.model;

import com.example.foodymoody.data.Food;

import java.util.ArrayList;

public class MehFood {
    public static ArrayList<Food> mehFoodList = new ArrayList<Food>();

    public MehFood(){
        //reset
        mehFoodList.clear();


        // food - > description, image (copy image address dari google image), name, calories per serving, possible allergic (boolean)
        mehFoodList.add(new Food("Indomie is a brand of instant noodle produced by the Indonesian company Indofood.",
                "https://resepkoki.id/wp-content/uploads/2020/11/Resep-Indomie-Goreng.jpg","Indomie", 350, false));
        mehFoodList.add(new Food("Fried Chicken Nugget is a good choice for you!",
                "https://asset.kompas.com/crops/sdYa4n2m_4wjusaKxxHFwQx5zdQ=/66x44:944x629/750x500/data/photo/2021/10/16/616a559fe2c61.jpg","Fried Chicken Nugget", 296, false));
        mehFoodList.add(new Food("Filet mignon is a cut of meat taken from the smaller end of the tenderloin, or psoas major of an animal carcass. Hmm.. so yummy!!",
                "https://airfryingfoodie.com/wp-content/uploads/2021/09/Air-Fryer-Filet-Mignon.jpg", "Filet Mignon", 267, false));
        mehFoodList.add(new Food("A corn dog is a sausage on a stick that has been coated in a thick layer of cornmeal batter and deep fried",
                "https://cdn.popbela.com/content-images/post/20190726/00-corn-dog-33aeb18ce148b5ea671c5a1f1bf594b3_750x500.jpg", "Corn Dog", 262, true));
        mehFoodList.add(new Food("Nasi padang is suitable for those of you who are hungry",
                "https://assets-pergikuliner.com/4o-dKncqKNS6QQbFDqM52WkrK0o=/fit-in/1366x768/smart/filters:no_upscale()/https://assets-pergikuliner.com/uploads/bootsy/image/12013/picture-1537766225.jpeg", "Nasi Padang", 550, false));
        mehFoodList.add(new Food("Lontong gulai or lontong Sayur is an Indonesian food originating from Minangkabau, West Sumatra. Lontong is synonymous with coconut milk sauce, a thick spice typical of Minang cuisine. Coconut milk sauce which is rich in spices, has been known as one of the ways to cook Minang cuisine",
                "https://cdn-brilio-net.akamaized.net/news/2022/03/24/225777/1699923-1000xauto-resep-lontong-sayur.jpg", "Lontong Sayur", 357, false));
        mehFoodList.add(new Food("Opor ayam is a type of chicken curry that is very well known in Indonesia. This cuisine has been widely known in other areas. Almost all over Indonesia. Opor ayam is boiled chicken that is given a thick seasoning of coconut milk which is added with various spices such as lemongrass, galangal, and so on",
                "https://img.kurio.network/xqALZtOLtYRK5YaHz4-tvAm0jJ4=/1200x1200/filters:quality(80)/https://kurio-img.kurioapps.com/21/04/13/93df0270-82a4-40f7-944d-a5ccc22a8c5e.jpe", "Opor Ayam", 392, false));
        mehFoodList.add(new Food("Sate Padang uses beef, tongue, or offal with thick peanut sauce seasoning and lots of chilies to taste spicy. Yumm.. Yum.. Yumm!!",
                "https://piknikdong.com/wp-content/uploads/2020/10/Resep-Sate-Padang-Sederhana.jpg", "Sate Padang", 161, true));
        mehFoodList.add(new Food("Bibimbap, sometimes romanized as bi bim bap or bi bim bop, is a Korean rice dish. The term \"bibim\" means mixing rice, while the \"bap\" noun refers to rice. Bibimbap is served as a bowl of warm white rice topped with namul or kimchi and gochujang, soy sauce, or doenjang.",
                "https://cdn0-production-images-kly.akamaized.net/8MsufSZxcK3z7KPubZPO2BZZlVo=/1x61:1000x624/1200x675/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/3548108/original/016406500_1629692444-shutterstock_1185115657.jpg", "Bibimbap", 490, true));
        mehFoodList.add(new Food("Gimbap, also romanized as kimbap, is a Korean dish made from cooked rice and ingredients such as vegetables, fish and meats that are rolled in gimâ€”dried sheets of seaweedâ€”and served in bite-sized slices. The origins of gimbap are debated.",
                "https://www.ohmyfoodrecipes.com/wp-content/uploads/2019/10/gimbap-korean-sushi-rolls-stack.jpg", "Gimbap", 97, false));
        mehFoodList.add(new Food("Rendang or randang is an authentic Indonesian meat dish originating from Minangkabau. This dish is made from a long low-temperature cooking process using various spices and coconut milk.",
                "https://cdn-2.tstatic.net/tribunnews/foto/bank/images/resep-rendang.jpg", "Rendang", 468, false));
        mehFoodList.add(new Food("Kerak Telor is a food native to the Jakarta area, with the ingredients of white glutinous rice, chicken or duck eggs, dry roasted ebi plus fried shallots, then seasoned with mashed coconut, red chili, galangal, ginger, peppercorns, salt, and sugar.",
                "https://awsimages.detik.net.id/community/media/visual/2020/06/22/kerak-telor-2.jpeg?w=700&q=90", "Kerak Telor", 169, true));
        mehFoodList.add(new Food("Siomay, is an Indonesian steamed fish dumpling with vegetables served in peanut sauce. It is derived from Chinese Shumai. It is considered a light meal that is a type of Chinese Dim Sum, but is cone shaped. It is traditionally made from pork but frequently substituted with tenggiri fish meat for halal reasons.",
                "https://asset.kompas.com/crops/Atp1STR6jMcegrNX0anTx5eN7xY=/0x0:1000x667/780x390/data/photo/2021/05/23/60aa371ed27a5.jpg", "Siomay", 500, true));
        mehFoodList.add(new Food("Nasi biryani or biriani, beriani, or briyani is a dish of rice cooked with spices and then added with vegetables or meat. This food comes from South Asia. In Indonesia and Malaysia, this dish is called the addition of the word rice.",
                "https://upload.wikimedia.org/wikipedia/commons/5/5a/%22Hyderabadi_Dum_Biryani%22.jpg", "Nasi Briyani", 200, false));
        mehFoodList.add(new Food("Chicken porridge is a type of porridge from Indonesia. Rice porridge is rice cooked with lots of water to have a soft and watery texture. Porridge is usually served hot or warm.",
                "https://img.inews.co.id/files/inews_new/2020/08/31/resep_bubur_ayam_simpel.jpg", "Chicken Porridge", 372, false));
        mehFoodList.add(new Food("Rawon is an Indonesian beef soup. Originating from East Java, rawon utilizes the black keluak nut as the main seasoning, which gives a dark color and nutty flavor to the soup.",
                "https://asset-a.grid.id/crop/0x0:0x0/700x465/photo/2019/07/18/1838279198.jpg", "Nasi Rawon", 680, true));
        mehFoodList.add(new Food("Gudeg is a special dish from Yogyakarta and Central Java Province made from young jackfruit cooked with coconut milk. It takes hours to make this dish. The brown color is usually produced by teak leaves that are cooked together.",
                "https://www.indonesia.travel/content/dam/indtravelrevamp/en/destinations/revisi-2020/thumbnailgudeg.jpg", "Nasi Gudeg", 1027, false));
        mehFoodList.add(new Food("Macaroni schotel or sometimes referred to as macaroni schaal is an Indonesian macaroni casserole dish made of pasta, cheese, milk, butter, meat, sausage, tuna, eggs, onions, mushrooms, and sometimes potatoes. The origin of the dish is European.",
                "https://asset.kompas.com/crops/AaqfT-h8tWbfUd15A1qHKO1s80k=/0x0:1000x667/750x500/data/photo/2020/06/26/5ef58a5834d2f.jpg", "Macaroni Schotel", 720, false));
        mehFoodList.add(new Food("Macaroni and cheeseâ€”also called mac and cheese in the United States and macaroni cheese in the United Kingdomâ€”is a dish of cooked macaroni pasta and a cheese sauce, most commonly cheddar. It can also incorporate other ingredients, such as breadcrumbs or meat.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Original_Mac_n_Cheese_.jpg/800px-Original_Mac_n_Cheese_.jpg", "Mac and Cheese", 164, true));
        mehFoodList.add(new Food("Martabak is a dish commonly found in Saudi Arabia, Yemen, Indonesia, Malaysia, Singapore, and Brunei. Depending on the location, the name and composition of the martabak may vary.",
                "https://www.resepistimewa.com/wp-content/uploads/cara-membuat-martabak-telur.jpg", "Martabak", 431, true));
        mehFoodList.add(new Food("Kue Terang Bulan or apam return in Indonesia is a kind of pancake snack usually sold on the roadside throughout Indonesia, Malaysia, Brunei, and Singapore.",
                "https://wiratech.co.id/wp-content/uploads/2019/07/Resep-Terang-Bulan.jpg", "Kue Terang Bulan", 270, false));
        mehFoodList.add(new Food("A samosa is a fried or baked pastry with a savory filling, including ingredients such as spiced potatoes, onions, peas. It may take different forms, including triangular, cone, or half-moon shapes, depending on the region. Samosas are often accompanied by chutney, and have origins in medieval times or earlier.",
                "https://asset.kompas.com/crops/XCjqsQmq7iHtfMPGr83tts8gRwI=/0x0:1000x667/375x240/data/photo/2020/11/14/5faf2e6209f2f.jpg", "Samosa", 212, true));
        mehFoodList.add(new Food("Asida is a dish made from wheat flour, sometimes with added butter or honey. Like gruel, it is eaten in most North African and Middle Eastern countries.",
                "https://www.newsredaksi.com/wp-content/uploads/2021/08/Screenshot_20210813-121452_Shopee.jpg", "Asida", 24, true));
        mehFoodList.add(new Food("Buko Pandan is a typical Filipino dessert. It is made of gelatin with pandan paste.",
                "https://asset.kompas.com/crops/_8suS7OojDo6oRY3hKOHYFlnJDo=/0x350:666x794/780x390/data/photo/2020/08/16/5f38e525480af.jpg", "Buko Pandan", 1050, true));
        mehFoodList.add(new Food("Nasi Langgi is processed rice with spices along with coconut milk and tamarind. Nasi Langgi comes from the cities of Solo and Semarang, Central Java and DI Yogyakarta. Nasi Langgi has side dishes such as omelet, beefsteak, dried potatoes, meat, serundeng, prawn crackers, liver-fried chili sauce, and cucumber.",
                "https://img.kurio.network/ymdzU1MZuk8na7ON6USAhubrm-A=/1200x1200/filters:quality(80)/https://kurio-img.kurioapps.com/22/01/26/e3b9a23f-3753-45ca-9ac2-4ebe18927b4a.jpe", "Nasi Langgi", 630, false));
        mehFoodList.add(new Food("Salted squid with sambal matah is perfect for those who are just ordinary! The taste of sambal matah, rich in oil and spicy, will make you more literate!",
                "https://img-global.cpcdn.com/recipes/41f3b377356218e3/680x482cq70/cumi-asin-sambal-matah-foto-resep-utama.jpg", "Salted Squid with Sambal Matah", 827, false));
        mehFoodList.add(new Food("Mi Aceh is a spicy noodle dish typical of Aceh in Indonesia. Thick yellow noodles with sliced â€‹â€‹beef, mutton, or seafood are served in a savory and spicy curry-type soup. Mi Aceh is usually topped with fried onions and served with emping, sliced â€‹â€‹shallots, cucumber, and lime.",
                "https://assets.pikiran-rakyat.com/crop/0x0:0x0/x/photo/2021/11/02/3111261266.jpg", "Mi Aceh", 476, false));
        mehFoodList.add(new Food("Sate taichan is a variant of satay that contains grilled chicken meat without garnishing with peanut sauce or soy sauce like satay in general.",
                "https://www.masakapahariini.com/wp-content/uploads/2019/01/sate-taichan-6.jpg", "Sate Taichan", 149, false));
        mehFoodList.add(new Food("Tteokbokki, or simmered rice cake, is a popular Korean food made from small-sized garae-tteok called tteokmyeon or commonly tteokbokki-tteok. Eomuk, boiled eggs, and scallions are some common ingredients paired with tteokbokki in dishes.",
                "https://awsimages.detik.net.id/community/media/visual/2020/10/19/tteokbokki_43.jpeg?w=700&q=90", "Tteokbokki", 359, false));
        mehFoodList.add(new Food("Kimchi-jjigae or kimchi stew is a jjigae, or stew-like Korean dish, made with kimchi and other ingredients, such as pork or seafood, scallions, onions, and diced dubu. It is one of the most common stews in Korean cuisine.",
                "https://www.cookerru.com/wp-content/uploads/2021/05/kimchi-stew-recipe-card.jpg", "Kimchi-jjigae", 166, true));
        mehFoodList.add(new Food("Kimchi fried rice or kimchi-bokkeum-bap is a variety of bokkeum-bap, a popular dish in South Korea. Kimchi fried rice is made primarily with kimchi and rice, along with other available ingredients, such as diced vegetables or meats like spam",
                "https://www.recipetineats.com/wp-content/uploads/2021/03/Kimchi-Fried-Rice-Skillet.jpg", "Kimchi Fried Rice", 305, false));
        mehFoodList.add(new Food("Zuppa toscana is a broad based term, literally meaning \"Tuscan soup\" but in Italy it is called \"Minestra di Pane\" meaning \"Bread Soup\".",
                "https://truffle-assets.imgix.net/1993b40d-vid52636-zuppa-soup-vegetarian-l.jpg", "Zuppa Soup", 430, false));
    }

    public ArrayList<Food> getList() {
        return mehFoodList;
    }
}
