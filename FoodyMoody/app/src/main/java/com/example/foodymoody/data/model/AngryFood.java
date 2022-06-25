package com.example.foodymoody.data.model;

import com.example.foodymoody.data.Food;

import java.util.ArrayList;

public class AngryFood {
    public static ArrayList<Food> angryFoodList = new ArrayList<Food>();

    public AngryFood(){
        // reset
        angryFoodList.clear();


        // food - > description, image (copy image address dari google image), name, calories per serving, is allergen (boolean)
        angryFoodList.add(new Food("is an Indonesian crispy battered fried chicken crushed and mixed with hot and spicy sambal.",
                "https://sweetrip.id/wp-content/uploads/2020/06/eatricebowl.id_104344746_939701739827278_1901979797285982520_n.jpg","Ayam Geprek", 0, false));
        angryFoodList.add(new Food("is an Sundanese savoury and spicy dish, originating from West Java, Indonesia. Made of wet krupuk (traditional Indonesian crackers) cooked with protein sources (egg, chicken, seafood or beef) in spicy sauce.",
                "https://cdn-cas.orami.co.id/parenting/images/Selak_kerupak_basah.width-800.jpg","Seblak", 0, false));
        angryFoodList.add(new Food("is a dairy product made by fermenting milk with a yogurt culture.",
                "https://www.pngall.com/wp-content/uploads/2/Yogurt-PNG-File-Download-Free.png","Yogurt", 0, false));
        angryFoodList.add(new Food("is one of the most popular fruits. Contains essential nutrients that can have a protective impact on health.",
                "https://www.collinsdictionary.com/images/full/banana_64728013.jpg","Banana", 0, false));
        angryFoodList.add(new Food("is a popular beverage that also offers a variety of health benefits.",
                "https://post.healthline.com/wp-content/uploads/2020/09/chamomile-tea-thumb-1-732x549.jpg","Chamomile tea", 0, false));
        angryFoodList.add(new Food("is a type of tea that is made from Camellia sinensis leaves and buds that have not undergone withering and oxidation process.",
                "https://linisehat.com/wp-content/uploads/2020/12/green-tea-recipe-12_16_072397.jpg","Green tea", 0, false));
        angryFoodList.add(new Food("is a common food fish classified as an oily fish with a rich content of protein and omega-3 fatty acids.",
                "https://www.onceuponachef.com/images/2018/02/pan-seared-salmon-.jpg","Salmon", 0, false));
        angryFoodList.add(new Food("is a dish made from beaten eggs, fried with butter or oil in a frying pan.",
                "https://img-global.cpcdn.com/recipes/52a433e2e240e5b0/1200x630cq70/photo.jpg","Omellete", 0, false));
        angryFoodList.add(new Food("is a leafy green vegetable that originated in Persia. It's considered very healthy, as it's loaded with nutrients and antioxidants",
                "https://www.simplyrecipes.com/thmb/d_ANlu0sNrAHeajkRkcdOXm4X9Q=/1072x1072/smart/filters:no_upscale()/__opt__aboutcom__coeus__resources__content_migration__simply_recipes__uploads__2010__06__spinach-seame-garlic-horiz-a-1600-0ebe05cbfb8d4e7c974a550727eeb6b4.jpg","Spinach", 0, false));
        angryFoodList.add(new Food("is a species of tree native to Iran and surrounding countries and ancient remains of almonds were discovered in the Levant area.",
                "https://koran-jakarta.com/images/article/banyak-orang-yang-belum-mengetahui-efek-rahasia-makan-almond-210820172245.","Almond", 0, false));
        angryFoodList.add(new Food("is a dish made from eggs stirred, whipped or beaten together while being gently heated, typically with salt, butter, oil and sometimes other ingredients.",
                "https://bakeitwithlove.com/wp-content/uploads/2021/12/scrambled-eggs-sq.jpg","Scrammbled Eggs", 0, false));
        angryFoodList.add(new Food("is a form of chocolate containing cocoa solids and cocoa butter, without the milk or butter found in milk chocolate.",
                "https://awsimages.detik.net.id/community/media/visual/2018/06/11/56cddff4-0ebd-4b2b-87bf-472459c03847.jpeg?w=848","Dark Chocolate", 0, false));
        angryFoodList.add(new Food("is a dish made from celery, chicken and other various spices.",
                "https://img-global.cpcdn.com/recipes/98c68c54599c81a2/680x482cq70/ayam-pedas-seledri-foto-resep-utama.jpg","Celery Chicken", 0, false));
        angryFoodList.add(new Food("is a Swiss melted cheese dish served in a communal pot over a portable stove heated with a candle or spirit lamp, and eaten by dipping bread into the cheese using long-stemmed forks.",
                "https://images-gmi-pmc.edge-generalmills.com/925f6a1e-d9f4-48ef-980f-344caa080558.jpg","Cheese Fondue", 0, false));
        angryFoodList.add(new Food("is an Indonesian vegetable soup prepared from vegetables in coconut milk popular in Indonesia, but most often associated with Javanese cuisine.",
                "https://awsimages.detik.net.id/community/media/visual/2020/09/16/resep-sayur-lodeh-jawa.jpeg?w=1200","Sayur Lodeh", 0, false));
        angryFoodList.add(new Food("is an Indonesian vegetable soup. It is a popular Southeast Asian dish originating from Sundanese cuisine, consisting of vegetables in tamarind soup.",
                "https://harianresep.com/wp-content/uploads/2020/06/resep-sayur-asem.jpg","Sayur Asem", 0, false));
        angryFoodList.add(new Food("is a dish from Albacore Tuna that is seasoned with sesame seeds and a ginger soy sauce marinade.",
                "https://cdn.shopify.com/s/files/1/0305/5921/articles/albacore-chimichurri_1800x.jpg?v=1576092138","Seared Albacore Tuna", 0, false));
        angryFoodList.add(new Food("is a dish consists of a slice of raw salmon served over pressed vinegar rice.",
                "https://cdn.tasteatlas.com/images/dishes/ef30d84ca9f04834917378c56630c6da.jpg","Salmon Nigiri", 0, false));
        angryFoodList.add(new Food("is a dish made from anchovies.",
                "https://www.thespruceeats.com/thmb/24ADOWEWM2W6j_-op0pBpj7uREU=/4179x3134/smart/filters:no_upscale()/spanish-fried-anchovies-recipe-3083690-hero-01-ac8008258e724f4d996c2995197341e3.jpg","Fried Anchovies", 0, false));
        angryFoodList.add(new Food("is a dish of cooked macaroni pasta and a cheese sauce, most commonly cheddar.",
                "https://www.seriouseats.com/thmb/MgCg01fCfA766HbksuciYfSRcok=/1500x1125/filters:fill(auto,1)/__opt__aboutcom__coeus__resources__content_migration__serious_eats__seriouseats.com__2021__02__20210214-stovetop-mac-cheese-reshoot-vicky-wasik-9-0760b642ca704cf8b2c5121a363a60a2.jpg","Mac and Cheese", 0, false));
        angryFoodList.add(new Food("is a liquid extract of the orange tree fruit, produced by squeezing or reaming oranges.",
                "https://www.alphafoodie.com/wp-content/uploads/2020/11/Orange-Juice-1-of-1.jpeg","Orange Juice", 0, false));
        angryFoodList.add(new Food("is a seed of the sunflower.",
                "https://www.ubuy.co.id/productimg/?image=aHR0cHM6Ly9tLm1lZGlhLWFtYXpvbi5jb20vaW1hZ2VzL0kvNjFFdUhrNzArb0wuX1NMMTQwMF8uanBn.jpg","Sunflower Seed", 0, false));
        angryFoodList.add(new Food("is an excellent source of omega 3 fatty acids that can give your immunity a significant boost.",
                "https://static01.nyt.com/images/2014/04/23/dining/23WALNUT_SPAN/23WALNUT-articleLarge.jpg","Walnut Bread", 0, false));
        angryFoodList.add(new Food("is a type of Chinese cabbage, that has smooth, wide, flat leaf blades, served with garlic.",
                "https://assets.bonappetit.com/photos/57adbf2c1b33404414975665/1:1/w_2560%2Cc_limit/BOK-CHOY.jpg","Garlic Bok Choy", 0, false));
        angryFoodList.add(new Food("is a dish consisting of chicken pieces that have been coated with seasoned flour or batter and pan-fried, deep fried, pressure fried, or air fried.",
                "https://thestayathomechef.com/wp-content/uploads/2016/06/Fried-Chicken-4-1.jpg","Fried Chicken", 0, false));
        angryFoodList.add(new Food("is a Japanese dish of fried chicken made with panko bread crumbs.",
                "https://static01.nyt.com/images/2021/05/23/dining/kc-chicken-katsu/merlin_185308080_a60a6563-292e-4f52-a33b-386113aca0b2-articleLarge.jpg","Chicken Katsu", 0, false));
        angryFoodList.add(new Food("is a dish where the fish is cooked quickly over medium or high heat coals or over burners set to medium or high heat on a gas grill.",
                "https://s6890.pcdn.co/wp-content/uploads/2012/10/dsc_0017_edited-1.jpg","Grilled Fish", 0, false));
        angryFoodList.add(new Food("is a dish with a very mild 'ocean' flavor with a faintly sweet, mushroom-like undertone.",
                "https://thecozyapron.com/wp-content/uploads/2021/02/steamed-mussels_thecozyapron_1.jpg","Steamed Mussels", 0, false));
        angryFoodList.add(new Food("is a dish consists of an outer pastry crust filled with egg custard.",
                "https://img.buzzfeed.com/video-api-prod/assets/18da0a2f7c65489abdaaa1767aba847a/BFV6265_EggTart_FB_Thumbnail.jpg","Egg Tart", 0, false));
        angryFoodList.add(new Food("choy sum mixed with light sauce made from soy sauce and a lot of garlic.",
                "https://yupitsvegan.com/wp-content/uploads/2018/06/choy-sum-stir-fry-square.jpg","Stir-Fry Choy Sum", 0, false));
    }

    public ArrayList<Food> getList() {
        return angryFoodList;
    }
}
