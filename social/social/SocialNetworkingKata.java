package social;

import java.util.HashMap;
import java.util.Scanner;

class SocialNetworkingKata {
	public static void main(String[] args) {
        HashMap<String, Profile> profiles = new HashMap<>();

        System.out.println( "====== Timeline start =====" );
        Scanner scanner = new Scanner( System.in );
        boolean exit = false;
        do {
        
        	String command = scanner.nextLine();

	        if( command.contains( " follows " )){
	            String[] users = command.split( " follows ");
	            if( profiles.containsKey( users[ 0 ]) && profiles.containsKey( users[ 1 ])){
	                if( !profiles.get( users[ 0 ]).addFollow( profiles.get( users[ 1 ])) ) {
	                	System.out.println( users[ 0 ] + " already follow " + users[ 1 ] );
	                }
	            }
	            else {
	            	System.out.println( "unknown command" );
	            }
	        }
	        else if( command.contains( " wall" )){
	            String user = command.split( " wall" )[ 0 ];
	            if( profiles.containsKey( user )) {
	            	System.out.println( getWallString( profiles.get( user )));
	            }
	            else {
	            	System.out.println( "unknown user" );
	            }
	        }
	        else if( command.contains( " -> " )){
	            String[] input = command.split( " -> ");
	            if( !profiles.containsKey( input[ 0 ])){
	                profiles.put( input[ 0  ], new Profile( input[ 0 ]));
	            }
	            profiles.get( input[ 0 ]).postMessage( input[ 1 ]);
	        }
	        else if( command.equals( "exit" )) {
	        	exit = true;
	        }
	        else{
	        	String user = command;
	            if( profiles.containsKey( user )) {
	            	System.out.println( getTimelineString( profiles.get( user )));
	            }
	            else {
	            	System.out.println( "unknown user" );
	            }
	        }
        }while( !exit );
        scanner.close();
        System.out.println( "====== Timeline end ======" );
    }
	
	public static String getTimelineString( Profile profile ) {
		String timeline = "";
    	for( Post post : profile.getTimeline() ) {
    		timeline += post.toString() + "\n";
    	}
    	return timeline;
	}
	
	public static String getWallString( Profile profile ) {
		String wall = "";
    	for( Post post : profile.getWall()) {
    		wall += post.toPost() + "\n";
		}
    	return wall;
	}
}