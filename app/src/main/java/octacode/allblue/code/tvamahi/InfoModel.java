package octacode.allblue.code.tvamahi;

public class InfoModel {

    private String title,description;
    private int imageAddr;

    public InfoModel(String title,String description,int imageAddr){
        this.title = title;
        this.description = description;
        this.imageAddr = imageAddr;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageAddr() {
        return imageAddr;
    }
}
