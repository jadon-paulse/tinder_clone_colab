public class ImageBuilder {
    private String url;
    private String title;
    private String description;

    public ImageBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public ImageBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public ImageBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Image createImage() {
        return new Image(url, title, description);
    }
}