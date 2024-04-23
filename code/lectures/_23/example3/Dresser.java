package lectures._23.example3;

import java.util.ArrayList;

public class Dresser implements ClothesContainer
{
    private ArrayList<Clothing> clothes = new ArrayList<>();


    @Override
    public Clothing getClothingArticle() {
        var article = this.clothes.getLast();

        this.clothes.removeLast();

        return article;
    }

    @Override
    public void returnClothingArticle(Clothing article) {
        this.clothes.add(article);
    }
}
