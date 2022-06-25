package com.example.foodymoody.data.model;

import com.example.foodymoody.data.Food;

import java.util.ArrayList;
import java.util.List;

public class HappyFood {
    public static ArrayList<Food> happyFoodList = new ArrayList<Food>();;

    public HappyFood(){
        //reset
        happyFoodList.clear();

        //food - > description, image (copy image address dari google image), name, calories per serving, possible allergic (boolean)
        happyFoodList.add(new Food("also known as Terang Bulan is originally a thick and sweet pancake that is usually topped with various toppings ranging from chocolate, cheese, peanuts, condensed milk, sesame seed and margarine.",
                "https://images.genpi.co/uploads/news/normal/2019/06/18/46189b8e54bf5835306250da9f4d47cd.jpg","Martabak Manis", 0, false));
        happyFoodList.add(new Food("is one of the most popular fruits. Contains essential nutrients that can have a protective impact on health.",
                "https://www.collinsdictionary.com/images/full/banana_64728013.jpg","Banana", 0, false));
        happyFoodList.add(new Food("is a type of bread made using flour that is partly or entirely milled from whole or almost-whole wheat grains, see whole-wheat flour and whole grain.",
                "https://media.self.com/photos/5daa23395c250800081afa68/4:3/w_2560%2Cc_limit/sprouted-whole-grain-bread.jpg","Wheat Bread", 0, false));
        happyFoodList.add(new Food("a Korean soup whose main ingredient is miyeok, or seaweed.",
                "https://i.ytimg.com/vi/znpwSp0Ro2I/maxresdefault.jpg","Seaweed Soup", 0, false));
        happyFoodList.add(new Food("Refreshing juice made with fresh blueberries, lemon juice and water.",
                "https://cdn3.foodviva.com/static-content/food-images/juice-recipes/blueberry-juice-recipe/blueberry-juice-recipe.jpg","Blueberry Juice", 0, false));
        happyFoodList.add(new Food("is a popular beverage that also offers a variety of health benefits.",
                "https://post.healthline.com/wp-content/uploads/2020/09/chamomile-tea-thumb-1-732x549.jpg","Chamomile tea", 0, false));
        happyFoodList.add(new Food("is a dish with a very mild 'ocean' flavor with a faintly sweet, mushroom-like undertone.",
                "https://thecozyapron.com/wp-content/uploads/2021/02/steamed-mussels_thecozyapron_1.jpg","Steamed Mussels", 0, false));
        happyFoodList.add(new Food("is a form of chocolate containing cocoa solids and cocoa butter, without the milk or butter found in milk chocolate.",
                "https://awsimages.detik.net.id/community/media/visual/2018/06/11/56cddff4-0ebd-4b2b-87bf-472459c03847.jpeg?w=848","Dark Chocolate", 0, false));
        happyFoodList.add(new Food("is a dairy product made by fermenting milk with a yogurt culture.",
                "https://www.pngall.com/wp-content/uploads/2/Yogurt-PNG-File-Download-Free.png","Yogurt", 0, false));
        happyFoodList.add(new Food("a flat cake, often thin and round, prepared from a starch-based batter that may contain eggs, milk and butter, with honey poured on top.",
                "https://denewlanmarkhotel.com/wp-content/uploads/2020/06/pancakes-and-honey.jpg","Honey Pancake", 0, false));
        happyFoodList.add(new Food("is a type of tea that is made from Camellia sinensis leaves and buds that have not undergone withering and oxidation process.",
                "https://linisehat.com/wp-content/uploads/2020/12/green-tea-recipe-12_16_072397.jpg","Green tea", 0, false));
        happyFoodList.add(new Food("is a leafy green vegetable that originated in Persia. It's considered very healthy, as it's loaded with nutrients and antioxidants",
                "https://www.simplyrecipes.com/thmb/d_ANlu0sNrAHeajkRkcdOXm4X9Q=/1072x1072/smart/filters:no_upscale()/__opt__aboutcom__coeus__resources__content_migration__simply_recipes__uploads__2010__06__spinach-seame-garlic-horiz-a-1600-0ebe05cbfb8d4e7c974a550727eeb6b4.jpg","Spinach", 0, false));
        happyFoodList.add(new Food("a fruit, botanically a berry, of the deciduous woody vines of the flowering plant genus Vitis.",
                "https://www.collinsdictionary.com/images/full/grape_229112122.jpg","Grapes", 0, false));
        happyFoodList.add(new Food("Baked, seasoned salmon with salt and pepper.",
                "https://i2.wp.com/www.downshiftology.com/wp-content/uploads/2021/01/Baked-Salmon-8.jpg","Baked Salmon", 0, false));
        happyFoodList.add(new Food("is a dish consists of a slice of raw salmon served over pressed vinegar rice.",
                "https://cdn.tasteatlas.com/images/dishes/ef30d84ca9f04834917378c56630c6da.jpg","Salmon Nigiri", 0, false));
        happyFoodList.add(new Food("roasted crab served with hot butter and olive oil mixture.",
                "https://rasamalaysia.com/wp-content/uploads/2019/08/roasted-dungeness-crab1.jpg","Roasted Crab", 0, false));
        happyFoodList.add(new Food("is a type of Chinese cabbage, that has smooth, wide, flat leaf blades, served with garlic.",
                "https://assets.bonappetit.com/photos/57adbf2c1b33404414975665/1:1/w_2560%2Cc_limit/BOK-CHOY.jpg","Garlic Bok Choy", 0, false));
        happyFoodList.add(new Food("is a dish of beef that is roasted, generally served as the main dish of a meat.",
                "https://hips.hearstapps.com/hmg-prod/images/delish-roast-beef-horizontal-1540505165.jpg","Roast Beef", 0, false));
        happyFoodList.add(new Food("is a dish consisting of chicken pieces that have been coated with seasoned flour or batter and pan-fried, deep fried, pressure fried, or air fried.",
                "https://thestayathomechef.com/wp-content/uploads/2016/06/Fried-Chicken-4-1.jpg","Fried Chicken", 0, false));
        happyFoodList.add(new Food("is a Japanese dish of fried chicken made with panko bread crumbs.",
                "https://static01.nyt.com/images/2021/05/23/dining/kc-chicken-katsu/merlin_185308080_a60a6563-292e-4f52-a33b-386113aca0b2-articleLarge.jpg","Chicken Katsu", 0, false));
        happyFoodList.add(new Food("is a type of bread made with raisins and flavored with cinnamon.",
                "https://www.seasonsandsuppers.ca/wp-content/uploads/2020/10/raisin-bread-1200.jpg","Raisin Bread", 0, false));
        happyFoodList.add(new Food("is a drink made from water, sugars, organic acids (principally citric acid) and small amounts of amino acids, vitamins and phenolic compounds.",
                "https://assets.epicurious.com/photos/54e658004f77a310045d66d4/16:9/w_2560%2Cc_limit/6x4.jpg","Lemon Juice", 0, false));
        happyFoodList.add(new Food("is a type of bread made with raisins and flavored with cinnamon.",
                "https://www.seasonsandsuppers.ca/wp-content/uploads/2020/10/raisin-bread-1200.jpg","Raisin Bread", 0, false));
        happyFoodList.add(new Food("is a dish from Albacore Tuna that is seasoned with sesame seeds and a ginger soy sauce marinade.",
                "https://cdn.shopify.com/s/files/1/0305/5921/articles/albacore-chimichurri_1800x.jpg?v=1576092138","Seared Albacore Tuna", 0, false));
        happyFoodList.add(new Food("is a whole grain rice with the inedible outer hull removed.",
                "https://www.recipetineats.com/wp-content/uploads/2020/09/Perfectly-Cooked-Brown-Rice_7-SQ.jpg","Brown Rice", 0, false));
        happyFoodList.add(new Food("is a dish with golden crispy skin and delicious flavor. Usually served with steamed rice, miso soup, or salad",
                "https://family-friends-food.com/wp-content/uploads/2016/07/2.jpg","Grilled Mackerel", 0, false));
        happyFoodList.add(new Food("is a dish with many nutrients, including fiber, vitamin C, vitamin K, iron, and potassium",
                "https://healthyrecipesblogs.com/wp-content/uploads/2012/09/steamed-broccoli-featured-2021.jpg","Steamed Broccoli", 0, false));
        happyFoodList.add(new Food("baked oyster with garlic butter",
                "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2016/10/4/5/CCUPR111H_Grilled-oysters-with-butter-and-garlic-sauce_s4x3.jpg.rend.hgtvcom.616.462.suffix/1482195668153.jpeg","Garlic Oyster", 0, false));
        happyFoodList.add(new Food("is a type of open sandwich consisting of toast with mashed avocado, and usually salt, black pepper, and sometimes citrus juice",
                "https://gimmedelicious.com/wp-content/uploads/2016/07/avocado-toast-7-of-13.jpg","Avocado Toast", 0, false));
        happyFoodList.add(new Food("is a most commonly the small spherical seed or the seed-pod of the pod fruit Pisum sativum",
                "https://theclevermeal.com/wp-content/uploads/2021/03/pea-recipes_01.jpg","Peas", 0, false));
    }

    public ArrayList<Food> getList() {
        return happyFoodList;
    }
}
