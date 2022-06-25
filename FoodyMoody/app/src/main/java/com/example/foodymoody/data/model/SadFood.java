package com.example.foodymoody.data.model;

import com.example.foodymoody.data.Food;

import java.util.ArrayList;

public class SadFood {
    public static ArrayList<Food> sadFoodList = new ArrayList<Food>();

    public SadFood(){
        //reset
        sadFoodList.clear();

        //food - > description, image (copy image address dari google image), name, calories per serving, allergen (boolean)
        sadFoodList.add(new Food("Indomie is a brand of instant noodle produced by the Indonesian company Indofood.",
                "https://resepkoki.id/wp-content/uploads/2020/11/Resep-Indomie-Goreng.jpg","Indomie", 350, false));
        sadFoodList.add(new Food("sweet food made from flour, sugar, and other ingredients, that is usually baked.",
                "https://www.hummingbirdhigh.com/wp-content/uploads/2020/05/01_Rainbow-Unicorn-Cake_IMG_0008.jpg","Cake", 257, true));
        sadFoodList.add(new Food(" is a sweetened frozen food typically eaten as a snack or dessert. It may be made from milk or cream and is flavoured with a sweetener, either sugar or an alternative, and a spice, such as cocoa or vanilla, or with fruit such as strawberries or peaches.",
                "https://www.thespruceeats.com/thmb/btLT5e97Xl3vBzNo37xPlUgfQcI=/3135x3900/filters:fill(auto,1)/GettyImages-90053856-588b7aff5f9b5874ee534b04.jpg","Ice cream", 208, true));
        sadFoodList.add(new Food("Bananas have a high level of vitamin b content that can lower depression in your body. Also, tryptophan levels increase the level of the hormone serotonin, the hormone in charge of bringing out the mood.",
                "https://img.okezone.com/content/2020/05/15/298/2214844/ciri-ciri-pisang-matang-sempurna-bReK2YGBA0.jpg", "Banana", 89, false));
        sadFoodList.add(new Food("Dark chocolate can slow the production of stress hormones, and automated stress levels can also lessen. It is because chocolate releases brain endorphins and increases serotonin levels. It will create a sense of happiness that can last for a few hours.",
                "https://awsimages.detik.net.id/community/media/visual/2016/11/01/65982aec-dcc5-428d-ba60-b464f272c89d_169.jpg?w=700&q=90", "Chocolate", 545, true));
        sadFoodList.add(new Food("Salmon pack as many omegas 3 known to fight mood swings and depression.",
                "https://cdn1-production-images-kly.akamaized.net/NS9MkU7JwDoOQKemciR7UQpizAU=/1200x1200/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/1591774/original/054597500_1494573556-Ikan-Salmon5.jpg", "Salmon", 208, true));
        sadFoodList.add(new Food("The egg has many vitamins d can help ward off the mind of depression and help with weight loss.",
                "https://cdn.apartmenttherapy.info/image/upload/f_jpg,q_auto:eco,c_fill,g_auto,w_1500,ar_1:1/k%2FPhoto%2FRecipes%2F2020-02-How-To-Hard-Boiled-Egg%2FHT-Hard-Boiled-Egg_065", "Egg", 155, true));
        sadFoodList.add(new Food("Besides overcoming sleepiness, coffee has a caffeine content that can use to maintain the mood.",
                "https://www.tastingtable.com/img/gallery/20-different-types-of-coffee-explained/intro-1646842160.jpg", "Coffee", 0, false));
        sadFoodList.add(new Food("Pasta turns out to have an advantage in discharging a bad mood by turning it into a happy hormone or endorphins in the body.",
                "https://www.vegrecipesofindia.com/wp-content/uploads/2021/06/fettuccine-alfredo-1.jpg", "Pasta", 131, false));
        sadFoodList.add(new Food("The benefit of avocado is to stimulate mood, and avocado has folic acid and phytonutrient content. Two levels of the substance can inhibit hormones from manifesting themselves so that the hormones that form eventually become a good mood.",
                "https://cdn-2.tstatic.net/tribunnews/foto/bank/images/ilustrasi-buah-alpukat-ilustrasi-alpukat.jpg", "Avocado", 160, false));
        sadFoodList.add(new Food("The klappertaart is a typical Manado dish that contains coconut inside. The coconut meat helps to build up the mood to be very good.",
                "https://asset.kompas.com/crops/Uf4RqKhpruCZJ9ObdXxJ3frvYaw=/0x165:1000x832/750x500/data/photo/2020/12/17/5fdabdad306f5.jpg", "Klappertaart", 182, true));
        sadFoodList.add(new Food("Coconut water has long coped with the problem of dehydration. This coconut water is full of electrolytes that will boost the mood instantly.",
                "https://images.immediate.co.uk/production/volatile/sites/30/2017/08/coconut-water-bb9cfe8.jpg", "Coconut Water", 19, false));
        sadFoodList.add(new Food("Strawberry cake will help you with the grief! Because strawberry has a nutrient capable of raising chemicals in the brain, you're in a better mood!",
                "https://celebratingsweets.com/wp-content/uploads/2018/06/Strawberry-Shortcake-Cake-1-1.jpg", "Strawberry Cake", 191, true));
        sadFoodList.add(new Food("Strawberry milkshake will help you with the grief! Because strawberry has a nutrient capable of raising chemicals in the brain, you're in a better mood!",
                "https://www.unicornsinthekitchen.com/wp-content/uploads/2021/07/Strawberry-Milkshake-2.1200px-1-of-1.jpg", "Strawberry Milkshake", 268, true));
        sadFoodList.add(new Food("Spicy chicken feet could help our mood get better. Studies suggest that foods supplemented with hot peppers may increase the hormone endorphins that can boost the mood and make you happier.",
                "https://sweetrip.id/wp-content/uploads/2022/02/resep-ceker-setan.jpg", "Spicy Chicken Feet", 212, true));
        sadFoodList.add(new Food("Oseng Mercon is made of soft dumplings or ingests, as the main ingredients are processed with an abundance of ingredients and cayenne peppers. Studies suggest that foods supplemented with hot peppers may increase the hormone endorphins that can boost the mood and make you happier.",
                "https://www.dapurawit.com/wp-content/uploads/2021/03/Resep-Oseng-Mercon-Sapi-Khas-Jogja.jpg", "Oseng-Oseng Mercon", 512, true));
        sadFoodList.add(new Food("Chicken Fire could help our mood get better. Studies suggest that foods supplemented with hot peppers may increase the hormone endorphins that can boost the mood and make you happier.",
                "https://assets.pikiran-rakyat.com/crop/0x0:0x0/x/photo/2021/11/11/1288881854.jpg", "Chicken Fire", 380, true));
        sadFoodList.add(new Food("Mashed potato is a silky, mashed potato food containing the chemical chromium. It helps to raise serotonin levels in the brain. It is this serotonin that serves as a cheerful and comfortable giver.",
                "https://resepkoki.id/wp-content/uploads/2017/06/Resep-Mashed-potato.jpg", "Mashed Potato", 88, true));
        sadFoodList.add(new Food("Almond milk can help you fix your broken mood! Because they have almonds inside, they contain magnesium that can help relieve depression.",
                "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2019/07/Blog_Manfaat-Susu-Almond-Tingkatkan-Produksi-ASI-hingga-Perkuat-Imun.jpeg", "Almond Milk", 40, true));
        sadFoodList.add(new Food("Almond Pudding can help you fix your broken mood! Because they have almonds inside, they contain magnesium that can help relieve depression.",
                "https://i0.wp.com/jazzyvegetarian.com/wp-content/uploads/2020/08/ALMOND-PUDDING-2-309.jpg?fit=1920%2C1280&ssl=1", "Almond Pudding", 294, true));
        sadFoodList.add(new Food("Avocado Juice is the best choice for you! avocado has folic acid and phytonutrient content. Two levels of the substance can inhibit hormones from manifesting themselves so that the hormones that form eventually become a good mood.",
                "https://4.bp.blogspot.com/--jyaYCACn_c/XPDx3zMNV3I/AAAAAAAADOM/atipuNpHrfkXANTj0gb6bCrwliwDOb4jwCLcBGAs/s1600/how-to-make-avocado-juice-.jpg", "Avocado Juice", 184, true));
        sadFoodList.add(new Food("Avocado Grilled Cheese Sandwich is the best choice for you! avocado has folic acid and phytonutrient content. Two levels of the substance can inhibit hormones from manifesting themselves so that the hormones that form eventually become a good mood.",
                "https://healthynibblesandbits.com/wp-content/uploads/2019/09/Kimchi-Avocado-Grilled-Cheese-FF.jpg", "Avocado Grilled Cheese Sandwich", 204, true));
        sadFoodList.add(new Food("Avocado Sushi Roll is the best choice for you! avocado has folic acid and phytonutrient content. Two levels of the substance can inhibit hormones from manifesting themselves so that the hormones that form eventually become a good mood.",
                "https://foodwithfeeling.com/wp-content/uploads/2021/09/avocado-roll-3.jpg", "Avocado Sushi Roll", 140, true));
        sadFoodList.add(new Food("Salmon Sushi Roll has the best taste! It contains salmon pack as many omegas 3 known to fight mood swings and depression.",
                "https://content.fun-japan.jp/renewal-prod/cms/articles/content/62ac73450a284663dc84adf5af7fa1a89f07aa31_2021-02-25-10-42-49.jpg", "Salmon Sushi Roll", 37, true));
        sadFoodList.add(new Food("Do you like yogurt? He's the right choice for you! It is an average fermented food that contains good probiotics for the body's digestion. When your body's digestive system is fluent, your days are no doubt enjoyable.",
                "https://awsimages.detik.net.id/community/media/visual/2020/01/09/b528a9f3-307f-45ca-bbda-8528cd6d48a8_43.jpeg?w=700&q=90", "Yoghurt", 59, true));
        sadFoodList.add(new Food("Kimchi is an average fermented food that contains good probiotics for the body's digestion. When your body's digestive system is fluent, your days are no doubt enjoyable.",
                "https://awsimages.detik.net.id/community/media/visual/2020/01/31/346606e6-5f97-45dd-a380-7356df9b4560_169.jpeg?w=700&q=90", "Kimchi", 22, false));
        sadFoodList.add(new Food("Miso is a Japanese foodstuff made from the fermentation of soy, rice, or a mixture of both beans and salt. It is an average fermented food that contains good probiotics for the body's digestion. When your body's digestive system is fluent, your days are no doubt enjoyable.",
                "https://asset.kompas.com/crops/6-O6QcKH3WScWaJNOvRpWHbauzs=/0x0:1000x667/780x390/data/photo/2020/04/28/5ea7fa27b91ff.jpg", "Miso Soup", 84, true));
        sadFoodList.add(new Food("Tempe is a typical Indonesian food made from soybean fermentation. It is an average fermented food that contains good probiotics for the body's digestion. When your body's digestive system is fluent, your days are no doubt enjoyable.",
                "https://cdn0-production-images-kly.akamaized.net/G8MNimwOOwYyKOsC9ayApb--cnw=/0x345:5792x3610/673x373/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/3493625/original/011678000_1624676204-shutterstock_1985813441.jpg", "Tempe", 193, true));
        sadFoodList.add(new Food("Natto antibiotics is a traditional Japanese food made from fermented soybeans with Bacillus subtilis, usually eaten for breakfast.",
                "https://res.cloudinary.com/dk0z4ums3/image/upload/v1634567087/attached_image/mengenal-7-manfaat-natto-untuk-kesehatan-tubuh.jpg", "Natto", 212, true));
        sadFoodList.add(new Food("Chocolate Brownies is the best choice! Chocolate can slow the production of stress hormones, and automated stress levels can also lessen. It is because chocolate releases brain endorphins and increases serotonin levels. It will create a sense of happiness that can last for a few hours.",
                "https://cdn1-production-images-kly.akamaized.net/k07KprqRap2_8lVUKHJ7yDU6LYg=/0x0:5184x2922/1200x675/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/3638248/original/016300500_1637376593-shutterstock_749044213.jpg", "Chocolate Brownies", 129, true));
        sadFoodList.add(new Food("Banana Cake is so yummy for your condition! Bananas have a high level of vitamin b content that can lower depression in your body. Also, tryptophan levels increase the level of the hormone serotonin, the hormone in charge of bringing out the mood.",
                "https://hips.hearstapps.com/vidthumb/images/delish-banana-cake-4-1535137229.jpg", "Banana Cake", 173, true));
        sadFoodList.add(new Food("Salad is a healthy meal for you! Many hormones the body produces after salad contain such green vegetables as serotonin, dopamine, to noradrenaline that will boost the mood.",
                "https://cdn0-production-images-kly.akamaized.net/1r1yIlIDrhHyNO5e8vciczca4F8=/598x0:1931x1333/1200x1200/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/3256671/original/016360300_1601695315-salad_sayur.jpg", "Salad", 108, true));
        sadFoodList.add(new Food("Tumis Kangkung or Cah Kangkung is a stir-fried vegetable dish commonly found in Asian dishes. Many hormones the body produces after salad contain such green vegetables as serotonin, dopamine, to noradrenaline that will boost the mood.",
                "https://blue.kumparan.com/image/upload/fl_progressive,fl_lossy,c_fill,q_auto:best,w_640/v1616802951/gnvklpvjqvd5ssjgmbjj.jpg", "Cah Kangkung", 92, false));
    }

    public ArrayList<Food> getList() {
        return sadFoodList;
    }
}
