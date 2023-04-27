package fr.mariech.tp.resources;

import fr.mariech.tp.model.Category;

public class RecipeDto {

    long id;
    String name;
    String text;
    Category category;
    String image;


    public RecipeDto() {
    }

    public RecipeDto(long id, String name, String text, String image, Category category) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.image = image;
        this.category = category;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", category=" + category +
                ", image='" + image + '\'' +
                '}';
    }
}
