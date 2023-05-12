package in.nareshtech.samachar.model;

public class Article {
    private String title;
    private String content;
    private String author;
    private String date;
    private String url;
    private String imageUrl;
    private String readMoreUrl;

    public Article() {
    }

    public Article(String title, String content, String author, String date, String url, String imageUrl, String readMoreUrl) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.url = url;
        this.imageUrl = imageUrl;
        this.readMoreUrl = readMoreUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getReadMoreUrl() {
        return readMoreUrl;
    }
}
