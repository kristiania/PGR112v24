package lectures._23.example3;

import java.util.ArrayList;

public class Wardrobe implements ClothesContainer
{
    private ArrayList<Clothing> clothes = new ArrayList<>();


    @Override
    public Clothing getClothingArticle() {
        var article = this.clothes.getFirst();

        this.clothes.removeFirst();

        return article;
    }

    @Override
    public void returnClothingArticle(Clothing article) {
        this.clothes.add(article);
    }
}
