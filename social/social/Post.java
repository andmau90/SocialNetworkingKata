package social;

import java.util.Date;

public class Post{
	private String author;
	private String text;
    private Date date;

    public Post( String text, String author ){
        this.text = text;
        this.author = author;
        date = new Date();
    }

    public String getAuthor() {
    	return author;
    }
    
    public String getText(){
        return text;
    }

    public Date getDate(){
        return date;
    }

    @Override
    public String toString(){
        return text + " (" + DateUtils.getDateString( date ) + ")";
    }
    
    public String toPost(){
    	return getAuthor() + " - " + toString();
    }
}