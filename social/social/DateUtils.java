package social;

import java.util.Date;

public class DateUtils {
	public static String getDateString( Date dateToConvert ){
        String date = "";
        int timeInSeconds = ( int ) ( ( new Date().getTime() - dateToConvert.getTime() ) / 1000 );
        int timeInMinutes = timeInSeconds / 60;
        int timeInHours = timeInMinutes / 60;
        int timeInDays = timeInHours / 24;
        int timeInMonth = timeInDays / 30;
        int timeInYear = timeInMonth / 12;

        if( timeInSeconds < 60 ){
            if( timeInSeconds <= 1 ){
                date = "1 second ago";
            }
            else{
                date = timeInSeconds + " seconds ago";
            }
        }
        else if( timeInMinutes < 60 ){
            if( timeInMinutes <= 1 ){
                date = "1 minute ago";
            }
            else{
                date = timeInMinutes + " minutes ago";
            }
        }
        else if( timeInHours < 24 ){
            if( timeInHours <= 1 ){
                date = "1 hour ago";
            }
            else{
                date = timeInHours + " hours ago";
            }
        }
        else if( timeInDays < 30 ){
            if( timeInDays <= 1 ){
                date = "1 day ago";
            }
            else{
                date = timeInDays + " days ago";
            }
        }
        else if( timeInMonth < 12 ){
            if( timeInMonth <= 1 ){
                date = "1 month ago";
            }
            else{
                date = timeInMonth + " months ago";
            }
        }
        else{
            if( timeInYear <= 1 ){
            	date = "1 year ago";
            }
            else{
            	date = timeInYear + " years ago";
            }
        }
        return date;
    }
}
